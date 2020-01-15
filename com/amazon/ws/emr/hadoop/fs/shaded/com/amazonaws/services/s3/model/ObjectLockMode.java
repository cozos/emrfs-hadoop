package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum ObjectLockMode
{
  GOVERNANCE("GOVERNANCE"),  COMPLIANCE("COMPLIANCE");
  
  private final String objectLockMode;
  
  private ObjectLockMode(String objectLockMode)
  {
    this.objectLockMode = objectLockMode;
  }
  
  public static ObjectLockMode fromString(String objectLockModeString)
  {
    for (ObjectLockMode v : ) {
      if (v.toString().equals(objectLockModeString)) {
        return v;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + objectLockModeString + " value!");
  }
  
  public String toString()
  {
    return objectLockMode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockMode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */