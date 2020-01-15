package com.amazonaws.services.sqs.model;

public enum MessageSystemAttributeNameForSends
{
  AWSTraceHeader("AWSTraceHeader");
  
  private String value;
  
  private MessageSystemAttributeNameForSends(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static MessageSystemAttributeNameForSends fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (MessageSystemAttributeNameForSends enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.MessageSystemAttributeNameForSends
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */