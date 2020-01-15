package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum MetadataDirective
{
  COPY("COPY"),  REPLACE("REPLACE");
  
  private String value;
  
  private MetadataDirective(String value)
  {
    this.value = value;
  }
  
  public static MetadataDirective fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (MetadataDirective enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MetadataDirective
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */