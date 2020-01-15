package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.Collections;
import java.util.Map;

class AttributeTransformerChain$ProxyParameters<T>
  implements AttributeTransformer.Parameters<T>
{
  private final AttributeTransformer.Parameters<T> delegate;
  private Map<String, AttributeValue> values;
  
  public AttributeTransformerChain$ProxyParameters(AttributeTransformer.Parameters<T> delegate)
  {
    this.delegate = delegate;
    values = delegate.getAttributeValues();
  }
  
  public Map<String, AttributeValue> getAttributeValues()
  {
    return values;
  }
  
  public void setAttributeValues(Map<String, AttributeValue> values)
  {
    this.values = Collections.unmodifiableMap(values);
  }
  
  public boolean isPartialUpdate()
  {
    return delegate.isPartialUpdate();
  }
  
  public Class<T> getModelClass()
  {
    return delegate.getModelClass();
  }
  
  public DynamoDBMapperConfig getMapperConfig()
  {
    return delegate.getMapperConfig();
  }
  
  public String getTableName()
  {
    return delegate.getTableName();
  }
  
  public String getHashKeyName()
  {
    return delegate.getHashKeyName();
  }
  
  public String getRangeKeyName()
  {
    return delegate.getRangeKeyName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.AttributeTransformerChain.ProxyParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */