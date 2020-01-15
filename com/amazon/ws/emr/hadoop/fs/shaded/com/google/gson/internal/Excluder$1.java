package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.Gson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;

class Excluder$1
  extends TypeAdapter<T>
{
  private TypeAdapter<T> delegate;
  
  Excluder$1(Excluder paramExcluder, boolean paramBoolean1, boolean paramBoolean2, Gson paramGson, TypeToken paramTypeToken) {}
  
  public T read(JsonReader in)
    throws IOException
  {
    if (val$skipDeserialize)
    {
      in.skipValue();
      return null;
    }
    return (T)delegate().read(in);
  }
  
  public void write(JsonWriter out, T value)
    throws IOException
  {
    if (val$skipSerialize)
    {
      out.nullValue();
      return;
    }
    delegate().write(out, value);
  }
  
  private TypeAdapter<T> delegate()
  {
    TypeAdapter<T> d = delegate;
    return d != null ? d : (delegate = val$gson.getDelegateAdapter(this$0, val$type));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.Excluder.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */