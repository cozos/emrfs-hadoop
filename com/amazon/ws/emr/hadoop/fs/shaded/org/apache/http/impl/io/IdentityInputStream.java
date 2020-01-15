package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.BufferInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.InputStream;

public class IdentityInputStream
  extends InputStream
{
  private final SessionInputBuffer in;
  private boolean closed = false;
  
  public IdentityInputStream(SessionInputBuffer in)
  {
    this.in = ((SessionInputBuffer)Args.notNull(in, "Session input buffer"));
  }
  
  public int available()
    throws IOException
  {
    if ((in instanceof BufferInfo)) {
      return ((BufferInfo)in).length();
    }
    return 0;
  }
  
  public void close()
    throws IOException
  {
    closed = true;
  }
  
  public int read()
    throws IOException
  {
    if (closed) {
      return -1;
    }
    return in.read();
  }
  
  public int read(byte[] b, int off, int len)
    throws IOException
  {
    if (closed) {
      return -1;
    }
    return in.read(b, off, len);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.IdentityInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */