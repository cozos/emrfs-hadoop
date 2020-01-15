package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListUserTagsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String userName;
  private String marker;
  private Integer maxItems;
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  public String getUserName()
  {
    return userName;
  }
  
  public ListUserTagsRequest withUserName(String userName)
  {
    setUserName(userName);
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
  
  public ListUserTagsRequest withMarker(String marker)
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
  
  public ListUserTagsRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUserName() != null) {
      sb.append("UserName: ").append(getUserName()).append(",");
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
    if (!(obj instanceof ListUserTagsRequest)) {
      return false;
    }
    ListUserTagsRequest other = (ListUserTagsRequest)obj;
    if (((other.getUserName() == null ? 1 : 0) ^ (getUserName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserName() != null) && (!other.getUserName().equals(getUserName()))) {
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
    
    hashCode = 31 * hashCode + (getUserName() == null ? 0 : getUserName().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    return hashCode;
  }
  
  public ListUserTagsRequest clone()
  {
    return (ListUserTagsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserTagsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */