package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

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
import java.util.concurrent.Future;

public class AbstractAmazonElasticMapReduceAsync
  extends AbstractAmazonElasticMapReduce
  implements AmazonElasticMapReduceAsync
{
  public Future<AddInstanceFleetResult> addInstanceFleetAsync(AddInstanceFleetRequest request)
  {
    return addInstanceFleetAsync(request, null);
  }
  
  public Future<AddInstanceFleetResult> addInstanceFleetAsync(AddInstanceFleetRequest request, AsyncHandler<AddInstanceFleetRequest, AddInstanceFleetResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AddInstanceGroupsResult> addInstanceGroupsAsync(AddInstanceGroupsRequest request)
  {
    return addInstanceGroupsAsync(request, null);
  }
  
  public Future<AddInstanceGroupsResult> addInstanceGroupsAsync(AddInstanceGroupsRequest request, AsyncHandler<AddInstanceGroupsRequest, AddInstanceGroupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AddJobFlowStepsResult> addJobFlowStepsAsync(AddJobFlowStepsRequest request)
  {
    return addJobFlowStepsAsync(request, null);
  }
  
  public Future<AddJobFlowStepsResult> addJobFlowStepsAsync(AddJobFlowStepsRequest request, AsyncHandler<AddJobFlowStepsRequest, AddJobFlowStepsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<AddTagsResult> addTagsAsync(AddTagsRequest request)
  {
    return addTagsAsync(request, null);
  }
  
  public Future<AddTagsResult> addTagsAsync(AddTagsRequest request, AsyncHandler<AddTagsRequest, AddTagsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CancelStepsResult> cancelStepsAsync(CancelStepsRequest request)
  {
    return cancelStepsAsync(request, null);
  }
  
  public Future<CancelStepsResult> cancelStepsAsync(CancelStepsRequest request, AsyncHandler<CancelStepsRequest, CancelStepsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<CreateSecurityConfigurationResult> createSecurityConfigurationAsync(CreateSecurityConfigurationRequest request)
  {
    return createSecurityConfigurationAsync(request, null);
  }
  
  public Future<CreateSecurityConfigurationResult> createSecurityConfigurationAsync(CreateSecurityConfigurationRequest request, AsyncHandler<CreateSecurityConfigurationRequest, CreateSecurityConfigurationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteSecurityConfigurationResult> deleteSecurityConfigurationAsync(DeleteSecurityConfigurationRequest request)
  {
    return deleteSecurityConfigurationAsync(request, null);
  }
  
  public Future<DeleteSecurityConfigurationResult> deleteSecurityConfigurationAsync(DeleteSecurityConfigurationRequest request, AsyncHandler<DeleteSecurityConfigurationRequest, DeleteSecurityConfigurationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeClusterResult> describeClusterAsync(DescribeClusterRequest request)
  {
    return describeClusterAsync(request, null);
  }
  
  public Future<DescribeClusterResult> describeClusterAsync(DescribeClusterRequest request, AsyncHandler<DescribeClusterRequest, DescribeClusterResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public Future<DescribeJobFlowsResult> describeJobFlowsAsync(DescribeJobFlowsRequest request)
  {
    return describeJobFlowsAsync(request, null);
  }
  
  @Deprecated
  public Future<DescribeJobFlowsResult> describeJobFlowsAsync(DescribeJobFlowsRequest request, AsyncHandler<DescribeJobFlowsRequest, DescribeJobFlowsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<DescribeSecurityConfigurationResult> describeSecurityConfigurationAsync(DescribeSecurityConfigurationRequest request, AsyncHandler<DescribeSecurityConfigurationRequest, DescribeSecurityConfigurationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeStepResult> describeStepAsync(DescribeStepRequest request)
  {
    return describeStepAsync(request, null);
  }
  
  public Future<DescribeStepResult> describeStepAsync(DescribeStepRequest request, AsyncHandler<DescribeStepRequest, DescribeStepResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetBlockPublicAccessConfigurationResult> getBlockPublicAccessConfigurationAsync(GetBlockPublicAccessConfigurationRequest request)
  {
    return getBlockPublicAccessConfigurationAsync(request, null);
  }
  
  public Future<GetBlockPublicAccessConfigurationResult> getBlockPublicAccessConfigurationAsync(GetBlockPublicAccessConfigurationRequest request, AsyncHandler<GetBlockPublicAccessConfigurationRequest, GetBlockPublicAccessConfigurationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListBootstrapActionsResult> listBootstrapActionsAsync(ListBootstrapActionsRequest request)
  {
    return listBootstrapActionsAsync(request, null);
  }
  
  public Future<ListBootstrapActionsResult> listBootstrapActionsAsync(ListBootstrapActionsRequest request, AsyncHandler<ListBootstrapActionsRequest, ListBootstrapActionsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListClustersResult> listClustersAsync(ListClustersRequest request)
  {
    return listClustersAsync(request, null);
  }
  
  public Future<ListClustersResult> listClustersAsync(ListClustersRequest request, AsyncHandler<ListClustersRequest, ListClustersResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<ListInstanceFleetsResult> listInstanceFleetsAsync(ListInstanceFleetsRequest request, AsyncHandler<ListInstanceFleetsRequest, ListInstanceFleetsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListInstanceGroupsResult> listInstanceGroupsAsync(ListInstanceGroupsRequest request)
  {
    return listInstanceGroupsAsync(request, null);
  }
  
  public Future<ListInstanceGroupsResult> listInstanceGroupsAsync(ListInstanceGroupsRequest request, AsyncHandler<ListInstanceGroupsRequest, ListInstanceGroupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListInstancesResult> listInstancesAsync(ListInstancesRequest request)
  {
    return listInstancesAsync(request, null);
  }
  
  public Future<ListInstancesResult> listInstancesAsync(ListInstancesRequest request, AsyncHandler<ListInstancesRequest, ListInstancesResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListSecurityConfigurationsResult> listSecurityConfigurationsAsync(ListSecurityConfigurationsRequest request)
  {
    return listSecurityConfigurationsAsync(request, null);
  }
  
  public Future<ListSecurityConfigurationsResult> listSecurityConfigurationsAsync(ListSecurityConfigurationsRequest request, AsyncHandler<ListSecurityConfigurationsRequest, ListSecurityConfigurationsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListStepsResult> listStepsAsync(ListStepsRequest request)
  {
    return listStepsAsync(request, null);
  }
  
  public Future<ListStepsResult> listStepsAsync(ListStepsRequest request, AsyncHandler<ListStepsRequest, ListStepsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ModifyInstanceFleetResult> modifyInstanceFleetAsync(ModifyInstanceFleetRequest request)
  {
    return modifyInstanceFleetAsync(request, null);
  }
  
  public Future<ModifyInstanceFleetResult> modifyInstanceFleetAsync(ModifyInstanceFleetRequest request, AsyncHandler<ModifyInstanceFleetRequest, ModifyInstanceFleetResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(ModifyInstanceGroupsRequest request)
  {
    return modifyInstanceGroupsAsync(request, null);
  }
  
  public Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(ModifyInstanceGroupsRequest request, AsyncHandler<ModifyInstanceGroupsRequest, ModifyInstanceGroupsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
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
  
  public Future<PutAutoScalingPolicyResult> putAutoScalingPolicyAsync(PutAutoScalingPolicyRequest request, AsyncHandler<PutAutoScalingPolicyRequest, PutAutoScalingPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutBlockPublicAccessConfigurationResult> putBlockPublicAccessConfigurationAsync(PutBlockPublicAccessConfigurationRequest request)
  {
    return putBlockPublicAccessConfigurationAsync(request, null);
  }
  
  public Future<PutBlockPublicAccessConfigurationResult> putBlockPublicAccessConfigurationAsync(PutBlockPublicAccessConfigurationRequest request, AsyncHandler<PutBlockPublicAccessConfigurationRequest, PutBlockPublicAccessConfigurationResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RemoveAutoScalingPolicyResult> removeAutoScalingPolicyAsync(RemoveAutoScalingPolicyRequest request)
  {
    return removeAutoScalingPolicyAsync(request, null);
  }
  
  public Future<RemoveAutoScalingPolicyResult> removeAutoScalingPolicyAsync(RemoveAutoScalingPolicyRequest request, AsyncHandler<RemoveAutoScalingPolicyRequest, RemoveAutoScalingPolicyResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RemoveTagsResult> removeTagsAsync(RemoveTagsRequest request)
  {
    return removeTagsAsync(request, null);
  }
  
  public Future<RemoveTagsResult> removeTagsAsync(RemoveTagsRequest request, AsyncHandler<RemoveTagsRequest, RemoveTagsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<RunJobFlowResult> runJobFlowAsync(RunJobFlowRequest request)
  {
    return runJobFlowAsync(request, null);
  }
  
  public Future<RunJobFlowResult> runJobFlowAsync(RunJobFlowRequest request, AsyncHandler<RunJobFlowRequest, RunJobFlowResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SetTerminationProtectionResult> setTerminationProtectionAsync(SetTerminationProtectionRequest request)
  {
    return setTerminationProtectionAsync(request, null);
  }
  
  public Future<SetTerminationProtectionResult> setTerminationProtectionAsync(SetTerminationProtectionRequest request, AsyncHandler<SetTerminationProtectionRequest, SetTerminationProtectionResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SetVisibleToAllUsersResult> setVisibleToAllUsersAsync(SetVisibleToAllUsersRequest request)
  {
    return setVisibleToAllUsersAsync(request, null);
  }
  
  public Future<SetVisibleToAllUsersResult> setVisibleToAllUsersAsync(SetVisibleToAllUsersRequest request, AsyncHandler<SetVisibleToAllUsersRequest, SetVisibleToAllUsersResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TerminateJobFlowsResult> terminateJobFlowsAsync(TerminateJobFlowsRequest request)
  {
    return terminateJobFlowsAsync(request, null);
  }
  
  public Future<TerminateJobFlowsResult> terminateJobFlowsAsync(TerminateJobFlowsRequest request, AsyncHandler<TerminateJobFlowsRequest, TerminateJobFlowsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AbstractAmazonElasticMapReduceAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */