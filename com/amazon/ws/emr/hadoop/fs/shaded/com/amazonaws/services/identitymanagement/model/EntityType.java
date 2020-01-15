package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum EntityType
{
  User("User"),  Role("Role"),  Group("Group"),  LocalManagedPolicy("LocalManagedPolicy"),  AWSManagedPolicy("AWSManagedPolicy");
  
  private String value;
  
  private EntityType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static EntityType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (EntityType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EntityType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */