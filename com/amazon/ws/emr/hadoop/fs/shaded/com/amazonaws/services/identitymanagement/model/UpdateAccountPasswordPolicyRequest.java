package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateAccountPasswordPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private Integer minimumPasswordLength;
  private Boolean requireSymbols;
  private Boolean requireNumbers;
  private Boolean requireUppercaseCharacters;
  private Boolean requireLowercaseCharacters;
  private Boolean allowUsersToChangePassword;
  private Integer maxPasswordAge;
  private Integer passwordReusePrevention;
  private Boolean hardExpiry;
  
  public void setMinimumPasswordLength(Integer minimumPasswordLength)
  {
    this.minimumPasswordLength = minimumPasswordLength;
  }
  
  public Integer getMinimumPasswordLength()
  {
    return minimumPasswordLength;
  }
  
  public UpdateAccountPasswordPolicyRequest withMinimumPasswordLength(Integer minimumPasswordLength)
  {
    setMinimumPasswordLength(minimumPasswordLength);
    return this;
  }
  
  public void setRequireSymbols(Boolean requireSymbols)
  {
    this.requireSymbols = requireSymbols;
  }
  
  public Boolean getRequireSymbols()
  {
    return requireSymbols;
  }
  
  public UpdateAccountPasswordPolicyRequest withRequireSymbols(Boolean requireSymbols)
  {
    setRequireSymbols(requireSymbols);
    return this;
  }
  
  public Boolean isRequireSymbols()
  {
    return requireSymbols;
  }
  
  public void setRequireNumbers(Boolean requireNumbers)
  {
    this.requireNumbers = requireNumbers;
  }
  
  public Boolean getRequireNumbers()
  {
    return requireNumbers;
  }
  
  public UpdateAccountPasswordPolicyRequest withRequireNumbers(Boolean requireNumbers)
  {
    setRequireNumbers(requireNumbers);
    return this;
  }
  
  public Boolean isRequireNumbers()
  {
    return requireNumbers;
  }
  
  public void setRequireUppercaseCharacters(Boolean requireUppercaseCharacters)
  {
    this.requireUppercaseCharacters = requireUppercaseCharacters;
  }
  
  public Boolean getRequireUppercaseCharacters()
  {
    return requireUppercaseCharacters;
  }
  
  public UpdateAccountPasswordPolicyRequest withRequireUppercaseCharacters(Boolean requireUppercaseCharacters)
  {
    setRequireUppercaseCharacters(requireUppercaseCharacters);
    return this;
  }
  
  public Boolean isRequireUppercaseCharacters()
  {
    return requireUppercaseCharacters;
  }
  
  public void setRequireLowercaseCharacters(Boolean requireLowercaseCharacters)
  {
    this.requireLowercaseCharacters = requireLowercaseCharacters;
  }
  
  public Boolean getRequireLowercaseCharacters()
  {
    return requireLowercaseCharacters;
  }
  
  public UpdateAccountPasswordPolicyRequest withRequireLowercaseCharacters(Boolean requireLowercaseCharacters)
  {
    setRequireLowercaseCharacters(requireLowercaseCharacters);
    return this;
  }
  
  public Boolean isRequireLowercaseCharacters()
  {
    return requireLowercaseCharacters;
  }
  
  public void setAllowUsersToChangePassword(Boolean allowUsersToChangePassword)
  {
    this.allowUsersToChangePassword = allowUsersToChangePassword;
  }
  
  public Boolean getAllowUsersToChangePassword()
  {
    return allowUsersToChangePassword;
  }
  
  public UpdateAccountPasswordPolicyRequest withAllowUsersToChangePassword(Boolean allowUsersToChangePassword)
  {
    setAllowUsersToChangePassword(allowUsersToChangePassword);
    return this;
  }
  
  public Boolean isAllowUsersToChangePassword()
  {
    return allowUsersToChangePassword;
  }
  
  public void setMaxPasswordAge(Integer maxPasswordAge)
  {
    this.maxPasswordAge = maxPasswordAge;
  }
  
  public Integer getMaxPasswordAge()
  {
    return maxPasswordAge;
  }
  
  public UpdateAccountPasswordPolicyRequest withMaxPasswordAge(Integer maxPasswordAge)
  {
    setMaxPasswordAge(maxPasswordAge);
    return this;
  }
  
  public void setPasswordReusePrevention(Integer passwordReusePrevention)
  {
    this.passwordReusePrevention = passwordReusePrevention;
  }
  
  public Integer getPasswordReusePrevention()
  {
    return passwordReusePrevention;
  }
  
  public UpdateAccountPasswordPolicyRequest withPasswordReusePrevention(Integer passwordReusePrevention)
  {
    setPasswordReusePrevention(passwordReusePrevention);
    return this;
  }
  
  public void setHardExpiry(Boolean hardExpiry)
  {
    this.hardExpiry = hardExpiry;
  }
  
  public Boolean getHardExpiry()
  {
    return hardExpiry;
  }
  
  public UpdateAccountPasswordPolicyRequest withHardExpiry(Boolean hardExpiry)
  {
    setHardExpiry(hardExpiry);
    return this;
  }
  
  public Boolean isHardExpiry()
  {
    return hardExpiry;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMinimumPasswordLength() != null) {
      sb.append("MinimumPasswordLength: ").append(getMinimumPasswordLength()).append(",");
    }
    if (getRequireSymbols() != null) {
      sb.append("RequireSymbols: ").append(getRequireSymbols()).append(",");
    }
    if (getRequireNumbers() != null) {
      sb.append("RequireNumbers: ").append(getRequireNumbers()).append(",");
    }
    if (getRequireUppercaseCharacters() != null) {
      sb.append("RequireUppercaseCharacters: ").append(getRequireUppercaseCharacters()).append(",");
    }
    if (getRequireLowercaseCharacters() != null) {
      sb.append("RequireLowercaseCharacters: ").append(getRequireLowercaseCharacters()).append(",");
    }
    if (getAllowUsersToChangePassword() != null) {
      sb.append("AllowUsersToChangePassword: ").append(getAllowUsersToChangePassword()).append(",");
    }
    if (getMaxPasswordAge() != null) {
      sb.append("MaxPasswordAge: ").append(getMaxPasswordAge()).append(",");
    }
    if (getPasswordReusePrevention() != null) {
      sb.append("PasswordReusePrevention: ").append(getPasswordReusePrevention()).append(",");
    }
    if (getHardExpiry() != null) {
      sb.append("HardExpiry: ").append(getHardExpiry());
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
    if (!(obj instanceof UpdateAccountPasswordPolicyRequest)) {
      return false;
    }
    UpdateAccountPasswordPolicyRequest other = (UpdateAccountPasswordPolicyRequest)obj;
    if (((other.getMinimumPasswordLength() == null ? 1 : 0) ^ (getMinimumPasswordLength() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMinimumPasswordLength() != null) && (!other.getMinimumPasswordLength().equals(getMinimumPasswordLength()))) {
      return false;
    }
    if (((other.getRequireSymbols() == null ? 1 : 0) ^ (getRequireSymbols() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequireSymbols() != null) && (!other.getRequireSymbols().equals(getRequireSymbols()))) {
      return false;
    }
    if (((other.getRequireNumbers() == null ? 1 : 0) ^ (getRequireNumbers() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequireNumbers() != null) && (!other.getRequireNumbers().equals(getRequireNumbers()))) {
      return false;
    }
    if (((other.getRequireUppercaseCharacters() == null ? 1 : 0) ^ (getRequireUppercaseCharacters() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequireUppercaseCharacters() != null) && (!other.getRequireUppercaseCharacters().equals(getRequireUppercaseCharacters()))) {
      return false;
    }
    if (((other.getRequireLowercaseCharacters() == null ? 1 : 0) ^ (getRequireLowercaseCharacters() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRequireLowercaseCharacters() != null) && (!other.getRequireLowercaseCharacters().equals(getRequireLowercaseCharacters()))) {
      return false;
    }
    if (((other.getAllowUsersToChangePassword() == null ? 1 : 0) ^ (getAllowUsersToChangePassword() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAllowUsersToChangePassword() != null) && (!other.getAllowUsersToChangePassword().equals(getAllowUsersToChangePassword()))) {
      return false;
    }
    if (((other.getMaxPasswordAge() == null ? 1 : 0) ^ (getMaxPasswordAge() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxPasswordAge() != null) && (!other.getMaxPasswordAge().equals(getMaxPasswordAge()))) {
      return false;
    }
    if (((other.getPasswordReusePrevention() == null ? 1 : 0) ^ (getPasswordReusePrevention() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPasswordReusePrevention() != null) && (!other.getPasswordReusePrevention().equals(getPasswordReusePrevention()))) {
      return false;
    }
    if (((other.getHardExpiry() == null ? 1 : 0) ^ (getHardExpiry() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getHardExpiry() != null) && (!other.getHardExpiry().equals(getHardExpiry()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMinimumPasswordLength() == null ? 0 : getMinimumPasswordLength().hashCode());
    hashCode = 31 * hashCode + (getRequireSymbols() == null ? 0 : getRequireSymbols().hashCode());
    hashCode = 31 * hashCode + (getRequireNumbers() == null ? 0 : getRequireNumbers().hashCode());
    hashCode = 31 * hashCode + (getRequireUppercaseCharacters() == null ? 0 : getRequireUppercaseCharacters().hashCode());
    hashCode = 31 * hashCode + (getRequireLowercaseCharacters() == null ? 0 : getRequireLowercaseCharacters().hashCode());
    hashCode = 31 * hashCode + (getAllowUsersToChangePassword() == null ? 0 : getAllowUsersToChangePassword().hashCode());
    hashCode = 31 * hashCode + (getMaxPasswordAge() == null ? 0 : getMaxPasswordAge().hashCode());
    hashCode = 31 * hashCode + (getPasswordReusePrevention() == null ? 0 : getPasswordReusePrevention().hashCode());
    hashCode = 31 * hashCode + (getHardExpiry() == null ? 0 : getHardExpiry().hashCode());
    return hashCode;
  }
  
  public UpdateAccountPasswordPolicyRequest clone()
  {
    return (UpdateAccountPasswordPolicyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */