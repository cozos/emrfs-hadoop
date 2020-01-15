package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

public abstract interface TypeAdapterFactory
{
  public abstract <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */