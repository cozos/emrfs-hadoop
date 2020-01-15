package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeBackupRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String backupArn;
  
  public void setBackupArn(String backupArn)
  {
    this.backupArn = backupArn;
  }
  
  public String getBackupArn()
  {
    return backupArn;
  }
  
  public DescribeBackupRequest withBackupArn(String backupArn)
  {
    setBackupArn(backupArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBackupArn() != null) {
      sb.append("BackupArn: ").append(getBackupArn());
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
    if (!(obj instanceof DescribeBackupRequest)) {
      return false;
    }
    DescribeBackupRequest other = (DescribeBackupRequest)obj;
    if (((other.getBackupArn() == null ? 1 : 0) ^ (getBackupArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBackupArn() != null) && (!other.getBackupArn().equals(getBackupArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBackupArn() == null ? 0 : getBackupArn().hashCode());
    return hashCode;
  }
  
  public DescribeBackupRequest clone()
  {
    return (DescribeBackupRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeBackupRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */