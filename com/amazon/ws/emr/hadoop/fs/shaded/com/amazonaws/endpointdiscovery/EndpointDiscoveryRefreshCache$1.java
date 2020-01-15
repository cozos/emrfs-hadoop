package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.Callable;

class EndpointDiscoveryRefreshCache$1
  implements Callable<URI>
{
  EndpointDiscoveryRefreshCache$1(EndpointDiscoveryRefreshCache this$0, String paramString, URI paramURI) {}
  
  public URI call()
  {
    try
    {
      return this$0.put(val$key, (Map)EndpointDiscoveryRefreshCache.access$000(this$0).load(val$key), val$defaultEndpoint);
    }
    catch (Exception e)
    {
      EndpointDiscoveryRefreshCache.access$100().debug("Failed to refresh cached endpoint. Scheduling another refresh in 5 minutes");
      this$0.loadAndScheduleRefresh(val$key, 5L, val$defaultEndpoint);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.EndpointDiscoveryRefreshCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */