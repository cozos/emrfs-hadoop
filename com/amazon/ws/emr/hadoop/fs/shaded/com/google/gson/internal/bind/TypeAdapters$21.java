package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

final class TypeAdapters$21
  extends TypeAdapter<UUID>
{
  public UUID read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    return UUID.fromString(in.nextString());
  }
  
  public void write(JsonWriter out, UUID value)
    throws IOException
  {
    out.value(value == null ? null : value.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.21
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */