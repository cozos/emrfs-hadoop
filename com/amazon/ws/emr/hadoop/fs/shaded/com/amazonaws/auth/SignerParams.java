package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

public class SignerParams
{
  private String serviceName;
  private String regionName;
  
  public SignerParams(String serviceName, String regionName)
  {
    this.serviceName = serviceName;
    this.regionName = regionName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SignerParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */