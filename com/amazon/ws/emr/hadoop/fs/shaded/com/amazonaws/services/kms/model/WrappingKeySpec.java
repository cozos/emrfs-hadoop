package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum WrappingKeySpec
{
  RSA_2048("RSA_2048");
  
  private String value;
  
  private WrappingKeySpec(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static WrappingKeySpec fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (WrappingKeySpec enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.WrappingKeySpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */