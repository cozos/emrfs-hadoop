package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonSerializer<T>
{
  public abstract JsonElement serialize(T paramT, Type paramType, JsonSerializationContext paramJsonSerializationContext);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSerializer
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */