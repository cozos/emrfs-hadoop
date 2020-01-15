package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import java.net.URI;

public class SignerProviderContext
{
  private final URI uri;
  private final boolean isRedirect;
  private final Request<?> request;
  private final RequestConfig requestConfig;
  
  private SignerProviderContext(Builder builder)
  {
    uri = uri;
    isRedirect = isRedirect;
    request = request;
    requestConfig = requestConfig;
  }
  
  public URI getUri()
  {
    return uri;
  }
  
  public boolean isRedirect()
  {
    return isRedirect;
  }
  
  public Request<?> getRequest()
  {
    return request;
  }
  
  public RequestConfig getRequestConfig()
  {
    return requestConfig;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static class Builder
  {
    private URI uri;
    private boolean isRedirect;
    private Request<?> request;
    private RequestConfig requestConfig;
    
    public Builder withUri(URI uri)
    {
      this.uri = uri;
      return this;
    }
    
    public Builder withIsRedirect(boolean withIsRedirect)
    {
      isRedirect = withIsRedirect;
      return this;
    }
    
    public Builder withRequest(Request<?> request)
    {
      this.request = request;
      return this;
    }
    
    public Builder withRequestConfig(RequestConfig requestConfig)
    {
      this.requestConfig = requestConfig;
      return this;
    }
    
    public SignerProviderContext build()
    {
      return new SignerProviderContext(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */