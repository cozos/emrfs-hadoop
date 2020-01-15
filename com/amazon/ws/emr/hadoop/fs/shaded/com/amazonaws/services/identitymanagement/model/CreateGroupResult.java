package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateGroupResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Group group;
  
  public void setGroup(Group group)
  {
    this.group = group;
  }
  
  public Group getGroup()
  {
    return group;
  }
  
  public CreateGroupResult withGroup(Group group)
  {
    setGroup(group);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGroup() != null) {
      sb.append("Group: ").append(getGroup());
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
    if (!(obj instanceof CreateGroupResult)) {
      return false;
    }
    CreateGroupResult other = (CreateGroupResult)obj;
    if (((other.getGroup() == null ? 1 : 0) ^ (getGroup() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroup() != null) && (!other.getGroup().equals(getGroup()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGroup() == null ? 0 : getGroup().hashCode());
    return hashCode;
  }
  
  public CreateGroupResult clone()
  {
    try
    {
      return (CreateGroupResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateGroupResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */