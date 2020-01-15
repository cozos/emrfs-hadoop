package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateTimeToLiveRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private TimeToLiveSpecification timeToLiveSpecification;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public UpdateTimeToLiveRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification)
  {
    this.timeToLiveSpecification = timeToLiveSpecification;
  }
  
  public TimeToLiveSpecification getTimeToLiveSpecification()
  {
    return timeToLiveSpecification;
  }
  
  public UpdateTimeToLiveRequest withTimeToLiveSpecification(TimeToLiveSpecification timeToLiveSpecification)
  {
    setTimeToLiveSpecification(timeToLiveSpecification);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getTimeToLiveSpecification() != null) {
      sb.append("TimeToLiveSpecification: ").append(getTimeToLiveSpecification());
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
    if (!(obj instanceof UpdateTimeToLiveRequest)) {
      return false;
    }
    UpdateTimeToLiveRequest other = (UpdateTimeToLiveRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getTimeToLiveSpecification() == null ? 1 : 0) ^ (getTimeToLiveSpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTimeToLiveSpecification() != null) && (!other.getTimeToLiveSpecification().equals(getTimeToLiveSpecification()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getTimeToLiveSpecification() == null ? 0 : getTimeToLiveSpecification().hashCode());
    return hashCode;
  }
  
  public UpdateTimeToLiveRequest clone()
  {
    return (UpdateTimeToLiveRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */