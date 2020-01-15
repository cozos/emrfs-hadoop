package com.amazon.ws.emr.hadoop.fs.s3.lite.factory;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;

public abstract interface S3Factory<C extends AmazonS3, S>
{
  public abstract C newS3(S paramS);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.factory.S3Factory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */