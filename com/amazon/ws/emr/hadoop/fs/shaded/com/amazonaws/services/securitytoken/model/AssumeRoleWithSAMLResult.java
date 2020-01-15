package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class AssumeRoleWithSAMLResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Credentials credentials;
  private AssumedRoleUser assumedRoleUser;
  private Integer packedPolicySize;
  private String subject;
  private String subjectType;
  private String issuer;
  private String audience;
  private String nameQualifier;
  
  public void setCredentials(Credentials credentials)
  {
    this.credentials = credentials;
  }
  
  public Credentials getCredentials()
  {
    return credentials;
  }
  
  public AssumeRoleWithSAMLResult withCredentials(Credentials credentials)
  {
    setCredentials(credentials);
    return this;
  }
  
  public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser)
  {
    this.assumedRoleUser = assumedRoleUser;
  }
  
  public AssumedRoleUser getAssumedRoleUser()
  {
    return assumedRoleUser;
  }
  
  public AssumeRoleWithSAMLResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser)
  {
    setAssumedRoleUser(assumedRoleUser);
    return this;
  }
  
  public void setPackedPolicySize(Integer packedPolicySize)
  {
    this.packedPolicySize = packedPolicySize;
  }
  
  public Integer getPackedPolicySize()
  {
    return packedPolicySize;
  }
  
  public AssumeRoleWithSAMLResult withPackedPolicySize(Integer packedPolicySize)
  {
    setPackedPolicySize(packedPolicySize);
    return this;
  }
  
  public void setSubject(String subject)
  {
    this.subject = subject;
  }
  
  public String getSubject()
  {
    return subject;
  }
  
  public AssumeRoleWithSAMLResult withSubject(String subject)
  {
    setSubject(subject);
    return this;
  }
  
  public void setSubjectType(String subjectType)
  {
    this.subjectType = subjectType;
  }
  
  public String getSubjectType()
  {
    return subjectType;
  }
  
  public AssumeRoleWithSAMLResult withSubjectType(String subjectType)
  {
    setSubjectType(subjectType);
    return this;
  }
  
  public void setIssuer(String issuer)
  {
    this.issuer = issuer;
  }
  
  public String getIssuer()
  {
    return issuer;
  }
  
  public AssumeRoleWithSAMLResult withIssuer(String issuer)
  {
    setIssuer(issuer);
    return this;
  }
  
  public void setAudience(String audience)
  {
    this.audience = audience;
  }
  
  public String getAudience()
  {
    return audience;
  }
  
  public AssumeRoleWithSAMLResult withAudience(String audience)
  {
    setAudience(audience);
    return this;
  }
  
  public void setNameQualifier(String nameQualifier)
  {
    this.nameQualifier = nameQualifier;
  }
  
  public String getNameQualifier()
  {
    return nameQualifier;
  }
  
  public AssumeRoleWithSAMLResult withNameQualifier(String nameQualifier)
  {
    setNameQualifier(nameQualifier);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCredentials() != null) {
      sb.append("Credentials: ").append(getCredentials()).append(",");
    }
    if (getAssumedRoleUser() != null) {
      sb.append("AssumedRoleUser: ").append(getAssumedRoleUser()).append(",");
    }
    if (getPackedPolicySize() != null) {
      sb.append("PackedPolicySize: ").append(getPackedPolicySize()).append(",");
    }
    if (getSubject() != null) {
      sb.append("Subject: ").append(getSubject()).append(",");
    }
    if (getSubjectType() != null) {
      sb.append("SubjectType: ").append(getSubjectType()).append(",");
    }
    if (getIssuer() != null) {
      sb.append("Issuer: ").append(getIssuer()).append(",");
    }
    if (getAudience() != null) {
      sb.append("Audience: ").append(getAudience()).append(",");
    }
    if (getNameQualifier() != null) {
      sb.append("NameQualifier: ").append(getNameQualifier());
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
    if (!(obj instanceof AssumeRoleWithSAMLResult)) {
      return false;
    }
    AssumeRoleWithSAMLResult other = (AssumeRoleWithSAMLResult)obj;
    if (((other.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCredentials() != null) && (!other.getCredentials().equals(getCredentials()))) {
      return false;
    }
    if (((other.getAssumedRoleUser() == null ? 1 : 0) ^ (getAssumedRoleUser() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAssumedRoleUser() != null) && (!other.getAssumedRoleUser().equals(getAssumedRoleUser()))) {
      return false;
    }
    if (((other.getPackedPolicySize() == null ? 1 : 0) ^ (getPackedPolicySize() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPackedPolicySize() != null) && (!other.getPackedPolicySize().equals(getPackedPolicySize()))) {
      return false;
    }
    if (((other.getSubject() == null ? 1 : 0) ^ (getSubject() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSubject() != null) && (!other.getSubject().equals(getSubject()))) {
      return false;
    }
    if (((other.getSubjectType() == null ? 1 : 0) ^ (getSubjectType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSubjectType() != null) && (!other.getSubjectType().equals(getSubjectType()))) {
      return false;
    }
    if (((other.getIssuer() == null ? 1 : 0) ^ (getIssuer() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIssuer() != null) && (!other.getIssuer().equals(getIssuer()))) {
      return false;
    }
    if (((other.getAudience() == null ? 1 : 0) ^ (getAudience() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAudience() != null) && (!other.getAudience().equals(getAudience()))) {
      return false;
    }
    if (((other.getNameQualifier() == null ? 1 : 0) ^ (getNameQualifier() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNameQualifier() != null) && (!other.getNameQualifier().equals(getNameQualifier()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCredentials() == null ? 0 : getCredentials().hashCode());
    hashCode = 31 * hashCode + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode());
    hashCode = 31 * hashCode + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode());
    hashCode = 31 * hashCode + (getSubject() == null ? 0 : getSubject().hashCode());
    hashCode = 31 * hashCode + (getSubjectType() == null ? 0 : getSubjectType().hashCode());
    hashCode = 31 * hashCode + (getIssuer() == null ? 0 : getIssuer().hashCode());
    hashCode = 31 * hashCode + (getAudience() == null ? 0 : getAudience().hashCode());
    hashCode = 31 * hashCode + (getNameQualifier() == null ? 0 : getNameQualifier().hashCode());
    return hashCode;
  }
  
  public AssumeRoleWithSAMLResult clone()
  {
    try
    {
      return (AssumeRoleWithSAMLResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */