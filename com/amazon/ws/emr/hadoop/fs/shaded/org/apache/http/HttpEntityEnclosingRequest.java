package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http;

public abstract interface HttpEntityEnclosingRequest
  extends HttpRequest
{
  public abstract boolean expectContinue();
  
  public abstract void setEntity(HttpEntity paramHttpEntity);
  
  public abstract HttpEntity getEntity();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpEntityEnclosingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */