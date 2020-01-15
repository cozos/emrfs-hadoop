package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.internal.RequestCopyUtils;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResultEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SendQueueBuffer
{
  private static Log log = LogFactory.getLog(SendQueueBuffer.class);
  private final QueueBufferConfig config;
  private final String qUrl;
  private final AmazonSQS sqsClient;
  private final Executor executor;
  private final Object sendMessageLock = new Object();
  private final Object deleteMessageLock = new Object();
  private final Object changeMessageVisibilityLock = new Object();
  private final SendMessageBatchTask[] openSendMessageBatchTask = new SendMessageBatchTask[1];
  private final DeleteMessageBatchTask[] openDeleteMessageBatchTask = new DeleteMessageBatchTask[1];
  private final ChangeMessageVisibilityBatchTask[] openChangeMessageVisibilityBatchTask = new ChangeMessageVisibilityBatchTask[1];
  private final Semaphore inflightSendMessageBatches;
  private final Semaphore inflightDeleteMessageBatches;
  private final Semaphore inflightChangeMessageVisibilityBatches;
  
  SendQueueBuffer(AmazonSQS sqsClient, Executor executor, QueueBufferConfig paramConfig, String url)
  {
    this.sqsClient = sqsClient;
    this.executor = executor;
    config = paramConfig;
    qUrl = url;
    int maxBatch = config.getMaxInflightOutboundBatches();
    
    maxBatch = maxBatch > 0 ? maxBatch : 1;
    inflightSendMessageBatches = new Semaphore(maxBatch);
    inflightDeleteMessageBatches = new Semaphore(maxBatch);
    inflightChangeMessageVisibilityBatches = new Semaphore(maxBatch);
  }
  
  public QueueBufferConfig getConfig()
  {
    return config;
  }
  
  public QueueBufferFuture<SendMessageRequest, SendMessageResult> sendMessage(SendMessageRequest request, QueueBufferCallback<SendMessageRequest, SendMessageResult> callback)
  {
    QueueBufferFuture<SendMessageRequest, SendMessageResult> result = submitOutboundRequest(sendMessageLock, openSendMessageBatchTask, request, inflightSendMessageBatches, callback);
    
    return result;
  }
  
  public QueueBufferFuture<DeleteMessageRequest, DeleteMessageResult> deleteMessage(DeleteMessageRequest request, QueueBufferCallback<DeleteMessageRequest, DeleteMessageResult> callback)
  {
    return submitOutboundRequest(deleteMessageLock, openDeleteMessageBatchTask, request, inflightDeleteMessageBatches, callback);
  }
  
  public QueueBufferFuture<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> changeMessageVisibility(ChangeMessageVisibilityRequest request, QueueBufferCallback<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> callback)
  {
    return submitOutboundRequest(changeMessageVisibilityLock, openChangeMessageVisibilityBatchTask, request, inflightChangeMessageVisibilityBatches, callback);
  }
  
  private <R extends AmazonWebServiceRequest, Result> OutboundBatchTask<R, Result> newOutboundBatchTask(R request)
  {
    if ((request instanceof SendMessageRequest)) {
      return new SendMessageBatchTask(null);
    }
    if ((request instanceof DeleteMessageRequest)) {
      return new DeleteMessageBatchTask(null);
    }
    if ((request instanceof ChangeMessageVisibilityRequest)) {
      return new ChangeMessageVisibilityBatchTask(null);
    }
    throw new IllegalArgumentException("Unsupported request type " + request.getClass().getName());
  }
  
  public void flush()
  {
    try
    {
      synchronized (sendMessageLock)
      {
        inflightSendMessageBatches.acquire(config.getMaxInflightOutboundBatches());
        inflightSendMessageBatches.release(config.getMaxInflightOutboundBatches());
      }
      synchronized (deleteMessageLock)
      {
        inflightDeleteMessageBatches.acquire(config.getMaxInflightOutboundBatches());
        inflightDeleteMessageBatches.release(config.getMaxInflightOutboundBatches());
      }
      synchronized (changeMessageVisibilityLock)
      {
        inflightChangeMessageVisibilityBatches.acquire(config.getMaxInflightOutboundBatches());
        inflightChangeMessageVisibilityBatches.release(config.getMaxInflightOutboundBatches());
      }
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
    }
  }
  
  <OBT extends OutboundBatchTask<R, Result>, R extends AmazonWebServiceRequest, Result> QueueBufferFuture<R, Result> submitOutboundRequest(Object operationLock, OBT[] openOutboundBatchTask, R request, final Semaphore inflightOperationBatches, QueueBufferCallback<R, Result> callback)
  {
    QueueBufferFuture<R, Result> theFuture = null;
    try
    {
      synchronized (operationLock)
      {
        if ((openOutboundBatchTask[0] == null) || 
          ((theFuture = openOutboundBatchTask[0].addRequest(request, callback)) == null))
        {
          OBT obt = newOutboundBatchTask(request);
          inflightOperationBatches.acquire();
          openOutboundBatchTask[0] = obt;
          
          openOutboundBatchTask[0].setOnCompleted(new Listener()
          {
            public void invoke(SendQueueBuffer.OutboundBatchTask<R, Result> task)
            {
              inflightOperationBatches.release();
            }
          });
          if (log.isTraceEnabled()) {
            log.trace("Queue " + qUrl + " created new batch for " + request.getClass().toString() + " " + inflightOperationBatches
              .availablePermits() + " free slots remain");
          }
          theFuture = openOutboundBatchTask[0].addRequest(request, callback);
          executor.execute(openOutboundBatchTask[0]);
          if (null == theFuture) {
            throw new AmazonClientException("Failed to schedule request " + request + " for execution");
          }
        }
      }
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
      AmazonClientException toThrow = new AmazonClientException("Interrupted while waiting for lock.");
      toThrow.initCause(e);
      throw toThrow;
    }
    return theFuture;
  }
  
  private static abstract interface Listener<T>
  {
    public abstract void invoke(T paramT);
  }
  
  private abstract class OutboundBatchTask<R extends AmazonWebServiceRequest, Result>
    implements Runnable
  {
    protected final List<R> requests;
    protected final ArrayList<QueueBufferFuture<R, Result>> futures;
    private boolean closed;
    private volatile SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> onCompleted;
    
    public OutboundBatchTask()
    {
      requests = new ArrayList(config.getMaxBatchSize());
      futures = new ArrayList(config.getMaxBatchSize());
    }
    
    public void setOnCompleted(SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> value)
    {
      onCompleted = value;
    }
    
    public synchronized QueueBufferFuture<R, Result> addRequest(R request, QueueBufferCallback<R, Result> callback)
    {
      if (closed) {
        return null;
      }
      QueueBufferFuture<R, Result> theFuture = addIfAllowed(request, callback);
      if ((null == theFuture) || (isFull()))
      {
        closed = true;
        notify();
      }
      return theFuture;
    }
    
    private QueueBufferFuture<R, Result> addIfAllowed(R request, QueueBufferCallback<R, Result> callback)
    {
      if (isOkToAdd(request))
      {
        requests.add(request);
        
        QueueBufferFuture<R, Result> theFuture = new QueueBufferFuture(callback);
        
        futures.add(theFuture);
        onRequestAdded(request);
        return theFuture;
      }
      return null;
    }
    
    protected boolean isOkToAdd(R request)
    {
      return requests.size() < config.getMaxBatchSize();
    }
    
    protected void onRequestAdded(R request) {}
    
    protected boolean isFull()
    {
      return requests.size() >= config.getMaxBatchSize();
    }
    
    protected abstract void process(List<R> paramList, List<QueueBufferFuture<R, Result>> paramList1);
    
    public final void run()
    {
      try
      {
        long deadlineMs = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS) + config.getMaxBatchOpenMs() + 1L;
        long t = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
        List<QueueBufferFuture<R, Result>> futures;
        synchronized (this)
        {
          while ((!closed) && (t < deadlineMs))
          {
            t = TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
            
            long toWait = Math.max(1L, deadlineMs - t);
            wait(toWait);
          }
          closed = true;
          
          List<R> requests = new ArrayList(this.requests);
          futures = new ArrayList(this.futures);
        }
        List<QueueBufferFuture<R, Result>> futures;
        List<R> requests;
        process(requests, futures);
      }
      catch (InterruptedException e)
      {
        SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener;
        failAll(e);
      }
      catch (AmazonClientException e)
      {
        SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener;
        failAll(e);
      }
      catch (RuntimeException e)
      {
        SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener;
        failAll(e);
        throw e;
      }
      catch (Error e)
      {
        failAll(new AmazonClientException("Error encountered", e));
        throw e;
      }
      finally
      {
        SendQueueBuffer.Listener<OutboundBatchTask<R, Result>> listener = onCompleted;
        if (listener != null) {
          listener.invoke(this);
        }
      }
    }
    
    private void failAll(Exception e)
    {
      for (QueueBufferFuture<R, Result> f : futures) {
        f.setFailure(e);
      }
    }
  }
  
  private class SendMessageBatchTask
    extends SendQueueBuffer.OutboundBatchTask<SendMessageRequest, SendMessageResult>
  {
    private SendMessageBatchTask()
    {
      super();
    }
    
    int batchSizeBytes = 0;
    
    protected boolean isOkToAdd(SendMessageRequest request)
    {
      return (requests.size() < config.getMaxBatchSize()) && 
        (request.getMessageBody().getBytes().length + batchSizeBytes <= config.getMaxBatchSizeBytes());
    }
    
    protected void onRequestAdded(SendMessageRequest request)
    {
      batchSizeBytes += request.getMessageBody().getBytes().length;
    }
    
    protected boolean isFull()
    {
      return (requests.size() >= config.getMaxBatchSize()) || (batchSizeBytes >= config.getMaxBatchSizeBytes());
    }
    
    protected void process(List<SendMessageRequest> requests, List<QueueBufferFuture<SendMessageRequest, SendMessageResult>> futures)
    {
      if (requests.isEmpty()) {
        return;
      }
      SendMessageBatchRequest batchRequest = new SendMessageBatchRequest().withQueueUrl(qUrl);
      ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
      
      List<SendMessageBatchRequestEntry> entries = new ArrayList(requests.size());
      int i = 0;
      for (int n = requests.size(); i < n; i++) {
        entries.add(RequestCopyUtils.createSendMessageBatchRequestEntryFrom(Integer.toString(i), 
          (SendMessageRequest)requests.get(i)));
      }
      batchRequest.setEntries(entries);
      
      SendMessageBatchResult batchResult = sqsClient.sendMessageBatch(batchRequest);
      for (SendMessageBatchResultEntry entry : batchResult.getSuccessful())
      {
        int index = Integer.parseInt(entry.getId());
        ((QueueBufferFuture)futures.get(index)).setSuccess(ResultConverter.convert(entry));
      }
      for (BatchResultErrorEntry errorEntry : batchResult.getFailed())
      {
        int index = Integer.parseInt(errorEntry.getId());
        if (errorEntry.isSenderFault().booleanValue()) {
          ((QueueBufferFuture)futures.get(index)).setFailure(ResultConverter.convert(errorEntry));
        } else {
          try
          {
            ((QueueBufferFuture)futures.get(index)).setSuccess(sqsClient.sendMessage((SendMessageRequest)requests.get(index)));
          }
          catch (AmazonClientException ace)
          {
            ((QueueBufferFuture)futures.get(index)).setFailure(ace);
          }
        }
      }
    }
  }
  
  private class DeleteMessageBatchTask
    extends SendQueueBuffer.OutboundBatchTask<DeleteMessageRequest, DeleteMessageResult>
  {
    private DeleteMessageBatchTask()
    {
      super();
    }
    
    protected void process(List<DeleteMessageRequest> requests, List<QueueBufferFuture<DeleteMessageRequest, DeleteMessageResult>> futures)
    {
      if (requests.isEmpty()) {
        return;
      }
      DeleteMessageBatchRequest batchRequest = new DeleteMessageBatchRequest().withQueueUrl(qUrl);
      ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
      
      List<DeleteMessageBatchRequestEntry> entries = new ArrayList(requests.size());
      int i = 0;
      for (int n = requests.size(); i < n; i++) {
        entries.add(new DeleteMessageBatchRequestEntry().withId(Integer.toString(i)).withReceiptHandle(
          ((DeleteMessageRequest)requests.get(i)).getReceiptHandle()));
      }
      batchRequest.setEntries(entries);
      
      DeleteMessageBatchResult batchResult = sqsClient.deleteMessageBatch(batchRequest);
      for (DeleteMessageBatchResultEntry entry : batchResult.getSuccessful())
      {
        int index = Integer.parseInt(entry.getId());
        ((QueueBufferFuture)futures.get(index)).setSuccess(new DeleteMessageResult());
      }
      for (BatchResultErrorEntry errorEntry : batchResult.getFailed())
      {
        int index = Integer.parseInt(errorEntry.getId());
        if (errorEntry.isSenderFault().booleanValue()) {
          ((QueueBufferFuture)futures.get(index)).setFailure(ResultConverter.convert(errorEntry));
        } else {
          try
          {
            ((QueueBufferFuture)futures.get(index)).setSuccess(sqsClient.deleteMessage((DeleteMessageRequest)requests.get(index)));
          }
          catch (AmazonClientException ace)
          {
            ((QueueBufferFuture)futures.get(index)).setFailure(ace);
          }
        }
      }
    }
  }
  
  private class ChangeMessageVisibilityBatchTask
    extends SendQueueBuffer.OutboundBatchTask<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult>
  {
    private ChangeMessageVisibilityBatchTask()
    {
      super();
    }
    
    protected void process(List<ChangeMessageVisibilityRequest> requests, List<QueueBufferFuture<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult>> futures)
    {
      if (requests.isEmpty()) {
        return;
      }
      ChangeMessageVisibilityBatchRequest batchRequest = new ChangeMessageVisibilityBatchRequest().withQueueUrl(qUrl);
      ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
      
      List<ChangeMessageVisibilityBatchRequestEntry> entries = new ArrayList(requests.size());
      int i = 0;
      for (int n = requests.size(); i < n; i++) {
        entries.add(new ChangeMessageVisibilityBatchRequestEntry().withId(Integer.toString(i))
          .withReceiptHandle(((ChangeMessageVisibilityRequest)requests.get(i)).getReceiptHandle())
          .withVisibilityTimeout(((ChangeMessageVisibilityRequest)requests.get(i)).getVisibilityTimeout()));
      }
      batchRequest.setEntries(entries);
      
      ChangeMessageVisibilityBatchResult batchResult = sqsClient.changeMessageVisibilityBatch(batchRequest);
      for (ChangeMessageVisibilityBatchResultEntry entry : batchResult.getSuccessful())
      {
        int index = Integer.parseInt(entry.getId());
        ((QueueBufferFuture)futures.get(index)).setSuccess(new ChangeMessageVisibilityResult());
      }
      for (BatchResultErrorEntry errorEntry : batchResult.getFailed())
      {
        int index = Integer.parseInt(errorEntry.getId());
        if (errorEntry.isSenderFault().booleanValue()) {
          ((QueueBufferFuture)futures.get(index)).setFailure(ResultConverter.convert(errorEntry));
        } else {
          try
          {
            ((QueueBufferFuture)futures.get(index)).setSuccess(sqsClient.changeMessageVisibility((ChangeMessageVisibilityRequest)requests.get(index)));
          }
          catch (AmazonClientException ace)
          {
            ((QueueBufferFuture)futures.get(index)).setFailure(ace);
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */