package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectListing
  implements Serializable
{
  private List<S3ObjectSummary> objectSummaries = new ArrayList();
  private List<String> commonPrefixes = new ArrayList();
  private String bucketName;
  private String nextMarker;
  private boolean isTruncated;
  private String prefix;
  private String marker;
  private int maxKeys;
  private String delimiter;
  private String encodingType;
  
  public List<S3ObjectSummary> getObjectSummaries()
  {
    return objectSummaries;
  }
  
  public List<String> getCommonPrefixes()
  {
    return commonPrefixes;
  }
  
  public void setCommonPrefixes(List<String> commonPrefixes)
  {
    this.commonPrefixes = commonPrefixes;
  }
  
  public String getNextMarker()
  {
    return nextMarker;
  }
  
  public void setNextMarker(String nextMarker)
  {
    this.nextMarker = nextMarker;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public int getMaxKeys()
  {
    return maxKeys;
  }
  
  public void setMaxKeys(int maxKeys)
  {
    this.maxKeys = maxKeys;
  }
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public void setDelimiter(String delimiter)
  {
    this.delimiter = delimiter;
  }
  
  public boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setTruncated(boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public void setEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectListing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */