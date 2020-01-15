package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum OriginType
{
  AWS_KMS("AWS_KMS"),  EXTERNAL("EXTERNAL"),  AWS_CLOUDHSM("AWS_CLOUDHSM");
  
  private String value;
  
  private OriginType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static OriginType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (OriginType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.OriginType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */