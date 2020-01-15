package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class NotificationConfiguration
{
  private Set<String> events = new HashSet();
  @Deprecated
  private List<String> objectPrefixes = new ArrayList();
  private Filter filter;
  
  protected NotificationConfiguration() {}
  
  protected NotificationConfiguration(EnumSet<S3Event> events)
  {
    if (events != null) {
      for (S3Event s3Event : events) {
        this.events.add(s3Event.toString());
      }
    }
  }
  
  protected NotificationConfiguration(String... events)
  {
    if (events != null) {
      for (String event : events) {
        this.events.add(event);
      }
    }
  }
  
  public Set<String> getEvents()
  {
    return events;
  }
  
  public void setEvents(Set<String> events)
  {
    this.events = events;
  }
  
  @Deprecated
  public List<String> getObjectPrefixes()
  {
    return objectPrefixes;
  }
  
  @Deprecated
  public void setObjectPrefixes(List<String> objectPrefixes)
  {
    this.objectPrefixes = objectPrefixes;
  }
  
  public NotificationConfiguration withEvents(Set<String> events)
  {
    this.events.clear();
    this.events.addAll(events);
    return this;
  }
  
  @Deprecated
  public NotificationConfiguration withObjectPrefixes(String... objectPrefixes)
  {
    this.objectPrefixes.clear();
    if ((objectPrefixes != null) && (objectPrefixes.length > 0)) {
      this.objectPrefixes.addAll(Arrays.asList(objectPrefixes));
    }
    return this;
  }
  
  public void addEvent(String event)
  {
    events.add(event);
  }
  
  public void addEvent(S3Event event)
  {
    events.add(event.toString());
  }
  
  @Deprecated
  public void addObjectPrefix(String prefix)
  {
    objectPrefixes.add(prefix);
  }
  
  public Filter getFilter()
  {
    return filter;
  }
  
  public void setFilter(Filter filter)
  {
    this.filter = filter;
  }
  
  public NotificationConfiguration withFilter(Filter filter)
  {
    setFilter(filter);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.NotificationConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */