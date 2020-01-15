package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class S3ClientOptions$Builder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.S3ClientOptions.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */