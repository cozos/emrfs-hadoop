package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class DeleteDashboardsRequestMarshaller
  implements Marshaller<Request<DeleteDashboardsRequest>, DeleteDashboardsRequest>
{
  public Request<DeleteDashboardsRequest> marshall(DeleteDashboardsRequest deleteDashboardsRequest)
  {
    if (deleteDashboardsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteDashboardsRequest> request = new DefaultRequest(deleteDashboardsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "DeleteDashboards");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    int dashboardNamesListIndex;
    if ((!deleteDashboardsRequest.getDashboardNames().isEmpty()) || 
      (!((SdkInternalList)deleteDashboardsRequest.getDashboardNames()).isAutoConstruct()))
    {
      SdkInternalList<String> dashboardNamesList = (SdkInternalList)deleteDashboardsRequest.getDashboardNames();
      dashboardNamesListIndex = 1;
      for (String dashboardNamesListValue : dashboardNamesList)
      {
        if (dashboardNamesListValue != null) {
          request.addParameter("DashboardNames.member." + dashboardNamesListIndex, StringUtils.fromString(dashboardNamesListValue));
        }
        dashboardNamesListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteDashboardsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */