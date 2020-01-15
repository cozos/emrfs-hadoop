package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetCallerIdentityRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(obj instanceof GetCallerIdentityRequest)) {
      return false;
    }
    GetCallerIdentityRequest other = (GetCallerIdentityRequest)obj;
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    return hashCode;
  }
  
  public GetCallerIdentityRequest clone()
  {
    return (GetCallerIdentityRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */