package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class EntityEnclosingRequestWrapper
  extends RequestWrapper
  implements HttpEntityEnclosingRequest
{
  private HttpEntity entity;
  private boolean consumed;
  
  public EntityEnclosingRequestWrapper(HttpEntityEnclosingRequest request)
    throws ProtocolException
  {
    super(request);
    setEntity(request.getEntity());
  }
  
  public HttpEntity getEntity()
  {
    return entity;
  }
  
  public void setEntity(HttpEntity entity)
  {
    this.entity = (entity != null ? new EntityWrapper(entity) : null);
    consumed = false;
  }
  
  public boolean expectContinue()
  {
    Header expect = getFirstHeader("Expect");
    return (expect != null) && ("100-continue".equalsIgnoreCase(expect.getValue()));
  }
  
  public boolean isRepeatable()
  {
    return (entity == null) || (entity.isRepeatable()) || (!consumed);
  }
  
  class EntityWrapper
    extends HttpEntityWrapper
  {
    EntityWrapper(HttpEntity entity)
    {
      super();
    }
    
    public void consumeContent()
      throws IOException
    {
      consumed = true;
      super.consumeContent();
    }
    
    public InputStream getContent()
      throws IOException
    {
      consumed = true;
      return super.getContent();
    }
    
    public void writeTo(OutputStream outstream)
      throws IOException
    {
      consumed = true;
      super.writeTo(outstream);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.client.EntityEnclosingRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */