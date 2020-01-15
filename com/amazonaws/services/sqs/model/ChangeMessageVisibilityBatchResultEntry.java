package com.amazonaws.services.sqs.model;

import java.io.Serializable;

public class ChangeMessageVisibilityBatchResultEntry
  implements Serializable, Cloneable
{
  private String id;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public ChangeMessageVisibilityBatchResultEntry withId(String id)
  {
    setId(id);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId());
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
    if (!(obj instanceof ChangeMessageVisibilityBatchResultEntry)) {
      return false;
    }
    ChangeMessageVisibilityBatchResultEntry other = (ChangeMessageVisibilityBatchResultEntry)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    return hashCode;
  }
  
  public ChangeMessageVisibilityBatchResultEntry clone()
  {
    try
    {
      return (ChangeMessageVisibilityBatchResultEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResultEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */