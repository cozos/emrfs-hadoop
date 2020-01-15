package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;

@SdkInternalApi
abstract class AmazonS3ClientParams
{
  public abstract AwsSyncClientParams getClientParams();
  
  public abstract S3ClientOptions getS3ClientOptions();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3ClientParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */