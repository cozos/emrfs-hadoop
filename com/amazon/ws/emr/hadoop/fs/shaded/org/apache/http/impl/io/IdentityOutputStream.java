package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.OutputStream;

public class IdentityOutputStream
  extends OutputStream
{
  private final SessionOutputBuffer out;
  private boolean closed = false;
  
  public IdentityOutputStream(SessionOutputBuffer out)
  {
    this.out = ((SessionOutputBuffer)Args.notNull(out, "Session output buffer"));
  }
  
  public void close()
    throws IOException
  {
    if (!closed)
    {
      closed = true;
      out.flush();
    }
  }
  
  public void flush()
    throws IOException
  {
    out.flush();
  }
  
  public void write(byte[] b, int off, int len)
    throws IOException
  {
    if (closed) {
      throw new IOException("Attempted write to closed stream.");
    }
    out.write(b, off, len);
  }
  
  public void write(byte[] b)
    throws IOException
  {
    write(b, 0, b.length);
  }
  
  public void write(int b)
    throws IOException
  {
    if (closed) {
      throw new IOException("Attempted write to closed stream.");
    }
    out.write(b);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.IdentityOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */