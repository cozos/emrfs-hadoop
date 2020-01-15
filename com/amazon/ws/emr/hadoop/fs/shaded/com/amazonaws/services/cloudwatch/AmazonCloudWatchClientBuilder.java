package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AmazonCloudWatchClientBuilder
  extends AwsSyncClientBuilder<AmazonCloudWatchClientBuilder, AmazonCloudWatch>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonCloudWatchClientBuilder standard()
  {
    return new AmazonCloudWatchClientBuilder();
  }
  
  public static AmazonCloudWatch defaultClient()
  {
    return (AmazonCloudWatch)standard().build();
  }
  
  private AmazonCloudWatchClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonCloudWatch build(AwsSyncClientParams params)
  {
    return new AmazonCloudWatchClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */