package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListObjectsV2Request
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String delimiter;
  private String encodingType;
  private Integer maxKeys;
  private String prefix;
  private String continuationToken;
  private boolean fetchOwner;
  private String startAfter;
  private boolean isRequesterPays;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public ListObjectsV2Request withBucketName(String bucketName)
  {
    setBucketName(bucketName);
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
  
  public ListObjectsV2Request withDelimiter(String delimiter)
  {
    setDelimiter(delimiter);
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
  
  public ListObjectsV2Request withEncodingType(String encodingType)
  {
    setEncodingType(encodingType);
    return this;
  }
  
  public Integer getMaxKeys()
  {
    return maxKeys;
  }
  
  public void setMaxKeys(Integer maxKeys)
  {
    this.maxKeys = maxKeys;
  }
  
  public ListObjectsV2Request withMaxKeys(Integer maxKeys)
  {
    setMaxKeys(maxKeys);
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
  
  public ListObjectsV2Request withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
  
  public String getContinuationToken()
  {
    return continuationToken;
  }
  
  public void setContinuationToken(String continuationToken)
  {
    this.continuationToken = continuationToken;
  }
  
  public ListObjectsV2Request withContinuationToken(String continuationToken)
  {
    setContinuationToken(continuationToken);
    return this;
  }
  
  public boolean isFetchOwner()
  {
    return fetchOwner;
  }
  
  public void setFetchOwner(boolean fetchOwner)
  {
    this.fetchOwner = fetchOwner;
  }
  
  public ListObjectsV2Request withFetchOwner(boolean fetchOwner)
  {
    setFetchOwner(fetchOwner);
    return this;
  }
  
  public String getStartAfter()
  {
    return startAfter;
  }
  
  public void setStartAfter(String startAfter)
  {
    this.startAfter = startAfter;
  }
  
  public ListObjectsV2Request withStartAfter(String startAfter)
  {
    setStartAfter(startAfter);
    return this;
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public ListObjectsV2Request withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsV2Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */