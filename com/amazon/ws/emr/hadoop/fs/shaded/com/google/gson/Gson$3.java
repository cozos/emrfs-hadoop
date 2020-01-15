package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson$3
  extends TypeAdapter<Number>
{
  Gson$3(Gson paramGson) {}
  
  public Double read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    return Double.valueOf(in.nextDouble());
  }
  
  public void write(JsonWriter out, Number value)
    throws IOException
  {
    if (value == null)
    {
      out.nullValue();
      return;
    }
    double doubleValue = value.doubleValue();
    Gson.access$000(this$0, doubleValue);
    out.value(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */