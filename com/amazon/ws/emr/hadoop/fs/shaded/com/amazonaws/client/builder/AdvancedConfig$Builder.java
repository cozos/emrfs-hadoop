package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import java.util.HashMap;
import java.util.Map;

public class AdvancedConfig$Builder
{
  private final Map<AdvancedConfig.Key<?>, Object> config = new HashMap();
  
  public <T> T get(AdvancedConfig.Key<T> key)
  {
    return (T)config.get(key);
  }
  
  public <T> Builder put(AdvancedConfig.Key<T> key, T value)
  {
    config.put(key, value);
    return this;
  }
  
  public AdvancedConfig build()
  {
    return new AdvancedConfig(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */