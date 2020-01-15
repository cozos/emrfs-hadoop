package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBDeleteExpression
{
  private Map<String, ExpectedAttributeValue> expectedAttributes;
  private String conditionalOperator;
  private String conditionExpression;
  private Map<String, String> expressionAttributeNames;
  private Map<String, AttributeValue> expressionAttributeValues;
  
  public Map<String, ExpectedAttributeValue> getExpected()
  {
    return expectedAttributes;
  }
  
  public void setExpected(Map<String, ExpectedAttributeValue> expectedAttributes)
  {
    this.expectedAttributes = expectedAttributes;
  }
  
  public DynamoDBDeleteExpression withExpected(Map<String, ExpectedAttributeValue> expectedAttributes)
  {
    setExpected(expectedAttributes);
    return this;
  }
  
  public DynamoDBDeleteExpression withExpectedEntry(String attributeName, ExpectedAttributeValue expected)
  {
    if (expectedAttributes == null) {
      expectedAttributes = new HashMap();
    }
    expectedAttributes.put(attributeName, expected);
    return this;
  }
  
  public String getConditionalOperator()
  {
    return conditionalOperator;
  }
  
  public void setConditionalOperator(String conditionalOperator)
  {
    this.conditionalOperator = conditionalOperator;
  }
  
  public DynamoDBDeleteExpression withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    setConditionalOperator(conditionalOperator.toString());
  }
  
  public DynamoDBDeleteExpression withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    return withConditionalOperator(conditionalOperator.toString());
  }
  
  public String getConditionExpression()
  {
    return conditionExpression;
  }
  
  public void setConditionExpression(String conditionExpression)
  {
    this.conditionExpression = conditionExpression;
  }
  
  public DynamoDBDeleteExpression withConditionExpression(String conditionExpression)
  {
    this.conditionExpression = conditionExpression;
    return this;
  }
  
  public Map<String, String> getExpressionAttributeNames()
  {
    return expressionAttributeNames;
  }
  
  public void setExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    this.expressionAttributeNames = expressionAttributeNames;
  }
  
  public DynamoDBDeleteExpression withExpressionAttributeNames(Map<String, String> expressionAttributeNames)
  {
    setExpressionAttributeNames(expressionAttributeNames);
    return this;
  }
  
  public DynamoDBDeleteExpression addExpressionAttributeNamesEntry(String key, String value)
  {
    if (null == expressionAttributeNames) {
      expressionAttributeNames = new HashMap();
    }
    if (expressionAttributeNames.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    expressionAttributeNames.put(key, value);
    return this;
  }
  
  public DynamoDBDeleteExpression clearExpressionAttributeNamesEntries()
  {
    expressionAttributeNames = null;
    return this;
  }
  
  public Map<String, AttributeValue> getExpressionAttributeValues()
  {
    return expressionAttributeValues;
  }
  
  public void setExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    this.expressionAttributeValues = expressionAttributeValues;
  }
  
  public DynamoDBDeleteExpression withExpressionAttributeValues(Map<String, AttributeValue> expressionAttributeValues)
  {
    setExpressionAttributeValues(expressionAttributeValues);
    return this;
  }
  
  public DynamoDBDeleteExpression addExpressionAttributeValuesEntry(String key, AttributeValue value)
  {
    if (null == expressionAttributeValues) {
      expressionAttributeValues = new HashMap();
    }
    if (expressionAttributeValues.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    expressionAttributeValues.put(key, value);
    return this;
  }
  
  public DynamoDBDeleteExpression clearExpressionAttributeValuesEntries()
  {
    expressionAttributeValues = null;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */