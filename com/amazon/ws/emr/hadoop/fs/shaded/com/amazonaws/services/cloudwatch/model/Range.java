package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;
import java.util.Date;

public class Range
  implements Serializable, Cloneable
{
  private Date startTime;
  private Date endTime;
  
  public void setStartTime(Date startTime)
  {
    this.startTime = startTime;
  }
  
  public Date getStartTime()
  {
    return startTime;
  }
  
  public Range withStartTime(Date startTime)
  {
    setStartTime(startTime);
    return this;
  }
  
  public void setEndTime(Date endTime)
  {
    this.endTime = endTime;
  }
  
  public Date getEndTime()
  {
    return endTime;
  }
  
  public Range withEndTime(Date endTime)
  {
    setEndTime(endTime);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getStartTime() != null) {
      sb.append("StartTime: ").append(getStartTime()).append(",");
    }
    if (getEndTime() != null) {
      sb.append("EndTime: ").append(getEndTime());
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
    if (!(obj instanceof Range)) {
      return false;
    }
    Range other = (Range)obj;
    if (((other.getStartTime() == null ? 1 : 0) ^ (getStartTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartTime() != null) && (!other.getStartTime().equals(getStartTime()))) {
      return false;
    }
    if (((other.getEndTime() == null ? 1 : 0) ^ (getEndTime() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndTime() != null) && (!other.getEndTime().equals(getEndTime()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getStartTime() == null ? 0 : getStartTime().hashCode());
    hashCode = 31 * hashCode + (getEndTime() == null ? 0 : getEndTime().hashCode());
    return hashCode;
  }
  
  public Range clone()
  {
    try
    {
      return (Range)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Range
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */