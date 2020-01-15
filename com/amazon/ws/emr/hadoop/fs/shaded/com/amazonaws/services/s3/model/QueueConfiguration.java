package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

public class QueueConfiguration
  extends NotificationConfiguration
  implements Serializable
{
  private String queueARN;
  
  public QueueConfiguration() {}
  
  public QueueConfiguration(String queueARN, EnumSet<S3Event> events)
  {
    super(events);
    this.queueARN = queueARN;
  }
  
  public QueueConfiguration(String queueARN, String... events)
  {
    super(events);
    this.queueARN = queueARN;
  }
  
  public String getQueueARN()
  {
    return queueARN;
  }
  
  public void setQueueARN(String queueARN)
  {
    this.queueARN = queueARN;
  }
  
  public QueueConfiguration withQueueARN(String queueARN)
  {
    setQueueARN(queueARN);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.QueueConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */