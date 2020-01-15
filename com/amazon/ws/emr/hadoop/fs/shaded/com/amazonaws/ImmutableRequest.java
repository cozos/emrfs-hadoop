package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

public abstract interface ImmutableRequest<T>
{
  public abstract Map<String, String> getHeaders();
  
  public abstract String getResourcePath();
  
  public abstract Map<String, List<String>> getParameters();
  
  public abstract URI getEndpoint();
  
  public abstract HttpMethodName getHttpMethod();
  
  public abstract int getTimeOffset();
  
  public abstract InputStream getContent();
  
  public abstract InputStream getContentUnwrapped();
  
  public abstract ReadLimitInfo getReadLimitInfo();
  
  public abstract Object getOriginalRequestObject();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ImmutableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */