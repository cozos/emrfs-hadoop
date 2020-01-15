package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ConfigurationMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Configuration
  implements Serializable, Cloneable, StructuredPojo
{
  private String classification;
  private SdkInternalList<Configuration> configurations;
  private SdkInternalMap<String, String> properties;
  
  public void setClassification(String classification)
  {
    this.classification = classification;
  }
  
  public String getClassification()
  {
    return classification;
  }
  
  public Configuration withClassification(String classification)
  {
    setClassification(classification);
    return this;
  }
  
  public List<Configuration> getConfigurations()
  {
    if (configurations == null) {
      configurations = new SdkInternalList();
    }
    return configurations;
  }
  
  public void setConfigurations(Collection<Configuration> configurations)
  {
    if (configurations == null)
    {
      this.configurations = null;
      return;
    }
    this.configurations = new SdkInternalList(configurations);
  }
  
  public Configuration withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public Configuration withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public Map<String, String> getProperties()
  {
    if (properties == null) {
      properties = new SdkInternalMap();
    }
    return properties;
  }
  
  public void setProperties(Map<String, String> properties)
  {
    this.properties = (properties == null ? null : new SdkInternalMap(properties));
  }
  
  public Configuration withProperties(Map<String, String> properties)
  {
    setProperties(properties);
    return this;
  }
  
  public Configuration addPropertiesEntry(String key, String value)
  {
    if (null == properties) {
      properties = new SdkInternalMap();
    }
    if (properties.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    properties.put(key, value);
    return this;
  }
  
  public Configuration clearPropertiesEntries()
  {
    properties = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getClassification() != null) {
      sb.append("Classification: ").append(getClassification()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations()).append(",");
    }
    if (getProperties() != null) {
      sb.append("Properties: ").append(getProperties());
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
    if (!(obj instanceof Configuration)) {
      return false;
    }
    Configuration other = (Configuration)obj;
    if (((other.getClassification() == null ? 1 : 0) ^ (getClassification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClassification() != null) && (!other.getClassification().equals(getClassification()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    if (((other.getProperties() == null ? 1 : 0) ^ (getProperties() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProperties() != null) && (!other.getProperties().equals(getProperties()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getClassification() == null ? 0 : getClassification().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    hashCode = 31 * hashCode + (getProperties() == null ? 0 : getProperties().hashCode());
    return hashCode;
  }
  
  public Configuration clone()
  {
    try
    {
      return (Configuration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ConfigurationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Configuration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */