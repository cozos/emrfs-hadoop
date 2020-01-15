package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public enum Region
{
  US_Standard((String[])null),  US_East_2(new String[] { "us-east-2" }),  US_West(new String[] { "us-west-1" }),  US_West_2(new String[] { "us-west-2" }),  US_GovCloud(new String[] { "us-gov-west-1" }),  US_Gov_East_1(new String[] { "us-gov-east-1", "AWS GovCloud (US-East)" }),  EU_Ireland(new String[] { "eu-west-1", "EU" }),  EU_London(new String[] { "eu-west-2" }),  EU_Paris(new String[] { "eu-west-3" }),  EU_Frankfurt(new String[] { "eu-central-1" }),  EU_North_1(new String[] { "eu-north-1" }),  AP_HongKong(new String[] { "ap-east-1" }),  AP_Singapore(new String[] { "ap-southeast-1" }),  AP_Sydney(new String[] { "ap-southeast-2" }),  AP_Tokyo(new String[] { "ap-northeast-1" }),  AP_Seoul(new String[] { "ap-northeast-2" }),  AP_Mumbai(new String[] { "ap-south-1" }),  SA_SaoPaulo(new String[] { "sa-east-1" }),  CA_Central(new String[] { "ca-central-1" }),  CN_Beijing(new String[] { "cn-north-1" }),  CN_Northwest_1(new String[] { "cn-northwest-1" }),  ME_Bahrain(new String[] { "me-south-1" });
  
  public static final Pattern S3_REGIONAL_ENDPOINT_PATTERN = Pattern.compile("s3[-.]([^.]+)\\.amazonaws\\.com(\\.[^.]*)?");
  private final List<String> regionIds;
  
  private Region(String... regionIds)
  {
    this.regionIds = (regionIds != null ? Arrays.asList(regionIds) : null);
  }
  
  public String toString()
  {
    return getFirstRegionId0();
  }
  
  public String getFirstRegionId()
  {
    return getFirstRegionId0();
  }
  
  private String getFirstRegionId0()
  {
    return (regionIds == null) || (regionIds.size() == 0) ? null : 
      (String)regionIds.get(0);
  }
  
  public static Region fromValue(String s3RegionId)
    throws IllegalArgumentException
  {
    if ((s3RegionId == null) || (s3RegionId.equals("US")) || (s3RegionId.equals("us-east-1"))) {
      return US_Standard;
    }
    for (Region region : values())
    {
      List<String> regionIds = regionIds;
      if ((regionIds != null) && (regionIds.contains(s3RegionId))) {
        return region;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + s3RegionId + " value!");
  }
  
  public com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region toAWSRegion()
  {
    String s3regionId = getFirstRegionId();
    if (s3regionId == null) {
      return RegionUtils.getRegion("us-east-1");
    }
    return RegionUtils.getRegion(s3regionId);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */