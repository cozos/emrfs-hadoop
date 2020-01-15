package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BootstrapActionConfigMarshaller;
import java.io.Serializable;

public class BootstrapActionConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private ScriptBootstrapActionConfig scriptBootstrapAction;
  
  public BootstrapActionConfig() {}
  
  public BootstrapActionConfig(String name, ScriptBootstrapActionConfig scriptBootstrapAction)
  {
    setName(name);
    setScriptBootstrapAction(scriptBootstrapAction);
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public BootstrapActionConfig withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setScriptBootstrapAction(ScriptBootstrapActionConfig scriptBootstrapAction)
  {
    this.scriptBootstrapAction = scriptBootstrapAction;
  }
  
  public ScriptBootstrapActionConfig getScriptBootstrapAction()
  {
    return scriptBootstrapAction;
  }
  
  public BootstrapActionConfig withScriptBootstrapAction(ScriptBootstrapActionConfig scriptBootstrapAction)
  {
    setScriptBootstrapAction(scriptBootstrapAction);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getScriptBootstrapAction() != null) {
      sb.append("ScriptBootstrapAction: ").append(getScriptBootstrapAction());
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
    if (!(obj instanceof BootstrapActionConfig)) {
      return false;
    }
    BootstrapActionConfig other = (BootstrapActionConfig)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getScriptBootstrapAction() == null ? 1 : 0) ^ (getScriptBootstrapAction() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScriptBootstrapAction() != null) && (!other.getScriptBootstrapAction().equals(getScriptBootstrapAction()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getScriptBootstrapAction() == null ? 0 : getScriptBootstrapAction().hashCode());
    return hashCode;
  }
  
  public BootstrapActionConfig clone()
  {
    try
    {
      return (BootstrapActionConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    BootstrapActionConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */