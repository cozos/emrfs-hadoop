package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.OutputStream;

public class ContentLengthOutputStream
  extends OutputStream
{
  private final SessionOutputBuffer out;
  private final long contentLength;
  private long total = 0L;
  private boolean closed = false;
  
  public ContentLengthOutputStream(SessionOutputBuffer out, long contentLength)
  {
    this.out = ((SessionOutputBuffer)Args.notNull(out, "Session output buffer"));
    this.contentLength = Args.notNegative(contentLength, "Content length");
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
    if (total < contentLength)
    {
      long max = contentLength - total;
      int chunk = len;
      if (chunk > max) {
        chunk = (int)max;
      }
      out.write(b, off, chunk);
      total += chunk;
    }
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
    if (total < contentLength)
    {
      out.write(b);
      total += 1L;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.ContentLengthOutputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */