package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartListing
  implements Serializable, S3RequesterChargedResult
{
  private String bucketName;
  private String key;
  private String uploadId;
  private Integer maxParts;
  private Integer partNumberMarker;
  private String encodingType;
  private Owner owner;
  private Owner initiator;
  private String storageClass;
  private boolean isTruncated;
  private Integer nextPartNumberMarker;
  private List<PartSummary> parts;
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
  
  public Owner getOwner()
  {
    return owner;
  }
  
  public void setOwner(Owner owner)
  {
    this.owner = owner;
  }
  
  public Owner getInitiator()
  {
    return initiator;
  }
  
  public void setInitiator(Owner initiator)
  {
    this.initiator = initiator;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public Integer getPartNumberMarker()
  {
    return partNumberMarker;
  }
  
  public void setPartNumberMarker(int partNumberMarker)
  {
    this.partNumberMarker = Integer.valueOf(partNumberMarker);
  }
  
  public Integer getNextPartNumberMarker()
  {
    return nextPartNumberMarker;
  }
  
  public void setNextPartNumberMarker(int nextPartNumberMarker)
  {
    this.nextPartNumberMarker = Integer.valueOf(nextPartNumberMarker);
  }
  
  public Integer getMaxParts()
  {
    return maxParts;
  }
  
  public void setMaxParts(int maxParts)
  {
    this.maxParts = Integer.valueOf(maxParts);
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public void setEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
  
  public boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setTruncated(boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public List<PartSummary> getParts()
  {
    if (parts == null) {
      parts = new ArrayList();
    }
    return parts;
  }
  
  public void setParts(List<PartSummary> parts)
  {
    this.parts = parts;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */