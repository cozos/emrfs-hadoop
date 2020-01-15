package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

abstract interface StandardModelFactories$Rule<T>
{
  public abstract boolean isAssignableFrom(ConvertibleType<?> paramConvertibleType);
  
  public abstract DynamoDBTypeConverter<AttributeValue, T> newConverter(ConvertibleType<T> paramConvertibleType);
  
  public abstract DynamoDBMapperFieldModel.DynamoDBAttributeType getAttributeType();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardModelFactories.Rule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */