package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class AbortMultipartUploadRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private String uploadId;
  private boolean isRequesterPays;
  
  public AbortMultipartUploadRequest(String bucketName, String key, String uploadId)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.uploadId = uploadId;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String value)
  {
    bucketName = value;
  }
  
  public AbortMultipartUploadRequest withBucketName(String bucketName)
  {
    this.bucketName = bucketName;
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
  
  public AbortMultipartUploadRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public void setUploadId(String uploadId)
  {
    this.uploadId = uploadId;
  }
  
  public AbortMultipartUploadRequest withUploadId(String uploadId)
  {
    this.uploadId = uploadId;
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
  
  public AbortMultipartUploadRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */