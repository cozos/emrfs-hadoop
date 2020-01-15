package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.util.Set;

@Deprecated
public class BucketNotificationConfiguration$TopicConfiguration
  extends TopicConfiguration
{
  public BucketNotificationConfiguration$TopicConfiguration(String topic, String event)
  {
    super(topic, new String[] { event });
  }
  
  public String getTopic()
  {
    return getTopicARN();
  }
  
  /**
   * @deprecated
   */
  public String getEvent()
  {
    Set<String> events = getEvents();
    String[] eventArray = (String[])events.toArray(new String[events.size()]);
    return eventArray[0];
  }
  
  public String toString()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketNotificationConfiguration.TopicConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */