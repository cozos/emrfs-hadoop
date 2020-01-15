package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.internal.RequestCopyUtils;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import java.util.ArrayList;
import java.util.List;

class SendQueueBuffer$SendMessageBatchTask
  extends SendQueueBuffer.OutboundBatchTask<SendMessageRequest, SendMessageResult>
{
  private SendQueueBuffer$SendMessageBatchTask(SendQueueBuffer paramSendQueueBuffer)
  {
    super(paramSendQueueBuffer);
  }
  
  int batchSizeBytes = 0;
  
  protected boolean isOkToAdd(SendMessageRequest request)
  {
    return (requests.size() < SendQueueBuffer.access$300(this$0).getMaxBatchSize()) && 
      (request.getMessageBody().getBytes().length + batchSizeBytes <= SendQueueBuffer.access$300(this$0).getMaxBatchSizeBytes());
  }
  
  protected void onRequestAdded(SendMessageRequest request)
  {
    batchSizeBytes += request.getMessageBody().getBytes().length;
  }
  
  protected boolean isFull()
  {
    return (requests.size() >= SendQueueBuffer.access$300(this$0).getMaxBatchSize()) || (batchSizeBytes >= SendQueueBuffer.access$300(this$0).getMaxBatchSizeBytes());
  }
  
  protected void process(List<SendMessageRequest> requests, List<QueueBufferFuture<SendMessageRequest, SendMessageResult>> futures)
  {
    if (requests.isEmpty()) {
      return;
    }
    SendMessageBatchRequest batchRequest = new SendMessageBatchRequest().withQueueUrl(SendQueueBuffer.access$400(this$0));
    ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
    
    List<SendMessageBatchRequestEntry> entries = new ArrayList(requests.size());
    int i = 0;
    for (int n = requests.size(); i < n; i++) {
      entries.add(RequestCopyUtils.createSendMessageBatchRequestEntryFrom(Integer.toString(i), 
        (SendMessageRequest)requests.get(i)));
    }
    batchRequest.setEntries(entries);
    
    SendMessageBatchResult batchResult = SendQueueBuffer.access$500(this$0).sendMessageBatch(batchRequest);
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
          ((QueueBufferFuture)futures.get(index)).setSuccess(SendQueueBuffer.access$500(this$0).sendMessage((SendMessageRequest)requests.get(index)));
        }
        catch (AmazonClientException ace)
        {
          ((QueueBufferFuture)futures.get(index)).setFailure(ace);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer.SendMessageBatchTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */