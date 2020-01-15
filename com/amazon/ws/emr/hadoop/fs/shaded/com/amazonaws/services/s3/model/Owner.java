package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Owner
  implements Serializable
{
  private static final long serialVersionUID = -8916731456944569115L;
  private String displayName;
  private String id;
  
  public Owner() {}
  
  public Owner(String id, String displayName)
  {
    this.id = id;
    this.displayName = displayName;
  }
  
  public String toString()
  {
    return "S3Owner [name=" + getDisplayName() + ",id=" + getId() + "]";
  }
  
  public String getId()
  {
    return id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getDisplayName()
  {
    return displayName;
  }
  
  public void setDisplayName(String name)
  {
    displayName = name;
  }
  
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Owner)) {
      return false;
    }
    Owner otherOwner = (Owner)obj;
    
    String otherOwnerId = otherOwner.getId();
    String otherOwnerName = otherOwner.getDisplayName();
    String thisOwnerId = getId();
    String thisOwnerName = getDisplayName();
    if (otherOwnerId == null) {
      otherOwnerId = "";
    }
    if (otherOwnerName == null) {
      otherOwnerName = "";
    }
    if (thisOwnerId == null) {
      thisOwnerId = "";
    }
    if (thisOwnerName == null) {
      thisOwnerName = "";
    }
    return (otherOwnerId.equals(thisOwnerId)) && 
      (otherOwnerName.equals(thisOwnerName));
  }
  
  public int hashCode()
  {
    if (id != null) {
      return id.hashCode();
    }
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Owner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */