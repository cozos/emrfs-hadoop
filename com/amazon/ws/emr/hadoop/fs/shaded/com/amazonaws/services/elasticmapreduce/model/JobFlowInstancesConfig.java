package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowInstancesConfigMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class JobFlowInstancesConfig
  implements Serializable, Cloneable, StructuredPojo
{
  private String masterInstanceType;
  private String slaveInstanceType;
  private Integer instanceCount;
  private SdkInternalList<InstanceGroupConfig> instanceGroups;
  private SdkInternalList<InstanceFleetConfig> instanceFleets;
  private String ec2KeyName;
  private PlacementType placement;
  private Boolean keepJobFlowAliveWhenNoSteps;
  private Boolean terminationProtected;
  private String hadoopVersion;
  private String ec2SubnetId;
  private SdkInternalList<String> ec2SubnetIds;
  private String emrManagedMasterSecurityGroup;
  private String emrManagedSlaveSecurityGroup;
  private String serviceAccessSecurityGroup;
  private SdkInternalList<String> additionalMasterSecurityGroups;
  private SdkInternalList<String> additionalSlaveSecurityGroups;
  
  public void setMasterInstanceType(String masterInstanceType)
  {
    this.masterInstanceType = masterInstanceType;
  }
  
  public String getMasterInstanceType()
  {
    return masterInstanceType;
  }
  
  public JobFlowInstancesConfig withMasterInstanceType(String masterInstanceType)
  {
    setMasterInstanceType(masterInstanceType);
    return this;
  }
  
  public void setSlaveInstanceType(String slaveInstanceType)
  {
    this.slaveInstanceType = slaveInstanceType;
  }
  
  public String getSlaveInstanceType()
  {
    return slaveInstanceType;
  }
  
  public JobFlowInstancesConfig withSlaveInstanceType(String slaveInstanceType)
  {
    setSlaveInstanceType(slaveInstanceType);
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
  
  public JobFlowInstancesConfig withInstanceCount(Integer instanceCount)
  {
    setInstanceCount(instanceCount);
    return this;
  }
  
  public List<InstanceGroupConfig> getInstanceGroups()
  {
    if (instanceGroups == null) {
      instanceGroups = new SdkInternalList();
    }
    return instanceGroups;
  }
  
  public void setInstanceGroups(Collection<InstanceGroupConfig> instanceGroups)
  {
    if (instanceGroups == null)
    {
      this.instanceGroups = null;
      return;
    }
    this.instanceGroups = new SdkInternalList(instanceGroups);
  }
  
  public JobFlowInstancesConfig withInstanceGroups(InstanceGroupConfig... instanceGroups)
  {
    if (this.instanceGroups == null) {
      setInstanceGroups(new SdkInternalList(instanceGroups.length));
    }
    for (InstanceGroupConfig ele : instanceGroups) {
      this.instanceGroups.add(ele);
    }
    return this;
  }
  
  public JobFlowInstancesConfig withInstanceGroups(Collection<InstanceGroupConfig> instanceGroups)
  {
    setInstanceGroups(instanceGroups);
    return this;
  }
  
  public List<InstanceFleetConfig> getInstanceFleets()
  {
    if (instanceFleets == null) {
      instanceFleets = new SdkInternalList();
    }
    return instanceFleets;
  }
  
  public void setInstanceFleets(Collection<InstanceFleetConfig> instanceFleets)
  {
    if (instanceFleets == null)
    {
      this.instanceFleets = null;
      return;
    }
    this.instanceFleets = new SdkInternalList(instanceFleets);
  }
  
  public JobFlowInstancesConfig withInstanceFleets(InstanceFleetConfig... instanceFleets)
  {
    if (this.instanceFleets == null) {
      setInstanceFleets(new SdkInternalList(instanceFleets.length));
    }
    for (InstanceFleetConfig ele : instanceFleets) {
      this.instanceFleets.add(ele);
    }
    return this;
  }
  
  public JobFlowInstancesConfig withInstanceFleets(Collection<InstanceFleetConfig> instanceFleets)
  {
    setInstanceFleets(instanceFleets);
    return this;
  }
  
  public void setEc2KeyName(String ec2KeyName)
  {
    this.ec2KeyName = ec2KeyName;
  }
  
  public String getEc2KeyName()
  {
    return ec2KeyName;
  }
  
  public JobFlowInstancesConfig withEc2KeyName(String ec2KeyName)
  {
    setEc2KeyName(ec2KeyName);
    return this;
  }
  
  public void setPlacement(PlacementType placement)
  {
    this.placement = placement;
  }
  
  public PlacementType getPlacement()
  {
    return placement;
  }
  
  public JobFlowInstancesConfig withPlacement(PlacementType placement)
  {
    setPlacement(placement);
    return this;
  }
  
  public void setKeepJobFlowAliveWhenNoSteps(Boolean keepJobFlowAliveWhenNoSteps)
  {
    this.keepJobFlowAliveWhenNoSteps = keepJobFlowAliveWhenNoSteps;
  }
  
  public Boolean getKeepJobFlowAliveWhenNoSteps()
  {
    return keepJobFlowAliveWhenNoSteps;
  }
  
  public JobFlowInstancesConfig withKeepJobFlowAliveWhenNoSteps(Boolean keepJobFlowAliveWhenNoSteps)
  {
    setKeepJobFlowAliveWhenNoSteps(keepJobFlowAliveWhenNoSteps);
    return this;
  }
  
  public Boolean isKeepJobFlowAliveWhenNoSteps()
  {
    return keepJobFlowAliveWhenNoSteps;
  }
  
  public void setTerminationProtected(Boolean terminationProtected)
  {
    this.terminationProtected = terminationProtected;
  }
  
  public Boolean getTerminationProtected()
  {
    return terminationProtected;
  }
  
  public JobFlowInstancesConfig withTerminationProtected(Boolean terminationProtected)
  {
    setTerminationProtected(terminationProtected);
    return this;
  }
  
  public Boolean isTerminationProtected()
  {
    return terminationProtected;
  }
  
  public void setHadoopVersion(String hadoopVersion)
  {
    this.hadoopVersion = hadoopVersion;
  }
  
  public String getHadoopVersion()
  {
    return hadoopVersion;
  }
  
  public JobFlowInstancesConfig withHadoopVersion(String hadoopVersion)
  {
    setHadoopVersion(hadoopVersion);
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
  
  public JobFlowInstancesConfig withEc2SubnetId(String ec2SubnetId)
  {
    setEc2SubnetId(ec2SubnetId);
    return this;
  }
  
  public List<String> getEc2SubnetIds()
  {
    if (ec2SubnetIds == null) {
      ec2SubnetIds = new SdkInternalList();
    }
    return ec2SubnetIds;
  }
  
  public void setEc2SubnetIds(Collection<String> ec2SubnetIds)
  {
    if (ec2SubnetIds == null)
    {
      this.ec2SubnetIds = null;
      return;
    }
    this.ec2SubnetIds = new SdkInternalList(ec2SubnetIds);
  }
  
  public JobFlowInstancesConfig withEc2SubnetIds(String... ec2SubnetIds)
  {
    if (this.ec2SubnetIds == null) {
      setEc2SubnetIds(new SdkInternalList(ec2SubnetIds.length));
    }
    for (String ele : ec2SubnetIds) {
      this.ec2SubnetIds.add(ele);
    }
    return this;
  }
  
  public JobFlowInstancesConfig withEc2SubnetIds(Collection<String> ec2SubnetIds)
  {
    setEc2SubnetIds(ec2SubnetIds);
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
  
  public JobFlowInstancesConfig withEmrManagedMasterSecurityGroup(String emrManagedMasterSecurityGroup)
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
  
  public JobFlowInstancesConfig withEmrManagedSlaveSecurityGroup(String emrManagedSlaveSecurityGroup)
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
  
  public JobFlowInstancesConfig withServiceAccessSecurityGroup(String serviceAccessSecurityGroup)
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
  
  public JobFlowInstancesConfig withAdditionalMasterSecurityGroups(String... additionalMasterSecurityGroups)
  {
    if (this.additionalMasterSecurityGroups == null) {
      setAdditionalMasterSecurityGroups(new SdkInternalList(additionalMasterSecurityGroups.length));
    }
    for (String ele : additionalMasterSecurityGroups) {
      this.additionalMasterSecurityGroups.add(ele);
    }
    return this;
  }
  
  public JobFlowInstancesConfig withAdditionalMasterSecurityGroups(Collection<String> additionalMasterSecurityGroups)
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
  
  public JobFlowInstancesConfig withAdditionalSlaveSecurityGroups(String... additionalSlaveSecurityGroups)
  {
    if (this.additionalSlaveSecurityGroups == null) {
      setAdditionalSlaveSecurityGroups(new SdkInternalList(additionalSlaveSecurityGroups.length));
    }
    for (String ele : additionalSlaveSecurityGroups) {
      this.additionalSlaveSecurityGroups.add(ele);
    }
    return this;
  }
  
  public JobFlowInstancesConfig withAdditionalSlaveSecurityGroups(Collection<String> additionalSlaveSecurityGroups)
  {
    setAdditionalSlaveSecurityGroups(additionalSlaveSecurityGroups);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMasterInstanceType() != null) {
      sb.append("MasterInstanceType: ").append(getMasterInstanceType()).append(",");
    }
    if (getSlaveInstanceType() != null) {
      sb.append("SlaveInstanceType: ").append(getSlaveInstanceType()).append(",");
    }
    if (getInstanceCount() != null) {
      sb.append("InstanceCount: ").append(getInstanceCount()).append(",");
    }
    if (getInstanceGroups() != null) {
      sb.append("InstanceGroups: ").append(getInstanceGroups()).append(",");
    }
    if (getInstanceFleets() != null) {
      sb.append("InstanceFleets: ").append(getInstanceFleets()).append(",");
    }
    if (getEc2KeyName() != null) {
      sb.append("Ec2KeyName: ").append(getEc2KeyName()).append(",");
    }
    if (getPlacement() != null) {
      sb.append("Placement: ").append(getPlacement()).append(",");
    }
    if (getKeepJobFlowAliveWhenNoSteps() != null) {
      sb.append("KeepJobFlowAliveWhenNoSteps: ").append(getKeepJobFlowAliveWhenNoSteps()).append(",");
    }
    if (getTerminationProtected() != null) {
      sb.append("TerminationProtected: ").append(getTerminationProtected()).append(",");
    }
    if (getHadoopVersion() != null) {
      sb.append("HadoopVersion: ").append(getHadoopVersion()).append(",");
    }
    if (getEc2SubnetId() != null) {
      sb.append("Ec2SubnetId: ").append(getEc2SubnetId()).append(",");
    }
    if (getEc2SubnetIds() != null) {
      sb.append("Ec2SubnetIds: ").append(getEc2SubnetIds()).append(",");
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
    if (!(obj instanceof JobFlowInstancesConfig)) {
      return false;
    }
    JobFlowInstancesConfig other = (JobFlowInstancesConfig)obj;
    if (((other.getMasterInstanceType() == null ? 1 : 0) ^ (getMasterInstanceType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMasterInstanceType() != null) && (!other.getMasterInstanceType().equals(getMasterInstanceType()))) {
      return false;
    }
    if (((other.getSlaveInstanceType() == null ? 1 : 0) ^ (getSlaveInstanceType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSlaveInstanceType() != null) && (!other.getSlaveInstanceType().equals(getSlaveInstanceType()))) {
      return false;
    }
    if (((other.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceCount() != null) && (!other.getInstanceCount().equals(getInstanceCount()))) {
      return false;
    }
    if (((other.getInstanceGroups() == null ? 1 : 0) ^ (getInstanceGroups() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceGroups() != null) && (!other.getInstanceGroups().equals(getInstanceGroups()))) {
      return false;
    }
    if (((other.getInstanceFleets() == null ? 1 : 0) ^ (getInstanceFleets() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceFleets() != null) && (!other.getInstanceFleets().equals(getInstanceFleets()))) {
      return false;
    }
    if (((other.getEc2KeyName() == null ? 1 : 0) ^ (getEc2KeyName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2KeyName() != null) && (!other.getEc2KeyName().equals(getEc2KeyName()))) {
      return false;
    }
    if (((other.getPlacement() == null ? 1 : 0) ^ (getPlacement() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPlacement() != null) && (!other.getPlacement().equals(getPlacement()))) {
      return false;
    }
    if (((other.getKeepJobFlowAliveWhenNoSteps() == null ? 1 : 0) ^ (getKeepJobFlowAliveWhenNoSteps() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeepJobFlowAliveWhenNoSteps() != null) && (!other.getKeepJobFlowAliveWhenNoSteps().equals(getKeepJobFlowAliveWhenNoSteps()))) {
      return false;
    }
    if (((other.getTerminationProtected() == null ? 1 : 0) ^ (getTerminationProtected() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTerminationProtected() != null) && (!other.getTerminationProtected().equals(getTerminationProtected()))) {
      return false;
    }
    if (((other.getHadoopVersion() == null ? 1 : 0) ^ (getHadoopVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHadoopVersion() != null) && (!other.getHadoopVersion().equals(getHadoopVersion()))) {
      return false;
    }
    if (((other.getEc2SubnetId() == null ? 1 : 0) ^ (getEc2SubnetId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2SubnetId() != null) && (!other.getEc2SubnetId().equals(getEc2SubnetId()))) {
      return false;
    }
    if (((other.getEc2SubnetIds() == null ? 1 : 0) ^ (getEc2SubnetIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2SubnetIds() != null) && (!other.getEc2SubnetIds().equals(getEc2SubnetIds()))) {
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
    
    hashCode = 31 * hashCode + (getMasterInstanceType() == null ? 0 : getMasterInstanceType().hashCode());
    hashCode = 31 * hashCode + (getSlaveInstanceType() == null ? 0 : getSlaveInstanceType().hashCode());
    hashCode = 31 * hashCode + (getInstanceCount() == null ? 0 : getInstanceCount().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroups() == null ? 0 : getInstanceGroups().hashCode());
    hashCode = 31 * hashCode + (getInstanceFleets() == null ? 0 : getInstanceFleets().hashCode());
    hashCode = 31 * hashCode + (getEc2KeyName() == null ? 0 : getEc2KeyName().hashCode());
    hashCode = 31 * hashCode + (getPlacement() == null ? 0 : getPlacement().hashCode());
    hashCode = 31 * hashCode + (getKeepJobFlowAliveWhenNoSteps() == null ? 0 : getKeepJobFlowAliveWhenNoSteps().hashCode());
    hashCode = 31 * hashCode + (getTerminationProtected() == null ? 0 : getTerminationProtected().hashCode());
    hashCode = 31 * hashCode + (getHadoopVersion() == null ? 0 : getHadoopVersion().hashCode());
    hashCode = 31 * hashCode + (getEc2SubnetId() == null ? 0 : getEc2SubnetId().hashCode());
    hashCode = 31 * hashCode + (getEc2SubnetIds() == null ? 0 : getEc2SubnetIds().hashCode());
    hashCode = 31 * hashCode + (getEmrManagedMasterSecurityGroup() == null ? 0 : getEmrManagedMasterSecurityGroup().hashCode());
    hashCode = 31 * hashCode + (getEmrManagedSlaveSecurityGroup() == null ? 0 : getEmrManagedSlaveSecurityGroup().hashCode());
    hashCode = 31 * hashCode + (getServiceAccessSecurityGroup() == null ? 0 : getServiceAccessSecurityGroup().hashCode());
    hashCode = 31 * hashCode + (getAdditionalMasterSecurityGroups() == null ? 0 : getAdditionalMasterSecurityGroups().hashCode());
    hashCode = 31 * hashCode + (getAdditionalSlaveSecurityGroups() == null ? 0 : getAdditionalSlaveSecurityGroups().hashCode());
    return hashCode;
  }
  
  public JobFlowInstancesConfig clone()
  {
    try
    {
      return (JobFlowInstancesConfig)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    JobFlowInstancesConfigMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */