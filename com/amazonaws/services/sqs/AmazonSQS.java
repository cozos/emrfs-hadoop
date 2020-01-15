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

public abstract interface AmazonSQS
{
  public static final String ENDPOINT_PREFIX = "sqs";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract AddPermissionResult addPermission(AddPermissionRequest paramAddPermissionRequest);
  
  public abstract AddPermissionResult addPermission(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2);
  
  public abstract ChangeMessageVisibilityResult changeMessageVisibility(ChangeMessageVisibilityRequest paramChangeMessageVisibilityRequest);
  
  public abstract ChangeMessageVisibilityResult changeMessageVisibility(String paramString1, String paramString2, Integer paramInteger);
  
  public abstract ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(ChangeMessageVisibilityBatchRequest paramChangeMessageVisibilityBatchRequest);
  
  public abstract ChangeMessageVisibilityBatchResult changeMessageVisibilityBatch(String paramString, List<ChangeMessageVisibilityBatchRequestEntry> paramList);
  
  public abstract CreateQueueResult createQueue(CreateQueueRequest paramCreateQueueRequest);
  
  public abstract CreateQueueResult createQueue(String paramString);
  
  public abstract DeleteMessageResult deleteMessage(DeleteMessageRequest paramDeleteMessageRequest);
  
  public abstract DeleteMessageResult deleteMessage(String paramString1, String paramString2);
  
  public abstract DeleteMessageBatchResult deleteMessageBatch(DeleteMessageBatchRequest paramDeleteMessageBatchRequest);
  
  public abstract DeleteMessageBatchResult deleteMessageBatch(String paramString, List<DeleteMessageBatchRequestEntry> paramList);
  
  public abstract DeleteQueueResult deleteQueue(DeleteQueueRequest paramDeleteQueueRequest);
  
  public abstract DeleteQueueResult deleteQueue(String paramString);
  
  public abstract GetQueueAttributesResult getQueueAttributes(GetQueueAttributesRequest paramGetQueueAttributesRequest);
  
  public abstract GetQueueAttributesResult getQueueAttributes(String paramString, List<String> paramList);
  
  public abstract GetQueueUrlResult getQueueUrl(GetQueueUrlRequest paramGetQueueUrlRequest);
  
  public abstract GetQueueUrlResult getQueueUrl(String paramString);
  
  public abstract ListDeadLetterSourceQueuesResult listDeadLetterSourceQueues(ListDeadLetterSourceQueuesRequest paramListDeadLetterSourceQueuesRequest);
  
  public abstract ListQueueTagsResult listQueueTags(ListQueueTagsRequest paramListQueueTagsRequest);
  
  public abstract ListQueueTagsResult listQueueTags(String paramString);
  
  public abstract ListQueuesResult listQueues(ListQueuesRequest paramListQueuesRequest);
  
  public abstract ListQueuesResult listQueues();
  
  public abstract ListQueuesResult listQueues(String paramString);
  
  public abstract PurgeQueueResult purgeQueue(PurgeQueueRequest paramPurgeQueueRequest);
  
  public abstract ReceiveMessageResult receiveMessage(ReceiveMessageRequest paramReceiveMessageRequest);
  
  public abstract ReceiveMessageResult receiveMessage(String paramString);
  
  public abstract RemovePermissionResult removePermission(RemovePermissionRequest paramRemovePermissionRequest);
  
  public abstract RemovePermissionResult removePermission(String paramString1, String paramString2);
  
  public abstract SendMessageResult sendMessage(SendMessageRequest paramSendMessageRequest);
  
  public abstract SendMessageResult sendMessage(String paramString1, String paramString2);
  
  public abstract SendMessageBatchResult sendMessageBatch(SendMessageBatchRequest paramSendMessageBatchRequest);
  
  public abstract SendMessageBatchResult sendMessageBatch(String paramString, List<SendMessageBatchRequestEntry> paramList);
  
  public abstract SetQueueAttributesResult setQueueAttributes(SetQueueAttributesRequest paramSetQueueAttributesRequest);
  
  public abstract SetQueueAttributesResult setQueueAttributes(String paramString, Map<String, String> paramMap);
  
  public abstract TagQueueResult tagQueue(TagQueueRequest paramTagQueueRequest);
  
  public abstract TagQueueResult tagQueue(String paramString, Map<String, String> paramMap);
  
  public abstract UntagQueueResult untagQueue(UntagQueueRequest paramUntagQueueRequest);
  
  public abstract UntagQueueResult untagQueue(String paramString, List<String> paramList);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */