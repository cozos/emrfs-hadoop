package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;

class ReflectiveTypeAdapterFactory$1
  extends ReflectiveTypeAdapterFactory.BoundField
{
  ReflectiveTypeAdapterFactory$1(ReflectiveTypeAdapterFactory paramReflectiveTypeAdapterFactory, String x0, boolean x1, boolean x2, Gson paramGson, TypeToken paramTypeToken, Field paramField, boolean paramBoolean1)
  {
    super(x0, x1, x2);
  }
  
  final TypeAdapter<?> typeAdapter = val$context.getAdapter(val$fieldType);
  
  void write(JsonWriter writer, Object value)
    throws IOException, IllegalAccessException
  {
    Object fieldValue = val$field.get(value);
    TypeAdapter t = new TypeAdapterRuntimeTypeWrapper(val$context, typeAdapter, val$fieldType.getType());
    
    t.write(writer, fieldValue);
  }
  
  void read(JsonReader reader, Object value)
    throws IOException, IllegalAccessException
  {
    Object fieldValue = typeAdapter.read(reader);
    if ((fieldValue != null) || (!val$isPrimitive)) {
      val$field.set(value, fieldValue);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */