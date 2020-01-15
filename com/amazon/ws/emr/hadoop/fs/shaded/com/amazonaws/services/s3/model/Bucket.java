package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class Bucket
  implements Serializable
{
  private static final long serialVersionUID = -8646831898339939580L;
  private String name = null;
  private Owner owner = null;
  private Date creationDate = null;
  
  public Bucket() {}
  
  public Bucket(String name)
  {
    this.name = name;
  }
  
  public String toString()
  {
    return 
    
      "S3Bucket [name=" + getName() + ", creationDate=" + getCreationDate() + ", owner=" + getOwner() + "]";
  }
  
  public Owner getOwner()
  {
    return owner;
  }
  
  public void setOwner(Owner owner)
  {
    this.owner = owner;
  }
  
  public Date getCreationDate()
  {
    return creationDate;
  }
  
  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }
  
  public String getName()
  {
    return name;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Bucket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */