package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.BufferRecycler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.util.TextBuffer;
import java.io.Writer;

public final class SegmentedStringWriter
  extends Writer
{
  protected final TextBuffer _buffer;
  
  public SegmentedStringWriter(BufferRecycler br)
  {
    _buffer = new TextBuffer(br);
  }
  
  public Writer append(char c)
  {
    write(c);
    return this;
  }
  
  public Writer append(CharSequence csq)
  {
    String str = csq.toString();
    _buffer.append(str, 0, str.length());
    return this;
  }
  
  public Writer append(CharSequence csq, int start, int end)
  {
    String str = csq.subSequence(start, end).toString();
    _buffer.append(str, 0, str.length());
    return this;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void write(char[] cbuf)
  {
    _buffer.append(cbuf, 0, cbuf.length);
  }
  
  public void write(char[] cbuf, int off, int len)
  {
    _buffer.append(cbuf, off, len);
  }
  
  public void write(int c)
  {
    _buffer.append((char)c);
  }
  
  public void write(String str)
  {
    _buffer.append(str, 0, str.length());
  }
  
  public void write(String str, int off, int len)
  {
    _buffer.append(str, off, len);
  }
  
  public String getAndClear()
  {
    String result = _buffer.contentsAsString();
    _buffer.releaseBuffers();
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.io.SegmentedStringWriter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */