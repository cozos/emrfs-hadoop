package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.endpointdiscovery;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Endpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonDynamoDBEndpointCacheLoader
  implements CacheLoader<String, Map<String, String>>
{
  private final AmazonDynamoDB client;
  
  public AmazonDynamoDBEndpointCacheLoader(AmazonDynamoDB client)
  {
    this.client = client;
  }
  
  public Map<String, String> load(String key)
  {
    DescribeEndpointsResult response = client.describeEndpoints(new DescribeEndpointsRequest());
    
    List<Endpoint> endpoints = response.getEndpoints();
    if ((endpoints == null) || (endpoints.size() == 0)) {
      return null;
    }
    Endpoint endpoint = (Endpoint)endpoints.get(0);
    
    Map<String, String> endpointDetail = new HashMap();
    endpointDetail.put("CachePeriod", String.valueOf(endpoint.getCachePeriodInMinutes()));
    endpointDetail.put("Endpoint", endpoint.getAddress());
    
    return endpointDetail;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.endpointdiscovery.AmazonDynamoDBEndpointCacheLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */