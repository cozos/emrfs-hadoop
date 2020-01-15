package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RemovePermissionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueUrl;
  private String label;
  
  public RemovePermissionRequest() {}
  
  public RemovePermissionRequest(String queueUrl, String label)
  {
    setQueueUrl(queueUrl);
    setLabel(label);
  }
  
  public void setQueueUrl(String queueUrl)
  {
    this.queueUrl = queueUrl;
  }
  
  public String getQueueUrl()
  {
    return queueUrl;
  }
  
  public RemovePermissionRequest withQueueUrl(String queueUrl)
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
  
  public RemovePermissionRequest withLabel(String label)
  {
    setLabel(label);
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
      sb.append("Label: ").append(getLabel());
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
    if (!(obj instanceof RemovePermissionRequest)) {
      return false;
    }
    RemovePermissionRequest other = (RemovePermissionRequest)obj;
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrl() == null ? 0 : getQueueUrl().hashCode());
    hashCode = 31 * hashCode + (getLabel() == null ? 0 : getLabel().hashCode());
    return hashCode;
  }
  
  public RemovePermissionRequest clone()
  {
    return (RemovePermissionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.RemovePermissionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */