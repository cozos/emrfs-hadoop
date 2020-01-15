package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.ProtocolMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.protocol.StructuredPojo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepStateChangeReasonMarshaller;
import java.io.Serializable;

public class StepStateChangeReason
  implements Serializable, Cloneable, StructuredPojo
{
  private String code;
  private String message;
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public StepStateChangeReason withCode(String code)
  {
    setCode(code);
    return this;
  }
  
  public void setCode(StepStateChangeReasonCode code)
  {
    withCode(code);
  }
  
  public StepStateChangeReason withCode(StepStateChangeReasonCode code)
  {
    this.code = code.toString();
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
  
  public StepStateChangeReason withMessage(String message)
  {
    setMessage(message);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof StepStateChangeReason)) {
      return false;
    }
    StepStateChangeReason other = (StepStateChangeReason)obj;
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
    
    hashCode = 31 * hashCode + (getCode() == null ? 0 : getCode().hashCode());
    hashCode = 31 * hashCode + (getMessage() == null ? 0 : getMessage().hashCode());
    return hashCode;
  }
  
  public StepStateChangeReason clone()
  {
    try
    {
      return (StepStateChangeReason)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
  
  @SdkInternalApi
  public void marshall(ProtocolMarshaller protocolMarshaller)
  {
    StepStateChangeReasonMarshaller.getInstance().marshall(this, protocolMarshaller);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepStateChangeReason
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */