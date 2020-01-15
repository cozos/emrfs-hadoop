package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class OutputLocation
  implements Serializable, Cloneable
{
  private S3Location s3;
  
  public S3Location getS3()
  {
    return s3;
  }
  
  public void setS3(S3Location s3)
  {
    this.s3 = s3;
  }
  
  public OutputLocation withS3(S3Location s3)
  {
    setS3(s3);
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof OutputLocation))) {
      return false;
    }
    OutputLocation other = (OutputLocation)obj;
    if (((other.getS3() == null ? 1 : 0) ^ (getS3() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getS3() != null) && (!other.getS3().equals(getS3()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getS3() == null ? 0 : getS3().hashCode());
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getS3() != null) {
      sb.append("S3: ").append(getS3());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public OutputLocation clone()
  {
    try
    {
      return (OutputLocation)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.OutputLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */