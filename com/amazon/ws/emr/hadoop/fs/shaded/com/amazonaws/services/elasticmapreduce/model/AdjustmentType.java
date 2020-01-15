package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

public enum AdjustmentType
{
  CHANGE_IN_CAPACITY("CHANGE_IN_CAPACITY"),  PERCENT_CHANGE_IN_CAPACITY("PERCENT_CHANGE_IN_CAPACITY"),  EXACT_CAPACITY("EXACT_CAPACITY");
  
  private String value;
  
  private AdjustmentType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static AdjustmentType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (AdjustmentType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AdjustmentType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */