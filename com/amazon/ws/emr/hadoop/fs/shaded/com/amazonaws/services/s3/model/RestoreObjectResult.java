package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RestoreOutputPathResult;
import java.io.Serializable;

public class RestoreObjectResult
  implements Serializable, S3RequesterChargedResult, S3RestoreOutputPathResult
{
  private boolean isRequesterCharged;
  private String restoreOutputPath;
  
  public boolean isRequesterCharged()
  {
    return isRequesterCharged;
  }
  
  public void setRequesterCharged(boolean isRequesterCharged)
  {
    this.isRequesterCharged = isRequesterCharged;
  }
  
  public String getRestoreOutputPath()
  {
    return restoreOutputPath;
  }
  
  public void setRestoreOutputPath(String restoreOutputPath)
  {
    this.restoreOutputPath = restoreOutputPath;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getRestoreOutputPath() != null) {
      sb.append("restoreOutputPath: ").append(getRestoreOutputPath()).append(",");
    }
    sb.append("isRequestCharged: ").append(isRequesterCharged());
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof RestoreObjectResult))) {
      return false;
    }
    RestoreObjectResult other = (RestoreObjectResult)obj;
    if (((other.getRestoreOutputPath() == null ? 1 : 0) ^ (getRestoreOutputPath() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getRestoreOutputPath() != null) && (!other.getRestoreOutputPath().equals(getRestoreOutputPath()))) {
      return false;
    }
    if (other.isRequesterCharged() != isRequesterCharged()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getRestoreOutputPath() == null ? 0 : getRestoreOutputPath().hashCode());
    return hashCode;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */