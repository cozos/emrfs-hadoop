package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.annotations.SerializedName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class TypeAdapters$EnumTypeAdapter<T extends Enum<T>>
  extends TypeAdapter<T>
{
  private final Map<String, T> nameToConstant = new HashMap();
  private final Map<T, String> constantToName = new HashMap();
  
  public TypeAdapters$EnumTypeAdapter(Class<T> classOfT)
  {
    try
    {
      for (T constant : (Enum[])classOfT.getEnumConstants())
      {
        String name = constant.name();
        SerializedName annotation = (SerializedName)classOfT.getField(name).getAnnotation(SerializedName.class);
        if (annotation != null) {
          name = annotation.value();
        }
        nameToConstant.put(name, constant);
        constantToName.put(constant, name);
      }
    }
    catch (NoSuchFieldException e)
    {
      throw new AssertionError();
    }
  }
  
  public T read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    return (Enum)nameToConstant.get(in.nextString());
  }
  
  public void write(JsonWriter out, T value)
    throws IOException
  {
    out.value(value == null ? null : (String)constantToName.get(value));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */