package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model;

public class UploadResult
{
  private String bucketName;
  private String key;
  private String eTag;
  private String versionId;
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.UploadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */