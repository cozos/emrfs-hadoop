package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

public enum JSONType
{
  DOCUMENT("DOCUMENT"),  LINES("LINES");
  
  private final String jsonType;
  
  private JSONType(String jsonType)
  {
    this.jsonType = jsonType;
  }
  
  public String toString()
  {
    return jsonType;
  }
  
  public static JSONType fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (JSONType enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */