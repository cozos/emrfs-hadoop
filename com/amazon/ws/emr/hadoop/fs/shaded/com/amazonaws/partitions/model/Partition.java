package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Partition
{
  private final String partition;
  private final Map<String, Region> regions;
  private final Map<String, Service> services;
  private String partitionName;
  private String dnsSuffix;
  private String regionRegex;
  private Endpoint defaults;
  
  public Partition(@JsonProperty("partition") String partition, @JsonProperty("regions") Map<String, Region> regions, @JsonProperty("services") Map<String, Service> services)
  {
    this.partition = ((String)ValidationUtils.assertNotNull(partition, "Partition"));
    this.regions = regions;
    this.services = services;
  }
  
  public String getPartition()
  {
    return partition;
  }
  
  public String getPartitionName()
  {
    return partitionName;
  }
  
  public void setPartitionName(String partitionName)
  {
    this.partitionName = partitionName;
  }
  
  public String getDnsSuffix()
  {
    return dnsSuffix;
  }
  
  public void setDnsSuffix(String dnsSuffix)
  {
    this.dnsSuffix = dnsSuffix;
  }
  
  public String getRegionRegex()
  {
    return regionRegex;
  }
  
  public void setRegionRegex(String regionRegex)
  {
    this.regionRegex = regionRegex;
  }
  
  public Endpoint getDefaults()
  {
    return defaults;
  }
  
  public void setDefaults(Endpoint defaults)
  {
    this.defaults = defaults;
  }
  
  public Map<String, Region> getRegions()
  {
    return regions;
  }
  
  public Map<String, Service> getServices()
  {
    return services;
  }
  
  public boolean hasRegion(String region)
  {
    return (regions.containsKey(region)) || (matchesRegionRegex(region)) || 
      (hasServiceEndpoint(region));
  }
  
  private boolean matchesRegionRegex(String region)
  {
    Pattern p = Pattern.compile(regionRegex);
    return p.matcher(region).matches();
  }
  
  @Deprecated
  private boolean hasServiceEndpoint(String endpoint)
  {
    for (Service s : services.values()) {
      if (s.getEndpoints().containsKey(endpoint)) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Partition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */