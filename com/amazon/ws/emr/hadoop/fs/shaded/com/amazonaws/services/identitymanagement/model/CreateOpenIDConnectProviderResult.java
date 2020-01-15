package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateOpenIDConnectProviderResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String openIDConnectProviderArn;
  
  public void setOpenIDConnectProviderArn(String openIDConnectProviderArn)
  {
    this.openIDConnectProviderArn = openIDConnectProviderArn;
  }
  
  public String getOpenIDConnectProviderArn()
  {
    return openIDConnectProviderArn;
  }
  
  public CreateOpenIDConnectProviderResult withOpenIDConnectProviderArn(String openIDConnectProviderArn)
  {
    setOpenIDConnectProviderArn(openIDConnectProviderArn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getOpenIDConnectProviderArn() != null) {
      sb.append("OpenIDConnectProviderArn: ").append(getOpenIDConnectProviderArn());
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
    if (!(obj instanceof CreateOpenIDConnectProviderResult)) {
      return false;
    }
    CreateOpenIDConnectProviderResult other = (CreateOpenIDConnectProviderResult)obj;
    if (((other.getOpenIDConnectProviderArn() == null ? 1 : 0) ^ (getOpenIDConnectProviderArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOpenIDConnectProviderArn() != null) && (!other.getOpenIDConnectProviderArn().equals(getOpenIDConnectProviderArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getOpenIDConnectProviderArn() == null ? 0 : getOpenIDConnectProviderArn().hashCode());
    return hashCode;
  }
  
  public CreateOpenIDConnectProviderResult clone()
  {
    try
    {
      return (CreateOpenIDConnectProviderResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */