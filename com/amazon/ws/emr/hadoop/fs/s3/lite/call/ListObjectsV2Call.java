package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result;
import java.util.Collection;

public final class ListObjectsV2Call
  extends AbstractS3GenericCall<ListObjectsV2Result, ListObjectsV2Request>
{
  public ListObjectsV2Call(ListObjectsV2Request request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((ListObjectsV2Request)request).getBucketName();
  }
  
  public ListObjectsV2Result perform(AmazonS3 amazonS3)
  {
    return amazonS3.listObjectsV2((ListObjectsV2Request)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndPrefix(((ListObjectsV2Request)request).getBucketName(), ((ListObjectsV2Request)request).getPrefix());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListObjectsV2Call
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */