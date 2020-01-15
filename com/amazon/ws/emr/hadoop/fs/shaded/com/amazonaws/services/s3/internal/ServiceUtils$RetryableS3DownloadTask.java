package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;

public abstract interface ServiceUtils$RetryableS3DownloadTask
{
  public abstract S3Object getS3ObjectStream();
  
  public abstract boolean needIntegrityCheck();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */