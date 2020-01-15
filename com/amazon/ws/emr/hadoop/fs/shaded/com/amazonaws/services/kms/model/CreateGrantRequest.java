package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CreateGrantRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private String granteePrincipal;
  private String retiringPrincipal;
  private SdkInternalList<String> operations;
  private GrantConstraints constraints;
  private SdkInternalList<String> grantTokens;
  private String name;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public CreateGrantRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setGranteePrincipal(String granteePrincipal)
  {
    this.granteePrincipal = granteePrincipal;
  }
  
  public String getGranteePrincipal()
  {
    return granteePrincipal;
  }
  
  public CreateGrantRequest withGranteePrincipal(String granteePrincipal)
  {
    setGranteePrincipal(granteePrincipal);
    return this;
  }
  
  public void setRetiringPrincipal(String retiringPrincipal)
  {
    this.retiringPrincipal = retiringPrincipal;
  }
  
  public String getRetiringPrincipal()
  {
    return retiringPrincipal;
  }
  
  public CreateGrantRequest withRetiringPrincipal(String retiringPrincipal)
  {
    setRetiringPrincipal(retiringPrincipal);
    return this;
  }
  
  public List<String> getOperations()
  {
    if (operations == null) {
      operations = new SdkInternalList();
    }
    return operations;
  }
  
  public void setOperations(Collection<String> operations)
  {
    if (operations == null)
    {
      this.operations = null;
      return;
    }
    this.operations = new SdkInternalList(operations);
  }
  
  public CreateGrantRequest withOperations(String... operations)
  {
    if (this.operations == null) {
      setOperations(new SdkInternalList(operations.length));
    }
    for (String ele : operations) {
      this.operations.add(ele);
    }
    return this;
  }
  
  public CreateGrantRequest withOperations(Collection<String> operations)
  {
    setOperations(operations);
    return this;
  }
  
  public CreateGrantRequest withOperations(GrantOperation... operations)
  {
    SdkInternalList<String> operationsCopy = new SdkInternalList(operations.length);
    for (GrantOperation value : operations) {
      operationsCopy.add(value.toString());
    }
    if (getOperations() == null) {
      setOperations(operationsCopy);
    } else {
      getOperations().addAll(operationsCopy);
    }
    return this;
  }
  
  public void setConstraints(GrantConstraints constraints)
  {
    this.constraints = constraints;
  }
  
  public GrantConstraints getConstraints()
  {
    return constraints;
  }
  
  public CreateGrantRequest withConstraints(GrantConstraints constraints)
  {
    setConstraints(constraints);
    return this;
  }
  
  public List<String> getGrantTokens()
  {
    if (grantTokens == null) {
      grantTokens = new SdkInternalList();
    }
    return grantTokens;
  }
  
  public void setGrantTokens(Collection<String> grantTokens)
  {
    if (grantTokens == null)
    {
      this.grantTokens = null;
      return;
    }
    this.grantTokens = new SdkInternalList(grantTokens);
  }
  
  public CreateGrantRequest withGrantTokens(String... grantTokens)
  {
    if (this.grantTokens == null) {
      setGrantTokens(new SdkInternalList(grantTokens.length));
    }
    for (String ele : grantTokens) {
      this.grantTokens.add(ele);
    }
    return this;
  }
  
  public CreateGrantRequest withGrantTokens(Collection<String> grantTokens)
  {
    setGrantTokens(grantTokens);
    return this;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CreateGrantRequest withName(String name)
  {
    setName(name);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getGranteePrincipal() != null) {
      sb.append("GranteePrincipal: ").append(getGranteePrincipal()).append(",");
    }
    if (getRetiringPrincipal() != null) {
      sb.append("RetiringPrincipal: ").append(getRetiringPrincipal()).append(",");
    }
    if (getOperations() != null) {
      sb.append("Operations: ").append(getOperations()).append(",");
    }
    if (getConstraints() != null) {
      sb.append("Constraints: ").append(getConstraints()).append(",");
    }
    if (getGrantTokens() != null) {
      sb.append("GrantTokens: ").append(getGrantTokens()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName());
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
    if (!(obj instanceof CreateGrantRequest)) {
      return false;
    }
    CreateGrantRequest other = (CreateGrantRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getGranteePrincipal() == null ? 1 : 0) ^ (getGranteePrincipal() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGranteePrincipal() != null) && (!other.getGranteePrincipal().equals(getGranteePrincipal()))) {
      return false;
    }
    if (((other.getRetiringPrincipal() == null ? 1 : 0) ^ (getRetiringPrincipal() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRetiringPrincipal() != null) && (!other.getRetiringPrincipal().equals(getRetiringPrincipal()))) {
      return false;
    }
    if (((other.getOperations() == null ? 1 : 0) ^ (getOperations() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOperations() != null) && (!other.getOperations().equals(getOperations()))) {
      return false;
    }
    if (((other.getConstraints() == null ? 1 : 0) ^ (getConstraints() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getConstraints() != null) && (!other.getConstraints().equals(getConstraints()))) {
      return false;
    }
    if (((other.getGrantTokens() == null ? 1 : 0) ^ (getGrantTokens() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantTokens() != null) && (!other.getGrantTokens().equals(getGrantTokens()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getGranteePrincipal() == null ? 0 : getGranteePrincipal().hashCode());
    hashCode = 31 * hashCode + (getRetiringPrincipal() == null ? 0 : getRetiringPrincipal().hashCode());
    hashCode = 31 * hashCode + (getOperations() == null ? 0 : getOperations().hashCode());
    hashCode = 31 * hashCode + (getConstraints() == null ? 0 : getConstraints().hashCode());
    hashCode = 31 * hashCode + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    return hashCode;
  }
  
  public CreateGrantRequest clone()
  {
    return (CreateGrantRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */