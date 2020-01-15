package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

public class DynamoDBTransactionWriteExpression
{
  private String conditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  
  public DynamoDBTransactionWriteExpression withConditionExpression(String conditionExpression)
  {
    this.conditionExpression = conditionExpression;
    return this;
  }
  
  public String getConditionExpression()
  {
    return conditionExpression;
  }
  
  public DynamoDBTransactionWriteExpression withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    this.expressionAttributeNames = expressionAttributeNames;
    return this;
  }
  
  public Map<String, String> getExpressionAttributeNames()
  {
    return expressionAttributeNames;
  }
  
  public DynamoDBTransactionWriteExpression withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    this.expressionAttributeValues = expressionAttributeValues;
    return this;
  }
  
  public Map<String, AttributeValue> getExpressionAttributeValues()
  {
    return expressionAttributeValues;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTransactionWriteExpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */