package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Encryption;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SkipMd5CheckStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;

@SdkInternalApi
public class PresignedUrlRetryableDownloadTaskImpl
  implements ServiceUtils.RetryableS3DownloadTask
{
  private final AmazonS3 s3;
  private final PresignedUrlDownloadImpl download;
  private final PresignedUrlDownloadRequest request;
  private final SkipMd5CheckStrategy skipMd5CheckStrategy = SkipMd5CheckStrategy.INSTANCE;
  
  public PresignedUrlRetryableDownloadTaskImpl(AmazonS3 s3, PresignedUrlDownloadImpl download, PresignedUrlDownloadRequest request)
  {
    this.s3 = s3;
    this.download = download;
    this.request = request;
  }
  
  public S3Object getS3ObjectStream()
  {
    S3Object s3Object = s3.download(request).getS3Object();
    download.setS3Object(s3Object);
    return s3Object;
  }
  
  public boolean needIntegrityCheck()
  {
    return (!(s3 instanceof AmazonS3Encryption)) && 
      (!skipMd5CheckStrategy.skipClientSideValidationPerRequest(request));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignedUrlRetryableDownloadTaskImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */