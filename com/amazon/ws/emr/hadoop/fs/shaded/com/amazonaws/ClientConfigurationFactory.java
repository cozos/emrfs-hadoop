package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public class ClientConfigurationFactory
{
  public final ClientConfiguration getConfig()
  {
    return SDKGlobalConfiguration.isInRegionOptimizedModeEnabled() ? 
      getInRegionOptimizedConfig() : getDefaultConfig();
  }
  
  protected ClientConfiguration getDefaultConfig()
  {
    return new ClientConfiguration();
  }
  
  protected ClientConfiguration getInRegionOptimizedConfig()
  {
    return new ClientConfiguration().withConnectionTimeout(1000);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */