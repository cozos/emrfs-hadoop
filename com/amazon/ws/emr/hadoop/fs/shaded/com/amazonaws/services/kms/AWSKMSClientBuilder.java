package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AWSKMSClientBuilder
  extends AwsSyncClientBuilder<AWSKMSClientBuilder, AWSKMS>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AWSKMSClientBuilder standard()
  {
    return new AWSKMSClientBuilder();
  }
  
  public static AWSKMS defaultClient()
  {
    return (AWSKMS)standard().build();
  }
  
  private AWSKMSClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AWSKMS build(AwsSyncClientParams params)
  {
    return new AWSKMSClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */