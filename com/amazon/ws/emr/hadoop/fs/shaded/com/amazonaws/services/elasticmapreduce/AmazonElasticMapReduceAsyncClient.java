package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceFleetResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CreateSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DeleteSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListBootstrapActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListClustersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstancesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceFleetResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ModifyInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutBlockPublicAccessConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetTerminationProtectionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SetVisibleToAllUsersResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsResult;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AmazonElasticMapReduceAsyncClient
  extends AmazonElasticMapReduceClient
  implements AmazonElasticMapReduceAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonElasticMapReduceAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AmazonElasticMapReduceAsyncClientBuilder asyncBuilder()
  {
    return AmazonElasticMapReduceAsyncClientBuilder.standard();
  }
  
  AmazonElasticMapReduceAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<AddInstanceFleetResult> addInstanceFleetAsync(AddInstanceFleetRequest request)
  {
    return addInstanceFleetAsync(request, null);
  }
  
  public Future<AddInstanceFleetResult> addInstanceFleetAsync(AddInstanceFleetRequest request, final AsyncHandler<AddInstanceFleetRequest, AddInstanceFleetResult> asyncHandler)
  {
    final AddInstanceFleetRequest finalRequest = (AddInstanceFleetRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddInstanceFleetResult call()
        throws Exception
      {
        AddInstanceFleetResult result = null;
        try
        {
          result = executeAddInstanceFleet(finalRequest);
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
  
  public Future<AddInstanceGroupsResult> addInstanceGroupsAsync(AddInstanceGroupsRequest request)
  {
    return addInstanceGroupsAsync(request, null);
  }
  
  public Future<AddInstanceGroupsResult> addInstanceGroupsAsync(AddInstanceGroupsRequest request, final AsyncHandler<AddInstanceGroupsRequest, AddInstanceGroupsResult> asyncHandler)
  {
    final AddInstanceGroupsRequest finalRequest = (AddInstanceGroupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddInstanceGroupsResult call()
        throws Exception
      {
        AddInstanceGroupsResult result = null;
        try
        {
          result = executeAddInstanceGroups(finalRequest);
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
  
  public Future<AddJobFlowStepsResult> addJobFlowStepsAsync(AddJobFlowStepsRequest request)
  {
    return addJobFlowStepsAsync(request, null);
  }
  
  public Future<AddJobFlowStepsResult> addJobFlowStepsAsync(AddJobFlowStepsRequest request, final AsyncHandler<AddJobFlowStepsRequest, AddJobFlowStepsResult> asyncHandler)
  {
    final AddJobFlowStepsRequest finalRequest = (AddJobFlowStepsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddJobFlowStepsResult call()
        throws Exception
      {
        AddJobFlowStepsResult result = null;
        try
        {
          result = executeAddJobFlowSteps(finalRequest);
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
  
  public Future<AddTagsResult> addTagsAsync(AddTagsRequest request)
  {
    return addTagsAsync(request, null);
  }
  
  public Future<AddTagsResult> addTagsAsync(AddTagsRequest request, final AsyncHandler<AddTagsRequest, AddTagsResult> asyncHandler)
  {
    final AddTagsRequest finalRequest = (AddTagsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AddTagsResult call()
        throws Exception
      {
        AddTagsResult result = null;
        try
        {
          result = executeAddTags(finalRequest);
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
  
  public Future<CancelStepsResult> cancelStepsAsync(CancelStepsRequest request)
  {
    return cancelStepsAsync(request, null);
  }
  
  public Future<CancelStepsResult> cancelStepsAsync(CancelStepsRequest request, final AsyncHandler<CancelStepsRequest, CancelStepsResult> asyncHandler)
  {
    final CancelStepsRequest finalRequest = (CancelStepsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CancelStepsResult call()
        throws Exception
      {
        CancelStepsResult result = null;
        try
        {
          result = executeCancelSteps(finalRequest);
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
  
  public Future<CreateSecurityConfigurationResult> createSecurityConfigurationAsync(CreateSecurityConfigurationRequest request)
  {
    return createSecurityConfigurationAsync(request, null);
  }
  
  public Future<CreateSecurityConfigurationResult> createSecurityConfigurationAsync(CreateSecurityConfigurationRequest request, final AsyncHandler<CreateSecurityConfigurationRequest, CreateSecurityConfigurationResult> asyncHandler)
  {
    final CreateSecurityConfigurationRequest finalRequest = (CreateSecurityConfigurationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public CreateSecurityConfigurationResult call()
        throws Exception
      {
        CreateSecurityConfigurationResult result = null;
        try
        {
          result = executeCreateSecurityConfiguration(finalRequest);
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
  
  public Future<DeleteSecurityConfigurationResult> deleteSecurityConfigurationAsync(DeleteSecurityConfigurationRequest request)
  {
    return deleteSecurityConfigurationAsync(request, null);
  }
  
  public Future<DeleteSecurityConfigurationResult> deleteSecurityConfigurationAsync(DeleteSecurityConfigurationRequest request, final AsyncHandler<DeleteSecurityConfigurationRequest, DeleteSecurityConfigurationResult> asyncHandler)
  {
    final DeleteSecurityConfigurationRequest finalRequest = (DeleteSecurityConfigurationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteSecurityConfigurationResult call()
        throws Exception
      {
        DeleteSecurityConfigurationResult result = null;
        try
        {
          result = executeDeleteSecurityConfiguration(finalRequest);
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
  
  public Future<DescribeClusterResult> describeClusterAsync(DescribeClusterRequest request)
  {
    return describeClusterAsync(request, null);
  }
  
  public Future<DescribeClusterResult> describeClusterAsync(DescribeClusterRequest request, final AsyncHandler<DescribeClusterRequest, DescribeClusterResult> asyncHandler)
  {
    final DescribeClusterRequest finalRequest = (DescribeClusterRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeClusterResult call()
        throws Exception
      {
        DescribeClusterResult result = null;
        try
        {
          result = executeDescribeCluster(finalRequest);
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
  
  @Deprecated
  public Future<DescribeJobFlowsResult> describeJobFlowsAsync(DescribeJobFlowsRequest request)
  {
    return describeJobFlowsAsync(request, null);
  }
  
  @Deprecated
  public Future<DescribeJobFlowsResult> describeJobFlowsAsync(DescribeJobFlowsRequest request, final AsyncHandler<DescribeJobFlowsRequest, DescribeJobFlowsResult> asyncHandler)
  {
    final DescribeJobFlowsRequest finalRequest = (DescribeJobFlowsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeJobFlowsResult call()
        throws Exception
      {
        DescribeJobFlowsResult result = null;
        try
        {
          result = executeDescribeJobFlows(finalRequest);
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
  
  @Deprecated
  public Future<DescribeJobFlowsResult> describeJobFlowsAsync()
  {
    return describeJobFlowsAsync(new DescribeJobFlowsRequest());
  }
  
  @Deprecated
  public Future<DescribeJobFlowsResult> describeJobFlowsAsync(AsyncHandler<DescribeJobFlowsRequest, DescribeJobFlowsResult> asyncHandler)
  {
    return describeJobFlowsAsync(new DescribeJobFlowsRequest(), asyncHandler);
  }
  
  public Future<DescribeSecurityConfigurationResult> describeSecurityConfigurationAsync(DescribeSecurityConfigurationRequest request)
  {
    return describeSecurityConfigurationAsync(request, null);
  }
  
  public Future<DescribeSecurityConfigurationResult> describeSecurityConfigurationAsync(DescribeSecurityConfigurationRequest request, final AsyncHandler<DescribeSecurityConfigurationRequest, DescribeSecurityConfigurationResult> asyncHandler)
  {
    final DescribeSecurityConfigurationRequest finalRequest = (DescribeSecurityConfigurationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeSecurityConfigurationResult call()
        throws Exception
      {
        DescribeSecurityConfigurationResult result = null;
        try
        {
          result = executeDescribeSecurityConfiguration(finalRequest);
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
  
  public Future<DescribeStepResult> describeStepAsync(DescribeStepRequest request)
  {
    return describeStepAsync(request, null);
  }
  
  public Future<DescribeStepResult> describeStepAsync(DescribeStepRequest request, final AsyncHandler<DescribeStepRequest, DescribeStepResult> asyncHandler)
  {
    final DescribeStepRequest finalRequest = (DescribeStepRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeStepResult call()
        throws Exception
      {
        DescribeStepResult result = null;
        try
        {
          result = executeDescribeStep(finalRequest);
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
  
  public Future<GetBlockPublicAccessConfigurationResult> getBlockPublicAccessConfigurationAsync(GetBlockPublicAccessConfigurationRequest request)
  {
    return getBlockPublicAccessConfigurationAsync(request, null);
  }
  
  public Future<GetBlockPublicAccessConfigurationResult> getBlockPublicAccessConfigurationAsync(GetBlockPublicAccessConfigurationRequest request, final AsyncHandler<GetBlockPublicAccessConfigurationRequest, GetBlockPublicAccessConfigurationResult> asyncHandler)
  {
    final GetBlockPublicAccessConfigurationRequest finalRequest = (GetBlockPublicAccessConfigurationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetBlockPublicAccessConfigurationResult call()
        throws Exception
      {
        GetBlockPublicAccessConfigurationResult result = null;
        try
        {
          result = executeGetBlockPublicAccessConfiguration(finalRequest);
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
  
  public Future<ListBootstrapActionsResult> listBootstrapActionsAsync(ListBootstrapActionsRequest request)
  {
    return listBootstrapActionsAsync(request, null);
  }
  
  public Future<ListBootstrapActionsResult> listBootstrapActionsAsync(ListBootstrapActionsRequest request, final AsyncHandler<ListBootstrapActionsRequest, ListBootstrapActionsResult> asyncHandler)
  {
    final ListBootstrapActionsRequest finalRequest = (ListBootstrapActionsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListBootstrapActionsResult call()
        throws Exception
      {
        ListBootstrapActionsResult result = null;
        try
        {
          result = executeListBootstrapActions(finalRequest);
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
  
  public Future<ListClustersResult> listClustersAsync(ListClustersRequest request)
  {
    return listClustersAsync(request, null);
  }
  
  public Future<ListClustersResult> listClustersAsync(ListClustersRequest request, final AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler)
  {
    final ListClustersRequest finalRequest = (ListClustersRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListClustersResult call()
        throws Exception
      {
        ListClustersResult result = null;
        try
        {
          result = executeListClusters(finalRequest);
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
  
  public Future<ListClustersResult> listClustersAsync()
  {
    return listClustersAsync(new ListClustersRequest());
  }
  
  public Future<ListClustersResult> listClustersAsync(AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler)
  {
    return listClustersAsync(new ListClustersRequest(), asyncHandler);
  }
  
  public Future<ListInstanceFleetsResult> listInstanceFleetsAsync(ListInstanceFleetsRequest request)
  {
    return listInstanceFleetsAsync(request, null);
  }
  
  public Future<ListInstanceFleetsResult> listInstanceFleetsAsync(ListInstanceFleetsRequest request, final AsyncHandler<ListInstanceFleetsRequest, ListInstanceFleetsResult> asyncHandler)
  {
    final ListInstanceFleetsRequest finalRequest = (ListInstanceFleetsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListInstanceFleetsResult call()
        throws Exception
      {
        ListInstanceFleetsResult result = null;
        try
        {
          result = executeListInstanceFleets(finalRequest);
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
  
  public Future<ListInstanceGroupsResult> listInstanceGroupsAsync(ListInstanceGroupsRequest request)
  {
    return listInstanceGroupsAsync(request, null);
  }
  
  public Future<ListInstanceGroupsResult> listInstanceGroupsAsync(ListInstanceGroupsRequest request, final AsyncHandler<ListInstanceGroupsRequest, ListInstanceGroupsResult> asyncHandler)
  {
    final ListInstanceGroupsRequest finalRequest = (ListInstanceGroupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListInstanceGroupsResult call()
        throws Exception
      {
        ListInstanceGroupsResult result = null;
        try
        {
          result = executeListInstanceGroups(finalRequest);
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
  
  public Future<ListInstancesResult> listInstancesAsync(ListInstancesRequest request)
  {
    return listInstancesAsync(request, null);
  }
  
  public Future<ListInstancesResult> listInstancesAsync(ListInstancesRequest request, final AsyncHandler<ListInstancesRequest, ListInstancesResult> asyncHandler)
  {
    final ListInstancesRequest finalRequest = (ListInstancesRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListInstancesResult call()
        throws Exception
      {
        ListInstancesResult result = null;
        try
        {
          result = executeListInstances(finalRequest);
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
  
  public Future<ListSecurityConfigurationsResult> listSecurityConfigurationsAsync(ListSecurityConfigurationsRequest request)
  {
    return listSecurityConfigurationsAsync(request, null);
  }
  
  public Future<ListSecurityConfigurationsResult> listSecurityConfigurationsAsync(ListSecurityConfigurationsRequest request, final AsyncHandler<ListSecurityConfigurationsRequest, ListSecurityConfigurationsResult> asyncHandler)
  {
    final ListSecurityConfigurationsRequest finalRequest = (ListSecurityConfigurationsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListSecurityConfigurationsResult call()
        throws Exception
      {
        ListSecurityConfigurationsResult result = null;
        try
        {
          result = executeListSecurityConfigurations(finalRequest);
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
  
  public Future<ListStepsResult> listStepsAsync(ListStepsRequest request)
  {
    return listStepsAsync(request, null);
  }
  
  public Future<ListStepsResult> listStepsAsync(ListStepsRequest request, final AsyncHandler<ListStepsRequest, ListStepsResult> asyncHandler)
  {
    final ListStepsRequest finalRequest = (ListStepsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListStepsResult call()
        throws Exception
      {
        ListStepsResult result = null;
        try
        {
          result = executeListSteps(finalRequest);
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
  
  public Future<ModifyInstanceFleetResult> modifyInstanceFleetAsync(ModifyInstanceFleetRequest request)
  {
    return modifyInstanceFleetAsync(request, null);
  }
  
  public Future<ModifyInstanceFleetResult> modifyInstanceFleetAsync(ModifyInstanceFleetRequest request, final AsyncHandler<ModifyInstanceFleetRequest, ModifyInstanceFleetResult> asyncHandler)
  {
    final ModifyInstanceFleetRequest finalRequest = (ModifyInstanceFleetRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ModifyInstanceFleetResult call()
        throws Exception
      {
        ModifyInstanceFleetResult result = null;
        try
        {
          result = executeModifyInstanceFleet(finalRequest);
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
  
  public Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(ModifyInstanceGroupsRequest request)
  {
    return modifyInstanceGroupsAsync(request, null);
  }
  
  public Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(ModifyInstanceGroupsRequest request, final AsyncHandler<ModifyInstanceGroupsRequest, ModifyInstanceGroupsResult> asyncHandler)
  {
    final ModifyInstanceGroupsRequest finalRequest = (ModifyInstanceGroupsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ModifyInstanceGroupsResult call()
        throws Exception
      {
        ModifyInstanceGroupsResult result = null;
        try
        {
          result = executeModifyInstanceGroups(finalRequest);
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
  
  public Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync()
  {
    return modifyInstanceGroupsAsync(new ModifyInstanceGroupsRequest());
  }
  
  public Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(AsyncHandler<ModifyInstanceGroupsRequest, ModifyInstanceGroupsResult> asyncHandler)
  {
    return modifyInstanceGroupsAsync(new ModifyInstanceGroupsRequest(), asyncHandler);
  }
  
  public Future<PutAutoScalingPolicyResult> putAutoScalingPolicyAsync(PutAutoScalingPolicyRequest request)
  {
    return putAutoScalingPolicyAsync(request, null);
  }
  
  public Future<PutAutoScalingPolicyResult> putAutoScalingPolicyAsync(PutAutoScalingPolicyRequest request, final AsyncHandler<PutAutoScalingPolicyRequest, PutAutoScalingPolicyResult> asyncHandler)
  {
    final PutAutoScalingPolicyRequest finalRequest = (PutAutoScalingPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutAutoScalingPolicyResult call()
        throws Exception
      {
        PutAutoScalingPolicyResult result = null;
        try
        {
          result = executePutAutoScalingPolicy(finalRequest);
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
  
  public Future<PutBlockPublicAccessConfigurationResult> putBlockPublicAccessConfigurationAsync(PutBlockPublicAccessConfigurationRequest request)
  {
    return putBlockPublicAccessConfigurationAsync(request, null);
  }
  
  public Future<PutBlockPublicAccessConfigurationResult> putBlockPublicAccessConfigurationAsync(PutBlockPublicAccessConfigurationRequest request, final AsyncHandler<PutBlockPublicAccessConfigurationRequest, PutBlockPublicAccessConfigurationResult> asyncHandler)
  {
    final PutBlockPublicAccessConfigurationRequest finalRequest = (PutBlockPublicAccessConfigurationRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutBlockPublicAccessConfigurationResult call()
        throws Exception
      {
        PutBlockPublicAccessConfigurationResult result = null;
        try
        {
          result = executePutBlockPublicAccessConfiguration(finalRequest);
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
  
  public Future<RemoveAutoScalingPolicyResult> removeAutoScalingPolicyAsync(RemoveAutoScalingPolicyRequest request)
  {
    return removeAutoScalingPolicyAsync(request, null);
  }
  
  public Future<RemoveAutoScalingPolicyResult> removeAutoScalingPolicyAsync(RemoveAutoScalingPolicyRequest request, final AsyncHandler<RemoveAutoScalingPolicyRequest, RemoveAutoScalingPolicyResult> asyncHandler)
  {
    final RemoveAutoScalingPolicyRequest finalRequest = (RemoveAutoScalingPolicyRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RemoveAutoScalingPolicyResult call()
        throws Exception
      {
        RemoveAutoScalingPolicyResult result = null;
        try
        {
          result = executeRemoveAutoScalingPolicy(finalRequest);
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
  
  public Future<RemoveTagsResult> removeTagsAsync(RemoveTagsRequest request)
  {
    return removeTagsAsync(request, null);
  }
  
  public Future<RemoveTagsResult> removeTagsAsync(RemoveTagsRequest request, final AsyncHandler<RemoveTagsRequest, RemoveTagsResult> asyncHandler)
  {
    final RemoveTagsRequest finalRequest = (RemoveTagsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RemoveTagsResult call()
        throws Exception
      {
        RemoveTagsResult result = null;
        try
        {
          result = executeRemoveTags(finalRequest);
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
  
  public Future<RunJobFlowResult> runJobFlowAsync(RunJobFlowRequest request)
  {
    return runJobFlowAsync(request, null);
  }
  
  public Future<RunJobFlowResult> runJobFlowAsync(RunJobFlowRequest request, final AsyncHandler<RunJobFlowRequest, RunJobFlowResult> asyncHandler)
  {
    final RunJobFlowRequest finalRequest = (RunJobFlowRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public RunJobFlowResult call()
        throws Exception
      {
        RunJobFlowResult result = null;
        try
        {
          result = executeRunJobFlow(finalRequest);
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
  
  public Future<SetTerminationProtectionResult> setTerminationProtectionAsync(SetTerminationProtectionRequest request)
  {
    return setTerminationProtectionAsync(request, null);
  }
  
  public Future<SetTerminationProtectionResult> setTerminationProtectionAsync(SetTerminationProtectionRequest request, final AsyncHandler<SetTerminationProtectionRequest, SetTerminationProtectionResult> asyncHandler)
  {
    final SetTerminationProtectionRequest finalRequest = (SetTerminationProtectionRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SetTerminationProtectionResult call()
        throws Exception
      {
        SetTerminationProtectionResult result = null;
        try
        {
          result = executeSetTerminationProtection(finalRequest);
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
  
  public Future<SetVisibleToAllUsersResult> setVisibleToAllUsersAsync(SetVisibleToAllUsersRequest request)
  {
    return setVisibleToAllUsersAsync(request, null);
  }
  
  public Future<SetVisibleToAllUsersResult> setVisibleToAllUsersAsync(SetVisibleToAllUsersRequest request, final AsyncHandler<SetVisibleToAllUsersRequest, SetVisibleToAllUsersResult> asyncHandler)
  {
    final SetVisibleToAllUsersRequest finalRequest = (SetVisibleToAllUsersRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SetVisibleToAllUsersResult call()
        throws Exception
      {
        SetVisibleToAllUsersResult result = null;
        try
        {
          result = executeSetVisibleToAllUsers(finalRequest);
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
  
  public Future<TerminateJobFlowsResult> terminateJobFlowsAsync(TerminateJobFlowsRequest request)
  {
    return terminateJobFlowsAsync(request, null);
  }
  
  public Future<TerminateJobFlowsResult> terminateJobFlowsAsync(TerminateJobFlowsRequest request, final AsyncHandler<TerminateJobFlowsRequest, TerminateJobFlowsResult> asyncHandler)
  {
    final TerminateJobFlowsRequest finalRequest = (TerminateJobFlowsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TerminateJobFlowsResult call()
        throws Exception
      {
        TerminateJobFlowsResult result = null;
        try
        {
          result = executeTerminateJobFlows(finalRequest);
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
  
  public void shutdown()
  {
    super.shutdown();
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */