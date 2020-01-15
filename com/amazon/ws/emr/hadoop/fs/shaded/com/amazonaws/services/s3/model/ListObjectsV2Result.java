package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListObjectsV2Result
  implements Serializable
{
  private List<S3ObjectSummary> objectSummaries = new ArrayList();
  private List<String> commonPrefixes = new ArrayList();
  private boolean isTruncated;
  private String bucketName;
  private int keyCount;
  private String nextContinuationToken;
  private String prefix;
  private String delimiter;
  private int maxKeys;
  private String encodingType;
  private String continuationToken;
  private String startAfter;
  
  public boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setTruncated(boolean isTruncated)
  {
    this.isTruncated = isTruncated;
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
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public void setDelimiter(String delimiter)
  {
    this.delimiter = delimiter;
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public void setEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
  
  public String getContinuationToken()
  {
    return continuationToken;
  }
  
  public void setContinuationToken(String continuationToken)
  {
    this.continuationToken = continuationToken;
  }
  
  public String getNextContinuationToken()
  {
    return nextContinuationToken;
  }
  
  public void setNextContinuationToken(String nextContinuationToken)
  {
    this.nextContinuationToken = nextContinuationToken;
  }
  
  public int getKeyCount()
  {
    return keyCount;
  }
  
  public void setKeyCount(int keyCount)
  {
    this.keyCount = keyCount;
  }
  
  public int getMaxKeys()
  {
    return maxKeys;
  }
  
  public void setMaxKeys(int maxKeys)
  {
    this.maxKeys = maxKeys;
  }
  
  public String getStartAfter()
  {
    return startAfter;
  }
  
  public void setStartAfter(String startAfter)
  {
    this.startAfter = startAfter;
  }
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Result
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */