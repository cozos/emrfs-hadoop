package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AWSSecurityTokenServiceAsyncClientBuilder
  extends AwsAsyncClientBuilder<AWSSecurityTokenServiceAsyncClientBuilder, AWSSecurityTokenServiceAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AWSSecurityTokenServiceAsyncClientBuilder standard()
  {
    return new AWSSecurityTokenServiceAsyncClientBuilder();
  }
  
  public static AWSSecurityTokenServiceAsync defaultClient()
  {
    return (AWSSecurityTokenServiceAsync)standard().build();
  }
  
  private AWSSecurityTokenServiceAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AWSSecurityTokenServiceAsync build(AwsAsyncClientParams params)
  {
    return new AWSSecurityTokenServiceAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */