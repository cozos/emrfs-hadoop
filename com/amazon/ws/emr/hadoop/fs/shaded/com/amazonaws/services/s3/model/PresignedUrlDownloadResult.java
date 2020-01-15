package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public final class PresignedUrlDownloadResult
{
  private S3Object s3Object;
  
  public S3Object getS3Object()
  {
    return s3Object;
  }
  
  public void setS3Object(S3Object s3Object)
  {
    this.s3Object = s3Object;
  }
  
  public PresignedUrlDownloadResult withS3Object(S3Object s3Object)
  {
    setS3Object(s3Object);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */