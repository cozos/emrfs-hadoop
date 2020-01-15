package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetSessionTokenResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private Credentials credentials;
  
  public void setCredentials(Credentials credentials)
  {
    this.credentials = credentials;
  }
  
  public Credentials getCredentials()
  {
    return credentials;
  }
  
  public GetSessionTokenResult withCredentials(Credentials credentials)
  {
    setCredentials(credentials);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getCredentials() != null) {
      sb.append("Credentials: ").append(getCredentials());
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
    if (!(obj instanceof GetSessionTokenResult)) {
      return false;
    }
    GetSessionTokenResult other = (GetSessionTokenResult)obj;
    if (((other.getCredentials() == null ? 1 : 0) ^ (getCredentials() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCredentials() != null) && (!other.getCredentials().equals(getCredentials()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getCredentials() == null ? 0 : getCredentials().hashCode());
    return hashCode;
  }
  
  public GetSessionTokenResult clone()
  {
    try
    {
      return (GetSessionTokenResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */