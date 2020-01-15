package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListTablesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String exclusiveStartTableName;
  private Integer limit;
  
  public ListTablesRequest() {}
  
  public ListTablesRequest(String exclusiveStartTableName)
  {
    setExclusiveStartTableName(exclusiveStartTableName);
  }
  
  public ListTablesRequest(String exclusiveStartTableName, Integer limit)
  {
    setExclusiveStartTableName(exclusiveStartTableName);
    setLimit(limit);
  }
  
  public void setExclusiveStartTableName(String exclusiveStartTableName)
  {
    this.exclusiveStartTableName = exclusiveStartTableName;
  }
  
  public String getExclusiveStartTableName()
  {
    return exclusiveStartTableName;
  }
  
  public ListTablesRequest withExclusiveStartTableName(String exclusiveStartTableName)
  {
    setExclusiveStartTableName(exclusiveStartTableName);
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
  
  public ListTablesRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getExclusiveStartTableName() != null) {
      sb.append("ExclusiveStartTableName: ").append(getExclusiveStartTableName()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit());
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
    if (!(obj instanceof ListTablesRequest)) {
      return false;
    }
    ListTablesRequest other = (ListTablesRequest)obj;
    if (((other.getExclusiveStartTableName() == null ? 1 : 0) ^ (getExclusiveStartTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExclusiveStartTableName() != null) && (!other.getExclusiveStartTableName().equals(getExclusiveStartTableName()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getExclusiveStartTableName() == null ? 0 : getExclusiveStartTableName().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    return hashCode;
  }
  
  public ListTablesRequest clone()
  {
    return (ListTablesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */