package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

class ReceiveQueueBuffer$ReceiveMessageBatchTask
  implements Runnable
{
  private Exception exception = null;
  private List<Message> messages;
  private long visibilityDeadlineNano;
  private boolean open = false;
  private ReceiveQueueBuffer parentBuffer;
  
  ReceiveQueueBuffer$ReceiveMessageBatchTask(ReceiveQueueBuffer paramReceiveQueueBuffer1, ReceiveQueueBuffer paramParentBuffer)
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
      ChangeMessageVisibilityBatchRequest batchRequest = new ChangeMessageVisibilityBatchRequest().withQueueUrl(ReceiveQueueBuffer.access$200(this$0));
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
        ReceiveQueueBuffer.access$300(this$0).changeMessageVisibilityBatch(batchRequest);
      }
      catch (AmazonClientException e)
      {
        ReceiveQueueBuffer.access$400().warn("ReceiveMessageBatchTask: changeMessageVisibility failed " + e);
      }
    }
    messages.clear();
  }
  
  public void run()
  {
    try
    {
      visibilityDeadlineNano = (System.nanoTime() + ReceiveQueueBuffer.access$500(this$0));
      
      ReceiveMessageRequest request = new ReceiveMessageRequest(ReceiveQueueBuffer.access$200(this$0)).withMaxNumberOfMessages(Integer.valueOf(ReceiveQueueBuffer.access$600(this$0).getMaxBatchSize())).withMessageAttributeNames(ReceiveQueueBuffer.access$600(this$0).getReceiveMessageAttributeNames()).withAttributeNames(ReceiveQueueBuffer.access$600(this$0).getReceiveAttributeNames());
      ResultConverter.appendUserAgent(request, AmazonSQSBufferedAsyncClient.USER_AGENT);
      if (ReceiveQueueBuffer.access$600(this$0).getVisibilityTimeoutSeconds() > 0)
      {
        request.setVisibilityTimeout(Integer.valueOf(ReceiveQueueBuffer.access$600(this$0).getVisibilityTimeoutSeconds()));
        
        visibilityDeadlineNano = (System.nanoTime() + TimeUnit.NANOSECONDS.convert(ReceiveQueueBuffer.access$600(this$0).getVisibilityTimeoutSeconds(), TimeUnit.SECONDS));
      }
      if (ReceiveQueueBuffer.access$600(this$0).isLongPoll()) {
        request.withWaitTimeSeconds(Integer.valueOf(ReceiveQueueBuffer.access$600(this$0).getLongPollWaitTimeoutSeconds()));
      }
      messages = ReceiveQueueBuffer.access$300(this$0).receiveMessage(request).getMessages();
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

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.ReceiveQueueBuffer.ReceiveMessageBatchTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */