package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum ObjectLockEnabled
{
  ENABLED("Enabled");
  
  private final String objectLockEnabled;
  
  private ObjectLockEnabled(String objectLockEnabled)
  {
    this.objectLockEnabled = objectLockEnabled;
  }
  
  public static ObjectLockEnabled fromString(String objectLockEnabledString)
  {
    for (ObjectLockEnabled v : ) {
      if (v.toString().equals(objectLockEnabledString)) {
        return v;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + objectLockEnabledString + " value!");
  }
  
  public String toString()
  {
    return objectLockEnabled;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockEnabled
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */