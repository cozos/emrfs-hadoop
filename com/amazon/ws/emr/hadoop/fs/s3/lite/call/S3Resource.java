package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

public abstract interface S3Resource
{
  public abstract Type getType();
  
  public abstract String getBucketName();
  
  public abstract String getPath();
  
  public static enum Type
  {
    BUCKET,  OBJECT,  PREFIX;
    
    private Type() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resource
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */