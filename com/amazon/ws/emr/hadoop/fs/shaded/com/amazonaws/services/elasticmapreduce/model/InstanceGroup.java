package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceGroup
  implements Serializable, Cloneable, StructuredPojo
{
  private String id;
  private String name;
  private String market;
  private String instanceGroupType;
  private String bidPrice;
  private String instanceType;
  private Integer requestedInstanceCount;
  private Integer runningInstanceCount;
  private InstanceGroupStatus status;
  private SdkInternalList<Configuration> configurations;
  private Long configurationsVersion;
  private SdkInternalList<Configuration> lastSuccessfullyAppliedConfigurations;
  private Long lastSuccessfullyAppliedConfigurationsVersion;
  private SdkInternalList<EbsBlockDevice> ebsBlockDevices;
  private Boolean ebsOptimized;
  private ShrinkPolicy shrinkPolicy;
  private AutoScalingPolicyDescription autoScalingPolicy;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public InstanceGroup withId(String id)
  {
    setId(id);
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
  
  public InstanceGroup withName(String name)
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
  
  public InstanceGroup withMarket(String market)
  {
    setMarket(market);
    return this;
  }
  
  public void setMarket(MarketType market)
  {
    withMarket(market);
  }
  
  public InstanceGroup withMarket(MarketType market)
  {
    this.market = market.toString();
    return this;
  }
  
  public void setInstanceGroupType(String instanceGroupType)
  {
    this.instanceGroupType = instanceGroupType;
  }
  
  public String getInstanceGroupType()
  {
    return instanceGroupType;
  }
  
  public InstanceGroup withInstanceGroupType(String instanceGroupType)
  {
    setInstanceGroupType(instanceGroupType);
    return this;
  }
  
  public void setInstanceGroupType(InstanceGroupType instanceGroupType)
  {
    withInstanceGroupType(instanceGroupType);
  }
  
  public InstanceGroup withInstanceGroupType(InstanceGroupType instanceGroupType)
  {
    this.instanceGroupType = instanceGroupType.toString();
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
  
  public InstanceGroup withBidPrice(String bidPrice)
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
  
  public InstanceGroup withInstanceType(String instanceType)
  {
    setInstanceType(instanceType);
    return this;
  }
  
  public void setRequestedInstanceCount(Integer requestedInstanceCount)
  {
    this.requestedInstanceCount = requestedInstanceCount;
  }
  
  public Integer getRequestedInstanceCount()
  {
    return requestedInstanceCount;
  }
  
  public InstanceGroup withRequestedInstanceCount(Integer requestedInstanceCount)
  {
    setRequestedInstanceCount(requestedInstanceCount);
    return this;
  }
  
  public void setRunningInstanceCount(Integer runningInstanceCount)
  {
    this.runningInstanceCount = runningInstanceCount;
  }
  
  public Integer getRunningInstanceCount()
  {
    return runningInstanceCount;
  }
  
  public InstanceGroup withRunningInstanceCount(Integer runningInstanceCount)
  {
    setRunningInstanceCount(runningInstanceCount);
    return this;
  }
  
  public void setStatus(InstanceGroupStatus status)
  {
    this.status = status;
  }
  
  public InstanceGroupStatus getStatus()
  {
    return status;
  }
  
  public InstanceGroup withStatus(InstanceGroupStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public List<Configuration> getConfigurations()
  {
    if (configurations == null) {
      configurations = new SdkInternalList();
    }
    return configurations;
  }
  
  public void setConfigurations(Collection<Configuration> configurations)
  {
    if (configurations == null)
    {
      this.configurations = null;
      return;
    }
    this.configurations = new SdkInternalList(configurations);
  }
  
  public InstanceGroup withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public InstanceGroup withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public void setConfigurationsVersion(Long configurationsVersion)
  {
    this.configurationsVersion = configurationsVersion;
  }
  
  public Long getConfigurationsVersion()
  {
    return configurationsVersion;
  }
  
  public InstanceGroup withConfigurationsVersion(Long configurationsVersion)
  {
    setConfigurationsVersion(configurationsVersion);
    return this;
  }
  
  public List<Configuration> getLastSuccessfullyAppliedConfigurations()
  {
    if (lastSuccessfullyAppliedConfigurations == null) {
      lastSuccessfullyAppliedConfigurations = new SdkInternalList();
    }
    return lastSuccessfullyAppliedConfigurations;
  }
  
  public void setLastSuccessfullyAppliedConfigurations(Collection<Configuration> lastSuccessfullyAppliedConfigurations)
  {
    if (lastSuccessfullyAppliedConfigurations == null)
    {
      this.lastSuccessfullyAppliedConfigurations = null;
      return;
    }
    this.lastSuccessfullyAppliedConfigurations = new SdkInternalList(lastSuccessfullyAppliedConfigurations);
  }
  
  public InstanceGroup withLastSuccessfullyAppliedConfigurations(Configuration... lastSuccessfullyAppliedConfigurations)
  {
    if (this.lastSuccessfullyAppliedConfigurations == null) {
      setLastSuccessfullyAppliedConfigurations(new SdkInternalList(lastSuccessfullyAppliedConfigurations.length));
    }
    for (Configuration ele : lastSuccessfullyAppliedConfigurations) {
      this.lastSuccessfullyAppliedConfigurations.add(ele);
    }
    return this;
  }
  
  public InstanceGroup withLastSuccessfullyAppliedConfigurations(Collection<Configuration> lastSuccessfullyAppliedConfigurations)
  {
    setLastSuccessfullyAppliedConfigurations(lastSuccessfullyAppliedConfigurations);
    return this;
  }
  
  public void setLastSuccessfullyAppliedConfigurationsVersion(Long lastSuccessfullyAppliedConfigurationsVersion)
  {
    this.lastSuccessfullyAppliedConfigurationsVersion = lastSuccessfullyAppliedConfigurationsVersion;
  }
  
  public Long getLastSuccessfullyAppliedConfigurationsVersion()
  {
    return lastSuccessfullyAppliedConfigurationsVersion;
  }
  
  public InstanceGroup withLastSuccessfullyAppliedConfigurationsVersion(Long lastSuccessfullyAppliedConfigurationsVersion)
  {
    setLastSuccessfullyAppliedConfigurationsVersion(lastSuccessfullyAppliedConfigurationsVersion);
    return this;
  }
  
  public List<EbsBlockDevice> getEbsBlockDevices()
  {
    if (ebsBlockDevices == null) {
      ebsBlockDevices = new SdkInternalList();
    }
    return ebsBlockDevices;
  }
  
  public void setEbsBlockDevices(Collection<EbsBlockDevice> ebsBlockDevices)
  {
    if (ebsBlockDevices == null)
    {
      this.ebsBlockDevices = null;
      return;
    }
    this.ebsBlockDevices = new SdkInternalList(ebsBlockDevices);
  }
  
  public InstanceGroup withEbsBlockDevices(EbsBlockDevice... ebsBlockDevices)
  {
    if (this.ebsBlockDevices == null) {
      setEbsBlockDevices(new SdkInternalList(ebsBlockDevices.length));
    }
    for (EbsBlockDevice ele : ebsBlockDevices) {
      this.ebsBlockDevices.add(ele);
    }
    return this;
  }
  
  public InstanceGroup withEbsBlockDevices(Collection<EbsBlockDevice> ebsBlockDevices)
  {
    setEbsBlockDevices(ebsBlockDevices);
    return this;
  }
  
  public void setEbsOptimized(Boolean ebsOptimized)
  {
    this.ebsOptimized = ebsOptimized;
  }
  
  public Boolean getEbsOptimized()
  {
    return ebsOptimized;
  }
  
  public InstanceGroup withEbsOptimized(Boolean ebsOptimized)
  {
    setEbsOptimized(ebsOptimized);
    return this;
  }
  
  public Boolean isEbsOptimized()
  {
    return ebsOptimized;
  }
  
  public void setShrinkPolicy(ShrinkPolicy shrinkPolicy)
  {
    this.shrinkPolicy = shrinkPolicy;
  }
  
  public ShrinkPolicy getShrinkPolicy()
  {
    return shrinkPolicy;
  }
  
  public InstanceGroup withShrinkPolicy(ShrinkPolicy shrinkPolicy)
  {
    setShrinkPolicy(shrinkPolicy);
    return this;
  }
  
  public void setAutoScalingPolicy(AutoScalingPolicyDescription autoScalingPolicy)
  {
    this.autoScalingPolicy = autoScalingPolicy;
  }
  
  public AutoScalingPolicyDescription getAutoScalingPolicy()
  {
    return autoScalingPolicy;
  }
  
  public InstanceGroup withAutoScalingPolicy(AutoScalingPolicyDescription autoScalingPolicy)
  {
    setAutoScalingPolicy(autoScalingPolicy);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getMarket() != null) {
      sb.append("Market: ").append(getMarket()).append(",");
    }
    if (getInstanceGroupType() != null) {
      sb.append("InstanceGroupType: ").append(getInstanceGroupType()).append(",");
    }
    if (getBidPrice() != null) {
      sb.append("BidPrice: ").append(getBidPrice()).append(",");
    }
    if (getInstanceType() != null) {
      sb.append("InstanceType: ").append(getInstanceType()).append(",");
    }
    if (getRequestedInstanceCount() != null) {
      sb.append("RequestedInstanceCount: ").append(getRequestedInstanceCount()).append(",");
    }
    if (getRunningInstanceCount() != null) {
      sb.append("RunningInstanceCount: ").append(getRunningInstanceCount()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations()).append(",");
    }
    if (getConfigurationsVersion() != null) {
      sb.append("ConfigurationsVersion: ").append(getConfigurationsVersion()).append(",");
    }
    if (getLastSuccessfullyAppliedConfigurations() != null) {
      sb.append("LastSuccessfullyAppliedConfigurations: ").append(getLastSuccessfullyAppliedConfigurations()).append(",");
    }
    if (getLastSuccessfullyAppliedConfigurationsVersion() != null) {
      sb.append("LastSuccessfullyAppliedConfigurationsVersion: ").append(getLastSuccessfullyAppliedConfigurationsVersion()).append(",");
    }
    if (getEbsBlockDevices() != null) {
      sb.append("EbsBlockDevices: ").append(getEbsBlockDevices()).append(",");
    }
    if (getEbsOptimized() != null) {
      sb.append("EbsOptimized: ").append(getEbsOptimized()).append(",");
    }
    if (getShrinkPolicy() != null) {
      sb.append("ShrinkPolicy: ").append(getShrinkPolicy()).append(",");
    }
    if (getAutoScalingPolicy() != null) {
      sb.append("AutoScalingPolicy: ").append(getAutoScalingPolicy());
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
    if (!(obj instanceof InstanceGroup)) {
      return false;
    }
    InstanceGroup other = (InstanceGroup)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
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
    if (((other.getInstanceGroupType() == null ? 1 : 0) ^ (getInstanceGroupType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupType() != null) && (!other.getInstanceGroupType().equals(getInstanceGroupType()))) {
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
    if (((other.getRequestedInstanceCount() == null ? 1 : 0) ^ (getRequestedInstanceCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequestedInstanceCount() != null) && (!other.getRequestedInstanceCount().equals(getRequestedInstanceCount()))) {
      return false;
    }
    if (((other.getRunningInstanceCount() == null ? 1 : 0) ^ (getRunningInstanceCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRunningInstanceCount() != null) && (!other.getRunningInstanceCount().equals(getRunningInstanceCount()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    if (((other.getConfigurationsVersion() == null ? 1 : 0) ^ (getConfigurationsVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurationsVersion() != null) && (!other.getConfigurationsVersion().equals(getConfigurationsVersion()))) {
      return false;
    }
    if (((other.getLastSuccessfullyAppliedConfigurations() == null ? 1 : 0) ^ (getLastSuccessfullyAppliedConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastSuccessfullyAppliedConfigurations() != null) && 
      (!other.getLastSuccessfullyAppliedConfigurations().equals(getLastSuccessfullyAppliedConfigurations()))) {
      return false;
    }
    if (((other.getLastSuccessfullyAppliedConfigurationsVersion() == null ? 1 : 0) ^ (getLastSuccessfullyAppliedConfigurationsVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastSuccessfullyAppliedConfigurationsVersion() != null) && 
      (!other.getLastSuccessfullyAppliedConfigurationsVersion().equals(getLastSuccessfullyAppliedConfigurationsVersion()))) {
      return false;
    }
    if (((other.getEbsBlockDevices() == null ? 1 : 0) ^ (getEbsBlockDevices() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsBlockDevices() != null) && (!other.getEbsBlockDevices().equals(getEbsBlockDevices()))) {
      return false;
    }
    if (((other.getEbsOptimized() == null ? 1 : 0) ^ (getEbsOptimized() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsOptimized() != null) && (!other.getEbsOptimized().equals(getEbsOptimized()))) {
      return false;
    }
    if (((other.getShrinkPolicy() == null ? 1 : 0) ^ (getShrinkPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getShrinkPolicy() != null) && (!other.getShrinkPolicy().equals(getShrinkPolicy()))) {
      return false;
    }
    if (((other.getAutoScalingPolicy() == null ? 1 : 0) ^ (getAutoScalingPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAutoScalingPolicy() != null) && (!other.getAutoScalingPolicy().equals(getAutoScalingPolicy()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getMarket() == null ? 0 : getMarket().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroupType() == null ? 0 : getInstanceGroupType().hashCode());
    hashCode = 31 * hashCode + (getBidPrice() == null ? 0 : getBidPrice().hashCode());
    hashCode = 31 * hashCode + (getInstanceType() == null ? 0 : getInstanceType().hashCode());
    hashCode = 31 * hashCode + (getRequestedInstanceCount() == null ? 0 : getRequestedInstanceCount().hashCode());
    hashCode = 31 * hashCode + (getRunningInstanceCount() == null ? 0 : getRunningInstanceCount().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    hashCode = 31 * hashCode + (getConfigurationsVersion() == null ? 0 : getConfigurationsVersion().hashCode());
    hashCode = 31 * hashCode + (getLastSuccessfullyAppliedConfigurations() == null ? 0 : getLastSuccessfullyAppliedConfigurations().hashCode());
    
    hashCode = 31 * hashCode + (getLastSuccessfullyAppliedConfigurationsVersion() == null ? 0 : getLastSuccessfullyAppliedConfigurationsVersion().hashCode());
    hashCode = 31 * hashCode + (getEbsBlockDevices() == null ? 0 : getEbsBlockDevices().hashCode());
    hashCode = 31 * hashCode + (getEbsOptimized() == null ? 0 : getEbsOptimized().hashCode());
    hashCode = 31 * hashCode + (getShrinkPolicy() == null ? 0 : getShrinkPolicy().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingPolicy() == null ? 0 : getAutoScalingPolicy().hashCode());
    return hashCode;
  }
  
  public InstanceGroup clone()
  {
    try
    {
      return (InstanceGroup)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceGroupMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */