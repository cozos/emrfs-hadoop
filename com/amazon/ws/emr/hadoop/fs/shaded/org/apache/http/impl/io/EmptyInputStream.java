package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import java.io.InputStream;

public final class EmptyInputStream
  extends InputStream
{
  public static final EmptyInputStream INSTANCE = new EmptyInputStream();
  
  public int available()
  {
    return 0;
  }
  
  public void close() {}
  
  public void mark(int readLimit) {}
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    return -1;
  }
  
  public int read(byte[] buf)
  {
    return -1;
  }
  
  public int read(byte[] buf, int off, int len)
  {
    return -1;
  }
  
  public void reset() {}
  
  public long skip(long n)
  {
    return 0L;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.EmptyInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */