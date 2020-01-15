package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import java.io.Serializable;

public class DashboardValidationMessage
  implements Serializable, Cloneable
{
  private String dataPath;
  private String message;
  
  public void setDataPath(String dataPath)
  {
    this.dataPath = dataPath;
  }
  
  public String getDataPath()
  {
    return dataPath;
  }
  
  public DashboardValidationMessage withDataPath(String dataPath)
  {
    setDataPath(dataPath);
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
  
  public DashboardValidationMessage withMessage(String message)
  {
    setMessage(message);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDataPath() != null) {
      sb.append("DataPath: ").append(getDataPath()).append(",");
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
    if (!(obj instanceof DashboardValidationMessage)) {
      return false;
    }
    DashboardValidationMessage other = (DashboardValidationMessage)obj;
    if (((other.getDataPath() == null ? 1 : 0) ^ (getDataPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDataPath() != null) && (!other.getDataPath().equals(getDataPath()))) {
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
    
    hashCode = 31 * hashCode + (getDataPath() == null ? 0 : getDataPath().hashCode());
    hashCode = 31 * hashCode + (getMessage() == null ? 0 : getMessage().hashCode());
    return hashCode;
  }
  
  public DashboardValidationMessage clone()
  {
    try
    {
      return (DashboardValidationMessage)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DashboardValidationMessage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */