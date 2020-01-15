package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListPartsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartListing;
import java.util.Collection;

public final class ListPartsCall
  extends AbstractS3GenericCall<PartListing, ListPartsRequest>
{
  public ListPartsCall(ListPartsRequest request)
  {
    super(request);
  }
  
  public String getBucketName()
  {
    return ((ListPartsRequest)request).getBucketName();
  }
  
  public PartListing perform(AmazonS3 client)
  {
    return client.listParts((ListPartsRequest)request);
  }
  
  public Collection<S3Resource> getS3Resources()
  {
    return S3Resources.fromBucketAndKey(((ListPartsRequest)request).getBucketName(), ((ListPartsRequest)request).getKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.ListPartsCall
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */