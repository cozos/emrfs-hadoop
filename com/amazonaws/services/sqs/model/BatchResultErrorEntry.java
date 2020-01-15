package com.amazonaws.services.sqs.model;

import java.io.Serializable;

public class BatchResultErrorEntry
  implements Serializable, Cloneable
{
  private String id;
  private Boolean senderFault;
  private String code;
  private String message;
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  public String getId()
  {
    return id;
  }
  
  public BatchResultErrorEntry withId(String id)
  {
    setId(id);
    return this;
  }
  
  public void setSenderFault(Boolean senderFault)
  {
    this.senderFault = senderFault;
  }
  
  public Boolean getSenderFault()
  {
    return senderFault;
  }
  
  public BatchResultErrorEntry withSenderFault(Boolean senderFault)
  {
    setSenderFault(senderFault);
    return this;
  }
  
  public Boolean isSenderFault()
  {
    return senderFault;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public BatchResultErrorEntry withCode(String code)
  {
    setCode(code);
    return this;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public BatchResultErrorEntry withMessage(String message)
  {
    setMessage(message);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getId() != null) {
      sb.append("Id: ").append(getId()).append(",");
    }
    if (getSenderFault() != null) {
      sb.append("SenderFault: ").append(getSenderFault()).append(",");
    }
    if (getCode() != null) {
      sb.append("Code: ").append(getCode()).append(",");
    }
    if (getMessage() != null) {
      sb.append("Message: ").append(getMessage());
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
    if (!(obj instanceof BatchResultErrorEntry)) {
      return false;
    }
    BatchResultErrorEntry other = (BatchResultErrorEntry)obj;
    if (((other.getId() == null ? 1 : 0) ^ (getId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getId() != null) && (!other.getId().equals(getId()))) {
      return false;
    }
    if (((other.getSenderFault() == null ? 1 : 0) ^ (getSenderFault() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSenderFault() != null) && (!other.getSenderFault().equals(getSenderFault()))) {
      return false;
    }
    if (((other.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCode() != null) && (!other.getCode().equals(getCode()))) {
      return false;
    }
    if (((other.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessage() != null) && (!other.getMessage().equals(getMessage()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getId() == null ? 0 : getId().hashCode());
    hashCode = 31 * hashCode + (getSenderFault() == null ? 0 : getSenderFault().hashCode());
    hashCode = 31 * hashCode + (getCode() == null ? 0 : getCode().hashCode());
    hashCode = 31 * hashCode + (getMessage() == null ? 0 : getMessage().hashCode());
    return hashCode;
  }
  
  public BatchResultErrorEntry clone()
  {
    try
    {
      return (BatchResultErrorEntry)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.BatchResultErrorEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */