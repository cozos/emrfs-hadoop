package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScriptBootstrapActionConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ScriptBootstrapActionConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String path;
  private SdkInternalList<String> args;
  
  public ScriptBootstrapActionConfig() {}
  
  public ScriptBootstrapActionConfig(String path, List<String> args)
  {
    setPath(path);
    setArgs(args);
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public ScriptBootstrapActionConfig withPath(String path)
  {
    setPath(path);
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
  
  public ScriptBootstrapActionConfig withArgs(String... args)
  {
    if (this.args == null) {
      setArgs(new SdkInternalList(args.length));
    }
    for (String ele : args) {
      this.args.add(ele);
    }
    return this;
  }
  
  public ScriptBootstrapActionConfig withArgs(Collection<String> args)
  {
    setArgs(args);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPath() != null) {
      sb.append("Path: ").append(getPath()).append(",");
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
    if (!(obj instanceof ScriptBootstrapActionConfig)) {
      return false;
    }
    ScriptBootstrapActionConfig other = (ScriptBootstrapActionConfig)obj;
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
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
    
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    hashCode = 31 * hashCode + (getArgs() == null ? 0 : getArgs().hashCode());
    return hashCode;
  }
  
  public ScriptBootstrapActionConfig clone()
  {
    try
    {
      return (ScriptBootstrapActionConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ScriptBootstrapActionConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */