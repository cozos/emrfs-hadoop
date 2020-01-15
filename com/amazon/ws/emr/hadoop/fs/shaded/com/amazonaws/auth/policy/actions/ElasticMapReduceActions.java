package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

public enum ElasticMapReduceActions
  implements Action
{
  AllElasticMapReduceActions("elasticmapreduce:*"),  AddInstanceFleet("elasticmapreduce:AddInstanceFleet"),  AddInstanceGroups("elasticmapreduce:AddInstanceGroups"),  AddJobFlowSteps("elasticmapreduce:AddJobFlowSteps"),  AddTags("elasticmapreduce:AddTags"),  CancelSteps("elasticmapreduce:CancelSteps"),  CreateSecurityConfiguration("elasticmapreduce:CreateSecurityConfiguration"),  DeleteSecurityConfiguration("elasticmapreduce:DeleteSecurityConfiguration"),  DescribeCluster("elasticmapreduce:DescribeCluster"),  DescribeJobFlows("elasticmapreduce:DescribeJobFlows"),  DescribeSecurityConfiguration("elasticmapreduce:DescribeSecurityConfiguration"),  DescribeStep("elasticmapreduce:DescribeStep"),  GetBlockPublicAccessConfiguration("elasticmapreduce:GetBlockPublicAccessConfiguration"),  ListBootstrapActions("elasticmapreduce:ListBootstrapActions"),  ListClusters("elasticmapreduce:ListClusters"),  ListInstanceFleets("elasticmapreduce:ListInstanceFleets"),  ListInstanceGroups("elasticmapreduce:ListInstanceGroups"),  ListInstances("elasticmapreduce:ListInstances"),  ListSecurityConfigurations("elasticmapreduce:ListSecurityConfigurations"),  ListSteps("elasticmapreduce:ListSteps"),  ModifyInstanceFleet("elasticmapreduce:ModifyInstanceFleet"),  ModifyInstanceGroups("elasticmapreduce:ModifyInstanceGroups"),  PutAutoScalingPolicy("elasticmapreduce:PutAutoScalingPolicy"),  PutBlockPublicAccessConfiguration("elasticmapreduce:PutBlockPublicAccessConfiguration"),  RemoveAutoScalingPolicy("elasticmapreduce:RemoveAutoScalingPolicy"),  RemoveTags("elasticmapreduce:RemoveTags"),  RunJobFlow("elasticmapreduce:RunJobFlow"),  SetTerminationProtection("elasticmapreduce:SetTerminationProtection"),  SetVisibleToAllUsers("elasticmapreduce:SetVisibleToAllUsers"),  TerminateJobFlows("elasticmapreduce:TerminateJobFlows");
  
  private final String action;
  
  private ElasticMapReduceActions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions.ElasticMapReduceActions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */