package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.Header;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntity;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.ProtocolVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.RequestLine;

public class BasicHttpEntityEnclosingRequest
  extends BasicHttpRequest
  implements HttpEntityEnclosingRequest
{
  private HttpEntity entity;
  
  public BasicHttpEntityEnclosingRequest(String method, String uri)
  {
    super(method, uri);
  }
  
  public BasicHttpEntityEnclosingRequest(String method, String uri, ProtocolVersion ver)
  {
    super(method, uri, ver);
  }
  
  public BasicHttpEntityEnclosingRequest(RequestLine requestline)
  {
    super(requestline);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.message.BasicHttpEntityEnclosingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */