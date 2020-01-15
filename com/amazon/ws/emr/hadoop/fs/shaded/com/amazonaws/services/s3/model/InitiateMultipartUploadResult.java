package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

public class InitiateMultipartUploadResult
  extends SSEResultBase
  implements S3RequesterChargedResult, Serializable
{
  private String bucketName;
  private String key;
  private String uploadId;
  private Date abortDate;
  private String abortRuleId;
  private boolean isRequesterCharged;
  
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
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public void setUploadId(String uploadId)
  {
    this.uploadId = uploadId;
  }
  
  public Date getAbortDate()
  {
    return abortDate;
  }
  
  public void setAbortDate(Date abortDate)
  {
    this.abortDate = abortDate;
  }
  
  public String getAbortRuleId()
  {
    return abortRuleId;
  }
  
  public void setAbortRuleId(String abortRuleId)
  {
    this.abortRuleId = abortRuleId;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */