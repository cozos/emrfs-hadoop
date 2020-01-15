package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Endpoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Partition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Service;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PartitionRegionImpl
  implements RegionImpl
{
  private static final String SERVICE = "{service}";
  private static final String REGION = "{region}";
  private static final String DNS_SUFFIX = "{dnsSuffix}";
  private final Partition partition;
  private final String region;
  private final Map<String, Endpoint> endpointCache = new ConcurrentHashMap();
  
  public PartitionRegionImpl(String region, Partition p)
  {
    partition = ((Partition)ValidationUtils.assertNotNull(p, "partition"));
    this.region = ((String)ValidationUtils.assertNotNull(region, "region"));
  }
  
  public String getName()
  {
    return region;
  }
  
  public String getDomain()
  {
    return partition.getDnsSuffix();
  }
  
  public String getPartition()
  {
    return partition.getPartition();
  }
  
  public String getServiceEndpoint(String serviceName)
  {
    return getEndpointString(serviceName, getEndpoint(serviceName));
  }
  
  private Endpoint getEndpoint(String serviceName)
  {
    Endpoint cachedEndpoint = (Endpoint)endpointCache.get(serviceName);
    if (cachedEndpoint == null)
    {
      cachedEndpoint = computeEndpoint(serviceName);
      if (cachedEndpoint == null) {
        return null;
      }
    }
    endpointCache.put(serviceName, cachedEndpoint);
    return cachedEndpoint;
  }
  
  private Endpoint computeEndpoint(String serviceName)
  {
    Service service = (Service)partition.getServices().get(serviceName);
    if (service != null)
    {
      if (service.getEndpoints().containsKey(region))
      {
        Endpoint merged = Endpoint.merge(partition
          .getDefaults(), 
          Endpoint.merge(service.getDefaults(), 
          (Endpoint)service.getEndpoints().get(region)));
        
        return merged;
      }
      if ((service.isPartitionWideEndpointAvailable()) && 
        (!service.isRegionalized()))
      {
        Endpoint merged = Endpoint.merge(partition
          .getDefaults(), 
          Endpoint.merge(service.getDefaults(), 
          (Endpoint)service.getEndpoints().get(service
          .getPartitionEndpoint())));
        
        return merged;
      }
      if ((partition.getDefaults() != null) && 
        (partition.getDefaults().getHostName() != null)) {
        return partition.getDefaults();
      }
    }
    return null;
  }
  
  private String getEndpointString(String serviceName, Endpoint endpoint)
  {
    return endpoint == null ? null : endpoint
    
      .getHostName()
      .replace("{service}", serviceName)
      .replace("{region}", region)
      .replace("{dnsSuffix}", partition.getDnsSuffix());
  }
  
  public boolean isServiceSupported(String serviceName)
  {
    return (isServiceSupportedInRegion(serviceName)) || 
      (isServicePartitionWide(serviceName));
  }
  
  private boolean isServiceSupportedInRegion(String serviceName)
  {
    if (partition.getServices().get(serviceName) != null) {}
    return 
    
      ((Service)partition.getServices().get(serviceName)).getEndpoints().containsKey(region);
  }
  
  private boolean isServicePartitionWide(String serviceName)
  {
    if (partition.getServices().get(serviceName) != null) {}
    return 
    
      ((Service)partition.getServices().get(serviceName)).getPartitionEndpoint() != null;
  }
  
  public boolean hasHttpsEndpoint(String serviceName)
  {
    if (!isServiceSupported(serviceName)) {
      return false;
    }
    return getEndpoint(serviceName).hasHttpsSupport();
  }
  
  public boolean hasHttpEndpoint(String serviceName)
  {
    if (!isServiceSupported(serviceName)) {
      return false;
    }
    return getEndpoint(serviceName).hasHttpSupport();
  }
  
  public Collection<String> getAvailableEndpoints()
  {
    List<String> endpoints = new ArrayList();
    for (String service : partition.getServices().keySet()) {
      if (isServiceSupported(service)) {
        endpoints.add(getServiceEndpoint(service));
      }
    }
    return Collections.unmodifiableCollection(endpoints);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.PartitionRegionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */