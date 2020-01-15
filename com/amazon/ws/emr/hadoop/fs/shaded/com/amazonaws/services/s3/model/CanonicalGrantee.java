package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class CanonicalGrantee
  implements Grantee, Serializable
{
  private String id = null;
  private String displayName = null;
  
  public String getTypeIdentifier()
  {
    return "id";
  }
  
  public CanonicalGrantee(String identifier)
  {
    setIdentifier(identifier);
  }
  
  public void setIdentifier(String id)
  {
    this.id = id;
  }
  
  public String getIdentifier()
  {
    return id;
  }
  
  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }
  
  public String getDisplayName()
  {
    return displayName;
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof CanonicalGrantee))
    {
      CanonicalGrantee canonicalGrantee = (CanonicalGrantee)obj;
      return id.equals(id);
    }
    return false;
  }
  
  public int hashCode()
  {
    return id.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CanonicalGrantee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */