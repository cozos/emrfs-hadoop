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

public abstract interface AmazonElasticMapReduceAsync
  extends AmazonElasticMapReduce
{
  public abstract Future<AddInstanceFleetResult> addInstanceFleetAsync(AddInstanceFleetRequest paramAddInstanceFleetRequest);
  
  public abstract Future<AddInstanceFleetResult> addInstanceFleetAsync(AddInstanceFleetRequest paramAddInstanceFleetRequest, AsyncHandler<AddInstanceFleetRequest, AddInstanceFleetResult> paramAsyncHandler);
  
  public abstract Future<AddInstanceGroupsResult> addInstanceGroupsAsync(AddInstanceGroupsRequest paramAddInstanceGroupsRequest);
  
  public abstract Future<AddInstanceGroupsResult> addInstanceGroupsAsync(AddInstanceGroupsRequest paramAddInstanceGroupsRequest, AsyncHandler<AddInstanceGroupsRequest, AddInstanceGroupsResult> paramAsyncHandler);
  
  public abstract Future<AddJobFlowStepsResult> addJobFlowStepsAsync(AddJobFlowStepsRequest paramAddJobFlowStepsRequest);
  
  public abstract Future<AddJobFlowStepsResult> addJobFlowStepsAsync(AddJobFlowStepsRequest paramAddJobFlowStepsRequest, AsyncHandler<AddJobFlowStepsRequest, AddJobFlowStepsResult> paramAsyncHandler);
  
  public abstract Future<AddTagsResult> addTagsAsync(AddTagsRequest paramAddTagsRequest);
  
  public abstract Future<AddTagsResult> addTagsAsync(AddTagsRequest paramAddTagsRequest, AsyncHandler<AddTagsRequest, AddTagsResult> paramAsyncHandler);
  
  public abstract Future<CancelStepsResult> cancelStepsAsync(CancelStepsRequest paramCancelStepsRequest);
  
  public abstract Future<CancelStepsResult> cancelStepsAsync(CancelStepsRequest paramCancelStepsRequest, AsyncHandler<CancelStepsRequest, CancelStepsResult> paramAsyncHandler);
  
  public abstract Future<CreateSecurityConfigurationResult> createSecurityConfigurationAsync(CreateSecurityConfigurationRequest paramCreateSecurityConfigurationRequest);
  
  public abstract Future<CreateSecurityConfigurationResult> createSecurityConfigurationAsync(CreateSecurityConfigurationRequest paramCreateSecurityConfigurationRequest, AsyncHandler<CreateSecurityConfigurationRequest, CreateSecurityConfigurationResult> paramAsyncHandler);
  
  public abstract Future<DeleteSecurityConfigurationResult> deleteSecurityConfigurationAsync(DeleteSecurityConfigurationRequest paramDeleteSecurityConfigurationRequest);
  
  public abstract Future<DeleteSecurityConfigurationResult> deleteSecurityConfigurationAsync(DeleteSecurityConfigurationRequest paramDeleteSecurityConfigurationRequest, AsyncHandler<DeleteSecurityConfigurationRequest, DeleteSecurityConfigurationResult> paramAsyncHandler);
  
  public abstract Future<DescribeClusterResult> describeClusterAsync(DescribeClusterRequest paramDescribeClusterRequest);
  
  public abstract Future<DescribeClusterResult> describeClusterAsync(DescribeClusterRequest paramDescribeClusterRequest, AsyncHandler<DescribeClusterRequest, DescribeClusterResult> paramAsyncHandler);
  
  @Deprecated
  public abstract Future<DescribeJobFlowsResult> describeJobFlowsAsync(DescribeJobFlowsRequest paramDescribeJobFlowsRequest);
  
  @Deprecated
  public abstract Future<DescribeJobFlowsResult> describeJobFlowsAsync(DescribeJobFlowsRequest paramDescribeJobFlowsRequest, AsyncHandler<DescribeJobFlowsRequest, DescribeJobFlowsResult> paramAsyncHandler);
  
  @Deprecated
  public abstract Future<DescribeJobFlowsResult> describeJobFlowsAsync();
  
  @Deprecated
  public abstract Future<DescribeJobFlowsResult> describeJobFlowsAsync(AsyncHandler<DescribeJobFlowsRequest, DescribeJobFlowsResult> paramAsyncHandler);
  
  public abstract Future<DescribeSecurityConfigurationResult> describeSecurityConfigurationAsync(DescribeSecurityConfigurationRequest paramDescribeSecurityConfigurationRequest);
  
  public abstract Future<DescribeSecurityConfigurationResult> describeSecurityConfigurationAsync(DescribeSecurityConfigurationRequest paramDescribeSecurityConfigurationRequest, AsyncHandler<DescribeSecurityConfigurationRequest, DescribeSecurityConfigurationResult> paramAsyncHandler);
  
  public abstract Future<DescribeStepResult> describeStepAsync(DescribeStepRequest paramDescribeStepRequest);
  
  public abstract Future<DescribeStepResult> describeStepAsync(DescribeStepRequest paramDescribeStepRequest, AsyncHandler<DescribeStepRequest, DescribeStepResult> paramAsyncHandler);
  
  public abstract Future<GetBlockPublicAccessConfigurationResult> getBlockPublicAccessConfigurationAsync(GetBlockPublicAccessConfigurationRequest paramGetBlockPublicAccessConfigurationRequest);
  
  public abstract Future<GetBlockPublicAccessConfigurationResult> getBlockPublicAccessConfigurationAsync(GetBlockPublicAccessConfigurationRequest paramGetBlockPublicAccessConfigurationRequest, AsyncHandler<GetBlockPublicAccessConfigurationRequest, GetBlockPublicAccessConfigurationResult> paramAsyncHandler);
  
  public abstract Future<ListBootstrapActionsResult> listBootstrapActionsAsync(ListBootstrapActionsRequest paramListBootstrapActionsRequest);
  
  public abstract Future<ListBootstrapActionsResult> listBootstrapActionsAsync(ListBootstrapActionsRequest paramListBootstrapActionsRequest, AsyncHandler<ListBootstrapActionsRequest, ListBootstrapActionsResult> paramAsyncHandler);
  
  public abstract Future<ListClustersResult> listClustersAsync(ListClustersRequest paramListClustersRequest);
  
  public abstract Future<ListClustersResult> listClustersAsync(ListClustersRequest paramListClustersRequest, AsyncHandler<ListClustersRequest, ListClustersResult> paramAsyncHandler);
  
  public abstract Future<ListClustersResult> listClustersAsync();
  
  public abstract Future<ListClustersResult> listClustersAsync(AsyncHandler<ListClustersRequest, ListClustersResult> paramAsyncHandler);
  
  public abstract Future<ListInstanceFleetsResult> listInstanceFleetsAsync(ListInstanceFleetsRequest paramListInstanceFleetsRequest);
  
  public abstract Future<ListInstanceFleetsResult> listInstanceFleetsAsync(ListInstanceFleetsRequest paramListInstanceFleetsRequest, AsyncHandler<ListInstanceFleetsRequest, ListInstanceFleetsResult> paramAsyncHandler);
  
  public abstract Future<ListInstanceGroupsResult> listInstanceGroupsAsync(ListInstanceGroupsRequest paramListInstanceGroupsRequest);
  
  public abstract Future<ListInstanceGroupsResult> listInstanceGroupsAsync(ListInstanceGroupsRequest paramListInstanceGroupsRequest, AsyncHandler<ListInstanceGroupsRequest, ListInstanceGroupsResult> paramAsyncHandler);
  
  public abstract Future<ListInstancesResult> listInstancesAsync(ListInstancesRequest paramListInstancesRequest);
  
  public abstract Future<ListInstancesResult> listInstancesAsync(ListInstancesRequest paramListInstancesRequest, AsyncHandler<ListInstancesRequest, ListInstancesResult> paramAsyncHandler);
  
  public abstract Future<ListSecurityConfigurationsResult> listSecurityConfigurationsAsync(ListSecurityConfigurationsRequest paramListSecurityConfigurationsRequest);
  
  public abstract Future<ListSecurityConfigurationsResult> listSecurityConfigurationsAsync(ListSecurityConfigurationsRequest paramListSecurityConfigurationsRequest, AsyncHandler<ListSecurityConfigurationsRequest, ListSecurityConfigurationsResult> paramAsyncHandler);
  
  public abstract Future<ListStepsResult> listStepsAsync(ListStepsRequest paramListStepsRequest);
  
  public abstract Future<ListStepsResult> listStepsAsync(ListStepsRequest paramListStepsRequest, AsyncHandler<ListStepsRequest, ListStepsResult> paramAsyncHandler);
  
  public abstract Future<ModifyInstanceFleetResult> modifyInstanceFleetAsync(ModifyInstanceFleetRequest paramModifyInstanceFleetRequest);
  
  public abstract Future<ModifyInstanceFleetResult> modifyInstanceFleetAsync(ModifyInstanceFleetRequest paramModifyInstanceFleetRequest, AsyncHandler<ModifyInstanceFleetRequest, ModifyInstanceFleetResult> paramAsyncHandler);
  
  public abstract Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(ModifyInstanceGroupsRequest paramModifyInstanceGroupsRequest);
  
  public abstract Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(ModifyInstanceGroupsRequest paramModifyInstanceGroupsRequest, AsyncHandler<ModifyInstanceGroupsRequest, ModifyInstanceGroupsResult> paramAsyncHandler);
  
  public abstract Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync();
  
  public abstract Future<ModifyInstanceGroupsResult> modifyInstanceGroupsAsync(AsyncHandler<ModifyInstanceGroupsRequest, ModifyInstanceGroupsResult> paramAsyncHandler);
  
  public abstract Future<PutAutoScalingPolicyResult> putAutoScalingPolicyAsync(PutAutoScalingPolicyRequest paramPutAutoScalingPolicyRequest);
  
  public abstract Future<PutAutoScalingPolicyResult> putAutoScalingPolicyAsync(PutAutoScalingPolicyRequest paramPutAutoScalingPolicyRequest, AsyncHandler<PutAutoScalingPolicyRequest, PutAutoScalingPolicyResult> paramAsyncHandler);
  
  public abstract Future<PutBlockPublicAccessConfigurationResult> putBlockPublicAccessConfigurationAsync(PutBlockPublicAccessConfigurationRequest paramPutBlockPublicAccessConfigurationRequest);
  
  public abstract Future<PutBlockPublicAccessConfigurationResult> putBlockPublicAccessConfigurationAsync(PutBlockPublicAccessConfigurationRequest paramPutBlockPublicAccessConfigurationRequest, AsyncHandler<PutBlockPublicAccessConfigurationRequest, PutBlockPublicAccessConfigurationResult> paramAsyncHandler);
  
  public abstract Future<RemoveAutoScalingPolicyResult> removeAutoScalingPolicyAsync(RemoveAutoScalingPolicyRequest paramRemoveAutoScalingPolicyRequest);
  
  public abstract Future<RemoveAutoScalingPolicyResult> removeAutoScalingPolicyAsync(RemoveAutoScalingPolicyRequest paramRemoveAutoScalingPolicyRequest, AsyncHandler<RemoveAutoScalingPolicyRequest, RemoveAutoScalingPolicyResult> paramAsyncHandler);
  
  public abstract Future<RemoveTagsResult> removeTagsAsync(RemoveTagsRequest paramRemoveTagsRequest);
  
  public abstract Future<RemoveTagsResult> removeTagsAsync(RemoveTagsRequest paramRemoveTagsRequest, AsyncHandler<RemoveTagsRequest, RemoveTagsResult> paramAsyncHandler);
  
  public abstract Future<RunJobFlowResult> runJobFlowAsync(RunJobFlowRequest paramRunJobFlowRequest);
  
  public abstract Future<RunJobFlowResult> runJobFlowAsync(RunJobFlowRequest paramRunJobFlowRequest, AsyncHandler<RunJobFlowRequest, RunJobFlowResult> paramAsyncHandler);
  
  public abstract Future<SetTerminationProtectionResult> setTerminationProtectionAsync(SetTerminationProtectionRequest paramSetTerminationProtectionRequest);
  
  public abstract Future<SetTerminationProtectionResult> setTerminationProtectionAsync(SetTerminationProtectionRequest paramSetTerminationProtectionRequest, AsyncHandler<SetTerminationProtectionRequest, SetTerminationProtectionResult> paramAsyncHandler);
  
  public abstract Future<SetVisibleToAllUsersResult> setVisibleToAllUsersAsync(SetVisibleToAllUsersRequest paramSetVisibleToAllUsersRequest);
  
  public abstract Future<SetVisibleToAllUsersResult> setVisibleToAllUsersAsync(SetVisibleToAllUsersRequest paramSetVisibleToAllUsersRequest, AsyncHandler<SetVisibleToAllUsersRequest, SetVisibleToAllUsersResult> paramAsyncHandler);
  
  public abstract Future<TerminateJobFlowsResult> terminateJobFlowsAsync(TerminateJobFlowsRequest paramTerminateJobFlowsRequest);
  
  public abstract Future<TerminateJobFlowsResult> terminateJobFlowsAsync(TerminateJobFlowsRequest paramTerminateJobFlowsRequest, AsyncHandler<TerminateJobFlowsRequest, TerminateJobFlowsResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */