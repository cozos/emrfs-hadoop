package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$3
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
    if (in.peek() == JsonToken.STRING) {
      return Boolean.valueOf(Boolean.parseBoolean(in.nextString()));
    }
    return Boolean.valueOf(in.nextBoolean());
  }
  
  public void write(JsonWriter out, Boolean value)
    throws IOException
  {
    if (value == null)
    {
      out.nullValue();
      return;
    }
    out.value(value.booleanValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */