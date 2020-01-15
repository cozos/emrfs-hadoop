package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectRequest;
import java.util.Collection;

public final class DeleteObjectCall
  extends AbstractS3GenericCall<Void, DeleteObjectRequest>
{
  public DeleteObjectCall(String bucketName, String key)
  {
    super(new DeleteObjectRequest(bucketName, key));
  }
  
  public String getBucketName()
  {
    return ((DeleteObjectRequest)request).getBucketName();
  }
  
  public Void perform(AmazonS3 amazonS3)
  {
    amazonS3.deleteObject((DeleteObjectRequest)request);
    return null;
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((DeleteObjectRequest)request).getBucketName(), ((DeleteObjectRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.DeleteObjectCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */