package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowInstancesDetailMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class JobFlowInstancesDetail
  implements Serializable, Cloneable, StructuredPojo
{
  private String masterInstanceType;
  private String masterPublicDnsName;
  private String masterInstanceId;
  private String slaveInstanceType;
  private Integer instanceCount;
  private SdkInternalList<InstanceGroupDetail> instanceGroups;
  private Integer normalizedInstanceHours;
  private String ec2KeyName;
  private String ec2SubnetId;
  private PlacementType placement;
  private Boolean keepJobFlowAliveWhenNoSteps;
  private Boolean terminationProtected;
  private String hadoopVersion;
  
  public JobFlowInstancesDetail() {}
  
  public JobFlowInstancesDetail(String masterInstanceType, String slaveInstanceType, Integer instanceCount)
  {
    setMasterInstanceType(masterInstanceType);
    setSlaveInstanceType(slaveInstanceType);
    setInstanceCount(instanceCount);
  }
  
  public void setMasterInstanceType(String masterInstanceType)
  {
    this.masterInstanceType = masterInstanceType;
  }
  
  public String getMasterInstanceType()
  {
    return masterInstanceType;
  }
  
  public JobFlowInstancesDetail withMasterInstanceType(String masterInstanceType)
  {
    setMasterInstanceType(masterInstanceType);
    return this;
  }
  
  public void setMasterPublicDnsName(String masterPublicDnsName)
  {
    this.masterPublicDnsName = masterPublicDnsName;
  }
  
  public String getMasterPublicDnsName()
  {
    return masterPublicDnsName;
  }
  
  public JobFlowInstancesDetail withMasterPublicDnsName(String masterPublicDnsName)
  {
    setMasterPublicDnsName(masterPublicDnsName);
    return this;
  }
  
  public void setMasterInstanceId(String masterInstanceId)
  {
    this.masterInstanceId = masterInstanceId;
  }
  
  public String getMasterInstanceId()
  {
    return masterInstanceId;
  }
  
  public JobFlowInstancesDetail withMasterInstanceId(String masterInstanceId)
  {
    setMasterInstanceId(masterInstanceId);
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
  
  public JobFlowInstancesDetail withSlaveInstanceType(String slaveInstanceType)
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
  
  public JobFlowInstancesDetail withInstanceCount(Integer instanceCount)
  {
    setInstanceCount(instanceCount);
    return this;
  }
  
  public List<InstanceGroupDetail> getInstanceGroups()
  {
    if (instanceGroups == null) {
      instanceGroups = new SdkInternalList();
    }
    return instanceGroups;
  }
  
  public void setInstanceGroups(Collection<InstanceGroupDetail> instanceGroups)
  {
    if (instanceGroups == null)
    {
      this.instanceGroups = null;
      return;
    }
    this.instanceGroups = new SdkInternalList(instanceGroups);
  }
  
  public JobFlowInstancesDetail withInstanceGroups(InstanceGroupDetail... instanceGroups)
  {
    if (this.instanceGroups == null) {
      setInstanceGroups(new SdkInternalList(instanceGroups.length));
    }
    for (InstanceGroupDetail ele : instanceGroups) {
      this.instanceGroups.add(ele);
    }
    return this;
  }
  
  public JobFlowInstancesDetail withInstanceGroups(Collection<InstanceGroupDetail> instanceGroups)
  {
    setInstanceGroups(instanceGroups);
    return this;
  }
  
  public void setNormalizedInstanceHours(Integer normalizedInstanceHours)
  {
    this.normalizedInstanceHours = normalizedInstanceHours;
  }
  
  public Integer getNormalizedInstanceHours()
  {
    return normalizedInstanceHours;
  }
  
  public JobFlowInstancesDetail withNormalizedInstanceHours(Integer normalizedInstanceHours)
  {
    setNormalizedInstanceHours(normalizedInstanceHours);
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
  
  public JobFlowInstancesDetail withEc2KeyName(String ec2KeyName)
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
  
  public JobFlowInstancesDetail withEc2SubnetId(String ec2SubnetId)
  {
    setEc2SubnetId(ec2SubnetId);
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
  
  public JobFlowInstancesDetail withPlacement(PlacementType placement)
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
  
  public JobFlowInstancesDetail withKeepJobFlowAliveWhenNoSteps(Boolean keepJobFlowAliveWhenNoSteps)
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
  
  public JobFlowInstancesDetail withTerminationProtected(Boolean terminationProtected)
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
  
  public JobFlowInstancesDetail withHadoopVersion(String hadoopVersion)
  {
    setHadoopVersion(hadoopVersion);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMasterInstanceType() != null) {
      sb.append("MasterInstanceType: ").append(getMasterInstanceType()).append(",");
    }
    if (getMasterPublicDnsName() != null) {
      sb.append("MasterPublicDnsName: ").append(getMasterPublicDnsName()).append(",");
    }
    if (getMasterInstanceId() != null) {
      sb.append("MasterInstanceId: ").append(getMasterInstanceId()).append(",");
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
    if (getNormalizedInstanceHours() != null) {
      sb.append("NormalizedInstanceHours: ").append(getNormalizedInstanceHours()).append(",");
    }
    if (getEc2KeyName() != null) {
      sb.append("Ec2KeyName: ").append(getEc2KeyName()).append(",");
    }
    if (getEc2SubnetId() != null) {
      sb.append("Ec2SubnetId: ").append(getEc2SubnetId()).append(",");
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
      sb.append("HadoopVersion: ").append(getHadoopVersion());
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
    if (!(obj instanceof JobFlowInstancesDetail)) {
      return false;
    }
    JobFlowInstancesDetail other = (JobFlowInstancesDetail)obj;
    if (((other.getMasterInstanceType() == null ? 1 : 0) ^ (getMasterInstanceType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMasterInstanceType() != null) && (!other.getMasterInstanceType().equals(getMasterInstanceType()))) {
      return false;
    }
    if (((other.getMasterPublicDnsName() == null ? 1 : 0) ^ (getMasterPublicDnsName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMasterPublicDnsName() != null) && (!other.getMasterPublicDnsName().equals(getMasterPublicDnsName()))) {
      return false;
    }
    if (((other.getMasterInstanceId() == null ? 1 : 0) ^ (getMasterInstanceId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMasterInstanceId() != null) && (!other.getMasterInstanceId().equals(getMasterInstanceId()))) {
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
    if (((other.getNormalizedInstanceHours() == null ? 1 : 0) ^ (getNormalizedInstanceHours() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNormalizedInstanceHours() != null) && (!other.getNormalizedInstanceHours().equals(getNormalizedInstanceHours()))) {
      return false;
    }
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMasterInstanceType() == null ? 0 : getMasterInstanceType().hashCode());
    hashCode = 31 * hashCode + (getMasterPublicDnsName() == null ? 0 : getMasterPublicDnsName().hashCode());
    hashCode = 31 * hashCode + (getMasterInstanceId() == null ? 0 : getMasterInstanceId().hashCode());
    hashCode = 31 * hashCode + (getSlaveInstanceType() == null ? 0 : getSlaveInstanceType().hashCode());
    hashCode = 31 * hashCode + (getInstanceCount() == null ? 0 : getInstanceCount().hashCode());
    hashCode = 31 * hashCode + (getInstanceGroups() == null ? 0 : getInstanceGroups().hashCode());
    hashCode = 31 * hashCode + (getNormalizedInstanceHours() == null ? 0 : getNormalizedInstanceHours().hashCode());
    hashCode = 31 * hashCode + (getEc2KeyName() == null ? 0 : getEc2KeyName().hashCode());
    hashCode = 31 * hashCode + (getEc2SubnetId() == null ? 0 : getEc2SubnetId().hashCode());
    hashCode = 31 * hashCode + (getPlacement() == null ? 0 : getPlacement().hashCode());
    hashCode = 31 * hashCode + (getKeepJobFlowAliveWhenNoSteps() == null ? 0 : getKeepJobFlowAliveWhenNoSteps().hashCode());
    hashCode = 31 * hashCode + (getTerminationProtected() == null ? 0 : getTerminationProtected().hashCode());
    hashCode = 31 * hashCode + (getHadoopVersion() == null ? 0 : getHadoopVersion().hashCode());
    return hashCode;
  }
  
  public JobFlowInstancesDetail clone()
  {
    try
    {
      return (JobFlowInstancesDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    JobFlowInstancesDetailMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */