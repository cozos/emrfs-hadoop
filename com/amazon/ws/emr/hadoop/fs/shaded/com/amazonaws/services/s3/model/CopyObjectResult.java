package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

public class CopyObjectResult
  extends SSEResultBase
  implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult, Serializable
{
  private String etag;
  private Date lastModifiedDate;
  private String versionId;
  private Date expirationTime;
  private String expirationTimeRuleId;
  private boolean isRequesterCharged;
  
  public String getETag()
  {
    return etag;
  }
  
  public void setETag(String etag)
  {
    this.etag = etag;
  }
  
  public Date getLastModifiedDate()
  {
    return lastModifiedDate;
  }
  
  public void setLastModifiedDate(Date lastModifiedDate)
  {
    this.lastModifiedDate = lastModifiedDate;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */