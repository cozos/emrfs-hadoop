package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;
import java.util.List;

public class S3Versions
  implements Iterable<S3VersionSummary>
{
  private AmazonS3 s3;
  private String bucketName;
  private String prefix;
  private String key;
  private Integer batchSize;
  
  private S3Versions(AmazonS3 s3, String bucketName)
  {
    this.s3 = s3;
    this.bucketName = bucketName;
  }
  
  public static S3Versions inBucket(AmazonS3 s3, String bucketName)
  {
    return new S3Versions(s3, bucketName);
  }
  
  public static S3Versions withPrefix(AmazonS3 s3, String bucketName, String prefix)
  {
    S3Versions versions = new S3Versions(s3, bucketName);
    prefix = prefix;
    return versions;
  }
  
  public static S3Versions forKey(AmazonS3 s3, String bucketName, String key)
  {
    S3Versions versions = new S3Versions(s3, bucketName);
    key = key;
    return versions;
  }
  
  public S3Versions withBatchSize(int batchSize)
  {
    this.batchSize = Integer.valueOf(batchSize);
    return this;
  }
  
  public Integer getBatchSize()
  {
    return batchSize;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public AmazonS3 getS3()
  {
    return s3;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  private class VersionIterator
    implements Iterator<S3VersionSummary>
  {
    private VersionListing currentListing = null;
    private Iterator<S3VersionSummary> currentIterator = null;
    private S3VersionSummary nextSummary = null;
    
    private VersionIterator() {}
    
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
      if ((getKey() == null) || ((nextSummary != null) && 
        (nextSummary.getKey().equals(
        getKey())))) {
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
          req.setBucketName(getBucketName());
          if (getKey() != null) {
            req.setPrefix(getKey());
          } else {
            req.setPrefix(getPrefix());
          }
          req.setMaxResults(getBatchSize());
          currentListing = getS3().listVersions(req);
        }
        else
        {
          currentListing = getS3().listNextBatchOfVersions(currentListing);
        }
        currentIterator = currentListing.getVersionSummaries().iterator();
      }
      if ((nextSummary == null) && (currentIterator.hasNext())) {
        nextSummary = ((S3VersionSummary)currentIterator.next());
      }
    }
  }
  
  public Iterator<S3VersionSummary> iterator()
  {
    return new VersionIterator(null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable.S3Versions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */