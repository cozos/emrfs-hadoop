package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class ListDashboardsRequestMarshaller
  implements Marshaller<Request<ListDashboardsRequest>, ListDashboardsRequest>
{
  public Request<ListDashboardsRequest> marshall(ListDashboardsRequest listDashboardsRequest)
  {
    if (listDashboardsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListDashboardsRequest> request = new DefaultRequest(listDashboardsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "ListDashboards");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (listDashboardsRequest.getDashboardNamePrefix() != null) {
      request.addParameter("DashboardNamePrefix", StringUtils.fromString(listDashboardsRequest.getDashboardNamePrefix()));
    }
    if (listDashboardsRequest.getNextToken() != null) {
      request.addParameter("NextToken", StringUtils.fromString(listDashboardsRequest.getNextToken()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListDashboardsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */