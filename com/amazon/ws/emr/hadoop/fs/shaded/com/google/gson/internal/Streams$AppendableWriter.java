package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.io.IOException;
import java.io.Writer;

final class Streams$AppendableWriter
  extends Writer
{
  private final Appendable appendable;
  private final CurrentWrite currentWrite = new CurrentWrite();
  
  private Streams$AppendableWriter(Appendable appendable)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.Streams.AppendableWriter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */