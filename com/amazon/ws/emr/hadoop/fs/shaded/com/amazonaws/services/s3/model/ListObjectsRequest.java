package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListObjectsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String prefix;
  private String marker;
  private String delimiter;
  private Integer maxKeys;
  private String encodingType;
  private boolean isRequesterPays;
  
  public ListObjectsRequest() {}
  
  public ListObjectsRequest(String bucketName, String prefix, String marker, String delimiter, Integer maxKeys)
  {
    setBucketName(bucketName);
    setPrefix(prefix);
    setMarker(marker);
    setDelimiter(delimiter);
    setMaxKeys(maxKeys);
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public ListObjectsRequest withBucketName(String bucketName)
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
  
  public ListObjectsRequest withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public ListObjectsRequest withMarker(String marker)
  {
    setMarker(marker);
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
  
  public ListObjectsRequest withDelimiter(String delimiter)
  {
    setDelimiter(delimiter);
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
  
  public ListObjectsRequest withMaxKeys(Integer maxKeys)
  {
    setMaxKeys(maxKeys);
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
  
  public ListObjectsRequest withEncodingType(String encodingType)
  {
    setEncodingType(encodingType);
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
  
  public ListObjectsRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListObjectsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */