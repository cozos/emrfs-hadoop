package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CreateKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String policy;
  private String description;
  private String keyUsage;
  private String origin;
  private String customKeyStoreId;
  private Boolean bypassPolicyLockoutSafetyCheck;
  private SdkInternalList<Tag> tags;
  
  public void setPolicy(String policy)
  {
    this.policy = policy;
  }
  
  public String getPolicy()
  {
    return policy;
  }
  
  public CreateKeyRequest withPolicy(String policy)
  {
    setPolicy(policy);
    return this;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public CreateKeyRequest withDescription(String description)
  {
    setDescription(description);
    return this;
  }
  
  public void setKeyUsage(String keyUsage)
  {
    this.keyUsage = keyUsage;
  }
  
  public String getKeyUsage()
  {
    return keyUsage;
  }
  
  public CreateKeyRequest withKeyUsage(String keyUsage)
  {
    setKeyUsage(keyUsage);
    return this;
  }
  
  public void setKeyUsage(KeyUsageType keyUsage)
  {
    withKeyUsage(keyUsage);
  }
  
  public CreateKeyRequest withKeyUsage(KeyUsageType keyUsage)
  {
    this.keyUsage = keyUsage.toString();
    return this;
  }
  
  public void setOrigin(String origin)
  {
    this.origin = origin;
  }
  
  public String getOrigin()
  {
    return origin;
  }
  
  public CreateKeyRequest withOrigin(String origin)
  {
    setOrigin(origin);
    return this;
  }
  
  public void setOrigin(OriginType origin)
  {
    withOrigin(origin);
  }
  
  public CreateKeyRequest withOrigin(OriginType origin)
  {
    this.origin = origin.toString();
    return this;
  }
  
  public void setCustomKeyStoreId(String customKeyStoreId)
  {
    this.customKeyStoreId = customKeyStoreId;
  }
  
  public String getCustomKeyStoreId()
  {
    return customKeyStoreId;
  }
  
  public CreateKeyRequest withCustomKeyStoreId(String customKeyStoreId)
  {
    setCustomKeyStoreId(customKeyStoreId);
    return this;
  }
  
  public void setBypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck)
  {
    this.bypassPolicyLockoutSafetyCheck = bypassPolicyLockoutSafetyCheck;
  }
  
  public Boolean getBypassPolicyLockoutSafetyCheck()
  {
    return bypassPolicyLockoutSafetyCheck;
  }
  
  public CreateKeyRequest withBypassPolicyLockoutSafetyCheck(Boolean bypassPolicyLockoutSafetyCheck)
  {
    setBypassPolicyLockoutSafetyCheck(bypassPolicyLockoutSafetyCheck);
    return this;
  }
  
  public Boolean isBypassPolicyLockoutSafetyCheck()
  {
    return bypassPolicyLockoutSafetyCheck;
  }
  
  public List<Tag> getTags()
  {
    if (tags == null) {
      tags = new SdkInternalList();
    }
    return tags;
  }
  
  public void setTags(Collection<Tag> tags)
  {
    if (tags == null)
    {
      this.tags = null;
      return;
    }
    this.tags = new SdkInternalList(tags);
  }
  
  public CreateKeyRequest withTags(Tag... tags)
  {
    if (this.tags == null) {
      setTags(new SdkInternalList(tags.length));
    }
    for (Tag ele : tags) {
      this.tags.add(ele);
    }
    return this;
  }
  
  public CreateKeyRequest withTags(Collection<Tag> tags)
  {
    setTags(tags);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getPolicy() != null) {
      sb.append("Policy: ").append(getPolicy()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getKeyUsage() != null) {
      sb.append("KeyUsage: ").append(getKeyUsage()).append(",");
    }
    if (getOrigin() != null) {
      sb.append("Origin: ").append(getOrigin()).append(",");
    }
    if (getCustomKeyStoreId() != null) {
      sb.append("CustomKeyStoreId: ").append(getCustomKeyStoreId()).append(",");
    }
    if (getBypassPolicyLockoutSafetyCheck() != null) {
      sb.append("BypassPolicyLockoutSafetyCheck: ").append(getBypassPolicyLockoutSafetyCheck()).append(",");
    }
    if (getTags() != null) {
      sb.append("Tags: ").append(getTags());
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
    if (!(obj instanceof CreateKeyRequest)) {
      return false;
    }
    CreateKeyRequest other = (CreateKeyRequest)obj;
    if (((other.getPolicy() == null ? 1 : 0) ^ (getPolicy() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPolicy() != null) && (!other.getPolicy().equals(getPolicy()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getKeyUsage() == null ? 1 : 0) ^ (getKeyUsage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyUsage() != null) && (!other.getKeyUsage().equals(getKeyUsage()))) {
      return false;
    }
    if (((other.getOrigin() == null ? 1 : 0) ^ (getOrigin() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOrigin() != null) && (!other.getOrigin().equals(getOrigin()))) {
      return false;
    }
    if (((other.getCustomKeyStoreId() == null ? 1 : 0) ^ (getCustomKeyStoreId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCustomKeyStoreId() != null) && (!other.getCustomKeyStoreId().equals(getCustomKeyStoreId()))) {
      return false;
    }
    if (((other.getBypassPolicyLockoutSafetyCheck() == null ? 1 : 0) ^ (getBypassPolicyLockoutSafetyCheck() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBypassPolicyLockoutSafetyCheck() != null) && 
      (!other.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck()))) {
      return false;
    }
    if (((other.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTags() != null) && (!other.getTags().equals(getTags()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getPolicy() == null ? 0 : getPolicy().hashCode());
    hashCode = 31 * hashCode + (getDescription() == null ? 0 : getDescription().hashCode());
    hashCode = 31 * hashCode + (getKeyUsage() == null ? 0 : getKeyUsage().hashCode());
    hashCode = 31 * hashCode + (getOrigin() == null ? 0 : getOrigin().hashCode());
    hashCode = 31 * hashCode + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode());
    hashCode = 31 * hashCode + (getBypassPolicyLockoutSafetyCheck() == null ? 0 : getBypassPolicyLockoutSafetyCheck().hashCode());
    hashCode = 31 * hashCode + (getTags() == null ? 0 : getTags().hashCode());
    return hashCode;
  }
  
  public CreateKeyRequest clone()
  {
    return (CreateKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */