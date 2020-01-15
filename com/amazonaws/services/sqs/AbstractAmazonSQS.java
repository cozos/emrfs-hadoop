package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazonaws.services.sqs.model.AddPermissionRequest;
import com.amazonaws.services.sqs.model.AddPermissionResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityResult;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequest;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import com.amazonaws.services.sqs.model.DeleteQueueRequest;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesRequest;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import com.amazonaws.services.sqs.model.ListQueueTagsRequest;
import com.amazonaws.services.sqs.model.ListQueueTagsResult;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.PurgeQueueRequest;
import com.amazonaws.services.sqs.model.PurgeQueueResult;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.RemovePermissionRequest;
import com.amazonaws.services.sqs.model.RemovePermissionResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.SetQueueAttributesResult;
import com.amazonaws.services.sqs.model.TagQueueRequest;
import com.amazonaws.services.sqs.model.TagQueueResult;
import com.amazonaws.services.sqs.model.UntagQueueRequest;
import com.amazonaws.services.sqs.model.UntagQueueResult;
import java.util.List;
import java.util.Map;

public class AbstractAmazonSQS
  implements AmazonSQS
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddPermissionResult addPermission(AddPermissionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddPermissionResult addPermission(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions)
  {
    return addPermission(new AddPermissionRequest().withQueueUrl(queueUrl).withLabel(label).withAWSAccountIds(aWSAccountIds).withActions(actions));
  }
  
  public ChangeMessageVisibilityResult changeMessageVisibility(ChangeMessageVisibilityRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ChangeMessageVisibilityResult changeMessageVisibility(String queueUrl, String receiptHandle, Integer visibilityTimeout)
  {
    return changeMessageVisibility(new ChangeMessageVisibilityRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle)
      .withVisibilityTimeout(visibilityTimeout));
  }
  
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries)
  {
    return changeMessageVisibilityBatch(new ChangeMessageVisibilityBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public CreateQueueResult createQueue(CreateQueueRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateQueueResult createQueue(String queueName)
  {
    return createQueue(new CreateQueueRequest().withQueueName(queueName));
  }
  
  public DeleteMessageResult deleteMessage(DeleteMessageRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteMessageResult deleteMessage(String queueUrl, String receiptHandle)
  {
    return deleteMessage(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle));
  }
  
  public DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteMessageBatchResult deleteMessageBatch(String queueUrl, List<DeleteMessageBatchRequestEntry> entries)
  {
    return deleteMessageBatch(new DeleteMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public DeleteQueueResult deleteQueue(DeleteQueueRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteQueueResult deleteQueue(String queueUrl)
  {
    return deleteQueue(new DeleteQueueRequest().withQueueUrl(queueUrl));
  }
  
  public GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetQueueAttributesResult getQueueAttributes(String queueUrl, List<String> attributeNames)
  {
    return getQueueAttributes(new GetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributeNames(attributeNames));
  }
  
  public GetQueueUrlResult getQueueUrl(GetQueueUrlRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetQueueUrlResult getQueueUrl(String queueName)
  {
    return getQueueUrl(new GetQueueUrlRequest().withQueueName(queueName));
  }
  
  public ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListQueueTagsResult listQueueTags(ListQueueTagsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListQueueTagsResult listQueueTags(String queueUrl)
  {
    return listQueueTags(new ListQueueTagsRequest().withQueueUrl(queueUrl));
  }
  
  public ListQueuesResult listQueues(ListQueuesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListQueuesResult listQueues()
  {
    return listQueues(new ListQueuesRequest());
  }
  
  public ListQueuesResult listQueues(String queueNamePrefix)
  {
    return listQueues(new ListQueuesRequest().withQueueNamePrefix(queueNamePrefix));
  }
  
  public PurgeQueueResult purgeQueue(PurgeQueueRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ReceiveMessageResult receiveMessage(ReceiveMessageRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ReceiveMessageResult receiveMessage(String queueUrl)
  {
    return receiveMessage(new ReceiveMessageRequest().withQueueUrl(queueUrl));
  }
  
  public RemovePermissionResult removePermission(RemovePermissionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RemovePermissionResult removePermission(String queueUrl, String label)
  {
    return removePermission(new RemovePermissionRequest().withQueueUrl(queueUrl).withLabel(label));
  }
  
  public SendMessageResult sendMessage(SendMessageRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SendMessageResult sendMessage(String queueUrl, String messageBody)
  {
    return sendMessage(new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(messageBody));
  }
  
  public SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SendMessageBatchResult sendMessageBatch(String queueUrl, List<SendMessageBatchRequestEntry> entries)
  {
    return sendMessageBatch(new SendMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public SetQueueAttributesResult setQueueAttributes(SetQueueAttributesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SetQueueAttributesResult setQueueAttributes(String queueUrl, Map<String, String> attributes)
  {
    return setQueueAttributes(new SetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributes(attributes));
  }
  
  public TagQueueResult tagQueue(TagQueueRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TagQueueResult tagQueue(String queueUrl, Map<String, String> tags)
  {
    return tagQueue(new TagQueueRequest().withQueueUrl(queueUrl).withTags(tags));
  }
  
  public UntagQueueResult untagQueue(UntagQueueRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UntagQueueResult untagQueue(String queueUrl, List<String> tagKeys)
  {
    return untagQueue(new UntagQueueRequest().withQueueUrl(queueUrl).withTagKeys(tagKeys));
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AbstractAmazonSQS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */