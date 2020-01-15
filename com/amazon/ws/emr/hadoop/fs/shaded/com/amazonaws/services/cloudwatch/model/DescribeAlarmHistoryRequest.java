package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.Date;

public class DescribeAlarmHistoryRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String alarmName;
  private String historyItemType;
  private Date startDate;
  private Date endDate;
  private Integer maxRecords;
  private String nextToken;
  
  public void setAlarmName(String alarmName)
  {
    this.alarmName = alarmName;
  }
  
  public String getAlarmName()
  {
    return alarmName;
  }
  
  public DescribeAlarmHistoryRequest withAlarmName(String alarmName)
  {
    setAlarmName(alarmName);
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
  
  public DescribeAlarmHistoryRequest withHistoryItemType(String historyItemType)
  {
    setHistoryItemType(historyItemType);
    return this;
  }
  
  public void setHistoryItemType(HistoryItemType historyItemType)
  {
    withHistoryItemType(historyItemType);
  }
  
  public DescribeAlarmHistoryRequest withHistoryItemType(HistoryItemType historyItemType)
  {
    this.historyItemType = historyItemType.toString();
    return this;
  }
  
  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }
  
  public Date getStartDate()
  {
    return startDate;
  }
  
  public DescribeAlarmHistoryRequest withStartDate(Date startDate)
  {
    setStartDate(startDate);
    return this;
  }
  
  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }
  
  public Date getEndDate()
  {
    return endDate;
  }
  
  public DescribeAlarmHistoryRequest withEndDate(Date endDate)
  {
    setEndDate(endDate);
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
  
  public DescribeAlarmHistoryRequest withMaxRecords(Integer maxRecords)
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
  
  public DescribeAlarmHistoryRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAlarmName() != null) {
      sb.append("AlarmName: ").append(getAlarmName()).append(",");
    }
    if (getHistoryItemType() != null) {
      sb.append("HistoryItemType: ").append(getHistoryItemType()).append(",");
    }
    if (getStartDate() != null) {
      sb.append("StartDate: ").append(getStartDate()).append(",");
    }
    if (getEndDate() != null) {
      sb.append("EndDate: ").append(getEndDate()).append(",");
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
    if (!(obj instanceof DescribeAlarmHistoryRequest)) {
      return false;
    }
    DescribeAlarmHistoryRequest other = (DescribeAlarmHistoryRequest)obj;
    if (((other.getAlarmName() == null ? 1 : 0) ^ (getAlarmName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAlarmName() != null) && (!other.getAlarmName().equals(getAlarmName()))) {
      return false;
    }
    if (((other.getHistoryItemType() == null ? 1 : 0) ^ (getHistoryItemType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHistoryItemType() != null) && (!other.getHistoryItemType().equals(getHistoryItemType()))) {
      return false;
    }
    if (((other.getStartDate() == null ? 1 : 0) ^ (getStartDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartDate() != null) && (!other.getStartDate().equals(getStartDate()))) {
      return false;
    }
    if (((other.getEndDate() == null ? 1 : 0) ^ (getEndDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndDate() != null) && (!other.getEndDate().equals(getEndDate()))) {
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
    
    hashCode = 31 * hashCode + (getAlarmName() == null ? 0 : getAlarmName().hashCode());
    hashCode = 31 * hashCode + (getHistoryItemType() == null ? 0 : getHistoryItemType().hashCode());
    hashCode = 31 * hashCode + (getStartDate() == null ? 0 : getStartDate().hashCode());
    hashCode = 31 * hashCode + (getEndDate() == null ? 0 : getEndDate().hashCode());
    hashCode = 31 * hashCode + (getMaxRecords() == null ? 0 : getMaxRecords().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public DescribeAlarmHistoryRequest clone()
  {
    return (DescribeAlarmHistoryRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */