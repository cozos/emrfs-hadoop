package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum CompressionType
{
  NONE("NONE"),  GZIP("GZIP"),  BZIP2("BZIP2");
  
  private final String compressionType;
  
  private CompressionType(String compressionType)
  {
    this.compressionType = compressionType;
  }
  
  public String toString()
  {
    return compressionType;
  }
  
  public static CompressionType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (CompressionType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CompressionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */