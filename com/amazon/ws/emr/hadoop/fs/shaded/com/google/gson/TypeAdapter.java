package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.JsonTreeReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.JsonTreeWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter<T>
{
  public abstract void write(JsonWriter paramJsonWriter, T paramT)
    throws IOException;
  
  public final void toJson(Writer out, T value)
    throws IOException
  {
    JsonWriter writer = new JsonWriter(out);
    write(writer, value);
  }
  
  public final TypeAdapter<T> nullSafe()
  {
    new TypeAdapter()
    {
      public void write(JsonWriter out, T value)
        throws IOException
      {
        if (value == null) {
          out.nullValue();
        } else {
          TypeAdapter.this.write(out, value);
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
        return (T)TypeAdapter.this.read(reader);
      }
    };
  }
  
  public final String toJson(T value)
    throws IOException
  {
    StringWriter stringWriter = new StringWriter();
    toJson(stringWriter, value);
    return stringWriter.toString();
  }
  
  public final JsonElement toJsonTree(T value)
  {
    try
    {
      JsonTreeWriter jsonWriter = new JsonTreeWriter();
      write(jsonWriter, value);
      return jsonWriter.get();
    }
    catch (IOException e)
    {
      throw new JsonIOException(e);
    }
  }
  
  public abstract T read(JsonReader paramJsonReader)
    throws IOException;
  
  public final T fromJson(Reader in)
    throws IOException
  {
    JsonReader reader = new JsonReader(in);
    return (T)read(reader);
  }
  
  public final T fromJson(String json)
    throws IOException
  {
    return (T)fromJson(new StringReader(json));
  }
  
  public final T fromJsonTree(JsonElement jsonTree)
  {
    try
    {
      JsonReader jsonReader = new JsonTreeReader(jsonTree);
      return (T)read(jsonReader);
    }
    catch (IOException e)
    {
      throw new JsonIOException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */