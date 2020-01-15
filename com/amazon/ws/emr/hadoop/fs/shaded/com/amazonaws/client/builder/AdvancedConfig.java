package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SdkProtectedApi
@Immutable
public final class AdvancedConfig
{
  public static final AdvancedConfig EMPTY = builder().build();
  private final Map<Key<?>, Object> config;
  
  private AdvancedConfig(Builder builder)
  {
    config = Collections.unmodifiableMap(new HashMap(config));
  }
  
  public <T> T get(Key<T> key)
  {
    return (T)config.get(key);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static class Builder
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
  
  public static class Key<T> {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */