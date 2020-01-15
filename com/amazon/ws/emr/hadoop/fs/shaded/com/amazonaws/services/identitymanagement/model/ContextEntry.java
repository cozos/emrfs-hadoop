package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ContextEntry
  implements Serializable, Cloneable
{
  private String contextKeyName;
  private SdkInternalList<String> contextKeyValues;
  private String contextKeyType;
  
  public void setContextKeyName(String contextKeyName)
  {
    this.contextKeyName = contextKeyName;
  }
  
  public String getContextKeyName()
  {
    return contextKeyName;
  }
  
  public ContextEntry withContextKeyName(String contextKeyName)
  {
    setContextKeyName(contextKeyName);
    return this;
  }
  
  public List<String> getContextKeyValues()
  {
    if (contextKeyValues == null) {
      contextKeyValues = new SdkInternalList();
    }
    return contextKeyValues;
  }
  
  public void setContextKeyValues(Collection<String> contextKeyValues)
  {
    if (contextKeyValues == null)
    {
      this.contextKeyValues = null;
      return;
    }
    this.contextKeyValues = new SdkInternalList(contextKeyValues);
  }
  
  public ContextEntry withContextKeyValues(String... contextKeyValues)
  {
    if (this.contextKeyValues == null) {
      setContextKeyValues(new SdkInternalList(contextKeyValues.length));
    }
    for (String ele : contextKeyValues) {
      this.contextKeyValues.add(ele);
    }
    return this;
  }
  
  public ContextEntry withContextKeyValues(Collection<String> contextKeyValues)
  {
    setContextKeyValues(contextKeyValues);
    return this;
  }
  
  public void setContextKeyType(String contextKeyType)
  {
    this.contextKeyType = contextKeyType;
  }
  
  public String getContextKeyType()
  {
    return contextKeyType;
  }
  
  public ContextEntry withContextKeyType(String contextKeyType)
  {
    setContextKeyType(contextKeyType);
    return this;
  }
  
  public void setContextKeyType(ContextKeyTypeEnum contextKeyType)
  {
    withContextKeyType(contextKeyType);
  }
  
  public ContextEntry withContextKeyType(ContextKeyTypeEnum contextKeyType)
  {
    this.contextKeyType = contextKeyType.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getContextKeyName() != null) {
      sb.append("ContextKeyName: ").append(getContextKeyName()).append(",");
    }
    if (getContextKeyValues() != null) {
      sb.append("ContextKeyValues: ").append(getContextKeyValues()).append(",");
    }
    if (getContextKeyType() != null) {
      sb.append("ContextKeyType: ").append(getContextKeyType());
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
    if (!(obj instanceof ContextEntry)) {
      return false;
    }
    ContextEntry other = (ContextEntry)obj;
    if (((other.getContextKeyName() == null ? 1 : 0) ^ (getContextKeyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContextKeyName() != null) && (!other.getContextKeyName().equals(getContextKeyName()))) {
      return false;
    }
    if (((other.getContextKeyValues() == null ? 1 : 0) ^ (getContextKeyValues() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContextKeyValues() != null) && (!other.getContextKeyValues().equals(getContextKeyValues()))) {
      return false;
    }
    if (((other.getContextKeyType() == null ? 1 : 0) ^ (getContextKeyType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContextKeyType() != null) && (!other.getContextKeyType().equals(getContextKeyType()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getContextKeyName() == null ? 0 : getContextKeyName().hashCode());
    hashCode = 31 * hashCode + (getContextKeyValues() == null ? 0 : getContextKeyValues().hashCode());
    hashCode = 31 * hashCode + (getContextKeyType() == null ? 0 : getContextKeyType().hashCode());
    return hashCode;
  }
  
  public ContextEntry clone()
  {
    try
    {
      return (ContextEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ContextEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */