package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazonaws.auth.AWSCredentials;

public class HandlerContextKey<T>
{
  public static final HandlerContextKey<AWSCredentials> AWS_CREDENTIALS = new HandlerContextKey("AWSCredentials");
  public static final HandlerContextKey<String> SIGNING_REGION = new HandlerContextKey("SigningRegion");
  public static final HandlerContextKey<String> OPERATION_NAME = new HandlerContextKey("OperationName");
  public static final HandlerContextKey<String> SERVICE_ID = new HandlerContextKey("ServiceId");
  public static final HandlerContextKey<Boolean> REQUIRES_LENGTH = new HandlerContextKey("RequiresLength");
  public static final HandlerContextKey<Boolean> HAS_STREAMING_INPUT = new HandlerContextKey("HasStreamingInput");
  public static final HandlerContextKey<AdvancedConfig> ADVANCED_CONFIG = new HandlerContextKey("AdvancedConfig");
  private final String name;
  
  public HandlerContextKey(String name)
  {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.name = name;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    HandlerContextKey<?> key = (HandlerContextKey)o;
    
    return name.equals(key.getName());
  }
  
  public String getName()
  {
    return name;
  }
  
  public int hashCode()
  {
    return name.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerContextKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */