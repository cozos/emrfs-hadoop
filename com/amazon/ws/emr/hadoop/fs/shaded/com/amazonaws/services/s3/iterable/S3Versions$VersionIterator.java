package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;
import java.util.List;

class S3Versions$VersionIterator
  implements Iterator<S3VersionSummary>
{
  private VersionListing currentListing = null;
  private Iterator<S3VersionSummary> currentIterator = null;
  private S3VersionSummary nextSummary = null;
  
  private S3Versions$VersionIterator(S3Versions paramS3Versions) {}
  
  public boolean hasNext()
  {
    prepareCurrentListing();
    return nextMatchingSummary() != null;
  }
  
  public S3VersionSummary next()
  {
    prepareCurrentListing();
    S3VersionSummary returnValue = nextMatchingSummary();
    nextSummary = null;
    return returnValue;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  private S3VersionSummary nextMatchingSummary()
  {
    if ((this$0.getKey() == null) || ((nextSummary != null) && 
      (nextSummary.getKey().equals(this$0
      .getKey())))) {
      return nextSummary;
    }
    return null;
  }
  
  private void prepareCurrentListing()
  {
    while ((currentListing == null) || (
      (!currentIterator.hasNext()) && 
      (currentListing.isTruncated())))
    {
      if (currentListing == null)
      {
        ListVersionsRequest req = new ListVersionsRequest();
        req.setBucketName(this$0.getBucketName());
        if (this$0.getKey() != null) {
          req.setPrefix(this$0.getKey());
        } else {
          req.setPrefix(this$0.getPrefix());
        }
        req.setMaxResults(this$0.getBatchSize());
        currentListing = this$0.getS3().listVersions(req);
      }
      else
      {
        currentListing = this$0.getS3().listNextBatchOfVersions(currentListing);
      }
      currentIterator = currentListing.getVersionSummaries().iterator();
    }
    if ((nextSummary == null) && (currentIterator.hasNext())) {
      nextSummary = ((S3VersionSummary)currentIterator.next());
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable.S3Versions.VersionIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */