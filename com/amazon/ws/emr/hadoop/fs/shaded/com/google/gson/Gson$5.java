package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson$5
  extends TypeAdapter<Number>
{
  Gson$5(Gson paramGson) {}
  
  public Number read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    return Long.valueOf(in.nextLong());
  }
  
  public void write(JsonWriter out, Number value)
    throws IOException
  {
    if (value == null)
    {
      out.nullValue();
      return;
    }
    out.value(value.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson.5
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */