package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum ObjectLockRetentionMode
{
  GOVERNANCE("GOVERNANCE"),  COMPLIANCE("COMPLIANCE");
  
  private final String objectLockRetentionMode;
  
  private ObjectLockRetentionMode(String objectLockRetentionMode)
  {
    this.objectLockRetentionMode = objectLockRetentionMode;
  }
  
  public static ObjectLockRetentionMode fromString(String objectLockRetentionModeString)
  {
    for (ObjectLockRetentionMode v : ) {
      if (v.toString().equals(objectLockRetentionModeString)) {
        return v;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + objectLockRetentionModeString + " value!");
  }
  
  public String toString()
  {
    return objectLockRetentionMode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockRetentionMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */