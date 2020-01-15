package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListPartsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private String uploadId;
  private Integer maxParts;
  private Integer partNumberMarker;
  private String encodingType;
  private boolean isRequesterPays;
  
  public ListPartsRequest(String bucketName, String key, String uploadId)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.uploadId = uploadId;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public ListPartsRequest withBucketName(String bucketName)
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
  
  public ListPartsRequest withKey(String key)
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
  
  public ListPartsRequest withUploadId(String uploadId)
  {
    this.uploadId = uploadId;
    return this;
  }
  
  public Integer getMaxParts()
  {
    return maxParts;
  }
  
  public void setMaxParts(int maxParts)
  {
    this.maxParts = Integer.valueOf(maxParts);
  }
  
  public ListPartsRequest withMaxParts(int maxParts)
  {
    this.maxParts = Integer.valueOf(maxParts);
    return this;
  }
  
  public Integer getPartNumberMarker()
  {
    return partNumberMarker;
  }
  
  public void setPartNumberMarker(Integer partNumberMarker)
  {
    this.partNumberMarker = partNumberMarker;
  }
  
  public ListPartsRequest withPartNumberMarker(Integer partNumberMarker)
  {
    this.partNumberMarker = partNumberMarker;
    return this;
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public void setEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
  
  public ListPartsRequest withEncodingType(String encodingType)
  {
    setEncodingType(encodingType);
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
  
  public ListPartsRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListPartsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */