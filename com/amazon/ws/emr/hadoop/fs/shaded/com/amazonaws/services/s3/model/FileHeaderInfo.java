package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum FileHeaderInfo
{
  USE("USE"),  IGNORE("IGNORE"),  NONE("NONE");
  
  private final String headerInfo;
  
  private FileHeaderInfo(String headerInfo)
  {
    this.headerInfo = headerInfo;
  }
  
  public String toString()
  {
    return headerInfo;
  }
  
  public static FileHeaderInfo fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (FileHeaderInfo enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.FileHeaderInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */