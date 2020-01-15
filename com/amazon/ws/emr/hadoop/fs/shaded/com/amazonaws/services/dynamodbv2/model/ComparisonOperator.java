package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum ComparisonOperator
{
  EQ("EQ"),  NE("NE"),  IN("IN"),  LE("LE"),  LT("LT"),  GE("GE"),  GT("GT"),  BETWEEN("BETWEEN"),  NOT_NULL("NOT_NULL"),  NULL("NULL"),  CONTAINS("CONTAINS"),  NOT_CONTAINS("NOT_CONTAINS"),  BEGINS_WITH("BEGINS_WITH");
  
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */