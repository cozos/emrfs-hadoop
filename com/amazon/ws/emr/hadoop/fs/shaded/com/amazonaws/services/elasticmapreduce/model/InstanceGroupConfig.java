package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceGroupConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String name;
  private String market;
  private String instanceRole;
  private String bidPrice;
  private String instanceType;
  private Integer instanceCount;
  private SdkInternalList<Configuration> configurations;
  private EbsConfiguration ebsConfiguration;
  private AutoScalingPolicy autoScalingPolicy;
  
  public InstanceGroupConfig() {}
  
  public InstanceGroupConfig(String instanceRole, String instanceType, Integer instanceCount)
  {
    setInstanceRole(instanceRole);
    setInstanceType(instanceType);
    setInstanceCount(instanceCount);
  }
  
  public InstanceGroupConfig(InstanceRoleType instanceRole, String instanceType, Integer instanceCount)
  {
    setInstanceRole(instanceRole.toString());
    setInstanceType(instanceType);
    setInstanceCount(instanceCount);
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public InstanceGroupConfig withName(String name)
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
  
  public InstanceGroupConfig withMarket(String market)
  {
    setMarket(market);
    return this;
  }
  
  public void setMarket(MarketType market)
  {
    withMarket(market);
  }
  
  public InstanceGroupConfig withMarket(MarketType market)
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
  
  public InstanceGroupConfig withInstanceRole(String instanceRole)
  {
    setInstanceRole(instanceRole);
    return this;
  }
  
  public void setInstanceRole(InstanceRoleType instanceRole)
  {
    withInstanceRole(instanceRole);
  }
  
  public InstanceGroupConfig withInstanceRole(InstanceRoleType instanceRole)
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
  
  public InstanceGroupConfig withBidPrice(String bidPrice)
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
  
  public InstanceGroupConfig withInstanceType(String instanceType)
  {
    setInstanceType(instanceType);
    return this;
  }
  
  public void setInstanceCount(Integer instanceCount)
  {
    this.instanceCount = instanceCount;
  }
  
  public Integer getInstanceCount()
  {
    return instanceCount;
  }
  
  public InstanceGroupConfig withInstanceCount(Integer instanceCount)
  {
    setInstanceCount(instanceCount);
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
  
  public InstanceGroupConfig withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public InstanceGroupConfig withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public void setEbsConfiguration(EbsConfiguration ebsConfiguration)
  {
    this.ebsConfiguration = ebsConfiguration;
  }
  
  public EbsConfiguration getEbsConfiguration()
  {
    return ebsConfiguration;
  }
  
  public InstanceGroupConfig withEbsConfiguration(EbsConfiguration ebsConfiguration)
  {
    setEbsConfiguration(ebsConfiguration);
    return this;
  }
  
  public void setAutoScalingPolicy(AutoScalingPolicy autoScalingPolicy)
  {
    this.autoScalingPolicy = autoScalingPolicy;
  }
  
  public AutoScalingPolicy getAutoScalingPolicy()
  {
    return autoScalingPolicy;
  }
  
  public InstanceGroupConfig withAutoScalingPolicy(AutoScalingPolicy autoScalingPolicy)
  {
    setAutoScalingPolicy(autoScalingPolicy);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (getInstanceCount() != null) {
      sb.append("InstanceCount: ").append(getInstanceCount()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations()).append(",");
    }
    if (getEbsConfiguration() != null) {
      sb.append("EbsConfiguration: ").append(getEbsConfiguration()).append(",");
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
    if (!(obj instanceof InstanceGroupConfig)) {
      return false;
    }
    InstanceGroupConfig other = (InstanceGroupConfig)obj;
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
    if (((other.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceCount() != null) && (!other.getInstanceCount().equals(getInstanceCount()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    if (((other.getEbsConfiguration() == null ? 1 : 0) ^ (getEbsConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsConfiguration() != null) && (!other.getEbsConfiguration().equals(getEbsConfiguration()))) {
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
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getMarket() == null ? 0 : getMarket().hashCode());
    hashCode = 31 * hashCode + (getInstanceRole() == null ? 0 : getInstanceRole().hashCode());
    hashCode = 31 * hashCode + (getBidPrice() == null ? 0 : getBidPrice().hashCode());
    hashCode = 31 * hashCode + (getInstanceType() == null ? 0 : getInstanceType().hashCode());
    hashCode = 31 * hashCode + (getInstanceCount() == null ? 0 : getInstanceCount().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    hashCode = 31 * hashCode + (getEbsConfiguration() == null ? 0 : getEbsConfiguration().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingPolicy() == null ? 0 : getAutoScalingPolicy().hashCode());
    return hashCode;
  }
  
  public InstanceGroupConfig clone()
  {
    try
    {
      return (InstanceGroupConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceGroupConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */