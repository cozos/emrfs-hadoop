package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class PresignedUrlUploadResult
  implements Serializable
{
  private ObjectMetadata metadata;
  private String contentMd5;
  
  public void setContentMd5(String contentMd5)
  {
    this.contentMd5 = contentMd5;
  }
  
  public PresignedUrlUploadResult withContentMd5(String contentMd5)
  {
    setContentMd5(contentMd5);
    return this;
  }
  
  public String getContentMd5()
  {
    return contentMd5;
  }
  
  public ObjectMetadata getMetadata()
  {
    return metadata;
  }
  
  public void setMetadata(ObjectMetadata metadata)
  {
    this.metadata = metadata;
  }
  
  public PresignedUrlUploadResult withMetadata(ObjectMetadata metadata)
  {
    setMetadata(metadata);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlUploadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */