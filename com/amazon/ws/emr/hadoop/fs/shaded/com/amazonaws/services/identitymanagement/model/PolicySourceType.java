package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum PolicySourceType
{
  User("user"),  Group("group"),  Role("role"),  AwsManaged("aws-managed"),  UserManaged("user-managed"),  Resource("resource"),  None("none");
  
  private String value;
  
  private PolicySourceType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static PolicySourceType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (PolicySourceType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicySourceType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */