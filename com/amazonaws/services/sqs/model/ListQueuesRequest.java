package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListQueuesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueNamePrefix;
  
  public ListQueuesRequest() {}
  
  public ListQueuesRequest(String queueNamePrefix)
  {
    setQueueNamePrefix(queueNamePrefix);
  }
  
  public void setQueueNamePrefix(String queueNamePrefix)
  {
    this.queueNamePrefix = queueNamePrefix;
  }
  
  public String getQueueNamePrefix()
  {
    return queueNamePrefix;
  }
  
  public ListQueuesRequest withQueueNamePrefix(String queueNamePrefix)
  {
    setQueueNamePrefix(queueNamePrefix);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueNamePrefix() != null) {
      sb.append("QueueNamePrefix: ").append(getQueueNamePrefix());
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
    if (!(obj instanceof ListQueuesRequest)) {
      return false;
    }
    ListQueuesRequest other = (ListQueuesRequest)obj;
    if (((other.getQueueNamePrefix() == null ? 1 : 0) ^ (getQueueNamePrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueNamePrefix() != null) && (!other.getQueueNamePrefix().equals(getQueueNamePrefix()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueNamePrefix() == null ? 0 : getQueueNamePrefix().hashCode());
    return hashCode;
  }
  
  public ListQueuesRequest clone()
  {
    return (ListQueuesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ListQueuesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */