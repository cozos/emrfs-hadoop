package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.util.Collection;
import java.util.List;

public class DashboardInvalidInputErrorException
  extends AmazonCloudWatchException
{
  private static final long serialVersionUID = 1L;
  private SdkInternalList<DashboardValidationMessage> dashboardValidationMessages;
  
  public DashboardInvalidInputErrorException(String message)
  {
    super(message);
  }
  
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
  
  public DashboardInvalidInputErrorException withDashboardValidationMessages(DashboardValidationMessage... dashboardValidationMessages)
  {
    if (this.dashboardValidationMessages == null) {
      setDashboardValidationMessages(new SdkInternalList(dashboardValidationMessages.length));
    }
    for (DashboardValidationMessage ele : dashboardValidationMessages) {
      this.dashboardValidationMessages.add(ele);
    }
    return this;
  }
  
  public DashboardInvalidInputErrorException withDashboardValidationMessages(Collection<DashboardValidationMessage> dashboardValidationMessages)
  {
    setDashboardValidationMessages(dashboardValidationMessages);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DashboardInvalidInputErrorException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */