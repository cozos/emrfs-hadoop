package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

public enum LongSerializationPolicy
{
  DEFAULT,  STRING;
  
  private LongSerializationPolicy() {}
  
  public abstract JsonElement serialize(Long paramLong);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.LongSerializationPolicy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */