package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListGlobalTablesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String exclusiveStartGlobalTableName;
  private Integer limit;
  private String regionName;
  
  public void setExclusiveStartGlobalTableName(String exclusiveStartGlobalTableName)
  {
    this.exclusiveStartGlobalTableName = exclusiveStartGlobalTableName;
  }
  
  public String getExclusiveStartGlobalTableName()
  {
    return exclusiveStartGlobalTableName;
  }
  
  public ListGlobalTablesRequest withExclusiveStartGlobalTableName(String exclusiveStartGlobalTableName)
  {
    setExclusiveStartGlobalTableName(exclusiveStartGlobalTableName);
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
  
  public ListGlobalTablesRequest withLimit(Integer limit)
  {
    setLimit(limit);
    return this;
  }
  
  public void setRegionName(String regionName)
  {
    this.regionName = regionName;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public ListGlobalTablesRequest withRegionName(String regionName)
  {
    setRegionName(regionName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getExclusiveStartGlobalTableName() != null) {
      sb.append("ExclusiveStartGlobalTableName: ").append(getExclusiveStartGlobalTableName()).append(",");
    }
    if (getLimit() != null) {
      sb.append("Limit: ").append(getLimit()).append(",");
    }
    if (getRegionName() != null) {
      sb.append("RegionName: ").append(getRegionName());
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
    if (!(obj instanceof ListGlobalTablesRequest)) {
      return false;
    }
    ListGlobalTablesRequest other = (ListGlobalTablesRequest)obj;
    if (((other.getExclusiveStartGlobalTableName() == null ? 1 : 0) ^ (getExclusiveStartGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExclusiveStartGlobalTableName() != null) && 
      (!other.getExclusiveStartGlobalTableName().equals(getExclusiveStartGlobalTableName()))) {
      return false;
    }
    if (((other.getLimit() == null ? 1 : 0) ^ (getLimit() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLimit() != null) && (!other.getLimit().equals(getLimit()))) {
      return false;
    }
    if (((other.getRegionName() == null ? 1 : 0) ^ (getRegionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRegionName() != null) && (!other.getRegionName().equals(getRegionName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getExclusiveStartGlobalTableName() == null ? 0 : getExclusiveStartGlobalTableName().hashCode());
    hashCode = 31 * hashCode + (getLimit() == null ? 0 : getLimit().hashCode());
    hashCode = 31 * hashCode + (getRegionName() == null ? 0 : getRegionName().hashCode());
    return hashCode;
  }
  
  public ListGlobalTablesRequest clone()
  {
    return (ListGlobalTablesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */