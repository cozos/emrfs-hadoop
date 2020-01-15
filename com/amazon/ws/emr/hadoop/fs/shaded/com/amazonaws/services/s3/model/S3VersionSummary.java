package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class S3VersionSummary
  implements Serializable
{
  protected String bucketName;
  private String key;
  private String versionId;
  private boolean isLatest;
  private Date lastModified;
  private Owner owner;
  private String eTag;
  private long size;
  private String storageClass;
  private boolean isDeleteMarker;
  
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
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String id)
  {
    versionId = id;
  }
  
  public boolean isLatest()
  {
    return isLatest;
  }
  
  public void setIsLatest(boolean isLatest)
  {
    this.isLatest = isLatest;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public void setLastModified(Date lastModified)
  {
    this.lastModified = lastModified;
  }
  
  public Owner getOwner()
  {
    return owner;
  }
  
  public void setOwner(Owner owner)
  {
    this.owner = owner;
  }
  
  public boolean isDeleteMarker()
  {
    return isDeleteMarker;
  }
  
  public void setIsDeleteMarker(boolean isDeleteMarker)
  {
    this.isDeleteMarker = isDeleteMarker;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public void setETag(String eTag)
  {
    this.eTag = eTag;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public long getSize()
  {
    return size;
  }
  
  public void setSize(long size)
  {
    this.size = size;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3VersionSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */