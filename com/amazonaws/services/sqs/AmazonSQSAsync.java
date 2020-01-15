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

public abstract interface AmazonSQSAsync
  extends AmazonSQS
{
  public abstract Future<AddPermissionResult> addPermissionAsync(AddPermissionRequest paramAddPermissionRequest);
  
  public abstract Future<AddPermissionResult> addPermissionAsync(AddPermissionRequest paramAddPermissionRequest, AsyncHandler<AddPermissionRequest, AddPermissionResult> paramAsyncHandler);
  
  public abstract Future<AddPermissionResult> addPermissionAsync(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract Future<AddPermissionResult> addPermissionAsync(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, AsyncHandler<AddPermissionRequest, AddPermissionResult> paramAsyncHandler);
  
  public abstract Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest paramChangeMessageVisibilityRequest);
  
  public abstract Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest paramChangeMessageVisibilityRequest, AsyncHandler<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> paramAsyncHandler);
  
  public abstract Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(String paramString1, String paramString2, Integer paramInteger);
  
  public abstract Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(String paramString1, String paramString2, Integer paramInteger, AsyncHandler<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> paramAsyncHandler);
  
  public abstract Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest paramChangeMessageVisibilityBatchRequest);
  
  public abstract Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest paramChangeMessageVisibilityBatchRequest, AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> paramAsyncHandler);
  
  public abstract Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(String paramString, List<ChangeMessageVisibilityBatchRequestEntry> paramList);
  
  public abstract Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(String paramString, List<ChangeMessageVisibilityBatchRequestEntry> paramList, AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> paramAsyncHandler);
  
  public abstract Future<CreateQueueResult> createQueueAsync(CreateQueueRequest paramCreateQueueRequest);
  
  public abstract Future<CreateQueueResult> createQueueAsync(CreateQueueRequest paramCreateQueueRequest, AsyncHandler<CreateQueueRequest, CreateQueueResult> paramAsyncHandler);
  
  public abstract Future<CreateQueueResult> createQueueAsync(String paramString);
  
  public abstract Future<CreateQueueResult> createQueueAsync(String paramString, AsyncHandler<CreateQueueRequest, CreateQueueResult> paramAsyncHandler);
  
  public abstract Future<DeleteMessageResult> deleteMessageAsync(DeleteMessageRequest paramDeleteMessageRequest);
  
  public abstract Future<DeleteMessageResult> deleteMessageAsync(DeleteMessageRequest paramDeleteMessageRequest, AsyncHandler<DeleteMessageRequest, DeleteMessageResult> paramAsyncHandler);
  
  public abstract Future<DeleteMessageResult> deleteMessageAsync(String paramString1, String paramString2);
  
  public abstract Future<DeleteMessageResult> deleteMessageAsync(String paramString1, String paramString2, AsyncHandler<DeleteMessageRequest, DeleteMessageResult> paramAsyncHandler);
  
  public abstract Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest paramDeleteMessageBatchRequest);
  
  public abstract Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest paramDeleteMessageBatchRequest, AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> paramAsyncHandler);
  
  public abstract Future<DeleteMessageBatchResult> deleteMessageBatchAsync(String paramString, List<DeleteMessageBatchRequestEntry> paramList);
  
  public abstract Future<DeleteMessageBatchResult> deleteMessageBatchAsync(String paramString, List<DeleteMessageBatchRequestEntry> paramList, AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> paramAsyncHandler);
  
  public abstract Future<DeleteQueueResult> deleteQueueAsync(DeleteQueueRequest paramDeleteQueueRequest);
  
  public abstract Future<DeleteQueueResult> deleteQueueAsync(DeleteQueueRequest paramDeleteQueueRequest, AsyncHandler<DeleteQueueRequest, DeleteQueueResult> paramAsyncHandler);
  
  public abstract Future<DeleteQueueResult> deleteQueueAsync(String paramString);
  
  public abstract Future<DeleteQueueResult> deleteQueueAsync(String paramString, AsyncHandler<DeleteQueueRequest, DeleteQueueResult> paramAsyncHandler);
  
  public abstract Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest paramGetQueueAttributesRequest);
  
  public abstract Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest paramGetQueueAttributesRequest, AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> paramAsyncHandler);
  
  public abstract Future<GetQueueAttributesResult> getQueueAttributesAsync(String paramString, List<String> paramList);
  
  public abstract Future<GetQueueAttributesResult> getQueueAttributesAsync(String paramString, List<String> paramList, AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> paramAsyncHandler);
  
  public abstract Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest paramGetQueueUrlRequest);
  
  public abstract Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest paramGetQueueUrlRequest, AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> paramAsyncHandler);
  
  public abstract Future<GetQueueUrlResult> getQueueUrlAsync(String paramString);
  
  public abstract Future<GetQueueUrlResult> getQueueUrlAsync(String paramString, AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> paramAsyncHandler);
  
  public abstract Future<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueuesAsync(ListDeadLetterSourceQueuesRequest paramListDeadLetterSourceQueuesRequest);
  
  public abstract Future<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueuesAsync(ListDeadLetterSourceQueuesRequest paramListDeadLetterSourceQueuesRequest, AsyncHandler<ListDeadLetterSourceQueuesRequest, ListDeadLetterSourceQueuesResult> paramAsyncHandler);
  
  public abstract Future<ListQueueTagsResult> listQueueTagsAsync(ListQueueTagsRequest paramListQueueTagsRequest);
  
  public abstract Future<ListQueueTagsResult> listQueueTagsAsync(ListQueueTagsRequest paramListQueueTagsRequest, AsyncHandler<ListQueueTagsRequest, ListQueueTagsResult> paramAsyncHandler);
  
  public abstract Future<ListQueueTagsResult> listQueueTagsAsync(String paramString);
  
  public abstract Future<ListQueueTagsResult> listQueueTagsAsync(String paramString, AsyncHandler<ListQueueTagsRequest, ListQueueTagsResult> paramAsyncHandler);
  
  public abstract Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest paramListQueuesRequest);
  
  public abstract Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest paramListQueuesRequest, AsyncHandler<ListQueuesRequest, ListQueuesResult> paramAsyncHandler);
  
  public abstract Future<ListQueuesResult> listQueuesAsync();
  
  public abstract Future<ListQueuesResult> listQueuesAsync(AsyncHandler<ListQueuesRequest, ListQueuesResult> paramAsyncHandler);
  
  public abstract Future<ListQueuesResult> listQueuesAsync(String paramString);
  
  public abstract Future<ListQueuesResult> listQueuesAsync(String paramString, AsyncHandler<ListQueuesRequest, ListQueuesResult> paramAsyncHandler);
  
  public abstract Future<PurgeQueueResult> purgeQueueAsync(PurgeQueueRequest paramPurgeQueueRequest);
  
  public abstract Future<PurgeQueueResult> purgeQueueAsync(PurgeQueueRequest paramPurgeQueueRequest, AsyncHandler<PurgeQueueRequest, PurgeQueueResult> paramAsyncHandler);
  
  public abstract Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest paramReceiveMessageRequest);
  
  public abstract Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest paramReceiveMessageRequest, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> paramAsyncHandler);
  
  public abstract Future<ReceiveMessageResult> receiveMessageAsync(String paramString);
  
  public abstract Future<ReceiveMessageResult> receiveMessageAsync(String paramString, AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> paramAsyncHandler);
  
  public abstract Future<RemovePermissionResult> removePermissionAsync(RemovePermissionRequest paramRemovePermissionRequest);
  
  public abstract Future<RemovePermissionResult> removePermissionAsync(RemovePermissionRequest paramRemovePermissionRequest, AsyncHandler<RemovePermissionRequest, RemovePermissionResult> paramAsyncHandler);
  
  public abstract Future<RemovePermissionResult> removePermissionAsync(String paramString1, String paramString2);
  
  public abstract Future<RemovePermissionResult> removePermissionAsync(String paramString1, String paramString2, AsyncHandler<RemovePermissionRequest, RemovePermissionResult> paramAsyncHandler);
  
  public abstract Future<SendMessageResult> sendMessageAsync(SendMessageRequest paramSendMessageRequest);
  
  public abstract Future<SendMessageResult> sendMessageAsync(SendMessageRequest paramSendMessageRequest, AsyncHandler<SendMessageRequest, SendMessageResult> paramAsyncHandler);
  
  public abstract Future<SendMessageResult> sendMessageAsync(String paramString1, String paramString2);
  
  public abstract Future<SendMessageResult> sendMessageAsync(String paramString1, String paramString2, AsyncHandler<SendMessageRequest, SendMessageResult> paramAsyncHandler);
  
  public abstract Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest paramSendMessageBatchRequest);
  
  public abstract Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest paramSendMessageBatchRequest, AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> paramAsyncHandler);
  
  public abstract Future<SendMessageBatchResult> sendMessageBatchAsync(String paramString, List<SendMessageBatchRequestEntry> paramList);
  
  public abstract Future<SendMessageBatchResult> sendMessageBatchAsync(String paramString, List<SendMessageBatchRequestEntry> paramList, AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> paramAsyncHandler);
  
  public abstract Future<SetQueueAttributesResult> setQueueAttributesAsync(SetQueueAttributesRequest paramSetQueueAttributesRequest);
  
  public abstract Future<SetQueueAttributesResult> setQueueAttributesAsync(SetQueueAttributesRequest paramSetQueueAttributesRequest, AsyncHandler<SetQueueAttributesRequest, SetQueueAttributesResult> paramAsyncHandler);
  
  public abstract Future<SetQueueAttributesResult> setQueueAttributesAsync(String paramString, Map<String, String> paramMap);
  
  public abstract Future<SetQueueAttributesResult> setQueueAttributesAsync(String paramString, Map<String, String> paramMap, AsyncHandler<SetQueueAttributesRequest, SetQueueAttributesResult> paramAsyncHandler);
  
  public abstract Future<TagQueueResult> tagQueueAsync(TagQueueRequest paramTagQueueRequest);
  
  public abstract Future<TagQueueResult> tagQueueAsync(TagQueueRequest paramTagQueueRequest, AsyncHandler<TagQueueRequest, TagQueueResult> paramAsyncHandler);
  
  public abstract Future<TagQueueResult> tagQueueAsync(String paramString, Map<String, String> paramMap);
  
  public abstract Future<TagQueueResult> tagQueueAsync(String paramString, Map<String, String> paramMap, AsyncHandler<TagQueueRequest, TagQueueResult> paramAsyncHandler);
  
  public abstract Future<UntagQueueResult> untagQueueAsync(UntagQueueRequest paramUntagQueueRequest);
  
  public abstract Future<UntagQueueResult> untagQueueAsync(UntagQueueRequest paramUntagQueueRequest, AsyncHandler<UntagQueueRequest, UntagQueueResult> paramAsyncHandler);
  
  public abstract Future<UntagQueueResult> untagQueueAsync(String paramString, List<String> paramList);
  
  public abstract Future<UntagQueueResult> untagQueueAsync(String paramString, List<String> paramList, AsyncHandler<UntagQueueRequest, UntagQueueResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */