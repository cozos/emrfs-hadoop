package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFunction;

final class AmazonS3Builder$1
  implements SdkFunction<AmazonS3ClientParamsWrapper, AmazonS3>
{
  public AmazonS3 apply(AmazonS3ClientParamsWrapper params)
  {
    return new AmazonS3Client(params);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3Builder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */