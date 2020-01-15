package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PortRangeMarshaller;
import java.io.Serializable;

public class PortRange
  implements Serializable, Cloneable, StructuredPojo
{
  private Integer minRange;
  private Integer maxRange;
  
  public void setMinRange(Integer minRange)
  {
    this.minRange = minRange;
  }
  
  public Integer getMinRange()
  {
    return minRange;
  }
  
  public PortRange withMinRange(Integer minRange)
  {
    setMinRange(minRange);
    return this;
  }
  
  public void setMaxRange(Integer maxRange)
  {
    this.maxRange = maxRange;
  }
  
  public Integer getMaxRange()
  {
    return maxRange;
  }
  
  public PortRange withMaxRange(Integer maxRange)
  {
    setMaxRange(maxRange);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMinRange() != null) {
      sb.append("MinRange: ").append(getMinRange()).append(",");
    }
    if (getMaxRange() != null) {
      sb.append("MaxRange: ").append(getMaxRange());
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
    if (!(obj instanceof PortRange)) {
      return false;
    }
    PortRange other = (PortRange)obj;
    if (((other.getMinRange() == null ? 1 : 0) ^ (getMinRange() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMinRange() != null) && (!other.getMinRange().equals(getMinRange()))) {
      return false;
    }
    if (((other.getMaxRange() == null ? 1 : 0) ^ (getMaxRange() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxRange() != null) && (!other.getMaxRange().equals(getMaxRange()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMinRange() == null ? 0 : getMinRange().hashCode());
    hashCode = 31 * hashCode + (getMaxRange() == null ? 0 : getMaxRange().hashCode());
    return hashCode;
  }
  
  public PortRange clone()
  {
    try
    {
      return (PortRange)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    PortRangeMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PortRange
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */