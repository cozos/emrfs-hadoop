package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmHistoryResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<AlarmHistoryItem> alarmHistoryItems;
  private String nextToken;
  
  public List<AlarmHistoryItem> getAlarmHistoryItems()
  {
    if (alarmHistoryItems == null) {
      alarmHistoryItems = new SdkInternalList();
    }
    return alarmHistoryItems;
  }
  
  public void setAlarmHistoryItems(Collection<AlarmHistoryItem> alarmHistoryItems)
  {
    if (alarmHistoryItems == null)
    {
      this.alarmHistoryItems = null;
      return;
    }
    this.alarmHistoryItems = new SdkInternalList(alarmHistoryItems);
  }
  
  public DescribeAlarmHistoryResult withAlarmHistoryItems(AlarmHistoryItem... alarmHistoryItems)
  {
    if (this.alarmHistoryItems == null) {
      setAlarmHistoryItems(new SdkInternalList(alarmHistoryItems.length));
    }
    for (AlarmHistoryItem ele : alarmHistoryItems) {
      this.alarmHistoryItems.add(ele);
    }
    return this;
  }
  
  public DescribeAlarmHistoryResult withAlarmHistoryItems(Collection<AlarmHistoryItem> alarmHistoryItems)
  {
    setAlarmHistoryItems(alarmHistoryItems);
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
  
  public DescribeAlarmHistoryResult withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmHistoryItems() != null) {
      sb.append("AlarmHistoryItems: ").append(getAlarmHistoryItems()).append(",");
    }
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken());
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
    if (!(obj instanceof DescribeAlarmHistoryResult)) {
      return false;
    }
    DescribeAlarmHistoryResult other = (DescribeAlarmHistoryResult)obj;
    if (((other.getAlarmHistoryItems() == null ? 1 : 0) ^ (getAlarmHistoryItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmHistoryItems() != null) && (!other.getAlarmHistoryItems().equals(getAlarmHistoryItems()))) {
      return false;
    }
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAlarmHistoryItems() == null ? 0 : getAlarmHistoryItems().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public DescribeAlarmHistoryResult clone()
  {
    try
    {
      return (DescribeAlarmHistoryResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */