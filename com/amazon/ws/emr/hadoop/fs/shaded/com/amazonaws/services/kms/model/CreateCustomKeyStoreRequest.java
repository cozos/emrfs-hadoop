package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateCustomKeyStoreRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String customKeyStoreName;
  private String cloudHsmClusterId;
  private String trustAnchorCertificate;
  private String keyStorePassword;
  
  public void setCustomKeyStoreName(String customKeyStoreName)
  {
    this.customKeyStoreName = customKeyStoreName;
  }
  
  public String getCustomKeyStoreName()
  {
    return customKeyStoreName;
  }
  
  public CreateCustomKeyStoreRequest withCustomKeyStoreName(String customKeyStoreName)
  {
    setCustomKeyStoreName(customKeyStoreName);
    return this;
  }
  
  public void setCloudHsmClusterId(String cloudHsmClusterId)
  {
    this.cloudHsmClusterId = cloudHsmClusterId;
  }
  
  public String getCloudHsmClusterId()
  {
    return cloudHsmClusterId;
  }
  
  public CreateCustomKeyStoreRequest withCloudHsmClusterId(String cloudHsmClusterId)
  {
    setCloudHsmClusterId(cloudHsmClusterId);
    return this;
  }
  
  public void setTrustAnchorCertificate(String trustAnchorCertificate)
  {
    this.trustAnchorCertificate = trustAnchorCertificate;
  }
  
  public String getTrustAnchorCertificate()
  {
    return trustAnchorCertificate;
  }
  
  public CreateCustomKeyStoreRequest withTrustAnchorCertificate(String trustAnchorCertificate)
  {
    setTrustAnchorCertificate(trustAnchorCertificate);
    return this;
  }
  
  public void setKeyStorePassword(String keyStorePassword)
  {
    this.keyStorePassword = keyStorePassword;
  }
  
  public String getKeyStorePassword()
  {
    return keyStorePassword;
  }
  
  public CreateCustomKeyStoreRequest withKeyStorePassword(String keyStorePassword)
  {
    setKeyStorePassword(keyStorePassword);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCustomKeyStoreName() != null) {
      sb.append("CustomKeyStoreName: ").append(getCustomKeyStoreName()).append(",");
    }
    if (getCloudHsmClusterId() != null) {
      sb.append("CloudHsmClusterId: ").append(getCloudHsmClusterId()).append(",");
    }
    if (getTrustAnchorCertificate() != null) {
      sb.append("TrustAnchorCertificate: ").append(getTrustAnchorCertificate()).append(",");
    }
    if (getKeyStorePassword() != null) {
      sb.append("KeyStorePassword: ").append("***Sensitive Data Redacted***");
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
    if (!(obj instanceof CreateCustomKeyStoreRequest)) {
      return false;
    }
    CreateCustomKeyStoreRequest other = (CreateCustomKeyStoreRequest)obj;
    if (((other.getCustomKeyStoreName() == null ? 1 : 0) ^ (getCustomKeyStoreName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreName() != null) && (!other.getCustomKeyStoreName().equals(getCustomKeyStoreName()))) {
      return false;
    }
    if (((other.getCloudHsmClusterId() == null ? 1 : 0) ^ (getCloudHsmClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCloudHsmClusterId() != null) && (!other.getCloudHsmClusterId().equals(getCloudHsmClusterId()))) {
      return false;
    }
    if (((other.getTrustAnchorCertificate() == null ? 1 : 0) ^ (getTrustAnchorCertificate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTrustAnchorCertificate() != null) && (!other.getTrustAnchorCertificate().equals(getTrustAnchorCertificate()))) {
      return false;
    }
    if (((other.getKeyStorePassword() == null ? 1 : 0) ^ (getKeyStorePassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyStorePassword() != null) && (!other.getKeyStorePassword().equals(getKeyStorePassword()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode());
    hashCode = 31 * hashCode + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode());
    hashCode = 31 * hashCode + (getTrustAnchorCertificate() == null ? 0 : getTrustAnchorCertificate().hashCode());
    hashCode = 31 * hashCode + (getKeyStorePassword() == null ? 0 : getKeyStorePassword().hashCode());
    return hashCode;
  }
  
  public CreateCustomKeyStoreRequest clone()
  {
    return (CreateCustomKeyStoreRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */