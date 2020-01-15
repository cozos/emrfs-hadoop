package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpRequestInterceptor;
import java.util.List;

@Deprecated
public abstract interface HttpRequestInterceptorList
{
  public abstract void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor);
  
  public abstract void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt);
  
  public abstract int getRequestInterceptorCount();
  
  public abstract HttpRequestInterceptor getRequestInterceptor(int paramInt);
  
  public abstract void clearRequestInterceptors();
  
  public abstract void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> paramClass);
  
  public abstract void setInterceptors(List<?> paramList);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpRequestInterceptorList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */