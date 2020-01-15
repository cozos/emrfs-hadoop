package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class GetObjectRetentionResult
  implements Serializable
{
  private ObjectLockRetention retention;
  
  public ObjectLockRetention getRetention()
  {
    return retention;
  }
  
  public GetObjectRetentionResult withRetention(ObjectLockRetention retention)
  {
    this.retention = retention;
    return this;
  }
  
  public void setRetention(ObjectLockRetention retention)
  {
    withRetention(retention);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRetentionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */