package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class AddPermissionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private String label;
  private SdkInternalList<String> aWSAccountIds;
  private SdkInternalList<String> actions;
  
  public AddPermissionRequest() {}
  
  public AddPermissionRequest(String queueUrl, String label, List<String> aWSAccountIds, List<String> actions)
  {
    setQueueUrl(queueUrl);
    setLabel(label);
    setAWSAccountIds(aWSAccountIds);
    setActions(actions);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public AddPermissionRequest withQueueUrl(String queueUrl)
  {
    setQueueUrl(queueUrl);
    return this;
  }
  
  public void setLabel(String label)
  {
    this.label = label;
  }
  
  public String getLabel()
  {
    return label;
  }
  
  public AddPermissionRequest withLabel(String label)
  {
    setLabel(label);
    return this;
  }
  
  public List<String> getAWSAccountIds()
  {
    if (aWSAccountIds == null) {
      aWSAccountIds = new SdkInternalList();
    }
    return aWSAccountIds;
  }
  
  public void setAWSAccountIds(Collection<String> aWSAccountIds)
  {
    if (aWSAccountIds == null)
    {
      this.aWSAccountIds = null;
      return;
    }
    this.aWSAccountIds = new SdkInternalList(aWSAccountIds);
  }
  
  public AddPermissionRequest withAWSAccountIds(String... aWSAccountIds)
  {
    if (this.aWSAccountIds == null) {
      setAWSAccountIds(new SdkInternalList(aWSAccountIds.length));
    }
    for (String ele : aWSAccountIds) {
      this.aWSAccountIds.add(ele);
    }
    return this;
  }
  
  public AddPermissionRequest withAWSAccountIds(Collection<String> aWSAccountIds)
  {
    setAWSAccountIds(aWSAccountIds);
    return this;
  }
  
  public List<String> getActions()
  {
    if (actions == null) {
      actions = new SdkInternalList();
    }
    return actions;
  }
  
  public void setActions(Collection<String> actions)
  {
    if (actions == null)
    {
      this.actions = null;
      return;
    }
    this.actions = new SdkInternalList(actions);
  }
  
  public AddPermissionRequest withActions(String... actions)
  {
    if (this.actions == null) {
      setActions(new SdkInternalList(actions.length));
    }
    for (String ele : actions) {
      this.actions.add(ele);
    }
    return this;
  }
  
  public AddPermissionRequest withActions(Collection<String> actions)
  {
    setActions(actions);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrl() != null) {
      sb.append("QueueUrl: ").append(getQueueUrl()).append(",");
    }
    if (getLabel() != null) {
      sb.append("Label: ").append(getLabel()).append(",");
    }
    if (getAWSAccountIds() != null) {
      sb.append("AWSAccountIds: ").append(getAWSAccountIds()).append(",");
    }
    if (getActions() != null) {
      sb.append("Actions: ").append(getActions());
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
    if (!(obj instanceof AddPermissionRequest)) {
      return false;
    }
    AddPermissionRequest other = (AddPermissionRequest)obj;
    if (((other.getQueueUrl() == null ? 1 : 0) ^ (getQueueUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrl() != null) && (!other.getQueueUrl().equals(getQueueUrl()))) {
      return false;
    }
    if (((other.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLabel() != null) && (!other.getLabel().equals(getLabel()))) {
      return false;
    }
    if (((other.getAWSAccountIds() == null ? 1 : 0) ^ (getAWSAccountIds() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAWSAccountIds() != null) && (!other.getAWSAccountIds().equals(getAWSAccountIds()))) {
      return false;
    }
    if (((other.getActions() == null ? 1 : 0) ^ (getActions() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getActions() != null) && (!other.getActions().equals(getActions()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getLabel() == null ? 0 : getLabel().hashCode());
    hashCode = 31 * hashCode + (getAWSAccountIds() == null ? 0 : getAWSAccountIds().hashCode());
    hashCode = 31 * hashCode + (getActions() == null ? 0 : getActions().hashCode());
    return hashCode;
  }
  
  public AddPermissionRequest clone()
  {
    return (AddPermissionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.AddPermissionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */