package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum ReturnValue
{
  NONE("NONE"),  ALL_OLD("ALL_OLD"),  UPDATED_OLD("UPDATED_OLD"),  ALL_NEW("ALL_NEW"),  UPDATED_NEW("UPDATED_NEW");
  
  private String value;
  
  private ReturnValue(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ReturnValue fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ReturnValue enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */