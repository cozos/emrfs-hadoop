package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import java.util.Date;

public abstract interface ObjectExpirationResult
{
  public abstract Date getExpirationTime();
  
  public abstract void setExpirationTime(Date paramDate);
  
  public abstract String getExpirationTimeRuleId();
  
  public abstract void setExpirationTimeRuleId(String paramString);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ObjectExpirationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */