package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListAccountAliasesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<String> accountAliases;
  private Boolean isTruncated;
  private String marker;
  
  public List<String> getAccountAliases()
  {
    if (accountAliases == null) {
      accountAliases = new SdkInternalList();
    }
    return accountAliases;
  }
  
  public void setAccountAliases(Collection<String> accountAliases)
  {
    if (accountAliases == null)
    {
      this.accountAliases = null;
      return;
    }
    this.accountAliases = new SdkInternalList(accountAliases);
  }
  
  public ListAccountAliasesResult withAccountAliases(String... accountAliases)
  {
    if (this.accountAliases == null) {
      setAccountAliases(new SdkInternalList(accountAliases.length));
    }
    for (String ele : accountAliases) {
      this.accountAliases.add(ele);
    }
    return this;
  }
  
  public ListAccountAliasesResult withAccountAliases(Collection<String> accountAliases)
  {
    setAccountAliases(accountAliases);
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
  
  public ListAccountAliasesResult withIsTruncated(Boolean isTruncated)
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
  
  public ListAccountAliasesResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccountAliases() != null) {
      sb.append("AccountAliases: ").append(getAccountAliases()).append(",");
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
    if (!(obj instanceof ListAccountAliasesResult)) {
      return false;
    }
    ListAccountAliasesResult other = (ListAccountAliasesResult)obj;
    if (((other.getAccountAliases() == null ? 1 : 0) ^ (getAccountAliases() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccountAliases() != null) && (!other.getAccountAliases().equals(getAccountAliases()))) {
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
    
    hashCode = 31 * hashCode + (getAccountAliases() == null ? 0 : getAccountAliases().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListAccountAliasesResult clone()
  {
    try
    {
      return (ListAccountAliasesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAccountAliasesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */