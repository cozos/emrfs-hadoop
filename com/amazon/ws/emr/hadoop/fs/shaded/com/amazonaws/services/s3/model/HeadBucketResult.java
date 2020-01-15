package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class HeadBucketResult
  implements Serializable
{
  private String bucketRegion;
  
  public String getBucketRegion()
  {
    return bucketRegion;
  }
  
  public void setBucketRegion(String bucketRegion)
  {
    this.bucketRegion = bucketRegion;
  }
  
  public HeadBucketResult withBucketRegion(String bucketRegion)
  {
    setBucketRegion(bucketRegion);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.HeadBucketResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */