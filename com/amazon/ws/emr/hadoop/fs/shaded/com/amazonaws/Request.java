package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import java.net.URI;
import java.util.List;
import java.util.Map;

public abstract interface Request<T>
  extends SignableRequest<T>, HandlerContextAware
{
  public abstract void setHeaders(Map<String, String> paramMap);
  
  public abstract void setResourcePath(String paramString);
  
  public abstract Request<T> withParameter(String paramString1, String paramString2);
  
  public abstract void setParameters(Map<String, List<String>> paramMap);
  
  public abstract void addParameters(String paramString, List<String> paramList);
  
  public abstract void setEndpoint(URI paramURI);
  
  public abstract void setHttpMethod(HttpMethodName paramHttpMethodName);
  
  public abstract String getServiceName();
  
  public abstract AmazonWebServiceRequest getOriginalRequest();
  
  public abstract void setTimeOffset(int paramInt);
  
  public abstract Request<T> withTimeOffset(int paramInt);
  
  public abstract AWSRequestMetrics getAWSRequestMetrics();
  
  public abstract void setAWSRequestMetrics(AWSRequestMetrics paramAWSRequestMetrics);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */