package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

@Immutable
@SdkInternalApi
class AmazonS3ClientParamsWrapper
  extends AmazonS3ClientParams
{
  private final AwsSyncClientParams clientParams;
  private final S3ClientOptions s3ClientOptions;
  
  public AmazonS3ClientParamsWrapper(AwsSyncClientParams delegate, S3ClientOptions s3ClientOptions)
  {
    clientParams = ((AwsSyncClientParams)ValidationUtils.assertNotNull(delegate, "delegate"));
    this.s3ClientOptions = s3ClientOptions;
  }
  
  public AwsSyncClientParams getClientParams()
  {
    return clientParams;
  }
  
  public S3ClientOptions getS3ClientOptions()
  {
    return s3ClientOptions;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3ClientParamsWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */