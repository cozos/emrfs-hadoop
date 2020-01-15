package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import java.util.Collection;

public final class CompleteMultipartUploadCall
  extends AbstractS3GenericCall<CompleteMultipartUploadResult, CompleteMultipartUploadRequest>
{
  public CompleteMultipartUploadCall(CompleteMultipartUploadRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((CompleteMultipartUploadRequest)request).getBucketName();
  }
  
  public CompleteMultipartUploadResult perform(AmazonS3 amazonS3)
  {
    return amazonS3.completeMultipartUpload((CompleteMultipartUploadRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((CompleteMultipartUploadRequest)request).getBucketName(), ((CompleteMultipartUploadRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.CompleteMultipartUploadCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */