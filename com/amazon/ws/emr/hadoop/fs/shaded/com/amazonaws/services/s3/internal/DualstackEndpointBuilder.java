package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ServiceEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import java.net.URI;
import java.net.URISyntaxException;

public class DualstackEndpointBuilder
  extends ServiceEndpointBuilder
{
  private final String serviceName;
  private final String protocol;
  private Region region;
  
  public DualstackEndpointBuilder(String serviceName, String protocol, Region region)
  {
    this.serviceName = serviceName;
    this.protocol = protocol;
    this.region = region;
  }
  
  public DualstackEndpointBuilder withRegion(Region region)
  {
    if (region == null) {
      throw new IllegalArgumentException("Region cannot be null");
    }
    this.region = region;
    return this;
  }
  
  public URI getServiceEndpoint()
  {
    String serviceEndpoint = String.format("%s.%s.%s.%s", new Object[] { serviceName, "dualstack", region.getName(), region.getDomain() });
    return toURI(stripProtocol(serviceEndpoint));
  }
  
  private String stripProtocol(String endpoint)
  {
    int protocolIndex = endpoint.indexOf("://");
    return protocolIndex >= 0 ? endpoint.substring(protocolIndex + "://".length()) : endpoint;
  }
  
  private URI toURI(String endpoint)
    throws IllegalArgumentException
  {
    try
    {
      return new URI(String.format("%s://%s", new Object[] { protocol, endpoint }));
    }
    catch (URISyntaxException e)
    {
      throw new IllegalArgumentException(e);
    }
  }
  
  public Region getRegion()
  {
    return region;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.DualstackEndpointBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */