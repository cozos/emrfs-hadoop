package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListUsersResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<User> users;
  private Boolean isTruncated;
  private String marker;
  
  public List<User> getUsers()
  {
    if (users == null) {
      users = new SdkInternalList();
    }
    return users;
  }
  
  public void setUsers(Collection<User> users)
  {
    if (users == null)
    {
      this.users = null;
      return;
    }
    this.users = new SdkInternalList(users);
  }
  
  public ListUsersResult withUsers(User... users)
  {
    if (this.users == null) {
      setUsers(new SdkInternalList(users.length));
    }
    for (User ele : users) {
      this.users.add(ele);
    }
    return this;
  }
  
  public ListUsersResult withUsers(Collection<User> users)
  {
    setUsers(users);
    return this;
  }
  
  public void setIsTruncated(Boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public Boolean getIsTruncated()
  {
    return isTruncated;
  }
  
  public ListUsersResult withIsTruncated(Boolean isTruncated)
  {
    setIsTruncated(isTruncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public ListUsersResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUsers() != null) {
      sb.append("Users: ").append(getUsers()).append(",");
    }
    if (getIsTruncated() != null) {
      sb.append("IsTruncated: ").append(getIsTruncated()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof ListUsersResult)) {
      return false;
    }
    ListUsersResult other = (ListUsersResult)obj;
    if (((other.getUsers() == null ? 1 : 0) ^ (getUsers() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUsers() != null) && (!other.getUsers().equals(getUsers()))) {
      return false;
    }
    if (((other.getIsTruncated() == null ? 1 : 0) ^ (getIsTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsTruncated() != null) && (!other.getIsTruncated().equals(getIsTruncated()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getUsers() == null ? 0 : getUsers().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListUsersResult clone()
  {
    try
    {
      return (ListUsersResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUsersResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */