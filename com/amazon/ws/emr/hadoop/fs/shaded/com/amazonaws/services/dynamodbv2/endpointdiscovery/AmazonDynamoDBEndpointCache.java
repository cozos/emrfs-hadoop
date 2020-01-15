package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.endpointdiscovery;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.EndpointDiscoveryRefreshCache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.net.URI;
import java.util.Map;

public class AmazonDynamoDBEndpointCache
  extends EndpointDiscoveryRefreshCache<String>
{
  private static final Log log = LogFactory.getLog(AmazonDynamoDBEndpointCache.class);
  
  public AmazonDynamoDBEndpointCache(AmazonDynamoDB client)
  {
    super(new AmazonDynamoDBEndpointCacheLoader(client));
  }
  
  public URI get(String key, boolean required, URI defaultEndpoint)
  {
    URI endpoint = (URI)cache.get(key);
    if (endpoint != null) {
      return endpoint;
    }
    if (!required) {
      cache.put(key, defaultEndpoint);
    }
    return discoverEndpoint(key, required, defaultEndpoint);
  }
  
  public URI put(String key, Map<String, String> endpointDetails, URI defaultEndpoint)
  {
    loadAndScheduleRefresh(key, Long.valueOf((String)endpointDetails.get("CachePeriod")).longValue(), defaultEndpoint);
    
    URI discoveredEndpoint = URI.create(String.format("%s://%s", new Object[] { defaultEndpoint.getScheme(), endpointDetails.get("Endpoint") }));
    
    log.debug("Cached new endpoint from service: " + discoveredEndpoint.toASCIIString());
    log.debug("Refresh scheduled in: " + (String)endpointDetails.get("CachePeriod") + " minutes");
    
    return (URI)cache.put(key, discoveredEndpoint);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.endpointdiscovery.AmazonDynamoDBEndpointCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */