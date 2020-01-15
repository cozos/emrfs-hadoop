package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum ReturnItemCollectionMetrics
{
  SIZE("SIZE"),  NONE("NONE");
  
  private String value;
  
  private ReturnItemCollectionMetrics(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ReturnItemCollectionMetrics fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ReturnItemCollectionMetrics enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnItemCollectionMetrics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */