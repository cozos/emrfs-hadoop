package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import java.util.Collection;

public final class GetObjectMetadataCall
  extends AbstractS3GenericCall<ObjectMetadata, GetObjectMetadataRequest>
{
  public GetObjectMetadataCall(GetObjectMetadataRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((GetObjectMetadataRequest)request).getBucketName();
  }
  
  public ObjectMetadata perform(AmazonS3 amazonS3)
  {
    return amazonS3.getObjectMetadata((GetObjectMetadataRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((GetObjectMetadataRequest)request).getBucketName(), ((GetObjectMetadataRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.GetObjectMetadataCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */