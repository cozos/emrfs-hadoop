package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetPublicAccessBlockRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String bucketName;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GetPublicAccessBlockRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    GetPublicAccessBlockRequest that = (GetPublicAccessBlockRequest)o;
    
    return bucketName == null ? true : bucketName != null ? bucketName.equals(bucketName) : false;
  }
  
  public int hashCode()
  {
    return bucketName != null ? bucketName.hashCode() : 0;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBucketName() != null) {
      sb.append("BucketName: ").append(getBucketName()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public GetPublicAccessBlockRequest clone()
  {
    return (GetPublicAccessBlockRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetPublicAccessBlockRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */