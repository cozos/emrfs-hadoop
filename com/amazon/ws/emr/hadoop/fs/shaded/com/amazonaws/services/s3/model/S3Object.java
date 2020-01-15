package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class S3Object
  implements Closeable, Serializable, S3RequesterChargedResult
{
  private static final long serialVersionUID = 1L;
  private String key = null;
  private String bucketName = null;
  private ObjectMetadata metadata = new ObjectMetadata();
  private transient S3ObjectInputStream objectContent;
  private String redirectLocation;
  private Integer taggingCount;
  private boolean isRequesterCharged;
  
  public ObjectMetadata getObjectMetadata()
  {
    return metadata;
  }
  
  public void setObjectMetadata(ObjectMetadata metadata)
  {
    this.metadata = metadata;
  }
  
  public S3ObjectInputStream getObjectContent()
  {
    return objectContent;
  }
  
  public void setObjectContent(S3ObjectInputStream objectContent)
  {
    this.objectContent = objectContent;
  }
  
  public void setObjectContent(InputStream objectContent)
  {
    setObjectContent(new S3ObjectInputStream(objectContent, this.objectContent != null ? this.objectContent
      .getHttpRequest() : null));
  }
  
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
  
  public String getRedirectLocation()
  {
    return redirectLocation;
  }
  
  public void setRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
  }
  
  public Integer getTaggingCount()
  {
    return taggingCount;
  }
  
  public void setTaggingCount(Integer taggingCount)
  {
    this.taggingCount = taggingCount;
  }
  
  public String toString()
  {
    return "S3Object [key=" + getKey() + ",bucket=" + (bucketName == null ? "<Unknown>" : bucketName) + "]";
  }
  
  public void close()
    throws IOException
  {
    InputStream is = getObjectContent();
    if (is != null) {
      is.close();
    }
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */