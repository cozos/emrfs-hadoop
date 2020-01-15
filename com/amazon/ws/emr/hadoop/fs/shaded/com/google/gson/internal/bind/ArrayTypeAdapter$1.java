package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapterFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Types;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class ArrayTypeAdapter$1
  implements TypeAdapterFactory
{
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken)
  {
    Type type = typeToken.getType();
    if ((!(type instanceof GenericArrayType)) && ((!(type instanceof Class)) || (!((Class)type).isArray()))) {
      return null;
    }
    Type componentType = .Gson.Types.getArrayComponentType(type);
    TypeAdapter<?> componentTypeAdapter = gson.getAdapter(TypeToken.get(componentType));
    return new ArrayTypeAdapter(gson, componentTypeAdapter, .Gson.Types.getRawType(componentType));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.ArrayTypeAdapter.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */