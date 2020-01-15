package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

final class TypeAdapters$20
  extends TypeAdapter<InetAddress>
{
  public InetAddress read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    return InetAddress.getByName(in.nextString());
  }
  
  public void write(JsonWriter out, InetAddress value)
    throws IOException
  {
    out.value(value == null ? null : value.getHostAddress());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.20
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */