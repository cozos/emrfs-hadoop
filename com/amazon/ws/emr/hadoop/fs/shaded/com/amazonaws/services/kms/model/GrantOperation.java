package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

public enum GrantOperation
{
  Decrypt("Decrypt"),  Encrypt("Encrypt"),  GenerateDataKey("GenerateDataKey"),  GenerateDataKeyWithoutPlaintext("GenerateDataKeyWithoutPlaintext"),  ReEncryptFrom("ReEncryptFrom"),  ReEncryptTo("ReEncryptTo"),  CreateGrant("CreateGrant"),  RetireGrant("RetireGrant"),  DescribeKey("DescribeKey");
  
  private String value;
  
  private GrantOperation(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static GrantOperation fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (GrantOperation enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GrantOperation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */