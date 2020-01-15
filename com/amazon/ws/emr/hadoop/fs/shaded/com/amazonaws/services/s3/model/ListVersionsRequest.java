package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListVersionsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String prefix;
  private String keyMarker;
  private String versionIdMarker;
  private String delimiter;
  private Integer maxResults;
  private String encodingType;
  
  public ListVersionsRequest() {}
  
  public ListVersionsRequest(String bucketName, String prefix, String keyMarker, String versionIdMarker, String delimiter, Integer maxResults)
  {
    setBucketName(bucketName);
    setPrefix(prefix);
    setKeyMarker(keyMarker);
    setVersionIdMarker(versionIdMarker);
    setDelimiter(delimiter);
    setMaxResults(maxResults);
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public ListVersionsRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
  
  public ListVersionsRequest withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
  
  public String getKeyMarker()
  {
    return keyMarker;
  }
  
  public void setKeyMarker(String keyMarker)
  {
    this.keyMarker = keyMarker;
  }
  
  public ListVersionsRequest withKeyMarker(String keyMarker)
  {
    setKeyMarker(keyMarker);
    return this;
  }
  
  public String getVersionIdMarker()
  {
    return versionIdMarker;
  }
  
  public void setVersionIdMarker(String versionIdMarker)
  {
    this.versionIdMarker = versionIdMarker;
  }
  
  public ListVersionsRequest withVersionIdMarker(String versionIdMarker)
  {
    setVersionIdMarker(versionIdMarker);
    return this;
  }
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public void setDelimiter(String delimiter)
  {
    this.delimiter = delimiter;
  }
  
  public ListVersionsRequest withDelimiter(String delimiter)
  {
    setDelimiter(delimiter);
    return this;
  }
  
  public Integer getMaxResults()
  {
    return maxResults;
  }
  
  public void setMaxResults(Integer maxResults)
  {
    this.maxResults = maxResults;
  }
  
  public ListVersionsRequest withMaxResults(Integer maxResults)
  {
    setMaxResults(maxResults);
    return this;
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public void setEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
  
  public ListVersionsRequest withEncodingType(String encodingType)
  {
    setEncodingType(encodingType);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListVersionsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */