package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AmazonDynamoDBStreamsAsyncClientBuilder
  extends AwsAsyncClientBuilder<AmazonDynamoDBStreamsAsyncClientBuilder, AmazonDynamoDBStreamsAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonDynamoDBStreamsAsyncClientBuilder standard()
  {
    return new AmazonDynamoDBStreamsAsyncClientBuilder();
  }
  
  public static AmazonDynamoDBStreamsAsync defaultClient()
  {
    return (AmazonDynamoDBStreamsAsync)standard().build();
  }
  
  private AmazonDynamoDBStreamsAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonDynamoDBStreamsAsync build(AwsAsyncClientParams params)
  {
    return new AmazonDynamoDBStreamsAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */