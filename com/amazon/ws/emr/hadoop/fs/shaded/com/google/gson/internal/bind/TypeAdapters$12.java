package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class TypeAdapters$12
  extends TypeAdapter<Character>
{
  public Character read(JsonReader in)
    throws IOException
  {
    if (in.peek() == JsonToken.NULL)
    {
      in.nextNull();
      return null;
    }
    String str = in.nextString();
    if (str.length() != 1) {
      throw new JsonSyntaxException("Expecting character, got: " + str);
    }
    return Character.valueOf(str.charAt(0));
  }
  
  public void write(JsonWriter out, Character value)
    throws IOException
  {
    out.value(value == null ? null : String.valueOf(value));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters.12
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */