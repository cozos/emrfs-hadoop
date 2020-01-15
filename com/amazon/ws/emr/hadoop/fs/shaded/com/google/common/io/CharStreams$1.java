package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

final class CharStreams$1
  extends Reader
{
  CharStreams$1(Readable paramReadable) {}
  
  public int read(char[] cbuf, int off, int len)
    throws IOException
  {
    return read(CharBuffer.wrap(cbuf, off, len));
  }
  
  public int read(CharBuffer target)
    throws IOException
  {
    return val$readable.read(target);
  }
  
  public void close()
    throws IOException
  {
    if ((val$readable instanceof Closeable)) {
      ((Closeable)val$readable).close();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.io.CharStreams.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */