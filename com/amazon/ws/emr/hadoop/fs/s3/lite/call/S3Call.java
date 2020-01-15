package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collection;

public abstract interface S3Call<R, C extends AmazonS3>
{
  public abstract String getBucketName();
  
  public abstract R perform(C paramC);
  
  public abstract void setCredentialsProvider(AWSCredentialsProvider paramAWSCredentialsProvider);
  
  public abstract Collection<S3Resource> getS3Resources();
  
  public abstract void enableRequesterPays();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */