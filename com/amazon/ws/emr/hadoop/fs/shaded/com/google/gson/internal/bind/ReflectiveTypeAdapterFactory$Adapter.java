package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.ObjectConstructor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory$Adapter<T>
  extends TypeAdapter<T>
{
  private final ObjectConstructor<T> constructor;
  private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
  
  private ReflectiveTypeAdapterFactory$Adapter(ObjectConstructor<T> constructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields)
  {
    this.constructor = constructor;
    this.boundFields = boundFields;
  }
  
  public T read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    T instance = constructor.construct();
    try
    {
      in.beginObject();
      while (in.hasNext())
      {
        String name = in.nextName();
        ReflectiveTypeAdapterFactory.BoundField field = (ReflectiveTypeAdapterFactory.BoundField)boundFields.get(name);
        if ((field == null) || (!deserialized)) {
          in.skipValue();
        } else {
          field.read(in, instance);
        }
      }
    }
    catch (IllegalStateException e)
    {
      throw new JsonSyntaxException(e);
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError(e);
    }
    in.endObject();
    return instance;
  }
  
  public void write(JsonWriter out, T value)
    throws IOException
  {
    if (value == null)
    {
      out.nullValue();
      return;
    }
    out.beginObject();
    try
    {
      for (ReflectiveTypeAdapterFactory.BoundField boundField : boundFields.values()) {
        if (serialized)
        {
          out.name(name);
          boundField.write(out, value);
        }
      }
    }
    catch (IllegalAccessException e)
    {
      throw new AssertionError();
    }
    out.endObject();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */