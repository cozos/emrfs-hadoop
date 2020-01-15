package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServerSideEncryptionConfiguration
  implements Serializable, Cloneable
{
  private List<ServerSideEncryptionRule> rules;
  
  public List<ServerSideEncryptionRule> getRules()
  {
    return rules;
  }
  
  public void setRules(Collection<ServerSideEncryptionRule> rules)
  {
    if (rules == null)
    {
      this.rules = null;
      return;
    }
    this.rules = new ArrayList(rules);
  }
  
  public ServerSideEncryptionConfiguration withRules(ServerSideEncryptionRule... rules)
  {
    if (this.rules == null) {
      setRules(new ArrayList(rules.length));
    }
    for (ServerSideEncryptionRule ele : rules) {
      this.rules.add(ele);
    }
    return this;
  }
  
  public ServerSideEncryptionConfiguration withRules(Collection<ServerSideEncryptionRule> rules)
  {
    setRules(rules);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRules() != null) {
      sb.append("Rules: ").append(getRules()).append(",");
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
    if (!(obj instanceof ServerSideEncryptionConfiguration)) {
      return false;
    }
    ServerSideEncryptionConfiguration other = (ServerSideEncryptionConfiguration)obj;
    if (((other.getRules() == null ? 1 : 0) ^ (getRules() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRules() != null) && (!other.getRules().equals(getRules()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRules() == null ? 0 : getRules().hashCode());
    return hashCode;
  }
  
  public ServerSideEncryptionConfiguration clone()
  {
    try
    {
      return (ServerSideEncryptionConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */