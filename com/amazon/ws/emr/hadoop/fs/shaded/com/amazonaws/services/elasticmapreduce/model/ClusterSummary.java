package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ClusterSummaryMarshaller;
import java.io.Serializable;

public class ClusterSummary
  implements Serializable, Cloneable, StructuredPojo
{
  private String id;
  private String name;
  private ClusterStatus status;
  private Integer normalizedInstanceHours;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public ClusterSummary withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public ClusterSummary withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setStatus(ClusterStatus status)
  {
    this.status = status;
  }
  
  public ClusterStatus getStatus()
  {
    return status;
  }
  
  public ClusterSummary withStatus(ClusterStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public void setNormalizedInstanceHours(Integer normalizedInstanceHours)
  {
    this.normalizedInstanceHours = normalizedInstanceHours;
  }
  
  public Integer getNormalizedInstanceHours()
  {
    return normalizedInstanceHours;
  }
  
  public ClusterSummary withNormalizedInstanceHours(Integer normalizedInstanceHours)
  {
    setNormalizedInstanceHours(normalizedInstanceHours);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getNormalizedInstanceHours() != null) {
      sb.append("NormalizedInstanceHours: ").append(getNormalizedInstanceHours());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof ClusterSummary)) {
      return false;
    }
    ClusterSummary other = (ClusterSummary)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getNormalizedInstanceHours() == null ? 1 : 0) ^ (getNormalizedInstanceHours() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNormalizedInstanceHours() != null) && (!other.getNormalizedInstanceHours().equals(getNormalizedInstanceHours()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getNormalizedInstanceHours() == null ? 0 : getNormalizedInstanceHours().hashCode());
    return hashCode;
  }
  
  public ClusterSummary clone()
  {
    try
    {
      return (ClusterSummary)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ClusterSummaryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ClusterSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */