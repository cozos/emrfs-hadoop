package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.JobFlowDetailMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class JobFlowDetail
  implements Serializable, Cloneable, StructuredPojo
{
  private String jobFlowId;
  private String name;
  private String logUri;
  private String amiVersion;
  private JobFlowExecutionStatusDetail executionStatusDetail;
  private JobFlowInstancesDetail instances;
  private SdkInternalList<StepDetail> steps;
  private SdkInternalList<BootstrapActionDetail> bootstrapActions;
  private SdkInternalList<String> supportedProducts;
  private Boolean visibleToAllUsers;
  private String jobFlowRole;
  private String serviceRole;
  private String autoScalingRole;
  private String scaleDownBehavior;
  
  public JobFlowDetail() {}
  
  public JobFlowDetail(String jobFlowId, String name, JobFlowExecutionStatusDetail executionStatusDetail, JobFlowInstancesDetail instances)
  {
    setJobFlowId(jobFlowId);
    setName(name);
    setExecutionStatusDetail(executionStatusDetail);
    setInstances(instances);
  }
  
  public void setJobFlowId(String jobFlowId)
  {
    this.jobFlowId = jobFlowId;
  }
  
  public String getJobFlowId()
  {
    return jobFlowId;
  }
  
  public JobFlowDetail withJobFlowId(String jobFlowId)
  {
    setJobFlowId(jobFlowId);
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
  
  public JobFlowDetail withName(String name)
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
  
  public JobFlowDetail withLogUri(String logUri)
  {
    setLogUri(logUri);
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
  
  public JobFlowDetail withAmiVersion(String amiVersion)
  {
    setAmiVersion(amiVersion);
    return this;
  }
  
  public void setExecutionStatusDetail(JobFlowExecutionStatusDetail executionStatusDetail)
  {
    this.executionStatusDetail = executionStatusDetail;
  }
  
  public JobFlowExecutionStatusDetail getExecutionStatusDetail()
  {
    return executionStatusDetail;
  }
  
  public JobFlowDetail withExecutionStatusDetail(JobFlowExecutionStatusDetail executionStatusDetail)
  {
    setExecutionStatusDetail(executionStatusDetail);
    return this;
  }
  
  public void setInstances(JobFlowInstancesDetail instances)
  {
    this.instances = instances;
  }
  
  public JobFlowInstancesDetail getInstances()
  {
    return instances;
  }
  
  public JobFlowDetail withInstances(JobFlowInstancesDetail instances)
  {
    setInstances(instances);
    return this;
  }
  
  public List<StepDetail> getSteps()
  {
    if (steps == null) {
      steps = new SdkInternalList();
    }
    return steps;
  }
  
  public void setSteps(Collection<StepDetail> steps)
  {
    if (steps == null)
    {
      this.steps = null;
      return;
    }
    this.steps = new SdkInternalList(steps);
  }
  
  public JobFlowDetail withSteps(StepDetail... steps)
  {
    if (this.steps == null) {
      setSteps(new SdkInternalList(steps.length));
    }
    for (StepDetail ele : steps) {
      this.steps.add(ele);
    }
    return this;
  }
  
  public JobFlowDetail withSteps(Collection<StepDetail> steps)
  {
    setSteps(steps);
    return this;
  }
  
  public List<BootstrapActionDetail> getBootstrapActions()
  {
    if (bootstrapActions == null) {
      bootstrapActions = new SdkInternalList();
    }
    return bootstrapActions;
  }
  
  public void setBootstrapActions(Collection<BootstrapActionDetail> bootstrapActions)
  {
    if (bootstrapActions == null)
    {
      this.bootstrapActions = null;
      return;
    }
    this.bootstrapActions = new SdkInternalList(bootstrapActions);
  }
  
  public JobFlowDetail withBootstrapActions(BootstrapActionDetail... bootstrapActions)
  {
    if (this.bootstrapActions == null) {
      setBootstrapActions(new SdkInternalList(bootstrapActions.length));
    }
    for (BootstrapActionDetail ele : bootstrapActions) {
      this.bootstrapActions.add(ele);
    }
    return this;
  }
  
  public JobFlowDetail withBootstrapActions(Collection<BootstrapActionDetail> bootstrapActions)
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
  
  public JobFlowDetail withSupportedProducts(String... supportedProducts)
  {
    if (this.supportedProducts == null) {
      setSupportedProducts(new SdkInternalList(supportedProducts.length));
    }
    for (String ele : supportedProducts) {
      this.supportedProducts.add(ele);
    }
    return this;
  }
  
  public JobFlowDetail withSupportedProducts(Collection<String> supportedProducts)
  {
    setSupportedProducts(supportedProducts);
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
  
  public JobFlowDetail withVisibleToAllUsers(Boolean visibleToAllUsers)
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
  
  public JobFlowDetail withJobFlowRole(String jobFlowRole)
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
  
  public JobFlowDetail withServiceRole(String serviceRole)
  {
    setServiceRole(serviceRole);
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
  
  public JobFlowDetail withAutoScalingRole(String autoScalingRole)
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
  
  public JobFlowDetail withScaleDownBehavior(String scaleDownBehavior)
  {
    setScaleDownBehavior(scaleDownBehavior);
    return this;
  }
  
  public void setScaleDownBehavior(ScaleDownBehavior scaleDownBehavior)
  {
    withScaleDownBehavior(scaleDownBehavior);
  }
  
  public JobFlowDetail withScaleDownBehavior(ScaleDownBehavior scaleDownBehavior)
  {
    this.scaleDownBehavior = scaleDownBehavior.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobFlowId() != null) {
      sb.append("JobFlowId: ").append(getJobFlowId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getLogUri() != null) {
      sb.append("LogUri: ").append(getLogUri()).append(",");
    }
    if (getAmiVersion() != null) {
      sb.append("AmiVersion: ").append(getAmiVersion()).append(",");
    }
    if (getExecutionStatusDetail() != null) {
      sb.append("ExecutionStatusDetail: ").append(getExecutionStatusDetail()).append(",");
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
    if (getVisibleToAllUsers() != null) {
      sb.append("VisibleToAllUsers: ").append(getVisibleToAllUsers()).append(",");
    }
    if (getJobFlowRole() != null) {
      sb.append("JobFlowRole: ").append(getJobFlowRole()).append(",");
    }
    if (getServiceRole() != null) {
      sb.append("ServiceRole: ").append(getServiceRole()).append(",");
    }
    if (getAutoScalingRole() != null) {
      sb.append("AutoScalingRole: ").append(getAutoScalingRole()).append(",");
    }
    if (getScaleDownBehavior() != null) {
      sb.append("ScaleDownBehavior: ").append(getScaleDownBehavior());
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
    if (!(obj instanceof JobFlowDetail)) {
      return false;
    }
    JobFlowDetail other = (JobFlowDetail)obj;
    if (((other.getJobFlowId() == null ? 1 : 0) ^ (getJobFlowId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobFlowId() != null) && (!other.getJobFlowId().equals(getJobFlowId()))) {
      return false;
    }
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
    if (((other.getAmiVersion() == null ? 1 : 0) ^ (getAmiVersion() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAmiVersion() != null) && (!other.getAmiVersion().equals(getAmiVersion()))) {
      return false;
    }
    if (((other.getExecutionStatusDetail() == null ? 1 : 0) ^ (getExecutionStatusDetail() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExecutionStatusDetail() != null) && (!other.getExecutionStatusDetail().equals(getExecutionStatusDetail()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobFlowId() == null ? 0 : getJobFlowId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getLogUri() == null ? 0 : getLogUri().hashCode());
    hashCode = 31 * hashCode + (getAmiVersion() == null ? 0 : getAmiVersion().hashCode());
    hashCode = 31 * hashCode + (getExecutionStatusDetail() == null ? 0 : getExecutionStatusDetail().hashCode());
    hashCode = 31 * hashCode + (getInstances() == null ? 0 : getInstances().hashCode());
    hashCode = 31 * hashCode + (getSteps() == null ? 0 : getSteps().hashCode());
    hashCode = 31 * hashCode + (getBootstrapActions() == null ? 0 : getBootstrapActions().hashCode());
    hashCode = 31 * hashCode + (getSupportedProducts() == null ? 0 : getSupportedProducts().hashCode());
    hashCode = 31 * hashCode + (getVisibleToAllUsers() == null ? 0 : getVisibleToAllUsers().hashCode());
    hashCode = 31 * hashCode + (getJobFlowRole() == null ? 0 : getJobFlowRole().hashCode());
    hashCode = 31 * hashCode + (getServiceRole() == null ? 0 : getServiceRole().hashCode());
    hashCode = 31 * hashCode + (getAutoScalingRole() == null ? 0 : getAutoScalingRole().hashCode());
    hashCode = 31 * hashCode + (getScaleDownBehavior() == null ? 0 : getScaleDownBehavior().hashCode());
    return hashCode;
  }
  
  public JobFlowDetail clone()
  {
    try
    {
      return (JobFlowDetail)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    JobFlowDetailMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.JobFlowDetail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */