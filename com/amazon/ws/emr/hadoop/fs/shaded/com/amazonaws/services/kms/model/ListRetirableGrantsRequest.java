package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListRetirableGrantsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Integer limit;
  private String marker;
  private String retiringPrincipal;
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public ListRetirableGrantsRequest withLimit(Integer limit)
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
  
  public ListRetirableGrantsRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setRetiringPrincipal(String retiringPrincipal)
  {
    this.retiringPrincipal = retiringPrincipal;
  }
  
  public String getRetiringPrincipal()
  {
    return retiringPrincipal;
  }
  
  public ListRetirableGrantsRequest withRetiringPrincipal(String retiringPrincipal)
  {
    setRetiringPrincipal(retiringPrincipal);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getRetiringPrincipal() != null) {
      sb.append("RetiringPrincipal: ").append(getRetiringPrincipal());
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
    if (!(obj instanceof ListRetirableGrantsRequest)) {
      return false;
    }
    ListRetirableGrantsRequest other = (ListRetirableGrantsRequest)obj;
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
    if (((other.getRetiringPrincipal() == null ? 1 : 0) ^ (getRetiringPrincipal() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRetiringPrincipal() != null) && (!other.getRetiringPrincipal().equals(getRetiringPrincipal()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getRetiringPrincipal() == null ? 0 : getRetiringPrincipal().hashCode());
    return hashCode;
  }
  
  public ListRetirableGrantsRequest clone()
  {
    return (ListRetirableGrantsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */