package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum ComparisonOperator
{
  GREATER_THAN_OR_EQUAL("GREATER_THAN_OR_EQUAL"),  GREATER_THAN("GREATER_THAN"),  LESS_THAN("LESS_THAN"),  LESS_THAN_OR_EQUAL("LESS_THAN_OR_EQUAL");
  
  private String value;
  
  private ComparisonOperator(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ComparisonOperator fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ComparisonOperator enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ComparisonOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */