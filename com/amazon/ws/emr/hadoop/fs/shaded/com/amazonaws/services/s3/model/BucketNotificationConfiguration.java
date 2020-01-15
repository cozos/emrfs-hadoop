package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class BucketNotificationConfiguration
  implements Serializable
{
  private Map<String, NotificationConfiguration> configurations = null;
  
  public BucketNotificationConfiguration()
  {
    configurations = new HashMap();
  }
  
  public BucketNotificationConfiguration(String name, NotificationConfiguration notificationConfiguration)
  {
    configurations = new HashMap();
    addConfiguration(name, notificationConfiguration);
  }
  
  public BucketNotificationConfiguration withNotificationConfiguration(Map<String, NotificationConfiguration> notificationConfiguration)
  {
    configurations.clear();
    configurations.putAll(notificationConfiguration);
    return this;
  }
  
  public BucketNotificationConfiguration addConfiguration(String name, NotificationConfiguration notificationConfiguration)
  {
    configurations.put(name, notificationConfiguration);
    return this;
  }
  
  public Map<String, NotificationConfiguration> getConfigurations()
  {
    return configurations;
  }
  
  public void setConfigurations(Map<String, NotificationConfiguration> configurations)
  {
    this.configurations = configurations;
  }
  
  public NotificationConfiguration getConfigurationByName(String name)
  {
    return (NotificationConfiguration)configurations.get(name);
  }
  
  public NotificationConfiguration removeConfiguration(String name)
  {
    return (NotificationConfiguration)configurations.remove(name);
  }
  
  /**
   * @deprecated
   */
  public BucketNotificationConfiguration(Collection<TopicConfiguration> topicConfigurations)
  {
    configurations = new HashMap();
    if (topicConfigurations != null) {
      for (TopicConfiguration config : topicConfigurations) {
        addConfiguration(UUID.randomUUID().toString(), config);
      }
    }
  }
  
  /**
   * @deprecated
   */
  public BucketNotificationConfiguration withTopicConfigurations(TopicConfiguration... topicConfigurations)
  {
    setTopicConfigurations(Arrays.asList(topicConfigurations));
    return this;
  }
  
  /**
   * @deprecated
   */
  public void setTopicConfigurations(Collection<TopicConfiguration> topicConfigurations)
  {
    configurations.clear();
    if (topicConfigurations != null) {
      for (TopicConfiguration topicConfiguration : topicConfigurations) {
        addConfiguration(UUID.randomUUID().toString(), topicConfiguration);
      }
    }
  }
  
  /**
   * @deprecated
   */
  public List<TopicConfiguration> getTopicConfigurations()
  {
    List<TopicConfiguration> topicConfigs = new ArrayList();
    for (Map.Entry<String, NotificationConfiguration> entry : configurations
      .entrySet()) {
      if ((entry.getValue() instanceof TopicConfiguration)) {
        topicConfigs.add((TopicConfiguration)entry.getValue());
      }
    }
    return topicConfigs;
  }
  
  public String toString()
  {
    return Jackson.toJsonString(getConfigurations());
  }
  
  @Deprecated
  public static class TopicConfiguration
    extends TopicConfiguration
  {
    public TopicConfiguration(String topic, String event)
    {
      super(new String[] { event });
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketNotificationConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */