package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoverySpecificationMarshaller;
import java.io.Serializable;

public class PointInTimeRecoverySpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private Boolean pointInTimeRecoveryEnabled;
  
  public void setPointInTimeRecoveryEnabled(Boolean pointInTimeRecoveryEnabled)
  {
    this.pointInTimeRecoveryEnabled = pointInTimeRecoveryEnabled;
  }
  
  public Boolean getPointInTimeRecoveryEnabled()
  {
    return pointInTimeRecoveryEnabled;
  }
  
  public PointInTimeRecoverySpecification withPointInTimeRecoveryEnabled(Boolean pointInTimeRecoveryEnabled)
  {
    setPointInTimeRecoveryEnabled(pointInTimeRecoveryEnabled);
    return this;
  }
  
  public Boolean isPointInTimeRecoveryEnabled()
  {
    return pointInTimeRecoveryEnabled;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPointInTimeRecoveryEnabled() != null) {
      sb.append("PointInTimeRecoveryEnabled: ").append(getPointInTimeRecoveryEnabled());
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
    if (!(obj instanceof PointInTimeRecoverySpecification)) {
      return false;
    }
    PointInTimeRecoverySpecification other = (PointInTimeRecoverySpecification)obj;
    if (((other.getPointInTimeRecoveryEnabled() == null ? 1 : 0) ^ (getPointInTimeRecoveryEnabled() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPointInTimeRecoveryEnabled() != null) && (!other.getPointInTimeRecoveryEnabled().equals(getPointInTimeRecoveryEnabled()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPointInTimeRecoveryEnabled() == null ? 0 : getPointInTimeRecoveryEnabled().hashCode());
    return hashCode;
  }
  
  public PointInTimeRecoverySpecification clone()
  {
    try
    {
      return (PointInTimeRecoverySpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    PointInTimeRecoverySpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoverySpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */