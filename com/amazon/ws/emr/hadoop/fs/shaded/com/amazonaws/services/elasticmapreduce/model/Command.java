package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CommandMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Command
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private String scriptPath;
  private SdkInternalList<String> args;
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Command withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setScriptPath(String scriptPath)
  {
    this.scriptPath = scriptPath;
  }
  
  public String getScriptPath()
  {
    return scriptPath;
  }
  
  public Command withScriptPath(String scriptPath)
  {
    setScriptPath(scriptPath);
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
  
  public Command withArgs(String... args)
  {
    if (this.args == null) {
      setArgs(new SdkInternalList(args.length));
    }
    for (String ele : args) {
      this.args.add(ele);
    }
    return this;
  }
  
  public Command withArgs(Collection<String> args)
  {
    setArgs(args);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getScriptPath() != null) {
      sb.append("ScriptPath: ").append(getScriptPath()).append(",");
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
    if (!(obj instanceof Command)) {
      return false;
    }
    Command other = (Command)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getScriptPath() == null ? 1 : 0) ^ (getScriptPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScriptPath() != null) && (!other.getScriptPath().equals(getScriptPath()))) {
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
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getScriptPath() == null ? 0 : getScriptPath().hashCode());
    hashCode = 31 * hashCode + (getArgs() == null ? 0 : getArgs().hashCode());
    return hashCode;
  }
  
  public Command clone()
  {
    try
    {
      return (Command)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    CommandMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Command
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */