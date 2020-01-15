package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AmazonDynamoDBStreamsClientBuilder
  extends AwsSyncClientBuilder<AmazonDynamoDBStreamsClientBuilder, AmazonDynamoDBStreams>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonDynamoDBStreamsClientBuilder standard()
  {
    return new AmazonDynamoDBStreamsClientBuilder();
  }
  
  public static AmazonDynamoDBStreams defaultClient()
  {
    return (AmazonDynamoDBStreams)standard().build();
  }
  
  private AmazonDynamoDBStreamsClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonDynamoDBStreams build(AwsSyncClientParams params)
  {
    return new AmazonDynamoDBStreamsClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */