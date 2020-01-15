package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;
import java.util.Date;

public class AlarmHistoryItem
  implements Serializable, Cloneable
{
  private String alarmName;
  private Date timestamp;
  private String historyItemType;
  private String historySummary;
  private String historyData;
  
  public void setAlarmName(String alarmName)
  {
    this.alarmName = alarmName;
  }
  
  public String getAlarmName()
  {
    return alarmName;
  }
  
  public AlarmHistoryItem withAlarmName(String alarmName)
  {
    setAlarmName(alarmName);
    return this;
  }
  
  public void setTimestamp(Date timestamp)
  {
    this.timestamp = timestamp;
  }
  
  public Date getTimestamp()
  {
    return timestamp;
  }
  
  public AlarmHistoryItem withTimestamp(Date timestamp)
  {
    setTimestamp(timestamp);
    return this;
  }
  
  public void setHistoryItemType(String historyItemType)
  {
    this.historyItemType = historyItemType;
  }
  
  public String getHistoryItemType()
  {
    return historyItemType;
  }
  
  public AlarmHistoryItem withHistoryItemType(String historyItemType)
  {
    setHistoryItemType(historyItemType);
    return this;
  }
  
  public void setHistoryItemType(HistoryItemType historyItemType)
  {
    withHistoryItemType(historyItemType);
  }
  
  public AlarmHistoryItem withHistoryItemType(HistoryItemType historyItemType)
  {
    this.historyItemType = historyItemType.toString();
    return this;
  }
  
  public void setHistorySummary(String historySummary)
  {
    this.historySummary = historySummary;
  }
  
  public String getHistorySummary()
  {
    return historySummary;
  }
  
  public AlarmHistoryItem withHistorySummary(String historySummary)
  {
    setHistorySummary(historySummary);
    return this;
  }
  
  public void setHistoryData(String historyData)
  {
    this.historyData = historyData;
  }
  
  public String getHistoryData()
  {
    return historyData;
  }
  
  public AlarmHistoryItem withHistoryData(String historyData)
  {
    setHistoryData(historyData);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmName() != null) {
      sb.append("AlarmName: ").append(getAlarmName()).append(",");
    }
    if (getTimestamp() != null) {
      sb.append("Timestamp: ").append(getTimestamp()).append(",");
    }
    if (getHistoryItemType() != null) {
      sb.append("HistoryItemType: ").append(getHistoryItemType()).append(",");
    }
    if (getHistorySummary() != null) {
      sb.append("HistorySummary: ").append(getHistorySummary()).append(",");
    }
    if (getHistoryData() != null) {
      sb.append("HistoryData: ").append(getHistoryData());
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
    if (!(obj instanceof AlarmHistoryItem)) {
      return false;
    }
    AlarmHistoryItem other = (AlarmHistoryItem)obj;
    if (((other.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmName() != null) && (!other.getAlarmName().equals(getAlarmName()))) {
      return false;
    }
    if (((other.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimestamp() != null) && (!other.getTimestamp().equals(getTimestamp()))) {
      return false;
    }
    if (((other.getHistoryItemType() == null ? 1 : 0) ^ (getHistoryItemType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHistoryItemType() != null) && (!other.getHistoryItemType().equals(getHistoryItemType()))) {
      return false;
    }
    if (((other.getHistorySummary() == null ? 1 : 0) ^ (getHistorySummary() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHistorySummary() != null) && (!other.getHistorySummary().equals(getHistorySummary()))) {
      return false;
    }
    if (((other.getHistoryData() == null ? 1 : 0) ^ (getHistoryData() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHistoryData() != null) && (!other.getHistoryData().equals(getHistoryData()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAlarmName() == null ? 0 : getAlarmName().hashCode());
    hashCode = 31 * hashCode + (getTimestamp() == null ? 0 : getTimestamp().hashCode());
    hashCode = 31 * hashCode + (getHistoryItemType() == null ? 0 : getHistoryItemType().hashCode());
    hashCode = 31 * hashCode + (getHistorySummary() == null ? 0 : getHistorySummary().hashCode());
    hashCode = 31 * hashCode + (getHistoryData() == null ? 0 : getHistoryData().hashCode());
    return hashCode;
  }
  
  public AlarmHistoryItem clone()
  {
    try
    {
      return (AlarmHistoryItem)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AlarmHistoryItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */