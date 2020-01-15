package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
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
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters.AmazonElasticMapReduceWaiters;

public abstract interface AmazonElasticMapReduce
{
  public static final String ENDPOINT_PREFIX = "elasticmapreduce";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract AddInstanceFleetResult addInstanceFleet(AddInstanceFleetRequest paramAddInstanceFleetRequest);
  
  public abstract AddInstanceGroupsResult addInstanceGroups(AddInstanceGroupsRequest paramAddInstanceGroupsRequest);
  
  public abstract AddJobFlowStepsResult addJobFlowSteps(AddJobFlowStepsRequest paramAddJobFlowStepsRequest);
  
  public abstract AddTagsResult addTags(AddTagsRequest paramAddTagsRequest);
  
  public abstract CancelStepsResult cancelSteps(CancelStepsRequest paramCancelStepsRequest);
  
  public abstract CreateSecurityConfigurationResult createSecurityConfiguration(CreateSecurityConfigurationRequest paramCreateSecurityConfigurationRequest);
  
  public abstract DeleteSecurityConfigurationResult deleteSecurityConfiguration(DeleteSecurityConfigurationRequest paramDeleteSecurityConfigurationRequest);
  
  public abstract DescribeClusterResult describeCluster(DescribeClusterRequest paramDescribeClusterRequest);
  
  @Deprecated
  public abstract DescribeJobFlowsResult describeJobFlows(DescribeJobFlowsRequest paramDescribeJobFlowsRequest);
  
  @Deprecated
  public abstract DescribeJobFlowsResult describeJobFlows();
  
  public abstract DescribeSecurityConfigurationResult describeSecurityConfiguration(DescribeSecurityConfigurationRequest paramDescribeSecurityConfigurationRequest);
  
  public abstract DescribeStepResult describeStep(DescribeStepRequest paramDescribeStepRequest);
  
  public abstract GetBlockPublicAccessConfigurationResult getBlockPublicAccessConfiguration(GetBlockPublicAccessConfigurationRequest paramGetBlockPublicAccessConfigurationRequest);
  
  public abstract ListBootstrapActionsResult listBootstrapActions(ListBootstrapActionsRequest paramListBootstrapActionsRequest);
  
  public abstract ListClustersResult listClusters(ListClustersRequest paramListClustersRequest);
  
  public abstract ListClustersResult listClusters();
  
  public abstract ListInstanceFleetsResult listInstanceFleets(ListInstanceFleetsRequest paramListInstanceFleetsRequest);
  
  public abstract ListInstanceGroupsResult listInstanceGroups(ListInstanceGroupsRequest paramListInstanceGroupsRequest);
  
  public abstract ListInstancesResult listInstances(ListInstancesRequest paramListInstancesRequest);
  
  public abstract ListSecurityConfigurationsResult listSecurityConfigurations(ListSecurityConfigurationsRequest paramListSecurityConfigurationsRequest);
  
  public abstract ListStepsResult listSteps(ListStepsRequest paramListStepsRequest);
  
  public abstract ModifyInstanceFleetResult modifyInstanceFleet(ModifyInstanceFleetRequest paramModifyInstanceFleetRequest);
  
  public abstract ModifyInstanceGroupsResult modifyInstanceGroups(ModifyInstanceGroupsRequest paramModifyInstanceGroupsRequest);
  
  public abstract ModifyInstanceGroupsResult modifyInstanceGroups();
  
  public abstract PutAutoScalingPolicyResult putAutoScalingPolicy(PutAutoScalingPolicyRequest paramPutAutoScalingPolicyRequest);
  
  public abstract PutBlockPublicAccessConfigurationResult putBlockPublicAccessConfiguration(PutBlockPublicAccessConfigurationRequest paramPutBlockPublicAccessConfigurationRequest);
  
  public abstract RemoveAutoScalingPolicyResult removeAutoScalingPolicy(RemoveAutoScalingPolicyRequest paramRemoveAutoScalingPolicyRequest);
  
  public abstract RemoveTagsResult removeTags(RemoveTagsRequest paramRemoveTagsRequest);
  
  public abstract RunJobFlowResult runJobFlow(RunJobFlowRequest paramRunJobFlowRequest);
  
  public abstract SetTerminationProtectionResult setTerminationProtection(SetTerminationProtectionRequest paramSetTerminationProtectionRequest);
  
  public abstract SetVisibleToAllUsersResult setVisibleToAllUsers(SetVisibleToAllUsersRequest paramSetVisibleToAllUsersRequest);
  
  public abstract TerminateJobFlowsResult terminateJobFlows(TerminateJobFlowsRequest paramTerminateJobFlowsRequest);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  public abstract AmazonElasticMapReduceWaiters waiters();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */