package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model;

public class CopyResult
{
  private String sourceBucketName;
  private String sourceKey;
  private String destinationBucketName;
  private String destinationKey;
  private String eTag;
  private String versionId;
  
  public String getSourceBucketName()
  {
    return sourceBucketName;
  }
  
  public void setSourceBucketName(String sourceBucketName)
  {
    this.sourceBucketName = sourceBucketName;
  }
  
  public String getSourceKey()
  {
    return sourceKey;
  }
  
  public void setSourceKey(String sourceKey)
  {
    this.sourceKey = sourceKey;
  }
  
  public String getDestinationBucketName()
  {
    return destinationBucketName;
  }
  
  public void setDestinationBucketName(String destinationBucketName)
  {
    this.destinationBucketName = destinationBucketName;
  }
  
  public String getDestinationKey()
  {
    return destinationKey;
  }
  
  public void setDestinationKey(String destinationKey)
  {
    this.destinationKey = destinationKey;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.CopyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */