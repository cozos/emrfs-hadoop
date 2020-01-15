package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetAlarmStateRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String alarmName;
  private String stateValue;
  private String stateReason;
  private String stateReasonData;
  
  public void setAlarmName(String alarmName)
  {
    this.alarmName = alarmName;
  }
  
  public String getAlarmName()
  {
    return alarmName;
  }
  
  public SetAlarmStateRequest withAlarmName(String alarmName)
  {
    setAlarmName(alarmName);
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
  
  public SetAlarmStateRequest withStateValue(String stateValue)
  {
    setStateValue(stateValue);
    return this;
  }
  
  public void setStateValue(StateValue stateValue)
  {
    withStateValue(stateValue);
  }
  
  public SetAlarmStateRequest withStateValue(StateValue stateValue)
  {
    this.stateValue = stateValue.toString();
    return this;
  }
  
  public void setStateReason(String stateReason)
  {
    this.stateReason = stateReason;
  }
  
  public String getStateReason()
  {
    return stateReason;
  }
  
  public SetAlarmStateRequest withStateReason(String stateReason)
  {
    setStateReason(stateReason);
    return this;
  }
  
  public void setStateReasonData(String stateReasonData)
  {
    this.stateReasonData = stateReasonData;
  }
  
  public String getStateReasonData()
  {
    return stateReasonData;
  }
  
  public SetAlarmStateRequest withStateReasonData(String stateReasonData)
  {
    setStateReasonData(stateReasonData);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmName() != null) {
      sb.append("AlarmName: ").append(getAlarmName()).append(",");
    }
    if (getStateValue() != null) {
      sb.append("StateValue: ").append(getStateValue()).append(",");
    }
    if (getStateReason() != null) {
      sb.append("StateReason: ").append(getStateReason()).append(",");
    }
    if (getStateReasonData() != null) {
      sb.append("StateReasonData: ").append(getStateReasonData());
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
    if (!(obj instanceof SetAlarmStateRequest)) {
      return false;
    }
    SetAlarmStateRequest other = (SetAlarmStateRequest)obj;
    if (((other.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmName() != null) && (!other.getAlarmName().equals(getAlarmName()))) {
      return false;
    }
    if (((other.getStateValue() == null ? 1 : 0) ^ (getStateValue() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateValue() != null) && (!other.getStateValue().equals(getStateValue()))) {
      return false;
    }
    if (((other.getStateReason() == null ? 1 : 0) ^ (getStateReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateReason() != null) && (!other.getStateReason().equals(getStateReason()))) {
      return false;
    }
    if (((other.getStateReasonData() == null ? 1 : 0) ^ (getStateReasonData() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStateReasonData() != null) && (!other.getStateReasonData().equals(getStateReasonData()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAlarmName() == null ? 0 : getAlarmName().hashCode());
    hashCode = 31 * hashCode + (getStateValue() == null ? 0 : getStateValue().hashCode());
    hashCode = 31 * hashCode + (getStateReason() == null ? 0 : getStateReason().hashCode());
    hashCode = 31 * hashCode + (getStateReasonData() == null ? 0 : getStateReasonData().hashCode());
    return hashCode;
  }
  
  public SetAlarmStateRequest clone()
  {
    return (SetAlarmStateRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */