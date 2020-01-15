package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetObjectLegalHoldRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucket;
  private String key;
  private ObjectLockLegalHold legalHold;
  private boolean isRequesterPays;
  private String versionId;
  
  public String getBucketName()
  {
    return bucket;
  }
  
  public SetObjectLegalHoldRequest withBucketName(String bucket)
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
  
  public SetObjectLegalHoldRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public void setKey(String key)
  {
    withKey(key);
  }
  
  public ObjectLockLegalHold getLegalHold()
  {
    return legalHold;
  }
  
  public SetObjectLegalHoldRequest withLegalHold(ObjectLockLegalHold legalHold)
  {
    this.legalHold = legalHold;
    return this;
  }
  
  public void setLegalHold(ObjectLockLegalHold legalHold)
  {
    withLegalHold(legalHold);
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public SetObjectLegalHoldRequest withRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
    return this;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public SetObjectLegalHoldRequest withVersionId(String versionId)
  {
    this.versionId = versionId;
    return this;
  }
  
  public void setVersionId(String versionId)
  {
    withVersionId(versionId);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectLegalHoldRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */