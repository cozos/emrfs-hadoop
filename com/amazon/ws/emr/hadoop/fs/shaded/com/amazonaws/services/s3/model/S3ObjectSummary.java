package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class S3ObjectSummary
  implements Serializable
{
  protected String bucketName;
  protected String key;
  protected String eTag;
  protected long size;
  protected Date lastModified;
  protected String storageClass;
  protected Owner owner;
  
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
  
  public void setETag(String eTag)
  {
    this.eTag = eTag;
  }
  
  public long getSize()
  {
    return size;
  }
  
  public void setSize(long size)
  {
    this.size = size;
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
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public String toString()
  {
    return "S3ObjectSummary{bucketName='" + bucketName + '\'' + ", key='" + key + '\'' + ", eTag='" + eTag + '\'' + ", size=" + size + ", lastModified=" + lastModified + ", storageClass='" + storageClass + '\'' + ", owner=" + owner + '}';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */