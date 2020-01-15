package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProvider;

@NotThreadSafe
public final class AmazonS3ClientBuilder
  extends AmazonS3Builder<AmazonS3ClientBuilder, AmazonS3>
{
  private AmazonS3ClientBuilder() {}
  
  @SdkTestInternalApi
  AmazonS3ClientBuilder(SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> clientFactory, ClientConfigurationFactory clientConfigFactory, AwsRegionProvider regionProvider)
  {
    super(clientFactory, clientConfigFactory, regionProvider);
  }
  
  public static AmazonS3ClientBuilder standard()
  {
    return (AmazonS3ClientBuilder)new AmazonS3ClientBuilder().withCredentials(new S3CredentialsProviderChain());
  }
  
  public static AmazonS3 defaultClient()
  {
    return (AmazonS3)standard().build();
  }
  
  protected AmazonS3 build(AwsSyncClientParams clientParams)
  {
    return (AmazonS3)clientFactory.apply(new AmazonS3ClientParamsWrapper(clientParams, resolveS3ClientOptions()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3ClientBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */