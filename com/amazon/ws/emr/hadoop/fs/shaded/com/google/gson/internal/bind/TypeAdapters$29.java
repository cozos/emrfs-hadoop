package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

final class TypeAdapters$29
  implements TypeAdapterFactory
{
  TypeAdapters$29(Class paramClass1, Class paramClass2, TypeAdapter paramTypeAdapter) {}
  
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    Class<? super T> rawType = typeToken.getRawType();
    return (rawType == val$unboxed) || (rawType == val$boxed) ? val$typeAdapter : null;
  }
  
  public String toString()
  {
    return "Factory[type=" + val$boxed.getName() + "+" + val$unboxed.getName() + ",adapter=" + val$typeAdapter + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.29
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */