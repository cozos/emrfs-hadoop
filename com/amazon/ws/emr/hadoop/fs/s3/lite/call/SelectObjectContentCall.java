package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SelectObjectContentResult;
import java.util.Collection;

public final class SelectObjectContentCall
  extends AbstractS3GenericCall<SelectObjectContentResult, SelectObjectContentRequest>
{
  public SelectObjectContentCall(SelectObjectContentRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((SelectObjectContentRequest)request).getBucketName();
  }
  
  public SelectObjectContentResult perform(AmazonS3 amazonS3)
  {
    return amazonS3.selectObjectContent((SelectObjectContentRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((SelectObjectContentRequest)request).getBucketName(), ((SelectObjectContentRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.SelectObjectContentCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */