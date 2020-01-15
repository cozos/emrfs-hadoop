package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.Iterator;
import java.util.List;

public class S3Objects
  implements Iterable<S3ObjectSummary>
{
  private AmazonS3 s3;
  private String prefix = null;
  private String bucketName;
  private Integer batchSize = null;
  private String delimiter;
  private String marker;
  private String encodingType;
  private boolean requesterPays;
  
  private S3Objects(AmazonS3 s3, String bucketName)
  {
    this.s3 = s3;
    this.bucketName = bucketName;
  }
  
  public static S3Objects inBucket(AmazonS3 s3, String bucketName)
  {
    return new S3Objects(s3, bucketName);
  }
  
  public static S3Objects withPrefix(AmazonS3 s3, String bucketName, String prefix)
  {
    S3Objects objects = new S3Objects(s3, bucketName);
    prefix = prefix;
    return objects;
  }
  
  public S3Objects withBatchSize(int batchSize)
  {
    this.batchSize = Integer.valueOf(batchSize);
    return this;
  }
  
  public void withRequesterPays(boolean requesterPays)
  {
    this.requesterPays = requesterPays;
  }
  
  public void withEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
  
  public void withMarker(String marker)
  {
    this.marker = marker;
  }
  
  public void withDelimiter(String delimiter)
  {
    this.delimiter = delimiter;
  }
  
  public Integer getBatchSize()
  {
    return batchSize;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public boolean isRequesterPays()
  {
    return requesterPays;
  }
  
  public AmazonS3 getS3()
  {
    return s3;
  }
  
  private class S3ObjectIterator
    implements Iterator<S3ObjectSummary>
  {
    private ObjectListing currentListing = null;
    private Iterator<S3ObjectSummary> currentIterator = null;
    
    private S3ObjectIterator() {}
    
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
          req.setBucketName(getBucketName());
          req.setPrefix(getPrefix());
          req.setMaxKeys(getBatchSize());
          req.setDelimiter(getDelimiter());
          req.setMarker(getMarker());
          req.setEncodingType(getEncodingType());
          req.setRequesterPays(isRequesterPays());
          currentListing = getS3().listObjects(req);
        }
        else
        {
          currentListing = getS3().listNextBatchOfObjects(currentListing);
        }
        currentIterator = currentListing.getObjectSummaries().iterator();
      }
    }
  }
  
  public Iterator<S3ObjectSummary> iterator()
  {
    return new S3ObjectIterator(null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.iterable.S3Objects
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */