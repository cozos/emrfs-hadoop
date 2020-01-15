package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MultipartUploadListing
  implements Serializable
{
  private String bucketName;
  private String keyMarker;
  private String delimiter;
  private String prefix;
  private String uploadIdMarker;
  private int maxUploads;
  private String encodingType;
  private boolean isTruncated;
  private String nextKeyMarker;
  private String nextUploadIdMarker;
  private List<MultipartUpload> multipartUploads;
  private List<String> commonPrefixes = new ArrayList();
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getKeyMarker()
  {
    return keyMarker;
  }
  
  public void setKeyMarker(String keyMarker)
  {
    this.keyMarker = keyMarker;
  }
  
  public String getUploadIdMarker()
  {
    return uploadIdMarker;
  }
  
  public void setUploadIdMarker(String uploadIdMarker)
  {
    this.uploadIdMarker = uploadIdMarker;
  }
  
  public String getNextKeyMarker()
  {
    return nextKeyMarker;
  }
  
  public void setNextKeyMarker(String nextKeyMarker)
  {
    this.nextKeyMarker = nextKeyMarker;
  }
  
  public String getNextUploadIdMarker()
  {
    return nextUploadIdMarker;
  }
  
  public void setNextUploadIdMarker(String nextUploadIdMarker)
  {
    this.nextUploadIdMarker = nextUploadIdMarker;
  }
  
  public int getMaxUploads()
  {
    return maxUploads;
  }
  
  public void setMaxUploads(int maxUploads)
  {
    this.maxUploads = maxUploads;
  }
  
  public String getEncodingType()
  {
    return encodingType;
  }
  
  public void setEncodingType(String encodingType)
  {
    this.encodingType = encodingType;
  }
  
  public boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setTruncated(boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public List<MultipartUpload> getMultipartUploads()
  {
    if (multipartUploads == null) {
      multipartUploads = new ArrayList();
    }
    return multipartUploads;
  }
  
  public void setMultipartUploads(List<MultipartUpload> multipartUploads)
  {
    this.multipartUploads = multipartUploads;
  }
  
  public List<String> getCommonPrefixes()
  {
    return commonPrefixes;
  }
  
  public void setCommonPrefixes(List<String> commonPrefixes)
  {
    this.commonPrefixes = commonPrefixes;
  }
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public void setDelimiter(String delimiter)
  {
    this.delimiter = delimiter;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUploadListing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */