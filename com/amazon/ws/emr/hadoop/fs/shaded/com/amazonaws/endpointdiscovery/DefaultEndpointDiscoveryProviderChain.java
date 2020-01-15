package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

public class DefaultEndpointDiscoveryProviderChain
  extends EndpointDiscoveryProviderChain
{
  public DefaultEndpointDiscoveryProviderChain()
  {
    super(new EndpointDiscoveryProvider[] { new EnvironmentVariableEndpointDiscoveryProvider(), new SystemPropertyEndpointDiscoveryProvider(), new AwsProfileEndpointDiscoveryProvider() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.DefaultEndpointDiscoveryProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */