package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeTableResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private TableDescription table;
  
  public void setTable(TableDescription table)
  {
    this.table = table;
  }
  
  public TableDescription getTable()
  {
    return table;
  }
  
  public DescribeTableResult withTable(TableDescription table)
  {
    setTable(table);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTable() != null) {
      sb.append("Table: ").append(getTable());
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
    if (!(obj instanceof DescribeTableResult)) {
      return false;
    }
    DescribeTableResult other = (DescribeTableResult)obj;
    if (((other.getTable() == null ? 1 : 0) ^ (getTable() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTable() != null) && (!other.getTable().equals(getTable()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTable() == null ? 0 : getTable().hashCode());
    return hashCode;
  }
  
  public DescribeTableResult clone()
  {
    try
    {
      return (DescribeTableResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */