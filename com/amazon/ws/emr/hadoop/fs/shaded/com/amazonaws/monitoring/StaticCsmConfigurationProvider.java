package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class StaticCsmConfigurationProvider
  implements CsmConfigurationProvider
{
  private final CsmConfiguration csmConfig;
  
  public StaticCsmConfigurationProvider(CsmConfiguration csmConfig)
  {
    this.csmConfig = ((CsmConfiguration)ValidationUtils.assertNotNull(csmConfig, "csmConfig"));
  }
  
  public CsmConfiguration getConfiguration()
  {
    return csmConfig;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.StaticCsmConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */