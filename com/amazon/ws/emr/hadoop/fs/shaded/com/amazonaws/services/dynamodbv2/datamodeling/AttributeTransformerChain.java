package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AttributeTransformerChain
  implements AttributeTransformer
{
  private final List<AttributeTransformer> transformers;
  
  public AttributeTransformerChain(AttributeTransformer... transformers)
  {
    this(Arrays.asList(transformers));
  }
  
  public AttributeTransformerChain(List<AttributeTransformer> transformers)
  {
    this.transformers = Collections.unmodifiableList(new ArrayList(transformers));
  }
  
  public List<AttributeTransformer> getTransformers()
  {
    return transformers;
  }
  
  public Map<String, AttributeValue> transform(AttributeTransformer.Parameters<?> parameters)
  {
    ProxyParameters<?> proxy = new ProxyParameters(parameters);
    for (int i = 0; i < transformers.size(); i++) {
      proxy.setAttributeValues(((AttributeTransformer)transformers.get(i)).transform(proxy));
    }
    return proxy.getAttributeValues();
  }
  
  public Map<String, AttributeValue> untransform(AttributeTransformer.Parameters<?> parameters)
  {
    ProxyParameters<?> proxy = new ProxyParameters(parameters);
    for (int i = transformers.size() - 1; i >= 0; i--) {
      proxy.setAttributeValues(((AttributeTransformer)transformers.get(i)).untransform(proxy));
    }
    return proxy.getAttributeValues();
  }
  
  public String toString()
  {
    return transformers.toString();
  }
  
  private static class ProxyParameters<T>
    implements AttributeTransformer.Parameters<T>
  {
    private final AttributeTransformer.Parameters<T> delegate;
    private Map<String, AttributeValue> values;
    
    public ProxyParameters(AttributeTransformer.Parameters<T> delegate)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.AttributeTransformerChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */