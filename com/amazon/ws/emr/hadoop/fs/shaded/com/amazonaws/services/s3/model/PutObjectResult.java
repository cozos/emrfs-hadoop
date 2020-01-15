package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

public class PutObjectResult
  extends SSEResultBase
  implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult, Serializable
{
  private String versionId;
  private String eTag;
  private Date expirationTime;
  private String expirationTimeRuleId;
  private String contentMd5;
  private ObjectMetadata metadata;
  private boolean isRequesterCharged;
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public void setETag(String eTag)
  {
    this.eTag = eTag;
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
  
  public void setContentMd5(String contentMd5)
  {
    this.contentMd5 = contentMd5;
  }
  
  public String getContentMd5()
  {
    return contentMd5;
  }
  
  public ObjectMetadata getMetadata()
  {
    return metadata;
  }
  
  public void setMetadata(ObjectMetadata metadata)
  {
    this.metadata = metadata;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */