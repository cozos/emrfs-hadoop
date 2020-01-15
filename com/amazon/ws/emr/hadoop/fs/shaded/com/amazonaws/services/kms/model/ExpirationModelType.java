package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum ExpirationModelType
{
  KEY_MATERIAL_EXPIRES("KEY_MATERIAL_EXPIRES"),  KEY_MATERIAL_DOES_NOT_EXPIRE("KEY_MATERIAL_DOES_NOT_EXPIRE");
  
  private String value;
  
  private ExpirationModelType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ExpirationModelType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ExpirationModelType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ExpirationModelType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */