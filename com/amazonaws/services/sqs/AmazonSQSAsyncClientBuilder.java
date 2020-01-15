package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AmazonSQSAsyncClientBuilder
  extends AwsAsyncClientBuilder<AmazonSQSAsyncClientBuilder, AmazonSQSAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new AmazonSQSClientConfigurationFactory();
  
  public static AmazonSQSAsyncClientBuilder standard()
  {
    return new AmazonSQSAsyncClientBuilder();
  }
  
  public static AmazonSQSAsync defaultClient()
  {
    return (AmazonSQSAsync)standard().build();
  }
  
  private AmazonSQSAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonSQSAsync build(AwsAsyncClientParams params)
  {
    return new AmazonSQSAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */