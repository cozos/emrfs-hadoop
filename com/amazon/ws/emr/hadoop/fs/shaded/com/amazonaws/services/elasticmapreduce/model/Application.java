package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ApplicationMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Application
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private String version;
  private SdkInternalList<String> args;
  private SdkInternalMap<String, String> additionalInfo;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Application withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setVersion(String version)
  {
    this.version = version;
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public Application withVersion(String version)
  {
    setVersion(version);
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
  
  public Application withArgs(String... args)
  {
    if (this.args == null) {
      setArgs(new SdkInternalList(args.length));
    }
    for (String ele : args) {
      this.args.add(ele);
    }
    return this;
  }
  
  public Application withArgs(Collection<String> args)
  {
    setArgs(args);
    return this;
  }
  
  public Map<String, String> getAdditionalInfo()
  {
    if (additionalInfo == null) {
      additionalInfo = new SdkInternalMap();
    }
    return additionalInfo;
  }
  
  public void setAdditionalInfo(Map<String, String> additionalInfo)
  {
    this.additionalInfo = (additionalInfo == null ? null : new SdkInternalMap(additionalInfo));
  }
  
  public Application withAdditionalInfo(Map<String, String> additionalInfo)
  {
    setAdditionalInfo(additionalInfo);
    return this;
  }
  
  public Application addAdditionalInfoEntry(String key, String value)
  {
    if (null == additionalInfo) {
      additionalInfo = new SdkInternalMap();
    }
    if (additionalInfo.containsKey(key)) {
      throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
    }
    additionalInfo.put(key, value);
    return this;
  }
  
  public Application clearAdditionalInfoEntries()
  {
    additionalInfo = null;
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getVersion() != null) {
      sb.append("Version: ").append(getVersion()).append(",");
    }
    if (getArgs() != null) {
      sb.append("Args: ").append(getArgs()).append(",");
    }
    if (getAdditionalInfo() != null) {
      sb.append("AdditionalInfo: ").append(getAdditionalInfo());
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
    if (!(obj instanceof Application)) {
      return false;
    }
    Application other = (Application)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getVersion() == null ? 1 : 0) ^ (getVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVersion() != null) && (!other.getVersion().equals(getVersion()))) {
      return false;
    }
    if (((other.getArgs() == null ? 1 : 0) ^ (getArgs() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArgs() != null) && (!other.getArgs().equals(getArgs()))) {
      return false;
    }
    if (((other.getAdditionalInfo() == null ? 1 : 0) ^ (getAdditionalInfo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAdditionalInfo() != null) && (!other.getAdditionalInfo().equals(getAdditionalInfo()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getVersion() == null ? 0 : getVersion().hashCode());
    hashCode = 31 * hashCode + (getArgs() == null ? 0 : getArgs().hashCode());
    hashCode = 31 * hashCode + (getAdditionalInfo() == null ? 0 : getAdditionalInfo().hashCode());
    return hashCode;
  }
  
  public Application clone()
  {
    try
    {
      return (Application)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ApplicationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Application
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */