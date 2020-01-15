package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.replication.ReplicationFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.Serializable;

public class ReplicationRule
  implements Serializable
{
  private String prefix;
  private String status;
  private ReplicationDestinationConfig destinationConfig;
  private SourceSelectionCriteria sourceSelectionCriteria;
  private ReplicationFilter filter;
  private Integer priority;
  private DeleteMarkerReplication deleteMarkerReplication;
  
  public Integer getPriority()
  {
    return priority;
  }
  
  public void setPriority(Integer priority)
  {
    if (priority.intValue() < 0) {
      throw new IllegalArgumentException("Priority has to be a positive number");
    }
    this.priority = priority;
  }
  
  public ReplicationRule withPriority(Integer priority)
  {
    setPriority(priority);
    return this;
  }
  
  public DeleteMarkerReplication getDeleteMarkerReplication()
  {
    return deleteMarkerReplication;
  }
  
  public void setDeleteMarkerReplication(DeleteMarkerReplication deleteMarkerReplication)
  {
    this.deleteMarkerReplication = deleteMarkerReplication;
  }
  
  public ReplicationRule withDeleteMarkerReplication(DeleteMarkerReplication deleteMarkerReplication)
  {
    setDeleteMarkerReplication(deleteMarkerReplication);
    return this;
  }
  
  @Deprecated
  public String getPrefix()
  {
    return prefix;
  }
  
  @Deprecated
  public void setPrefix(String prefix)
  {
    if (prefix == null) {
      throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
    }
    if (filter != null) {
      throw new IllegalArgumentException("You cannot use both prefix and filter at the same time in a replication rule");
    }
    this.prefix = prefix;
  }
  
  @Deprecated
  public ReplicationRule withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
  
  public ReplicationFilter getFilter()
  {
    return filter;
  }
  
  public void setFilter(ReplicationFilter filter)
  {
    if (filter == null) {
      throw new IllegalArgumentException("Filter cannot be null for a replication rule");
    }
    if (prefix != null) {
      throw new IllegalArgumentException("You cannot use both prefix and filter at the same time in a replication rule");
    }
    this.filter = filter;
  }
  
  public ReplicationRule withFilter(ReplicationFilter filter)
  {
    setFilter(filter);
    return this;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public ReplicationRule withStatus(String status)
  {
    setStatus(status);
    return this;
  }
  
  public void setStatus(ReplicationRuleStatus status)
  {
    setStatus(status.getStatus());
  }
  
  public ReplicationRule withStatus(ReplicationRuleStatus status)
  {
    setStatus(status.getStatus());
    return this;
  }
  
  public ReplicationDestinationConfig getDestinationConfig()
  {
    return destinationConfig;
  }
  
  public void setDestinationConfig(ReplicationDestinationConfig destinationConfig)
  {
    if (destinationConfig == null) {
      throw new IllegalArgumentException("Destination cannot be null in the replication rule");
    }
    this.destinationConfig = destinationConfig;
  }
  
  public ReplicationRule withDestinationConfig(ReplicationDestinationConfig destinationConfig)
  {
    setDestinationConfig(destinationConfig);
    return this;
  }
  
  public SourceSelectionCriteria getSourceSelectionCriteria()
  {
    return sourceSelectionCriteria;
  }
  
  public void setSourceSelectionCriteria(SourceSelectionCriteria sourceSelectionCriteria)
  {
    this.sourceSelectionCriteria = sourceSelectionCriteria;
  }
  
  public ReplicationRule withSourceSelectionCriteria(SourceSelectionCriteria sourceSelectionCriteria)
  {
    setSourceSelectionCriteria(sourceSelectionCriteria);
    return this;
  }
  
  public String toString()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */