package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

public enum HistoryItemType
{
  ConfigurationUpdate("ConfigurationUpdate"),  StateUpdate("StateUpdate"),  Action("Action");
  
  private String value;
  
  private HistoryItemType(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static HistoryItemType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (HistoryItemType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.HistoryItemType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */