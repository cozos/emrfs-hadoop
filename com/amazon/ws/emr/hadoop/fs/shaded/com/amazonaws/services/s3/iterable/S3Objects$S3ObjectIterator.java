package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.Iterator;
import java.util.List;

class S3Objects$S3ObjectIterator
  implements Iterator<S3ObjectSummary>
{
  private ObjectListing currentListing = null;
  private Iterator<S3ObjectSummary> currentIterator = null;
  
  private S3Objects$S3ObjectIterator(S3Objects paramS3Objects) {}
  
  public boolean hasNext()
  {
    prepareCurrentListing();
    return currentIterator.hasNext();
  }
  
  public S3ObjectSummary next()
  {
    prepareCurrentListing();
    return (S3ObjectSummary)currentIterator.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  private void prepareCurrentListing()
  {
    while ((currentListing == null) || ((!currentIterator.hasNext()) && (currentListing.isTruncated())))
    {
      if (currentListing == null)
      {
        ListObjectsRequest req = new ListObjectsRequest();
        req.setBucketName(this$0.getBucketName());
        req.setPrefix(this$0.getPrefix());
        req.setMaxKeys(this$0.getBatchSize());
        req.setDelimiter(this$0.getDelimiter());
        req.setMarker(this$0.getMarker());
        req.setEncodingType(this$0.getEncodingType());
        req.setRequesterPays(this$0.isRequesterPays());
        currentListing = this$0.getS3().listObjects(req);
      }
      else
      {
        currentListing = this$0.getS3().listNextBatchOfObjects(currentListing);
      }
      currentIterator = currentListing.getObjectSummaries().iterator();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable.S3Objects.S3ObjectIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */