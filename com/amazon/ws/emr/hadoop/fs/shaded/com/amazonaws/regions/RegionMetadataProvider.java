package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.List;

@SdkInternalApi
public abstract interface RegionMetadataProvider
{
  public abstract List<Region> getRegions();
  
  public abstract Region getRegion(String paramString);
  
  public abstract List<Region> getRegionsForService(String paramString);
  
  @Deprecated
  public abstract Region getRegionByEndpoint(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionMetadataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */