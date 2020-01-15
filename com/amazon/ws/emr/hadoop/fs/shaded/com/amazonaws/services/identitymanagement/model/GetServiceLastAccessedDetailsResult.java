package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GetServiceLastAccessedDetailsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String jobStatus;
  private Date jobCreationDate;
  private SdkInternalList<ServiceLastAccessed> servicesLastAccessed;
  private Date jobCompletionDate;
  private Boolean isTruncated;
  private String marker;
  private ErrorDetails error;
  
  public void setJobStatus(String jobStatus)
  {
    this.jobStatus = jobStatus;
  }
  
  public String getJobStatus()
  {
    return jobStatus;
  }
  
  public GetServiceLastAccessedDetailsResult withJobStatus(String jobStatus)
  {
    setJobStatus(jobStatus);
    return this;
  }
  
  public GetServiceLastAccessedDetailsResult withJobStatus(JobStatusType jobStatus)
  {
    this.jobStatus = jobStatus.toString();
    return this;
  }
  
  public void setJobCreationDate(Date jobCreationDate)
  {
    this.jobCreationDate = jobCreationDate;
  }
  
  public Date getJobCreationDate()
  {
    return jobCreationDate;
  }
  
  public GetServiceLastAccessedDetailsResult withJobCreationDate(Date jobCreationDate)
  {
    setJobCreationDate(jobCreationDate);
    return this;
  }
  
  public List<ServiceLastAccessed> getServicesLastAccessed()
  {
    if (servicesLastAccessed == null) {
      servicesLastAccessed = new SdkInternalList();
    }
    return servicesLastAccessed;
  }
  
  public void setServicesLastAccessed(Collection<ServiceLastAccessed> servicesLastAccessed)
  {
    if (servicesLastAccessed == null)
    {
      this.servicesLastAccessed = null;
      return;
    }
    this.servicesLastAccessed = new SdkInternalList(servicesLastAccessed);
  }
  
  public GetServiceLastAccessedDetailsResult withServicesLastAccessed(ServiceLastAccessed... servicesLastAccessed)
  {
    if (this.servicesLastAccessed == null) {
      setServicesLastAccessed(new SdkInternalList(servicesLastAccessed.length));
    }
    for (ServiceLastAccessed ele : servicesLastAccessed) {
      this.servicesLastAccessed.add(ele);
    }
    return this;
  }
  
  public GetServiceLastAccessedDetailsResult withServicesLastAccessed(Collection<ServiceLastAccessed> servicesLastAccessed)
  {
    setServicesLastAccessed(servicesLastAccessed);
    return this;
  }
  
  public void setJobCompletionDate(Date jobCompletionDate)
  {
    this.jobCompletionDate = jobCompletionDate;
  }
  
  public Date getJobCompletionDate()
  {
    return jobCompletionDate;
  }
  
  public GetServiceLastAccessedDetailsResult withJobCompletionDate(Date jobCompletionDate)
  {
    setJobCompletionDate(jobCompletionDate);
    return this;
  }
  
  public void setIsTruncated(Boolean isTruncated)
  {
    this.isTruncated = isTruncated;
  }
  
  public Boolean getIsTruncated()
  {
    return isTruncated;
  }
  
  public GetServiceLastAccessedDetailsResult withIsTruncated(Boolean isTruncated)
  {
    setIsTruncated(isTruncated);
    return this;
  }
  
  public Boolean isTruncated()
  {
    return isTruncated;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public GetServiceLastAccessedDetailsResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setError(ErrorDetails error)
  {
    this.error = error;
  }
  
  public ErrorDetails getError()
  {
    return error;
  }
  
  public GetServiceLastAccessedDetailsResult withError(ErrorDetails error)
  {
    setError(error);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobStatus() != null) {
      sb.append("JobStatus: ").append(getJobStatus()).append(",");
    }
    if (getJobCreationDate() != null) {
      sb.append("JobCreationDate: ").append(getJobCreationDate()).append(",");
    }
    if (getServicesLastAccessed() != null) {
      sb.append("ServicesLastAccessed: ").append(getServicesLastAccessed()).append(",");
    }
    if (getJobCompletionDate() != null) {
      sb.append("JobCompletionDate: ").append(getJobCompletionDate()).append(",");
    }
    if (getIsTruncated() != null) {
      sb.append("IsTruncated: ").append(getIsTruncated()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getError() != null) {
      sb.append("Error: ").append(getError());
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
    if (!(obj instanceof GetServiceLastAccessedDetailsResult)) {
      return false;
    }
    GetServiceLastAccessedDetailsResult other = (GetServiceLastAccessedDetailsResult)obj;
    if (((other.getJobStatus() == null ? 1 : 0) ^ (getJobStatus() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobStatus() != null) && (!other.getJobStatus().equals(getJobStatus()))) {
      return false;
    }
    if (((other.getJobCreationDate() == null ? 1 : 0) ^ (getJobCreationDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobCreationDate() != null) && (!other.getJobCreationDate().equals(getJobCreationDate()))) {
      return false;
    }
    if (((other.getServicesLastAccessed() == null ? 1 : 0) ^ (getServicesLastAccessed() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServicesLastAccessed() != null) && (!other.getServicesLastAccessed().equals(getServicesLastAccessed()))) {
      return false;
    }
    if (((other.getJobCompletionDate() == null ? 1 : 0) ^ (getJobCompletionDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobCompletionDate() != null) && (!other.getJobCompletionDate().equals(getJobCompletionDate()))) {
      return false;
    }
    if (((other.getIsTruncated() == null ? 1 : 0) ^ (getIsTruncated() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getIsTruncated() != null) && (!other.getIsTruncated().equals(getIsTruncated()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    if (((other.getError() == null ? 1 : 0) ^ (getError() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getError() != null) && (!other.getError().equals(getError()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobStatus() == null ? 0 : getJobStatus().hashCode());
    hashCode = 31 * hashCode + (getJobCreationDate() == null ? 0 : getJobCreationDate().hashCode());
    hashCode = 31 * hashCode + (getServicesLastAccessed() == null ? 0 : getServicesLastAccessed().hashCode());
    hashCode = 31 * hashCode + (getJobCompletionDate() == null ? 0 : getJobCompletionDate().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getError() == null ? 0 : getError().hashCode());
    return hashCode;
  }
  
  public GetServiceLastAccessedDetailsResult clone()
  {
    try
    {
      return (GetServiceLastAccessedDetailsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */