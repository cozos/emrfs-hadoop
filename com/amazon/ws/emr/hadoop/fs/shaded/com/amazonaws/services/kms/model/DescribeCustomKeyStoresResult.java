package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeCustomKeyStoresResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<CustomKeyStoresListEntry> customKeyStores;
  private String nextMarker;
  private Boolean truncated;
  
  public List<CustomKeyStoresListEntry> getCustomKeyStores()
  {
    if (customKeyStores == null) {
      customKeyStores = new SdkInternalList();
    }
    return customKeyStores;
  }
  
  public void setCustomKeyStores(Collection<CustomKeyStoresListEntry> customKeyStores)
  {
    if (customKeyStores == null)
    {
      this.customKeyStores = null;
      return;
    }
    this.customKeyStores = new SdkInternalList(customKeyStores);
  }
  
  public DescribeCustomKeyStoresResult withCustomKeyStores(CustomKeyStoresListEntry... customKeyStores)
  {
    if (this.customKeyStores == null) {
      setCustomKeyStores(new SdkInternalList(customKeyStores.length));
    }
    for (CustomKeyStoresListEntry ele : customKeyStores) {
      this.customKeyStores.add(ele);
    }
    return this;
  }
  
  public DescribeCustomKeyStoresResult withCustomKeyStores(Collection<CustomKeyStoresListEntry> customKeyStores)
  {
    setCustomKeyStores(customKeyStores);
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
  
  public DescribeCustomKeyStoresResult withNextMarker(String nextMarker)
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
  
  public DescribeCustomKeyStoresResult withTruncated(Boolean truncated)
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
    if (getCustomKeyStores() != null) {
      sb.append("CustomKeyStores: ").append(getCustomKeyStores()).append(",");
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
    if (!(obj instanceof DescribeCustomKeyStoresResult)) {
      return false;
    }
    DescribeCustomKeyStoresResult other = (DescribeCustomKeyStoresResult)obj;
    if (((other.getCustomKeyStores() == null ? 1 : 0) ^ (getCustomKeyStores() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStores() != null) && (!other.getCustomKeyStores().equals(getCustomKeyStores()))) {
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
    
    hashCode = 31 * hashCode + (getCustomKeyStores() == null ? 0 : getCustomKeyStores().hashCode());
    hashCode = 31 * hashCode + (getNextMarker() == null ? 0 : getNextMarker().hashCode());
    hashCode = 31 * hashCode + (getTruncated() == null ? 0 : getTruncated().hashCode());
    return hashCode;
  }
  
  public DescribeCustomKeyStoresResult clone()
  {
    try
    {
      return (DescribeCustomKeyStoresResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */