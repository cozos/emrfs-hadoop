package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetQueueUrlRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String queueName;
  private String queueOwnerAWSAccountId;
  
  public GetQueueUrlRequest() {}
  
  public GetQueueUrlRequest(String queueName)
  {
    setQueueName(queueName);
  }
  
  public void setQueueName(String queueName)
  {
    this.queueName = queueName;
  }
  
  public String getQueueName()
  {
    return queueName;
  }
  
  public GetQueueUrlRequest withQueueName(String queueName)
  {
    setQueueName(queueName);
    return this;
  }
  
  public void setQueueOwnerAWSAccountId(String queueOwnerAWSAccountId)
  {
    this.queueOwnerAWSAccountId = queueOwnerAWSAccountId;
  }
  
  public String getQueueOwnerAWSAccountId()
  {
    return queueOwnerAWSAccountId;
  }
  
  public GetQueueUrlRequest withQueueOwnerAWSAccountId(String queueOwnerAWSAccountId)
  {
    setQueueOwnerAWSAccountId(queueOwnerAWSAccountId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueName() != null) {
      sb.append("QueueName: ").append(getQueueName()).append(",");
    }
    if (getQueueOwnerAWSAccountId() != null) {
      sb.append("QueueOwnerAWSAccountId: ").append(getQueueOwnerAWSAccountId());
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
    if (!(obj instanceof GetQueueUrlRequest)) {
      return false;
    }
    GetQueueUrlRequest other = (GetQueueUrlRequest)obj;
    if (((other.getQueueName() == null ? 1 : 0) ^ (getQueueName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueName() != null) && (!other.getQueueName().equals(getQueueName()))) {
      return false;
    }
    if (((other.getQueueOwnerAWSAccountId() == null ? 1 : 0) ^ (getQueueOwnerAWSAccountId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueOwnerAWSAccountId() != null) && (!other.getQueueOwnerAWSAccountId().equals(getQueueOwnerAWSAccountId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueName() == null ? 0 : getQueueName().hashCode());
    hashCode = 31 * hashCode + (getQueueOwnerAWSAccountId() == null ? 0 : getQueueOwnerAWSAccountId().hashCode());
    return hashCode;
  }
  
  public GetQueueUrlRequest clone()
  {
    return (GetQueueUrlRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.GetQueueUrlRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */