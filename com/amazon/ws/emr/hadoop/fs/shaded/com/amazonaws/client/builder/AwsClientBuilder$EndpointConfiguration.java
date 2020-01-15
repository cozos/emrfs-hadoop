package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

public final class AwsClientBuilder$EndpointConfiguration
{
  private final String serviceEndpoint;
  private final String signingRegion;
  
  public AwsClientBuilder$EndpointConfiguration(String serviceEndpoint, String signingRegion)
  {
    this.serviceEndpoint = serviceEndpoint;
    this.signingRegion = signingRegion;
  }
  
  public String getServiceEndpoint()
  {
    return serviceEndpoint;
  }
  
  public String getSigningRegion()
  {
    return signingRegion;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */