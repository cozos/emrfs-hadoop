package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import java.util.Collection;

public final class ListVersionsCall
  extends AbstractS3GenericCall<VersionListing, ListVersionsRequest>
{
  public ListVersionsCall(ListVersionsRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((ListVersionsRequest)request).getBucketName();
  }
  
  public VersionListing perform(AmazonS3 client)
  {
    return client.listVersions((ListVersionsRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndPrefix(((ListVersionsRequest)request).getBucketName(), ((ListVersionsRequest)request).getPrefix());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListVersionsCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */