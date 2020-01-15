package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

public class TopicConfiguration
  extends NotificationConfiguration
  implements Serializable
{
  private String topicARN;
  
  public TopicConfiguration() {}
  
  public TopicConfiguration(String topicARN, EnumSet<S3Event> events)
  {
    super(events);
    this.topicARN = topicARN;
  }
  
  public TopicConfiguration(String topicARN, String... events)
  {
    super(events);
    this.topicARN = topicARN;
  }
  
  public String getTopicARN()
  {
    return topicARN;
  }
  
  public void setTopicARN(String topicARN)
  {
    this.topicARN = topicARN;
  }
  
  public TopicConfiguration withTopicARN(String topicARN)
  {
    setTopicARN(topicARN);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TopicConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */