package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SdkInternalApi
public class InMemoryRegionsProvider
  extends AbstractRegionMetadataProvider
{
  private final List<Region> regions;
  
  public InMemoryRegionsProvider(List<Region> regions)
  {
    ValidationUtils.assertNotNull(regions, "regions");
    this.regions = Collections.unmodifiableList(new ArrayList(regions));
  }
  
  public List<Region> getRegions()
  {
    return Collections.unmodifiableList(new ArrayList(regions));
  }
  
  public Region getRegion(String regionName)
  {
    for (Region region : regions) {
      if (region.getName().equals(regionName)) {
        return region;
      }
    }
    return null;
  }
  
  public List<Region> getRegionsForService(String serviceName)
  {
    List<Region> results = new LinkedList();
    for (Region region : regions) {
      if (region.isServiceSupported(serviceName)) {
        results.add(region);
      }
    }
    return results;
  }
  
  public String toString()
  {
    return regions.toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.InMemoryRegionsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */