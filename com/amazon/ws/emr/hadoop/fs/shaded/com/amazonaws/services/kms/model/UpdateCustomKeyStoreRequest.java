package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateCustomKeyStoreRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String customKeyStoreId;
  private String newCustomKeyStoreName;
  private String keyStorePassword;
  private String cloudHsmClusterId;
  
  public void setCustomKeyStoreId(String customKeyStoreId)
  {
    this.customKeyStoreId = customKeyStoreId;
  }
  
  public String getCustomKeyStoreId()
  {
    return customKeyStoreId;
  }
  
  public UpdateCustomKeyStoreRequest withCustomKeyStoreId(String customKeyStoreId)
  {
    setCustomKeyStoreId(customKeyStoreId);
    return this;
  }
  
  public void setNewCustomKeyStoreName(String newCustomKeyStoreName)
  {
    this.newCustomKeyStoreName = newCustomKeyStoreName;
  }
  
  public String getNewCustomKeyStoreName()
  {
    return newCustomKeyStoreName;
  }
  
  public UpdateCustomKeyStoreRequest withNewCustomKeyStoreName(String newCustomKeyStoreName)
  {
    setNewCustomKeyStoreName(newCustomKeyStoreName);
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
  
  public UpdateCustomKeyStoreRequest withKeyStorePassword(String keyStorePassword)
  {
    setKeyStorePassword(keyStorePassword);
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
  
  public UpdateCustomKeyStoreRequest withCloudHsmClusterId(String cloudHsmClusterId)
  {
    setCloudHsmClusterId(cloudHsmClusterId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCustomKeyStoreId() != null) {
      sb.append("CustomKeyStoreId: ").append(getCustomKeyStoreId()).append(",");
    }
    if (getNewCustomKeyStoreName() != null) {
      sb.append("NewCustomKeyStoreName: ").append(getNewCustomKeyStoreName()).append(",");
    }
    if (getKeyStorePassword() != null) {
      sb.append("KeyStorePassword: ").append("***Sensitive Data Redacted***").append(",");
    }
    if (getCloudHsmClusterId() != null) {
      sb.append("CloudHsmClusterId: ").append(getCloudHsmClusterId());
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
    if (!(obj instanceof UpdateCustomKeyStoreRequest)) {
      return false;
    }
    UpdateCustomKeyStoreRequest other = (UpdateCustomKeyStoreRequest)obj;
    if (((other.getCustomKeyStoreId() == null ? 1 : 0) ^ (getCustomKeyStoreId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreId() != null) && (!other.getCustomKeyStoreId().equals(getCustomKeyStoreId()))) {
      return false;
    }
    if (((other.getNewCustomKeyStoreName() == null ? 1 : 0) ^ (getNewCustomKeyStoreName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNewCustomKeyStoreName() != null) && (!other.getNewCustomKeyStoreName().equals(getNewCustomKeyStoreName()))) {
      return false;
    }
    if (((other.getKeyStorePassword() == null ? 1 : 0) ^ (getKeyStorePassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyStorePassword() != null) && (!other.getKeyStorePassword().equals(getKeyStorePassword()))) {
      return false;
    }
    if (((other.getCloudHsmClusterId() == null ? 1 : 0) ^ (getCloudHsmClusterId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCloudHsmClusterId() != null) && (!other.getCloudHsmClusterId().equals(getCloudHsmClusterId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    hashCode = 31 * hashCode + (getNewCustomKeyStoreName() == null ? 0 : getNewCustomKeyStoreName().hashCode());
    hashCode = 31 * hashCode + (getKeyStorePassword() == null ? 0 : getKeyStorePassword().hashCode());
    hashCode = 31 * hashCode + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode());
    return hashCode;
  }
  
  public UpdateCustomKeyStoreRequest clone()
  {
    return (UpdateCustomKeyStoreRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */