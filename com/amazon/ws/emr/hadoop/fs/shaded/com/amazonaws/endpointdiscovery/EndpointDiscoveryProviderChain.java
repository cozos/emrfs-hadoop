package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EndpointDiscoveryProviderChain
  implements EndpointDiscoveryProvider
{
  private static final Log LOG = LogFactory.getLog(EndpointDiscoveryProviderChain.class);
  private final List<EndpointDiscoveryProvider> providers;
  
  public EndpointDiscoveryProviderChain(EndpointDiscoveryProvider... providers)
  {
    this.providers = new ArrayList(providers.length);
    Collections.addAll(this.providers, providers);
  }
  
  public Boolean endpointDiscoveryEnabled()
  {
    Boolean endpointDiscoveryEnabled = null;
    for (EndpointDiscoveryProvider provider : providers) {
      try
      {
        endpointDiscoveryEnabled = provider.endpointDiscoveryEnabled();
        if (endpointDiscoveryEnabled != null) {
          return endpointDiscoveryEnabled;
        }
      }
      catch (Exception e)
      {
        LOG.debug("Unable to discover endpoint discovery setting " + provider.toString() + ": " + e
          .getMessage());
      }
    }
    return endpointDiscoveryEnabled;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.EndpointDiscoveryProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */