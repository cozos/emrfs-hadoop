package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeGlobalTableSettingsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String globalTableName;
  
  public void setGlobalTableName(String globalTableName)
  {
    this.globalTableName = globalTableName;
  }
  
  public String getGlobalTableName()
  {
    return globalTableName;
  }
  
  public DescribeGlobalTableSettingsRequest withGlobalTableName(String globalTableName)
  {
    setGlobalTableName(globalTableName);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGlobalTableName() != null) {
      sb.append("GlobalTableName: ").append(getGlobalTableName());
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
    if (!(obj instanceof DescribeGlobalTableSettingsRequest)) {
      return false;
    }
    DescribeGlobalTableSettingsRequest other = (DescribeGlobalTableSettingsRequest)obj;
    if (((other.getGlobalTableName() == null ? 1 : 0) ^ (getGlobalTableName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlobalTableName() != null) && (!other.getGlobalTableName().equals(getGlobalTableName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    return hashCode;
  }
  
  public DescribeGlobalTableSettingsRequest clone()
  {
    return (DescribeGlobalTableSettingsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableSettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */