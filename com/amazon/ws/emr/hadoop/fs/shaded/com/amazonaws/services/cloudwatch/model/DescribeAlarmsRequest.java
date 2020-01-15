package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeAlarmsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> alarmNames;
  private String alarmNamePrefix;
  private String stateValue;
  private String actionPrefix;
  private Integer maxRecords;
  private String nextToken;
  
  public List<String> getAlarmNames()
  {
    if (alarmNames == null) {
      alarmNames = new SdkInternalList();
    }
    return alarmNames;
  }
  
  public void setAlarmNames(Collection<String> alarmNames)
  {
    if (alarmNames == null)
    {
      this.alarmNames = null;
      return;
    }
    this.alarmNames = new SdkInternalList(alarmNames);
  }
  
  public DescribeAlarmsRequest withAlarmNames(String... alarmNames)
  {
    if (this.alarmNames == null) {
      setAlarmNames(new SdkInternalList(alarmNames.length));
    }
    for (String ele : alarmNames) {
      this.alarmNames.add(ele);
    }
    return this;
  }
  
  public DescribeAlarmsRequest withAlarmNames(Collection<String> alarmNames)
  {
    setAlarmNames(alarmNames);
    return this;
  }
  
  public void setAlarmNamePrefix(String alarmNamePrefix)
  {
    this.alarmNamePrefix = alarmNamePrefix;
  }
  
  public String getAlarmNamePrefix()
  {
    return alarmNamePrefix;
  }
  
  public DescribeAlarmsRequest withAlarmNamePrefix(String alarmNamePrefix)
  {
    setAlarmNamePrefix(alarmNamePrefix);
    return this;
  }
  
  public void setStateValue(String stateValue)
  {
    this.stateValue = stateValue;
  }
  
  public String getStateValue()
  {
    return stateValue;
  }
  
  public DescribeAlarmsRequest withStateValue(String stateValue)
  {
    setStateValue(stateValue);
    return this;
  }
  
  public void setStateValue(StateValue stateValue)
  {
    withStateValue(stateValue);
  }
  
  public DescribeAlarmsRequest withStateValue(StateValue stateValue)
  {
    this.stateValue = stateValue.toString();
    return this;
  }
  
  public void setActionPrefix(String actionPrefix)
  {
    this.actionPrefix = actionPrefix;
  }
  
  public String getActionPrefix()
  {
    return actionPrefix;
  }
  
  public DescribeAlarmsRequest withActionPrefix(String actionPrefix)
  {
    setActionPrefix(actionPrefix);
    return this;
  }
  
  public void setMaxRecords(Integer maxRecords)
  {
    this.maxRecords = maxRecords;
  }
  
  public Integer getMaxRecords()
  {
    return maxRecords;
  }
  
  public DescribeAlarmsRequest withMaxRecords(Integer maxRecords)
  {
    setMaxRecords(maxRecords);
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
  
  public DescribeAlarmsRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmNames() != null) {
      sb.append("AlarmNames: ").append(getAlarmNames()).append(",");
    }
    if (getAlarmNamePrefix() != null) {
      sb.append("AlarmNamePrefix: ").append(getAlarmNamePrefix()).append(",");
    }
    if (getStateValue() != null) {
      sb.append("StateValue: ").append(getStateValue()).append(",");
    }
    if (getActionPrefix() != null) {
      sb.append("ActionPrefix: ").append(getActionPrefix()).append(",");
    }
    if (getMaxRecords() != null) {
      sb.append("MaxRecords: ").append(getMaxRecords()).append(",");
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
    if (!(obj instanceof DescribeAlarmsRequest)) {
      return false;
    }
    DescribeAlarmsRequest other = (DescribeAlarmsRequest)obj;
    if (((other.getAlarmNames() == null ? 1 : 0) ^ (getAlarmNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmNames() != null) && (!other.getAlarmNames().equals(getAlarmNames()))) {
      return false;
    }
    if (((other.getAlarmNamePrefix() == null ? 1 : 0) ^ (getAlarmNamePrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmNamePrefix() != null) && (!other.getAlarmNamePrefix().equals(getAlarmNamePrefix()))) {
      return false;
    }
    if (((other.getStateValue() == null ? 1 : 0) ^ (getStateValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateValue() != null) && (!other.getStateValue().equals(getStateValue()))) {
      return false;
    }
    if (((other.getActionPrefix() == null ? 1 : 0) ^ (getActionPrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getActionPrefix() != null) && (!other.getActionPrefix().equals(getActionPrefix()))) {
      return false;
    }
    if (((other.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxRecords() != null) && (!other.getMaxRecords().equals(getMaxRecords()))) {
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
    
    hashCode = 31 * hashCode + (getAlarmNames() == null ? 0 : getAlarmNames().hashCode());
    hashCode = 31 * hashCode + (getAlarmNamePrefix() == null ? 0 : getAlarmNamePrefix().hashCode());
    hashCode = 31 * hashCode + (getStateValue() == null ? 0 : getStateValue().hashCode());
    hashCode = 31 * hashCode + (getActionPrefix() == null ? 0 : getActionPrefix().hashCode());
    hashCode = 31 * hashCode + (getMaxRecords() == null ? 0 : getMaxRecords().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public DescribeAlarmsRequest clone()
  {
    return (DescribeAlarmsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */