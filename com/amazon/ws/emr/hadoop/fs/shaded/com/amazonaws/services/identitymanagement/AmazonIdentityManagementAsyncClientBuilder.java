package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsAsyncClientBuilder;

@NotThreadSafe
public final class AmazonIdentityManagementAsyncClientBuilder
  extends AwsAsyncClientBuilder<AmazonIdentityManagementAsyncClientBuilder, AmazonIdentityManagementAsync>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonIdentityManagementAsyncClientBuilder standard()
  {
    return new AmazonIdentityManagementAsyncClientBuilder();
  }
  
  public static AmazonIdentityManagementAsync defaultClient()
  {
    return (AmazonIdentityManagementAsync)standard().build();
  }
  
  private AmazonIdentityManagementAsyncClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonIdentityManagementAsync build(AwsAsyncClientParams params)
  {
    return new AmazonIdentityManagementAsyncClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */