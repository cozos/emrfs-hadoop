package com.amazonaws.services.sqs.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ListDeadLetterSourceQueuesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<String> queueUrls;
  
  public List<String> getQueueUrls()
  {
    if (queueUrls == null) {
      queueUrls = new SdkInternalList();
    }
    return queueUrls;
  }
  
  public void setQueueUrls(Collection<String> queueUrls)
  {
    if (queueUrls == null)
    {
      this.queueUrls = null;
      return;
    }
    this.queueUrls = new SdkInternalList(queueUrls);
  }
  
  public ListDeadLetterSourceQueuesResult withQueueUrls(String... queueUrls)
  {
    if (this.queueUrls == null) {
      setQueueUrls(new SdkInternalList(queueUrls.length));
    }
    for (String ele : queueUrls) {
      this.queueUrls.add(ele);
    }
    return this;
  }
  
  public ListDeadLetterSourceQueuesResult withQueueUrls(Collection<String> queueUrls)
  {
    setQueueUrls(queueUrls);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getQueueUrls() != null) {
      sb.append("QueueUrls: ").append(getQueueUrls());
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
    if (!(obj instanceof ListDeadLetterSourceQueuesResult)) {
      return false;
    }
    ListDeadLetterSourceQueuesResult other = (ListDeadLetterSourceQueuesResult)obj;
    if (((other.getQueueUrls() == null ? 1 : 0) ^ (getQueueUrls() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getQueueUrls() != null) && (!other.getQueueUrls().equals(getQueueUrls()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getQueueUrls() == null ? 0 : getQueueUrls().hashCode());
    return hashCode;
  }
  
  public ListDeadLetterSourceQueuesResult clone()
  {
    try
    {
      return (ListDeadLetterSourceQueuesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */