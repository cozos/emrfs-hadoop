package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListOpenIDConnectProvidersResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<OpenIDConnectProviderListEntry> openIDConnectProviderList;
  
  public List<OpenIDConnectProviderListEntry> getOpenIDConnectProviderList()
  {
    if (openIDConnectProviderList == null) {
      openIDConnectProviderList = new SdkInternalList();
    }
    return openIDConnectProviderList;
  }
  
  public void setOpenIDConnectProviderList(Collection<OpenIDConnectProviderListEntry> openIDConnectProviderList)
  {
    if (openIDConnectProviderList == null)
    {
      this.openIDConnectProviderList = null;
      return;
    }
    this.openIDConnectProviderList = new SdkInternalList(openIDConnectProviderList);
  }
  
  public ListOpenIDConnectProvidersResult withOpenIDConnectProviderList(OpenIDConnectProviderListEntry... openIDConnectProviderList)
  {
    if (this.openIDConnectProviderList == null) {
      setOpenIDConnectProviderList(new SdkInternalList(openIDConnectProviderList.length));
    }
    for (OpenIDConnectProviderListEntry ele : openIDConnectProviderList) {
      this.openIDConnectProviderList.add(ele);
    }
    return this;
  }
  
  public ListOpenIDConnectProvidersResult withOpenIDConnectProviderList(Collection<OpenIDConnectProviderListEntry> openIDConnectProviderList)
  {
    setOpenIDConnectProviderList(openIDConnectProviderList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getOpenIDConnectProviderList() != null) {
      sb.append("OpenIDConnectProviderList: ").append(getOpenIDConnectProviderList());
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
    if (!(obj instanceof ListOpenIDConnectProvidersResult)) {
      return false;
    }
    ListOpenIDConnectProvidersResult other = (ListOpenIDConnectProvidersResult)obj;
    if (((other.getOpenIDConnectProviderList() == null ? 1 : 0) ^ (getOpenIDConnectProviderList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOpenIDConnectProviderList() != null) && (!other.getOpenIDConnectProviderList().equals(getOpenIDConnectProviderList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getOpenIDConnectProviderList() == null ? 0 : getOpenIDConnectProviderList().hashCode());
    return hashCode;
  }
  
  public ListOpenIDConnectProvidersResult clone()
  {
    try
    {
      return (ListOpenIDConnectProvidersResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListOpenIDConnectProvidersResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */