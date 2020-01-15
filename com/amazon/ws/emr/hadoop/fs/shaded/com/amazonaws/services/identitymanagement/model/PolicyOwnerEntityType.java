package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum PolicyOwnerEntityType
{
  USER("USER"),  ROLE("ROLE"),  GROUP("GROUP");
  
  private String value;
  
  private PolicyOwnerEntityType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static PolicyOwnerEntityType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (PolicyOwnerEntityType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyOwnerEntityType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */