package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

class StandardModelFactories$Rules$NotSupported
  extends StandardModelFactories.AbstractRule<T, T>
{
  private StandardModelFactories$Rules$NotSupported(StandardModelFactories.Rules paramRules)
  {
    super(DynamoDBMapperFieldModel.DynamoDBAttributeType.NULL, false);
  }
  
  public DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> type)
  {
    return this;
  }
  
  public T get(AttributeValue value)
  {
    throw new DynamoDBMappingException("not supported; requires @DynamoDBTyped or @DynamoDBTypeConverted");
  }
  
  public void set(AttributeValue value, T o)
  {
    throw new DynamoDBMappingException("not supported; requires @DynamoDBTyped or @DynamoDBTypeConverted");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rules.NotSupported
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */