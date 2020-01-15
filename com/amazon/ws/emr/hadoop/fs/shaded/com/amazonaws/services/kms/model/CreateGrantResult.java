package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class CreateGrantResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String grantToken;
  private String grantId;
  
  public void setGrantToken(String grantToken)
  {
    this.grantToken = grantToken;
  }
  
  public String getGrantToken()
  {
    return grantToken;
  }
  
  public CreateGrantResult withGrantToken(String grantToken)
  {
    setGrantToken(grantToken);
    return this;
  }
  
  public void setGrantId(String grantId)
  {
    this.grantId = grantId;
  }
  
  public String getGrantId()
  {
    return grantId;
  }
  
  public CreateGrantResult withGrantId(String grantId)
  {
    setGrantId(grantId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getGrantToken() != null) {
      sb.append("GrantToken: ").append(getGrantToken()).append(",");
    }
    if (getGrantId() != null) {
      sb.append("GrantId: ").append(getGrantId());
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
    if (!(obj instanceof CreateGrantResult)) {
      return false;
    }
    CreateGrantResult other = (CreateGrantResult)obj;
    if (((other.getGrantToken() == null ? 1 : 0) ^ (getGrantToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantToken() != null) && (!other.getGrantToken().equals(getGrantToken()))) {
      return false;
    }
    if (((other.getGrantId() == null ? 1 : 0) ^ (getGrantId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantId() != null) && (!other.getGrantId().equals(getGrantId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getGrantToken() == null ? 0 : getGrantToken().hashCode());
    hashCode = 31 * hashCode + (getGrantId() == null ? 0 : getGrantId().hashCode());
    return hashCode;
  }
  
  public CreateGrantResult clone()
  {
    try
    {
      return (CreateGrantResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */