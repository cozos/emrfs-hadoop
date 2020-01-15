package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.utils.CloneUtils;

public abstract class HttpEntityEnclosingRequestBase
  extends HttpRequestBase
  implements HttpEntityEnclosingRequest
{
  private HttpEntity entity;
  
  public HttpEntity getEntity()
  {
    return entity;
  }
  
  public void setEntity(HttpEntity entity)
  {
    this.entity = entity;
  }
  
  public boolean expectContinue()
  {
    Header expect = getFirstHeader("Expect");
    return (expect != null) && ("100-continue".equalsIgnoreCase(expect.getValue()));
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    HttpEntityEnclosingRequestBase clone = (HttpEntityEnclosingRequestBase)super.clone();
    if (entity != null) {
      entity = ((HttpEntity)CloneUtils.cloneObject(entity));
    }
    return clone;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpEntityEnclosingRequestBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */