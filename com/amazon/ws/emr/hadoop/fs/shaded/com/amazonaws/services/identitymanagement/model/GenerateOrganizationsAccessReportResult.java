package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;

public class GenerateOrganizationsAccessReportResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String jobId;
  
  public void setJobId(String jobId)
  {
    this.jobId = jobId;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public GenerateOrganizationsAccessReportResult withJobId(String jobId)
  {
    setJobId(jobId);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobId() != null) {
      sb.append("JobId: ").append(getJobId());
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
    if (!(obj instanceof GenerateOrganizationsAccessReportResult)) {
      return false;
    }
    GenerateOrganizationsAccessReportResult other = (GenerateOrganizationsAccessReportResult)obj;
    if (((other.getJobId() == null ? 1 : 0) ^ (getJobId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobId() != null) && (!other.getJobId().equals(getJobId()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobId() == null ? 0 : getJobId().hashCode());
    return hashCode;
  }
  
  public GenerateOrganizationsAccessReportResult clone()
  {
    try
    {
      return (GenerateOrganizationsAccessReportResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */