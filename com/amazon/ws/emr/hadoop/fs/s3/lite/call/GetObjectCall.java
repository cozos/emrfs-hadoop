package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import java.util.Collection;

public final class GetObjectCall
  extends AbstractS3GenericCall<S3Object, GetObjectRequest>
{
  public GetObjectCall(GetObjectRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((GetObjectRequest)request).getBucketName();
  }
  
  public S3Object perform(AmazonS3 amazonS3)
  {
    return amazonS3.getObject((GetObjectRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((GetObjectRequest)request).getBucketName(), ((GetObjectRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.GetObjectCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */