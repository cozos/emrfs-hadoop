package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.HadoopStepConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class HadoopStepConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String jar;
  private SdkInternalMap<String, String> properties;
  private String mainClass;
  private SdkInternalList<String> args;
  
  public void setJar(String jar)
  {
    this.jar = jar;
  }
  
  public String getJar()
  {
    return jar;
  }
  
  public HadoopStepConfig withJar(String jar)
  {
    setJar(jar);
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
  
  public HadoopStepConfig withProperties(Map<String, String> properties)
  {
    setProperties(properties);
    return this;
  }
  
  public HadoopStepConfig addPropertiesEntry(String key, String value)
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
  
  public HadoopStepConfig clearPropertiesEntries()
  {
    properties = null;
    return this;
  }
  
  public void setMainClass(String mainClass)
  {
    this.mainClass = mainClass;
  }
  
  public String getMainClass()
  {
    return mainClass;
  }
  
  public HadoopStepConfig withMainClass(String mainClass)
  {
    setMainClass(mainClass);
    return this;
  }
  
  public List<String> getArgs()
  {
    if (args == null) {
      args = new SdkInternalList();
    }
    return args;
  }
  
  public void setArgs(Collection<String> args)
  {
    if (args == null)
    {
      this.args = null;
      return;
    }
    this.args = new SdkInternalList(args);
  }
  
  public HadoopStepConfig withArgs(String... args)
  {
    if (this.args == null) {
      setArgs(new SdkInternalList(args.length));
    }
    for (String ele : args) {
      this.args.add(ele);
    }
    return this;
  }
  
  public HadoopStepConfig withArgs(Collection<String> args)
  {
    setArgs(args);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJar() != null) {
      sb.append("Jar: ").append(getJar()).append(",");
    }
    if (getProperties() != null) {
      sb.append("Properties: ").append(getProperties()).append(",");
    }
    if (getMainClass() != null) {
      sb.append("MainClass: ").append(getMainClass()).append(",");
    }
    if (getArgs() != null) {
      sb.append("Args: ").append(getArgs());
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
    if (!(obj instanceof HadoopStepConfig)) {
      return false;
    }
    HadoopStepConfig other = (HadoopStepConfig)obj;
    if (((other.getJar() == null ? 1 : 0) ^ (getJar() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJar() != null) && (!other.getJar().equals(getJar()))) {
      return false;
    }
    if (((other.getProperties() == null ? 1 : 0) ^ (getProperties() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProperties() != null) && (!other.getProperties().equals(getProperties()))) {
      return false;
    }
    if (((other.getMainClass() == null ? 1 : 0) ^ (getMainClass() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMainClass() != null) && (!other.getMainClass().equals(getMainClass()))) {
      return false;
    }
    if (((other.getArgs() == null ? 1 : 0) ^ (getArgs() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArgs() != null) && (!other.getArgs().equals(getArgs()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJar() == null ? 0 : getJar().hashCode());
    hashCode = 31 * hashCode + (getProperties() == null ? 0 : getProperties().hashCode());
    hashCode = 31 * hashCode + (getMainClass() == null ? 0 : getMainClass().hashCode());
    hashCode = 31 * hashCode + (getArgs() == null ? 0 : getArgs().hashCode());
    return hashCode;
  }
  
  public HadoopStepConfig clone()
  {
    try
    {
      return (HadoopStepConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    HadoopStepConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopStepConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */