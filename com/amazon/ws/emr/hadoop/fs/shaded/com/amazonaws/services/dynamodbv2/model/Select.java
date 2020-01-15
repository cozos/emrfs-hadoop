package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum Select
{
  ALL_ATTRIBUTES("ALL_ATTRIBUTES"),  ALL_PROJECTED_ATTRIBUTES("ALL_PROJECTED_ATTRIBUTES"),  SPECIFIC_ATTRIBUTES("SPECIFIC_ATTRIBUTES"),  COUNT("COUNT");
  
  private String value;
  
  private Select(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static Select fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (Select enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Select
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */