package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListAliasesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<AliasListEntry> aliases;
  private String nextMarker;
  private Boolean truncated;
  
  public List<AliasListEntry> getAliases()
  {
    if (aliases == null) {
      aliases = new SdkInternalList();
    }
    return aliases;
  }
  
  public void setAliases(Collection<AliasListEntry> aliases)
  {
    if (aliases == null)
    {
      this.aliases = null;
      return;
    }
    this.aliases = new SdkInternalList(aliases);
  }
  
  public ListAliasesResult withAliases(AliasListEntry... aliases)
  {
    if (this.aliases == null) {
      setAliases(new SdkInternalList(aliases.length));
    }
    for (AliasListEntry ele : aliases) {
      this.aliases.add(ele);
    }
    return this;
  }
  
  public ListAliasesResult withAliases(Collection<AliasListEntry> aliases)
  {
    setAliases(aliases);
    return this;
  }
  
  public void setNextMarker(String nextMarker)
  {
    this.nextMarker = nextMarker;
  }
  
  public String getNextMarker()
  {
    return nextMarker;
  }
  
  public ListAliasesResult withNextMarker(String nextMarker)
  {
    setNextMarker(nextMarker);
    return this;
  }
  
  public void setTruncated(Boolean truncated)
  {
    this.truncated = truncated;
  }
  
  public Boolean getTruncated()
  {
    return truncated;
  }
  
  public ListAliasesResult withTruncated(Boolean truncated)
  {
    setTruncated(truncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return truncated;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAliases() != null) {
      sb.append("Aliases: ").append(getAliases()).append(",");
    }
    if (getNextMarker() != null) {
      sb.append("NextMarker: ").append(getNextMarker()).append(",");
    }
    if (getTruncated() != null) {
      sb.append("Truncated: ").append(getTruncated());
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
    if (!(obj instanceof ListAliasesResult)) {
      return false;
    }
    ListAliasesResult other = (ListAliasesResult)obj;
    if (((other.getAliases() == null ? 1 : 0) ^ (getAliases() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAliases() != null) && (!other.getAliases().equals(getAliases()))) {
      return false;
    }
    if (((other.getNextMarker() == null ? 1 : 0) ^ (getNextMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextMarker() != null) && (!other.getNextMarker().equals(getNextMarker()))) {
      return false;
    }
    if (((other.getTruncated() == null ? 1 : 0) ^ (getTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTruncated() != null) && (!other.getTruncated().equals(getTruncated()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAliases() == null ? 0 : getAliases().hashCode());
    hashCode = 31 * hashCode + (getNextMarker() == null ? 0 : getNextMarker().hashCode());
    hashCode = 31 * hashCode + (getTruncated() == null ? 0 : getTruncated().hashCode());
    return hashCode;
  }
  
  public ListAliasesResult clone()
  {
    try
    {
      return (ListAliasesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListAliasesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */