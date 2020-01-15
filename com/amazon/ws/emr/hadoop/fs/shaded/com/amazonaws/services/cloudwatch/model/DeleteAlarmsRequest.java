package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DeleteAlarmsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private SdkInternalList<String> alarmNames;
  
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
  
  public DeleteAlarmsRequest withAlarmNames(String... alarmNames)
  {
    if (this.alarmNames == null) {
      setAlarmNames(new SdkInternalList(alarmNames.length));
    }
    for (String ele : alarmNames) {
      this.alarmNames.add(ele);
    }
    return this;
  }
  
  public DeleteAlarmsRequest withAlarmNames(Collection<String> alarmNames)
  {
    setAlarmNames(alarmNames);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmNames() != null) {
      sb.append("AlarmNames: ").append(getAlarmNames());
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
    if (!(obj instanceof DeleteAlarmsRequest)) {
      return false;
    }
    DeleteAlarmsRequest other = (DeleteAlarmsRequest)obj;
    if (((other.getAlarmNames() == null ? 1 : 0) ^ (getAlarmNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmNames() != null) && (!other.getAlarmNames().equals(getAlarmNames()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAlarmNames() == null ? 0 : getAlarmNames().hashCode());
    return hashCode;
  }
  
  public DeleteAlarmsRequest clone()
  {
    return (DeleteAlarmsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */