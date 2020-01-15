package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ClusterMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class Cluster
  implements Serializable, Cloneable, StructuredPojo
{
  private String id;
  private String name;
  private ClusterStatus status;
  private Ec2InstanceAttributes ec2InstanceAttributes;
  private String instanceCollectionType;
  private String logUri;
  private String requestedAmiVersion;
  private String runningAmiVersion;
  private String releaseLabel;
  private Boolean autoTerminate;
  private Boolean terminationProtected;
  private Boolean visibleToAllUsers;
  private SdkInternalList<Application> applications;
  private SdkInternalList<Tag> tags;
  private String serviceRole;
  private Integer normalizedInstanceHours;
  private String masterPublicDnsName;
  private SdkInternalList<Configuration> configurations;
  private String securityConfiguration;
  private String autoScalingRole;
  private String scaleDownBehavior;
  private String customAmiId;
  private Integer ebsRootVolumeSize;
  private String repoUpgradeOnBoot;
  private KerberosAttributes kerberosAttributes;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public Cluster withId(String id)
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
  
  public Cluster withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setStatus(ClusterStatus status)
  {
    this.status = status;
  }
  
  public ClusterStatus getStatus()
  {
    return status;
  }
  
  public Cluster withStatus(ClusterStatus status)
  {
    setStatus(status);
    return this;
  }
  
  public void setEc2InstanceAttributes(Ec2InstanceAttributes ec2InstanceAttributes)
  {
    this.ec2InstanceAttributes = ec2InstanceAttributes;
  }
  
  public Ec2InstanceAttributes getEc2InstanceAttributes()
  {
    return ec2InstanceAttributes;
  }
  
  public Cluster withEc2InstanceAttributes(Ec2InstanceAttributes ec2InstanceAttributes)
  {
    setEc2InstanceAttributes(ec2InstanceAttributes);
    return this;
  }
  
  public void setInstanceCollectionType(String instanceCollectionType)
  {
    this.instanceCollectionType = instanceCollectionType;
  }
  
  public String getInstanceCollectionType()
  {
    return instanceCollectionType;
  }
  
  public Cluster withInstanceCollectionType(String instanceCollectionType)
  {
    setInstanceCollectionType(instanceCollectionType);
    return this;
  }
  
  public void setInstanceCollectionType(InstanceCollectionType instanceCollectionType)
  {
    withInstanceCollectionType(instanceCollectionType);
  }
  
  public Cluster withInstanceCollectionType(InstanceCollectionType instanceCollectionType)
  {
    this.instanceCollectionType = instanceCollectionType.toString();
    return this;
  }
  
  public void setLogUri(String logUri)
  {
    this.logUri = logUri;
  }
  
  public String getLogUri()
  {
    return logUri;
  }
  
  public Cluster withLogUri(String logUri)
  {
    setLogUri(logUri);
    return this;
  }
  
  public void setRequestedAmiVersion(String requestedAmiVersion)
  {
    this.requestedAmiVersion = requestedAmiVersion;
  }
  
  public String getRequestedAmiVersion()
  {
    return requestedAmiVersion;
  }
  
  public Cluster withRequestedAmiVersion(String requestedAmiVersion)
  {
    setRequestedAmiVersion(requestedAmiVersion);
    return this;
  }
  
  public void setRunningAmiVersion(String runningAmiVersion)
  {
    this.runningAmiVersion = runningAmiVersion;
  }
  
  public String getRunningAmiVersion()
  {
    return runningAmiVersion;
  }
  
  public Cluster withRunningAmiVersion(String runningAmiVersion)
  {
    setRunningAmiVersion(runningAmiVersion);
    return this;
  }
  
  public void setReleaseLabel(String releaseLabel)
  {
    this.releaseLabel = releaseLabel;
  }
  
  public String getReleaseLabel()
  {
    return releaseLabel;
  }
  
  public Cluster withReleaseLabel(String releaseLabel)
  {
    setReleaseLabel(releaseLabel);
    return this;
  }
  
  public void setAutoTerminate(Boolean autoTerminate)
  {
    this.autoTerminate = autoTerminate;
  }
  
  public Boolean getAutoTerminate()
  {
    return autoTerminate;
  }
  
  public Cluster withAutoTerminate(Boolean autoTerminate)
  {
    setAutoTerminate(autoTerminate);
    return this;
  }
  
  public Boolean isAutoTerminate()
  {
    return autoTerminate;
  }
  
  public void setTerminationProtected(Boolean terminationProtected)
  {
    this.terminationProtected = terminationProtected;
  }
  
  public Boolean getTerminationProtected()
  {
    return terminationProtected;
  }
  
  public Cluster withTerminationProtected(Boolean terminationProtected)
  {
    setTerminationProtected(terminationProtected);
    return this;
  }
  
  public Boolean isTerminationProtected()
  {
    return terminationProtected;
  }
  
  public void setVisibleToAllUsers(Boolean visibleToAllUsers)
  {
    this.visibleToAllUsers = visibleToAllUsers;
  }
  
  public Boolean getVisibleToAllUsers()
  {
    return visibleToAllUsers;
  }
  
  public Cluster withVisibleToAllUsers(Boolean visibleToAllUsers)
  {
    setVisibleToAllUsers(visibleToAllUsers);
    return this;
  }
  
  public Boolean isVisibleToAllUsers()
  {
    return visibleToAllUsers;
  }
  
  public List<Application> getApplications()
  {
    if (applications == null) {
      applications = new SdkInternalList();
    }
    return applications;
  }
  
  public void setApplications(Collection<Application> applications)
  {
    if (applications == null)
    {
      this.applications = null;
      return;
    }
    this.applications = new SdkInternalList(applications);
  }
  
  public Cluster withApplications(Application... applications)
  {
    if (this.applications == null) {
      setApplications(new SdkInternalList(applications.length));
    }
    for (Application ele : applications) {
      this.applications.add(ele);
    }
    return this;
  }
  
  public Cluster withApplications(Collection<Application> applications)
  {
    setApplications(applications);
    return this;
  }
  
  public List<Tag> getTags()
  {
    if (tags == null) {
      tags = new SdkInternalList();
    }
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new SdkInternalList(tags);
  }
  
  public Cluster withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public Cluster withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public void setServiceRole(String serviceRole)
  {
    this.serviceRole = serviceRole;
  }
  
  public String getServiceRole()
  {
    return serviceRole;
  }
  
  public Cluster withServiceRole(String serviceRole)
  {
    setServiceRole(serviceRole);
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
  
  public Cluster withNormalizedInstanceHours(Integer normalizedInstanceHours)
  {
    setNormalizedInstanceHours(normalizedInstanceHours);
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
  
  public Cluster withMasterPublicDnsName(String masterPublicDnsName)
  {
    setMasterPublicDnsName(masterPublicDnsName);
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
  
  public Cluster withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public Cluster withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public void setSecurityConfiguration(String securityConfiguration)
  {
    this.securityConfiguration = securityConfiguration;
  }
  
  public String getSecurityConfiguration()
  {
    return securityConfiguration;
  }
  
  public Cluster withSecurityConfiguration(String securityConfiguration)
  {
    setSecurityConfiguration(securityConfiguration);
    return this;
  }
  
  public void setAutoScalingRole(String autoScalingRole)
  {
    this.autoScalingRole = autoScalingRole;
  }
  
  public String getAutoScalingRole()
  {
    return autoScalingRole;
  }
  
  public Cluster withAutoScalingRole(String autoScalingRole)
  {
    setAutoScalingRole(autoScalingRole);
    return this;
  }
  
  public void setScaleDownBehavior(String scaleDownBehavior)
  {
    this.scaleDownBehavior = scaleDownBehavior;
  }
  
  public String getScaleDownBehavior()
  {
    return scaleDownBehavior;
  }
  
  public Cluster withScaleDownBehavior(String scaleDownBehavior)
  {
    setScaleDownBehavior(scaleDownBehavior);
    return this;
  }
  
  public void setScaleDownBehavior(ScaleDownBehavior scaleDownBehavior)
  {
    withScaleDownBehavior(scaleDownBehavior);
  }
  
  public Cluster withScaleDownBehavior(ScaleDownBehavior scaleDownBehavior)
  {
    this.scaleDownBehavior = scaleDownBehavior.toString();
    return this;
  }
  
  public void setCustomAmiId(String customAmiId)
  {
    this.customAmiId = customAmiId;
  }
  
  public String getCustomAmiId()
  {
    return customAmiId;
  }
  
  public Cluster withCustomAmiId(String customAmiId)
  {
    setCustomAmiId(customAmiId);
    return this;
  }
  
  public void setEbsRootVolumeSize(Integer ebsRootVolumeSize)
  {
    this.ebsRootVolumeSize = ebsRootVolumeSize;
  }
  
  public Integer getEbsRootVolumeSize()
  {
    return ebsRootVolumeSize;
  }
  
  public Cluster withEbsRootVolumeSize(Integer ebsRootVolumeSize)
  {
    setEbsRootVolumeSize(ebsRootVolumeSize);
    return this;
  }
  
  public void setRepoUpgradeOnBoot(String repoUpgradeOnBoot)
  {
    this.repoUpgradeOnBoot = repoUpgradeOnBoot;
  }
  
  public String getRepoUpgradeOnBoot()
  {
    return repoUpgradeOnBoot;
  }
  
  public Cluster withRepoUpgradeOnBoot(String repoUpgradeOnBoot)
  {
    setRepoUpgradeOnBoot(repoUpgradeOnBoot);
    return this;
  }
  
  public void setRepoUpgradeOnBoot(RepoUpgradeOnBoot repoUpgradeOnBoot)
  {
    withRepoUpgradeOnBoot(repoUpgradeOnBoot);
  }
  
  public Cluster withRepoUpgradeOnBoot(RepoUpgradeOnBoot repoUpgradeOnBoot)
  {
    this.repoUpgradeOnBoot = repoUpgradeOnBoot.toString();
    return this;
  }
  
  public void setKerberosAttributes(KerberosAttributes kerberosAttributes)
  {
    this.kerberosAttributes = kerberosAttributes;
  }
  
  public KerberosAttributes getKerberosAttributes()
  {
    return kerberosAttributes;
  }
  
  public Cluster withKerberosAttributes(KerberosAttributes kerberosAttributes)
  {
    setKerberosAttributes(kerberosAttributes);
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
    if (getStatus() != null) {
      sb.append("Status: ").append(getStatus()).append(",");
    }
    if (getEc2InstanceAttributes() != null) {
      sb.append("Ec2InstanceAttributes: ").append(getEc2InstanceAttributes()).append(",");
    }
    if (getInstanceCollectionType() != null) {
      sb.append("InstanceCollectionType: ").append(getInstanceCollectionType()).append(",");
    }
    if (getLogUri() != null) {
      sb.append("LogUri: ").append(getLogUri()).append(",");
    }
    if (getRequestedAmiVersion() != null) {
      sb.append("RequestedAmiVersion: ").append(getRequestedAmiVersion()).append(",");
    }
    if (getRunningAmiVersion() != null) {
      sb.append("RunningAmiVersion: ").append(getRunningAmiVersion()).append(",");
    }
    if (getReleaseLabel() != null) {
      sb.append("ReleaseLabel: ").append(getReleaseLabel()).append(",");
    }
    if (getAutoTerminate() != null) {
      sb.append("AutoTerminate: ").append(getAutoTerminate()).append(",");
    }
    if (getTerminationProtected() != null) {
      sb.append("TerminationProtected: ").append(getTerminationProtected()).append(",");
    }
    if (getVisibleToAllUsers() != null) {
      sb.append("VisibleToAllUsers: ").append(getVisibleToAllUsers()).append(",");
    }
    if (getApplications() != null) {
      sb.append("Applications: ").append(getApplications()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags()).append(",");
    }
    if (getServiceRole() != null) {
      sb.append("ServiceRole: ").append(getServiceRole()).append(",");
    }
    if (getNormalizedInstanceHours() != null) {
      sb.append("NormalizedInstanceHours: ").append(getNormalizedInstanceHours()).append(",");
    }
    if (getMasterPublicDnsName() != null) {
      sb.append("MasterPublicDnsName: ").append(getMasterPublicDnsName()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations()).append(",");
    }
    if (getSecurityConfiguration() != null) {
      sb.append("SecurityConfiguration: ").append(getSecurityConfiguration()).append(",");
    }
    if (getAutoScalingRole() != null) {
      sb.append("AutoScalingRole: ").append(getAutoScalingRole()).append(",");
    }
    if (getScaleDownBehavior() != null) {
      sb.append("ScaleDownBehavior: ").append(getScaleDownBehavior()).append(",");
    }
    if (getCustomAmiId() != null) {
      sb.append("CustomAmiId: ").append(getCustomAmiId()).append(",");
    }
    if (getEbsRootVolumeSize() != null) {
      sb.append("EbsRootVolumeSize: ").append(getEbsRootVolumeSize()).append(",");
    }
    if (getRepoUpgradeOnBoot() != null) {
      sb.append("RepoUpgradeOnBoot: ").append(getRepoUpgradeOnBoot()).append(",");
    }
    if (getKerberosAttributes() != null) {
      sb.append("KerberosAttributes: ").append(getKerberosAttributes());
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
    if (!(obj instanceof Cluster)) {
      return false;
    }
    Cluster other = (Cluster)obj;
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
    if (((other.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStatus() != null) && (!other.getStatus().equals(getStatus()))) {
      return false;
    }
    if (((other.getEc2InstanceAttributes() == null ? 1 : 0) ^ (getEc2InstanceAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEc2InstanceAttributes() != null) && (!other.getEc2InstanceAttributes().equals(getEc2InstanceAttributes()))) {
      return false;
    }
    if (((other.getInstanceCollectionType() == null ? 1 : 0) ^ (getInstanceCollectionType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstanceCollectionType() != null) && (!other.getInstanceCollectionType().equals(getInstanceCollectionType()))) {
      return false;
    }
    if (((other.getLogUri() == null ? 1 : 0) ^ (getLogUri() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLogUri() != null) && (!other.getLogUri().equals(getLogUri()))) {
      return false;
    }
    if (((other.getRequestedAmiVersion() == null ? 1 : 0) ^ (getRequestedAmiVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequestedAmiVersion() != null) && (!other.getRequestedAmiVersion().equals(getRequestedAmiVersion()))) {
      return false;
    }
    if (((other.getRunningAmiVersion() == null ? 1 : 0) ^ (getRunningAmiVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRunningAmiVersion() != null) && (!other.getRunningAmiVersion().equals(getRunningAmiVersion()))) {
      return false;
    }
    if (((other.getReleaseLabel() == null ? 1 : 0) ^ (getReleaseLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReleaseLabel() != null) && (!other.getReleaseLabel().equals(getReleaseLabel()))) {
      return false;
    }
    if (((other.getAutoTerminate() == null ? 1 : 0) ^ (getAutoTerminate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAutoTerminate() != null) && (!other.getAutoTerminate().equals(getAutoTerminate()))) {
      return false;
    }
    if (((other.getTerminationProtected() == null ? 1 : 0) ^ (getTerminationProtected() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTerminationProtected() != null) && (!other.getTerminationProtected().equals(getTerminationProtected()))) {
      return false;
    }
    if (((other.getVisibleToAllUsers() == null ? 1 : 0) ^ (getVisibleToAllUsers() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVisibleToAllUsers() != null) && (!other.getVisibleToAllUsers().equals(getVisibleToAllUsers()))) {
      return false;
    }
    if (((other.getApplications() == null ? 1 : 0) ^ (getApplications() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getApplications() != null) && (!other.getApplications().equals(getApplications()))) {
      return false;
    }
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
      return false;
    }
    if (((other.getServiceRole() == null ? 1 : 0) ^ (getServiceRole() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceRole() != null) && (!other.getServiceRole().equals(getServiceRole()))) {
      return false;
    }
    if (((other.getNormalizedInstanceHours() == null ? 1 : 0) ^ (getNormalizedInstanceHours() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNormalizedInstanceHours() != null) && (!other.getNormalizedInstanceHours().equals(getNormalizedInstanceHours()))) {
      return false;
    }
    if (((other.getMasterPublicDnsName() == null ? 1 : 0) ^ (getMasterPublicDnsName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMasterPublicDnsName() != null) && (!other.getMasterPublicDnsName().equals(getMasterPublicDnsName()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    if (((other.getSecurityConfiguration() == null ? 1 : 0) ^ (getSecurityConfiguration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSecurityConfiguration() != null) && (!other.getSecurityConfiguration().equals(getSecurityConfiguration()))) {
      return false;
    }
    if (((other.getAutoScalingRole() == null ? 1 : 0) ^ (getAutoScalingRole() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAutoScalingRole() != null) && (!other.getAutoScalingRole().equals(getAutoScalingRole()))) {
      return false;
    }
    if (((other.getScaleDownBehavior() == null ? 1 : 0) ^ (getScaleDownBehavior() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getScaleDownBehavior() != null) && (!other.getScaleDownBehavior().equals(getScaleDownBehavior()))) {
      return false;
    }
    if (((other.getCustomAmiId() == null ? 1 : 0) ^ (getCustomAmiId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomAmiId() != null) && (!other.getCustomAmiId().equals(getCustomAmiId()))) {
      return false;
    }
    if (((other.getEbsRootVolumeSize() == null ? 1 : 0) ^ (getEbsRootVolumeSize() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEbsRootVolumeSize() != null) && (!other.getEbsRootVolumeSize().equals(getEbsRootVolumeSize()))) {
      return false;
    }
    if (((other.getRepoUpgradeOnBoot() == null ? 1 : 0) ^ (getRepoUpgradeOnBoot() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRepoUpgradeOnBoot() != null) && (!other.getRepoUpgradeOnBoot().equals(getRepoUpgradeOnBoot()))) {
      return false;
    }
    if (((other.getKerberosAttributes() == null ? 1 : 0) ^ (getKerberosAttributes() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKerberosAttributes() != null) && (!other.getKerberosAttributes().equals(getKerberosAttributes()))) {
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
    hashCode = 31 * hashCode + (getStatus() == null ? 0 : getStatus().hashCode());
    hashCode = 31 * hashCode + (getEc2InstanceAttributes() == null ? 0 : getEc2InstanceAttributes().hashCode());
    hashCode = 31 * hashCode + (getInstanceCollectionType() == null ? 0 : getInstanceCollectionType().hashCode());
    hashCode = 31 * hashCode + (getLogUri() == null ? 0 : getLogUri().hashCode());
    hashCode = 31 * hashCode + (getRequestedAmiVersion() == null ? 0 : getRequestedAmiVersion().hashCode());
    hashCode = 31 * hashCode + (getRunningAmiVersion() == null ? 0 : getRunningAmiVersion().hashCode());
    hashCode = 31 * hashCode + (getReleaseLabel() == null ? 0 : getReleaseLabel().hashCode());
    hashCode = 31 * hashCode + (getAutoTerminate() == null ? 0 : getAutoTerminate().hashCode());
    hashCode = 31 * hashCode + (getTerminationProtected() == null ? 0 : getTerminationProtected().hashCode());
    hashCode = 31 * hashCode + (getVisibleToAllUsers() == null ? 0 : getVisibleToAllUsers().hashCode());
    hashCode = 31 * hashCode + (getApplications() == null ? 0 : getApplications().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    hashCode = 31 * hashCode + (getServiceRole() == null ? 0 : getServiceRole().hashCode());
    hashCode = 31 * hashCode + (getNormalizedInstanceHours() == null ? 0 : getNormalizedInstanceHours().hashCode());
    hashCode = 31 * hashCode + (getMasterPublicDnsName() == null ? 0 : getMasterPublicDnsName().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    hashCode = 31 * hashCode + (getSecurityConfiguration() == null ? 0 : getSecurityConfiguration().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingRole() == null ? 0 : getAutoScalingRole().hashCode());
    hashCode = 31 * hashCode + (getScaleDownBehavior() == null ? 0 : getScaleDownBehavior().hashCode());
    hashCode = 31 * hashCode + (getCustomAmiId() == null ? 0 : getCustomAmiId().hashCode());
    hashCode = 31 * hashCode + (getEbsRootVolumeSize() == null ? 0 : getEbsRootVolumeSize().hashCode());
    hashCode = 31 * hashCode + (getRepoUpgradeOnBoot() == null ? 0 : getRepoUpgradeOnBoot().hashCode());
    hashCode = 31 * hashCode + (getKerberosAttributes() == null ? 0 : getKerberosAttributes().hashCode());
    return hashCode;
  }
  
  public Cluster clone()
  {
    try
    {
      return (Cluster)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    ClusterMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Cluster
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */