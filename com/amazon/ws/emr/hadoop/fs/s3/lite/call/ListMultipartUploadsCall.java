package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing;
import java.util.Collection;

public final class ListMultipartUploadsCall
  extends AbstractS3GenericCall<MultipartUploadListing, ListMultipartUploadsRequest>
{
  public ListMultipartUploadsCall(ListMultipartUploadsRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((ListMultipartUploadsRequest)request).getBucketName();
  }
  
  public MultipartUploadListing perform(AmazonS3 client)
  {
    return client.listMultipartUploads((ListMultipartUploadsRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndPrefix(((ListMultipartUploadsRequest)request).getBucketName(), ((ListMultipartUploadsRequest)request).getPrefix());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListMultipartUploadsCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */