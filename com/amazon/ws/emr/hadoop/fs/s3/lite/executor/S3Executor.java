package com.amazon.ws.emr.hadoop.fs.s3.lite.executor;

import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;

public abstract interface S3Executor<C extends AmazonS3>
{
  public abstract <R> R execute(S3Call<R, ? super C> paramS3Call);
  
  public abstract <R> R execute(S3Call<R, ? super C> paramS3Call, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3Executor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */