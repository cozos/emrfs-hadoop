package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHeader;
import java.io.IOException;

public abstract class AbstractHttpEntity
  implements HttpEntity
{
  protected static final int OUTPUT_BUFFER_SIZE = 4096;
  protected Header contentType;
  protected Header contentEncoding;
  protected boolean chunked;
  
  public Header getContentType()
  {
    return contentType;
  }
  
  public Header getContentEncoding()
  {
    return contentEncoding;
  }
  
  public boolean isChunked()
  {
    return chunked;
  }
  
  public void setContentType(Header contentType)
  {
    this.contentType = contentType;
  }
  
  public void setContentType(String ctString)
  {
    Header h = null;
    if (ctString != null) {
      h = new BasicHeader("Content-Type", ctString);
    }
    setContentType(h);
  }
  
  public void setContentEncoding(Header contentEncoding)
  {
    this.contentEncoding = contentEncoding;
  }
  
  public void setContentEncoding(String ceString)
  {
    Header h = null;
    if (ceString != null) {
      h = new BasicHeader("Content-Encoding", ceString);
    }
    setContentEncoding(h);
  }
  
  public void setChunked(boolean b)
  {
    chunked = b;
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {}
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    if (contentType != null)
    {
      sb.append("Content-Type: ");
      sb.append(contentType.getValue());
      sb.append(',');
    }
    if (contentEncoding != null)
    {
      sb.append("Content-Encoding: ");
      sb.append(contentEncoding.getValue());
      sb.append(',');
    }
    long len = getContentLength();
    if (len >= 0L)
    {
      sb.append("Content-Length: ");
      sb.append(len);
      sb.append(',');
    }
    sb.append("Chunked: ");
    sb.append(chunked);
    sb.append(']');
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.AbstractHttpEntity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */