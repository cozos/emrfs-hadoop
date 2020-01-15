package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Gson$FutureTypeAdapter<T>
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  public void setDelegate(TypeAdapter<T> typeAdapter)
  {
    if (delegate != null) {
      throw new AssertionError();
    }
    delegate = typeAdapter;
  }
  
  public T read(JsonReader in)
    throws IOException
  {
    if (delegate == null) {
      throw new IllegalStateException();
    }
    return (T)delegate.read(in);
  }
  
  public void write(JsonWriter out, T value)
    throws IOException
  {
    if (delegate == null) {
      throw new IllegalStateException();
    }
    delegate.write(out, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson.FutureTypeAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */