package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Writer;

final class CharStreams$NullWriter
  extends Writer
{
  private static final NullWriter INSTANCE = new NullWriter();
  
  public void write(int c) {}
  
  public void write(char[] cbuf)
  {
    Preconditions.checkNotNull(cbuf);
  }
  
  public void write(char[] cbuf, int off, int len)
  {
    Preconditions.checkPositionIndexes(off, off + len, cbuf.length);
  }
  
  public void write(String str)
  {
    Preconditions.checkNotNull(str);
  }
  
  public void write(String str, int off, int len)
  {
    Preconditions.checkPositionIndexes(off, off + len, str.length());
  }
  
  public Writer append(CharSequence csq)
  {
    Preconditions.checkNotNull(csq);
    return this;
  }
  
  public Writer append(CharSequence csq, int start, int end)
  {
    Preconditions.checkPositionIndexes(start, end, csq.length());
    return this;
  }
  
  public Writer append(char c)
  {
    return this;
  }
  
  public void flush() {}
  
  public void close() {}
  
  public String toString()
  {
    return "CharStreams.nullWriter()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CharStreams.NullWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */