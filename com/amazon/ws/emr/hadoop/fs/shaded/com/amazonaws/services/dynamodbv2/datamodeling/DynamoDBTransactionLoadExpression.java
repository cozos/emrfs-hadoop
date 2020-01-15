package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.Map;

public class DynamoDBTransactionLoadExpression
{
  private String projectionExpression;
  private Map<String, String> expressionAttributeNames;
  
  public DynamoDBTransactionLoadExpression withProjectionExpression(String projectionExpression)
  {
    this.projectionExpression = projectionExpression;
    return this;
  }
  
  public String getProjectionExpression()
  {
    return projectionExpression;
  }
  
  public DynamoDBTransactionLoadExpression withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    this.expressionAttributeNames = expressionAttributeNames;
    return this;
  }
  
  public Map<String, String> getExpressionAttributeNames()
  {
    return expressionAttributeNames;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTransactionLoadExpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */