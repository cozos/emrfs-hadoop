package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import java.util.List;

public class RegionMetadata
{
  private final RegionMetadataProvider provider;
  
  public RegionMetadata(List<Region> regions)
  {
    provider = new InMemoryRegionsProvider(regions);
  }
  
  public RegionMetadata(RegionMetadataProvider provider)
  {
    this.provider = provider;
  }
  
  public List<Region> getRegions()
  {
    return provider.getRegions();
  }
  
  public Region getRegion(String name)
  {
    return provider.getRegion(name);
  }
  
  public List<Region> getRegionsForService(String service)
  {
    return provider.getRegionsForService(service);
  }
  
  @Deprecated
  public Region getRegionByEndpoint(String endpoint)
  {
    return provider.getRegionByEndpoint(endpoint);
  }
  
  public String toString()
  {
    return provider.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */