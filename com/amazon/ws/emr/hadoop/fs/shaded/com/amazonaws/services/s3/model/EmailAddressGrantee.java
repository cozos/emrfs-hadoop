package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class EmailAddressGrantee
  implements Grantee, Serializable
{
  private String emailAddress = null;
  
  public String getTypeIdentifier()
  {
    return "emailAddress";
  }
  
  public EmailAddressGrantee(String emailAddress)
  {
    setIdentifier(emailAddress);
  }
  
  public void setIdentifier(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }
  
  public String getIdentifier()
  {
    return emailAddress;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + (emailAddress == null ? 0 : emailAddress.hashCode());
    return result;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    EmailAddressGrantee other = (EmailAddressGrantee)obj;
    if (emailAddress == null)
    {
      if (emailAddress != null) {
        return false;
      }
    }
    else if (!emailAddress.equals(emailAddress)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return emailAddress;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.EmailAddressGrantee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */