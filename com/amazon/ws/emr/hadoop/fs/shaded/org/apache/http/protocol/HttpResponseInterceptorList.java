package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponseInterceptor;
import java.util.List;

@Deprecated
public abstract interface HttpResponseInterceptorList
{
  public abstract void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor);
  
  public abstract void addResponseInterceptor(HttpResponseInterceptor paramHttpResponseInterceptor, int paramInt);
  
  public abstract int getResponseInterceptorCount();
  
  public abstract HttpResponseInterceptor getResponseInterceptor(int paramInt);
  
  public abstract void clearResponseInterceptors();
  
  public abstract void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> paramClass);
  
  public abstract void setInterceptors(List<?> paramList);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.protocol.HttpResponseInterceptorList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */