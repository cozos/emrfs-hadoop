package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.HttpEntityWrapper;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class GzipCompressingEntity
  extends HttpEntityWrapper
{
  private static final String GZIP_CODEC = "gzip";
  
  public GzipCompressingEntity(HttpEntity entity)
  {
    super(entity);
  }
  
  public Header getContentEncoding()
  {
    return new BasicHeader("Content-Encoding", "gzip");
  }
  
  public long getContentLength()
  {
    return -1L;
  }
  
  public boolean isChunked()
  {
    return true;
  }
  
  public InputStream getContent()
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public void writeTo(OutputStream outstream)
    throws IOException
  {
    Args.notNull(outstream, "Output stream");
    GZIPOutputStream gzip = new GZIPOutputStream(outstream);
    wrappedEntity.writeTo(gzip);
    
    gzip.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.entity.GzipCompressingEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */