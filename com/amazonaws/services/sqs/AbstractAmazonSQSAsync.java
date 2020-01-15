package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
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
import java.util.concurrent.Future;

public class AbstractAmazonSQSAsync
  extends AbstractAmazonSQS
  implements AmazonSQSAsync
{
  public Future<AddPermissionResult> addPermissionAsync(AddPermissionRequest request)
  {
    return addPermissionAsync(request, null);
  }
  
  public Future<AddPermissionResult> addPermissionAsync(AddPermissionRequest request, AsyncHandler<AddPermissionRequest, AddPermissionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AddPermissionResult> addPermissionAsync(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions)
  {
    return addPermissionAsync(new AddPermissionRequest().withQueueUrl(queueUrl).withLabel(label).withAWSAccountIds(aWSAccountIds).withActions(actions));
  }
  
  public Future<AddPermissionResult> addPermissionAsync(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions, AsyncHandler<AddPermissionRequest, AddPermissionResult> asyncHandler)
  {
    return addPermissionAsync(new AddPermissionRequest().withQueueUrl(queueUrl).withLabel(label).withAWSAccountIds(aWSAccountIds).withActions(actions), asyncHandler);
  }
  
  public Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest request)
  {
    return changeMessageVisibilityAsync(request, null);
  }
  
  public Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest request, AsyncHandler<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(String queueUrl, String receiptHandle, Integer visibilityTimeout)
  {
    return changeMessageVisibilityAsync(new ChangeMessageVisibilityRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle)
      .withVisibilityTimeout(visibilityTimeout));
  }
  
  public Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(String queueUrl, String receiptHandle, Integer visibilityTimeout, AsyncHandler<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> asyncHandler)
  {
    return changeMessageVisibilityAsync(new ChangeMessageVisibilityRequest()
      .withQueueUrl(queueUrl).withReceiptHandle(receiptHandle).withVisibilityTimeout(visibilityTimeout), asyncHandler);
  }
  
  public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest request)
  {
    return changeMessageVisibilityBatchAsync(request, null);
  }
  
  public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest request, AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries)
  {
    return changeMessageVisibilityBatchAsync(new ChangeMessageVisibilityBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(String queueUrl, List<ChangeMessageVisibilityBatchRequestEntry> entries, AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> asyncHandler)
  {
    return changeMessageVisibilityBatchAsync(new ChangeMessageVisibilityBatchRequest().withQueueUrl(queueUrl).withEntries(entries), asyncHandler);
  }
  
  public Future<CreateQueueResult> createQueueAsync(CreateQueueRequest request)
  {
    return createQueueAsync(request, null);
  }
  
  public Future<CreateQueueResult> createQueueAsync(CreateQueueRequest request, AsyncHandler<CreateQueueRequest, CreateQueueResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateQueueResult> createQueueAsync(String queueName)
  {
    return createQueueAsync(new CreateQueueRequest().withQueueName(queueName));
  }
  
  public Future<CreateQueueResult> createQueueAsync(String queueName, AsyncHandler<CreateQueueRequest, CreateQueueResult> asyncHandler)
  {
    return createQueueAsync(new CreateQueueRequest().withQueueName(queueName), asyncHandler);
  }
  
  public Future<DeleteMessageResult> deleteMessageAsync(DeleteMessageRequest request)
  {
    return deleteMessageAsync(request, null);
  }
  
  public Future<DeleteMessageResult> deleteMessageAsync(DeleteMessageRequest request, AsyncHandler<DeleteMessageRequest, DeleteMessageResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteMessageResult> deleteMessageAsync(String queueUrl, String receiptHandle)
  {
    return deleteMessageAsync(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle));
  }
  
  public Future<DeleteMessageResult> deleteMessageAsync(String queueUrl, String receiptHandle, AsyncHandler<DeleteMessageRequest, DeleteMessageResult> asyncHandler)
  {
    return deleteMessageAsync(new DeleteMessageRequest().withQueueUrl(queueUrl).withReceiptHandle(receiptHandle), asyncHandler);
  }
  
  public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest request)
  {
    return deleteMessageBatchAsync(request, null);
  }
  
  public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest request, AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(String queueUrl, List<DeleteMessageBatchRequestEntry> entries)
  {
    return deleteMessageBatchAsync(new DeleteMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(String queueUrl, List<DeleteMessageBatchRequestEntry> entries, AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> asyncHandler)
  {
    return deleteMessageBatchAsync(new DeleteMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries), asyncHandler);
  }
  
  public Future<DeleteQueueResult> deleteQueueAsync(DeleteQueueRequest request)
  {
    return deleteQueueAsync(request, null);
  }
  
  public Future<DeleteQueueResult> deleteQueueAsync(DeleteQueueRequest request, AsyncHandler<DeleteQueueRequest, DeleteQueueResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteQueueResult> deleteQueueAsync(String queueUrl)
  {
    return deleteQueueAsync(new DeleteQueueRequest().withQueueUrl(queueUrl));
  }
  
  public Future<DeleteQueueResult> deleteQueueAsync(String queueUrl, AsyncHandler<DeleteQueueRequest, DeleteQueueResult> asyncHandler)
  {
    return deleteQueueAsync(new DeleteQueueRequest().withQueueUrl(queueUrl), asyncHandler);
  }
  
  public Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest request)
  {
    return getQueueAttributesAsync(request, null);
  }
  
  public Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest request, AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetQueueAttributesResult> getQueueAttributesAsync(String queueUrl, List<String> attributeNames)
  {
    return getQueueAttributesAsync(new GetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributeNames(attributeNames));
  }
  
  public Future<GetQueueAttributesResult> getQueueAttributesAsync(String queueUrl, List<String> attributeNames, AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> asyncHandler)
  {
    return getQueueAttributesAsync(new GetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributeNames(attributeNames), asyncHandler);
  }
  
  public Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest request)
  {
    return getQueueUrlAsync(request, null);
  }
  
  public Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest request, AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetQueueUrlResult> getQueueUrlAsync(String queueName)
  {
    return getQueueUrlAsync(new GetQueueUrlRequest().withQueueName(queueName));
  }
  
  public Future<GetQueueUrlResult> getQueueUrlAsync(String queueName, AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> asyncHandler)
  {
    return getQueueUrlAsync(new GetQueueUrlRequest().withQueueName(queueName), asyncHandler);
  }
  
  public Future<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueuesAsync(ListDeadLetterSourceQueuesRequest request)
  {
    return listDeadLetterSourceQueuesAsync(request, null);
  }
  
  public Future<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueuesAsync(ListDeadLetterSourceQueuesRequest request, AsyncHandler<ListDeadLetterSourceQueuesRequest, ListDeadLetterSourceQueuesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListQueueTagsResult> listQueueTagsAsync(ListQueueTagsRequest request)
  {
    return listQueueTagsAsync(request, null);
  }
  
  public Future<ListQueueTagsResult> listQueueTagsAsync(ListQueueTagsRequest request, AsyncHandler<ListQueueTagsRequest, ListQueueTagsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListQueueTagsResult> listQueueTagsAsync(String queueUrl)
  {
    return listQueueTagsAsync(new ListQueueTagsRequest().withQueueUrl(queueUrl));
  }
  
  public Future<ListQueueTagsResult> listQueueTagsAsync(String queueUrl, AsyncHandler<ListQueueTagsRequest, ListQueueTagsResult> asyncHandler)
  {
    return listQueueTagsAsync(new ListQueueTagsRequest().withQueueUrl(queueUrl), asyncHandler);
  }
  
  public Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest request)
  {
    return listQueuesAsync(request, null);
  }
  
  public Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest request, AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListQueuesResult> listQueuesAsync()
  {
    return listQueuesAsync(new ListQueuesRequest());
  }
  
  public Future<ListQueuesResult> listQueuesAsync(AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler)
  {
    return listQueuesAsync(new ListQueuesRequest(), asyncHandler);
  }
  
  public Future<ListQueuesResult> listQueuesAsync(String queueNamePrefix)
  {
    return listQueuesAsync(new ListQueuesRequest().withQueueNamePrefix(queueNamePrefix));
  }
  
  public Future<ListQueuesResult> listQueuesAsync(String queueNamePrefix, AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler)
  {
    return listQueuesAsync(new ListQueuesRequest().withQueueNamePrefix(queueNamePrefix), asyncHandler);
  }
  
  public Future<PurgeQueueResult> purgeQueueAsync(PurgeQueueRequest request)
  {
    return purgeQueueAsync(request, null);
  }
  
  public Future<PurgeQueueResult> purgeQueueAsync(PurgeQueueRequest request, AsyncHandler<PurgeQueueRequest, PurgeQueueResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest request)
  {
    return receiveMessageAsync(request, null);
  }
  
  public Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest request, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ReceiveMessageResult> receiveMessageAsync(String queueUrl)
  {
    return receiveMessageAsync(new ReceiveMessageRequest().withQueueUrl(queueUrl));
  }
  
  public Future<ReceiveMessageResult> receiveMessageAsync(String queueUrl, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> asyncHandler)
  {
    return receiveMessageAsync(new ReceiveMessageRequest().withQueueUrl(queueUrl), asyncHandler);
  }
  
  public Future<RemovePermissionResult> removePermissionAsync(RemovePermissionRequest request)
  {
    return removePermissionAsync(request, null);
  }
  
  public Future<RemovePermissionResult> removePermissionAsync(RemovePermissionRequest request, AsyncHandler<RemovePermissionRequest, RemovePermissionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RemovePermissionResult> removePermissionAsync(String queueUrl, String label)
  {
    return removePermissionAsync(new RemovePermissionRequest().withQueueUrl(queueUrl).withLabel(label));
  }
  
  public Future<RemovePermissionResult> removePermissionAsync(String queueUrl, String label, AsyncHandler<RemovePermissionRequest, RemovePermissionResult> asyncHandler)
  {
    return removePermissionAsync(new RemovePermissionRequest().withQueueUrl(queueUrl).withLabel(label), asyncHandler);
  }
  
  public Future<SendMessageResult> sendMessageAsync(SendMessageRequest request)
  {
    return sendMessageAsync(request, null);
  }
  
  public Future<SendMessageResult> sendMessageAsync(SendMessageRequest request, AsyncHandler<SendMessageRequest, SendMessageResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SendMessageResult> sendMessageAsync(String queueUrl, String messageBody)
  {
    return sendMessageAsync(new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(messageBody));
  }
  
  public Future<SendMessageResult> sendMessageAsync(String queueUrl, String messageBody, AsyncHandler<SendMessageRequest, SendMessageResult> asyncHandler)
  {
    return sendMessageAsync(new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody(messageBody), asyncHandler);
  }
  
  public Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest request)
  {
    return sendMessageBatchAsync(request, null);
  }
  
  public Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest request, AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SendMessageBatchResult> sendMessageBatchAsync(String queueUrl, List<SendMessageBatchRequestEntry> entries)
  {
    return sendMessageBatchAsync(new SendMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries));
  }
  
  public Future<SendMessageBatchResult> sendMessageBatchAsync(String queueUrl, List<SendMessageBatchRequestEntry> entries, AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> asyncHandler)
  {
    return sendMessageBatchAsync(new SendMessageBatchRequest().withQueueUrl(queueUrl).withEntries(entries), asyncHandler);
  }
  
  public Future<SetQueueAttributesResult> setQueueAttributesAsync(SetQueueAttributesRequest request)
  {
    return setQueueAttributesAsync(request, null);
  }
  
  public Future<SetQueueAttributesResult> setQueueAttributesAsync(SetQueueAttributesRequest request, AsyncHandler<SetQueueAttributesRequest, SetQueueAttributesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SetQueueAttributesResult> setQueueAttributesAsync(String queueUrl, Map<String, String> attributes)
  {
    return setQueueAttributesAsync(new SetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributes(attributes));
  }
  
  public Future<SetQueueAttributesResult> setQueueAttributesAsync(String queueUrl, Map<String, String> attributes, AsyncHandler<SetQueueAttributesRequest, SetQueueAttributesResult> asyncHandler)
  {
    return setQueueAttributesAsync(new SetQueueAttributesRequest().withQueueUrl(queueUrl).withAttributes(attributes), asyncHandler);
  }
  
  public Future<TagQueueResult> tagQueueAsync(TagQueueRequest request)
  {
    return tagQueueAsync(request, null);
  }
  
  public Future<TagQueueResult> tagQueueAsync(TagQueueRequest request, AsyncHandler<TagQueueRequest, TagQueueResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TagQueueResult> tagQueueAsync(String queueUrl, Map<String, String> tags)
  {
    return tagQueueAsync(new TagQueueRequest().withQueueUrl(queueUrl).withTags(tags));
  }
  
  public Future<TagQueueResult> tagQueueAsync(String queueUrl, Map<String, String> tags, AsyncHandler<TagQueueRequest, TagQueueResult> asyncHandler)
  {
    return tagQueueAsync(new TagQueueRequest().withQueueUrl(queueUrl).withTags(tags), asyncHandler);
  }
  
  public Future<UntagQueueResult> untagQueueAsync(UntagQueueRequest request)
  {
    return untagQueueAsync(request, null);
  }
  
  public Future<UntagQueueResult> untagQueueAsync(UntagQueueRequest request, AsyncHandler<UntagQueueRequest, UntagQueueResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UntagQueueResult> untagQueueAsync(String queueUrl, List<String> tagKeys)
  {
    return untagQueueAsync(new UntagQueueRequest().withQueueUrl(queueUrl).withTagKeys(tagKeys));
  }
  
  public Future<UntagQueueResult> untagQueueAsync(String queueUrl, List<String> tagKeys, AsyncHandler<UntagQueueRequest, UntagQueueResult> asyncHandler)
  {
    return untagQueueAsync(new UntagQueueRequest().withQueueUrl(queueUrl).withTagKeys(tagKeys), asyncHandler);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AbstractAmazonSQSAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */