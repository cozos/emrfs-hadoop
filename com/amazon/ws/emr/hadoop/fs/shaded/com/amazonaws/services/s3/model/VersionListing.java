package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VersionListing
  implements Serializable
{
  private List<S3VersionSummary> versionSummaries = new ArrayList();
  private List<String> commonPrefixes = new ArrayList();
  private String bucketName;
  private String nextKeyMarker;
  private String nextVersionIdMarker;
  private boolean isTruncated;
  private String prefix;
  private String keyMarker;
  private String versionIdMarker;
  private int maxKeys;
  private String delimiter;
  private String encodingType;
  
  public List<S3VersionSummary> getVersionSummaries()
  {
    return versionSummaries;
  }
  
  public void setVersionSummaries(List<S3VersionSummary> versionSummaries)
  {
    this.versionSummaries = versionSummaries;
  }
  
  public List<String> getCommonPrefixes()
  {
    return commonPrefixes;
  }
  
  public void setCommonPrefixes(List<String> commonPrefixes)
  {
    this.commonPrefixes = commonPrefixes;
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
  
  public String getKeyMarker()
  {
    return keyMarker;
  }
  
  public void setKeyMarker(String keyMarker)
  {
    this.keyMarker = keyMarker;
  }
  
  public String getVersionIdMarker()
  {
    return versionIdMarker;
  }
  
  public void setVersionIdMarker(String versionIdMarker)
  {
    this.versionIdMarker = versionIdMarker;
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
  
  public String getNextKeyMarker()
  {
    return nextKeyMarker;
  }
  
  public void setNextKeyMarker(String marker)
  {
    nextKeyMarker = marker;
  }
  
  public String getNextVersionIdMarker()
  {
    return nextVersionIdMarker;
  }
  
  public void setNextVersionIdMarker(String marker)
  {
    nextVersionIdMarker = marker;
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.VersionListing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */