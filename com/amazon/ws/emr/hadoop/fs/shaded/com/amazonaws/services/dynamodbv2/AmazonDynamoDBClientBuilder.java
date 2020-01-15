package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.DefaultEndpointDiscoveryProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.EndpointDiscoveryProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig.Factory;

@NotThreadSafe
public final class AmazonDynamoDBClientBuilder
  extends AwsSyncClientBuilder<AmazonDynamoDBClientBuilder, AmazonDynamoDB>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new AmazonDynamoDBClientConfigurationFactory();
  private static final EndpointDiscoveryProviderChain DEFAULT_ENDPOINT_DISCOVERY_PROVIDER = new DefaultEndpointDiscoveryProviderChain();
  private boolean endpointDiscoveryEnabled = false;
  private boolean endpointDiscoveryDisabled = false;
  
  public static AmazonDynamoDBClientBuilder standard()
  {
    return new AmazonDynamoDBClientBuilder();
  }
  
  public static AmazonDynamoDB defaultClient()
  {
    return (AmazonDynamoDB)standard().build();
  }
  
  private AmazonDynamoDBClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  public AmazonDynamoDBClientBuilder enableEndpointDiscovery()
  {
    endpointDiscoveryEnabled = true;
    return this;
  }
  
  public AmazonDynamoDBClientBuilder disableEndpointDiscovery()
  {
    endpointDiscoveryDisabled = true;
    return this;
  }
  
  private boolean endpointDiscoveryEnabled()
  {
    Boolean endpointDiscoveryChainSetting = DEFAULT_ENDPOINT_DISCOVERY_PROVIDER.endpointDiscoveryEnabled();
    if (endpointDiscoveryDisabled) {
      return false;
    }
    if (endpointDiscoveryEnabled) {
      return true;
    }
    if ((endpointDiscoveryChainSetting != null) && (!endpointDiscoveryChainSetting.booleanValue())) {
      return false;
    }
    if ((endpointDiscoveryChainSetting != null) && (endpointDiscoveryChainSetting.booleanValue())) {
      return true;
    }
    if (InternalConfig.Factory.getInternalConfig().endpointDiscoveryEnabled()) {
      return true;
    }
    return false;
  }
  
  protected AmazonDynamoDB build(AwsSyncClientParams params)
  {
    if ((endpointDiscoveryEnabled()) && (getEndpoint() == null)) {
      return new AmazonDynamoDBClient(params, true);
    }
    return new AmazonDynamoDBClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */