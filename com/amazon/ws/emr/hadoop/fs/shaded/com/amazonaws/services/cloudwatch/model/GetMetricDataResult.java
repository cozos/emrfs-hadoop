package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class GetMetricDataResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<MetricDataResult> metricDataResults;
  private String nextToken;
  private SdkInternalList<MessageData> messages;
  
  public List<MetricDataResult> getMetricDataResults()
  {
    if (metricDataResults == null) {
      metricDataResults = new SdkInternalList();
    }
    return metricDataResults;
  }
  
  public void setMetricDataResults(Collection<MetricDataResult> metricDataResults)
  {
    if (metricDataResults == null)
    {
      this.metricDataResults = null;
      return;
    }
    this.metricDataResults = new SdkInternalList(metricDataResults);
  }
  
  public GetMetricDataResult withMetricDataResults(MetricDataResult... metricDataResults)
  {
    if (this.metricDataResults == null) {
      setMetricDataResults(new SdkInternalList(metricDataResults.length));
    }
    for (MetricDataResult ele : metricDataResults) {
      this.metricDataResults.add(ele);
    }
    return this;
  }
  
  public GetMetricDataResult withMetricDataResults(Collection<MetricDataResult> metricDataResults)
  {
    setMetricDataResults(metricDataResults);
    return this;
  }
  
  public void setNextToken(String nextToken)
  {
    this.nextToken = nextToken;
  }
  
  public String getNextToken()
  {
    return nextToken;
  }
  
  public GetMetricDataResult withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public List<MessageData> getMessages()
  {
    if (messages == null) {
      messages = new SdkInternalList();
    }
    return messages;
  }
  
  public void setMessages(Collection<MessageData> messages)
  {
    if (messages == null)
    {
      this.messages = null;
      return;
    }
    this.messages = new SdkInternalList(messages);
  }
  
  public GetMetricDataResult withMessages(MessageData... messages)
  {
    if (this.messages == null) {
      setMessages(new SdkInternalList(messages.length));
    }
    for (MessageData ele : messages) {
      this.messages.add(ele);
    }
    return this;
  }
  
  public GetMetricDataResult withMessages(Collection<MessageData> messages)
  {
    setMessages(messages);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMetricDataResults() != null) {
      sb.append("MetricDataResults: ").append(getMetricDataResults()).append(",");
    }
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken()).append(",");
    }
    if (getMessages() != null) {
      sb.append("Messages: ").append(getMessages());
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
    if (!(obj instanceof GetMetricDataResult)) {
      return false;
    }
    GetMetricDataResult other = (GetMetricDataResult)obj;
    if (((other.getMetricDataResults() == null ? 1 : 0) ^ (getMetricDataResults() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMetricDataResults() != null) && (!other.getMetricDataResults().equals(getMetricDataResults()))) {
      return false;
    }
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
      return false;
    }
    if (((other.getMessages() == null ? 1 : 0) ^ (getMessages() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessages() != null) && (!other.getMessages().equals(getMessages()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMetricDataResults() == null ? 0 : getMetricDataResults().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    hashCode = 31 * hashCode + (getMessages() == null ? 0 : getMessages().hashCode());
    return hashCode;
  }
  
  public GetMetricDataResult clone()
  {
    try
    {
      return (GetMetricDataResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */