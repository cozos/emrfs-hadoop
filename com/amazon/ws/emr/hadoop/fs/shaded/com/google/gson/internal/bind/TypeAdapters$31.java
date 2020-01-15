package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

final class TypeAdapters$31
  implements TypeAdapterFactory
{
  TypeAdapters$31(Class paramClass, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    return val$clazz.isAssignableFrom(typeToken.getRawType()) ? val$typeAdapter : null;
  }
  
  public String toString()
  {
    return "Factory[typeHierarchy=" + val$clazz.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.31
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */