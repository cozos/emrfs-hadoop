package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import java.io.Serializable;
import java.util.Date;

public class Credentials
  implements Serializable, Cloneable
{
  private String accessKeyId;
  private String secretAccessKey;
  private String sessionToken;
  private Date expiration;
  
  public Credentials() {}
  
  public Credentials(String accessKeyId, String secretAccessKey, String sessionToken, Date expiration)
  {
    setAccessKeyId(accessKeyId);
    setSecretAccessKey(secretAccessKey);
    setSessionToken(sessionToken);
    setExpiration(expiration);
  }
  
  public void setAccessKeyId(String accessKeyId)
  {
    this.accessKeyId = accessKeyId;
  }
  
  public String getAccessKeyId()
  {
    return accessKeyId;
  }
  
  public Credentials withAccessKeyId(String accessKeyId)
  {
    setAccessKeyId(accessKeyId);
    return this;
  }
  
  public void setSecretAccessKey(String secretAccessKey)
  {
    this.secretAccessKey = secretAccessKey;
  }
  
  public String getSecretAccessKey()
  {
    return secretAccessKey;
  }
  
  public Credentials withSecretAccessKey(String secretAccessKey)
  {
    setSecretAccessKey(secretAccessKey);
    return this;
  }
  
  public void setSessionToken(String sessionToken)
  {
    this.sessionToken = sessionToken;
  }
  
  public String getSessionToken()
  {
    return sessionToken;
  }
  
  public Credentials withSessionToken(String sessionToken)
  {
    setSessionToken(sessionToken);
    return this;
  }
  
  public void setExpiration(Date expiration)
  {
    this.expiration = expiration;
  }
  
  public Date getExpiration()
  {
    return expiration;
  }
  
  public Credentials withExpiration(Date expiration)
  {
    setExpiration(expiration);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getAccessKeyId() != null) {
      sb.append("AccessKeyId: ").append(getAccessKeyId()).append(",");
    }
    if (getSecretAccessKey() != null) {
      sb.append("SecretAccessKey: ").append(getSecretAccessKey()).append(",");
    }
    if (getSessionToken() != null) {
      sb.append("SessionToken: ").append(getSessionToken()).append(",");
    }
    if (getExpiration() != null) {
      sb.append("Expiration: ").append(getExpiration());
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
    if (!(obj instanceof Credentials)) {
      return false;
    }
    Credentials other = (Credentials)obj;
    if (((other.getAccessKeyId() == null ? 1 : 0) ^ (getAccessKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessKeyId() != null) && (!other.getAccessKeyId().equals(getAccessKeyId()))) {
      return false;
    }
    if (((other.getSecretAccessKey() == null ? 1 : 0) ^ (getSecretAccessKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSecretAccessKey() != null) && (!other.getSecretAccessKey().equals(getSecretAccessKey()))) {
      return false;
    }
    if (((other.getSessionToken() == null ? 1 : 0) ^ (getSessionToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSessionToken() != null) && (!other.getSessionToken().equals(getSessionToken()))) {
      return false;
    }
    if (((other.getExpiration() == null ? 1 : 0) ^ (getExpiration() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExpiration() != null) && (!other.getExpiration().equals(getExpiration()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode());
    hashCode = 31 * hashCode + (getSecretAccessKey() == null ? 0 : getSecretAccessKey().hashCode());
    hashCode = 31 * hashCode + (getSessionToken() == null ? 0 : getSessionToken().hashCode());
    hashCode = 31 * hashCode + (getExpiration() == null ? 0 : getExpiration().hashCode());
    return hashCode;
  }
  
  public Credentials clone()
  {
    try
    {
      return (Credentials)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.Credentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */