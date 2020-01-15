package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

public enum StandardUnit
{
  Seconds("Seconds"),  Microseconds("Microseconds"),  Milliseconds("Milliseconds"),  Bytes("Bytes"),  Kilobytes("Kilobytes"),  Megabytes("Megabytes"),  Gigabytes("Gigabytes"),  Terabytes("Terabytes"),  Bits("Bits"),  Kilobits("Kilobits"),  Megabits("Megabits"),  Gigabits("Gigabits"),  Terabits("Terabits"),  Percent("Percent"),  Count("Count"),  BytesSecond("Bytes/Second"),  KilobytesSecond("Kilobytes/Second"),  MegabytesSecond("Megabytes/Second"),  GigabytesSecond("Gigabytes/Second"),  TerabytesSecond("Terabytes/Second"),  BitsSecond("Bits/Second"),  KilobitsSecond("Kilobits/Second"),  MegabitsSecond("Megabits/Second"),  GigabitsSecond("Gigabits/Second"),  TerabitsSecond("Terabits/Second"),  CountSecond("Count/Second"),  None("None");
  
  private String value;
  
  private StandardUnit(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static StandardUnit fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (StandardUnit enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.StandardUnit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */