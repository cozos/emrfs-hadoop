package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedHttpEntity
  extends HttpEntityWrapper
{
  private final byte[] buffer;
  
  public BufferedHttpEntity(HttpEntity entity)
    throws IOException
  {
    super(entity);
    if ((!entity.isRepeatable()) || (entity.getContentLength() < 0L))
    {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      entity.writeTo(out);
      out.flush();
      buffer = out.toByteArray();
    }
    else
    {
      buffer = null;
    }
  }
  
  public long getContentLength()
  {
    if (buffer != null) {
      return buffer.length;
    }
    return super.getContentLength();
  }
  
  public InputStream getContent()
    throws IOException
  {
    if (buffer != null) {
      return new ByteArrayInputStream(buffer);
    }
    return super.getContent();
  }
  
  public boolean isChunked()
  {
    return (buffer == null) && (super.isChunked());
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    if (buffer != null) {
      outstream.write(buffer);
    } else {
      super.writeTo(outstream);
    }
  }
  
  public boolean isStreaming()
  {
    return (buffer == null) && (super.isStreaming());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BufferedHttpEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */