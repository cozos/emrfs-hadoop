package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonIOException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

final class TypeAdapters$19
  extends TypeAdapter<URI>
{
  public URI read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    try
    {
      String nextString = in.nextString();
      return "null".equals(nextString) ? null : new URI(nextString);
    }
    catch (URISyntaxException e)
    {
      throw new JsonIOException(e);
    }
  }
  
  public void write(JsonWriter out, URI value)
    throws IOException
  {
    out.value(value == null ? null : value.toASCIIString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.19
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */