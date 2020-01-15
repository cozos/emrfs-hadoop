package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult;
import java.util.Collection;

public final class CopyPartCall
  extends AbstractS3GenericCall<CopyPartResult, CopyPartRequest>
{
  public CopyPartCall(CopyPartRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((CopyPartRequest)request).getDestinationBucketName();
  }
  
  public CopyPartResult perform(AmazonS3 amazonS3)
  {
    return amazonS3.copyPart((CopyPartRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromSourceAndDestination(((CopyPartRequest)request)
      .getSourceBucketName(), ((CopyPartRequest)request).getSourceKey(), ((CopyPartRequest)request)
      .getDestinationBucketName(), ((CopyPartRequest)request).getDestinationKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.CopyPartCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */