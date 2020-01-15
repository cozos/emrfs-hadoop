package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Partition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AbstractRegionMetadataProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

@SdkInternalApi
public class PartitionMetadataProvider
  extends AbstractRegionMetadataProvider
{
  private final Map<String, Partition> partitionMap = new HashMap();
  private final Map<String, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region> regionCache = new ConcurrentHashMap();
  
  public PartitionMetadataProvider(List<Partition> partitions)
  {
    ValidationUtils.assertNotNull(partitions, "partitions");
    for (Partition p : partitions) {
      partitionMap.put(p.getPartition(), p);
    }
  }
  
  public List<com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region> getRegions()
  {
    List<com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region> regions = new ArrayList();
    for (Iterator localIterator1 = partitionMap.values().iterator(); localIterator1.hasNext();)
    {
      p = (Partition)localIterator1.next();
      for (Map.Entry<String, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Region> entry : p.getRegions().entrySet()) {
        regions.add(new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region(new PartitionRegionImpl((String)entry.getKey(), p)));
      }
    }
    Partition p;
    return Collections.unmodifiableList(regions);
  }
  
  public com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region getRegion(String regionName)
  {
    if (regionName == null) {
      return null;
    }
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region regionFromCache = getRegionFromCache(regionName);
    if (regionFromCache != null) {
      return regionFromCache;
    }
    return createNewRegion(regionName);
  }
  
  private com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region createNewRegion(String regionName)
  {
    for (Partition p : partitionMap.values()) {
      if (p.hasRegion(regionName)) {
        return cacheRegion(new PartitionRegionImpl(regionName, p));
      }
    }
    Partition awsPartition = (Partition)partitionMap.get("aws");
    if (awsPartition != null) {
      return cacheRegion(new PartitionRegionImpl(regionName, awsPartition));
    }
    return null;
  }
  
  private com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region getRegionFromCache(String regionName)
  {
    return (com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region)regionCache.get(regionName);
  }
  
  private com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region cacheRegion(PartitionRegionImpl regionImpl)
  {
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region region = new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region(regionImpl);
    
    regionCache.put(region.getName(), region);
    
    return region;
  }
  
  public List<com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region> getRegionsForService(String serviceName)
  {
    List<com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region> allRegions = getRegions();
    List<com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region> serviceSupportedRegions = new ArrayList();
    for (com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region r : allRegions) {
      if (r.isServiceSupported(serviceName)) {
        serviceSupportedRegions.add(r);
      }
    }
    return serviceSupportedRegions;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.PartitionMetadataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */