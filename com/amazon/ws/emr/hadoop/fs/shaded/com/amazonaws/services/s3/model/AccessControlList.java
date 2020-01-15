package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AccessControlList
  implements Serializable, S3RequesterChargedResult
{
  private static final long serialVersionUID = 8095040648034788376L;
  private Set<Grant> grantSet;
  private List<Grant> grantList;
  private Owner owner = null;
  private boolean isRequesterCharged;
  
  public Owner getOwner()
  {
    return owner;
  }
  
  public void setOwner(Owner owner)
  {
    this.owner = owner;
  }
  
  public void grantPermission(Grantee grantee, Permission permission)
  {
    getGrantsAsList().add(new Grant(grantee, permission));
  }
  
  public void grantAllPermissions(Grant... grantsVarArg)
  {
    for (Grant gap : grantsVarArg) {
      grantPermission(gap.getGrantee(), gap.getPermission());
    }
  }
  
  public void revokeAllPermissions(Grantee grantee)
  {
    ArrayList<Grant> grantsToRemove = new ArrayList();
    List<Grant> existingGrants = getGrantsAsList();
    for (Grant gap : existingGrants) {
      if (gap.getGrantee().equals(grantee)) {
        grantsToRemove.add(gap);
      }
    }
    grantList.removeAll(grantsToRemove);
  }
  
  @Deprecated
  public Set<Grant> getGrants()
  {
    checkState();
    if (grantSet == null) {
      if (grantList == null)
      {
        grantSet = new HashSet();
      }
      else
      {
        grantSet = new HashSet(grantList);
        grantList = null;
      }
    }
    return grantSet;
  }
  
  private void checkState()
  {
    if ((grantSet != null) && (grantList != null)) {
      throw new IllegalStateException("Both grant set and grant list cannot be null");
    }
  }
  
  public List<Grant> getGrantsAsList()
  {
    checkState();
    if (grantList == null) {
      if (grantSet == null)
      {
        grantList = new LinkedList();
      }
      else
      {
        grantList = new LinkedList(grantSet);
        grantSet = null;
      }
    }
    return grantList;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (owner == null ? 0 : owner.hashCode());
    result = 31 * result + (grantSet == null ? 0 : grantSet.hashCode());
    result = 31 * result + (grantList == null ? 0 : grantList.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    AccessControlList other = (AccessControlList)obj;
    if (owner == null)
    {
      if (owner != null) {
        return false;
      }
    }
    else if (!owner.equals(owner)) {
      return false;
    }
    if (grantSet == null)
    {
      if (grantSet != null) {
        return false;
      }
    }
    else if (!grantSet.equals(grantSet)) {
      return false;
    }
    if (grantList == null)
    {
      if (grantList != null) {
        return false;
      }
    }
    else if (!grantList.equals(grantList)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "AccessControlList [owner=" + owner + ", grants=" + getGrantsAsList() + "]";
  }
  
  public boolean isRequesterCharged()
  {
    return isRequesterCharged;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    this.isRequesterCharged = isRequesterCharged;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */