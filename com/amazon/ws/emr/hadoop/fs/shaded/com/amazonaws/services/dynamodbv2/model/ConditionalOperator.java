package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum ConditionalOperator
{
  AND("AND"),  OR("OR");
  
  private String value;
  
  private ConditionalOperator(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ConditionalOperator fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ConditionalOperator enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */