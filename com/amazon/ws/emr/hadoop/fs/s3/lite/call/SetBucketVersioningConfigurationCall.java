package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest;
import java.util.Collection;

public final class SetBucketVersioningConfigurationCall
  extends AbstractS3GenericCall<Void, SetBucketVersioningConfigurationRequest>
{
  public SetBucketVersioningConfigurationCall(SetBucketVersioningConfigurationRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((SetBucketVersioningConfigurationRequest)request).getBucketName();
  }
  
  public Void perform(AmazonS3 client)
  {
    client.setBucketVersioningConfiguration((SetBucketVersioningConfigurationRequest)request);
    return null;
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucket(((SetBucketVersioningConfigurationRequest)request).getBucketName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.SetBucketVersioningConfigurationCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */