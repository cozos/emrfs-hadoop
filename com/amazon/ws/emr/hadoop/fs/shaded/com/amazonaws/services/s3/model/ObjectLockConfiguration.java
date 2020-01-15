package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class ObjectLockConfiguration
  implements Serializable
{
  private String objectLockEnabled;
  private ObjectLockRule rule;
  
  public String getObjectLockEnabled()
  {
    return objectLockEnabled;
  }
  
  public ObjectLockConfiguration withObjectLockEnabled(String objectLockEnabled)
  {
    this.objectLockEnabled = objectLockEnabled;
    return this;
  }
  
  public ObjectLockConfiguration withObjectLockEnabled(ObjectLockEnabled objectLockEnabled)
  {
    return withObjectLockEnabled(objectLockEnabled.toString());
  }
  
  public void setObjectLockEnabled(String objectLockEnabled)
  {
    withObjectLockEnabled(objectLockEnabled);
  }
  
  public void setObjectLockEnabled(ObjectLockEnabled objectLockEnabled)
  {
    setObjectLockEnabled(objectLockEnabled.toString());
  }
  
  public ObjectLockRule getRule()
  {
    return rule;
  }
  
  public ObjectLockConfiguration withRule(ObjectLockRule rule)
  {
    this.rule = rule;
    return this;
  }
  
  public void setRule(ObjectLockRule rule)
  {
    withRule(rule);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */