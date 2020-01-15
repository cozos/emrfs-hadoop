package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetObjectMetadataRequest
  extends AmazonWebServiceRequest
  implements SSECustomerKeyProvider, Serializable
{
  private String bucketName;
  private String key;
  private String versionId;
  private boolean isRequesterPays;
  private SSECustomerKey sseCustomerKey;
  private Integer partNumber;
  
  public GetObjectMetadataRequest(String bucketName, String key)
  {
    setBucketName(bucketName);
    setKey(key);
  }
  
  public GetObjectMetadataRequest(String bucketName, String key, String versionId)
  {
    this(bucketName, key);
    setVersionId(versionId);
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public GetObjectMetadataRequest withBucketName(String bucketName)
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
  
  public GetObjectMetadataRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public GetObjectMetadataRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
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
  
  public GetObjectMetadataRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
  
  public SSECustomerKey getSSECustomerKey()
  {
    return sseCustomerKey;
  }
  
  public void setSSECustomerKey(SSECustomerKey sseKey)
  {
    sseCustomerKey = sseKey;
  }
  
  public GetObjectMetadataRequest withSSECustomerKey(SSECustomerKey sseKey)
  {
    setSSECustomerKey(sseKey);
    return this;
  }
  
  public Integer getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(Integer partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public GetObjectMetadataRequest withPartNumber(Integer partNumber)
  {
    setPartNumber(partNumber);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */