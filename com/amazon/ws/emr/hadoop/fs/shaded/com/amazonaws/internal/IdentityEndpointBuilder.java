package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import java.net.URI;

public class IdentityEndpointBuilder
  extends ServiceEndpointBuilder
{
  private final URI endpoint;
  
  public IdentityEndpointBuilder(URI endpoint)
  {
    this.endpoint = endpoint;
  }
  
  public URI getServiceEndpoint()
  {
    return endpoint;
  }
  
  public DefaultServiceEndpointBuilder withRegion(Region region)
  {
    return null;
  }
  
  public Region getRegion()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.IdentityEndpointBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */