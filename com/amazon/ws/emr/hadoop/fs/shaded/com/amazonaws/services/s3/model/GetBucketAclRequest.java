package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetBucketAclRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  
  public GetBucketAclRequest(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetBucketAclRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */