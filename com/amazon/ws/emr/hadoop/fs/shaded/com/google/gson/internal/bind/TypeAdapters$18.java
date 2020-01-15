package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

final class TypeAdapters$18
  extends TypeAdapter<URL>
{
  public URL read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    String nextString = in.nextString();
    return "null".equals(nextString) ? null : new URL(nextString);
  }
  
  public void write(JsonWriter out, URL value)
    throws IOException
  {
    out.value(value == null ? null : value.toExternalForm());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.18
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */