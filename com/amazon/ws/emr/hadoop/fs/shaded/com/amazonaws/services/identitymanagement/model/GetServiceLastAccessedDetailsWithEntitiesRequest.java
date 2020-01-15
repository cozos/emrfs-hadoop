package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetServiceLastAccessedDetailsWithEntitiesRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String jobId;
  private String serviceNamespace;
  private Integer maxItems;
  private String marker;
  
  public void setJobId(String jobId)
  {
    this.jobId = jobId;
  }
  
  public String getJobId()
  {
    return jobId;
  }
  
  public GetServiceLastAccessedDetailsWithEntitiesRequest withJobId(String jobId)
  {
    setJobId(jobId);
    return this;
  }
  
  public void setServiceNamespace(String serviceNamespace)
  {
    this.serviceNamespace = serviceNamespace;
  }
  
  public String getServiceNamespace()
  {
    return serviceNamespace;
  }
  
  public GetServiceLastAccessedDetailsWithEntitiesRequest withServiceNamespace(String serviceNamespace)
  {
    setServiceNamespace(serviceNamespace);
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
  
  public GetServiceLastAccessedDetailsWithEntitiesRequest withMaxItems(Integer maxItems)
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
  
  public GetServiceLastAccessedDetailsWithEntitiesRequest withMarker(String marker)
  {
    setMarker(marker);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getJobId() != null) {
      sb.append("JobId: ").append(getJobId()).append(",");
    }
    if (getServiceNamespace() != null) {
      sb.append("ServiceNamespace: ").append(getServiceNamespace()).append(",");
    }
    if (getMaxItems() != null) {
      sb.append("MaxItems: ").append(getMaxItems()).append(",");
    }
    if (getMarker() != null) {
      sb.append("Marker: ").append(getMarker());
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
    if (!(obj instanceof GetServiceLastAccessedDetailsWithEntitiesRequest)) {
      return false;
    }
    GetServiceLastAccessedDetailsWithEntitiesRequest other = (GetServiceLastAccessedDetailsWithEntitiesRequest)obj;
    if (((other.getJobId() == null ? 1 : 0) ^ (getJobId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getJobId() != null) && (!other.getJobId().equals(getJobId()))) {
      return false;
    }
    if (((other.getServiceNamespace() == null ? 1 : 0) ^ (getServiceNamespace() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getServiceNamespace() != null) && (!other.getServiceNamespace().equals(getServiceNamespace()))) {
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
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getJobId() == null ? 0 : getJobId().hashCode());
    hashCode = 31 * hashCode + (getServiceNamespace() == null ? 0 : getServiceNamespace().hashCode());
    hashCode = 31 * hashCode + (getMaxItems() == null ? 0 : getMaxItems().hashCode());
    hashCode = 31 * hashCode + (getMarker() == null ? 0 : getMarker().hashCode());
    return hashCode;
  }
  
  public GetServiceLastAccessedDetailsWithEntitiesRequest clone()
  {
    return (GetServiceLastAccessedDetailsWithEntitiesRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */