package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CreateBucketRequest;
import java.util.Collection;

public final class CreateBucketCall
  extends AbstractS3GenericCall<Bucket, CreateBucketRequest>
{
  public CreateBucketCall(CreateBucketRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((CreateBucketRequest)request).getBucketName();
  }
  
  public Bucket perform(AmazonS3 amazonS3)
  {
    return amazonS3.createBucket((CreateBucketRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucket(((CreateBucketRequest)request).getBucketName());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.CreateBucketCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */