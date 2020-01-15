package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GetServerCertificateResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ServerCertificate serverCertificate;
  
  public void setServerCertificate(ServerCertificate serverCertificate)
  {
    this.serverCertificate = serverCertificate;
  }
  
  public ServerCertificate getServerCertificate()
  {
    return serverCertificate;
  }
  
  public GetServerCertificateResult withServerCertificate(ServerCertificate serverCertificate)
  {
    setServerCertificate(serverCertificate);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerCertificate() != null) {
      sb.append("ServerCertificate: ").append(getServerCertificate());
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
    if (!(obj instanceof GetServerCertificateResult)) {
      return false;
    }
    GetServerCertificateResult other = (GetServerCertificateResult)obj;
    if (((other.getServerCertificate() == null ? 1 : 0) ^ (getServerCertificate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificate() != null) && (!other.getServerCertificate().equals(getServerCertificate()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServerCertificate() == null ? 0 : getServerCertificate().hashCode());
    return hashCode;
  }
  
  public GetServerCertificateResult clone()
  {
    try
    {
      return (GetServerCertificateResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */