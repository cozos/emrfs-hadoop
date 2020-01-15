package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AmazonSQSClientBuilder
  extends AwsSyncClientBuilder<AmazonSQSClientBuilder, AmazonSQS>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new AmazonSQSClientConfigurationFactory();
  
  public static AmazonSQSClientBuilder standard()
  {
    return new AmazonSQSClientBuilder();
  }
  
  public static AmazonSQS defaultClient()
  {
    return (AmazonSQS)standard().build();
  }
  
  private AmazonSQSClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonSQS build(AwsSyncClientParams params)
  {
    return new AmazonSQSClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */