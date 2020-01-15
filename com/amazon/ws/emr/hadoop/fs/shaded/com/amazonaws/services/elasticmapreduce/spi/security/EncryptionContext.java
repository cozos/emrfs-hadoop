package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security;

import java.util.HashMap;
import java.util.Map;

public class EncryptionContext
{
  private final String type;
  private final Map<String, String> context = new HashMap();
  
  public EncryptionContext(String type)
  {
    this.type = type;
  }
  
  public String getType()
  {
    return type;
  }
  
  public Map<String, String> getContext()
  {
    return new HashMap(context);
  }
  
  public EncryptionContext withContext(String key, String value)
  {
    context.put(key, value);
    return this;
  }
  
  public EncryptionContext withContext(Map<String, String> context)
  {
    this.context.putAll(context);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.spi.security.EncryptionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */