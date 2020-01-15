package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetObjectTaggingRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private String versionId;
  
  public GetObjectTaggingRequest(String bucketName, String key, String versionId)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.versionId = versionId;
  }
  
  public GetObjectTaggingRequest(String bucketName, String key)
  {
    this(bucketName, key, null);
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GetObjectTaggingRequest withBucketName(String bucketName)
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
  
  public GetObjectTaggingRequest withKey(String key)
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
  
  public GetObjectTaggingRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectTaggingRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */