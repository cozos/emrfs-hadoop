package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class EncryptionConfiguration
  implements Serializable, Cloneable
{
  private String replicaKmsKeyID;
  
  public String getReplicaKmsKeyID()
  {
    return replicaKmsKeyID;
  }
  
  public void setReplicaKmsKeyID(String replicaKmsKeyID)
  {
    this.replicaKmsKeyID = replicaKmsKeyID;
  }
  
  public EncryptionConfiguration withReplicaKmsKeyID(String replicaKmsKeyID)
  {
    setReplicaKmsKeyID(replicaKmsKeyID);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getReplicaKmsKeyID() != null) {
      sb.append("ReplicaKmsKeyID: ").append(getReplicaKmsKeyID()).append(",");
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
    if (!(obj instanceof EncryptionConfiguration)) {
      return false;
    }
    EncryptionConfiguration other = (EncryptionConfiguration)obj;
    if (((other.getReplicaKmsKeyID() == null ? 1 : 0) ^ (getReplicaKmsKeyID() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReplicaKmsKeyID() != null) && (!other.getReplicaKmsKeyID().equals(getReplicaKmsKeyID()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getReplicaKmsKeyID() == null ? 0 : getReplicaKmsKeyID().hashCode());
    return hashCode;
  }
  
  public EncryptionConfiguration clone()
  {
    try
    {
      return (EncryptionConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EncryptionConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */