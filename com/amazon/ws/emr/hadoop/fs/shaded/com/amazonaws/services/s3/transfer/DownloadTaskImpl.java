package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Encryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SkipMd5CheckStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadImpl;

final class DownloadTaskImpl
  implements ServiceUtils.RetryableS3DownloadTask
{
  private final AmazonS3 s3;
  private final DownloadImpl download;
  private final GetObjectRequest getObjectRequest;
  private final SkipMd5CheckStrategy skipMd5CheckStrategy = SkipMd5CheckStrategy.INSTANCE;
  
  DownloadTaskImpl(AmazonS3 s3, DownloadImpl download, GetObjectRequest getObjectRequest)
  {
    this.s3 = s3;
    this.download = download;
    this.getObjectRequest = getObjectRequest;
  }
  
  public S3Object getS3ObjectStream()
  {
    S3Object s3Object = s3.getObject(getObjectRequest);
    download.setS3Object(s3Object);
    return s3Object;
  }
  
  public boolean needIntegrityCheck()
  {
    return (!(s3 instanceof AmazonS3Encryption)) && (!skipMd5CheckStrategy.skipClientSideValidationPerRequest(getObjectRequest));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.DownloadTaskImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */