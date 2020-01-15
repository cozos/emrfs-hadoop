package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketVersioningConfigurationRequest;
import java.util.Collection;

public final class GetBucketVersioningConfigurationCall
  extends AbstractS3GenericCall<BucketVersioningConfiguration, GetBucketVersioningConfigurationRequest>
{
  public GetBucketVersioningConfigurationCall(String bucketName)
  {
    super(new GetBucketVersioningConfigurationRequest(bucketName));
  }
  
  public String getBucketName()
  {
    return ((GetBucketVersioningConfigurationRequest)request).getBucketName();
  }
  
  public BucketVersioningConfiguration perform(AmazonS3 client)
  {
    return client.getBucketVersioningConfiguration((GetBucketVersioningConfigurationRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucket(((GetBucketVersioningConfigurationRequest)request).getBucketName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.GetBucketVersioningConfigurationCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */