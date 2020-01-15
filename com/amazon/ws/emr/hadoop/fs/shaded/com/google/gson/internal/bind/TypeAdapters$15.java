package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

final class TypeAdapters$15
  extends TypeAdapter<BigInteger>
{
  public BigInteger read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    try
    {
      return new BigInteger(in.nextString());
    }
    catch (NumberFormatException e)
    {
      throw new JsonSyntaxException(e);
    }
  }
  
  public void write(JsonWriter out, BigInteger value)
    throws IOException
  {
    out.value(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.15
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */