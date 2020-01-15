package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class RunJobFlowRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String name;
  private String logUri;
  private String additionalInfo;
  private String amiVersion;
  private String releaseLabel;
  private JobFlowInstancesConfig instances;
  private SdkInternalList<StepConfig> steps;
  private SdkInternalList<BootstrapActionConfig> bootstrapActions;
  private SdkInternalList<String> supportedProducts;
  private SdkInternalList<SupportedProductConfig> newSupportedProducts;
  private SdkInternalList<Application> applications;
  private SdkInternalList<Configuration> configurations;
  private Boolean visibleToAllUsers;
  private String jobFlowRole;
  private String serviceRole;
  private SdkInternalList<Tag> tags;
  private String securityConfiguration;
  private String autoScalingRole;
  private String scaleDownBehavior;
  private String customAmiId;
  private Integer ebsRootVolumeSize;
  private String repoUpgradeOnBoot;
  private KerberosAttributes kerberosAttributes;
  
  public RunJobFlowRequest() {}
  
  public RunJobFlowRequest(String name, JobFlowInstancesConfig instances)
  {
    setName(name);
    setInstances(instances);
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public RunJobFlowRequest withName(String name)
  {
    setName(name);
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
  
  public RunJobFlowRequest withLogUri(String logUri)
  {
    setLogUri(logUri);
    return this;
  }
  
  public void setAdditionalInfo(String additionalInfo)
  {
    this.additionalInfo = additionalInfo;
  }
  
  public String getAdditionalInfo()
  {
    return additionalInfo;
  }
  
  public RunJobFlowRequest withAdditionalInfo(String additionalInfo)
  {
    setAdditionalInfo(additionalInfo);
    return this;
  }
  
  public void setAmiVersion(String amiVersion)
  {
    this.amiVersion = amiVersion;
  }
  
  public String getAmiVersion()
  {
    return amiVersion;
  }
  
  public RunJobFlowRequest withAmiVersion(String amiVersion)
  {
    setAmiVersion(amiVersion);
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
  
  public RunJobFlowRequest withReleaseLabel(String releaseLabel)
  {
    setReleaseLabel(releaseLabel);
    return this;
  }
  
  public void setInstances(JobFlowInstancesConfig instances)
  {
    this.instances = instances;
  }
  
  public JobFlowInstancesConfig getInstances()
  {
    return instances;
  }
  
  public RunJobFlowRequest withInstances(JobFlowInstancesConfig instances)
  {
    setInstances(instances);
    return this;
  }
  
  public List<StepConfig> getSteps()
  {
    if (steps == null) {
      steps = new SdkInternalList();
    }
    return steps;
  }
  
  public void setSteps(Collection<StepConfig> steps)
  {
    if (steps == null)
    {
      this.steps = null;
      return;
    }
    this.steps = new SdkInternalList(steps);
  }
  
  public RunJobFlowRequest withSteps(StepConfig... steps)
  {
    if (this.steps == null) {
      setSteps(new SdkInternalList(steps.length));
    }
    for (StepConfig ele : steps) {
      this.steps.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withSteps(Collection<StepConfig> steps)
  {
    setSteps(steps);
    return this;
  }
  
  public List<BootstrapActionConfig> getBootstrapActions()
  {
    if (bootstrapActions == null) {
      bootstrapActions = new SdkInternalList();
    }
    return bootstrapActions;
  }
  
  public void setBootstrapActions(Collection<BootstrapActionConfig> bootstrapActions)
  {
    if (bootstrapActions == null)
    {
      this.bootstrapActions = null;
      return;
    }
    this.bootstrapActions = new SdkInternalList(bootstrapActions);
  }
  
  public RunJobFlowRequest withBootstrapActions(BootstrapActionConfig... bootstrapActions)
  {
    if (this.bootstrapActions == null) {
      setBootstrapActions(new SdkInternalList(bootstrapActions.length));
    }
    for (BootstrapActionConfig ele : bootstrapActions) {
      this.bootstrapActions.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withBootstrapActions(Collection<BootstrapActionConfig> bootstrapActions)
  {
    setBootstrapActions(bootstrapActions);
    return this;
  }
  
  public List<String> getSupportedProducts()
  {
    if (supportedProducts == null) {
      supportedProducts = new SdkInternalList();
    }
    return supportedProducts;
  }
  
  public void setSupportedProducts(Collection<String> supportedProducts)
  {
    if (supportedProducts == null)
    {
      this.supportedProducts = null;
      return;
    }
    this.supportedProducts = new SdkInternalList(supportedProducts);
  }
  
  public RunJobFlowRequest withSupportedProducts(String... supportedProducts)
  {
    if (this.supportedProducts == null) {
      setSupportedProducts(new SdkInternalList(supportedProducts.length));
    }
    for (String ele : supportedProducts) {
      this.supportedProducts.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withSupportedProducts(Collection<String> supportedProducts)
  {
    setSupportedProducts(supportedProducts);
    return this;
  }
  
  public List<SupportedProductConfig> getNewSupportedProducts()
  {
    if (newSupportedProducts == null) {
      newSupportedProducts = new SdkInternalList();
    }
    return newSupportedProducts;
  }
  
  public void setNewSupportedProducts(Collection<SupportedProductConfig> newSupportedProducts)
  {
    if (newSupportedProducts == null)
    {
      this.newSupportedProducts = null;
      return;
    }
    this.newSupportedProducts = new SdkInternalList(newSupportedProducts);
  }
  
  public RunJobFlowRequest withNewSupportedProducts(SupportedProductConfig... newSupportedProducts)
  {
    if (this.newSupportedProducts == null) {
      setNewSupportedProducts(new SdkInternalList(newSupportedProducts.length));
    }
    for (SupportedProductConfig ele : newSupportedProducts) {
      this.newSupportedProducts.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withNewSupportedProducts(Collection<SupportedProductConfig> newSupportedProducts)
  {
    setNewSupportedProducts(newSupportedProducts);
    return this;
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
  
  public RunJobFlowRequest withApplications(Application... applications)
  {
    if (this.applications == null) {
      setApplications(new SdkInternalList(applications.length));
    }
    for (Application ele : applications) {
      this.applications.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withApplications(Collection<Application> applications)
  {
    setApplications(applications);
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
  
  public RunJobFlowRequest withConfigurations(Configuration... configurations)
  {
    if (this.configurations == null) {
      setConfigurations(new SdkInternalList(configurations.length));
    }
    for (Configuration ele : configurations) {
      this.configurations.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withConfigurations(Collection<Configuration> configurations)
  {
    setConfigurations(configurations);
    return this;
  }
  
  public void setVisibleToAllUsers(Boolean visibleToAllUsers)
  {
    this.visibleToAllUsers = visibleToAllUsers;
  }
  
  public Boolean getVisibleToAllUsers()
  {
    return visibleToAllUsers;
  }
  
  public RunJobFlowRequest withVisibleToAllUsers(Boolean visibleToAllUsers)
  {
    setVisibleToAllUsers(visibleToAllUsers);
    return this;
  }
  
  public Boolean isVisibleToAllUsers()
  {
    return visibleToAllUsers;
  }
  
  public void setJobFlowRole(String jobFlowRole)
  {
    this.jobFlowRole = jobFlowRole;
  }
  
  public String getJobFlowRole()
  {
    return jobFlowRole;
  }
  
  public RunJobFlowRequest withJobFlowRole(String jobFlowRole)
  {
    setJobFlowRole(jobFlowRole);
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
  
  public RunJobFlowRequest withServiceRole(String serviceRole)
  {
    setServiceRole(serviceRole);
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
  
  public RunJobFlowRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public RunJobFlowRequest withTags(Collection<Tag> tags)
  {
    setTags(tags);
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
  
  public RunJobFlowRequest withSecurityConfiguration(String securityConfiguration)
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
  
  public RunJobFlowRequest withAutoScalingRole(String autoScalingRole)
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
  
  public RunJobFlowRequest withScaleDownBehavior(String scaleDownBehavior)
  {
    setScaleDownBehavior(scaleDownBehavior);
    return this;
  }
  
  public void setScaleDownBehavior(ScaleDownBehavior scaleDownBehavior)
  {
    withScaleDownBehavior(scaleDownBehavior);
  }
  
  public RunJobFlowRequest withScaleDownBehavior(ScaleDownBehavior scaleDownBehavior)
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
  
  public RunJobFlowRequest withCustomAmiId(String customAmiId)
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
  
  public RunJobFlowRequest withEbsRootVolumeSize(Integer ebsRootVolumeSize)
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
  
  public RunJobFlowRequest withRepoUpgradeOnBoot(String repoUpgradeOnBoot)
  {
    setRepoUpgradeOnBoot(repoUpgradeOnBoot);
    return this;
  }
  
  public void setRepoUpgradeOnBoot(RepoUpgradeOnBoot repoUpgradeOnBoot)
  {
    withRepoUpgradeOnBoot(repoUpgradeOnBoot);
  }
  
  public RunJobFlowRequest withRepoUpgradeOnBoot(RepoUpgradeOnBoot repoUpgradeOnBoot)
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
  
  public RunJobFlowRequest withKerberosAttributes(KerberosAttributes kerberosAttributes)
  {
    setKerberosAttributes(kerberosAttributes);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getLogUri() != null) {
      sb.append("LogUri: ").append(getLogUri()).append(",");
    }
    if (getAdditionalInfo() != null) {
      sb.append("AdditionalInfo: ").append(getAdditionalInfo()).append(",");
    }
    if (getAmiVersion() != null) {
      sb.append("AmiVersion: ").append(getAmiVersion()).append(",");
    }
    if (getReleaseLabel() != null) {
      sb.append("ReleaseLabel: ").append(getReleaseLabel()).append(",");
    }
    if (getInstances() != null) {
      sb.append("Instances: ").append(getInstances()).append(",");
    }
    if (getSteps() != null) {
      sb.append("Steps: ").append(getSteps()).append(",");
    }
    if (getBootstrapActions() != null) {
      sb.append("BootstrapActions: ").append(getBootstrapActions()).append(",");
    }
    if (getSupportedProducts() != null) {
      sb.append("SupportedProducts: ").append(getSupportedProducts()).append(",");
    }
    if (getNewSupportedProducts() != null) {
      sb.append("NewSupportedProducts: ").append(getNewSupportedProducts()).append(",");
    }
    if (getApplications() != null) {
      sb.append("Applications: ").append(getApplications()).append(",");
    }
    if (getConfigurations() != null) {
      sb.append("Configurations: ").append(getConfigurations()).append(",");
    }
    if (getVisibleToAllUsers() != null) {
      sb.append("VisibleToAllUsers: ").append(getVisibleToAllUsers()).append(",");
    }
    if (getJobFlowRole() != null) {
      sb.append("JobFlowRole: ").append(getJobFlowRole()).append(",");
    }
    if (getServiceRole() != null) {
      sb.append("ServiceRole: ").append(getServiceRole()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags()).append(",");
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
    if (!(obj instanceof RunJobFlowRequest)) {
      return false;
    }
    RunJobFlowRequest other = (RunJobFlowRequest)obj;
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getLogUri() == null ? 1 : 0) ^ (getLogUri() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLogUri() != null) && (!other.getLogUri().equals(getLogUri()))) {
      return false;
    }
    if (((other.getAdditionalInfo() == null ? 1 : 0) ^ (getAdditionalInfo() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAdditionalInfo() != null) && (!other.getAdditionalInfo().equals(getAdditionalInfo()))) {
      return false;
    }
    if (((other.getAmiVersion() == null ? 1 : 0) ^ (getAmiVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAmiVersion() != null) && (!other.getAmiVersion().equals(getAmiVersion()))) {
      return false;
    }
    if (((other.getReleaseLabel() == null ? 1 : 0) ^ (getReleaseLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReleaseLabel() != null) && (!other.getReleaseLabel().equals(getReleaseLabel()))) {
      return false;
    }
    if (((other.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getInstances() != null) && (!other.getInstances().equals(getInstances()))) {
      return false;
    }
    if (((other.getSteps() == null ? 1 : 0) ^ (getSteps() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSteps() != null) && (!other.getSteps().equals(getSteps()))) {
      return false;
    }
    if (((other.getBootstrapActions() == null ? 1 : 0) ^ (getBootstrapActions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBootstrapActions() != null) && (!other.getBootstrapActions().equals(getBootstrapActions()))) {
      return false;
    }
    if (((other.getSupportedProducts() == null ? 1 : 0) ^ (getSupportedProducts() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSupportedProducts() != null) && (!other.getSupportedProducts().equals(getSupportedProducts()))) {
      return false;
    }
    if (((other.getNewSupportedProducts() == null ? 1 : 0) ^ (getNewSupportedProducts() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewSupportedProducts() != null) && (!other.getNewSupportedProducts().equals(getNewSupportedProducts()))) {
      return false;
    }
    if (((other.getApplications() == null ? 1 : 0) ^ (getApplications() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getApplications() != null) && (!other.getApplications().equals(getApplications()))) {
      return false;
    }
    if (((other.getConfigurations() == null ? 1 : 0) ^ (getConfigurations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConfigurations() != null) && (!other.getConfigurations().equals(getConfigurations()))) {
      return false;
    }
    if (((other.getVisibleToAllUsers() == null ? 1 : 0) ^ (getVisibleToAllUsers() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVisibleToAllUsers() != null) && (!other.getVisibleToAllUsers().equals(getVisibleToAllUsers()))) {
      return false;
    }
    if (((other.getJobFlowRole() == null ? 1 : 0) ^ (getJobFlowRole() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowRole() != null) && (!other.getJobFlowRole().equals(getJobFlowRole()))) {
      return false;
    }
    if (((other.getServiceRole() == null ? 1 : 0) ^ (getServiceRole() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceRole() != null) && (!other.getServiceRole().equals(getServiceRole()))) {
      return false;
    }
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
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
    
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getLogUri() == null ? 0 : getLogUri().hashCode());
    hashCode = 31 * hashCode + (getAdditionalInfo() == null ? 0 : getAdditionalInfo().hashCode());
    hashCode = 31 * hashCode + (getAmiVersion() == null ? 0 : getAmiVersion().hashCode());
    hashCode = 31 * hashCode + (getReleaseLabel() == null ? 0 : getReleaseLabel().hashCode());
    hashCode = 31 * hashCode + (getInstances() == null ? 0 : getInstances().hashCode());
    hashCode = 31 * hashCode + (getSteps() == null ? 0 : getSteps().hashCode());
    hashCode = 31 * hashCode + (getBootstrapActions() == null ? 0 : getBootstrapActions().hashCode());
    hashCode = 31 * hashCode + (getSupportedProducts() == null ? 0 : getSupportedProducts().hashCode());
    hashCode = 31 * hashCode + (getNewSupportedProducts() == null ? 0 : getNewSupportedProducts().hashCode());
    hashCode = 31 * hashCode + (getApplications() == null ? 0 : getApplications().hashCode());
    hashCode = 31 * hashCode + (getConfigurations() == null ? 0 : getConfigurations().hashCode());
    hashCode = 31 * hashCode + (getVisibleToAllUsers() == null ? 0 : getVisibleToAllUsers().hashCode());
    hashCode = 31 * hashCode + (getJobFlowRole() == null ? 0 : getJobFlowRole().hashCode());
    hashCode = 31 * hashCode + (getServiceRole() == null ? 0 : getServiceRole().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    hashCode = 31 * hashCode + (getSecurityConfiguration() == null ? 0 : getSecurityConfiguration().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingRole() == null ? 0 : getAutoScalingRole().hashCode());
    hashCode = 31 * hashCode + (getScaleDownBehavior() == null ? 0 : getScaleDownBehavior().hashCode());
    hashCode = 31 * hashCode + (getCustomAmiId() == null ? 0 : getCustomAmiId().hashCode());
    hashCode = 31 * hashCode + (getEbsRootVolumeSize() == null ? 0 : getEbsRootVolumeSize().hashCode());
    hashCode = 31 * hashCode + (getRepoUpgradeOnBoot() == null ? 0 : getRepoUpgradeOnBoot().hashCode());
    hashCode = 31 * hashCode + (getKerberosAttributes() == null ? 0 : getKerberosAttributes().hashCode());
    return hashCode;
  }
  
  public RunJobFlowRequest clone()
  {
    return (RunJobFlowRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */