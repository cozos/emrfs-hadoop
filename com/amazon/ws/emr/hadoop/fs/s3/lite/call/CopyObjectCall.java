package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectResult;
import java.util.Collection;

public final class CopyObjectCall
  extends AbstractS3GenericCall<CopyObjectResult, CopyObjectRequest>
{
  public CopyObjectCall(CopyObjectRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((CopyObjectRequest)request).getDestinationBucketName();
  }
  
  public CopyObjectResult perform(AmazonS3 amazonS3)
  {
    return amazonS3.copyObject((CopyObjectRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromSourceAndDestination(((CopyObjectRequest)request)
      .getSourceBucketName(), ((CopyObjectRequest)request).getSourceKey(), ((CopyObjectRequest)request)
      .getDestinationBucketName(), ((CopyObjectRequest)request).getDestinationKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.CopyObjectCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */