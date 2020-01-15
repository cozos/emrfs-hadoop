package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum ConnectionErrorCodeType
{
  INVALID_CREDENTIALS("INVALID_CREDENTIALS"),  CLUSTER_NOT_FOUND("CLUSTER_NOT_FOUND"),  NETWORK_ERRORS("NETWORK_ERRORS"),  INTERNAL_ERROR("INTERNAL_ERROR"),  INSUFFICIENT_CLOUDHSM_HSMS("INSUFFICIENT_CLOUDHSM_HSMS"),  USER_LOCKED_OUT("USER_LOCKED_OUT");
  
  private String value;
  
  private ConnectionErrorCodeType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ConnectionErrorCodeType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ConnectionErrorCodeType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectionErrorCodeType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */