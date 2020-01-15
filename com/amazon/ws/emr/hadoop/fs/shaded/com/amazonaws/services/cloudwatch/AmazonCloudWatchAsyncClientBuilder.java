package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AmazonCloudWatchAsyncClientBuilder
  extends AwsAsyncClientBuilder<AmazonCloudWatchAsyncClientBuilder, AmazonCloudWatchAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonCloudWatchAsyncClientBuilder standard()
  {
    return new AmazonCloudWatchAsyncClientBuilder();
  }
  
  public static AmazonCloudWatchAsync defaultClient()
  {
    return (AmazonCloudWatchAsync)standard().build();
  }
  
  private AmazonCloudWatchAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonCloudWatchAsync build(AwsAsyncClientParams params)
  {
    return new AmazonCloudWatchAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */