package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class Region
{
  private final String description;
  
  public Region(@JsonProperty("description") String description)
  {
    this.description = ((String)ValidationUtils.assertNotNull(description, "Region description"));
  }
  
  public String getDescription()
  {
    return description;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.model.Region
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */