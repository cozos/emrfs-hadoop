package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum ObjectLockLegalHoldStatus
{
  ON("ON"),  OFF("OFF");
  
  private final String objectLockLegalHoldStatus;
  
  private ObjectLockLegalHoldStatus(String objectLockLegalHoldStatus)
  {
    this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
  }
  
  public static ObjectLockLegalHoldStatus fromString(String objectLockLegalHoldStatusString)
  {
    for (ObjectLockLegalHoldStatus v : ) {
      if (v.toString().equals(objectLockLegalHoldStatusString)) {
        return v;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + objectLockLegalHoldStatusString + " value!");
  }
  
  public String toString()
  {
    return objectLockLegalHoldStatus;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectLockLegalHoldStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */