package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DeleteTableResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private TableDescription tableDescription;
  
  public void setTableDescription(TableDescription tableDescription)
  {
    this.tableDescription = tableDescription;
  }
  
  public TableDescription getTableDescription()
  {
    return tableDescription;
  }
  
  public DeleteTableResult withTableDescription(TableDescription tableDescription)
  {
    setTableDescription(tableDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getTableDescription() != null) {
      sb.append("TableDescription: ").append(getTableDescription());
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
    if (!(obj instanceof DeleteTableResult)) {
      return false;
    }
    DeleteTableResult other = (DeleteTableResult)obj;
    if (((other.getTableDescription() == null ? 1 : 0) ^ (getTableDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableDescription() != null) && (!other.getTableDescription().equals(getTableDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getTableDescription() == null ? 0 : getTableDescription().hashCode());
    return hashCode;
  }
  
  public DeleteTableResult clone()
  {
    try
    {
      return (DeleteTableResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */