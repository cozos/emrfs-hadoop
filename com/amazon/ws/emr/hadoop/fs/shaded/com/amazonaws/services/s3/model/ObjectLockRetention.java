package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class ObjectLockRetention
  implements Serializable
{
  private String mode;
  private Date retainUntilDate;
  
  public String getMode()
  {
    return mode;
  }
  
  public ObjectLockRetention withMode(String mode)
  {
    this.mode = mode;
    return this;
  }
  
  public ObjectLockRetention withMode(ObjectLockRetentionMode mode)
  {
    return withMode(mode.toString());
  }
  
  public void setMode(String mode)
  {
    withMode(mode);
  }
  
  public void setMode(ObjectLockRetentionMode mode)
  {
    setMode(mode.toString());
  }
  
  public Date getRetainUntilDate()
  {
    return retainUntilDate;
  }
  
  public ObjectLockRetention withRetainUntilDate(Date retainUntilDate)
  {
    this.retainUntilDate = retainUntilDate;
    return this;
  }
  
  public void setRetainUntilDate(Date retainUntilDate)
  {
    withRetainUntilDate(retainUntilDate);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRetention
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */