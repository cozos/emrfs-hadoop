package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonSerializationContext
{
  public abstract JsonElement serialize(Object paramObject);
  
  public abstract JsonElement serialize(Object paramObject, Type paramType);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSerializationContext
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */