package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;

@Immutable
public class HttpClientConfig
{
  private final String serviceName;
  private final String regionMetadataServiceName;
  
  HttpClientConfig(String serviceName, String regionMetadataServiceName)
  {
    this.serviceName = serviceName;
    this.regionMetadataServiceName = regionMetadataServiceName;
  }
  
  public String toString()
  {
    return "serviceName: " + serviceName + ", regionMetadataServiceName: " + regionMetadataServiceName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public String getRegionMetadataServiceName()
  {
    return regionMetadataServiceName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.HttpClientConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */