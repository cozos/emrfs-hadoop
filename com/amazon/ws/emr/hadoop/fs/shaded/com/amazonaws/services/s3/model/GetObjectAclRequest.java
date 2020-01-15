package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetObjectAclRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private S3ObjectIdBuilder s3ObjectIdBuilder = new S3ObjectIdBuilder();
  private boolean isRequesterPays;
  
  public GetObjectAclRequest(String bucketName, String key)
  {
    this(bucketName, key, null);
  }
  
  public GetObjectAclRequest(String bucketName, String key, String versionId)
  {
    setBucketName(bucketName);
    setKey(key);
    setVersionId(versionId);
  }
  
  public String getBucketName()
  {
    return s3ObjectIdBuilder.getBucket();
  }
  
  public void setBucketName(String bucketName)
  {
    s3ObjectIdBuilder.setBucket(bucketName);
  }
  
  public GetObjectAclRequest withBucket(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getKey()
  {
    return s3ObjectIdBuilder.getKey();
  }
  
  public void setKey(String key)
  {
    s3ObjectIdBuilder.setKey(key);
  }
  
  public GetObjectAclRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public String getVersionId()
  {
    return s3ObjectIdBuilder.getVersionId();
  }
  
  public void setVersionId(String versionId)
  {
    s3ObjectIdBuilder.setVersionId(versionId);
  }
  
  public GetObjectAclRequest withVersionId(String versionId)
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
  
  public GetObjectAclRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectAclRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */