package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;
import java.util.Date;

public class EntityDetails
  implements Serializable, Cloneable
{
  private EntityInfo entityInfo;
  private Date lastAuthenticated;
  
  public void setEntityInfo(EntityInfo entityInfo)
  {
    this.entityInfo = entityInfo;
  }
  
  public EntityInfo getEntityInfo()
  {
    return entityInfo;
  }
  
  public EntityDetails withEntityInfo(EntityInfo entityInfo)
  {
    setEntityInfo(entityInfo);
    return this;
  }
  
  public void setLastAuthenticated(Date lastAuthenticated)
  {
    this.lastAuthenticated = lastAuthenticated;
  }
  
  public Date getLastAuthenticated()
  {
    return lastAuthenticated;
  }
  
  public EntityDetails withLastAuthenticated(Date lastAuthenticated)
  {
    setLastAuthenticated(lastAuthenticated);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEntityInfo() != null) {
      sb.append("EntityInfo: ").append(getEntityInfo()).append(",");
    }
    if (getLastAuthenticated() != null) {
      sb.append("LastAuthenticated: ").append(getLastAuthenticated());
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
    if (!(obj instanceof EntityDetails)) {
      return false;
    }
    EntityDetails other = (EntityDetails)obj;
    if (((other.getEntityInfo() == null ? 1 : 0) ^ (getEntityInfo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEntityInfo() != null) && (!other.getEntityInfo().equals(getEntityInfo()))) {
      return false;
    }
    if (((other.getLastAuthenticated() == null ? 1 : 0) ^ (getLastAuthenticated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastAuthenticated() != null) && (!other.getLastAuthenticated().equals(getLastAuthenticated()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEntityInfo() == null ? 0 : getEntityInfo().hashCode());
    hashCode = 31 * hashCode + (getLastAuthenticated() == null ? 0 : getLastAuthenticated().hashCode());
    return hashCode;
  }
  
  public EntityDetails clone()
  {
    try
    {
      return (EntityDetails)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EntityDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */