package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Partitions
{
  private final String version;
  private final List<Partition> partitions;
  
  public Partitions(@JsonProperty("version") String version, @JsonProperty("partitions") List<Partition> partitions)
  {
    this.version = ((String)ValidationUtils.assertNotNull(version, "version"));
    this.partitions = ((List)ValidationUtils.assertNotNull(partitions, "version"));
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public List<Partition> getPartitions()
  {
    return partitions;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Partitions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */