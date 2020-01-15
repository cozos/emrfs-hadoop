package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.FailureDetailsMarshaller;
import java.io.Serializable;

public class FailureDetails
  implements Serializable, Cloneable, StructuredPojo
{
  private String reason;
  private String message;
  private String logFile;
  
  public void setReason(String reason)
  {
    this.reason = reason;
  }
  
  public String getReason()
  {
    return reason;
  }
  
  public FailureDetails withReason(String reason)
  {
    setReason(reason);
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
  
  public FailureDetails withMessage(String message)
  {
    setMessage(message);
    return this;
  }
  
  public void setLogFile(String logFile)
  {
    this.logFile = logFile;
  }
  
  public String getLogFile()
  {
    return logFile;
  }
  
  public FailureDetails withLogFile(String logFile)
  {
    setLogFile(logFile);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getReason() != null) {
      sb.append("Reason: ").append(getReason()).append(",");
    }
    if (getMessage() != null) {
      sb.append("Message: ").append(getMessage()).append(",");
    }
    if (getLogFile() != null) {
      sb.append("LogFile: ").append(getLogFile());
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
    if (!(obj instanceof FailureDetails)) {
      return false;
    }
    FailureDetails other = (FailureDetails)obj;
    if (((other.getReason() == null ? 1 : 0) ^ (getReason() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getReason() != null) && (!other.getReason().equals(getReason()))) {
      return false;
    }
    if (((other.getMessage() == null ? 1 : 0) ^ (getMessage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMessage() != null) && (!other.getMessage().equals(getMessage()))) {
      return false;
    }
    if (((other.getLogFile() == null ? 1 : 0) ^ (getLogFile() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getLogFile() != null) && (!other.getLogFile().equals(getLogFile()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getReason() == null ? 0 : getReason().hashCode());
    hashCode = 31 * hashCode + (getMessage() == null ? 0 : getMessage().hashCode());
    hashCode = 31 * hashCode + (getLogFile() == null ? 0 : getLogFile().hashCode());
    return hashCode;
  }
  
  public FailureDetails clone()
  {
    try
    {
      return (FailureDetails)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    FailureDetailsMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.FailureDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */