package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class SourceSelectionCriteria
  implements Serializable, Cloneable
{
  private SseKmsEncryptedObjects sseKmsEncryptedObjects;
  
  public SseKmsEncryptedObjects getSseKmsEncryptedObjects()
  {
    return sseKmsEncryptedObjects;
  }
  
  public void setSseKmsEncryptedObjects(SseKmsEncryptedObjects sseKmsEncryptedObjects)
  {
    this.sseKmsEncryptedObjects = sseKmsEncryptedObjects;
  }
  
  public SourceSelectionCriteria withSseKmsEncryptedObjects(SseKmsEncryptedObjects sseKmsEncryptedObjects)
  {
    setSseKmsEncryptedObjects(sseKmsEncryptedObjects);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSseKmsEncryptedObjects() != null) {
      sb.append("SseKmsEncryptedObjects: ").append(getSseKmsEncryptedObjects()).append(",");
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
    if (!(obj instanceof SourceSelectionCriteria)) {
      return false;
    }
    SourceSelectionCriteria other = (SourceSelectionCriteria)obj;
    if (((other.getSseKmsEncryptedObjects() == null ? 1 : 0) ^ (getSseKmsEncryptedObjects() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSseKmsEncryptedObjects() != null) && 
      (!other.getSseKmsEncryptedObjects().equals(getSseKmsEncryptedObjects()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSseKmsEncryptedObjects() == null ? 0 : getSseKmsEncryptedObjects().hashCode());
    return hashCode;
  }
  
  public SourceSelectionCriteria clone()
  {
    try
    {
      return (SourceSelectionCriteria)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SourceSelectionCriteria
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */