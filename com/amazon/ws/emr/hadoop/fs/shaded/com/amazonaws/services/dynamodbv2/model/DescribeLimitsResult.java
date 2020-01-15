package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DescribeLimitsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Long accountMaxReadCapacityUnits;
  private Long accountMaxWriteCapacityUnits;
  private Long tableMaxReadCapacityUnits;
  private Long tableMaxWriteCapacityUnits;
  
  public void setAccountMaxReadCapacityUnits(Long accountMaxReadCapacityUnits)
  {
    this.accountMaxReadCapacityUnits = accountMaxReadCapacityUnits;
  }
  
  public Long getAccountMaxReadCapacityUnits()
  {
    return accountMaxReadCapacityUnits;
  }
  
  public DescribeLimitsResult withAccountMaxReadCapacityUnits(Long accountMaxReadCapacityUnits)
  {
    setAccountMaxReadCapacityUnits(accountMaxReadCapacityUnits);
    return this;
  }
  
  public void setAccountMaxWriteCapacityUnits(Long accountMaxWriteCapacityUnits)
  {
    this.accountMaxWriteCapacityUnits = accountMaxWriteCapacityUnits;
  }
  
  public Long getAccountMaxWriteCapacityUnits()
  {
    return accountMaxWriteCapacityUnits;
  }
  
  public DescribeLimitsResult withAccountMaxWriteCapacityUnits(Long accountMaxWriteCapacityUnits)
  {
    setAccountMaxWriteCapacityUnits(accountMaxWriteCapacityUnits);
    return this;
  }
  
  public void setTableMaxReadCapacityUnits(Long tableMaxReadCapacityUnits)
  {
    this.tableMaxReadCapacityUnits = tableMaxReadCapacityUnits;
  }
  
  public Long getTableMaxReadCapacityUnits()
  {
    return tableMaxReadCapacityUnits;
  }
  
  public DescribeLimitsResult withTableMaxReadCapacityUnits(Long tableMaxReadCapacityUnits)
  {
    setTableMaxReadCapacityUnits(tableMaxReadCapacityUnits);
    return this;
  }
  
  public void setTableMaxWriteCapacityUnits(Long tableMaxWriteCapacityUnits)
  {
    this.tableMaxWriteCapacityUnits = tableMaxWriteCapacityUnits;
  }
  
  public Long getTableMaxWriteCapacityUnits()
  {
    return tableMaxWriteCapacityUnits;
  }
  
  public DescribeLimitsResult withTableMaxWriteCapacityUnits(Long tableMaxWriteCapacityUnits)
  {
    setTableMaxWriteCapacityUnits(tableMaxWriteCapacityUnits);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccountMaxReadCapacityUnits() != null) {
      sb.append("AccountMaxReadCapacityUnits: ").append(getAccountMaxReadCapacityUnits()).append(",");
    }
    if (getAccountMaxWriteCapacityUnits() != null) {
      sb.append("AccountMaxWriteCapacityUnits: ").append(getAccountMaxWriteCapacityUnits()).append(",");
    }
    if (getTableMaxReadCapacityUnits() != null) {
      sb.append("TableMaxReadCapacityUnits: ").append(getTableMaxReadCapacityUnits()).append(",");
    }
    if (getTableMaxWriteCapacityUnits() != null) {
      sb.append("TableMaxWriteCapacityUnits: ").append(getTableMaxWriteCapacityUnits());
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
    if (!(obj instanceof DescribeLimitsResult)) {
      return false;
    }
    DescribeLimitsResult other = (DescribeLimitsResult)obj;
    if (((other.getAccountMaxReadCapacityUnits() == null ? 1 : 0) ^ (getAccountMaxReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccountMaxReadCapacityUnits() != null) && (!other.getAccountMaxReadCapacityUnits().equals(getAccountMaxReadCapacityUnits()))) {
      return false;
    }
    if (((other.getAccountMaxWriteCapacityUnits() == null ? 1 : 0) ^ (getAccountMaxWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccountMaxWriteCapacityUnits() != null) && (!other.getAccountMaxWriteCapacityUnits().equals(getAccountMaxWriteCapacityUnits()))) {
      return false;
    }
    if (((other.getTableMaxReadCapacityUnits() == null ? 1 : 0) ^ (getTableMaxReadCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableMaxReadCapacityUnits() != null) && (!other.getTableMaxReadCapacityUnits().equals(getTableMaxReadCapacityUnits()))) {
      return false;
    }
    if (((other.getTableMaxWriteCapacityUnits() == null ? 1 : 0) ^ (getTableMaxWriteCapacityUnits() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTableMaxWriteCapacityUnits() != null) && (!other.getTableMaxWriteCapacityUnits().equals(getTableMaxWriteCapacityUnits()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAccountMaxReadCapacityUnits() == null ? 0 : getAccountMaxReadCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getAccountMaxWriteCapacityUnits() == null ? 0 : getAccountMaxWriteCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getTableMaxReadCapacityUnits() == null ? 0 : getTableMaxReadCapacityUnits().hashCode());
    hashCode = 31 * hashCode + (getTableMaxWriteCapacityUnits() == null ? 0 : getTableMaxWriteCapacityUnits().hashCode());
    return hashCode;
  }
  
  public DescribeLimitsResult clone()
  {
    try
    {
      return (DescribeLimitsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */