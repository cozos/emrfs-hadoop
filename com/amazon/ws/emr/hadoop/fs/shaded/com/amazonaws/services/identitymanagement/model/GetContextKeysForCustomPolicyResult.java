package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetContextKeysForCustomPolicyResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<String> contextKeyNames;
  
  public List<String> getContextKeyNames()
  {
    if (contextKeyNames == null) {
      contextKeyNames = new SdkInternalList();
    }
    return contextKeyNames;
  }
  
  public void setContextKeyNames(Collection<String> contextKeyNames)
  {
    if (contextKeyNames == null)
    {
      this.contextKeyNames = null;
      return;
    }
    this.contextKeyNames = new SdkInternalList(contextKeyNames);
  }
  
  public GetContextKeysForCustomPolicyResult withContextKeyNames(String... contextKeyNames)
  {
    if (this.contextKeyNames == null) {
      setContextKeyNames(new SdkInternalList(contextKeyNames.length));
    }
    for (String ele : contextKeyNames) {
      this.contextKeyNames.add(ele);
    }
    return this;
  }
  
  public GetContextKeysForCustomPolicyResult withContextKeyNames(Collection<String> contextKeyNames)
  {
    setContextKeyNames(contextKeyNames);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getContextKeyNames() != null) {
      sb.append("ContextKeyNames: ").append(getContextKeyNames());
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
    if (!(obj instanceof GetContextKeysForCustomPolicyResult)) {
      return false;
    }
    GetContextKeysForCustomPolicyResult other = (GetContextKeysForCustomPolicyResult)obj;
    if (((other.getContextKeyNames() == null ? 1 : 0) ^ (getContextKeyNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContextKeyNames() != null) && (!other.getContextKeyNames().equals(getContextKeyNames()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getContextKeyNames() == null ? 0 : getContextKeyNames().hashCode());
    return hashCode;
  }
  
  public GetContextKeysForCustomPolicyResult clone()
  {
    try
    {
      return (GetContextKeysForCustomPolicyResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */