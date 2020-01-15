package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GetOrganizationsAccessReportResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private String jobStatus;
  private Date jobCreationDate;
  private Date jobCompletionDate;
  private Integer numberOfServicesAccessible;
  private Integer numberOfServicesNotAccessed;
  private SdkInternalList<AccessDetail> accessDetails;
  private Boolean isTruncated;
  private String marker;
  private ErrorDetails errorDetails;
  
  public void setJobStatus(String jobStatus)
  {
    this.jobStatus = jobStatus;
  }
  
  public String getJobStatus()
  {
    return jobStatus;
  }
  
  public GetOrganizationsAccessReportResult withJobStatus(String jobStatus)
  {
    setJobStatus(jobStatus);
    return this;
  }
  
  public GetOrganizationsAccessReportResult withJobStatus(JobStatusType jobStatus)
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
  
  public GetOrganizationsAccessReportResult withJobCreationDate(Date jobCreationDate)
  {
    setJobCreationDate(jobCreationDate);
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
  
  public GetOrganizationsAccessReportResult withJobCompletionDate(Date jobCompletionDate)
  {
    setJobCompletionDate(jobCompletionDate);
    return this;
  }
  
  public void setNumberOfServicesAccessible(Integer numberOfServicesAccessible)
  {
    this.numberOfServicesAccessible = numberOfServicesAccessible;
  }
  
  public Integer getNumberOfServicesAccessible()
  {
    return numberOfServicesAccessible;
  }
  
  public GetOrganizationsAccessReportResult withNumberOfServicesAccessible(Integer numberOfServicesAccessible)
  {
    setNumberOfServicesAccessible(numberOfServicesAccessible);
    return this;
  }
  
  public void setNumberOfServicesNotAccessed(Integer numberOfServicesNotAccessed)
  {
    this.numberOfServicesNotAccessed = numberOfServicesNotAccessed;
  }
  
  public Integer getNumberOfServicesNotAccessed()
  {
    return numberOfServicesNotAccessed;
  }
  
  public GetOrganizationsAccessReportResult withNumberOfServicesNotAccessed(Integer numberOfServicesNotAccessed)
  {
    setNumberOfServicesNotAccessed(numberOfServicesNotAccessed);
    return this;
  }
  
  public List<AccessDetail> getAccessDetails()
  {
    if (accessDetails == null) {
      accessDetails = new SdkInternalList();
    }
    return accessDetails;
  }
  
  public void setAccessDetails(Collection<AccessDetail> accessDetails)
  {
    if (accessDetails == null)
    {
      this.accessDetails = null;
      return;
    }
    this.accessDetails = new SdkInternalList(accessDetails);
  }
  
  public GetOrganizationsAccessReportResult withAccessDetails(AccessDetail... accessDetails)
  {
    if (this.accessDetails == null) {
      setAccessDetails(new SdkInternalList(accessDetails.length));
    }
    for (AccessDetail ele : accessDetails) {
      this.accessDetails.add(ele);
    }
    return this;
  }
  
  public GetOrganizationsAccessReportResult withAccessDetails(Collection<AccessDetail> accessDetails)
  {
    setAccessDetails(accessDetails);
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
  
  public GetOrganizationsAccessReportResult withIsTruncated(Boolean isTruncated)
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
  
  public GetOrganizationsAccessReportResult withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setErrorDetails(ErrorDetails errorDetails)
  {
    this.errorDetails = errorDetails;
  }
  
  public ErrorDetails getErrorDetails()
  {
    return errorDetails;
  }
  
  public GetOrganizationsAccessReportResult withErrorDetails(ErrorDetails errorDetails)
  {
    setErrorDetails(errorDetails);
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
    if (getJobCompletionDate() != null) {
      sb.append("JobCompletionDate: ").append(getJobCompletionDate()).append(",");
    }
    if (getNumberOfServicesAccessible() != null) {
      sb.append("NumberOfServicesAccessible: ").append(getNumberOfServicesAccessible()).append(",");
    }
    if (getNumberOfServicesNotAccessed() != null) {
      sb.append("NumberOfServicesNotAccessed: ").append(getNumberOfServicesNotAccessed()).append(",");
    }
    if (getAccessDetails() != null) {
      sb.append("AccessDetails: ").append(getAccessDetails()).append(",");
    }
    if (getIsTruncated() != null) {
      sb.append("IsTruncated: ").append(getIsTruncated()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getErrorDetails() != null) {
      sb.append("ErrorDetails: ").append(getErrorDetails());
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
    if (!(obj instanceof GetOrganizationsAccessReportResult)) {
      return false;
    }
    GetOrganizationsAccessReportResult other = (GetOrganizationsAccessReportResult)obj;
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
    if (((other.getJobCompletionDate() == null ? 1 : 0) ^ (getJobCompletionDate() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobCompletionDate() != null) && (!other.getJobCompletionDate().equals(getJobCompletionDate()))) {
      return false;
    }
    if (((other.getNumberOfServicesAccessible() == null ? 1 : 0) ^ (getNumberOfServicesAccessible() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNumberOfServicesAccessible() != null) && (!other.getNumberOfServicesAccessible().equals(getNumberOfServicesAccessible()))) {
      return false;
    }
    if (((other.getNumberOfServicesNotAccessed() == null ? 1 : 0) ^ (getNumberOfServicesNotAccessed() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNumberOfServicesNotAccessed() != null) && (!other.getNumberOfServicesNotAccessed().equals(getNumberOfServicesNotAccessed()))) {
      return false;
    }
    if (((other.getAccessDetails() == null ? 1 : 0) ^ (getAccessDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessDetails() != null) && (!other.getAccessDetails().equals(getAccessDetails()))) {
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
    if (((other.getErrorDetails() == null ? 1 : 0) ^ (getErrorDetails() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getErrorDetails() != null) && (!other.getErrorDetails().equals(getErrorDetails()))) {
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
    hashCode = 31 * hashCode + (getJobCompletionDate() == null ? 0 : getJobCompletionDate().hashCode());
    hashCode = 31 * hashCode + (getNumberOfServicesAccessible() == null ? 0 : getNumberOfServicesAccessible().hashCode());
    hashCode = 31 * hashCode + (getNumberOfServicesNotAccessed() == null ? 0 : getNumberOfServicesNotAccessed().hashCode());
    hashCode = 31 * hashCode + (getAccessDetails() == null ? 0 : getAccessDetails().hashCode());
    hashCode = 31 * hashCode + (getIsTruncated() == null ? 0 : getIsTruncated().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getErrorDetails() == null ? 0 : getErrorDetails().hashCode());
    return hashCode;
  }
  
  public GetOrganizationsAccessReportResult clone()
  {
    try
    {
      return (GetOrganizationsAccessReportResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */