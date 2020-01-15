package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

public final class DefaultCsmConfigurationProviderChain
  extends CsmConfigurationProviderChain
{
  private static final DefaultCsmConfigurationProviderChain INSTANCE = new DefaultCsmConfigurationProviderChain();
  
  private DefaultCsmConfigurationProviderChain()
  {
    super(new CsmConfigurationProvider[] { new EnvironmentVariableCsmConfigurationProvider(), new SystemPropertyCsmConfigurationProvider(), new ProfileCsmConfigurationProvider() });
  }
  
  public static DefaultCsmConfigurationProviderChain getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.DefaultCsmConfigurationProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */