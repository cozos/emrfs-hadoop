package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SdkInternalApi
public abstract class EndpointDiscoveryRefreshCache<K>
{
  private static final Log log = LogFactory.getLog(EndpointDiscoveryRefreshCache.class);
  private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(DaemonThreadFactory.INSTANCE);
  private final CacheLoader<String, Map<String, String>> cacheLoader;
  protected final Map<String, URI> cache = new ConcurrentHashMap();
  
  public EndpointDiscoveryRefreshCache(CacheLoader cacheLoader)
  {
    this.cacheLoader = cacheLoader;
  }
  
  public abstract URI get(K paramK, boolean paramBoolean, URI paramURI);
  
  public abstract URI put(String paramString, Map<String, String> paramMap, URI paramURI);
  
  public void evict(String key)
  {
    cache.remove(key);
  }
  
  public URI discoverEndpoint(String key, boolean required, URI defaultEndpoint)
  {
    if (required) {
      try
      {
        return put(key, (Map)cacheLoader.load(key), defaultEndpoint);
      }
      catch (Exception e)
      {
        return defaultEndpoint;
      }
    }
    loadAndScheduleRefresh(key, 1L, defaultEndpoint);
    return defaultEndpoint;
  }
  
  public ScheduledFuture<URI> loadAndScheduleRefresh(final String key, long refreshPeriod, final URI defaultEndpoint)
  {
    executorService.schedule(new Callable()
    {
      public URI call()
      {
        try
        {
          return put(key, (Map)cacheLoader.load(key), defaultEndpoint);
        }
        catch (Exception e)
        {
          EndpointDiscoveryRefreshCache.log.debug("Failed to refresh cached endpoint. Scheduling another refresh in 5 minutes");
          loadAndScheduleRefresh(key, 5L, defaultEndpoint);
        }
        return null;
      }
    }, refreshPeriod, TimeUnit.MINUTES);
  }
  
  public void shutdown()
  {
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.EndpointDiscoveryRefreshCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */