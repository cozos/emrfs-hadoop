package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListGlobalTablesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<GlobalTable> globalTables;
  private String lastEvaluatedGlobalTableName;
  
  public List<GlobalTable> getGlobalTables()
  {
    return globalTables;
  }
  
  public void setGlobalTables(Collection<GlobalTable> globalTables)
  {
    if (globalTables == null)
    {
      this.globalTables = null;
      return;
    }
    this.globalTables = new ArrayList(globalTables);
  }
  
  public ListGlobalTablesResult withGlobalTables(GlobalTable... globalTables)
  {
    if (this.globalTables == null) {
      setGlobalTables(new ArrayList(globalTables.length));
    }
    for (GlobalTable ele : globalTables) {
      this.globalTables.add(ele);
    }
    return this;
  }
  
  public ListGlobalTablesResult withGlobalTables(Collection<GlobalTable> globalTables)
  {
    setGlobalTables(globalTables);
    return this;
  }
  
  public void setLastEvaluatedGlobalTableName(String lastEvaluatedGlobalTableName)
  {
    this.lastEvaluatedGlobalTableName = lastEvaluatedGlobalTableName;
  }
  
  public String getLastEvaluatedGlobalTableName()
  {
    return lastEvaluatedGlobalTableName;
  }
  
  public ListGlobalTablesResult withLastEvaluatedGlobalTableName(String lastEvaluatedGlobalTableName)
  {
    setLastEvaluatedGlobalTableName(lastEvaluatedGlobalTableName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTables() != null) {
      sb.append("GlobalTables: ").append(getGlobalTables()).append(",");
    }
    if (getLastEvaluatedGlobalTableName() != null) {
      sb.append("LastEvaluatedGlobalTableName: ").append(getLastEvaluatedGlobalTableName());
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
    if (!(obj instanceof ListGlobalTablesResult)) {
      return false;
    }
    ListGlobalTablesResult other = (ListGlobalTablesResult)obj;
    if (((other.getGlobalTables() == null ? 1 : 0) ^ (getGlobalTables() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTables() != null) && (!other.getGlobalTables().equals(getGlobalTables()))) {
      return false;
    }
    if (((other.getLastEvaluatedGlobalTableName() == null ? 1 : 0) ^ (getLastEvaluatedGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastEvaluatedGlobalTableName() != null) && (!other.getLastEvaluatedGlobalTableName().equals(getLastEvaluatedGlobalTableName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTables() == null ? 0 : getGlobalTables().hashCode());
    hashCode = 31 * hashCode + (getLastEvaluatedGlobalTableName() == null ? 0 : getLastEvaluatedGlobalTableName().hashCode());
    return hashCode;
  }
  
  public ListGlobalTablesResult clone()
  {
    try
    {
      return (ListGlobalTablesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */