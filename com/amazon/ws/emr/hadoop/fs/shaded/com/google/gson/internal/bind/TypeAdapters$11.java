package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.LazilyParsedNumber;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$11
  extends TypeAdapter<Number>
{
  public Number read(JsonReader in)
    throws IOException
  {
    JsonToken jsonToken = in.peek();
    switch (TypeAdapters.32.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()])
    {
    case 4: 
      in.nextNull();
      return null;
    case 1: 
      return new LazilyParsedNumber(in.nextString());
    }
    throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
  }
  
  public void write(JsonWriter out, Number value)
    throws IOException
  {
    out.value(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.11
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */