package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class PutDashboardResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private SdkInternalList<DashboardValidationMessage> dashboardValidationMessages;
  
  public List<DashboardValidationMessage> getDashboardValidationMessages()
  {
    if (dashboardValidationMessages == null) {
      dashboardValidationMessages = new SdkInternalList();
    }
    return dashboardValidationMessages;
  }
  
  public void setDashboardValidationMessages(Collection<DashboardValidationMessage> dashboardValidationMessages)
  {
    if (dashboardValidationMessages == null)
    {
      this.dashboardValidationMessages = null;
      return;
    }
    this.dashboardValidationMessages = new SdkInternalList(dashboardValidationMessages);
  }
  
  public PutDashboardResult withDashboardValidationMessages(DashboardValidationMessage... dashboardValidationMessages)
  {
    if (this.dashboardValidationMessages == null) {
      setDashboardValidationMessages(new SdkInternalList(dashboardValidationMessages.length));
    }
    for (DashboardValidationMessage ele : dashboardValidationMessages) {
      this.dashboardValidationMessages.add(ele);
    }
    return this;
  }
  
  public PutDashboardResult withDashboardValidationMessages(Collection<DashboardValidationMessage> dashboardValidationMessages)
  {
    setDashboardValidationMessages(dashboardValidationMessages);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getDashboardValidationMessages() != null) {
      sb.append("DashboardValidationMessages: ").append(getDashboardValidationMessages());
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
    if (!(obj instanceof PutDashboardResult)) {
      return false;
    }
    PutDashboardResult other = (PutDashboardResult)obj;
    if (((other.getDashboardValidationMessages() == null ? 1 : 0) ^ (getDashboardValidationMessages() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDashboardValidationMessages() != null) && (!other.getDashboardValidationMessages().equals(getDashboardValidationMessages()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getDashboardValidationMessages() == null ? 0 : getDashboardValidationMessages().hashCode());
    return hashCode;
  }
  
  public PutDashboardResult clone()
  {
    try
    {
      return (PutDashboardResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */