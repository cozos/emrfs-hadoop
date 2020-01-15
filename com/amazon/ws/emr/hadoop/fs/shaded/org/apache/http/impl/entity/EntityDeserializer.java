package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.BasicHttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.ChunkedInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.ContentLengthInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.IdentityInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionInputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class EntityDeserializer
{
  private final ContentLengthStrategy lenStrategy;
  
  public EntityDeserializer(ContentLengthStrategy lenStrategy)
  {
    this.lenStrategy = ((ContentLengthStrategy)Args.notNull(lenStrategy, "Content length strategy"));
  }
  
  protected BasicHttpEntity doDeserialize(SessionInputBuffer inbuffer, HttpMessage message)
    throws HttpException, IOException
  {
    BasicHttpEntity entity = new BasicHttpEntity();
    
    long len = lenStrategy.determineLength(message);
    if (len == -2L)
    {
      entity.setChunked(true);
      entity.setContentLength(-1L);
      entity.setContent(new ChunkedInputStream(inbuffer));
    }
    else if (len == -1L)
    {
      entity.setChunked(false);
      entity.setContentLength(-1L);
      entity.setContent(new IdentityInputStream(inbuffer));
    }
    else
    {
      entity.setChunked(false);
      entity.setContentLength(len);
      entity.setContent(new ContentLengthInputStream(inbuffer, len));
    }
    Header contentTypeHeader = message.getFirstHeader("Content-Type");
    if (contentTypeHeader != null) {
      entity.setContentType(contentTypeHeader);
    }
    Header contentEncodingHeader = message.getFirstHeader("Content-Encoding");
    if (contentEncodingHeader != null) {
      entity.setContentEncoding(contentEncodingHeader);
    }
    return entity;
  }
  
  public HttpEntity deserialize(SessionInputBuffer inbuffer, HttpMessage message)
    throws HttpException, IOException
  {
    Args.notNull(inbuffer, "Session input buffer");
    Args.notNull(message, "HTTP message");
    return doDeserialize(inbuffer, message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.EntityDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */