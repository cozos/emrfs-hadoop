package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class EntityInfo
  implements Serializable, Cloneable
{
  private String arn;
  private String name;
  private String type;
  private String id;
  private String path;
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public EntityInfo withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public EntityInfo withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public String getType()
  {
    return type;
  }
  
  public EntityInfo withType(String type)
  {
    setType(type);
    return this;
  }
  
  public EntityInfo withType(PolicyOwnerEntityType type)
  {
    this.type = type.toString();
    return this;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public EntityInfo withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setPath(String path)
  {
    this.path = path;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public EntityInfo withPath(String path)
  {
    setPath(path);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getType() != null) {
      sb.append("Type: ").append(getType()).append(",");
    }
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getPath() != null) {
      sb.append("Path: ").append(getPath());
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
    if (!(obj instanceof EntityInfo)) {
      return false;
    }
    EntityInfo other = (EntityInfo)obj;
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getType() == null ? 1 : 0) ^ (getType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getType() != null) && (!other.getType().equals(getType()))) {
      return false;
    }
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getPath() == null ? 1 : 0) ^ (getPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPath() != null) && (!other.getPath().equals(getPath()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getType() == null ? 0 : getType().hashCode());
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getPath() == null ? 0 : getPath().hashCode());
    return hashCode;
  }
  
  public EntityInfo clone()
  {
    try
    {
      return (EntityInfo)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EntityInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */