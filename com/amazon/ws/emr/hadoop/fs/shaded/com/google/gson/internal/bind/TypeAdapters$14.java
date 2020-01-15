package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;

final class TypeAdapters$14
  extends TypeAdapter<BigDecimal>
{
  public BigDecimal read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    try
    {
      return new BigDecimal(in.nextString());
    }
    catch (NumberFormatException e)
    {
      throw new JsonSyntaxException(e);
    }
  }
  
  public void write(JsonWriter out, BigDecimal value)
    throws IOException
  {
    out.value(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.14
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */