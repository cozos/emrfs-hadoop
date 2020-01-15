package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config;

public class HostRegexToRegionMappingJsonHelper
  implements Builder<HostRegexToRegionMapping>
{
  private String hostNameRegex;
  private String regionName;
  
  public String getHostNameRegex()
  {
    return hostNameRegex;
  }
  
  public void setHostNameRegex(String hostNameRegex)
  {
    this.hostNameRegex = hostNameRegex;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public void setRegionName(String regionName)
  {
    this.regionName = regionName;
  }
  
  public HostRegexToRegionMapping build()
  {
    return new HostRegexToRegionMapping(hostNameRegex, regionName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.HostRegexToRegionMappingJsonHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */