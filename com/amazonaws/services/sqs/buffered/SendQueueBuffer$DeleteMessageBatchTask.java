package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResultEntry;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import java.util.ArrayList;
import java.util.List;

class SendQueueBuffer$DeleteMessageBatchTask
  extends SendQueueBuffer.OutboundBatchTask<DeleteMessageRequest, DeleteMessageResult>
{
  private SendQueueBuffer$DeleteMessageBatchTask(SendQueueBuffer paramSendQueueBuffer)
  {
    super(paramSendQueueBuffer);
  }
  
  protected void process(List<DeleteMessageRequest> requests, List<QueueBufferFuture<DeleteMessageRequest, DeleteMessageResult>> futures)
  {
    if (requests.isEmpty()) {
      return;
    }
    DeleteMessageBatchRequest batchRequest = new DeleteMessageBatchRequest().withQueueUrl(SendQueueBuffer.access$400(this$0));
    ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
    
    List<DeleteMessageBatchRequestEntry> entries = new ArrayList(requests.size());
    int i = 0;
    for (int n = requests.size(); i < n; i++) {
      entries.add(new DeleteMessageBatchRequestEntry().withId(Integer.toString(i)).withReceiptHandle(
        ((DeleteMessageRequest)requests.get(i)).getReceiptHandle()));
    }
    batchRequest.setEntries(entries);
    
    DeleteMessageBatchResult batchResult = SendQueueBuffer.access$500(this$0).deleteMessageBatch(batchRequest);
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
          ((QueueBufferFuture)futures.get(index)).setSuccess(SendQueueBuffer.access$500(this$0).deleteMessage((DeleteMessageRequest)requests.get(index)));
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
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer.DeleteMessageBatchTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */