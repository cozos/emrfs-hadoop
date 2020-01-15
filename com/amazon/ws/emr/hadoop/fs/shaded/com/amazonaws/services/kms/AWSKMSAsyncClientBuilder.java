package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AWSKMSAsyncClientBuilder
  extends AwsAsyncClientBuilder<AWSKMSAsyncClientBuilder, AWSKMSAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AWSKMSAsyncClientBuilder standard()
  {
    return new AWSKMSAsyncClientBuilder();
  }
  
  public static AWSKMSAsync defaultClient()
  {
    return (AWSKMSAsync)standard().build();
  }
  
  private AWSKMSAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AWSKMSAsync build(AwsAsyncClientParams params)
  {
    return new AWSKMSAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */