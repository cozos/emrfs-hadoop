package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

final class TypeAdapters$28
  implements TypeAdapterFactory
{
  TypeAdapters$28(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    return typeToken.getRawType() == val$type ? val$typeAdapter : null;
  }
  
  public String toString()
  {
    return "Factory[type=" + val$type.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.28
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */