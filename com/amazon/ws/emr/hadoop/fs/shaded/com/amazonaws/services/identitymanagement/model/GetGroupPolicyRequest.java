package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetGroupPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String groupName;
  private String policyName;
  
  public GetGroupPolicyRequest() {}
  
  public GetGroupPolicyRequest(String groupName, String policyName)
  {
    setGroupName(groupName);
    setPolicyName(policyName);
  }
  
  public void setGroupName(String groupName)
  {
    this.groupName = groupName;
  }
  
  public String getGroupName()
  {
    return groupName;
  }
  
  public GetGroupPolicyRequest withGroupName(String groupName)
  {
    setGroupName(groupName);
    return this;
  }
  
  public void setPolicyName(String policyName)
  {
    this.policyName = policyName;
  }
  
  public String getPolicyName()
  {
    return policyName;
  }
  
  public GetGroupPolicyRequest withPolicyName(String policyName)
  {
    setPolicyName(policyName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGroupName() != null) {
      sb.append("GroupName: ").append(getGroupName()).append(",");
    }
    if (getPolicyName() != null) {
      sb.append("PolicyName: ").append(getPolicyName());
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
    if (!(obj instanceof GetGroupPolicyRequest)) {
      return false;
    }
    GetGroupPolicyRequest other = (GetGroupPolicyRequest)obj;
    if (((other.getGroupName() == null ? 1 : 0) ^ (getGroupName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGroupName() != null) && (!other.getGroupName().equals(getGroupName()))) {
      return false;
    }
    if (((other.getPolicyName() == null ? 1 : 0) ^ (getPolicyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyName() != null) && (!other.getPolicyName().equals(getPolicyName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGroupName() == null ? 0 : getGroupName().hashCode());
    hashCode = 31 * hashCode + (getPolicyName() == null ? 0 : getPolicyName().hashCode());
    return hashCode;
  }
  
  public GetGroupPolicyRequest clone()
  {
    return (GetGroupPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */