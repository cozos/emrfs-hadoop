package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;

public abstract interface S3GenericCall<R>
  extends S3Call<R, AmazonS3>
{}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3GenericCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */