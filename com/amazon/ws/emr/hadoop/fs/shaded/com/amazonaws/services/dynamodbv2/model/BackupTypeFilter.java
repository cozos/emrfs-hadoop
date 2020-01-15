package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

public enum BackupTypeFilter
{
  USER("USER"),  SYSTEM("SYSTEM"),  AWS_BACKUP("AWS_BACKUP"),  ALL("ALL");
  
  private String value;
  
  private BackupTypeFilter(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static BackupTypeFilter fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (BackupTypeFilter enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupTypeFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */