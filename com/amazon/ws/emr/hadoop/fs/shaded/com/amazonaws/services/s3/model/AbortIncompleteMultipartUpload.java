package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class AbortIncompleteMultipartUpload
  implements Serializable
{
  private int daysAfterInitiation;
  
  public int getDaysAfterInitiation()
  {
    return daysAfterInitiation;
  }
  
  public void setDaysAfterInitiation(int daysAfterInitiation)
  {
    this.daysAfterInitiation = daysAfterInitiation;
  }
  
  public AbortIncompleteMultipartUpload withDaysAfterInitiation(int daysAfterInitiation)
  {
    setDaysAfterInitiation(daysAfterInitiation);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    AbortIncompleteMultipartUpload that = (AbortIncompleteMultipartUpload)o;
    
    return daysAfterInitiation == daysAfterInitiation;
  }
  
  public int hashCode()
  {
    return daysAfterInitiation;
  }
  
  protected AbortIncompleteMultipartUpload clone()
    throws CloneNotSupportedException
  {
    try
    {
      return (AbortIncompleteMultipartUpload)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */