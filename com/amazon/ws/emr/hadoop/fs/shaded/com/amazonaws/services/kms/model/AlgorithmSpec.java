package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum AlgorithmSpec
{
  RSAES_PKCS1_V1_5("RSAES_PKCS1_V1_5"),  RSAES_OAEP_SHA_1("RSAES_OAEP_SHA_1"),  RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256");
  
  private String value;
  
  private AlgorithmSpec(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static AlgorithmSpec fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (AlgorithmSpec enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.AlgorithmSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */