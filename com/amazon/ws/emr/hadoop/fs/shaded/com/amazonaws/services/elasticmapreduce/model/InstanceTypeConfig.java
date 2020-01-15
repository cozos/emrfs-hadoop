package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceTypeConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceTypeConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String instanceType;
  private Integer weightedCapacity;
  private String bidPrice;
  private Double bidPriceAsPercentageOfOnDemandPrice;
  private EbsConfiguration ebsConfiguration;
  private SdkInternalList<Configuration> configurations;
  
  public void setInstanceType(String instanceType)
  {
    this.instanceType = instanceType;
  }
  
  public String getInstanceType()
  {
    return instanceType;
  }
  
  public InstanceTypeConfig withInstanceType(String instanceType)
  {
    setInstanceType(instanceType);
    return this;
  }
  
  public void setWeightedCapacity(Integer weightedCapacity)
  {
    this.weightedCapacity = weightedCapacity;
  }
  
  public Integer getWeightedCapacity()
  {
    return weightedCapacity;
  }
  
  public InstanceTypeConfig withWeightedCapacity(Integer weightedCapacity)
  {
    setWeightedCapacity(weightedCapacity);
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
  
  public InstanceTypeConfig withBidPrice(String bidPrice)
  {
    setBidPrice(bidPrice);
    return this;
  }
  
  public void setBidPriceAsPercentageOfOnDemandPrice(Double bidPriceAsPercentageOfOnDemandPrice)
  {
    this.bidPriceAsPercentageOfOnDemandPrice = bidPriceAsPercentageOfOnDemandPrice;
  }
  
  public Double getBidPriceAsPercentageOfOnDemandPrice()
  {
    return bidPriceAsPercentageOfOnDemandPrice;
  }
  
  public InstanceTypeConfig withBidPriceAsPercentageOfOnDemandPrice(Double bidPriceAsPercentageOfOnDemandPrice)
  {
    setBidPriceAsPercentageOfOnDemandPrice(bidPriceAsPercentageOfOnDemandPrice);
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
  
  public InstanceTypeConfig withEbsConfiguration(EbsConfiguration ebsConfiguration)
  {
    setEbsConfiguration(ebsConfiguration);
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
  
  public InstanceTypeConfig withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public InstanceTypeConfig withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getInstanceType() != null) {
      sb.append("InstanceType: ").append(getInstanceType()).append(",");
    }
    if (getWeightedCapacity() != null) {
      sb.append("WeightedCapacity: ").append(getWeightedCapacity()).append(",");
    }
    if (getBidPrice() != null) {
      sb.append("BidPrice: ").append(getBidPrice()).append(",");
    }
    if (getBidPriceAsPercentageOfOnDemandPrice() != null) {
      sb.append("BidPriceAsPercentageOfOnDemandPrice: ").append(getBidPriceAsPercentageOfOnDemandPrice()).append(",");
    }
    if (getEbsConfiguration() != null) {
      sb.append("EbsConfiguration: ").append(getEbsConfiguration()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations());
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
    if (!(obj instanceof InstanceTypeConfig)) {
      return false;
    }
    InstanceTypeConfig other = (InstanceTypeConfig)obj;
    if (((other.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceType() != null) && (!other.getInstanceType().equals(getInstanceType()))) {
      return false;
    }
    if (((other.getWeightedCapacity() == null ? 1 : 0) ^ (getWeightedCapacity() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getWeightedCapacity() != null) && (!other.getWeightedCapacity().equals(getWeightedCapacity()))) {
      return false;
    }
    if (((other.getBidPrice() == null ? 1 : 0) ^ (getBidPrice() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBidPrice() != null) && (!other.getBidPrice().equals(getBidPrice()))) {
      return false;
    }
    if (((other.getBidPriceAsPercentageOfOnDemandPrice() == null ? 1 : 0) ^ (getBidPriceAsPercentageOfOnDemandPrice() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBidPriceAsPercentageOfOnDemandPrice() != null) && 
      (!other.getBidPriceAsPercentageOfOnDemandPrice().equals(getBidPriceAsPercentageOfOnDemandPrice()))) {
      return false;
    }
    if (((other.getEbsConfiguration() == null ? 1 : 0) ^ (getEbsConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsConfiguration() != null) && (!other.getEbsConfiguration().equals(getEbsConfiguration()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getInstanceType() == null ? 0 : getInstanceType().hashCode());
    hashCode = 31 * hashCode + (getWeightedCapacity() == null ? 0 : getWeightedCapacity().hashCode());
    hashCode = 31 * hashCode + (getBidPrice() == null ? 0 : getBidPrice().hashCode());
    hashCode = 31 * hashCode + (getBidPriceAsPercentageOfOnDemandPrice() == null ? 0 : getBidPriceAsPercentageOfOnDemandPrice().hashCode());
    hashCode = 31 * hashCode + (getEbsConfiguration() == null ? 0 : getEbsConfiguration().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    return hashCode;
  }
  
  public InstanceTypeConfig clone()
  {
    try
    {
      return (InstanceTypeConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceTypeConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceTypeConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */