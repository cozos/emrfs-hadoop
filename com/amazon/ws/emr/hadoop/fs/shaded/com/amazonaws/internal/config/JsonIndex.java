package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

public final class JsonIndex<C extends Builder<T>, T>
{
  private String key;
  private C config;
  
  public JsonIndex() {}
  
  public JsonIndex(String key)
  {
    this.key = key;
  }
  
  public JsonIndex(String key, C config)
  {
    this.key = key;
    this.config = config;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public C getConfig()
  {
    return config;
  }
  
  public void setConfig(C config)
  {
    this.config = config;
  }
  
  public T newReadOnlyConfig()
  {
    return (T)config.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.JsonIndex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */