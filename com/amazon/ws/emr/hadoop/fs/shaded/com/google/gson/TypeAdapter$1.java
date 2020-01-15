package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

class TypeAdapter$1
  extends TypeAdapter<T>
{
  TypeAdapter$1(TypeAdapter paramTypeAdapter) {}
  
  public void write(JsonWriter out, T value)
    throws IOException
  {
    if (value == null) {
      out.nullValue();
    } else {
      this$0.write(out, value);
    }
  }
  
  public T read(JsonReader reader)
    throws IOException
  {
    if (reader.peek() == JsonToken.NULL)
    {
      reader.nextNull();
      return null;
    }
    return (T)this$0.read(reader);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */