package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateUserResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private User user;
  
  public void setUser(User user)
  {
    this.user = user;
  }
  
  public User getUser()
  {
    return user;
  }
  
  public CreateUserResult withUser(User user)
  {
    setUser(user);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUser() != null) {
      sb.append("User: ").append(getUser());
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
    if (!(obj instanceof CreateUserResult)) {
      return false;
    }
    CreateUserResult other = (CreateUserResult)obj;
    if (((other.getUser() == null ? 1 : 0) ^ (getUser() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUser() != null) && (!other.getUser().equals(getUser()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUser() == null ? 0 : getUser().hashCode());
    return hashCode;
  }
  
  public CreateUserResult clone()
  {
    try
    {
      return (CreateUserResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateUserResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */