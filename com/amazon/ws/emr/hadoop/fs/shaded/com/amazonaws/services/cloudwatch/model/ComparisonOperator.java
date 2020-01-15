package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

public enum ComparisonOperator
{
  GreaterThanOrEqualToThreshold("GreaterThanOrEqualToThreshold"),  GreaterThanThreshold("GreaterThanThreshold"),  LessThanThreshold("LessThanThreshold"),  LessThanOrEqualToThreshold("LessThanOrEqualToThreshold"),  LessThanLowerOrGreaterThanUpperThreshold("LessThanLowerOrGreaterThanUpperThreshold"),  LessThanLowerThreshold("LessThanLowerThreshold"),  GreaterThanUpperThreshold("GreaterThanUpperThreshold");
  
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ComparisonOperator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */