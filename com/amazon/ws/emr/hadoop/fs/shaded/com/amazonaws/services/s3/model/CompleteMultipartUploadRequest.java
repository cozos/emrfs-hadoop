package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompleteMultipartUploadRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String key;
  private String uploadId;
  private List<PartETag> partETags = new ArrayList();
  private boolean isRequesterPays;
  
  public CompleteMultipartUploadRequest() {}
  
  public CompleteMultipartUploadRequest(String bucketName, String key, String uploadId, List<PartETag> partETags)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.uploadId = uploadId;
    this.partETags = partETags;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public CompleteMultipartUploadRequest withBucketName(String bucketName)
  {
    this.bucketName = bucketName;
    return this;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public CompleteMultipartUploadRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public void setUploadId(String uploadId)
  {
    this.uploadId = uploadId;
  }
  
  public CompleteMultipartUploadRequest withUploadId(String uploadId)
  {
    this.uploadId = uploadId;
    return this;
  }
  
  public List<PartETag> getPartETags()
  {
    return partETags;
  }
  
  public void setPartETags(List<PartETag> partETags)
  {
    this.partETags = partETags;
  }
  
  public CompleteMultipartUploadRequest withPartETags(List<PartETag> partETags)
  {
    setPartETags(partETags);
    return this;
  }
  
  public CompleteMultipartUploadRequest withPartETags(UploadPartResult... uploadPartResults)
  {
    for (UploadPartResult result : uploadPartResults) {
      partETags.add(new PartETag(result.getPartNumber(), result.getETag()));
    }
    return this;
  }
  
  public CompleteMultipartUploadRequest withPartETags(Collection<UploadPartResult> uploadPartResultsCollection)
  {
    for (UploadPartResult result : uploadPartResultsCollection) {
      partETags.add(new PartETag(result.getPartNumber(), result.getETag()));
    }
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
  
  public CompleteMultipartUploadRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompleteMultipartUploadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */