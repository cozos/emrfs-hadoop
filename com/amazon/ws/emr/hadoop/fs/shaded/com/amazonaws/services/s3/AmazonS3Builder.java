package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsSyncClientBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFunction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProvider;

@NotThreadSafe
public abstract class AmazonS3Builder<Subclass extends AmazonS3Builder, TypeToBuild extends AmazonS3>
  extends AwsSyncClientBuilder<Subclass, TypeToBuild>
{
  private static final AmazonS3ClientConfigurationFactory CLIENT_CONFIG_FACTORY = new AmazonS3ClientConfigurationFactory();
  private static final SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> DEFAULT_CLIENT_FACTORY = new SdkFunction()
  {
    public AmazonS3 apply(AmazonS3ClientParamsWrapper params)
    {
      return new AmazonS3Client(params);
    }
  };
  protected final SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> clientFactory;
  private Boolean pathStyleAccessEnabled;
  private Boolean chunkedEncodingDisabled;
  private Boolean accelerateModeEnabled;
  private Boolean payloadSigningEnabled;
  private Boolean dualstackEnabled;
  private Boolean forceGlobalBucketAccessEnabled;
  
  protected AmazonS3Builder()
  {
    super(CLIENT_CONFIG_FACTORY);
    clientFactory = DEFAULT_CLIENT_FACTORY;
  }
  
  @SdkTestInternalApi
  AmazonS3Builder(SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3> clientFactory, ClientConfigurationFactory clientConfigFactory, AwsRegionProvider regionProvider)
  {
    super(clientConfigFactory, regionProvider);
    this.clientFactory = clientFactory;
  }
  
  public Boolean isPathStyleAccessEnabled()
  {
    return pathStyleAccessEnabled;
  }
  
  public void setPathStyleAccessEnabled(Boolean pathStyleAccessEnabled)
  {
    this.pathStyleAccessEnabled = pathStyleAccessEnabled;
  }
  
  public Subclass withPathStyleAccessEnabled(Boolean pathStyleAccessEnabled)
  {
    setPathStyleAccessEnabled(pathStyleAccessEnabled);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Subclass enablePathStyleAccess()
  {
    setPathStyleAccessEnabled(Boolean.TRUE);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Boolean isChunkedEncodingDisabled()
  {
    return chunkedEncodingDisabled;
  }
  
  public void setChunkedEncodingDisabled(Boolean chunkedEncodingDisabled)
  {
    this.chunkedEncodingDisabled = chunkedEncodingDisabled;
  }
  
  public Subclass withChunkedEncodingDisabled(Boolean chunkedEncodingDisabled)
  {
    setChunkedEncodingDisabled(chunkedEncodingDisabled);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Subclass disableChunkedEncoding()
  {
    setChunkedEncodingDisabled(Boolean.TRUE);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Boolean isAccelerateModeEnabled()
  {
    return accelerateModeEnabled;
  }
  
  public void setAccelerateModeEnabled(Boolean accelerateModeEnabled)
  {
    this.accelerateModeEnabled = accelerateModeEnabled;
  }
  
  public Subclass withAccelerateModeEnabled(Boolean accelerateModeEnabled)
  {
    setAccelerateModeEnabled(accelerateModeEnabled);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Subclass enableAccelerateMode()
  {
    setAccelerateModeEnabled(Boolean.TRUE);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Boolean isPayloadSigningEnabled()
  {
    return payloadSigningEnabled;
  }
  
  public void setPayloadSigningEnabled(Boolean payloadSigningEnabled)
  {
    this.payloadSigningEnabled = payloadSigningEnabled;
  }
  
  public Subclass withPayloadSigningEnabled(Boolean payloadSigningEnabled)
  {
    setPayloadSigningEnabled(payloadSigningEnabled);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Subclass enablePayloadSigning()
  {
    setPayloadSigningEnabled(Boolean.TRUE);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Boolean isDualstackEnabled()
  {
    return dualstackEnabled;
  }
  
  public void setDualstackEnabled(Boolean dualstackEnabled)
  {
    this.dualstackEnabled = dualstackEnabled;
  }
  
  public Subclass withDualstackEnabled(Boolean dualstackEnabled)
  {
    setDualstackEnabled(dualstackEnabled);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Subclass enableDualstack()
  {
    setDualstackEnabled(Boolean.TRUE);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Boolean isForceGlobalBucketAccessEnabled()
  {
    return forceGlobalBucketAccessEnabled;
  }
  
  public void setForceGlobalBucketAccessEnabled(Boolean forceGlobalBucketAccessEnabled)
  {
    this.forceGlobalBucketAccessEnabled = forceGlobalBucketAccessEnabled;
  }
  
  public Subclass withForceGlobalBucketAccessEnabled(Boolean forceGlobalBucketAccessEnabled)
  {
    setForceGlobalBucketAccessEnabled(forceGlobalBucketAccessEnabled);
    return (AmazonS3Builder)getSubclass();
  }
  
  public Subclass enableForceGlobalBucketAccess()
  {
    setForceGlobalBucketAccessEnabled(Boolean.TRUE);
    return (AmazonS3Builder)getSubclass();
  }
  
  protected S3ClientOptions resolveS3ClientOptions()
  {
    S3ClientOptions.Builder builder = S3ClientOptions.builder();
    if (Boolean.TRUE.equals(chunkedEncodingDisabled)) {
      builder.disableChunkedEncoding();
    }
    if (payloadSigningEnabled != null) {
      builder.setPayloadSigningEnabled(payloadSigningEnabled.booleanValue());
    }
    if (accelerateModeEnabled != null) {
      builder.setAccelerateModeEnabled(accelerateModeEnabled.booleanValue());
    }
    if (pathStyleAccessEnabled != null) {
      builder.setPathStyleAccess(pathStyleAccessEnabled.booleanValue());
    }
    if (Boolean.TRUE.equals(dualstackEnabled)) {
      builder.enableDualstack();
    }
    if (Boolean.TRUE.equals(forceGlobalBucketAccessEnabled)) {
      builder.enableForceGlobalBucketAccess();
    }
    return builder.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */