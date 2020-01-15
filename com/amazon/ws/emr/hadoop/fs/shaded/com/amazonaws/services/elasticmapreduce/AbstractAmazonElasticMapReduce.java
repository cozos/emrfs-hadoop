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

public class AbstractAmazonElasticMapReduce
  implements AmazonElasticMapReduce
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddInstanceFleetResult addInstanceFleet(AddInstanceFleetRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddInstanceGroupsResult addInstanceGroups(AddInstanceGroupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddJobFlowStepsResult addJobFlowSteps(AddJobFlowStepsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AddTagsResult addTags(AddTagsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CancelStepsResult cancelSteps(CancelStepsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public CreateSecurityConfigurationResult createSecurityConfiguration(CreateSecurityConfigurationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteSecurityConfigurationResult deleteSecurityConfiguration(DeleteSecurityConfigurationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeClusterResult describeCluster(DescribeClusterRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public DescribeJobFlowsResult describeJobFlows(DescribeJobFlowsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public DescribeJobFlowsResult describeJobFlows()
  {
    return describeJobFlows(new DescribeJobFlowsRequest());
  }
  
  public DescribeSecurityConfigurationResult describeSecurityConfiguration(DescribeSecurityConfigurationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeStepResult describeStep(DescribeStepRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetBlockPublicAccessConfigurationResult getBlockPublicAccessConfiguration(GetBlockPublicAccessConfigurationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListBootstrapActionsResult listBootstrapActions(ListBootstrapActionsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListClustersResult listClusters(ListClustersRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListClustersResult listClusters()
  {
    return listClusters(new ListClustersRequest());
  }
  
  public ListInstanceFleetsResult listInstanceFleets(ListInstanceFleetsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListInstanceGroupsResult listInstanceGroups(ListInstanceGroupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListInstancesResult listInstances(ListInstancesRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListSecurityConfigurationsResult listSecurityConfigurations(ListSecurityConfigurationsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListStepsResult listSteps(ListStepsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ModifyInstanceFleetResult modifyInstanceFleet(ModifyInstanceFleetRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ModifyInstanceGroupsResult modifyInstanceGroups(ModifyInstanceGroupsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ModifyInstanceGroupsResult modifyInstanceGroups()
  {
    return modifyInstanceGroups(new ModifyInstanceGroupsRequest());
  }
  
  public PutAutoScalingPolicyResult putAutoScalingPolicy(PutAutoScalingPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutBlockPublicAccessConfigurationResult putBlockPublicAccessConfiguration(PutBlockPublicAccessConfigurationRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RemoveAutoScalingPolicyResult removeAutoScalingPolicy(RemoveAutoScalingPolicyRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RemoveTagsResult removeTags(RemoveTagsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public RunJobFlowResult runJobFlow(RunJobFlowRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SetTerminationProtectionResult setTerminationProtection(SetTerminationProtectionRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SetVisibleToAllUsersResult setVisibleToAllUsers(SetVisibleToAllUsersRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TerminateJobFlowsResult terminateJobFlows(TerminateJobFlowsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AmazonElasticMapReduceWaiters waiters()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AbstractAmazonElasticMapReduce
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */