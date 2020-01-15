package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

public enum ContextKeyTypeEnum
{
  String("string"),  StringList("stringList"),  Numeric("numeric"),  NumericList("numericList"),  Boolean("boolean"),  BooleanList("booleanList"),  Ip("ip"),  IpList("ipList"),  Binary("binary"),  BinaryList("binaryList"),  Date("date"),  DateList("dateList");
  
  private String value;
  
  private ContextKeyTypeEnum(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static ContextKeyTypeEnum fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (ContextKeyTypeEnum enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ContextKeyTypeEnum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */