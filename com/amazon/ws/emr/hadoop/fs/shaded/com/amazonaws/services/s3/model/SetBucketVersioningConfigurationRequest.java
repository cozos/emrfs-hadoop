package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketVersioningConfigurationRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private BucketVersioningConfiguration versioningConfiguration;
  private MultiFactorAuthentication mfa;
  
  public SetBucketVersioningConfigurationRequest(String bucketName, BucketVersioningConfiguration configuration)
  {
    this.bucketName = bucketName;
    versioningConfiguration = configuration;
  }
  
  public SetBucketVersioningConfigurationRequest(String bucketName, BucketVersioningConfiguration configuration, MultiFactorAuthentication mfa)
  {
    this(bucketName, configuration);
    this.mfa = mfa;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketVersioningConfigurationRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public BucketVersioningConfiguration getVersioningConfiguration()
  {
    return versioningConfiguration;
  }
  
  public void setVersioningConfiguration(BucketVersioningConfiguration versioningConfiguration)
  {
    this.versioningConfiguration = versioningConfiguration;
  }
  
  public SetBucketVersioningConfigurationRequest withVersioningConfiguration(BucketVersioningConfiguration versioningConfiguration)
  {
    setVersioningConfiguration(versioningConfiguration);
    return this;
  }
  
  public MultiFactorAuthentication getMfa()
  {
    return mfa;
  }
  
  public void setMfa(MultiFactorAuthentication mfa)
  {
    this.mfa = mfa;
  }
  
  public SetBucketVersioningConfigurationRequest withMfa(MultiFactorAuthentication mfa)
  {
    setMfa(mfa);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */