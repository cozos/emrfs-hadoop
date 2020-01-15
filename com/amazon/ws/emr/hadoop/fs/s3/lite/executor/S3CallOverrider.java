package com.amazon.ws.emr.hadoop.fs.s3.lite.executor;

import com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Call;

public abstract interface S3CallOverrider
{
  public abstract S3Call override(S3Call paramS3Call);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.executor.S3CallOverrider
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */