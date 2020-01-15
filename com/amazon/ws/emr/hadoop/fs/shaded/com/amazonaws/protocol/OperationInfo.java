package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;

@SdkProtectedApi
public class OperationInfo
{
  private final Protocol protocol;
  private final String requestUri;
  private final HttpMethodName httpMethodName;
  private final String operationIdentifier;
  private final String serviceName;
  private final boolean hasExplicitPayloadMember;
  private final boolean hasPayloadMembers;
  private final String serviceId;
  
  private OperationInfo(Builder builder)
  {
    protocol = protocol;
    requestUri = requestUri;
    httpMethodName = httpMethodName;
    operationIdentifier = operationIdentifier;
    serviceName = serviceName;
    hasExplicitPayloadMember = hasExplicitPayloadMember;
    hasPayloadMembers = hasPayloadMembers;
    serviceId = serviceId;
  }
  
  public Protocol protocol()
  {
    return protocol;
  }
  
  public String requestUri()
  {
    return requestUri;
  }
  
  public HttpMethodName httpMethodName()
  {
    return httpMethodName;
  }
  
  public String operationIdentifier()
  {
    return operationIdentifier;
  }
  
  public String serviceName()
  {
    return serviceName;
  }
  
  public boolean hasExplicitPayloadMember()
  {
    return hasExplicitPayloadMember;
  }
  
  public boolean hasPayloadMembers()
  {
    return hasPayloadMembers;
  }
  
  public String serviceId()
  {
    return serviceId;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static final class Builder
  {
    private Protocol protocol;
    private String requestUri;
    private HttpMethodName httpMethodName;
    private String operationIdentifier;
    private String serviceName;
    private boolean hasExplicitPayloadMember;
    private boolean hasPayloadMembers;
    private String serviceId;
    
    public Builder protocol(Protocol protocol)
    {
      this.protocol = protocol;
      return this;
    }
    
    public Builder requestUri(String requestUri)
    {
      this.requestUri = requestUri;
      return this;
    }
    
    public Builder httpMethodName(HttpMethodName httpMethodName)
    {
      this.httpMethodName = httpMethodName;
      return this;
    }
    
    public Builder operationIdentifier(String operationIdentifier)
    {
      this.operationIdentifier = operationIdentifier;
      return this;
    }
    
    public Builder serviceName(String serviceName)
    {
      this.serviceName = serviceName;
      return this;
    }
    
    public Builder hasExplicitPayloadMember(boolean hasExplicitPayloadMember)
    {
      this.hasExplicitPayloadMember = hasExplicitPayloadMember;
      return this;
    }
    
    public Builder hasPayloadMembers(boolean hasPayloadMembers)
    {
      this.hasPayloadMembers = hasPayloadMembers;
      return this;
    }
    
    public Builder serviceId(String serviceId)
    {
      this.serviceId = serviceId;
      return this;
    }
    
    public OperationInfo build()
    {
      return new OperationInfo(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.OperationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */