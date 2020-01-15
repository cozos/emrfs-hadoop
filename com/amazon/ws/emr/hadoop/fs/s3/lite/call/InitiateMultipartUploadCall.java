package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import java.util.Collection;

public final class InitiateMultipartUploadCall
  extends AbstractS3GenericCall<InitiateMultipartUploadResult, InitiateMultipartUploadRequest>
{
  public InitiateMultipartUploadCall(InitiateMultipartUploadRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((InitiateMultipartUploadRequest)request).getBucketName();
  }
  
  public InitiateMultipartUploadResult perform(AmazonS3 amazonS3)
  {
    return amazonS3.initiateMultipartUpload((InitiateMultipartUploadRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((InitiateMultipartUploadRequest)request).getBucketName(), ((InitiateMultipartUploadRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.InitiateMultipartUploadCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */