package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.Map;

public class Service
{
  private final Map<String, Endpoint> endpoints;
  private Endpoint defaults;
  private String partitionEndpoint;
  private boolean isRegionalized;
  
  public Service(@JsonProperty("endpoints") Map<String, Endpoint> endpoints)
  {
    this.endpoints = (endpoints == null ? Collections.emptyMap() : endpoints);
  }
  
  public Map<String, Endpoint> getEndpoints()
  {
    return endpoints;
  }
  
  public Endpoint getDefaults()
  {
    return defaults;
  }
  
  public void setDefaults(Endpoint defaults)
  {
    this.defaults = defaults;
  }
  
  public String getPartitionEndpoint()
  {
    return partitionEndpoint;
  }
  
  @JsonProperty("partitionEndpoint")
  public void setPartitionEndpoint(String partitionEndpoint)
  {
    this.partitionEndpoint = partitionEndpoint;
  }
  
  public boolean isRegionalized()
  {
    return isRegionalized;
  }
  
  @JsonProperty("isRegionalized")
  public void setRegionalized(boolean regionalized)
  {
    isRegionalized = regionalized;
  }
  
  public boolean isPartitionWideEndpointAvailable()
  {
    return partitionEndpoint != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Service
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */