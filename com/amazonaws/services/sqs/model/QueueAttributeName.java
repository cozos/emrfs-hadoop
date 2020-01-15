package com.amazonaws.services.sqs.model;

public enum QueueAttributeName
{
  All("All"),  Policy("Policy"),  VisibilityTimeout("VisibilityTimeout"),  MaximumMessageSize("MaximumMessageSize"),  MessageRetentionPeriod("MessageRetentionPeriod"),  ApproximateNumberOfMessages("ApproximateNumberOfMessages"),  ApproximateNumberOfMessagesNotVisible("ApproximateNumberOfMessagesNotVisible"),  CreatedTimestamp("CreatedTimestamp"),  LastModifiedTimestamp("LastModifiedTimestamp"),  QueueArn("QueueArn"),  ApproximateNumberOfMessagesDelayed("ApproximateNumberOfMessagesDelayed"),  DelaySeconds("DelaySeconds"),  ReceiveMessageWaitTimeSeconds("ReceiveMessageWaitTimeSeconds"),  RedrivePolicy("RedrivePolicy"),  FifoQueue("FifoQueue"),  ContentBasedDeduplication("ContentBasedDeduplication"),  KmsMasterKeyId("KmsMasterKeyId"),  KmsDataKeyReusePeriodSeconds("KmsDataKeyReusePeriodSeconds");
  
  private String value;
  
  private QueueAttributeName(String value)
  {
    this.value = value;
  }
  
  public String toString()
  {
    return value;
  }
  
  public static QueueAttributeName fromValue(String value)
  {
    if ((value == null) || ("".equals(value))) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }
    for (QueueAttributeName enumEntry : values()) {
      if (enumEntry.toString().equals(value)) {
        return enumEntry;
      }
    }
    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.QueueAttributeName
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */