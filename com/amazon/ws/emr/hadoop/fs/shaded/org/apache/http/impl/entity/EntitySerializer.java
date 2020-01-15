package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.Contract;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.annotation.ThreadingBehavior;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.ContentLengthStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.ChunkedOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.ContentLengthOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.io.IdentityOutputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.io.SessionOutputBuffer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.util.Args;
import java.io.IOException;
import java.io.OutputStream;

@Deprecated
@Contract(threading=ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class EntitySerializer
{
  private final ContentLengthStrategy lenStrategy;
  
  public EntitySerializer(ContentLengthStrategy lenStrategy)
  {
    this.lenStrategy = ((ContentLengthStrategy)Args.notNull(lenStrategy, "Content length strategy"));
  }
  
  protected OutputStream doSerialize(SessionOutputBuffer outbuffer, HttpMessage message)
    throws HttpException, IOException
  {
    long len = lenStrategy.determineLength(message);
    if (len == -2L) {
      return new ChunkedOutputStream(outbuffer);
    }
    if (len == -1L) {
      return new IdentityOutputStream(outbuffer);
    }
    return new ContentLengthOutputStream(outbuffer, len);
  }
  
  public void serialize(SessionOutputBuffer outbuffer, HttpMessage message, HttpEntity entity)
    throws HttpException, IOException
  {
    Args.notNull(outbuffer, "Session output buffer");
    Args.notNull(message, "HTTP message");
    Args.notNull(entity, "HTTP entity");
    OutputStream outstream = doSerialize(outbuffer, message);
    entity.writeTo(outstream);
    outstream.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.entity.EntitySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */