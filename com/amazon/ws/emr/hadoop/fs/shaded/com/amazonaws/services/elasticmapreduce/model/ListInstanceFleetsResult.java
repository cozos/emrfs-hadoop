package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListInstanceFleetsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<InstanceFleet> instanceFleets;
  private String marker;
  
  public List<InstanceFleet> getInstanceFleets()
  {
    if (instanceFleets == null) {
      instanceFleets = new SdkInternalList();
    }
    return instanceFleets;
  }
  
  public void setInstanceFleets(Collection<InstanceFleet> instanceFleets)
  {
    if (instanceFleets == null)
    {
      this.instanceFleets = null;
      return;
    }
    this.instanceFleets = new SdkInternalList(instanceFleets);
  }
  
  public ListInstanceFleetsResult withInstanceFleets(InstanceFleet... instanceFleets)
  {
    if (this.instanceFleets == null) {
      setInstanceFleets(new SdkInternalList(instanceFleets.length));
    }
    for (InstanceFleet ele : instanceFleets) {
      this.instanceFleets.add(ele);
    }
    return this;
  }
  
  public ListInstanceFleetsResult withInstanceFleets(Collection<InstanceFleet> instanceFleets)
  {
    setInstanceFleets(instanceFleets);
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
  
  public ListInstanceFleetsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceFleets() != null) {
      sb.append("InstanceFleets: ").append(getInstanceFleets()).append(",");
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
    if (!(obj instanceof ListInstanceFleetsResult)) {
      return false;
    }
    ListInstanceFleetsResult other = (ListInstanceFleetsResult)obj;
    if (((other.getInstanceFleets() == null ? 1 : 0) ^ (getInstanceFleets() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleets() != null) && (!other.getInstanceFleets().equals(getInstanceFleets()))) {
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
    
    hashCode = 31 * hashCode + (getInstanceFleets() == null ? 0 : getInstanceFleets().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public ListInstanceFleetsResult clone()
  {
    try
    {
      return (ListInstanceFleetsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceFleetsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */