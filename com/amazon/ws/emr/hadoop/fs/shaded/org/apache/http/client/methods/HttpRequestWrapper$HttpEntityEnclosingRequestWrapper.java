package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpHost;

class HttpRequestWrapper$HttpEntityEnclosingRequestWrapper
  extends HttpRequestWrapper
  implements HttpEntityEnclosingRequest
{
  private HttpEntity entity;
  
  HttpRequestWrapper$HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest request, HttpHost target)
  {
    super(request, target, null);
    entity = request.getEntity();
  }
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestWrapper.HttpEntityEnclosingRequestWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */