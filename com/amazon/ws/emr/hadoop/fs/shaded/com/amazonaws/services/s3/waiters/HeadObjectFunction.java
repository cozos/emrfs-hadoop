package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class HeadObjectFunction
  implements SdkFunction<GetObjectMetadataRequest, ObjectMetadata>
{
  private final AmazonS3 client;
  
  public HeadObjectFunction(AmazonS3 client)
  {
    this.client = client;
  }
  
  public ObjectMetadata apply(GetObjectMetadataRequest headObjectRequest)
  {
    return client.getObjectMetadata(headObjectRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.waiters.HeadObjectFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */