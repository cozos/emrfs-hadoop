package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Map;

public abstract interface AttributeTransformer$Parameters<T>
{
  public abstract Map<String, AttributeValue> getAttributeValues();
  
  public abstract boolean isPartialUpdate();
  
  public abstract Class<T> getModelClass();
  
  public abstract DynamoDBMapperConfig getMapperConfig();
  
  public abstract String getTableName();
  
  public abstract String getHashKeyName();
  
  public abstract String getRangeKeyName();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.AttributeTransformer.Parameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */