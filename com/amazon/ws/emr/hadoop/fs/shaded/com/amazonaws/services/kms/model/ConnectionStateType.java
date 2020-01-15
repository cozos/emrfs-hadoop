package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum ConnectionStateType
{
  CONNECTED("CONNECTED"),  CONNECTING("CONNECTING"),  FAILED("FAILED"),  DISCONNECTED("DISCONNECTED"),  DISCONNECTING("DISCONNECTING");
  
  private String value;
  
  private ConnectionStateType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ConnectionStateType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ConnectionStateType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectionStateType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */