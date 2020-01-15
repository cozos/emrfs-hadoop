package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.URI;
import java.net.URISyntaxException;

@NotThreadSafe
public class DefaultServiceEndpointBuilder
  extends ServiceEndpointBuilder
{
  private static final Log log = LogFactory.getLog(DefaultServiceEndpointBuilder.class);
  private final String serviceName;
  private final String protocol;
  private Region region;
  
  public DefaultServiceEndpointBuilder(String serviceName, String protocol)
  {
    this.serviceName = serviceName;
    this.protocol = protocol;
  }
  
  public DefaultServiceEndpointBuilder withRegion(Region region)
  {
    if (region == null) {
      throw new IllegalArgumentException("Region cannot be null");
    }
    this.region = region;
    return this;
  }
  
  public URI getServiceEndpoint()
  {
    String serviceEndpoint = region.getServiceEndpoint(serviceName);
    if (serviceEndpoint == null)
    {
      serviceEndpoint = String.format("%s.%s.%s", new Object[] { serviceName, region.getName(), region.getDomain() });
      
      log.info("{" + serviceName + ", " + region.getName() + "} was not found in region metadata, trying to construct an endpoint using the standard pattern for this region: '" + serviceEndpoint + "'.");
    }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.DefaultServiceEndpointBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */