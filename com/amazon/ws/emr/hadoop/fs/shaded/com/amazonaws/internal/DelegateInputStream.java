package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import java.io.IOException;
import java.io.InputStream;

public class DelegateInputStream
  extends InputStream
{
  protected final InputStream in;
  
  public DelegateInputStream(InputStream in)
  {
    this.in = in;
  }
  
  public int read()
    throws IOException
  {
    return in.read();
  }
  
  public int read(byte[] b)
    throws IOException
  {
    return in.read(b);
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    return in.read(b, off, len);
  }
  
  public long skip(long n)
    throws IOException
  {
    return in.skip(n);
  }
  
  public int available()
    throws IOException
  {
    return in.available();
  }
  
  public void close()
    throws IOException
  {
    in.close();
  }
  
  public void mark(int readlimit)
  {
    in.mark(readlimit);
  }
  
  public void reset()
    throws IOException
  {
    in.reset();
  }
  
  public boolean markSupported()
  {
    return in.markSupported();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DelegateInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */