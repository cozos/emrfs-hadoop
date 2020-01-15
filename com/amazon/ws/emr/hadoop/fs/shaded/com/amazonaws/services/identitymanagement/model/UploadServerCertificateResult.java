package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class UploadServerCertificateResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ServerCertificateMetadata serverCertificateMetadata;
  
  public void setServerCertificateMetadata(ServerCertificateMetadata serverCertificateMetadata)
  {
    this.serverCertificateMetadata = serverCertificateMetadata;
  }
  
  public ServerCertificateMetadata getServerCertificateMetadata()
  {
    return serverCertificateMetadata;
  }
  
  public UploadServerCertificateResult withServerCertificateMetadata(ServerCertificateMetadata serverCertificateMetadata)
  {
    setServerCertificateMetadata(serverCertificateMetadata);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getServerCertificateMetadata() != null) {
      sb.append("ServerCertificateMetadata: ").append(getServerCertificateMetadata());
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
    if (!(obj instanceof UploadServerCertificateResult)) {
      return false;
    }
    UploadServerCertificateResult other = (UploadServerCertificateResult)obj;
    if (((other.getServerCertificateMetadata() == null ? 1 : 0) ^ (getServerCertificateMetadata() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServerCertificateMetadata() != null) && (!other.getServerCertificateMetadata().equals(getServerCertificateMetadata()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getServerCertificateMetadata() == null ? 0 : getServerCertificateMetadata().hashCode());
    return hashCode;
  }
  
  public UploadServerCertificateResult clone()
  {
    try
    {
      return (UploadServerCertificateResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */