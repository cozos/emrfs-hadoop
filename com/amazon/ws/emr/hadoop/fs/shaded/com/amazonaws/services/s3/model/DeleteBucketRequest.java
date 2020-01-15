package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteBucketRequest
  extends AmazonWebServiceRequest
  implements Serializable, S3AccelerateUnsupported
{
  private String bucketName;
  
  public DeleteBucketRequest(String bucketName)
  {
    setBucketName(bucketName);
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */