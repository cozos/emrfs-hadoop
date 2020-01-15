package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum SortKeyType
{
  SERVICE_NAMESPACE_ASCENDING("SERVICE_NAMESPACE_ASCENDING"),  SERVICE_NAMESPACE_DESCENDING("SERVICE_NAMESPACE_DESCENDING"),  LAST_AUTHENTICATED_TIME_ASCENDING("LAST_AUTHENTICATED_TIME_ASCENDING"),  LAST_AUTHENTICATED_TIME_DESCENDING("LAST_AUTHENTICATED_TIME_DESCENDING");
  
  private String value;
  
  private SortKeyType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static SortKeyType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (SortKeyType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SortKeyType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */