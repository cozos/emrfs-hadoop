package com.amazon.ws.emr.hadoop.fs.s3.lite.provider;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;

public abstract interface S3Provider<C extends AmazonS3>
{
  public abstract C getS3(String paramString);
  
  public abstract C getS3WithInitialTimeoutOrS3Default(String paramString);
  
  public abstract boolean isInitialTimeoutSet();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.provider.S3Provider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */