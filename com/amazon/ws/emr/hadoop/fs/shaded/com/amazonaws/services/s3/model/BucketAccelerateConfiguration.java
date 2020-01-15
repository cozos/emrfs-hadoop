package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class BucketAccelerateConfiguration
  implements Serializable
{
  private String status;
  
  public BucketAccelerateConfiguration(String status)
  {
    setStatus(status);
  }
  
  public BucketAccelerateConfiguration(BucketAccelerateStatus status)
  {
    setStatus(status);
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public void setStatus(BucketAccelerateStatus status)
  {
    setStatus(status.toString());
  }
  
  public BucketAccelerateConfiguration withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public BucketAccelerateConfiguration withStatus(BucketAccelerateStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public boolean isAccelerateEnabled()
  {
    return BucketAccelerateStatus.Enabled.toString().equals(getStatus());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketAccelerateConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */