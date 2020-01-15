package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;

final class TypeAdapters$26
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    Class<? super T> rawType = typeToken.getRawType();
    if ((!Enum.class.isAssignableFrom(rawType)) || (rawType == Enum.class)) {
      return null;
    }
    if (!rawType.isEnum()) {
      rawType = rawType.getSuperclass();
    }
    return new TypeAdapters.EnumTypeAdapter(rawType);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.26
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */