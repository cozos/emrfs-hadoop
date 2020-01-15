package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.Collection;

@SdkInternalApi
public abstract interface RegionImpl
{
  public abstract String getName();
  
  public abstract String getDomain();
  
  public abstract String getPartition();
  
  public abstract boolean isServiceSupported(String paramString);
  
  public abstract String getServiceEndpoint(String paramString);
  
  public abstract boolean hasHttpEndpoint(String paramString);
  
  public abstract boolean hasHttpsEndpoint(String paramString);
  
  public abstract Collection<String> getAvailableEndpoints();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */