package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListEntitiesForPolicyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<PolicyGroup> policyGroups;
  private SdkInternalList<PolicyUser> policyUsers;
  private SdkInternalList<PolicyRole> policyRoles;
  private Boolean isTruncated;
  private String marker;
  
  public List<PolicyGroup> getPolicyGroups()
  {
    if (policyGroups == null) {
      policyGroups = new SdkInternalList();
    }
    return policyGroups;
  }
  
  public void setPolicyGroups(Collection<PolicyGroup> policyGroups)
  {
    if (policyGroups == null)
    {
      this.policyGroups = null;
      return;
    }
    this.policyGroups = new SdkInternalList(policyGroups);
  }
  
  public ListEntitiesForPolicyResult withPolicyGroups(PolicyGroup... policyGroups)
  {
    if (this.policyGroups == null) {
      setPolicyGroups(new SdkInternalList(policyGroups.length));
    }
    for (PolicyGroup ele : policyGroups) {
      this.policyGroups.add(ele);
    }
    return this;
  }
  
  public ListEntitiesForPolicyResult withPolicyGroups(Collection<PolicyGroup> policyGroups)
  {
    setPolicyGroups(policyGroups);
    return this;
  }
  
  public List<PolicyUser> getPolicyUsers()
  {
    if (policyUsers == null) {
      policyUsers = new SdkInternalList();
    }
    return policyUsers;
  }
  
  public void setPolicyUsers(Collection<PolicyUser> policyUsers)
  {
    if (policyUsers == null)
    {
      this.policyUsers = null;
      return;
    }
    this.policyUsers = new SdkInternalList(policyUsers);
  }
  
  public ListEntitiesForPolicyResult withPolicyUsers(PolicyUser... policyUsers)
  {
    if (this.policyUsers == null) {
      setPolicyUsers(new SdkInternalList(policyUsers.length));
    }
    for (PolicyUser ele : policyUsers) {
      this.policyUsers.add(ele);
    }
    return this;
  }
  
  public ListEntitiesForPolicyResult withPolicyUsers(Collection<PolicyUser> policyUsers)
  {
    setPolicyUsers(policyUsers);
    return this;
  }
  
  public List<PolicyRole> getPolicyRoles()
  {
    if (policyRoles == null) {
      policyRoles = new SdkInternalList();
    }
    return policyRoles;
  }
  
  public void setPolicyRoles(Collection<PolicyRole> policyRoles)
  {
    if (policyRoles == null)
    {
      this.policyRoles = null;
      return;
    }
    this.policyRoles = new SdkInternalList(policyRoles);
  }
  
  public ListEntitiesForPolicyResult withPolicyRoles(PolicyRole... policyRoles)
  {
    if (this.policyRoles == null) {
      setPolicyRoles(new SdkInternalList(policyRoles.length));
    }
    for (PolicyRole ele : policyRoles) {
      this.policyRoles.add(ele);
    }
    return this;
  }
  
  public ListEntitiesForPolicyResult withPolicyRoles(Collection<PolicyRole> policyRoles)
  {
    setPolicyRoles(policyRoles);
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
  
  public ListEntitiesForPolicyResult withIsTruncated(Boolean isTruncated)
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
  
  public ListEntitiesForPolicyResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyGroups() != null) {
      sb.append("PolicyGroups: ").append(getPolicyGroups()).append(",");
    }
    if (getPolicyUsers() != null) {
      sb.append("PolicyUsers: ").append(getPolicyUsers()).append(",");
    }
    if (getPolicyRoles() != null) {
      sb.append("PolicyRoles: ").append(getPolicyRoles()).append(",");
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
    if (!(obj instanceof ListEntitiesForPolicyResult)) {
      return false;
    }
    ListEntitiesForPolicyResult other = (ListEntitiesForPolicyResult)obj;
    if (((other.getPolicyGroups() == null ? 1 : 0) ^ (getPolicyGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyGroups() != null) && (!other.getPolicyGroups().equals(getPolicyGroups()))) {
      return false;
    }
    if (((other.getPolicyUsers() == null ? 1 : 0) ^ (getPolicyUsers() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyUsers() != null) && (!other.getPolicyUsers().equals(getPolicyUsers()))) {
      return false;
    }
    if (((other.getPolicyRoles() == null ? 1 : 0) ^ (getPolicyRoles() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyRoles() != null) && (!other.getPolicyRoles().equals(getPolicyRoles()))) {
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
    
    hashCode = 31 * hashCode + (getPolicyGroups() == null ? 0 : getPolicyGroups().hashCode());
    hashCode = 31 * hashCode + (getPolicyUsers() == null ? 0 : getPolicyUsers().hashCode());
    hashCode = 31 * hashCode + (getPolicyRoles() == null ? 0 : getPolicyRoles().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListEntitiesForPolicyResult clone()
  {
    try
    {
      return (ListEntitiesForPolicyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */