package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PlacementTypeMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class PlacementType
  implements Serializable, Cloneable, StructuredPojo
{
  private String availabilityZone;
  private SdkInternalList<String> availabilityZones;
  
  public PlacementType() {}
  
  public PlacementType(String availabilityZone)
  {
    setAvailabilityZone(availabilityZone);
  }
  
  public void setAvailabilityZone(String availabilityZone)
  {
    this.availabilityZone = availabilityZone;
  }
  
  public String getAvailabilityZone()
  {
    return availabilityZone;
  }
  
  public PlacementType withAvailabilityZone(String availabilityZone)
  {
    setAvailabilityZone(availabilityZone);
    return this;
  }
  
  public List<String> getAvailabilityZones()
  {
    if (availabilityZones == null) {
      availabilityZones = new SdkInternalList();
    }
    return availabilityZones;
  }
  
  public void setAvailabilityZones(Collection<String> availabilityZones)
  {
    if (availabilityZones == null)
    {
      this.availabilityZones = null;
      return;
    }
    this.availabilityZones = new SdkInternalList(availabilityZones);
  }
  
  public PlacementType withAvailabilityZones(String... availabilityZones)
  {
    if (this.availabilityZones == null) {
      setAvailabilityZones(new SdkInternalList(availabilityZones.length));
    }
    for (String ele : availabilityZones) {
      this.availabilityZones.add(ele);
    }
    return this;
  }
  
  public PlacementType withAvailabilityZones(Collection<String> availabilityZones)
  {
    setAvailabilityZones(availabilityZones);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAvailabilityZone() != null) {
      sb.append("AvailabilityZone: ").append(getAvailabilityZone()).append(",");
    }
    if (getAvailabilityZones() != null) {
      sb.append("AvailabilityZones: ").append(getAvailabilityZones());
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
    if (!(obj instanceof PlacementType)) {
      return false;
    }
    PlacementType other = (PlacementType)obj;
    if (((other.getAvailabilityZone() == null ? 1 : 0) ^ (getAvailabilityZone() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAvailabilityZone() != null) && (!other.getAvailabilityZone().equals(getAvailabilityZone()))) {
      return false;
    }
    if (((other.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAvailabilityZones() != null) && (!other.getAvailabilityZones().equals(getAvailabilityZones()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAvailabilityZone() == null ? 0 : getAvailabilityZone().hashCode());
    hashCode = 31 * hashCode + (getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode());
    return hashCode;
  }
  
  public PlacementType clone()
  {
    try
    {
      return (PlacementType)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    PlacementTypeMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PlacementType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */