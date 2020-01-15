package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

abstract class ReflectiveTypeAdapterFactory$BoundField
{
  final String name;
  final boolean serialized;
  final boolean deserialized;
  
  protected ReflectiveTypeAdapterFactory$BoundField(String name, boolean serialized, boolean deserialized)
  {
    this.name = name;
    this.serialized = serialized;
    this.deserialized = deserialized;
  }
  
  abstract void write(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException, IllegalAccessException;
  
  abstract void read(JsonReader paramJsonReader, Object paramObject)
    throws IOException, IllegalAccessException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */