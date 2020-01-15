package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@SdkProtectedApi
public class RoleInfo
  implements Cloneable
{
  private String roleArn;
  private String roleSessionName;
  private String externalId;
  private String webIdentityTokenFilePath;
  private AWSCredentialsProvider longLivedCredentialsProvider;
  
  public void setRoleArn(String roleArn)
  {
    this.roleArn = roleArn;
  }
  
  public String getRoleArn()
  {
    return roleArn;
  }
  
  public RoleInfo withRoleArn(String roleArn)
  {
    setRoleArn(roleArn);
    return this;
  }
  
  public void setRoleSessionName(String roleSessionName)
  {
    this.roleSessionName = roleSessionName;
  }
  
  public String getRoleSessionName()
  {
    return roleSessionName;
  }
  
  public RoleInfo withRoleSessionName(String roleSessionName)
  {
    setRoleSessionName(roleSessionName);
    return this;
  }
  
  public void setExternalId(String externalId)
  {
    this.externalId = externalId;
  }
  
  public String getExternalId()
  {
    return externalId;
  }
  
  public RoleInfo withExternalId(String externalId)
  {
    setExternalId(externalId);
    return this;
  }
  
  public void setWebIdentityTokenFilePath(String webIdentityTokenFilePath)
  {
    this.webIdentityTokenFilePath = webIdentityTokenFilePath;
  }
  
  public String getWebIdentityTokenFilePath()
  {
    return webIdentityTokenFilePath;
  }
  
  public RoleInfo withWebIdentityTokenFilePath(String webIdentityTokenFilePath)
  {
    setWebIdentityTokenFilePath(webIdentityTokenFilePath);
    return this;
  }
  
  public void setLongLivedCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider)
  {
    this.longLivedCredentialsProvider = longLivedCredentialsProvider;
  }
  
  public AWSCredentialsProvider getLongLivedCredentialsProvider()
  {
    return longLivedCredentialsProvider;
  }
  
  public RoleInfo withLongLivedCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider)
  {
    setLongLivedCredentialsProvider(longLivedCredentialsProvider);
    return this;
  }
  
  public RoleInfo withLongLivedCredentials(AWSCredentials longLivedCredentials)
  {
    setLongLivedCredentialsProvider(new StaticCredentialsProvider(longLivedCredentials));
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRoleArn() != null) {
      sb.append("RoleArn: " + getRoleArn() + ",");
    }
    if (getRoleSessionName() != null) {
      sb.append("RoleSessionName: " + getRoleSessionName() + ",");
    }
    if (getExternalId() != null) {
      sb.append("ExternalId: " + getExternalId() + ",");
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
    if (!(obj instanceof RoleInfo)) {
      return false;
    }
    RoleInfo other = (RoleInfo)obj;
    if (((other.getRoleArn() == null ? 1 : 0) ^ (getRoleArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleArn() != null) && 
      (!other.getRoleArn().equals(getRoleArn()))) {
      return false;
    }
    if (((other.getRoleSessionName() == null ? 1 : 0) ^ (getRoleSessionName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRoleSessionName() != null) && 
      (!other.getRoleSessionName().equals(getRoleSessionName()))) {
      return false;
    }
    if (((other.getExternalId() == null ? 1 : 0) ^ (getExternalId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getExternalId() != null) && 
      (!other.getExternalId().equals(getExternalId()))) {
      return false;
    }
    if (other.getLongLivedCredentialsProvider() != getLongLivedCredentialsProvider()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRoleArn() == null ? 0 : getRoleArn().hashCode());
    
    hashCode = 31 * hashCode + (getRoleSessionName() == null ? 0 : getRoleSessionName().hashCode());
    
    hashCode = 31 * hashCode + (getExternalId() == null ? 0 : getExternalId().hashCode());
    
    hashCode = 31 * hashCode + (getLongLivedCredentialsProvider() == null ? 0 : getLongLivedCredentialsProvider().hashCode());
    return hashCode;
  }
  
  public RoleInfo clone()
  {
    try
    {
      return (RoleInfo)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.RoleInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */