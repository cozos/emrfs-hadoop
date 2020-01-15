package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Instance
  implements Serializable, Cloneable, StructuredPojo
{
  private String id;
  private String ec2InstanceId;
  private String publicDnsName;
  private String publicIpAddress;
  private String privateDnsName;
  private String privateIpAddress;
  private InstanceStatus status;
  private String instanceGroupId;
  private String instanceFleetId;
  private String market;
  private String instanceType;
  private SdkInternalList<EbsVolume> ebsVolumes;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Instance withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setEc2InstanceId(String ec2InstanceId)
  {
    this.ec2InstanceId = ec2InstanceId;
  }
  
  public String getEc2InstanceId()
  {
    return ec2InstanceId;
  }
  
  public Instance withEc2InstanceId(String ec2InstanceId)
  {
    setEc2InstanceId(ec2InstanceId);
    return this;
  }
  
  public void setPublicDnsName(String publicDnsName)
  {
    this.publicDnsName = publicDnsName;
  }
  
  public String getPublicDnsName()
  {
    return publicDnsName;
  }
  
  public Instance withPublicDnsName(String publicDnsName)
  {
    setPublicDnsName(publicDnsName);
    return this;
  }
  
  public void setPublicIpAddress(String publicIpAddress)
  {
    this.publicIpAddress = publicIpAddress;
  }
  
  public String getPublicIpAddress()
  {
    return publicIpAddress;
  }
  
  public Instance withPublicIpAddress(String publicIpAddress)
  {
    setPublicIpAddress(publicIpAddress);
    return this;
  }
  
  public void setPrivateDnsName(String privateDnsName)
  {
    this.privateDnsName = privateDnsName;
  }
  
  public String getPrivateDnsName()
  {
    return privateDnsName;
  }
  
  public Instance withPrivateDnsName(String privateDnsName)
  {
    setPrivateDnsName(privateDnsName);
    return this;
  }
  
  public void setPrivateIpAddress(String privateIpAddress)
  {
    this.privateIpAddress = privateIpAddress;
  }
  
  public String getPrivateIpAddress()
  {
    return privateIpAddress;
  }
  
  public Instance withPrivateIpAddress(String privateIpAddress)
  {
    setPrivateIpAddress(privateIpAddress);
    return this;
  }
  
  public void setStatus(InstanceStatus status)
  {
    this.status = status;
  }
  
  public InstanceStatus getStatus()
  {
    return status;
  }
  
  public Instance withStatus(InstanceStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public void setInstanceGroupId(String instanceGroupId)
  {
    this.instanceGroupId = instanceGroupId;
  }
  
  public String getInstanceGroupId()
  {
    return instanceGroupId;
  }
  
  public Instance withInstanceGroupId(String instanceGroupId)
  {
    setInstanceGroupId(instanceGroupId);
    return this;
  }
  
  public void setInstanceFleetId(String instanceFleetId)
  {
    this.instanceFleetId = instanceFleetId;
  }
  
  public String getInstanceFleetId()
  {
    return instanceFleetId;
  }
  
  public Instance withInstanceFleetId(String instanceFleetId)
  {
    setInstanceFleetId(instanceFleetId);
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
  
  public Instance withMarket(String market)
  {
    setMarket(market);
    return this;
  }
  
  public void setMarket(MarketType market)
  {
    withMarket(market);
  }
  
  public Instance withMarket(MarketType market)
  {
    this.market = market.toString();
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
  
  public Instance withInstanceType(String instanceType)
  {
    setInstanceType(instanceType);
    return this;
  }
  
  public List<EbsVolume> getEbsVolumes()
  {
    if (ebsVolumes == null) {
      ebsVolumes = new SdkInternalList();
    }
    return ebsVolumes;
  }
  
  public void setEbsVolumes(Collection<EbsVolume> ebsVolumes)
  {
    if (ebsVolumes == null)
    {
      this.ebsVolumes = null;
      return;
    }
    this.ebsVolumes = new SdkInternalList(ebsVolumes);
  }
  
  public Instance withEbsVolumes(EbsVolume... ebsVolumes)
  {
    if (this.ebsVolumes == null) {
      setEbsVolumes(new SdkInternalList(ebsVolumes.length));
    }
    for (EbsVolume ele : ebsVolumes) {
      this.ebsVolumes.add(ele);
    }
    return this;
  }
  
  public Instance withEbsVolumes(Collection<EbsVolume> ebsVolumes)
  {
    setEbsVolumes(ebsVolumes);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getEc2InstanceId() != null) {
      sb.append("Ec2InstanceId: ").append(getEc2InstanceId()).append(",");
    }
    if (getPublicDnsName() != null) {
      sb.append("PublicDnsName: ").append(getPublicDnsName()).append(",");
    }
    if (getPublicIpAddress() != null) {
      sb.append("PublicIpAddress: ").append(getPublicIpAddress()).append(",");
    }
    if (getPrivateDnsName() != null) {
      sb.append("PrivateDnsName: ").append(getPrivateDnsName()).append(",");
    }
    if (getPrivateIpAddress() != null) {
      sb.append("PrivateIpAddress: ").append(getPrivateIpAddress()).append(",");
    }
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getInstanceGroupId() != null) {
      sb.append("InstanceGroupId: ").append(getInstanceGroupId()).append(",");
    }
    if (getInstanceFleetId() != null) {
      sb.append("InstanceFleetId: ").append(getInstanceFleetId()).append(",");
    }
    if (getMarket() != null) {
      sb.append("Market: ").append(getMarket()).append(",");
    }
    if (getInstanceType() != null) {
      sb.append("InstanceType: ").append(getInstanceType()).append(",");
    }
    if (getEbsVolumes() != null) {
      sb.append("EbsVolumes: ").append(getEbsVolumes());
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
    if (!(obj instanceof Instance)) {
      return false;
    }
    Instance other = (Instance)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getEc2InstanceId() == null ? 1 : 0) ^ (getEc2InstanceId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2InstanceId() != null) && (!other.getEc2InstanceId().equals(getEc2InstanceId()))) {
      return false;
    }
    if (((other.getPublicDnsName() == null ? 1 : 0) ^ (getPublicDnsName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPublicDnsName() != null) && (!other.getPublicDnsName().equals(getPublicDnsName()))) {
      return false;
    }
    if (((other.getPublicIpAddress() == null ? 1 : 0) ^ (getPublicIpAddress() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPublicIpAddress() != null) && (!other.getPublicIpAddress().equals(getPublicIpAddress()))) {
      return false;
    }
    if (((other.getPrivateDnsName() == null ? 1 : 0) ^ (getPrivateDnsName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPrivateDnsName() != null) && (!other.getPrivateDnsName().equals(getPrivateDnsName()))) {
      return false;
    }
    if (((other.getPrivateIpAddress() == null ? 1 : 0) ^ (getPrivateIpAddress() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPrivateIpAddress() != null) && (!other.getPrivateIpAddress().equals(getPrivateIpAddress()))) {
      return false;
    }
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getInstanceGroupId() == null ? 1 : 0) ^ (getInstanceGroupId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroupId() != null) && (!other.getInstanceGroupId().equals(getInstanceGroupId()))) {
      return false;
    }
    if (((other.getInstanceFleetId() == null ? 1 : 0) ^ (getInstanceFleetId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleetId() != null) && (!other.getInstanceFleetId().equals(getInstanceFleetId()))) {
      return false;
    }
    if (((other.getMarket() == null ? 1 : 0) ^ (getMarket() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarket() != null) && (!other.getMarket().equals(getMarket()))) {
      return false;
    }
    if (((other.getInstanceType() == null ? 1 : 0) ^ (getInstanceType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceType() != null) && (!other.getInstanceType().equals(getInstanceType()))) {
      return false;
    }
    if (((other.getEbsVolumes() == null ? 1 : 0) ^ (getEbsVolumes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsVolumes() != null) && (!other.getEbsVolumes().equals(getEbsVolumes()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getEc2InstanceId() == null ? 0 : getEc2InstanceId().hashCode());
    hashCode = 31 * hashCode + (getPublicDnsName() == null ? 0 : getPublicDnsName().hashCode());
    hashCode = 31 * hashCode + (getPublicIpAddress() == null ? 0 : getPublicIpAddress().hashCode());
    hashCode = 31 * hashCode + (getPrivateDnsName() == null ? 0 : getPrivateDnsName().hashCode());
    hashCode = 31 * hashCode + (getPrivateIpAddress() == null ? 0 : getPrivateIpAddress().hashCode());
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroupId() == null ? 0 : getInstanceGroupId().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleetId() == null ? 0 : getInstanceFleetId().hashCode());
    hashCode = 31 * hashCode + (getMarket() == null ? 0 : getMarket().hashCode());
    hashCode = 31 * hashCode + (getInstanceType() == null ? 0 : getInstanceType().hashCode());
    hashCode = 31 * hashCode + (getEbsVolumes() == null ? 0 : getEbsVolumes().hashCode());
    return hashCode;
  }
  
  public Instance clone()
  {
    try
    {
      return (Instance)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    InstanceMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Instance
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */