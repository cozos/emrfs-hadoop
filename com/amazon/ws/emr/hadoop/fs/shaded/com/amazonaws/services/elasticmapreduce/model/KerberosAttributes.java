package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.KerberosAttributesMarshaller;
import java.io.Serializable;

public class KerberosAttributes
  implements Serializable, Cloneable, StructuredPojo
{
  private String realm;
  private String kdcAdminPassword;
  private String crossRealmTrustPrincipalPassword;
  private String aDDomainJoinUser;
  private String aDDomainJoinPassword;
  
  public void setRealm(String realm)
  {
    this.realm = realm;
  }
  
  public String getRealm()
  {
    return realm;
  }
  
  public KerberosAttributes withRealm(String realm)
  {
    setRealm(realm);
    return this;
  }
  
  public void setKdcAdminPassword(String kdcAdminPassword)
  {
    this.kdcAdminPassword = kdcAdminPassword;
  }
  
  public String getKdcAdminPassword()
  {
    return kdcAdminPassword;
  }
  
  public KerberosAttributes withKdcAdminPassword(String kdcAdminPassword)
  {
    setKdcAdminPassword(kdcAdminPassword);
    return this;
  }
  
  public void setCrossRealmTrustPrincipalPassword(String crossRealmTrustPrincipalPassword)
  {
    this.crossRealmTrustPrincipalPassword = crossRealmTrustPrincipalPassword;
  }
  
  public String getCrossRealmTrustPrincipalPassword()
  {
    return crossRealmTrustPrincipalPassword;
  }
  
  public KerberosAttributes withCrossRealmTrustPrincipalPassword(String crossRealmTrustPrincipalPassword)
  {
    setCrossRealmTrustPrincipalPassword(crossRealmTrustPrincipalPassword);
    return this;
  }
  
  public void setADDomainJoinUser(String aDDomainJoinUser)
  {
    this.aDDomainJoinUser = aDDomainJoinUser;
  }
  
  public String getADDomainJoinUser()
  {
    return aDDomainJoinUser;
  }
  
  public KerberosAttributes withADDomainJoinUser(String aDDomainJoinUser)
  {
    setADDomainJoinUser(aDDomainJoinUser);
    return this;
  }
  
  public void setADDomainJoinPassword(String aDDomainJoinPassword)
  {
    this.aDDomainJoinPassword = aDDomainJoinPassword;
  }
  
  public String getADDomainJoinPassword()
  {
    return aDDomainJoinPassword;
  }
  
  public KerberosAttributes withADDomainJoinPassword(String aDDomainJoinPassword)
  {
    setADDomainJoinPassword(aDDomainJoinPassword);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRealm() != null) {
      sb.append("Realm: ").append(getRealm()).append(",");
    }
    if (getKdcAdminPassword() != null) {
      sb.append("KdcAdminPassword: ").append(getKdcAdminPassword()).append(",");
    }
    if (getCrossRealmTrustPrincipalPassword() != null) {
      sb.append("CrossRealmTrustPrincipalPassword: ").append(getCrossRealmTrustPrincipalPassword()).append(",");
    }
    if (getADDomainJoinUser() != null) {
      sb.append("ADDomainJoinUser: ").append(getADDomainJoinUser()).append(",");
    }
    if (getADDomainJoinPassword() != null) {
      sb.append("ADDomainJoinPassword: ").append(getADDomainJoinPassword());
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
    if (!(obj instanceof KerberosAttributes)) {
      return false;
    }
    KerberosAttributes other = (KerberosAttributes)obj;
    if (((other.getRealm() == null ? 1 : 0) ^ (getRealm() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRealm() != null) && (!other.getRealm().equals(getRealm()))) {
      return false;
    }
    if (((other.getKdcAdminPassword() == null ? 1 : 0) ^ (getKdcAdminPassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKdcAdminPassword() != null) && (!other.getKdcAdminPassword().equals(getKdcAdminPassword()))) {
      return false;
    }
    if (((other.getCrossRealmTrustPrincipalPassword() == null ? 1 : 0) ^ (getCrossRealmTrustPrincipalPassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCrossRealmTrustPrincipalPassword() != null) && 
      (!other.getCrossRealmTrustPrincipalPassword().equals(getCrossRealmTrustPrincipalPassword()))) {
      return false;
    }
    if (((other.getADDomainJoinUser() == null ? 1 : 0) ^ (getADDomainJoinUser() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getADDomainJoinUser() != null) && (!other.getADDomainJoinUser().equals(getADDomainJoinUser()))) {
      return false;
    }
    if (((other.getADDomainJoinPassword() == null ? 1 : 0) ^ (getADDomainJoinPassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getADDomainJoinPassword() != null) && (!other.getADDomainJoinPassword().equals(getADDomainJoinPassword()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRealm() == null ? 0 : getRealm().hashCode());
    hashCode = 31 * hashCode + (getKdcAdminPassword() == null ? 0 : getKdcAdminPassword().hashCode());
    hashCode = 31 * hashCode + (getCrossRealmTrustPrincipalPassword() == null ? 0 : getCrossRealmTrustPrincipalPassword().hashCode());
    hashCode = 31 * hashCode + (getADDomainJoinUser() == null ? 0 : getADDomainJoinUser().hashCode());
    hashCode = 31 * hashCode + (getADDomainJoinPassword() == null ? 0 : getADDomainJoinPassword().hashCode());
    return hashCode;
  }
  
  public KerberosAttributes clone()
  {
    try
    {
      return (KerberosAttributes)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    KerberosAttributesMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.KerberosAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */