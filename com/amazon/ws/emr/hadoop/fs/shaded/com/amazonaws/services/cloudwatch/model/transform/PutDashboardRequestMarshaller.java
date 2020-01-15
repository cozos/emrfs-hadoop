package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class PutDashboardRequestMarshaller
  implements Marshaller<Request<PutDashboardRequest>, PutDashboardRequest>
{
  public Request<PutDashboardRequest> marshall(PutDashboardRequest putDashboardRequest)
  {
    if (putDashboardRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutDashboardRequest> request = new DefaultRequest(putDashboardRequest, "AmazonCloudWatch");
    request.addParameter("Action", "PutDashboard");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (putDashboardRequest.getDashboardName() != null) {
      request.addParameter("DashboardName", StringUtils.fromString(putDashboardRequest.getDashboardName()));
    }
    if (putDashboardRequest.getDashboardBody() != null) {
      request.addParameter("DashboardBody", StringUtils.fromString(putDashboardRequest.getDashboardBody()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutDashboardRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */