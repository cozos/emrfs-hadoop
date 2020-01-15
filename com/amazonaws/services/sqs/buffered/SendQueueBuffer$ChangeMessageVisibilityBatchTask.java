package com.amazonaws.services.sqs.buffered;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResultEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import java.util.ArrayList;
import java.util.List;

class SendQueueBuffer$ChangeMessageVisibilityBatchTask
  extends SendQueueBuffer.OutboundBatchTask<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult>
{
  private SendQueueBuffer$ChangeMessageVisibilityBatchTask(SendQueueBuffer paramSendQueueBuffer)
  {
    super(paramSendQueueBuffer);
  }
  
  protected void process(List<ChangeMessageVisibilityRequest> requests, List<QueueBufferFuture<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult>> futures)
  {
    if (requests.isEmpty()) {
      return;
    }
    ChangeMessageVisibilityBatchRequest batchRequest = new ChangeMessageVisibilityBatchRequest().withQueueUrl(SendQueueBuffer.access$400(this$0));
    ResultConverter.appendUserAgent(batchRequest, AmazonSQSBufferedAsyncClient.USER_AGENT);
    
    List<ChangeMessageVisibilityBatchRequestEntry> entries = new ArrayList(requests.size());
    int i = 0;
    for (int n = requests.size(); i < n; i++) {
      entries.add(new ChangeMessageVisibilityBatchRequestEntry().withId(Integer.toString(i))
        .withReceiptHandle(((ChangeMessageVisibilityRequest)requests.get(i)).getReceiptHandle())
        .withVisibilityTimeout(((ChangeMessageVisibilityRequest)requests.get(i)).getVisibilityTimeout()));
    }
    batchRequest.setEntries(entries);
    
    ChangeMessageVisibilityBatchResult batchResult = SendQueueBuffer.access$500(this$0).changeMessageVisibilityBatch(batchRequest);
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
          ((QueueBufferFuture)futures.get(index)).setSuccess(SendQueueBuffer.access$500(this$0).changeMessageVisibility((ChangeMessageVisibilityRequest)requests.get(index)));
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
 * Qualified Name:     com.amazonaws.services.sqs.buffered.SendQueueBuffer.ChangeMessageVisibilityBatchTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */