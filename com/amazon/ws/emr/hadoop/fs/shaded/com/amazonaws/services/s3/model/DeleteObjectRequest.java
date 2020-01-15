package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteObjectRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private boolean isRequesterPays;
  
  public DeleteObjectRequest(String bucketName, String key)
  {
    setBucketName(bucketName);
    setKey(key);
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public DeleteObjectRequest withBucketName(String bucketName)
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
  
  public DeleteObjectRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public DeleteObjectRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */