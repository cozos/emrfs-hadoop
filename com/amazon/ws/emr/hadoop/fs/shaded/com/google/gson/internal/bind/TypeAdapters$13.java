package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$13
  extends TypeAdapter<String>
{
  public String read(JsonReader in)
    throws IOException
  {
    JsonToken peek = in.peek();
    if (peek == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    if (peek == JsonToken.BOOLEAN) {
      return Boolean.toString(in.nextBoolean());
    }
    return in.nextString();
  }
  
  public void write(JsonWriter out, String value)
    throws IOException
  {
    out.value(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.13
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */