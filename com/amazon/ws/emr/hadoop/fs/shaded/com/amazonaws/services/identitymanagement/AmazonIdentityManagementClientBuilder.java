package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;

@NotThreadSafe
public final class AmazonIdentityManagementClientBuilder
  extends AwsSyncClientBuilder<AmazonIdentityManagementClientBuilder, AmazonIdentityManagement>
{
  private static final ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new ClientConfigurationFactory();
  
  public static AmazonIdentityManagementClientBuilder standard()
  {
    return new AmazonIdentityManagementClientBuilder();
  }
  
  public static AmazonIdentityManagement defaultClient()
  {
    return (AmazonIdentityManagement)standard().build();
  }
  
  private AmazonIdentityManagementClientBuilder()
  {
    super(CLIENT_CONFIG_FACTORY);
  }
  
  protected AmazonIdentityManagement build(AwsSyncClientParams params)
  {
    return new AmazonIdentityManagementClient(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */