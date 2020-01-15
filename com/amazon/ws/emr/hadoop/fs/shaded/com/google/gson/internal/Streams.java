package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonIOException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonNull;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonParseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.JsonSyntaxException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.TypeAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.bind.TypeAdapters;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonReader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.JsonWriter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class Streams
{
  public static JsonElement parse(JsonReader reader)
    throws JsonParseException
  {
    boolean isEmpty = true;
    try
    {
      reader.peek();
      isEmpty = false;
      return (JsonElement)TypeAdapters.JSON_ELEMENT.read(reader);
    }
    catch (EOFException e)
    {
      if (isEmpty) {
        return JsonNull.INSTANCE;
      }
      throw new JsonSyntaxException(e);
    }
    catch (MalformedJsonException e)
    {
      throw new JsonSyntaxException(e);
    }
    catch (IOException e)
    {
      throw new JsonIOException(e);
    }
    catch (NumberFormatException e)
    {
      throw new JsonSyntaxException(e);
    }
  }
  
  public static void write(JsonElement element, JsonWriter writer)
    throws IOException
  {
    TypeAdapters.JSON_ELEMENT.write(writer, element);
  }
  
  public static Writer writerForAppendable(Appendable appendable)
  {
    return (appendable instanceof Writer) ? (Writer)appendable : new AppendableWriter(appendable, null);
  }
  
  private static final class AppendableWriter
    extends Writer
  {
    private final Appendable appendable;
    private final CurrentWrite currentWrite = new CurrentWrite();
    
    private AppendableWriter(Appendable appendable)
    {
      this.appendable = appendable;
    }
    
    public void write(char[] chars, int offset, int length)
      throws IOException
    {
      currentWrite.chars = chars;
      appendable.append(currentWrite, offset, offset + length);
    }
    
    public void write(int i)
      throws IOException
    {
      appendable.append((char)i);
    }
    
    public void flush() {}
    
    public void close() {}
    
    static class CurrentWrite
      implements CharSequence
    {
      char[] chars;
      
      public int length()
      {
        return chars.length;
      }
      
      public char charAt(int i)
      {
        return chars[i];
      }
      
      public CharSequence subSequence(int start, int end)
      {
        return new String(chars, start, end - start);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.Streams
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */