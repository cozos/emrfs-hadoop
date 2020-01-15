package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum KeyState
{
  Enabled("Enabled"),  Disabled("Disabled"),  PendingDeletion("PendingDeletion"),  PendingImport("PendingImport"),  Unavailable("Unavailable");
  
  private String value;
  
  private KeyState(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static KeyState fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (KeyState enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.KeyState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */