package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListSAMLProvidersResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<SAMLProviderListEntry> sAMLProviderList;
  
  public List<SAMLProviderListEntry> getSAMLProviderList()
  {
    if (sAMLProviderList == null) {
      sAMLProviderList = new SdkInternalList();
    }
    return sAMLProviderList;
  }
  
  public void setSAMLProviderList(Collection<SAMLProviderListEntry> sAMLProviderList)
  {
    if (sAMLProviderList == null)
    {
      this.sAMLProviderList = null;
      return;
    }
    this.sAMLProviderList = new SdkInternalList(sAMLProviderList);
  }
  
  public ListSAMLProvidersResult withSAMLProviderList(SAMLProviderListEntry... sAMLProviderList)
  {
    if (this.sAMLProviderList == null) {
      setSAMLProviderList(new SdkInternalList(sAMLProviderList.length));
    }
    for (SAMLProviderListEntry ele : sAMLProviderList) {
      this.sAMLProviderList.add(ele);
    }
    return this;
  }
  
  public ListSAMLProvidersResult withSAMLProviderList(Collection<SAMLProviderListEntry> sAMLProviderList)
  {
    setSAMLProviderList(sAMLProviderList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSAMLProviderList() != null) {
      sb.append("SAMLProviderList: ").append(getSAMLProviderList());
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
    if (!(obj instanceof ListSAMLProvidersResult)) {
      return false;
    }
    ListSAMLProvidersResult other = (ListSAMLProvidersResult)obj;
    if (((other.getSAMLProviderList() == null ? 1 : 0) ^ (getSAMLProviderList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSAMLProviderList() != null) && (!other.getSAMLProviderList().equals(getSAMLProviderList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSAMLProviderList() == null ? 0 : getSAMLProviderList().hashCode());
    return hashCode;
  }
  
  public ListSAMLProvidersResult clone()
  {
    try
    {
      return (ListSAMLProvidersResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */