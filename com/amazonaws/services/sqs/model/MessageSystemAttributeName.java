package com.amazonaws.services.sqs.model;

public enum MessageSystemAttributeName
{
  SenderId("SenderId"),  SentTimestamp("SentTimestamp"),  ApproximateReceiveCount("ApproximateReceiveCount"),  ApproximateFirstReceiveTimestamp("ApproximateFirstReceiveTimestamp"),  SequenceNumber("SequenceNumber"),  MessageDeduplicationId("MessageDeduplicationId"),  MessageGroupId("MessageGroupId"),  AWSTraceHeader("AWSTraceHeader");
  
  private String value;
  
  private MessageSystemAttributeName(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static MessageSystemAttributeName fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (MessageSystemAttributeName enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.MessageSystemAttributeName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */