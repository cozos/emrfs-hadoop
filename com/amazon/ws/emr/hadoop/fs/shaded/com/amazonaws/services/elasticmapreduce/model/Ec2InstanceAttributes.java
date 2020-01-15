package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.Ec2InstanceAttributesMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Ec2InstanceAttributes
  implements Serializable, Cloneable, StructuredPojo
{
  private String ec2KeyName;
  private String ec2SubnetId;
  private SdkInternalList<String> requestedEc2SubnetIds;
  private String ec2AvailabilityZone;
  private SdkInternalList<String> requestedEc2AvailabilityZones;
  private String iamInstanceProfile;
  private String emrManagedMasterSecurityGroup;
  private String emrManagedSlaveSecurityGroup;
  private String serviceAccessSecurityGroup;
  private SdkInternalList<String> additionalMasterSecurityGroups;
  private SdkInternalList<String> additionalSlaveSecurityGroups;
  
  public void setEc2KeyName(String ec2KeyName)
  {
    this.ec2KeyName = ec2KeyName;
  }
  
  public String getEc2KeyName()
  {
    return ec2KeyName;
  }
  
  public Ec2InstanceAttributes withEc2KeyName(String ec2KeyName)
  {
    setEc2KeyName(ec2KeyName);
    return this;
  }
  
  public void setEc2SubnetId(String ec2SubnetId)
  {
    this.ec2SubnetId = ec2SubnetId;
  }
  
  public String getEc2SubnetId()
  {
    return ec2SubnetId;
  }
  
  public Ec2InstanceAttributes withEc2SubnetId(String ec2SubnetId)
  {
    setEc2SubnetId(ec2SubnetId);
    return this;
  }
  
  public List<String> getRequestedEc2SubnetIds()
  {
    if (requestedEc2SubnetIds == null) {
      requestedEc2SubnetIds = new SdkInternalList();
    }
    return requestedEc2SubnetIds;
  }
  
  public void setRequestedEc2SubnetIds(Collection<String> requestedEc2SubnetIds)
  {
    if (requestedEc2SubnetIds == null)
    {
      this.requestedEc2SubnetIds = null;
      return;
    }
    this.requestedEc2SubnetIds = new SdkInternalList(requestedEc2SubnetIds);
  }
  
  public Ec2InstanceAttributes withRequestedEc2SubnetIds(String... requestedEc2SubnetIds)
  {
    if (this.requestedEc2SubnetIds == null) {
      setRequestedEc2SubnetIds(new SdkInternalList(requestedEc2SubnetIds.length));
    }
    for (String ele : requestedEc2SubnetIds) {
      this.requestedEc2SubnetIds.add(ele);
    }
    return this;
  }
  
  public Ec2InstanceAttributes withRequestedEc2SubnetIds(Collection<String> requestedEc2SubnetIds)
  {
    setRequestedEc2SubnetIds(requestedEc2SubnetIds);
    return this;
  }
  
  public void setEc2AvailabilityZone(String ec2AvailabilityZone)
  {
    this.ec2AvailabilityZone = ec2AvailabilityZone;
  }
  
  public String getEc2AvailabilityZone()
  {
    return ec2AvailabilityZone;
  }
  
  public Ec2InstanceAttributes withEc2AvailabilityZone(String ec2AvailabilityZone)
  {
    setEc2AvailabilityZone(ec2AvailabilityZone);
    return this;
  }
  
  public List<String> getRequestedEc2AvailabilityZones()
  {
    if (requestedEc2AvailabilityZones == null) {
      requestedEc2AvailabilityZones = new SdkInternalList();
    }
    return requestedEc2AvailabilityZones;
  }
  
  public void setRequestedEc2AvailabilityZones(Collection<String> requestedEc2AvailabilityZones)
  {
    if (requestedEc2AvailabilityZones == null)
    {
      this.requestedEc2AvailabilityZones = null;
      return;
    }
    this.requestedEc2AvailabilityZones = new SdkInternalList(requestedEc2AvailabilityZones);
  }
  
  public Ec2InstanceAttributes withRequestedEc2AvailabilityZones(String... requestedEc2AvailabilityZones)
  {
    if (this.requestedEc2AvailabilityZones == null) {
      setRequestedEc2AvailabilityZones(new SdkInternalList(requestedEc2AvailabilityZones.length));
    }
    for (String ele : requestedEc2AvailabilityZones) {
      this.requestedEc2AvailabilityZones.add(ele);
    }
    return this;
  }
  
  public Ec2InstanceAttributes withRequestedEc2AvailabilityZones(Collection<String> requestedEc2AvailabilityZones)
  {
    setRequestedEc2AvailabilityZones(requestedEc2AvailabilityZones);
    return this;
  }
  
  public void setIamInstanceProfile(String iamInstanceProfile)
  {
    this.iamInstanceProfile = iamInstanceProfile;
  }
  
  public String getIamInstanceProfile()
  {
    return iamInstanceProfile;
  }
  
  public Ec2InstanceAttributes withIamInstanceProfile(String iamInstanceProfile)
  {
    setIamInstanceProfile(iamInstanceProfile);
    return this;
  }
  
  public void setEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup)
  {
    this.emrManagedMasterSecurityGroup = emrManagedMasterSecurityGroup;
  }
  
  public String getEmrManagedMasterSecurityGroup()
  {
    return emrManagedMasterSecurityGroup;
  }
  
  public Ec2InstanceAttributes withEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup)
  {
    setEmrManagedMasterSecurityGroup(emrManagedMasterSecurityGroup);
    return this;
  }
  
  public void setEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup)
  {
    this.emrManagedSlaveSecurityGroup = emrManagedSlaveSecurityGroup;
  }
  
  public String getEmrManagedSlaveSecurityGroup()
  {
    return emrManagedSlaveSecurityGroup;
  }
  
  public Ec2InstanceAttributes withEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup)
  {
    setEmrManagedSlaveSecurityGroup(emrManagedSlaveSecurityGroup);
    return this;
  }
  
  public void setServiceAccessSecurityGroup(String serviceAccessSecurityGroup)
  {
    this.serviceAccessSecurityGroup = serviceAccessSecurityGroup;
  }
  
  public String getServiceAccessSecurityGroup()
  {
    return serviceAccessSecurityGroup;
  }
  
  public Ec2InstanceAttributes withServiceAccessSecurityGroup(String serviceAccessSecurityGroup)
  {
    setServiceAccessSecurityGroup(serviceAccessSecurityGroup);
    return this;
  }
  
  public List<String> getAdditionalMasterSecurityGroups()
  {
    if (additionalMasterSecurityGroups == null) {
      additionalMasterSecurityGroups = new SdkInternalList();
    }
    return additionalMasterSecurityGroups;
  }
  
  public void setAdditionalMasterSecurityGroups(Collection<String> additionalMasterSecurityGroups)
  {
    if (additionalMasterSecurityGroups == null)
    {
      this.additionalMasterSecurityGroups = null;
      return;
    }
    this.additionalMasterSecurityGroups = new SdkInternalList(additionalMasterSecurityGroups);
  }
  
  public Ec2InstanceAttributes withAdditionalMasterSecurityGroups(String... additionalMasterSecurityGroups)
  {
    if (this.additionalMasterSecurityGroups == null) {
      setAdditionalMasterSecurityGroups(new SdkInternalList(additionalMasterSecurityGroups.length));
    }
    for (String ele : additionalMasterSecurityGroups) {
      this.additionalMasterSecurityGroups.add(ele);
    }
    return this;
  }
  
  public Ec2InstanceAttributes withAdditionalMasterSecurityGroups(Collection<String> additionalMasterSecurityGroups)
  {
    setAdditionalMasterSecurityGroups(additionalMasterSecurityGroups);
    return this;
  }
  
  public List<String> getAdditionalSlaveSecurityGroups()
  {
    if (additionalSlaveSecurityGroups == null) {
      additionalSlaveSecurityGroups = new SdkInternalList();
    }
    return additionalSlaveSecurityGroups;
  }
  
  public void setAdditionalSlaveSecurityGroups(Collection<String> additionalSlaveSecurityGroups)
  {
    if (additionalSlaveSecurityGroups == null)
    {
      this.additionalSlaveSecurityGroups = null;
      return;
    }
    this.additionalSlaveSecurityGroups = new SdkInternalList(additionalSlaveSecurityGroups);
  }
  
  public Ec2InstanceAttributes withAdditionalSlaveSecurityGroups(String... additionalSlaveSecurityGroups)
  {
    if (this.additionalSlaveSecurityGroups == null) {
      setAdditionalSlaveSecurityGroups(new SdkInternalList(additionalSlaveSecurityGroups.length));
    }
    for (String ele : additionalSlaveSecurityGroups) {
      this.additionalSlaveSecurityGroups.add(ele);
    }
    return this;
  }
  
  public Ec2InstanceAttributes withAdditionalSlaveSecurityGroups(Collection<String> additionalSlaveSecurityGroups)
  {
    setAdditionalSlaveSecurityGroups(additionalSlaveSecurityGroups);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEc2KeyName() != null) {
      sb.append("Ec2KeyName: ").append(getEc2KeyName()).append(",");
    }
    if (getEc2SubnetId() != null) {
      sb.append("Ec2SubnetId: ").append(getEc2SubnetId()).append(",");
    }
    if (getRequestedEc2SubnetIds() != null) {
      sb.append("RequestedEc2SubnetIds: ").append(getRequestedEc2SubnetIds()).append(",");
    }
    if (getEc2AvailabilityZone() != null) {
      sb.append("Ec2AvailabilityZone: ").append(getEc2AvailabilityZone()).append(",");
    }
    if (getRequestedEc2AvailabilityZones() != null) {
      sb.append("RequestedEc2AvailabilityZones: ").append(getRequestedEc2AvailabilityZones()).append(",");
    }
    if (getIamInstanceProfile() != null) {
      sb.append("IamInstanceProfile: ").append(getIamInstanceProfile()).append(",");
    }
    if (getEmrManagedMasterSecurityGroup() != null) {
      sb.append("EmrManagedMasterSecurityGroup: ").append(getEmrManagedMasterSecurityGroup()).append(",");
    }
    if (getEmrManagedSlaveSecurityGroup() != null) {
      sb.append("EmrManagedSlaveSecurityGroup: ").append(getEmrManagedSlaveSecurityGroup()).append(",");
    }
    if (getServiceAccessSecurityGroup() != null) {
      sb.append("ServiceAccessSecurityGroup: ").append(getServiceAccessSecurityGroup()).append(",");
    }
    if (getAdditionalMasterSecurityGroups() != null) {
      sb.append("AdditionalMasterSecurityGroups: ").append(getAdditionalMasterSecurityGroups()).append(",");
    }
    if (getAdditionalSlaveSecurityGroups() != null) {
      sb.append("AdditionalSlaveSecurityGroups: ").append(getAdditionalSlaveSecurityGroups());
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
    if (!(obj instanceof Ec2InstanceAttributes)) {
      return false;
    }
    Ec2InstanceAttributes other = (Ec2InstanceAttributes)obj;
    if (((other.getEc2KeyName() == null ? 1 : 0) ^ (getEc2KeyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2KeyName() != null) && (!other.getEc2KeyName().equals(getEc2KeyName()))) {
      return false;
    }
    if (((other.getEc2SubnetId() == null ? 1 : 0) ^ (getEc2SubnetId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2SubnetId() != null) && (!other.getEc2SubnetId().equals(getEc2SubnetId()))) {
      return false;
    }
    if (((other.getRequestedEc2SubnetIds() == null ? 1 : 0) ^ (getRequestedEc2SubnetIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequestedEc2SubnetIds() != null) && (!other.getRequestedEc2SubnetIds().equals(getRequestedEc2SubnetIds()))) {
      return false;
    }
    if (((other.getEc2AvailabilityZone() == null ? 1 : 0) ^ (getEc2AvailabilityZone() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2AvailabilityZone() != null) && (!other.getEc2AvailabilityZone().equals(getEc2AvailabilityZone()))) {
      return false;
    }
    if (((other.getRequestedEc2AvailabilityZones() == null ? 1 : 0) ^ (getRequestedEc2AvailabilityZones() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequestedEc2AvailabilityZones() != null) && 
      (!other.getRequestedEc2AvailabilityZones().equals(getRequestedEc2AvailabilityZones()))) {
      return false;
    }
    if (((other.getIamInstanceProfile() == null ? 1 : 0) ^ (getIamInstanceProfile() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIamInstanceProfile() != null) && (!other.getIamInstanceProfile().equals(getIamInstanceProfile()))) {
      return false;
    }
    if (((other.getEmrManagedMasterSecurityGroup() == null ? 1 : 0) ^ (getEmrManagedMasterSecurityGroup() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEmrManagedMasterSecurityGroup() != null) && 
      (!other.getEmrManagedMasterSecurityGroup().equals(getEmrManagedMasterSecurityGroup()))) {
      return false;
    }
    if (((other.getEmrManagedSlaveSecurityGroup() == null ? 1 : 0) ^ (getEmrManagedSlaveSecurityGroup() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEmrManagedSlaveSecurityGroup() != null) && (!other.getEmrManagedSlaveSecurityGroup().equals(getEmrManagedSlaveSecurityGroup()))) {
      return false;
    }
    if (((other.getServiceAccessSecurityGroup() == null ? 1 : 0) ^ (getServiceAccessSecurityGroup() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceAccessSecurityGroup() != null) && (!other.getServiceAccessSecurityGroup().equals(getServiceAccessSecurityGroup()))) {
      return false;
    }
    if (((other.getAdditionalMasterSecurityGroups() == null ? 1 : 0) ^ (getAdditionalMasterSecurityGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAdditionalMasterSecurityGroups() != null) && 
      (!other.getAdditionalMasterSecurityGroups().equals(getAdditionalMasterSecurityGroups()))) {
      return false;
    }
    if (((other.getAdditionalSlaveSecurityGroups() == null ? 1 : 0) ^ (getAdditionalSlaveSecurityGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAdditionalSlaveSecurityGroups() != null) && 
      (!other.getAdditionalSlaveSecurityGroups().equals(getAdditionalSlaveSecurityGroups()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEc2KeyName() == null ? 0 : getEc2KeyName().hashCode());
    hashCode = 31 * hashCode + (getEc2SubnetId() == null ? 0 : getEc2SubnetId().hashCode());
    hashCode = 31 * hashCode + (getRequestedEc2SubnetIds() == null ? 0 : getRequestedEc2SubnetIds().hashCode());
    hashCode = 31 * hashCode + (getEc2AvailabilityZone() == null ? 0 : getEc2AvailabilityZone().hashCode());
    hashCode = 31 * hashCode + (getRequestedEc2AvailabilityZones() == null ? 0 : getRequestedEc2AvailabilityZones().hashCode());
    hashCode = 31 * hashCode + (getIamInstanceProfile() == null ? 0 : getIamInstanceProfile().hashCode());
    hashCode = 31 * hashCode + (getEmrManagedMasterSecurityGroup() == null ? 0 : getEmrManagedMasterSecurityGroup().hashCode());
    hashCode = 31 * hashCode + (getEmrManagedSlaveSecurityGroup() == null ? 0 : getEmrManagedSlaveSecurityGroup().hashCode());
    hashCode = 31 * hashCode + (getServiceAccessSecurityGroup() == null ? 0 : getServiceAccessSecurityGroup().hashCode());
    hashCode = 31 * hashCode + (getAdditionalMasterSecurityGroups() == null ? 0 : getAdditionalMasterSecurityGroups().hashCode());
    hashCode = 31 * hashCode + (getAdditionalSlaveSecurityGroups() == null ? 0 : getAdditionalSlaveSecurityGroups().hashCode());
    return hashCode;
  }
  
  public Ec2InstanceAttributes clone()
  {
    try
    {
      return (Ec2InstanceAttributes)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    Ec2InstanceAttributesMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Ec2InstanceAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */