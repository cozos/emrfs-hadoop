package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBSaveExpression
{
  private Map<String, ExpectedAttributeValue> expectedAttributes;
  private String conditionalOperator;
  
  public Map<String, ExpectedAttributeValue> getExpected()
  {
    return expectedAttributes;
  }
  
  public void setExpected(Map<String, ExpectedAttributeValue> expectedAttributes)
  {
    this.expectedAttributes = expectedAttributes;
  }
  
  public DynamoDBSaveExpression withExpected(Map<String, ExpectedAttributeValue> expectedAttributes)
  {
    setExpected(expectedAttributes);
    return this;
  }
  
  public DynamoDBSaveExpression withExpectedEntry(String attributeName, ExpectedAttributeValue expected)
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
  
  public DynamoDBSaveExpression withConditionalOperator(String conditionalOperator)
  {
    setConditionalOperator(conditionalOperator);
    return this;
  }
  
  public void setConditionalOperator(ConditionalOperator conditionalOperator)
  {
    setConditionalOperator(conditionalOperator.toString());
  }
  
  public DynamoDBSaveExpression withConditionalOperator(ConditionalOperator conditionalOperator)
  {
    return withConditionalOperator(conditionalOperator.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */