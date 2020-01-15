package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum SseKmsEncryptedObjectsStatus
{
  ENABLED("Enabled"),  DISABLED("Disabled");
  
  private final String value;
  
  private SseKmsEncryptedObjectsStatus(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static SseKmsEncryptedObjectsStatus fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (SseKmsEncryptedObjectsStatus enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SseKmsEncryptedObjectsStatus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */