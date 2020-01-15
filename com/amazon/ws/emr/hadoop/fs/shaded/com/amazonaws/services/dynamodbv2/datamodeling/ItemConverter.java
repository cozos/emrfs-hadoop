package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.util.Map;

public abstract interface ItemConverter
{
  public abstract DynamoDBMapperFieldModel getFieldModel(Method paramMethod);
  
  public abstract AttributeValue convert(Method paramMethod, Object paramObject);
  
  public abstract Map<String, AttributeValue> convert(Object paramObject);
  
  public abstract Object unconvert(Method paramMethod1, Method paramMethod2, AttributeValue paramAttributeValue);
  
  public abstract <T> T unconvert(Class<T> paramClass, Map<String, AttributeValue> paramMap);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ItemConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */