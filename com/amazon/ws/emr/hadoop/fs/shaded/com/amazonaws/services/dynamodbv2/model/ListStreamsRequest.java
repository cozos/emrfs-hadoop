package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListStreamsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String tableName;
  private Integer limit;
  private String exclusiveStartStreamArn;
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public ListStreamsRequest withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public void setLimit(Integer limit)
  {
    this.limit = limit;
  }
  
  public Integer getLimit()
  {
    return limit;
  }
  
  public ListStreamsRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public void setExclusiveStartStreamArn(String exclusiveStartStreamArn)
  {
    this.exclusiveStartStreamArn = exclusiveStartStreamArn;
  }
  
  public String getExclusiveStartStreamArn()
  {
    return exclusiveStartStreamArn;
  }
  
  public ListStreamsRequest withExclusiveStartStreamArn(String exclusiveStartStreamArn)
  {
    setExclusiveStartStreamArn(exclusiveStartStreamArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableName() != null) {
      sb.append("TableName: ").append(getTableName()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
    }
    if (getExclusiveStartStreamArn() != null) {
      sb.append("ExclusiveStartStreamArn: ").append(getExclusiveStartStreamArn());
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
    if (!(obj instanceof ListStreamsRequest)) {
      return false;
    }
    ListStreamsRequest other = (ListStreamsRequest)obj;
    if (((other.getTableName() == null ? 1 : 0) ^ (getTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableName() != null) && (!other.getTableName().equals(getTableName()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    if (((other.getExclusiveStartStreamArn() == null ? 1 : 0) ^ (getExclusiveStartStreamArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExclusiveStartStreamArn() != null) && (!other.getExclusiveStartStreamArn().equals(getExclusiveStartStreamArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableName() == null ? 0 : getTableName().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getExclusiveStartStreamArn() == null ? 0 : getExclusiveStartStreamArn().hashCode());
    return hashCode;
  }
  
  public ListStreamsRequest clone()
  {
    return (ListStreamsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */