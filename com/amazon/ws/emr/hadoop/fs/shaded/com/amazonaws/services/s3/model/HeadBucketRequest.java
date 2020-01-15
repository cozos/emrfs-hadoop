package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class HeadBucketRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public HeadBucketRequest(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof HeadBucketRequest)) {
      return false;
    }
    HeadBucketRequest other = (HeadBucketRequest)obj;
    if (((other.getBucketName() == null ? 1 : 0) ^ (getBucketName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBucketName() != null) && (!other.getBucketName().equals(getBucketName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    hashCode = 31 * hashCode + (getBucketName() == null ? 0 : getBucketName().hashCode());
    return hashCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */