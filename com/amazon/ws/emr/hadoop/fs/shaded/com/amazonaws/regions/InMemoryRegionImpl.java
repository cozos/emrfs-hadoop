package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRegionImpl
  implements RegionImpl
{
  private static final String DEFAULT_DOMAIN = "amazonaws.com";
  private final String name;
  private final String domain;
  private final Map<String, String> endpoints = new HashMap();
  private final List<String> https = new ArrayList();
  private final List<String> http = new ArrayList();
  
  public InMemoryRegionImpl(String name, String domain)
  {
    ValidationUtils.assertNotNull(name, "region name");
    this.name = name;
    this.domain = (domain == null ? "amazonaws.com" : domain);
  }
  
  public InMemoryRegionImpl addEndpoint(String serviceName, String endpoint)
  {
    ValidationUtils.assertNotNull(serviceName, "service name");
    ValidationUtils.assertNotNull(endpoint, "endpoint");
    
    endpoints.put(serviceName, endpoint);
    return this;
  }
  
  public InMemoryRegionImpl addHttps(String serviceName)
  {
    https.add(serviceName);
    return this;
  }
  
  public InMemoryRegionImpl addHttp(String serviceName)
  {
    http.add(serviceName);
    return this;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getDomain()
  {
    return domain;
  }
  
  public String getPartition()
  {
    throw new UnsupportedOperationException("Partition is not available in the in memory implementation");
  }
  
  public boolean isServiceSupported(String serviceName)
  {
    return endpoints.containsKey(serviceName);
  }
  
  public String getServiceEndpoint(String serviceName)
  {
    return (String)endpoints.get(serviceName);
  }
  
  public boolean hasHttpsEndpoint(String serviceName)
  {
    return https.contains(serviceName);
  }
  
  public boolean hasHttpEndpoint(String serviceName)
  {
    return http.contains(serviceName);
  }
  
  public Collection<String> getAvailableEndpoints()
  {
    return Collections.unmodifiableCollection(endpoints.values());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.InMemoryRegionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */