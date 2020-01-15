package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class HeadBucketFunction
  implements SdkFunction<HeadBucketRequest, HeadBucketResult>
{
  private final AmazonS3 client;
  
  public HeadBucketFunction(AmazonS3 client)
  {
    this.client = client;
  }
  
  public HeadBucketResult apply(HeadBucketRequest headBucketRequest)
  {
    return client.headBucket(headBucketRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters.HeadBucketFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */