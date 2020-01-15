package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public final class S3ObjectIdBuilder
  implements Serializable
{
  private String bucket;
  private String key;
  private String versionId;
  
  public S3ObjectIdBuilder() {}
  
  public S3ObjectIdBuilder(S3ObjectId id)
  {
    bucket = id.getBucket();
    key = id.getKey();
    versionId = id.getVersionId();
  }
  
  public String getBucket()
  {
    return bucket;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setBucket(String bucket)
  {
    this.bucket = bucket;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public S3ObjectIdBuilder withBucket(String bucket)
  {
    this.bucket = bucket;
    return this;
  }
  
  public S3ObjectIdBuilder withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public S3ObjectIdBuilder withVersionId(String versionId)
  {
    this.versionId = versionId;
    return this;
  }
  
  public S3ObjectId build()
  {
    return new S3ObjectId(bucket, key, versionId);
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    S3ObjectIdBuilder that = (S3ObjectIdBuilder)o;
    if (bucket != null ? !bucket.equals(bucket) : bucket != null) {
      return false;
    }
    if (key != null ? !key.equals(key) : key != null) {
      return false;
    }
    return versionId == null ? true : versionId != null ? versionId.equals(versionId) : false;
  }
  
  public int hashCode()
  {
    int result = bucket != null ? bucket.hashCode() : 0;
    result = 31 * result + (key != null ? key.hashCode() : 0);
    result = 31 * result + (versionId != null ? versionId.hashCode() : 0);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectIdBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */