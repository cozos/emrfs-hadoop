package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

public class HttpClientConfigJsonHelper
  implements Builder<HttpClientConfig>
{
  private String serviceName;
  private String regionMetadataServiceName;
  
  public HttpClientConfigJsonHelper() {}
  
  public HttpClientConfigJsonHelper(String serviceName, String regionMetadataServiceName)
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
  
  public void setServiceName(String serviceName)
  {
    this.serviceName = serviceName;
  }
  
  public String getRegionMetadataServiceName()
  {
    return regionMetadataServiceName;
  }
  
  public void setRegionMetadataServiceName(String regionMetadataServiceName)
  {
    this.regionMetadataServiceName = regionMetadataServiceName;
  }
  
  public HttpClientConfig build()
  {
    return new HttpClientConfig(serviceName, regionMetadataServiceName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.HttpClientConfigJsonHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */