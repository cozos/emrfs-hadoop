package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupDetailMarshaller;
import java.io.Serializable;
import java.util.Date;

public class InstanceGroupDetail
  implements Serializable, Cloneable, StructuredPojo
{
  private String instanceGroupId;
  private String name;
  private String market;
  private String instanceRole;
  private String bidPrice;
  private String instanceType;
  private Integer instanceRequestCount;
  private Integer instanceRunningCount;
  private String state;
  private String lastStateChangeReason;
  private Date creationDateTime;
  private Date startDateTime;
  private Date readyDateTime;
  private Date endDateTime;
  
  public InstanceGroupDetail() {}
  
  public InstanceGroupDetail(String instanceRole, String instanceType, Integer instanceRequestCount, Integer instanceRunningCount, String state, Date creationDateTime)
  {
    setInstanceRole(instanceRole);
    setInstanceType(instanceType);
    setInstanceRequestCount(instanceRequestCount);
    setInstanceRunningCount(instanceRunningCount);
    setState(state);
    setCreationDateTime(creationDateTime);
  }
  
  public InstanceGroupDetail(InstanceRoleType instanceRole, String instanceType, Integer instanceRequestCount, Integer instanceRunningCount, InstanceGroupState state, Date creationDateTime)
  {
    setInstanceRole(instanceRole.toString());
    setInstanceType(instanceType);
    setInstanceRequestCount(instanceRequestCount);
    setInstanceRunningCount(instanceRunningCount);
    setState(state.toString());
    setCreationDateTime(creationDateTime);
  }
  
  public void setInstanceGroupId(String instanceGroupId)
  {
    this.instanceGroupId = instanceGroupId;
  }
  
  public String getInstanceGroupId()
  {
    return instanceGroupId;
  }
  
  public InstanceGroupDetail withInstanceGroupId(String instanceGroupId)
  {
    setInstanceGroupId(instanceGroupId);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public InstanceGroupDetail withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setMarket(String market)
  {
    this.market = market;
  }
  
  public String getMarket()
  {
    return market;
  }
  
  public InstanceGroupDetail withMarket(String market)
  {
    setMarket(market);
    return this;
  }
  
  public void setMarket(MarketType market)
  {
    withMarket(market);
  }
  
  public InstanceGroupDetail withMarket(MarketType market)
  {
    this.market = market.toString();
    return this;
  }
  
  public void setInstanceRole(String instanceRole)
  {
    this.instanceRole = instanceRole;
  }
  
  public String getInstanceRole()
  {
    return instanceRole;
  }
  
  public InstanceGroupDetail withInstanceRole(String instanceRole)
  {
    setInstanceRole(instanceRole);
    return this;
  }
  
  public void setInstanceRole(InstanceRoleType instanceRole)
  {
    withInstanceRole(instanceRole);
  }
  
  public InstanceGroupDetail withInstanceRole(InstanceRoleType instanceRole)
  {
    this.instanceRole = instanceRole.toString();
    return this;
  }
  
  public void setBidPrice(String bidPrice)
  {
    this.bidPrice = bidPrice;
  }
  
  public String getBidPrice()
  {
    return bidPrice;
  }
  
  public InstanceGroupDetail withBidPrice(String bidPrice)
  {
    setBidPrice(bidPrice);
    return this;
  }
  
  public void setInstanceType(String instanceType)
  {
    this.instanceType = instanceType;
  }
  
  public String getInstanceType()
  {
    return instanceType;
  }
  
  public InstanceGroupDetail withInstanceType(String instanceType)
  {
    setInstanceType(instanceType);
    return this;
  }
  
  public void setInstanceRequestCount(Integer instanceRequestCount)
  {
    this.instanceRequestCount = instanceRequestCount;
  }
  
  public Integer getInstanceRequestCount()
  {
    return instanceRequestCount;
  }
  
  public InstanceGroupDetail withInstanceRequestCount(Integer instanceRequestCount)
  {
    setInstanceRequestCount(instanceRequestCount);
    return this;
  }
  
  public void setInstanceRunningCount(Integer instanceRunningCount)
  {
    this.instanceRunningCount = instanceRunningCount;
  }
  
  public Integer getInstanceRunningCount()
  {
    return instanceRunningCount;
  }
  
  public InstanceGroupDetail withInstanceRunningCount(Integer instanceRunningCount)
  {
    setInstanceRunningCount(instanceRunningCount);
    return this;
  }
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getState()
  {
    return state;
  }
  
  public InstanceGroupDetail withState(String state)
  {
    setState(state);
    return this;
  }
  
  public void setState(InstanceGroupState state)
  {
    withState(state);
  }
  
  public InstanceGroupDetail withState(InstanceGroupState state)
  {
    this.state = state.toString();
    return this;
  }
  
  public void setLastStateChangeReason(String lastStateChangeReason)
  {
    this.lastStateChangeReason = lastStateChangeReason;
  }
  
  public String getLastStateChangeReason()
  {
    return lastStateChangeReason;
  }
  
  public InstanceGroupDetail withLastStateChangeReason(String lastStateChangeReason)
  {
    setLastStateChangeReason(lastStateChangeReason);
    return this;
  }
  
  public void setCreationDateTime(Date creationDateTime)
  {
    this.creationDateTime = creationDateTime;
  }
  
  public Date getCreationDateTime()
  {
    return creationDateTime;
  }
  
  public InstanceGroupDetail withCreationDateTime(Date creationDateTime)
  {
    setCreationDateTime(creationDateTime);
    return this;
  }
  
  public void setStartDateTime(Date startDateTime)
  {
    this.startDateTime = startDateTime;
  }
  
  public Date getStartDateTime()
  {
    return startDateTime;
  }
  
  public InstanceGroupDetail withStartDateTime(Date startDateTime)
  {
    setStartDateTime(startDateTime);
    return this;
  }
  
  public void setReadyDateTime(Date readyDateTime)
  {
    this.readyDateTime = readyDateTime;
  }
  
  public Date getReadyDateTime()
  {
    return readyDateTime;
  }
  
  public InstanceGroupDetail withReadyDateTime(Date readyDateTime)
  {
    setReadyDateTime(readyDateTime);
    return this;
  }
  
  public void setEndDateTime(Date endDateTime)
  {
    this.endDateTime = endDateTime;
  }
  
  public Date getEndDateTime()
  {
    return endDateTime;
  }
  
  public InstanceGroupDetail withEndDateTime(Date endDateTime)
  {
    setEndDateTime(endDateTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceGroupId() != null) {
      sb.append("InstanceGroupId: ").append(getInstanceGroupId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getMarket() != null) {
      sb.append("Market: ").append(getMarket()).append(",");
    }
    if (getInstanceRole() != null) {
      sb.append("InstanceRole: ").append(getInstanceRole()).append(",");
    }
    if (getBidPrice() != null) {
      sb.append("BidPrice: ").append(getBidPrice()).append(",");
    }
    if (getInstanceType() != null) {
      sb.append("InstanceType: ").append(getInstanceType()).append(",");
    }
    if (getInstanceRequestCount() != null) {
      sb.append("InstanceRequestCount: ").append(getInstanceRequestCount()).append(",");
    }
    if (getInstanceRunningCount() != null) {
      sb.append("InstanceRunningCount: ").append(getInstanceRunningCount()).append(",");
    }
    if (getState() != null) {
      sb.append("State: ").append(getState()).append(",");
    }
    if (getLastStateChangeReason() != null) {
      sb.append("LastStateChangeReason: ").append(getLastStateChangeReason()).append(",");
    }
    if (getCreationDateTime() != null) {
      sb.append("CreationDateTime: ").append(getCreationDateTime()).append(",");
    }
    if (getStartDateTime() != null) {
      sb.append("StartDateTime: ").append(getStartDateTime()).append(",");
    }
    if (getReadyDateTime() != null) {
      sb.append("ReadyDateTime: ").append(getReadyDateTime()).append(",");
    }
    if (getEndDateTime() != null) {
      sb.append("EndDateTime: ").append(getEndDateTime());
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
    if (!(obj instanceof InstanceGroupDetail)) {
      return false;
    }
    InstanceGroupDetail other = (InstanceGroupDetail)obj;
    if (((other.getInstanceGroupId() == null ? 1 : 0) ^ (getInstanceGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupId() != null) && (!other.getInstanceGroupId().equals(getInstanceGroupId()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getMarket() == null ? 1 : 0) ^ (getMarket() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarket() != null) && (!other.getMarket().equals(getMarket()))) {
      return false;
    }
    if (((other.getInstanceRole() == null ? 1 : 0) ^ (getInstanceRole() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceRole() != null) && (!other.getInstanceRole().equals(getInstanceRole()))) {
      return false;
    }
    if (((other.getBidPrice() == null ? 1 : 0) ^ (getBidPrice() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBidPrice() != null) && (!other.getBidPrice().equals(getBidPrice()))) {
      return false;
    }
    if (((other.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceType() != null) && (!other.getInstanceType().equals(getInstanceType()))) {
      return false;
    }
    if (((other.getInstanceRequestCount() == null ? 1 : 0) ^ (getInstanceRequestCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceRequestCount() != null) && (!other.getInstanceRequestCount().equals(getInstanceRequestCount()))) {
      return false;
    }
    if (((other.getInstanceRunningCount() == null ? 1 : 0) ^ (getInstanceRunningCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceRunningCount() != null) && (!other.getInstanceRunningCount().equals(getInstanceRunningCount()))) {
      return false;
    }
    if (((other.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getState() != null) && (!other.getState().equals(getState()))) {
      return false;
    }
    if (((other.getLastStateChangeReason() == null ? 1 : 0) ^ (getLastStateChangeReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastStateChangeReason() != null) && (!other.getLastStateChangeReason().equals(getLastStateChangeReason()))) {
      return false;
    }
    if (((other.getCreationDateTime() == null ? 1 : 0) ^ (getCreationDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDateTime() != null) && (!other.getCreationDateTime().equals(getCreationDateTime()))) {
      return false;
    }
    if (((other.getStartDateTime() == null ? 1 : 0) ^ (getStartDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartDateTime() != null) && (!other.getStartDateTime().equals(getStartDateTime()))) {
      return false;
    }
    if (((other.getReadyDateTime() == null ? 1 : 0) ^ (getReadyDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReadyDateTime() != null) && (!other.getReadyDateTime().equals(getReadyDateTime()))) {
      return false;
    }
    if (((other.getEndDateTime() == null ? 1 : 0) ^ (getEndDateTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndDateTime() != null) && (!other.getEndDateTime().equals(getEndDateTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceGroupId() == null ? 0 : getInstanceGroupId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getMarket() == null ? 0 : getMarket().hashCode());
    hashCode = 31 * hashCode + (getInstanceRole() == null ? 0 : getInstanceRole().hashCode());
    hashCode = 31 * hashCode + (getBidPrice() == null ? 0 : getBidPrice().hashCode());
    hashCode = 31 * hashCode + (getInstanceType() == null ? 0 : getInstanceType().hashCode());
    hashCode = 31 * hashCode + (getInstanceRequestCount() == null ? 0 : getInstanceRequestCount().hashCode());
    hashCode = 31 * hashCode + (getInstanceRunningCount() == null ? 0 : getInstanceRunningCount().hashCode());
    hashCode = 31 * hashCode + (getState() == null ? 0 : getState().hashCode());
    hashCode = 31 * hashCode + (getLastStateChangeReason() == null ? 0 : getLastStateChangeReason().hashCode());
    hashCode = 31 * hashCode + (getCreationDateTime() == null ? 0 : getCreationDateTime().hashCode());
    hashCode = 31 * hashCode + (getStartDateTime() == null ? 0 : getStartDateTime().hashCode());
    hashCode = 31 * hashCode + (getReadyDateTime() == null ? 0 : getReadyDateTime().hashCode());
    hashCode = 31 * hashCode + (getEndDateTime() == null ? 0 : getEndDateTime().hashCode());
    return hashCode;
  }
  
  public InstanceGroupDetail clone()
  {
    try
    {
      return (InstanceGroupDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceGroupDetailMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */