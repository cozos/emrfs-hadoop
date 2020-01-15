package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class UpdateContinuousBackupsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private ContinuousBackupsDescription continuousBackupsDescription;
  
  public void setContinuousBackupsDescription(ContinuousBackupsDescription continuousBackupsDescription)
  {
    this.continuousBackupsDescription = continuousBackupsDescription;
  }
  
  public ContinuousBackupsDescription getContinuousBackupsDescription()
  {
    return continuousBackupsDescription;
  }
  
  public UpdateContinuousBackupsResult withContinuousBackupsDescription(ContinuousBackupsDescription continuousBackupsDescription)
  {
    setContinuousBackupsDescription(continuousBackupsDescription);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getContinuousBackupsDescription() != null) {
      sb.append("ContinuousBackupsDescription: ").append(getContinuousBackupsDescription());
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
    if (!(obj instanceof UpdateContinuousBackupsResult)) {
      return false;
    }
    UpdateContinuousBackupsResult other = (UpdateContinuousBackupsResult)obj;
    if (((other.getContinuousBackupsDescription() == null ? 1 : 0) ^ (getContinuousBackupsDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getContinuousBackupsDescription() != null) && (!other.getContinuousBackupsDescription().equals(getContinuousBackupsDescription()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getContinuousBackupsDescription() == null ? 0 : getContinuousBackupsDescription().hashCode());
    return hashCode;
  }
  
  public UpdateContinuousBackupsResult clone()
  {
    try
    {
      return (UpdateContinuousBackupsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */