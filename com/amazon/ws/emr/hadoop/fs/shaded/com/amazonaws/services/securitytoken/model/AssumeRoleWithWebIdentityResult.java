package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class AssumeRoleWithWebIdentityResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Credentials credentials;
  private String subjectFromWebIdentityToken;
  private AssumedRoleUser assumedRoleUser;
  private Integer packedPolicySize;
  private String provider;
  private String audience;
  
  public void setCredentials(Credentials credentials)
  {
    this.credentials = credentials;
  }
  
  public Credentials getCredentials()
  {
    return credentials;
  }
  
  public AssumeRoleWithWebIdentityResult withCredentials(Credentials credentials)
  {
    setCredentials(credentials);
    return this;
  }
  
  public void setSubjectFromWebIdentityToken(String subjectFromWebIdentityToken)
  {
    this.subjectFromWebIdentityToken = subjectFromWebIdentityToken;
  }
  
  public String getSubjectFromWebIdentityToken()
  {
    return subjectFromWebIdentityToken;
  }
  
  public AssumeRoleWithWebIdentityResult withSubjectFromWebIdentityToken(String subjectFromWebIdentityToken)
  {
    setSubjectFromWebIdentityToken(subjectFromWebIdentityToken);
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
  
  public AssumeRoleWithWebIdentityResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser)
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
  
  public AssumeRoleWithWebIdentityResult withPackedPolicySize(Integer packedPolicySize)
  {
    setPackedPolicySize(packedPolicySize);
    return this;
  }
  
  public void setProvider(String provider)
  {
    this.provider = provider;
  }
  
  public String getProvider()
  {
    return provider;
  }
  
  public AssumeRoleWithWebIdentityResult withProvider(String provider)
  {
    setProvider(provider);
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
  
  public AssumeRoleWithWebIdentityResult withAudience(String audience)
  {
    setAudience(audience);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCredentials() != null) {
      sb.append("Credentials: ").append(getCredentials()).append(",");
    }
    if (getSubjectFromWebIdentityToken() != null) {
      sb.append("SubjectFromWebIdentityToken: ").append(getSubjectFromWebIdentityToken()).append(",");
    }
    if (getAssumedRoleUser() != null) {
      sb.append("AssumedRoleUser: ").append(getAssumedRoleUser()).append(",");
    }
    if (getPackedPolicySize() != null) {
      sb.append("PackedPolicySize: ").append(getPackedPolicySize()).append(",");
    }
    if (getProvider() != null) {
      sb.append("Provider: ").append(getProvider()).append(",");
    }
    if (getAudience() != null) {
      sb.append("Audience: ").append(getAudience());
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
    if (!(obj instanceof AssumeRoleWithWebIdentityResult)) {
      return false;
    }
    AssumeRoleWithWebIdentityResult other = (AssumeRoleWithWebIdentityResult)obj;
    if (((other.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCredentials() != null) && (!other.getCredentials().equals(getCredentials()))) {
      return false;
    }
    if (((other.getSubjectFromWebIdentityToken() == null ? 1 : 0) ^ (getSubjectFromWebIdentityToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSubjectFromWebIdentityToken() != null) && (!other.getSubjectFromWebIdentityToken().equals(getSubjectFromWebIdentityToken()))) {
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
    if (((other.getProvider() == null ? 1 : 0) ^ (getProvider() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getProvider() != null) && (!other.getProvider().equals(getProvider()))) {
      return false;
    }
    if (((other.getAudience() == null ? 1 : 0) ^ (getAudience() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAudience() != null) && (!other.getAudience().equals(getAudience()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCredentials() == null ? 0 : getCredentials().hashCode());
    hashCode = 31 * hashCode + (getSubjectFromWebIdentityToken() == null ? 0 : getSubjectFromWebIdentityToken().hashCode());
    hashCode = 31 * hashCode + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode());
    hashCode = 31 * hashCode + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode());
    hashCode = 31 * hashCode + (getProvider() == null ? 0 : getProvider().hashCode());
    hashCode = 31 * hashCode + (getAudience() == null ? 0 : getAudience().hashCode());
    return hashCode;
  }
  
  public AssumeRoleWithWebIdentityResult clone()
  {
    try
    {
      return (AssumeRoleWithWebIdentityResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */