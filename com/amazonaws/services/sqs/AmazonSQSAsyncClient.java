package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
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
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AmazonSQSAsyncClient
  extends AmazonSQSClient
  implements AmazonSQSAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AmazonSQSAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonSQSAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AmazonSQSAsyncClientBuilder asyncBuilder()
  {
    return AmazonSQSAsyncClientBuilder.standard();
  }
  
  AmazonSQSAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<AddPermissionResult> addPermissionAsync(AddPermissionRequest request)
  {
    return addPermissionAsync(request, null);
  }
  
  public Future<AddPermissionResult> addPermissionAsync(AddPermissionRequest request, final AsyncHandler<AddPermissionRequest, AddPermissionResult> asyncHandler)
  {
    final AddPermissionRequest finalRequest = (AddPermissionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddPermissionResult call()
        throws Exception
      {
        AddPermissionResult result = null;
        try
        {
          result = executeAddPermission(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ChangeMessageVisibilityResult> changeMessageVisibilityAsync(ChangeMessageVisibilityRequest request, final AsyncHandler<ChangeMessageVisibilityRequest, ChangeMessageVisibilityResult> asyncHandler)
  {
    final ChangeMessageVisibilityRequest finalRequest = (ChangeMessageVisibilityRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ChangeMessageVisibilityResult call()
        throws Exception
      {
        ChangeMessageVisibilityResult result = null;
        try
        {
          result = executeChangeMessageVisibility(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ChangeMessageVisibilityBatchResult> changeMessageVisibilityBatchAsync(ChangeMessageVisibilityBatchRequest request, final AsyncHandler<ChangeMessageVisibilityBatchRequest, ChangeMessageVisibilityBatchResult> asyncHandler)
  {
    final ChangeMessageVisibilityBatchRequest finalRequest = (ChangeMessageVisibilityBatchRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ChangeMessageVisibilityBatchResult call()
        throws Exception
      {
        ChangeMessageVisibilityBatchResult result = null;
        try
        {
          result = executeChangeMessageVisibilityBatch(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<CreateQueueResult> createQueueAsync(CreateQueueRequest request, final AsyncHandler<CreateQueueRequest, CreateQueueResult> asyncHandler)
  {
    final CreateQueueRequest finalRequest = (CreateQueueRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateQueueResult call()
        throws Exception
      {
        CreateQueueResult result = null;
        try
        {
          result = executeCreateQueue(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<DeleteMessageResult> deleteMessageAsync(DeleteMessageRequest request, final AsyncHandler<DeleteMessageRequest, DeleteMessageResult> asyncHandler)
  {
    final DeleteMessageRequest finalRequest = (DeleteMessageRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteMessageResult call()
        throws Exception
      {
        DeleteMessageResult result = null;
        try
        {
          result = executeDeleteMessage(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<DeleteMessageBatchResult> deleteMessageBatchAsync(DeleteMessageBatchRequest request, final AsyncHandler<DeleteMessageBatchRequest, DeleteMessageBatchResult> asyncHandler)
  {
    final DeleteMessageBatchRequest finalRequest = (DeleteMessageBatchRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteMessageBatchResult call()
        throws Exception
      {
        DeleteMessageBatchResult result = null;
        try
        {
          result = executeDeleteMessageBatch(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<DeleteQueueResult> deleteQueueAsync(DeleteQueueRequest request, final AsyncHandler<DeleteQueueRequest, DeleteQueueResult> asyncHandler)
  {
    final DeleteQueueRequest finalRequest = (DeleteQueueRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteQueueResult call()
        throws Exception
      {
        DeleteQueueResult result = null;
        try
        {
          result = executeDeleteQueue(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<GetQueueAttributesResult> getQueueAttributesAsync(GetQueueAttributesRequest request, final AsyncHandler<GetQueueAttributesRequest, GetQueueAttributesResult> asyncHandler)
  {
    final GetQueueAttributesRequest finalRequest = (GetQueueAttributesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetQueueAttributesResult call()
        throws Exception
      {
        GetQueueAttributesResult result = null;
        try
        {
          result = executeGetQueueAttributes(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<GetQueueUrlResult> getQueueUrlAsync(GetQueueUrlRequest request, final AsyncHandler<GetQueueUrlRequest, GetQueueUrlResult> asyncHandler)
  {
    final GetQueueUrlRequest finalRequest = (GetQueueUrlRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetQueueUrlResult call()
        throws Exception
      {
        GetQueueUrlResult result = null;
        try
        {
          result = executeGetQueueUrl(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ListDeadLetterSourceQueuesResult> listDeadLetterSourceQueuesAsync(ListDeadLetterSourceQueuesRequest request, final AsyncHandler<ListDeadLetterSourceQueuesRequest, ListDeadLetterSourceQueuesResult> asyncHandler)
  {
    final ListDeadLetterSourceQueuesRequest finalRequest = (ListDeadLetterSourceQueuesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListDeadLetterSourceQueuesResult call()
        throws Exception
      {
        ListDeadLetterSourceQueuesResult result = null;
        try
        {
          result = executeListDeadLetterSourceQueues(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListQueueTagsResult> listQueueTagsAsync(ListQueueTagsRequest request)
  {
    return listQueueTagsAsync(request, null);
  }
  
  public Future<ListQueueTagsResult> listQueueTagsAsync(ListQueueTagsRequest request, final AsyncHandler<ListQueueTagsRequest, ListQueueTagsResult> asyncHandler)
  {
    final ListQueueTagsRequest finalRequest = (ListQueueTagsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListQueueTagsResult call()
        throws Exception
      {
        ListQueueTagsResult result = null;
        try
        {
          result = executeListQueueTags(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ListQueuesResult> listQueuesAsync(ListQueuesRequest request, final AsyncHandler<ListQueuesRequest, ListQueuesResult> asyncHandler)
  {
    final ListQueuesRequest finalRequest = (ListQueuesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListQueuesResult call()
        throws Exception
      {
        ListQueuesResult result = null;
        try
        {
          result = executeListQueues(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<PurgeQueueResult> purgeQueueAsync(PurgeQueueRequest request, final AsyncHandler<PurgeQueueRequest, PurgeQueueResult> asyncHandler)
  {
    final PurgeQueueRequest finalRequest = (PurgeQueueRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PurgeQueueResult call()
        throws Exception
      {
        PurgeQueueResult result = null;
        try
        {
          result = executePurgeQueue(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest request)
  {
    return receiveMessageAsync(request, null);
  }
  
  public Future<ReceiveMessageResult> receiveMessageAsync(ReceiveMessageRequest request, final AsyncHandler<ReceiveMessageRequest, ReceiveMessageResult> asyncHandler)
  {
    final ReceiveMessageRequest finalRequest = (ReceiveMessageRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ReceiveMessageResult call()
        throws Exception
      {
        ReceiveMessageResult result = null;
        try
        {
          result = executeReceiveMessage(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<RemovePermissionResult> removePermissionAsync(RemovePermissionRequest request, final AsyncHandler<RemovePermissionRequest, RemovePermissionResult> asyncHandler)
  {
    final RemovePermissionRequest finalRequest = (RemovePermissionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RemovePermissionResult call()
        throws Exception
      {
        RemovePermissionResult result = null;
        try
        {
          result = executeRemovePermission(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<SendMessageResult> sendMessageAsync(SendMessageRequest request, final AsyncHandler<SendMessageRequest, SendMessageResult> asyncHandler)
  {
    final SendMessageRequest finalRequest = (SendMessageRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SendMessageResult call()
        throws Exception
      {
        SendMessageResult result = null;
        try
        {
          result = executeSendMessage(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<SendMessageBatchResult> sendMessageBatchAsync(SendMessageBatchRequest request, final AsyncHandler<SendMessageBatchRequest, SendMessageBatchResult> asyncHandler)
  {
    final SendMessageBatchRequest finalRequest = (SendMessageBatchRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SendMessageBatchResult call()
        throws Exception
      {
        SendMessageBatchResult result = null;
        try
        {
          result = executeSendMessageBatch(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<SetQueueAttributesResult> setQueueAttributesAsync(SetQueueAttributesRequest request, final AsyncHandler<SetQueueAttributesRequest, SetQueueAttributesResult> asyncHandler)
  {
    final SetQueueAttributesRequest finalRequest = (SetQueueAttributesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SetQueueAttributesResult call()
        throws Exception
      {
        SetQueueAttributesResult result = null;
        try
        {
          result = executeSetQueueAttributes(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<TagQueueResult> tagQueueAsync(TagQueueRequest request, final AsyncHandler<TagQueueRequest, TagQueueResult> asyncHandler)
  {
    final TagQueueRequest finalRequest = (TagQueueRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TagQueueResult call()
        throws Exception
      {
        TagQueueResult result = null;
        try
        {
          result = executeTagQueue(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<UntagQueueResult> untagQueueAsync(UntagQueueRequest request, final AsyncHandler<UntagQueueRequest, UntagQueueResult> asyncHandler)
  {
    final UntagQueueRequest finalRequest = (UntagQueueRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UntagQueueResult call()
        throws Exception
      {
        UntagQueueResult result = null;
        try
        {
          result = executeUntagQueue(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<UntagQueueResult> untagQueueAsync(String queueUrl, List<String> tagKeys)
  {
    return untagQueueAsync(new UntagQueueRequest().withQueueUrl(queueUrl).withTagKeys(tagKeys));
  }
  
  public Future<UntagQueueResult> untagQueueAsync(String queueUrl, List<String> tagKeys, AsyncHandler<UntagQueueRequest, UntagQueueResult> asyncHandler)
  {
    return untagQueueAsync(new UntagQueueRequest().withQueueUrl(queueUrl).withTagKeys(tagKeys), asyncHandler);
  }
  
  public void shutdown()
  {
    super.shutdown();
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */