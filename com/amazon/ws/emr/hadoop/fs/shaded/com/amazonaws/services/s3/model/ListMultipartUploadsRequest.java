package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListMultipartUploadsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String delimiter;
  private String prefix;
  private Integer maxUploads;
  private String keyMarker;
  private String uploadIdMarker;
  private String encodingType;
  
  public ListMultipartUploadsRequest(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public ListMultipartUploadsRequest withBucketName(String bucketName)
  {
    this.bucketName = bucketName;
    return this;
  }
  
  public Integer getMaxUploads()
  {
    return maxUploads;
  }
  
  public void setMaxUploads(Integer maxUploads)
  {
    this.maxUploads = maxUploads;
  }
  
  public ListMultipartUploadsRequest withMaxUploads(int maxUploadsInt)
  {
    maxUploads = Integer.valueOf(maxUploadsInt);
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
  
  public ListMultipartUploadsRequest withKeyMarker(String keyMarker)
  {
    this.keyMarker = keyMarker;
    return this;
  }
  
  public String getUploadIdMarker()
  {
    return uploadIdMarker;
  }
  
  public void setUploadIdMarker(String uploadIdMarker)
  {
    this.uploadIdMarker = uploadIdMarker;
  }
  
  public ListMultipartUploadsRequest withUploadIdMarker(String uploadIdMarker)
  {
    this.uploadIdMarker = uploadIdMarker;
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
  
  public ListMultipartUploadsRequest withDelimiter(String delimiter)
  {
    setDelimiter(delimiter);
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
  
  public ListMultipartUploadsRequest withPrefix(String prefix)
  {
    setPrefix(prefix);
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
  
  public ListMultipartUploadsRequest withEncodingType(String encodingType)
  {
    setEncodingType(encodingType);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListMultipartUploadsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */