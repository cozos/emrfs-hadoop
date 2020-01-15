package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public enum Regions
{
  GovCloud("us-gov-west-1", "AWS GovCloud (US)"),  US_GOV_EAST_1("us-gov-east-1", "AWS GovCloud (US-East)"),  US_EAST_1("us-east-1", "US East (N. Virginia)"),  US_EAST_2("us-east-2", "US East (Ohio)"),  US_WEST_1("us-west-1", "US West (N. California)"),  US_WEST_2("us-west-2", "US West (Oregon)"),  EU_WEST_1("eu-west-1", "EU (Ireland)"),  EU_WEST_2("eu-west-2", "EU (London)"),  EU_WEST_3("eu-west-3", "EU (Paris)"),  EU_CENTRAL_1("eu-central-1", "EU (Frankfurt)"),  EU_NORTH_1("eu-north-1", "EU (Stockholm)"),  AP_EAST_1("ap-east-1", "Asia Pacific (Hong Kong)"),  AP_SOUTH_1("ap-south-1", "Asia Pacific (Mumbai)"),  AP_SOUTHEAST_1("ap-southeast-1", "Asia Pacific (Singapore)"),  AP_SOUTHEAST_2("ap-southeast-2", "Asia Pacific (Sydney)"),  AP_NORTHEAST_1("ap-northeast-1", "Asia Pacific (Tokyo)"),  AP_NORTHEAST_2("ap-northeast-2", "Asia Pacific (Seoul)"),  SA_EAST_1("sa-east-1", "South America (Sao Paulo)"),  CN_NORTH_1("cn-north-1", "China (Beijing)"),  CN_NORTHWEST_1("cn-northwest-1", "China (Ningxia)"),  CA_CENTRAL_1("ca-central-1", "Canada (Central)"),  ME_SOUTH_1("me-south-1", "Middle East (Bahrain)");
  
  public static final Regions DEFAULT_REGION = US_WEST_2;
  private final String name;
  private final String description;
  
  private Regions(String name, String description)
  {
    this.name = name;
    this.description = description;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public static Regions fromName(String regionName)
  {
    for (Regions region : ) {
      if (region.getName().equals(regionName)) {
        return region;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + regionName + " value!");
  }
  
  public static Region getCurrentRegion()
  {
    try
    {
      String region = EC2MetadataUtils.getEC2InstanceRegion();
      if (region != null) {
        return RegionUtils.getRegion(region);
      }
    }
    catch (AmazonClientException e)
    {
      LogFactory.getLog(Regions.class).debug("Ignoring failure to retrieve the region: " + e
        .getMessage());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Regions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */