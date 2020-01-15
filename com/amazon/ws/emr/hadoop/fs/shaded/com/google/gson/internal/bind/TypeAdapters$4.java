package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$4
  extends TypeAdapter<Boolean>
{
  public Boolean read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    return Boolean.valueOf(in.nextString());
  }
  
  public void write(JsonWriter out, Boolean value)
    throws IOException
  {
    out.value(value == null ? "null" : value.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.4
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */