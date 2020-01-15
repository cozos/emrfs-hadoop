package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetObjectRetentionRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucket;
  private String key;
  private ObjectLockRetention retention;
  private boolean isRequesterPays;
  private String versionId;
  private boolean bypassGovernanceRetention;
  
  public String getBucketName()
  {
    return bucket;
  }
  
  public SetObjectRetentionRequest withBucketName(String bucket)
  {
    this.bucket = bucket;
    return this;
  }
  
  public void setBucketName(String bucket)
  {
    withBucketName(bucket);
  }
  
  public String getKey()
  {
    return key;
  }
  
  public SetObjectRetentionRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public void setKey(String key)
  {
    withKey(key);
  }
  
  public ObjectLockRetention getRetention()
  {
    return retention;
  }
  
  public SetObjectRetentionRequest withRetention(ObjectLockRetention retention)
  {
    this.retention = retention;
    return this;
  }
  
  public void setRetention(ObjectLockRetention retention)
  {
    withRetention(retention);
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public SetObjectRetentionRequest withRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
    return this;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    withRequesterPays(isRequesterPays);
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public SetObjectRetentionRequest withVersionId(String versionId)
  {
    this.versionId = versionId;
    return this;
  }
  
  public void setVersionId(String versionId)
  {
    withVersionId(versionId);
  }
  
  public boolean getBypassGovernanceRetention()
  {
    return bypassGovernanceRetention;
  }
  
  public SetObjectRetentionRequest withBypassGovernanceRetention(boolean bypassGovernanceRetention)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectRetentionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */