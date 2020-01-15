package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListVirtualMFADevicesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String assignmentStatus;
  private String marker;
  private Integer maxItems;
  
  public void setAssignmentStatus(String assignmentStatus)
  {
    this.assignmentStatus = assignmentStatus;
  }
  
  public String getAssignmentStatus()
  {
    return assignmentStatus;
  }
  
  public ListVirtualMFADevicesRequest withAssignmentStatus(String assignmentStatus)
  {
    setAssignmentStatus(assignmentStatus);
    return this;
  }
  
  public void setAssignmentStatus(AssignmentStatusType assignmentStatus)
  {
    withAssignmentStatus(assignmentStatus);
  }
  
  public ListVirtualMFADevicesRequest withAssignmentStatus(AssignmentStatusType assignmentStatus)
  {
    this.assignmentStatus = assignmentStatus.toString();
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
  
  public ListVirtualMFADevicesRequest withMarker(String marker)
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
  
  public ListVirtualMFADevicesRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAssignmentStatus() != null) {
      sb.append("AssignmentStatus: ").append(getAssignmentStatus()).append(",");
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
    if (!(obj instanceof ListVirtualMFADevicesRequest)) {
      return false;
    }
    ListVirtualMFADevicesRequest other = (ListVirtualMFADevicesRequest)obj;
    if (((other.getAssignmentStatus() == null ? 1 : 0) ^ (getAssignmentStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAssignmentStatus() != null) && (!other.getAssignmentStatus().equals(getAssignmentStatus()))) {
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
    
    hashCode = 31 * hashCode + (getAssignmentStatus() == null ? 0 : getAssignmentStatus().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    return hashCode;
  }
  
  public ListVirtualMFADevicesRequest clone()
  {
    return (ListVirtualMFADevicesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListVirtualMFADevicesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */