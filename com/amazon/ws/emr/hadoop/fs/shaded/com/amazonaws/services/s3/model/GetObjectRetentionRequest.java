package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetObjectRetentionRequest
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
  
  public GetObjectRetentionRequest withBucketName(String bucket)
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
  
  public GetObjectRetentionRequest withKey(String key)
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
  
  public GetObjectRetentionRequest withVersionId(String versionId)
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
  
  public GetObjectRetentionRequest withRequesterPays(boolean isRequesterPays)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */