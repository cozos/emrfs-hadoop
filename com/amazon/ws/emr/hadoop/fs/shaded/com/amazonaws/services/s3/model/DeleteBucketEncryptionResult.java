package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class DeleteBucketEncryptionResult
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
    if (!(obj instanceof DeleteBucketEncryptionResult)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int hashCode = 1;
    return hashCode;
  }
  
  public DeleteBucketEncryptionResult clone()
  {
    try
    {
      return (DeleteBucketEncryptionResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteBucketEncryptionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */