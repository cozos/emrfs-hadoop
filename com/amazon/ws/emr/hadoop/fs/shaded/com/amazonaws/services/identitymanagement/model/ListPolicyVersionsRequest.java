package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListPolicyVersionsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policyArn;
  private String marker;
  private Integer maxItems;
  
  public void setPolicyArn(String policyArn)
  {
    this.policyArn = policyArn;
  }
  
  public String getPolicyArn()
  {
    return policyArn;
  }
  
  public ListPolicyVersionsRequest withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
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
  
  public ListPolicyVersionsRequest withMarker(String marker)
  {
    setMarker(marker);
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
  
  public ListPolicyVersionsRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyArn() != null) {
      sb.append("PolicyArn: ").append(getPolicyArn()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems());
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
    if (!(obj instanceof ListPolicyVersionsRequest)) {
      return false;
    }
    ListPolicyVersionsRequest other = (ListPolicyVersionsRequest)obj;
    if (((other.getPolicyArn() == null ? 1 : 0) ^ (getPolicyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArn() != null) && (!other.getPolicyArn().equals(getPolicyArn()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    if (((other.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxItems() != null) && (!other.getMaxItems().equals(getMaxItems()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    return hashCode;
  }
  
  public ListPolicyVersionsRequest clone()
  {
    return (ListPolicyVersionsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */