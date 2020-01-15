package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Action;

public enum DynamoDBv2Actions
  implements Action
{
  AllDynamoDBv2Actions("dynamodb:*"),  BatchGetItem("dynamodb:BatchGetItem"),  BatchWriteItem("dynamodb:BatchWriteItem"),  CreateBackup("dynamodb:CreateBackup"),  CreateGlobalTable("dynamodb:CreateGlobalTable"),  CreateTable("dynamodb:CreateTable"),  DeleteBackup("dynamodb:DeleteBackup"),  DeleteItem("dynamodb:DeleteItem"),  DeleteTable("dynamodb:DeleteTable"),  DescribeBackup("dynamodb:DescribeBackup"),  DescribeContinuousBackups("dynamodb:DescribeContinuousBackups"),  DescribeEndpoints("dynamodb:DescribeEndpoints"),  DescribeGlobalTable("dynamodb:DescribeGlobalTable"),  DescribeGlobalTableSettings("dynamodb:DescribeGlobalTableSettings"),  DescribeLimits("dynamodb:DescribeLimits"),  DescribeTable("dynamodb:DescribeTable"),  DescribeTimeToLive("dynamodb:DescribeTimeToLive"),  GetItem("dynamodb:GetItem"),  ListBackups("dynamodb:ListBackups"),  ListGlobalTables("dynamodb:ListGlobalTables"),  ListTables("dynamodb:ListTables"),  ListTagsOfResource("dynamodb:ListTagsOfResource"),  PutItem("dynamodb:PutItem"),  Query("dynamodb:Query"),  RestoreTableFromBackup("dynamodb:RestoreTableFromBackup"),  RestoreTableToPointInTime("dynamodb:RestoreTableToPointInTime"),  Scan("dynamodb:Scan"),  TagResource("dynamodb:TagResource"),  TransactGetItems("dynamodb:TransactGetItems"),  TransactWriteItems("dynamodb:TransactWriteItems"),  UntagResource("dynamodb:UntagResource"),  UpdateContinuousBackups("dynamodb:UpdateContinuousBackups"),  UpdateGlobalTable("dynamodb:UpdateGlobalTable"),  UpdateGlobalTableSettings("dynamodb:UpdateGlobalTableSettings"),  UpdateItem("dynamodb:UpdateItem"),  UpdateTable("dynamodb:UpdateTable"),  UpdateTimeToLive("dynamodb:UpdateTimeToLive");
  
  private final String action;
  
  private DynamoDBv2Actions(String action)
  {
    this.action = action;
  }
  
  public String getActionName()
  {
    return action;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.actions.DynamoDBv2Actions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */