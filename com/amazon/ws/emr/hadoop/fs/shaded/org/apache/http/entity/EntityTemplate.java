package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EntityTemplate
  extends AbstractHttpEntity
{
  private final ContentProducer contentproducer;
  
  public EntityTemplate(ContentProducer contentproducer)
  {
    this.contentproducer = ((ContentProducer)Args.notNull(contentproducer, "Content producer"));
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public InputStream getContent()
    throws IOException
  {
    ByteArrayOutputStream buf = new ByteArrayOutputStream();
    writeTo(buf);
    return new ByteArrayInputStream(buf.toByteArray());
  }
  
  public boolean isRepeatable()
  {
    return true;
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    contentproducer.writeTo(outstream);
  }
  
  public boolean isStreaming()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.EntityTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */