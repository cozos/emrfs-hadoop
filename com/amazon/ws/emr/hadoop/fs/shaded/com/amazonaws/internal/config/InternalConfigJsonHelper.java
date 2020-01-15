package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

public class InternalConfigJsonHelper
{
  private SignerConfigJsonHelper defaultSigner;
  private JsonIndex<SignerConfigJsonHelper, SignerConfig>[] serviceSigners;
  private JsonIndex<SignerConfigJsonHelper, SignerConfig>[] regionSigners;
  private JsonIndex<SignerConfigJsonHelper, SignerConfig>[] serviceRegionSigners;
  private JsonIndex<HttpClientConfigJsonHelper, HttpClientConfig>[] httpClients;
  private HostRegexToRegionMappingJsonHelper[] hostRegexToRegionMappings;
  private String userAgentTemplate;
  private boolean endpointDiscoveryEnabled;
  
  public SignerConfigJsonHelper getDefaultSigner()
  {
    return defaultSigner;
  }
  
  public void setDefaultSigner(SignerConfigJsonHelper defaultSigner)
  {
    this.defaultSigner = defaultSigner;
  }
  
  public JsonIndex<SignerConfigJsonHelper, SignerConfig>[] getServiceSigners()
  {
    return serviceSigners;
  }
  
  public void setServiceSigners(JsonIndex<SignerConfigJsonHelper, SignerConfig>... serviceSigners)
  {
    this.serviceSigners = serviceSigners;
  }
  
  public JsonIndex<SignerConfigJsonHelper, SignerConfig>[] getRegionSigners()
  {
    return regionSigners;
  }
  
  public void setRegionSigners(JsonIndex<SignerConfigJsonHelper, SignerConfig>... regionSigners)
  {
    this.regionSigners = regionSigners;
  }
  
  public JsonIndex<SignerConfigJsonHelper, SignerConfig>[] getServiceRegionSigners()
  {
    return serviceRegionSigners;
  }
  
  public void setServiceRegionSigners(JsonIndex<SignerConfigJsonHelper, SignerConfig>... serviceRegionSigners)
  {
    this.serviceRegionSigners = serviceRegionSigners;
  }
  
  public JsonIndex<HttpClientConfigJsonHelper, HttpClientConfig>[] getHttpClients()
  {
    return httpClients;
  }
  
  public void setHttpClients(JsonIndex<HttpClientConfigJsonHelper, HttpClientConfig>... httpClients)
  {
    this.httpClients = httpClients;
  }
  
  public HostRegexToRegionMappingJsonHelper[] getHostRegexToRegionMappings()
  {
    return hostRegexToRegionMappings;
  }
  
  public void setHostRegexToRegionMappings(HostRegexToRegionMappingJsonHelper[] hostRegexToRegionMappings)
  {
    this.hostRegexToRegionMappings = hostRegexToRegionMappings;
  }
  
  public String getUserAgentTemplate()
  {
    return userAgentTemplate;
  }
  
  public void setUserAgentTemplate(String userAgentTemplate)
  {
    this.userAgentTemplate = userAgentTemplate;
  }
  
  public boolean isEndpointDiscoveryEnabled()
  {
    return endpointDiscoveryEnabled;
  }
  
  public void setEndpointDiscoveryEnabled(boolean endpointDiscoveryEnabled)
  {
    this.endpointDiscoveryEnabled = endpointDiscoveryEnabled;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfigJsonHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */