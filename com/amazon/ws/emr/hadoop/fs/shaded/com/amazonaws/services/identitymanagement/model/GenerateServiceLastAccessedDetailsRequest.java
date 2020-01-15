package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GenerateServiceLastAccessedDetailsRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String arn;
  
  public void setArn(String arn)
  {
    this.arn = arn;
  }
  
  public String getArn()
  {
    return arn;
  }
  
  public GenerateServiceLastAccessedDetailsRequest withArn(String arn)
  {
    setArn(arn);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getArn() != null) {
      sb.append("Arn: ").append(getArn());
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
    if (!(obj instanceof GenerateServiceLastAccessedDetailsRequest)) {
      return false;
    }
    GenerateServiceLastAccessedDetailsRequest other = (GenerateServiceLastAccessedDetailsRequest)obj;
    if (((other.getArn() == null ? 1 : 0) ^ (getArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getArn() != null) && (!other.getArn().equals(getArn()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getArn() == null ? 0 : getArn().hashCode());
    return hashCode;
  }
  
  public GenerateServiceLastAccessedDetailsRequest clone()
  {
    return (GenerateServiceLastAccessedDetailsRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */