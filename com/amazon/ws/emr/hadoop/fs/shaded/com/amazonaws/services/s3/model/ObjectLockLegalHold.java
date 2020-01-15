package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class ObjectLockLegalHold
  implements Serializable
{
  private String status;
  
  public String getStatus()
  {
    return status;
  }
  
  public ObjectLockLegalHold withStatus(String status)
  {
    this.status = status;
    return this;
  }
  
  public ObjectLockLegalHold withStatus(ObjectLockLegalHoldStatus status)
  {
    this.status = status.toString();
    return this;
  }
  
  public void setStatus(String status)
  {
    withStatus(status);
  }
  
  public void setStatus(ObjectLockLegalHoldStatus status)
  {
    setStatus(status.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockLegalHold
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */