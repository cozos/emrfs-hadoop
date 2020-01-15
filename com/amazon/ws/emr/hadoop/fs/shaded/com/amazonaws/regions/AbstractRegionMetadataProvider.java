package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRegionMetadataProvider
  implements RegionMetadataProvider
{
  public Region getRegionByEndpoint(String endpoint)
  {
    String host = getHost(endpoint);
    for (Iterator localIterator1 = getRegions().iterator(); localIterator1.hasNext();)
    {
      region = (Region)localIterator1.next();
      for (String serviceEndpoint : region.getAvailableEndpoints()) {
        if (host.equals(getHost(serviceEndpoint))) {
          return region;
        }
      }
    }
    Region region;
    throw new IllegalArgumentException("No region found with any service for endpoint " + endpoint);
  }
  
  private static String getHost(String endpoint)
  {
    String host = URI.create(endpoint).getHost();
    if (host == null) {
      host = URI.create("http://" + endpoint).getHost();
    }
    return host;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AbstractRegionMetadataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */