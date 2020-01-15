package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetProvisioningSpecificationsMarshaller;
import java.io.Serializable;

public class InstanceFleetProvisioningSpecifications
  implements Serializable, Cloneable, StructuredPojo
{
  private SpotProvisioningSpecification spotSpecification;
  
  public void setSpotSpecification(SpotProvisioningSpecification spotSpecification)
  {
    this.spotSpecification = spotSpecification;
  }
  
  public SpotProvisioningSpecification getSpotSpecification()
  {
    return spotSpecification;
  }
  
  public InstanceFleetProvisioningSpecifications withSpotSpecification(SpotProvisioningSpecification spotSpecification)
  {
    setSpotSpecification(spotSpecification);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSpotSpecification() != null) {
      sb.append("SpotSpecification: ").append(getSpotSpecification());
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
    if (!(obj instanceof InstanceFleetProvisioningSpecifications)) {
      return false;
    }
    InstanceFleetProvisioningSpecifications other = (InstanceFleetProvisioningSpecifications)obj;
    if (((other.getSpotSpecification() == null ? 1 : 0) ^ (getSpotSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSpotSpecification() != null) && (!other.getSpotSpecification().equals(getSpotSpecification()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSpotSpecification() == null ? 0 : getSpotSpecification().hashCode());
    return hashCode;
  }
  
  public InstanceFleetProvisioningSpecifications clone()
  {
    try
    {
      return (InstanceFleetProvisioningSpecifications)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceFleetProvisioningSpecificationsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetProvisioningSpecifications
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */