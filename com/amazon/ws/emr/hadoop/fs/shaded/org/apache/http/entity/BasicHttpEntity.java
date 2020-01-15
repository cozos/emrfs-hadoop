package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.EmptyInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Asserts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicHttpEntity
  extends AbstractHttpEntity
{
  private InputStream content;
  private long length;
  
  public BasicHttpEntity()
  {
    length = -1L;
  }
  
  public long getContentLength()
  {
    return length;
  }
  
  public InputStream getContent()
    throws IllegalStateException
  {
    Asserts.check(content != null, "Content has not been provided");
    return content;
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public void setContentLength(long len)
  {
    length = len;
  }
  
  public void setContent(InputStream instream)
  {
    content = instream;
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    InputStream instream = getContent();
    try
    {
      byte[] tmp = new byte['က'];
      int l;
      while ((l = instream.read(tmp)) != -1) {
        outstream.write(tmp, 0, l);
      }
    }
    finally
    {
      instream.close();
    }
  }
  
  public boolean isStreaming()
  {
    return (content != null) && (content != EmptyInputStream.INSTANCE);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BasicHttpEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */