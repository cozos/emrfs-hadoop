package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProvider;

@NotThreadSafe
@SdkProtectedApi
public abstract class AwsSyncClientBuilder<Subclass extends AwsSyncClientBuilder, TypeToBuild>
  extends AwsClientBuilder<Subclass, TypeToBuild>
{
  protected AwsSyncClientBuilder(ClientConfigurationFactory clientConfigFactory)
  {
    super(clientConfigFactory);
  }
  
  @SdkTestInternalApi
  protected AwsSyncClientBuilder(ClientConfigurationFactory clientConfigFactory, AwsRegionProvider regionProvider)
  {
    super(clientConfigFactory, regionProvider);
  }
  
  public final TypeToBuild build()
  {
    return (TypeToBuild)configureMutableProperties(build(getSyncClientParams()));
  }
  
  protected abstract TypeToBuild build(AwsSyncClientParams paramAwsSyncClientParams);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */