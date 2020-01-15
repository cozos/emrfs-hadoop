package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import java.util.Date;

public abstract interface ObjectRestoreResult
{
  public abstract Date getRestoreExpirationTime();
  
  public abstract void setRestoreExpirationTime(Date paramDate);
  
  public abstract void setOngoingRestore(boolean paramBoolean);
  
  public abstract Boolean getOngoingRestore();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectRestoreResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */