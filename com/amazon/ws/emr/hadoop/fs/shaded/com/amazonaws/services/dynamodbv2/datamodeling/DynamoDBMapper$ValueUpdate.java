package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

final class DynamoDBMapper$ValueUpdate
{
  private final DynamoDBMapperFieldModel<Object, Object> field;
  private final AttributeValue newValue;
  private final Object target;
  
  public DynamoDBMapper$ValueUpdate(DynamoDBMapperFieldModel<Object, Object> arg1, AttributeValue field, Object newValue)
  {
    this.field = field;
    this.newValue = newValue;
    this.target = target;
  }
  
  public void apply()
  {
    field.set(target, field.unconvert(newValue));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.ValueUpdate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */