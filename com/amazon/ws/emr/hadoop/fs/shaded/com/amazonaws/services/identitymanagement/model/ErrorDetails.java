package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class ErrorDetails
  implements Serializable, Cloneable
{
  private String message;
  private String code;
  
  public void setMessage(String message)
  {
    this.message = message;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public ErrorDetails withMessage(String message)
  {
    setMessage(message);
    return this;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public ErrorDetails withCode(String code)
  {
    setCode(code);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getMessage() != null) {
      sb.append("Message: ").append(getMessage()).append(",");
    }
    if (getCode() != null) {
      sb.append("Code: ").append(getCode());
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
    if (!(obj instanceof ErrorDetails)) {
      return false;
    }
    ErrorDetails other = (ErrorDetails)obj;
    if (((other.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessage() != null) && (!other.getMessage().equals(getMessage()))) {
      return false;
    }
    if (((other.getCode() == null ? 1 : 0) ^ (getCode() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCode() != null) && (!other.getCode().equals(getCode()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getMessage() == null ? 0 : getMessage().hashCode());
    hashCode = 31 * hashCode + (getCode() == null ? 0 : getCode().hashCode());
    return hashCode;
  }
  
  public ErrorDetails clone()
  {
    try
    {
      return (ErrorDetails)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ErrorDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */