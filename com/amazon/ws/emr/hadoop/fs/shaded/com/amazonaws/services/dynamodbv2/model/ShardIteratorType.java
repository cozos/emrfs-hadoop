package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum ShardIteratorType
{
  TRIM_HORIZON("TRIM_HORIZON"),  LATEST("LATEST"),  AT_SEQUENCE_NUMBER("AT_SEQUENCE_NUMBER"),  AFTER_SEQUENCE_NUMBER("AFTER_SEQUENCE_NUMBER");
  
  private String value;
  
  private ShardIteratorType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ShardIteratorType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ShardIteratorType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ShardIteratorType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */