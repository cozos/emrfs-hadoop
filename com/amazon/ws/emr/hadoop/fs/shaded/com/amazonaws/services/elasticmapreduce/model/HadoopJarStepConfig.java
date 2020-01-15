package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.HadoopJarStepConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class HadoopJarStepConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private SdkInternalList<KeyValue> properties;
  private String jar;
  private String mainClass;
  private SdkInternalList<String> args;
  
  public HadoopJarStepConfig() {}
  
  public HadoopJarStepConfig(String jar)
  {
    setJar(jar);
  }
  
  public List<KeyValue> getProperties()
  {
    if (properties == null) {
      properties = new SdkInternalList();
    }
    return properties;
  }
  
  public void setProperties(Collection<KeyValue> properties)
  {
    if (properties == null)
    {
      this.properties = null;
      return;
    }
    this.properties = new SdkInternalList(properties);
  }
  
  public HadoopJarStepConfig withProperties(KeyValue... properties)
  {
    if (this.properties == null) {
      setProperties(new SdkInternalList(properties.length));
    }
    for (KeyValue ele : properties) {
      this.properties.add(ele);
    }
    return this;
  }
  
  public HadoopJarStepConfig withProperties(Collection<KeyValue> properties)
  {
    setProperties(properties);
    return this;
  }
  
  public void setJar(String jar)
  {
    this.jar = jar;
  }
  
  public String getJar()
  {
    return jar;
  }
  
  public HadoopJarStepConfig withJar(String jar)
  {
    setJar(jar);
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
  
  public HadoopJarStepConfig withMainClass(String mainClass)
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
  
  public HadoopJarStepConfig withArgs(String... args)
  {
    if (this.args == null) {
      setArgs(new SdkInternalList(args.length));
    }
    for (String ele : args) {
      this.args.add(ele);
    }
    return this;
  }
  
  public HadoopJarStepConfig withArgs(Collection<String> args)
  {
    setArgs(args);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getProperties() != null) {
      sb.append("Properties: ").append(getProperties()).append(",");
    }
    if (getJar() != null) {
      sb.append("Jar: ").append(getJar()).append(",");
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
    if (!(obj instanceof HadoopJarStepConfig)) {
      return false;
    }
    HadoopJarStepConfig other = (HadoopJarStepConfig)obj;
    if (((other.getProperties() == null ? 1 : 0) ^ (getProperties() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProperties() != null) && (!other.getProperties().equals(getProperties()))) {
      return false;
    }
    if (((other.getJar() == null ? 1 : 0) ^ (getJar() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJar() != null) && (!other.getJar().equals(getJar()))) {
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
    
    hashCode = 31 * hashCode + (getProperties() == null ? 0 : getProperties().hashCode());
    hashCode = 31 * hashCode + (getJar() == null ? 0 : getJar().hashCode());
    hashCode = 31 * hashCode + (getMainClass() == null ? 0 : getMainClass().hashCode());
    hashCode = 31 * hashCode + (getArgs() == null ? 0 : getArgs().hashCode());
    return hashCode;
  }
  
  public HadoopJarStepConfig clone()
  {
    try
    {
      return (HadoopJarStepConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    HadoopJarStepConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */