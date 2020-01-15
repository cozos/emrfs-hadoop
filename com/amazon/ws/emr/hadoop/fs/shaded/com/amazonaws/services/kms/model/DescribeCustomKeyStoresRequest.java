package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeCustomKeyStoresRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String customKeyStoreId;
  private String customKeyStoreName;
  private Integer limit;
  private String marker;
  
  public void setCustomKeyStoreId(String customKeyStoreId)
  {
    this.customKeyStoreId = customKeyStoreId;
  }
  
  public String getCustomKeyStoreId()
  {
    return customKeyStoreId;
  }
  
  public DescribeCustomKeyStoresRequest withCustomKeyStoreId(String customKeyStoreId)
  {
    setCustomKeyStoreId(customKeyStoreId);
    return this;
  }
  
  public void setCustomKeyStoreName(String customKeyStoreName)
  {
    this.customKeyStoreName = customKeyStoreName;
  }
  
  public String getCustomKeyStoreName()
  {
    return customKeyStoreName;
  }
  
  public DescribeCustomKeyStoresRequest withCustomKeyStoreName(String customKeyStoreName)
  {
    setCustomKeyStoreName(customKeyStoreName);
    return this;
  }
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public DescribeCustomKeyStoresRequest withLimit(Integer limit)
  {
    setLimit(limit);
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
  
  public DescribeCustomKeyStoresRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCustomKeyStoreId() != null) {
      sb.append("CustomKeyStoreId: ").append(getCustomKeyStoreId()).append(",");
    }
    if (getCustomKeyStoreName() != null) {
      sb.append("CustomKeyStoreName: ").append(getCustomKeyStoreName()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
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
    if (!(obj instanceof DescribeCustomKeyStoresRequest)) {
      return false;
    }
    DescribeCustomKeyStoresRequest other = (DescribeCustomKeyStoresRequest)obj;
    if (((other.getCustomKeyStoreId() == null ? 1 : 0) ^ (getCustomKeyStoreId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreId() != null) && (!other.getCustomKeyStoreId().equals(getCustomKeyStoreId()))) {
      return false;
    }
    if (((other.getCustomKeyStoreName() == null ? 1 : 0) ^ (getCustomKeyStoreName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreName() != null) && (!other.getCustomKeyStoreName().equals(getCustomKeyStoreName()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
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
    
    hashCode = 31 * hashCode + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    hashCode = 31 * hashCode + (getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public DescribeCustomKeyStoresRequest clone()
  {
    return (DescribeCustomKeyStoresRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */