package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GrantListEntryMarshaller;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GrantListEntry
  implements Serializable, Cloneable, StructuredPojo
{
  private String keyId;
  private String grantId;
  private String name;
  private Date creationDate;
  private String granteePrincipal;
  private String retiringPrincipal;
  private String issuingAccount;
  private SdkInternalList<String> operations;
  private GrantConstraints constraints;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public GrantListEntry withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public void setGrantId(String grantId)
  {
    this.grantId = grantId;
  }
  
  public String getGrantId()
  {
    return grantId;
  }
  
  public GrantListEntry withGrantId(String grantId)
  {
    setGrantId(grantId);
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
  
  public GrantListEntry withName(String name)
  {
    setName(name);
    return this;
  }
  
  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }
  
  public Date getCreationDate()
  {
    return creationDate;
  }
  
  public GrantListEntry withCreationDate(Date creationDate)
  {
    setCreationDate(creationDate);
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
  
  public GrantListEntry withGranteePrincipal(String granteePrincipal)
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
  
  public GrantListEntry withRetiringPrincipal(String retiringPrincipal)
  {
    setRetiringPrincipal(retiringPrincipal);
    return this;
  }
  
  public void setIssuingAccount(String issuingAccount)
  {
    this.issuingAccount = issuingAccount;
  }
  
  public String getIssuingAccount()
  {
    return issuingAccount;
  }
  
  public GrantListEntry withIssuingAccount(String issuingAccount)
  {
    setIssuingAccount(issuingAccount);
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
  
  public GrantListEntry withOperations(String... operations)
  {
    if (this.operations == null) {
      setOperations(new SdkInternalList(operations.length));
    }
    for (String ele : operations) {
      this.operations.add(ele);
    }
    return this;
  }
  
  public GrantListEntry withOperations(Collection<String> operations)
  {
    setOperations(operations);
    return this;
  }
  
  public GrantListEntry withOperations(GrantOperation... operations)
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
  
  public GrantListEntry withConstraints(GrantConstraints constraints)
  {
    setConstraints(constraints);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getGrantId() != null) {
      sb.append("GrantId: ").append(getGrantId()).append(",");
    }
    if (getName() != null) {
      sb.append("Name: ").append(getName()).append(",");
    }
    if (getCreationDate() != null) {
      sb.append("CreationDate: ").append(getCreationDate()).append(",");
    }
    if (getGranteePrincipal() != null) {
      sb.append("GranteePrincipal: ").append(getGranteePrincipal()).append(",");
    }
    if (getRetiringPrincipal() != null) {
      sb.append("RetiringPrincipal: ").append(getRetiringPrincipal()).append(",");
    }
    if (getIssuingAccount() != null) {
      sb.append("IssuingAccount: ").append(getIssuingAccount()).append(",");
    }
    if (getOperations() != null) {
      sb.append("Operations: ").append(getOperations()).append(",");
    }
    if (getConstraints() != null) {
      sb.append("Constraints: ").append(getConstraints());
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
    if (!(obj instanceof GrantListEntry)) {
      return false;
    }
    GrantListEntry other = (GrantListEntry)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getGrantId() == null ? 1 : 0) ^ (getGrantId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantId() != null) && (!other.getGrantId().equals(getGrantId()))) {
      return false;
    }
    if (((other.getName() == null ? 1 : 0) ^ (getName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getName() != null) && (!other.getName().equals(getName()))) {
      return false;
    }
    if (((other.getCreationDate() == null ? 1 : 0) ^ (getCreationDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCreationDate() != null) && (!other.getCreationDate().equals(getCreationDate()))) {
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
    if (((other.getIssuingAccount() == null ? 1 : 0) ^ (getIssuingAccount() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIssuingAccount() != null) && (!other.getIssuingAccount().equals(getIssuingAccount()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getGrantId() == null ? 0 : getGrantId().hashCode());
    hashCode = 31 * hashCode + (getName() == null ? 0 : getName().hashCode());
    hashCode = 31 * hashCode + (getCreationDate() == null ? 0 : getCreationDate().hashCode());
    hashCode = 31 * hashCode + (getGranteePrincipal() == null ? 0 : getGranteePrincipal().hashCode());
    hashCode = 31 * hashCode + (getRetiringPrincipal() == null ? 0 : getRetiringPrincipal().hashCode());
    hashCode = 31 * hashCode + (getIssuingAccount() == null ? 0 : getIssuingAccount().hashCode());
    hashCode = 31 * hashCode + (getOperations() == null ? 0 : getOperations().hashCode());
    hashCode = 31 * hashCode + (getConstraints() == null ? 0 : getConstraints().hashCode());
    return hashCode;
  }
  
  public GrantListEntry clone()
  {
    try
    {
      return (GrantListEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    GrantListEntryMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GrantListEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */