package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DecodeAuthorizationMessageRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String encodedMessage;
  
  public void setEncodedMessage(String encodedMessage)
  {
    this.encodedMessage = encodedMessage;
  }
  
  public String getEncodedMessage()
  {
    return encodedMessage;
  }
  
  public DecodeAuthorizationMessageRequest withEncodedMessage(String encodedMessage)
  {
    setEncodedMessage(encodedMessage);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEncodedMessage() != null) {
      sb.append("EncodedMessage: ").append(getEncodedMessage());
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
    if (!(obj instanceof DecodeAuthorizationMessageRequest)) {
      return false;
    }
    DecodeAuthorizationMessageRequest other = (DecodeAuthorizationMessageRequest)obj;
    if (((other.getEncodedMessage() == null ? 1 : 0) ^ (getEncodedMessage() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncodedMessage() != null) && (!other.getEncodedMessage().equals(getEncodedMessage()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEncodedMessage() == null ? 0 : getEncodedMessage().hashCode());
    return hashCode;
  }
  
  public DecodeAuthorizationMessageRequest clone()
  {
    return (DecodeAuthorizationMessageRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */