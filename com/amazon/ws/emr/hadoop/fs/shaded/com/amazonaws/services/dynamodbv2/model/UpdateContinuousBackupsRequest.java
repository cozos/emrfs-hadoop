package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateContinuousBackupsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private PointInTimeRecoverySpecification pointInTimeRecoverySpecification;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public UpdateContinuousBackupsRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setPointInTimeRecoverySpecification(PointInTimeRecoverySpecification pointInTimeRecoverySpecification)
  {
    this.pointInTimeRecoverySpecification = pointInTimeRecoverySpecification;
  }
  
  public PointInTimeRecoverySpecification getPointInTimeRecoverySpecification()
  {
    return pointInTimeRecoverySpecification;
  }
  
  public UpdateContinuousBackupsRequest withPointInTimeRecoverySpecification(PointInTimeRecoverySpecification pointInTimeRecoverySpecification)
  {
    setPointInTimeRecoverySpecification(pointInTimeRecoverySpecification);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getPointInTimeRecoverySpecification() != null) {
      sb.append("PointInTimeRecoverySpecification: ").append(getPointInTimeRecoverySpecification());
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
    if (!(obj instanceof UpdateContinuousBackupsRequest)) {
      return false;
    }
    UpdateContinuousBackupsRequest other = (UpdateContinuousBackupsRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getPointInTimeRecoverySpecification() == null ? 1 : 0) ^ (getPointInTimeRecoverySpecification() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPointInTimeRecoverySpecification() != null) && 
      (!other.getPointInTimeRecoverySpecification().equals(getPointInTimeRecoverySpecification()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getPointInTimeRecoverySpecification() == null ? 0 : getPointInTimeRecoverySpecification().hashCode());
    return hashCode;
  }
  
  public UpdateContinuousBackupsRequest clone()
  {
    return (UpdateContinuousBackupsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */