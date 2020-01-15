package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

public abstract interface ExclusionStrategy
{
  public abstract boolean shouldSkipField(FieldAttributes paramFieldAttributes);
  
  public abstract boolean shouldSkipClass(Class<?> paramClass);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.ExclusionStrategy
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */