package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetObjectLegalHoldRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucket;
  private String key;
  private String versionId;
  private boolean isRequesterPays;
  
  public String getBucketName()
  {
    return bucket;
  }
  
  public GetObjectLegalHoldRequest withBucketName(String bucket)
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
  
  public GetObjectLegalHoldRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public void setKey(String key)
  {
    withKey(key);
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public GetObjectLegalHoldRequest withVersionId(String versionId)
  {
    this.versionId = versionId;
    return this;
  }
  
  public void setVersionId(String versionId)
  {
    withVersionId(versionId);
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public GetObjectLegalHoldRequest withRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
    return this;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectLegalHoldRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */