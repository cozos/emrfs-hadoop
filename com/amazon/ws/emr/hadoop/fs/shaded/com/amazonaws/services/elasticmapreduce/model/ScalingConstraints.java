package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingConstraintsMarshaller;
import java.io.Serializable;

public class ScalingConstraints
  implements Serializable, Cloneable, StructuredPojo
{
  private Integer minCapacity;
  private Integer maxCapacity;
  
  public void setMinCapacity(Integer minCapacity)
  {
    this.minCapacity = minCapacity;
  }
  
  public Integer getMinCapacity()
  {
    return minCapacity;
  }
  
  public ScalingConstraints withMinCapacity(Integer minCapacity)
  {
    setMinCapacity(minCapacity);
    return this;
  }
  
  public void setMaxCapacity(Integer maxCapacity)
  {
    this.maxCapacity = maxCapacity;
  }
  
  public Integer getMaxCapacity()
  {
    return maxCapacity;
  }
  
  public ScalingConstraints withMaxCapacity(Integer maxCapacity)
  {
    setMaxCapacity(maxCapacity);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMinCapacity() != null) {
      sb.append("MinCapacity: ").append(getMinCapacity()).append(",");
    }
    if (getMaxCapacity() != null) {
      sb.append("MaxCapacity: ").append(getMaxCapacity());
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
    if (!(obj instanceof ScalingConstraints)) {
      return false;
    }
    ScalingConstraints other = (ScalingConstraints)obj;
    if (((other.getMinCapacity() == null ? 1 : 0) ^ (getMinCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMinCapacity() != null) && (!other.getMinCapacity().equals(getMinCapacity()))) {
      return false;
    }
    if (((other.getMaxCapacity() == null ? 1 : 0) ^ (getMaxCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxCapacity() != null) && (!other.getMaxCapacity().equals(getMaxCapacity()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMinCapacity() == null ? 0 : getMinCapacity().hashCode());
    hashCode = 31 * hashCode + (getMaxCapacity() == null ? 0 : getMaxCapacity().hashCode());
    return hashCode;
  }
  
  public ScalingConstraints clone()
  {
    try
    {
      return (ScalingConstraints)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ScalingConstraintsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingConstraints
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */