package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetOrganizationsAccessReportRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String jobId;
  private Integer maxItems;
  private String marker;
  private String sortKey;
  
  public void setJobId(String jobId)
  {
    this.jobId = jobId;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public GetOrganizationsAccessReportRequest withJobId(String jobId)
  {
    setJobId(jobId);
    return this;
  }
  
  public void setMaxItems(Integer maxItems)
  {
    this.maxItems = maxItems;
  }
  
  public Integer getMaxItems()
  {
    return maxItems;
  }
  
  public GetOrganizationsAccessReportRequest withMaxItems(Integer maxItems)
  {
    setMaxItems(maxItems);
    return this;
  }
  
  public void setMarker(String marker)
  {
    this.marker = marker;
  }
  
  public String getMarker()
  {
    return marker;
  }
  
  public GetOrganizationsAccessReportRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public void setSortKey(String sortKey)
  {
    this.sortKey = sortKey;
  }
  
  public String getSortKey()
  {
    return sortKey;
  }
  
  public GetOrganizationsAccessReportRequest withSortKey(String sortKey)
  {
    setSortKey(sortKey);
    return this;
  }
  
  public GetOrganizationsAccessReportRequest withSortKey(SortKeyType sortKey)
  {
    this.sortKey = sortKey.toString();
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobId() != null) {
      sb.append("JobId: ").append(getJobId()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker()).append(",");
    }
    if (getSortKey() != null) {
      sb.append("SortKey: ").append(getSortKey());
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
    if (!(obj instanceof GetOrganizationsAccessReportRequest)) {
      return false;
    }
    GetOrganizationsAccessReportRequest other = (GetOrganizationsAccessReportRequest)obj;
    if (((other.getJobId() == null ? 1 : 0) ^ (getJobId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobId() != null) && (!other.getJobId().equals(getJobId()))) {
      return false;
    }
    if (((other.getMaxItems() == null ? 1 : 0) ^ (getMaxItems() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMaxItems() != null) && (!other.getMaxItems().equals(getMaxItems()))) {
      return false;
    }
    if (((other.getMarker() == null ? 1 : 0) ^ (getMarker() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getMarker() != null) && (!other.getMarker().equals(getMarker()))) {
      return false;
    }
    if (((other.getSortKey() == null ? 1 : 0) ^ (getSortKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSortKey() != null) && (!other.getSortKey().equals(getSortKey()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobId() == null ? 0 : getJobId().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    hashCode = 31 * hashCode + (getSortKey() == null ? 0 : getSortKey().hashCode());
    return hashCode;
  }
  
  public GetOrganizationsAccessReportRequest clone()
  {
    return (GetOrganizationsAccessReportRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */