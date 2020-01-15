package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;

final class S3Resources$GenericS3Resource
  implements S3Resource
{
  private final S3Resource.Type type;
  private final String bucketName;
  private final String path;
  
  private S3Resources$GenericS3Resource(S3Resource.Type type, String bucketName, String path)
  {
    this.type = type;
    this.bucketName = bucketName;
    this.path = path;
  }
  
  public S3Resource.Type getType()
  {
    return type;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public String toString()
  {
    if (!Strings.isNullOrEmpty(path)) {
      return type + " : " + bucketName + "/" + path;
    }
    return type + " : " + bucketName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resources.GenericS3Resource
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */