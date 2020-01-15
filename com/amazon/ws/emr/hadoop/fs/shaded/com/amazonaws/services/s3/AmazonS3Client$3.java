package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SkipMd5CheckStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;

class AmazonS3Client$3
  implements ServiceUtils.RetryableS3DownloadTask
{
  AmazonS3Client$3(AmazonS3Client this$0, GetObjectRequest paramGetObjectRequest) {}
  
  public S3Object getS3ObjectStream()
  {
    return this$0.getObject(val$getObjectRequest);
  }
  
  public boolean needIntegrityCheck()
  {
    return !AmazonS3Client.access$000(this$0).skipClientSideValidationPerRequest(val$getObjectRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Client.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */