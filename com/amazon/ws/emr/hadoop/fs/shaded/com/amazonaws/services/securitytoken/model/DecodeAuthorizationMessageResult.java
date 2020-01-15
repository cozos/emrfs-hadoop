package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class DecodeAuthorizationMessageResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String decodedMessage;
  
  public void setDecodedMessage(String decodedMessage)
  {
    this.decodedMessage = decodedMessage;
  }
  
  public String getDecodedMessage()
  {
    return decodedMessage;
  }
  
  public DecodeAuthorizationMessageResult withDecodedMessage(String decodedMessage)
  {
    setDecodedMessage(decodedMessage);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDecodedMessage() != null) {
      sb.append("DecodedMessage: ").append(getDecodedMessage());
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
    if (!(obj instanceof DecodeAuthorizationMessageResult)) {
      return false;
    }
    DecodeAuthorizationMessageResult other = (DecodeAuthorizationMessageResult)obj;
    if (((other.getDecodedMessage() == null ? 1 : 0) ^ (getDecodedMessage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDecodedMessage() != null) && (!other.getDecodedMessage().equals(getDecodedMessage()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDecodedMessage() == null ? 0 : getDecodedMessage().hashCode());
    return hashCode;
  }
  
  public DecodeAuthorizationMessageResult clone()
  {
    try
    {
      return (DecodeAuthorizationMessageResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */