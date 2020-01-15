package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import java.util.Collection;

public final class AbortMultipartUploadCall
  extends AbstractS3GenericCall<Void, AbortMultipartUploadRequest>
{
  public AbortMultipartUploadCall(AbortMultipartUploadRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((AbortMultipartUploadRequest)request).getBucketName();
  }
  
  public Void perform(AmazonS3 amazonS3)
  {
    amazonS3.abortMultipartUpload((AbortMultipartUploadRequest)request);
    return null;
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((AbortMultipartUploadRequest)request).getBucketName(), ((AbortMultipartUploadRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.AbortMultipartUploadCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */