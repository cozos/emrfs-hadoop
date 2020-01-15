package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class S3ClientOptions
{
  public static final boolean DEFAULT_PATH_STYLE_ACCESS = false;
  public static final boolean DEFAULT_CHUNKED_ENCODING_DISABLED = false;
  public static final boolean DEFAULT_PAYLOAD_SIGNING_ENABLED = false;
  public static final boolean DEFAULT_ACCELERATE_MODE_ENABLED = false;
  public static final boolean DEFAULT_DUALSTACK_ENABLED = false;
  public static final boolean DEFAULT_FORCE_GLOBAL_BUCKET_ACCESS_ENABLED = false;
  private boolean pathStyleAccess;
  private boolean chunkedEncodingDisabled;
  private final boolean accelerateModeEnabled;
  private final boolean payloadSigningEnabled;
  private final boolean dualstackEnabled;
  private final boolean forceGlobalBucketAccessEnabled;
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static class Builder
  {
    private boolean pathStyleAccess = false;
    private boolean chunkedEncodingDisabled = false;
    private boolean accelerateModeEnabled = false;
    private boolean payloadSigningEnabled = false;
    private boolean dualstackEnabled = false;
    private boolean forceGlobalBucketAccessEnabled = false;
    
    public S3ClientOptions build()
    {
      if ((pathStyleAccess) && (accelerateModeEnabled)) {
        throw new SdkClientException("Both accelerate mode and path style access are being enabled either through S3ClientOptions or AmazonS3ClientBuilder. These options are mutually exclusive and cannot be enabled together. Please disable one of them");
      }
      return new S3ClientOptions(pathStyleAccess, chunkedEncodingDisabled, accelerateModeEnabled, payloadSigningEnabled, dualstackEnabled, forceGlobalBucketAccessEnabled, null);
    }
    
    public Builder setPathStyleAccess(boolean pathStyleAccess)
    {
      this.pathStyleAccess = pathStyleAccess;
      return this;
    }
    
    public Builder setAccelerateModeEnabled(boolean accelerateModeEnabled)
    {
      this.accelerateModeEnabled = accelerateModeEnabled;
      return this;
    }
    
    public Builder setPayloadSigningEnabled(boolean payloadSigningEnabled)
    {
      this.payloadSigningEnabled = payloadSigningEnabled;
      return this;
    }
    
    public Builder disableChunkedEncoding()
    {
      chunkedEncodingDisabled = true;
      return this;
    }
    
    public Builder enableDualstack()
    {
      dualstackEnabled = true;
      return this;
    }
    
    public Builder enableForceGlobalBucketAccess()
    {
      forceGlobalBucketAccessEnabled = true;
      return this;
    }
  }
  
  @Deprecated
  public S3ClientOptions()
  {
    pathStyleAccess = false;
    chunkedEncodingDisabled = false;
    accelerateModeEnabled = false;
    payloadSigningEnabled = false;
    dualstackEnabled = false;
    forceGlobalBucketAccessEnabled = false;
  }
  
  @Deprecated
  public S3ClientOptions(S3ClientOptions other)
  {
    pathStyleAccess = pathStyleAccess;
    chunkedEncodingDisabled = chunkedEncodingDisabled;
    accelerateModeEnabled = accelerateModeEnabled;
    payloadSigningEnabled = payloadSigningEnabled;
    dualstackEnabled = dualstackEnabled;
    forceGlobalBucketAccessEnabled = forceGlobalBucketAccessEnabled;
  }
  
  private S3ClientOptions(boolean pathStyleAccess, boolean chunkedEncodingDisabled, boolean accelerateModeEnabled, boolean payloadSigningEnabled, boolean dualstackEnabled, boolean forceGlobalBucketAccessEnabled)
  {
    this.pathStyleAccess = pathStyleAccess;
    this.chunkedEncodingDisabled = chunkedEncodingDisabled;
    this.accelerateModeEnabled = accelerateModeEnabled;
    this.payloadSigningEnabled = payloadSigningEnabled;
    this.dualstackEnabled = dualstackEnabled;
    this.forceGlobalBucketAccessEnabled = forceGlobalBucketAccessEnabled;
  }
  
  public boolean isPathStyleAccess()
  {
    return pathStyleAccess;
  }
  
  public boolean isChunkedEncodingDisabled()
  {
    return chunkedEncodingDisabled;
  }
  
  public boolean isAccelerateModeEnabled()
  {
    return accelerateModeEnabled;
  }
  
  public boolean isPayloadSigningEnabled()
  {
    return payloadSigningEnabled;
  }
  
  public boolean isDualstackEnabled()
  {
    return dualstackEnabled;
  }
  
  public boolean isForceGlobalBucketAccessEnabled()
  {
    return forceGlobalBucketAccessEnabled;
  }
  
  @Deprecated
  public void setPathStyleAccess(boolean pathStyleAccess)
  {
    this.pathStyleAccess = pathStyleAccess;
  }
  
  @Deprecated
  public S3ClientOptions withPathStyleAccess(boolean pathStyleAccess)
  {
    setPathStyleAccess(pathStyleAccess);
    return this;
  }
  
  @Deprecated
  public void setChunkedEncodingDisabled(boolean chunkedEncodingDisabled)
  {
    this.chunkedEncodingDisabled = chunkedEncodingDisabled;
  }
  
  @Deprecated
  public S3ClientOptions withChunkedEncodingDisabled(boolean chunkedEncodingDisabled)
  {
    setChunkedEncodingDisabled(chunkedEncodingDisabled);
    return this;
  }
  
  @Deprecated
  public S3ClientOptions disableChunkedEncoding()
  {
    return withChunkedEncodingDisabled(true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.S3ClientOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */