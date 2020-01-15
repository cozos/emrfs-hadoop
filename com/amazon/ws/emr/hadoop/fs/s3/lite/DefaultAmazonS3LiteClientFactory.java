package com.amazon.ws.emr.hadoop.fs.s3.lite;

import com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.BucketRegionStore;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3Configuration;
import com.amazon.ws.emr.hadoop.fs.s3.lite.configuration.S3EncryptionConfiguration;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.GlobalS3Executor;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider;
import com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3Executor;
import com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3Factories;
import com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3Factory;
import com.amazon.ws.emr.hadoop.fs.s3.lite.handler.HeadBucketRedirectHandler;
import com.amazon.ws.emr.hadoop.fs.s3.lite.handler.RequestIdLogger;
import com.amazon.ws.emr.hadoop.fs.s3.lite.provider.DefaultS3Provider;
import com.amazon.ws.emr.hadoop.fs.s3.lite.provider.S3Provider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

final class DefaultAmazonS3LiteClientFactory
  implements AmazonS3LiteClientFactory
{
  private final S3Factory<AmazonS3Client, S3Configuration> s3Factory;
  private final S3Factory<AmazonS3EncryptionClient, S3EncryptionConfiguration> s3EncryptionFactory;
  private final BucketRegionStore bucketRegionStore;
  private final List<? extends RequestHandler2> requestHandlers;
  
  DefaultAmazonS3LiteClientFactory(BucketRegionStore bucketRegionStore)
  {
    this(S3Factories.clientFactory(), S3Factories.encryptionClientFactory(), bucketRegionStore);
  }
  
  @VisibleForTesting
  DefaultAmazonS3LiteClientFactory(S3Factory<AmazonS3Client, S3Configuration> s3Factory, S3Factory<AmazonS3EncryptionClient, S3EncryptionConfiguration> s3EncryptionFactory, BucketRegionStore bucketRegionStore)
  {
    this.s3Factory = s3Factory;
    this.s3EncryptionFactory = s3EncryptionFactory;
    this.bucketRegionStore = bucketRegionStore;
    requestHandlers = ImmutableList.of(new HeadBucketRedirectHandler(bucketRegionStore), new RequestIdLogger());
  }
  
  public AmazonS3Lite newClient(S3Configuration s3Configuration, @Nullable S3Configuration initialTimeoutS3Configuration, String defaultEndpoint, @Nullable List<S3CallOverrider> overriders)
  {
    Preconditions.checkNotNull(s3Configuration, "S3Configuration is required");
    Preconditions.checkNotNull(defaultEndpoint, "DefaultEndpoint is required");
    return new AmazonS3LiteClient(newExecutor(
      newProvider(s3Factory, s3Configuration, initialTimeoutS3Configuration), defaultEndpoint, 
      
      (List)MoreObjects.firstNonNull(overriders, ImmutableList.of())));
  }
  
  public AmazonS3Lite newClient(S3Configuration s3Configuration, String defaultEndpoint, List<S3CallOverrider> overriders)
  {
    return newClient(s3Configuration, null, defaultEndpoint, null);
  }
  
  public AmazonS3Lite newClient(S3Configuration s3Configuration, String defaultEndpoint)
  {
    return newClient(s3Configuration, defaultEndpoint, null);
  }
  
  public AmazonS3EncryptionLite newEncryptionClient(S3EncryptionConfiguration s3EncryptionConfiguration, String defaultEndpoint, List<S3CallOverrider> overriders)
  {
    return newEncryptionClient(s3EncryptionConfiguration, null, defaultEndpoint, overriders);
  }
  
  public AmazonS3EncryptionLite newEncryptionClient(S3EncryptionConfiguration s3EncryptionConfiguration, @Nullable S3EncryptionConfiguration s3EncryptionInitialTimeoutConfiguration, String defaultEndpoint, @Nullable List<S3CallOverrider> overriders)
  {
    Preconditions.checkNotNull(s3EncryptionConfiguration, "S3EncryptionConfiguration is required");
    Preconditions.checkNotNull(defaultEndpoint, "DefaultEndpoint is required");
    
    return new AmazonS3EncryptionLiteClient(
      newExecutor(
      newProvider(s3EncryptionFactory, s3EncryptionConfiguration, s3EncryptionInitialTimeoutConfiguration), defaultEndpoint, 
      
      (List)MoreObjects.firstNonNull(overriders, ImmutableList.of())));
  }
  
  public AmazonS3EncryptionLite newEncryptionClient(S3EncryptionConfiguration s3EncryptionConfiguration, String defaultEndpoint)
  {
    return newEncryptionClient(s3EncryptionConfiguration, defaultEndpoint, null);
  }
  
  private <C extends AmazonS3Client, S> S3Provider<C> newProvider(S3Factory<C, S> s3Factory, S s3Configuration, @Nullable S initialRetryS3Configuration)
  {
    return new DefaultS3Provider(s3Factory, s3Configuration, initialRetryS3Configuration, requestHandlers);
  }
  
  private <C extends AmazonS3Client> S3Executor<C> newExecutor(S3Provider<C> s3Provider, String defaultEndpoint, List<S3CallOverrider> overriders)
  {
    return new GlobalS3Executor(s3Provider, defaultEndpoint, bucketRegionStore, overriders);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.DefaultAmazonS3LiteClientFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */