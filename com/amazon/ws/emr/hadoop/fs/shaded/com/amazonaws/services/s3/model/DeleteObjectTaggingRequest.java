package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteObjectTaggingRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private String versionId;
  
  public DeleteObjectTaggingRequest(String bucketName, String key)
  {
    this.bucketName = bucketName;
    this.key = key;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public DeleteObjectTaggingRequest withBucketName(String bucketName)
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
  
  public DeleteObjectTaggingRequest withKey(String key)
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
  
  public DeleteObjectTaggingRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectTaggingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */