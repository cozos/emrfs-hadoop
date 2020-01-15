package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteVersionRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private String versionId;
  private MultiFactorAuthentication mfa;
  private boolean bypassGovernanceRetention;
  
  public DeleteVersionRequest(String bucketName, String key, String versionId)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.versionId = versionId;
  }
  
  public DeleteVersionRequest(String bucketName, String key, String versionId, MultiFactorAuthentication mfa)
  {
    this(bucketName, key, versionId);
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
  
  public DeleteVersionRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public DeleteVersionRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public DeleteVersionRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
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
  
  public DeleteVersionRequest withMfa(MultiFactorAuthentication mfa)
  {
    setMfa(mfa);
    return this;
  }
  
  public boolean getBypassGovernanceRetention()
  {
    return bypassGovernanceRetention;
  }
  
  public DeleteVersionRequest withBypassGovernanceRetention(boolean bypassGovernanceRetention)
  {
    this.bypassGovernanceRetention = bypassGovernanceRetention;
    return this;
  }
  
  public void setBypassGovernanceRetention(boolean bypassGovernanceRetention)
  {
    withBypassGovernanceRetention(bypassGovernanceRetention);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteVersionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */