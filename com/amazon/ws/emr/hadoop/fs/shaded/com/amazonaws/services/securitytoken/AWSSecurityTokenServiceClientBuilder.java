package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AWSSecurityTokenServiceClientBuilder
  extends AwsSyncClientBuilder<AWSSecurityTokenServiceClientBuilder, AWSSecurityTokenService>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AWSSecurityTokenServiceClientBuilder standard()
  {
    return new AWSSecurityTokenServiceClientBuilder();
  }
  
  public static AWSSecurityTokenService defaultClient()
  {
    return (AWSSecurityTokenService)standard().build();
  }
  
  private AWSSecurityTokenServiceClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AWSSecurityTokenService build(AwsSyncClientParams params)
  {
    return new AWSSecurityTokenServiceClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */