package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AmazonDynamoDBAsyncClientBuilder
  extends AwsAsyncClientBuilder<AmazonDynamoDBAsyncClientBuilder, AmazonDynamoDBAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new AmazonDynamoDBClientConfigurationFactory();
  
  public static AmazonDynamoDBAsyncClientBuilder standard()
  {
    return new AmazonDynamoDBAsyncClientBuilder();
  }
  
  public static AmazonDynamoDBAsync defaultClient()
  {
    return (AmazonDynamoDBAsync)standard().build();
  }
  
  private AmazonDynamoDBAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonDynamoDBAsync build(AwsAsyncClientParams params)
  {
    return new AmazonDynamoDBAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */