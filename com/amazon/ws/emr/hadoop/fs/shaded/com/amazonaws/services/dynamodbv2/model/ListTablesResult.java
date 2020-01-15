package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListTablesResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<String> tableNames;
  private String lastEvaluatedTableName;
  
  public List<String> getTableNames()
  {
    return tableNames;
  }
  
  public void setTableNames(Collection<String> tableNames)
  {
    if (tableNames == null)
    {
      this.tableNames = null;
      return;
    }
    this.tableNames = new ArrayList(tableNames);
  }
  
  public ListTablesResult withTableNames(String... tableNames)
  {
    if (this.tableNames == null) {
      setTableNames(new ArrayList(tableNames.length));
    }
    for (String ele : tableNames) {
      this.tableNames.add(ele);
    }
    return this;
  }
  
  public ListTablesResult withTableNames(Collection<String> tableNames)
  {
    setTableNames(tableNames);
    return this;
  }
  
  public void setLastEvaluatedTableName(String lastEvaluatedTableName)
  {
    this.lastEvaluatedTableName = lastEvaluatedTableName;
  }
  
  public String getLastEvaluatedTableName()
  {
    return lastEvaluatedTableName;
  }
  
  public ListTablesResult withLastEvaluatedTableName(String lastEvaluatedTableName)
  {
    setLastEvaluatedTableName(lastEvaluatedTableName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableNames() != null) {
      sb.append("TableNames: ").append(getTableNames()).append(",");
    }
    if (getLastEvaluatedTableName() != null) {
      sb.append("LastEvaluatedTableName: ").append(getLastEvaluatedTableName());
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
    if (!(obj instanceof ListTablesResult)) {
      return false;
    }
    ListTablesResult other = (ListTablesResult)obj;
    if (((other.getTableNames() == null ? 1 : 0) ^ (getTableNames() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableNames() != null) && (!other.getTableNames().equals(getTableNames()))) {
      return false;
    }
    if (((other.getLastEvaluatedTableName() == null ? 1 : 0) ^ (getLastEvaluatedTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLastEvaluatedTableName() != null) && (!other.getLastEvaluatedTableName().equals(getLastEvaluatedTableName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableNames() == null ? 0 : getTableNames().hashCode());
    hashCode = 31 * hashCode + (getLastEvaluatedTableName() == null ? 0 : getLastEvaluatedTableName().hashCode());
    return hashCode;
  }
  
  public ListTablesResult clone()
  {
    try
    {
      return (ListTablesResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */