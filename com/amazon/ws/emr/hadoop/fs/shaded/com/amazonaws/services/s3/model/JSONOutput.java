package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class JSONOutput
  implements Serializable
{
  private String recordDelimiter;
  
  public Character getRecordDelimiter()
  {
    return stringToChar(recordDelimiter);
  }
  
  public String getRecordDelimiterAsString()
  {
    return recordDelimiter;
  }
  
  public void setRecordDelimiter(String recordDelimiter)
  {
    validateNotEmpty(recordDelimiter, "recordDelimiter");
    this.recordDelimiter = recordDelimiter;
  }
  
  public JSONOutput withRecordDelimiter(String recordDelimiter)
  {
    setRecordDelimiter(recordDelimiter);
    return this;
  }
  
  public void setRecordDelimiter(Character recordDelimiter)
  {
    setRecordDelimiter(charToString(recordDelimiter));
  }
  
  public JSONOutput withRecordDelimiter(Character recordDelimiter)
  {
    setRecordDelimiter(recordDelimiter);
    return this;
  }
  
  private String charToString(Character character)
  {
    return character == null ? null : character.toString();
  }
  
  private Character stringToChar(String string)
  {
    return string == null ? null : Character.valueOf(string.charAt(0));
  }
  
  private void validateNotEmpty(String value, String valueName)
  {
    if ("".equals(value)) {
      throw new IllegalArgumentException(valueName + " must not be empty-string.");
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONOutput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */