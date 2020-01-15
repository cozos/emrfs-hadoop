package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeletePolicyVersionRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policyArn;
  private String versionId;
  
  public void setPolicyArn(String policyArn)
  {
    this.policyArn = policyArn;
  }
  
  public String getPolicyArn()
  {
    return policyArn;
  }
  
  public DeletePolicyVersionRequest withPolicyArn(String policyArn)
  {
    setPolicyArn(policyArn);
    return this;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public DeletePolicyVersionRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicyArn() != null) {
      sb.append("PolicyArn: ").append(getPolicyArn()).append(",");
    }
    if (getVersionId() != null) {
      sb.append("VersionId: ").append(getVersionId());
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
    if (!(obj instanceof DeletePolicyVersionRequest)) {
      return false;
    }
    DeletePolicyVersionRequest other = (DeletePolicyVersionRequest)obj;
    if (((other.getPolicyArn() == null ? 1 : 0) ^ (getPolicyArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicyArn() != null) && (!other.getPolicyArn().equals(getPolicyArn()))) {
      return false;
    }
    if (((other.getVersionId() == null ? 1 : 0) ^ (getVersionId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVersionId() != null) && (!other.getVersionId().equals(getVersionId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicyArn() == null ? 0 : getPolicyArn().hashCode());
    hashCode = 31 * hashCode + (getVersionId() == null ? 0 : getVersionId().hashCode());
    return hashCode;
  }
  
  public DeletePolicyVersionRequest clone()
  {
    return (DeletePolicyVersionRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */