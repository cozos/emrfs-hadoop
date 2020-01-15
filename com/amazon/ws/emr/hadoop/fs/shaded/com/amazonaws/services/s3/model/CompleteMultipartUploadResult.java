package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

public class CompleteMultipartUploadResult
  extends SSEResultBase
  implements ObjectExpirationResult, S3RequesterChargedResult, Serializable
{
  private String bucketName;
  private String key;
  private String location;
  private String eTag;
  private String versionId;
  private Date expirationTime;
  private String expirationTimeRuleId;
  private boolean isRequesterCharged;
  
  public String getLocation()
  {
    return location;
  }
  
  public void setLocation(String location)
  {
    this.location = location;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public void setETag(String etag)
  {
    eTag = etag;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public Date getExpirationTime()
  {
    return expirationTime;
  }
  
  public void setExpirationTime(Date expirationTime)
  {
    this.expirationTime = expirationTime;
  }
  
  public String getExpirationTimeRuleId()
  {
    return expirationTimeRuleId;
  }
  
  public void setExpirationTimeRuleId(String expirationTimeRuleId)
  {
    this.expirationTimeRuleId = expirationTimeRuleId;
  }
  
  public boolean isRequesterCharged()
  {
    return isRequesterCharged;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    this.isRequesterCharged = isRequesterCharged;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */