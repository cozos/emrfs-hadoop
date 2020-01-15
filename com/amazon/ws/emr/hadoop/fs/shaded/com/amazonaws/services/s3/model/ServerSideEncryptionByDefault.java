package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class ServerSideEncryptionByDefault
  implements Serializable, Cloneable
{
  private String sseAlgorithm;
  private String kmsMasterKeyID;
  
  public String getSSEAlgorithm()
  {
    return sseAlgorithm;
  }
  
  public void setSSEAlgorithm(String sseAlgorithm)
  {
    this.sseAlgorithm = sseAlgorithm;
  }
  
  public ServerSideEncryptionByDefault withSSEAlgorithm(String sseAlgorithm)
  {
    setSSEAlgorithm(sseAlgorithm);
    return this;
  }
  
  public ServerSideEncryptionByDefault withSSEAlgorithm(SSEAlgorithm sseAlgorithm)
  {
    setSSEAlgorithm(sseAlgorithm == null ? null : sseAlgorithm.toString());
    return this;
  }
  
  public String getKMSMasterKeyID()
  {
    return kmsMasterKeyID;
  }
  
  public void setKMSMasterKeyID(String kmsMasterKeyID)
  {
    this.kmsMasterKeyID = kmsMasterKeyID;
  }
  
  public ServerSideEncryptionByDefault withKMSMasterKeyID(String kmsMasterKeyID)
  {
    setKMSMasterKeyID(kmsMasterKeyID);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSSEAlgorithm() != null) {
      sb.append("SSEAlgorithm: ").append(getSSEAlgorithm()).append(",");
    }
    if (getKMSMasterKeyID() != null) {
      sb.append("KMSMasterKeyID: ").append(getKMSMasterKeyID()).append(",");
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
    if (!(obj instanceof ServerSideEncryptionByDefault)) {
      return false;
    }
    ServerSideEncryptionByDefault other = (ServerSideEncryptionByDefault)obj;
    if (((other.getSSEAlgorithm() == null ? 1 : 0) ^ (getSSEAlgorithm() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSSEAlgorithm() != null) && 
      (!other.getSSEAlgorithm().equals(getSSEAlgorithm()))) {
      return false;
    }
    if (((other.getKMSMasterKeyID() == null ? 1 : 0) ^ (getKMSMasterKeyID() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKMSMasterKeyID() != null) && 
      (!other.getKMSMasterKeyID().equals(getKMSMasterKeyID()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSSEAlgorithm() == null ? 0 : getSSEAlgorithm().hashCode());
    hashCode = 31 * hashCode + (getKMSMasterKeyID() == null ? 0 : getKMSMasterKeyID().hashCode());
    return hashCode;
  }
  
  public ServerSideEncryptionByDefault clone()
  {
    try
    {
      return (ServerSideEncryptionByDefault)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ServerSideEncryptionByDefault
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */