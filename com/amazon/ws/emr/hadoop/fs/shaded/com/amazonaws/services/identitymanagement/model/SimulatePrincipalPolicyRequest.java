package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class SimulatePrincipalPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policySourceArn;
  private SdkInternalList<String> policyInputList;
  private SdkInternalList<String> actionNames;
  private SdkInternalList<String> resourceArns;
  private String resourcePolicy;
  private String resourceOwner;
  private String callerArn;
  private SdkInternalList<ContextEntry> contextEntries;
  private String resourceHandlingOption;
  private Integer maxItems;
  private String marker;
  
  public void setPolicySourceArn(String policySourceArn)
  {
    this.policySourceArn = policySourceArn;
  }
  
  public String getPolicySourceArn()
  {
    return policySourceArn;
  }
  
  public SimulatePrincipalPolicyRequest withPolicySourceArn(String policySourceArn)
  {
    setPolicySourceArn(policySourceArn);
    return this;
  }
  
  public List<String> getPolicyInputList()
  {
    if (policyInputList == null) {
      policyInputList = new SdkInternalList();
    }
    return policyInputList;
  }
  
  public void setPolicyInputList(Collection<String> policyInputList)
  {
    if (policyInputList == null)
    {
      this.policyInputList = null;
      return;
    }
    this.policyInputList = new SdkInternalList(policyInputList);
  }
  
  public SimulatePrincipalPolicyRequest withPolicyInputList(String... policyInputList)
  {
    if (this.policyInputList == null) {
      setPolicyInputList(new SdkInternalList(policyInputList.length));
    }
    for (String ele : policyInputList) {
      this.policyInputList.add(ele);
    }
    return this;
  }
  
  public SimulatePrincipalPolicyRequest withPolicyInputList(Collection<String> policyInputList)
  {
    setPolicyInputList(policyInputList);
    return this;
  }
  
  public List<String> getActionNames()
  {
    if (actionNames == null) {
      actionNames = new SdkInternalList();
    }
    return actionNames;
  }
  
  public void setActionNames(Collection<String> actionNames)
  {
    if (actionNames == null)
    {
      this.actionNames = null;
      return;
    }
    this.actionNames = new SdkInternalList(actionNames);
  }
  
  public SimulatePrincipalPolicyRequest withActionNames(String... actionNames)
  {
    if (this.actionNames == null) {
      setActionNames(new SdkInternalList(actionNames.length));
    }
    for (String ele : actionNames) {
      this.actionNames.add(ele);
    }
    return this;
  }
  
  public SimulatePrincipalPolicyRequest withActionNames(Collection<String> actionNames)
  {
    setActionNames(actionNames);
    return this;
  }
  
  public List<String> getResourceArns()
  {
    if (resourceArns == null) {
      resourceArns = new SdkInternalList();
    }
    return resourceArns;
  }
  
  public void setResourceArns(Collection<String> resourceArns)
  {
    if (resourceArns == null)
    {
      this.resourceArns = null;
      return;
    }
    this.resourceArns = new SdkInternalList(resourceArns);
  }
  
  public SimulatePrincipalPolicyRequest withResourceArns(String... resourceArns)
  {
    if (this.resourceArns == null) {
      setResourceArns(new SdkInternalList(resourceArns.length));
    }
    for (String ele : resourceArns) {
      this.resourceArns.add(ele);
    }
    return this;
  }
  
  public SimulatePrincipalPolicyRequest withResourceArns(Collection<String> resourceArns)
  {
    setResourceArns(resourceArns);
    return this;
  }
  
  public void setResourcePolicy(String resourcePolicy)
  {
    this.resourcePolicy = resourcePolicy;
  }
  
  public String getResourcePolicy()
  {
    return resourcePolicy;
  }
  
  public SimulatePrincipalPolicyRequest withResourcePolicy(String resourcePolicy)
  {
    setResourcePolicy(resourcePolicy);
    return this;
  }
  
  public void setResourceOwner(String resourceOwner)
  {
    this.resourceOwner = resourceOwner;
  }
  
  public String getResourceOwner()
  {
    return resourceOwner;
  }
  
  public SimulatePrincipalPolicyRequest withResourceOwner(String resourceOwner)
  {
    setResourceOwner(resourceOwner);
    return this;
  }
  
  public void setCallerArn(String callerArn)
  {
    this.callerArn = callerArn;
  }
  
  public String getCallerArn()
  {
    return callerArn;
  }
  
  public SimulatePrincipalPolicyRequest withCallerArn(String callerArn)
  {
    setCallerArn(callerArn);
    return this;
  }
  
  public List<ContextEntry> getContextEntries()
  {
    if (contextEntries == null) {
      contextEntries = new SdkInternalList();
    }
    return contextEntries;
  }
  
  public void setContextEntries(Collection<ContextEntry> contextEntries)
  {
    if (contextEntries == null)
    {
      this.contextEntries = null;
      return;
    }
    this.contextEntries = new SdkInternalList(contextEntries);
  }
  
  public SimulatePrincipalPolicyRequest withContextEntries(ContextEntry... contextEntries)
  {
    if (this.contextEntries == null) {
      setContextEntries(new SdkInternalList(contextEntries.length));
    }
    for (ContextEntry ele : contextEntries) {
      this.contextEntries.add(ele);
    }
    return this;
  }
  
  public SimulatePrincipalPolicyRequest withContextEntries(Collection<ContextEntry> contextEntries)
  {
    setContextEntries(contextEntries);
    return this;
  }
  
  public void setResourceHandlingOption(String resourceHandlingOption)
  {
    this.resourceHandlingOption = resourceHandlingOption;
  }
  
  public String getResourceHandlingOption()
  {
    return resourceHandlingOption;
  }
  
  public SimulatePrincipalPolicyRequest withResourceHandlingOption(String resourceHandlingOption)
  {
    setResourceHandlingOption(resourceHandlingOption);
    return this;
  }
  
  public void setMaxItems(Integer maxItems)
  {
    this.maxItems = maxItems;
  }
  
  public Integer getMaxItems()
  {
    return maxItems;
  }
  
  public SimulatePrincipalPolicyRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public SimulatePrincipalPolicyRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicySourceArn() != null) {
      sb.append("PolicySourceArn: ").append(getPolicySourceArn()).append(",");
    }
    if (getPolicyInputList() != null) {
      sb.append("PolicyInputList: ").append(getPolicyInputList()).append(",");
    }
    if (getActionNames() != null) {
      sb.append("ActionNames: ").append(getActionNames()).append(",");
    }
    if (getResourceArns() != null) {
      sb.append("ResourceArns: ").append(getResourceArns()).append(",");
    }
    if (getResourcePolicy() != null) {
      sb.append("ResourcePolicy: ").append(getResourcePolicy()).append(",");
    }
    if (getResourceOwner() != null) {
      sb.append("ResourceOwner: ").append(getResourceOwner()).append(",");
    }
    if (getCallerArn() != null) {
      sb.append("CallerArn: ").append(getCallerArn()).append(",");
    }
    if (getContextEntries() != null) {
      sb.append("ContextEntries: ").append(getContextEntries()).append(",");
    }
    if (getResourceHandlingOption() != null) {
      sb.append("ResourceHandlingOption: ").append(getResourceHandlingOption()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems()).append(",");
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
    if (!(obj instanceof SimulatePrincipalPolicyRequest)) {
      return false;
    }
    SimulatePrincipalPolicyRequest other = (SimulatePrincipalPolicyRequest)obj;
    if (((other.getPolicySourceArn() == null ? 1 : 0) ^ (getPolicySourceArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicySourceArn() != null) && (!other.getPolicySourceArn().equals(getPolicySourceArn()))) {
      return false;
    }
    if (((other.getPolicyInputList() == null ? 1 : 0) ^ (getPolicyInputList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyInputList() != null) && (!other.getPolicyInputList().equals(getPolicyInputList()))) {
      return false;
    }
    if (((other.getActionNames() == null ? 1 : 0) ^ (getActionNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getActionNames() != null) && (!other.getActionNames().equals(getActionNames()))) {
      return false;
    }
    if (((other.getResourceArns() == null ? 1 : 0) ^ (getResourceArns() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceArns() != null) && (!other.getResourceArns().equals(getResourceArns()))) {
      return false;
    }
    if (((other.getResourcePolicy() == null ? 1 : 0) ^ (getResourcePolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourcePolicy() != null) && (!other.getResourcePolicy().equals(getResourcePolicy()))) {
      return false;
    }
    if (((other.getResourceOwner() == null ? 1 : 0) ^ (getResourceOwner() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceOwner() != null) && (!other.getResourceOwner().equals(getResourceOwner()))) {
      return false;
    }
    if (((other.getCallerArn() == null ? 1 : 0) ^ (getCallerArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCallerArn() != null) && (!other.getCallerArn().equals(getCallerArn()))) {
      return false;
    }
    if (((other.getContextEntries() == null ? 1 : 0) ^ (getContextEntries() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContextEntries() != null) && (!other.getContextEntries().equals(getContextEntries()))) {
      return false;
    }
    if (((other.getResourceHandlingOption() == null ? 1 : 0) ^ (getResourceHandlingOption() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceHandlingOption() != null) && (!other.getResourceHandlingOption().equals(getResourceHandlingOption()))) {
      return false;
    }
    if (((other.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxItems() != null) && (!other.getMaxItems().equals(getMaxItems()))) {
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
    
    hashCode = 31 * hashCode + (getPolicySourceArn() == null ? 0 : getPolicySourceArn().hashCode());
    hashCode = 31 * hashCode + (getPolicyInputList() == null ? 0 : getPolicyInputList().hashCode());
    hashCode = 31 * hashCode + (getActionNames() == null ? 0 : getActionNames().hashCode());
    hashCode = 31 * hashCode + (getResourceArns() == null ? 0 : getResourceArns().hashCode());
    hashCode = 31 * hashCode + (getResourcePolicy() == null ? 0 : getResourcePolicy().hashCode());
    hashCode = 31 * hashCode + (getResourceOwner() == null ? 0 : getResourceOwner().hashCode());
    hashCode = 31 * hashCode + (getCallerArn() == null ? 0 : getCallerArn().hashCode());
    hashCode = 31 * hashCode + (getContextEntries() == null ? 0 : getContextEntries().hashCode());
    hashCode = 31 * hashCode + (getResourceHandlingOption() == null ? 0 : getResourceHandlingOption().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public SimulatePrincipalPolicyRequest clone()
  {
    return (SimulatePrincipalPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */