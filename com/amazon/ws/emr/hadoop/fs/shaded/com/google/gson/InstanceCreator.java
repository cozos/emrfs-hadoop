package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import java.lang.reflect.Type;

public abstract interface InstanceCreator<T>
{
  public abstract T createInstance(Type paramType);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.InstanceCreator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */