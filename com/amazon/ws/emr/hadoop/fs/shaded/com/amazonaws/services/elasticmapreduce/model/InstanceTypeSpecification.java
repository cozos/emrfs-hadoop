package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceTypeSpecificationMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class InstanceTypeSpecification
  implements Serializable, Cloneable, StructuredPojo
{
  private String instanceType;
  private Integer weightedCapacity;
  private String bidPrice;
  private Double bidPriceAsPercentageOfOnDemandPrice;
  private SdkInternalList<Configuration> configurations;
  private SdkInternalList<EbsBlockDevice> ebsBlockDevices;
  private Boolean ebsOptimized;
  
  public void setInstanceType(String instanceType)
  {
    this.instanceType = instanceType;
  }
  
  public String getInstanceType()
  {
    return instanceType;
  }
  
  public InstanceTypeSpecification withInstanceType(String instanceType)
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
  
  public InstanceTypeSpecification withWeightedCapacity(Integer weightedCapacity)
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
  
  public InstanceTypeSpecification withBidPrice(String bidPrice)
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
  
  public InstanceTypeSpecification withBidPriceAsPercentageOfOnDemandPrice(Double bidPriceAsPercentageOfOnDemandPrice)
  {
    setBidPriceAsPercentageOfOnDemandPrice(bidPriceAsPercentageOfOnDemandPrice);
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
  
  public InstanceTypeSpecification withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public InstanceTypeSpecification withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
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
  
  public InstanceTypeSpecification withEbsBlockDevices(EbsBlockDevice... ebsBlockDevices)
  {
    if (this.ebsBlockDevices == null) {
      setEbsBlockDevices(new SdkInternalList(ebsBlockDevices.length));
    }
    for (EbsBlockDevice ele : ebsBlockDevices) {
      this.ebsBlockDevices.add(ele);
    }
    return this;
  }
  
  public InstanceTypeSpecification withEbsBlockDevices(Collection<EbsBlockDevice> ebsBlockDevices)
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
  
  public InstanceTypeSpecification withEbsOptimized(Boolean ebsOptimized)
  {
    setEbsOptimized(ebsOptimized);
    return this;
  }
  
  public Boolean isEbsOptimized()
  {
    return ebsOptimized;
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
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations()).append(",");
    }
    if (getEbsBlockDevices() != null) {
      sb.append("EbsBlockDevices: ").append(getEbsBlockDevices()).append(",");
    }
    if (getEbsOptimized() != null) {
      sb.append("EbsOptimized: ").append(getEbsOptimized());
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
    if (!(obj instanceof InstanceTypeSpecification)) {
      return false;
    }
    InstanceTypeSpecification other = (InstanceTypeSpecification)obj;
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
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
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
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    hashCode = 31 * hashCode + (getEbsBlockDevices() == null ? 0 : getEbsBlockDevices().hashCode());
    hashCode = 31 * hashCode + (getEbsOptimized() == null ? 0 : getEbsOptimized().hashCode());
    return hashCode;
  }
  
  public InstanceTypeSpecification clone()
  {
    try
    {
      return (InstanceTypeSpecification)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceTypeSpecificationMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceTypeSpecification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */