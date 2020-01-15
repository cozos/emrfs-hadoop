package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.QueueAttributeName;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReceiveQueueBuffer
{
  private static Log log = LogFactory.getLog(ReceiveQueueBuffer.class);
  private final QueueBufferConfig config;
  private final String qUrl;
  private final Executor executor;
  private final ScheduledExecutorService waitTimer = Executors.newSingleThreadScheduledExecutor();
  private final AmazonSQS sqsClient;
  private long bufferCounter = 0L;
  private volatile long visibilityTimeoutNanos = -1L;
  private volatile int defaultWaitTimeSeconds = -1;
  private volatile int inflightReceiveMessageBatches;
  private final Object taskSpawnSyncPoint = new Object();
  volatile boolean shutDown = false;
  private final Set<ReceiveMessageFuture> futures = new LinkedHashSet();
  private LinkedList<ReceiveMessageBatchTask> finishedTasks = new LinkedList();
  
  ReceiveQueueBuffer(AmazonSQS paramSQS, Executor paramExecutor, QueueBufferConfig paramConfig, String url)
  {
    config = paramConfig;
    executor = paramExecutor;
    sqsClient = paramSQS;
    qUrl = url;
  }
  
  public void shutdown()
  {
    shutDown = true;
    try
    {
      while (inflightReceiveMessageBatches > 0) {
        Thread.sleep(100L);
      }
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
    waitTimer.shutdown();
    try
    {
      waitTimer.awaitTermination(20L, TimeUnit.SECONDS);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
  }
  
  public QueueBufferFuture<ReceiveMessageRequest, ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest rq, QueueBufferCallback<ReceiveMessageRequest, ReceiveMessageResult> callback)
  {
    if (shutDown) {
      throw new AmazonClientException("The client has been shut down.");
    }
    int numMessages = 10;
    if (rq.getMaxNumberOfMessages() != null) {
      numMessages = rq.getMaxNumberOfMessages().intValue();
    }
    synchronized (futures)
    {
      if (defaultWaitTimeSeconds == -1)
      {
        GetQueueAttributesRequest request = new GetQueueAttributesRequest().withQueueUrl(qUrl).withAttributeNames(new QueueAttributeName[] { QueueAttributeName.ReceiveMessageWaitTimeSeconds });
        ResultConverter.appendUserAgent(request, AmazonSQSBufferedAsyncClient.USER_AGENT);
        defaultWaitTimeSeconds = Integer.parseInt(
          (String)sqsClient.getQueueAttributes(request).getAttributes().get(QueueAttributeName.ReceiveMessageWaitTimeSeconds.toString()));
      }
    }
    int waitTimeSeconds = defaultWaitTimeSeconds;
    if (rq.getWaitTimeSeconds() != null) {
      waitTimeSeconds = rq.getWaitTimeSeconds().intValue();
    }
    long waitTimeMs = Math.max(config.getMinReceiveWaitTimeMs(), TimeUnit.MILLISECONDS
      .convert(waitTimeSeconds, TimeUnit.SECONDS));
    ReceiveMessageFuture toReturn = issueFuture(numMessages, waitTimeMs, callback);
    
    satisfyFuturesFromBuffer();
    
    spawnMoreReceiveTasks();
    
    toReturn.startWaitTimer();
    
    return toReturn;
  }
  
  private ReceiveMessageFuture issueFuture(int size, long waitTimeMs, QueueBufferCallback<ReceiveMessageRequest, ReceiveMessageResult> callback)
  {
    synchronized (futures)
    {
      ReceiveMessageFuture theFuture = new ReceiveMessageFuture(callback, size, waitTimeMs);
      futures.add(theFuture);
      return theFuture;
    }
  }
  
  private void satisfyFuturesFromBuffer()
  {
    synchronized (futures)
    {
      synchronized (finishedTasks)
      {
        Iterator<ReceiveMessageFuture> futureIter = futures.iterator();
        while ((futureIter.hasNext()) && (!finishedTasks.isEmpty()))
        {
          pruneExpiredTasks();
          if (!finishedTasks.isEmpty())
          {
            fufillFuture((ReceiveMessageFuture)futureIter.next());
            futureIter.remove();
          }
        }
      }
    }
  }
  
  private void fufillFuture(ReceiveMessageFuture future)
  {
    ReceiveMessageBatchTask task = (ReceiveMessageBatchTask)finishedTasks.getFirst();
    ReceiveMessageResult result = new ReceiveMessageResult();
    LinkedList<Message> messages = new LinkedList();
    result.setMessages(messages);
    Exception exception = task.getException();
    int numRetrieved = 0;
    boolean batchDone = false;
    while (numRetrieved < future.getRequestedSize())
    {
      Message msg = task.removeMessage();
      if (msg != null)
      {
        messages.add(msg);
        numRetrieved++;
      }
      else
      {
        batchDone = true;
        break;
      }
    }
    batchDone = (batchDone) || (task.isEmpty()) || (exception != null);
    if (batchDone) {
      finishedTasks.removeFirst();
    }
    result.setMessages(messages);
    if (exception != null) {
      future.setFailure(exception);
    } else {
      future.setSuccess(result);
    }
  }
  
  private void pruneExpiredTasks()
  {
    int numberExpiredTasksPruned = pruneHeadTasks(new Predicate()
    {
      public boolean test(ReceiveQueueBuffer.ReceiveMessageBatchTask t)
      {
        return (t.isExpired()) && (t.getException() == null);
      }
    });
    if (numberExpiredTasksPruned > 0) {
      pruneHeadTasks(new Predicate()
      {
        public boolean test(ReceiveQueueBuffer.ReceiveMessageBatchTask t)
        {
          return (t.isEmpty()) && (t.getException() == null);
        }
      });
    }
  }
  
  private int pruneHeadTasks(Predicate<ReceiveMessageBatchTask> pruneCondition)
  {
    int numberPruned = 0;
    while ((!finishedTasks.isEmpty()) && 
      (pruneCondition.test(finishedTasks.getFirst())))
    {
      finishedTasks.removeFirst();
      numberPruned++;
    }
    return numberPruned;
  }
  
  private void spawnMoreReceiveTasks()
  {
    if (shutDown) {
      return;
    }
    int desiredBatches = config.getMaxDoneReceiveBatches();
    desiredBatches = desiredBatches < 1 ? 1 : desiredBatches;
    if (config.isAdapativePrefetching()) {
      synchronized (futures)
      {
        int totalRequested = 0;
        for (Iterator<ReceiveMessageFuture> futuresIter = futures.iterator(); futuresIter.hasNext();)
        {
          ReceiveMessageFuture future = (ReceiveMessageFuture)futuresIter.next();
          totalRequested += future.getRequestedSize();
        }
        int batchesNeededToFulfillFutures = (int)Math.ceil(totalRequested / config.getMaxBatchSize());
        desiredBatches = Math.min(batchesNeededToFulfillFutures, desiredBatches);
      }
    }
    synchronized (finishedTasks)
    {
      if (finishedTasks.size() >= desiredBatches) {
        return;
      }
      if ((finishedTasks.size() > 0) && (finishedTasks.size() + inflightReceiveMessageBatches >= desiredBatches)) {
        return;
      }
    }
    synchronized (taskSpawnSyncPoint)
    {
      if (visibilityTimeoutNanos == -1L)
      {
        GetQueueAttributesRequest request = new GetQueueAttributesRequest().withQueueUrl(qUrl).withAttributeNames(new String[] { "VisibilityTimeout" });
        ResultConverter.appendUserAgent(request, AmazonSQSBufferedAsyncClient.USER_AGENT);
        long visibilityTimeoutSeconds = Long.parseLong(
          (String)sqsClient.getQueueAttributes(request).getAttributes().get("VisibilityTimeout"));
        visibilityTimeoutNanos = TimeUnit.NANOSECONDS.convert(visibilityTimeoutSeconds, TimeUnit.SECONDS);
      }
      int max = config.getMaxInflightReceiveBatches();
      
      max = max > 0 ? max : 1;
      int toSpawn = max - inflightReceiveMessageBatches;
      if (toSpawn > 0)
      {
        ReceiveMessageBatchTask task = new ReceiveMessageBatchTask(this);
        inflightReceiveMessageBatches += 1;
        bufferCounter += 1L;
        if (log.isTraceEnabled()) {
          log.trace("Spawned receive batch #" + bufferCounter + " (" + inflightReceiveMessageBatches + " of " + max + " inflight) for queue " + qUrl);
        }
        executor.execute(task);
      }
    }
  }
  
  void reportBatchFinished(ReceiveMessageBatchTask batch)
  {
    synchronized (finishedTasks)
    {
      finishedTasks.addLast(batch);
      if (log.isTraceEnabled()) {
        log.trace("Queue " + qUrl + " now has " + finishedTasks.size() + " receive results cached ");
      }
    }
    synchronized (taskSpawnSyncPoint)
    {
      inflightReceiveMessageBatches -= 1;
    }
    satisfyFuturesFromBuffer();
    spawnMoreReceiveTasks();
  }
  
  public void clear()
  {
    boolean done = false;
    while (!done)
    {
      ReceiveMessageBatchTask currentBatch = null;
      synchronized (finishedTasks)
      {
        currentBatch = (ReceiveMessageBatchTask)finishedTasks.poll();
      }
      if (currentBatch != null) {
        currentBatch.clear();
      } else {
        done = true;
      }
    }
  }
  
  private static abstract interface Predicate<T>
  {
    public abstract boolean test(T paramT);
  }
  
  private class ReceiveMessageFuture
    extends QueueBufferFuture<ReceiveMessageRequest, ReceiveMessageResult>
  {
    private int requestedSize;
    private final long waitTimeDeadlineNano;
    private volatile Future<?> timeoutFuture;
    
    ReceiveMessageFuture(int cb, long paramSize)
    {
      super();
      requestedSize = paramSize;
      waitTimeDeadlineNano = (System.nanoTime() + TimeUnit.NANOSECONDS.convert(waitTimeMs, TimeUnit.MILLISECONDS));
    }
    
    public void startWaitTimer()
    {
      if ((isDone()) || (timeoutFuture != null)) {
        return;
      }
      long remaining = waitTimeDeadlineNano - System.nanoTime();
      if (remaining <= 0L)
      {
        timeout();
      }
      else
      {
        Runnable timeoutRunnable = new Runnable()
        {
          public void run()
          {
            timeout();
          }
        };
        timeoutFuture = waitTimer.schedule(timeoutRunnable, remaining, TimeUnit.NANOSECONDS);
      }
    }
    
    public boolean isExpired()
    {
      return System.nanoTime() > waitTimeDeadlineNano;
    }
    
    public synchronized void setSuccess(ReceiveMessageResult result)
    {
      cancelTimeout();
      super.setSuccess(result);
    }
    
    public synchronized void setFailure(Exception exception)
    {
      cancelTimeout();
      super.setFailure(exception);
    }
    
    public void timeout()
    {
      synchronized (futures)
      {
        synchronized (this)
        {
          if (!isDone())
          {
            setSuccess(new ReceiveMessageResult());
            futures.remove(this);
          }
        }
      }
    }
    
    public int getRequestedSize()
    {
      return requestedSize;
    }
    
    private synchronized void cancelTimeout()
    {
      if (timeoutFuture != null) {
        timeoutFuture.cancel(false);
      }
    }
  }
  
  private class ReceiveMessageBatchTask
    implements Runnable
  {
    private Exception exception = null;
    private List<Message> messages;
    private long visibilityDeadlineNano;
    private boolean open = false;
    private ReceiveQueueBuffer parentBuffer;
    
    ReceiveMessageBatchTask(ReceiveQueueBuffer paramParentBuffer)
    {
      parentBuffer = paramParentBuffer;
      messages = Collections.emptyList();
    }
    
    synchronized boolean isEmpty()
    {
      if (!open) {
        throw new IllegalStateException("batch is not open");
      }
      return messages.isEmpty();
    }
    
    synchronized Exception getException()
    {
      if (!open) {
        throw new IllegalStateException("batch is not open");
      }
      return exception;
    }
    
    synchronized Message removeMessage()
    {
      if (!open) {
        throw new IllegalStateException("batch is not open");
      }
      if (isExpired())
      {
        messages.clear();
        return null;
      }
      if (messages.isEmpty()) {
        return null;
      }
      return (Message)messages.remove(messages.size() - 1);
    }
    
    boolean isExpired()
    {
      return System.nanoTime() > visibilityDeadlineNano;
    }
    
    synchronized void clear()
    {
      if (!open) {
        throw new IllegalStateException("batch is not open");
      }
      if (!isExpired())
      {
        ChangeMessageVisibilityBatchRequest batchRequest = new ChangeMessageVisibilityBatchRequest().withQueueUrl(qUrl);
        ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
        
        List<ChangeMessageVisibilityBatchRequestEntry> entries = new ArrayList(messages.size());
        
        int i = 0;
        for (Message m : messages)
        {
          entries.add(new ChangeMessageVisibilityBatchRequestEntry().withId(Integer.toString(i))
            .withReceiptHandle(m.getReceiptHandle()).withVisibilityTimeout(Integer.valueOf(0)));
          i++;
        }
        try
        {
          batchRequest.setEntries(entries);
          sqsClient.changeMessageVisibilityBatch(batchRequest);
        }
        catch (AmazonClientException e)
        {
          ReceiveQueueBuffer.log.warn("ReceiveMessageBatchTask: changeMessageVisibility failed " + e);
        }
      }
      messages.clear();
    }
    
    public void run()
    {
      try
      {
        visibilityDeadlineNano = (System.nanoTime() + visibilityTimeoutNanos);
        
        ReceiveMessageRequest request = new ReceiveMessageRequest(qUrl).withMaxNumberOfMessages(Integer.valueOf(config.getMaxBatchSize())).withMessageAttributeNames(config.getReceiveMessageAttributeNames()).withAttributeNames(config.getReceiveAttributeNames());
        ResultConverter.appendUserAgent(request, AmazonSQSBufferedAsyncClient.USER_AGENT);
        if (config.getVisibilityTimeoutSeconds() > 0)
        {
          request.setVisibilityTimeout(Integer.valueOf(config.getVisibilityTimeoutSeconds()));
          
          visibilityDeadlineNano = (System.nanoTime() + TimeUnit.NANOSECONDS.convert(config.getVisibilityTimeoutSeconds(), TimeUnit.SECONDS));
        }
        if (config.isLongPoll()) {
          request.withWaitTimeSeconds(Integer.valueOf(config.getLongPollWaitTimeoutSeconds()));
        }
        messages = sqsClient.receiveMessage(request).getMessages();
      }
      catch (AmazonClientException e)
      {
        exception = e;
      }
      finally
      {
        open = true;
        parentBuffer.reportBatchFinished(this);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */