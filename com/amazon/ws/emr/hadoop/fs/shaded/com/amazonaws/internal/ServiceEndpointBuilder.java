package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import java.net.URI;

public abstract class ServiceEndpointBuilder
{
  public abstract URI getServiceEndpoint();
  
  public abstract Region getRegion();
  
  public abstract ServiceEndpointBuilder withRegion(Region paramRegion);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ServiceEndpointBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */