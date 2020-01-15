package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import java.io.Serializable;

public class Statement
  implements Serializable, Cloneable
{
  private String sourcePolicyId;
  private String sourcePolicyType;
  private Position startPosition;
  private Position endPosition;
  
  public void setSourcePolicyId(String sourcePolicyId)
  {
    this.sourcePolicyId = sourcePolicyId;
  }
  
  public String getSourcePolicyId()
  {
    return sourcePolicyId;
  }
  
  public Statement withSourcePolicyId(String sourcePolicyId)
  {
    setSourcePolicyId(sourcePolicyId);
    return this;
  }
  
  public void setSourcePolicyType(String sourcePolicyType)
  {
    this.sourcePolicyType = sourcePolicyType;
  }
  
  public String getSourcePolicyType()
  {
    return sourcePolicyType;
  }
  
  public Statement withSourcePolicyType(String sourcePolicyType)
  {
    setSourcePolicyType(sourcePolicyType);
    return this;
  }
  
  public void setSourcePolicyType(PolicySourceType sourcePolicyType)
  {
    withSourcePolicyType(sourcePolicyType);
  }
  
  public Statement withSourcePolicyType(PolicySourceType sourcePolicyType)
  {
    this.sourcePolicyType = sourcePolicyType.toString();
    return this;
  }
  
  public void setStartPosition(Position startPosition)
  {
    this.startPosition = startPosition;
  }
  
  public Position getStartPosition()
  {
    return startPosition;
  }
  
  public Statement withStartPosition(Position startPosition)
  {
    setStartPosition(startPosition);
    return this;
  }
  
  public void setEndPosition(Position endPosition)
  {
    this.endPosition = endPosition;
  }
  
  public Position getEndPosition()
  {
    return endPosition;
  }
  
  public Statement withEndPosition(Position endPosition)
  {
    setEndPosition(endPosition);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getSourcePolicyId() != null) {
      sb.append("SourcePolicyId: ").append(getSourcePolicyId()).append(",");
    }
    if (getSourcePolicyType() != null) {
      sb.append("SourcePolicyType: ").append(getSourcePolicyType()).append(",");
    }
    if (getStartPosition() != null) {
      sb.append("StartPosition: ").append(getStartPosition()).append(",");
    }
    if (getEndPosition() != null) {
      sb.append("EndPosition: ").append(getEndPosition());
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
    if (!(obj instanceof Statement)) {
      return false;
    }
    Statement other = (Statement)obj;
    if (((other.getSourcePolicyId() == null ? 1 : 0) ^ (getSourcePolicyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourcePolicyId() != null) && (!other.getSourcePolicyId().equals(getSourcePolicyId()))) {
      return false;
    }
    if (((other.getSourcePolicyType() == null ? 1 : 0) ^ (getSourcePolicyType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSourcePolicyType() != null) && (!other.getSourcePolicyType().equals(getSourcePolicyType()))) {
      return false;
    }
    if (((other.getStartPosition() == null ? 1 : 0) ^ (getStartPosition() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStartPosition() != null) && (!other.getStartPosition().equals(getStartPosition()))) {
      return false;
    }
    if (((other.getEndPosition() == null ? 1 : 0) ^ (getEndPosition() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndPosition() != null) && (!other.getEndPosition().equals(getEndPosition()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getSourcePolicyId() == null ? 0 : getSourcePolicyId().hashCode());
    hashCode = 31 * hashCode + (getSourcePolicyType() == null ? 0 : getSourcePolicyType().hashCode());
    hashCode = 31 * hashCode + (getStartPosition() == null ? 0 : getStartPosition().hashCode());
    hashCode = 31 * hashCode + (getEndPosition() == null ? 0 : getEndPosition().hashCode());
    return hashCode;
  }
  
  public Statement clone()
  {
    try
    {
      return (Statement)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Statement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */