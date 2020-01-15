package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class QueueBuffer
{
  private static final Log log = LogFactory.getLog(QueueBuffer.class);
  private static final AsyncHandler<DeleteMessageRequest, DeleteMessageResult> DEFAULT_BACKGROUND_DELETE_ASYNC_HANDLER = new AsyncHandler()
  {
    public void onSuccess(DeleteMessageRequest request, DeleteMessageResult deleteMessageResult) {}
    
    public void onError(Exception exception)
    {
      QueueBuffer.log.warn("Failed to delete message in background (config.isDeleteInBackground() is true) - message will likely be redelivered", exception);
    }
  };
  private final SendQueueBuffer sendBuffer;
  private final ReceiveQueueBuffer receiveBuffer;
  private final AmazonSQSAsync realSqs;
  QueueBufferConfig config;
  private final AsyncHandler<DeleteMessageRequest, DeleteMessageResult> backgroundDeleteAsyncHandler;
  static ExecutorService executor = Executors.newCachedThreadPool(new DaemonThreadFactory(null));
  
  QueueBuffer(QueueBufferConfig paramConfig, String url, AmazonSQSAsync sqs)
  {
    this(paramConfig, url, sqs, DEFAULT_BACKGROUND_DELETE_ASYNC_HANDLER);
  }
  
  QueueBuffer(QueueBufferConfig paramConfig, String url, AmazonSQSAsync sqs, AsyncHandler<DeleteMessageRequest, DeleteMessageResult> backgroundDeleteAsyncHandler)
  {
    realSqs = sqs;
    config = paramConfig;
    sendBuffer = new SendQueueBuffer(sqs, executor, paramConfig, url);
    receiveBuffer = new ReceiveQueueBuffer(sqs, executor, paramConfig, url);
    this.backgroundDeleteAsyncHandler = backgroundDeleteAsyncHandler;
  }
  
  public Future<SendMessageResult> sendMessage(SendMessageRequest request, AsyncHandler<SendMessageRequest, SendMessageResult> handler)
  {
    QueueBufferCallback<SendMessageRequest, SendMessageResult> callback = null;
    if (handler != null) {
      callback = new QueueBufferCallback(handler, request);
    }
    QueueBufferFuture<SendMessageRequest, SendMessageResult> future = sendBuffer.sendMessage(request, callback);
    future.setBuffer(this);
    return future;
  }
  
  public SendMessageResult sendMessageSync(SendMessageRequest request)
  {
    Future<SendMessageResult> future = sendMessage(request, null);
    return (SendMessageResult)waitForFuture(future);
  }
  
  public Future<DeleteMessageResult> deleteMessage(DeleteMessageRequest request, AsyncHandler<DeleteMessageRequest, DeleteMessageResult> handler)
  {
    QueueBufferCallback<DeleteMessageRequest, DeleteMessageResult> callback = null;
    if (handler != null) {
      callback = new QueueBufferCallback(handler, request);
    }
    QueueBufferFuture<DeleteMessageRequest, DeleteMessageResult> future = sendBuffer.deleteMessage(request, callback);
    future.setBuffer(this);
    return future;
  }
  
  public DeleteMessageResult deleteMessageSync(DeleteMessageRequest request)
  {
    if (config.isDeleteInBackground())
    {
      deleteMessage(request, backgroundDeleteAsyncHandler);
      return new DeleteMessageResult();
    }
    Future<DeleteMessageResult> future = deleteMessage(request, null);
    return (DeleteMessageResult)waitForFuture(future);
  }
  
  public DeleteMessageBatchResult deleteMessageBatchSync(DeleteMessageBatchRequest request)
  {
    if (config.isDeleteInBackground())
    {
      String queueUrl = request.getQueueUrl();
      List<DeleteMessageBatchRequestEntry> requestEntries = request.getEntries();
      
      List<DeleteMessageBatchResultEntry> resultEntries = new ArrayList(requestEntries.size());
      for (DeleteMessageBatchRequestEntry entry : requestEntries)
      {
        deleteMessage(new DeleteMessageRequest().withQueueUrl(queueUrl)
          .withReceiptHandle(entry.getReceiptHandle()), backgroundDeleteAsyncHandler);
        
        resultEntries.add(new DeleteMessageBatchResultEntry().withId(entry.getId()));
      }
      return new DeleteMessageBatchResult().withSuccessful(resultEntries);
    }
    return realSqs.deleteMessageBatch(request);
  }
  
  public Future<ChangeMessageVisibilityResult> changeMessageVisibility(ChangeMessageVisibilityRequest request, AsyncHandler<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> handler)
  {
    QueueBufferCallback<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> callback = null;
    if (handler != null) {
      callback = new QueueBufferCallback(handler, request);
    }
    QueueBufferFuture<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> future = sendBuffer.changeMessageVisibility(request, callback);
    future.setBuffer(this);
    return future;
  }
  
  public ChangeMessageVisibilityResult changeMessageVisibilitySync(ChangeMessageVisibilityRequest request)
  {
    Future<ChangeMessageVisibilityResult> future = sendBuffer.changeMessageVisibility(request, null);
    return (ChangeMessageVisibilityResult)waitForFuture(future);
  }
  
  public Future<ReceiveMessageResult> receiveMessage(ReceiveMessageRequest rq, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> handler)
  {
    if (canBeRetrievedFromQueueBuffer(rq))
    {
      QueueBufferCallback<ReceiveMessageRequest, ReceiveMessageResult> callback = null;
      if (handler != null) {
        callback = new QueueBufferCallback(handler, rq);
      }
      QueueBufferFuture<ReceiveMessageRequest, ReceiveMessageResult> future = receiveBuffer.receiveMessageAsync(rq, callback);
      
      future.setBuffer(this);
      return future;
    }
    if (handler != null) {
      return realSqs.receiveMessageAsync(rq, handler);
    }
    return realSqs.receiveMessageAsync(rq);
  }
  
  public ReceiveMessageResult receiveMessageSync(ReceiveMessageRequest rq)
  {
    Future<ReceiveMessageResult> future = receiveMessage(rq, null);
    return (ReceiveMessageResult)waitForFuture(future);
  }
  
  public void shutdown()
  {
    if (config.isFlushOnShutdown()) {
      flush();
    }
    receiveBuffer.shutdown();
  }
  
  void flush()
  {
    sendBuffer.flush();
  }
  
  private boolean canBeRetrievedFromQueueBuffer(ReceiveMessageRequest rq)
  {
    return (requestedAttributesAreCompatible(rq)) && (requestedMessageAttributesAreCompatible(rq)) && (isBufferingEnabled()) && 
      (rq.getVisibilityTimeout() == null);
  }
  
  private boolean requestedAttributesAreCompatible(ReceiveMessageRequest rq)
  {
    return rq.getAttributeNames().equals(config.getReceiveAttributeNames());
  }
  
  private boolean requestedMessageAttributesAreCompatible(ReceiveMessageRequest rq)
  {
    return rq.getMessageAttributeNames().equals(config.getReceiveMessageAttributeNames());
  }
  
  private boolean isBufferingEnabled()
  {
    return (config.getMaxInflightReceiveBatches() > 0) && (config.getMaxDoneReceiveBatches() > 0);
  }
  
  private <ResultType> ResultType waitForFuture(Future<ResultType> future)
  {
    ResultType toReturn = null;
    try
    {
      toReturn = future.get();
    }
    catch (InterruptedException ie)
    {
      Thread.currentThread().interrupt();
      AmazonClientException ce = new AmazonClientException("Thread interrupted while waiting for execution result");
      
      ce.initCause(ie);
      throw ce;
    }
    catch (ExecutionException ee)
    {
      Throwable cause = ee.getCause();
      if ((cause instanceof AmazonClientException)) {
        throw ((AmazonClientException)cause);
      }
      AmazonClientException ce = new AmazonClientException("Caught an exception while waiting for request to complete...");
      
      ce.initCause(ee);
      throw ce;
    }
    return toReturn;
  }
  
  private static class DaemonThreadFactory
    implements ThreadFactory
  {
    static AtomicInteger threadCount = new AtomicInteger(0);
    
    public Thread newThread(Runnable r)
    {
      int threadNumber = threadCount.addAndGet(1);
      Thread thread = new Thread(r);
      thread.setDaemon(true);
      thread.setName("SQSQueueBufferWorkerThread-" + threadNumber);
      return thread;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */