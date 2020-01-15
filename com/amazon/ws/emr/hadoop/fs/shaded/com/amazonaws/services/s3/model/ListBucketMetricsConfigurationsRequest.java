package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListBucketMetricsConfigurationsRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String continuationToken;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public ListBucketMetricsConfigurationsRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
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
  
  public ListBucketMetricsConfigurationsRequest withContinuationToken(String continuationToken)
  {
    setContinuationToken(continuationToken);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */