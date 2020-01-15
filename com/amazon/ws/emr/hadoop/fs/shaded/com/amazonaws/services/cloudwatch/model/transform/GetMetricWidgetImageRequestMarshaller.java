package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

public class GetMetricWidgetImageRequestMarshaller
  implements Marshaller<Request<GetMetricWidgetImageRequest>, GetMetricWidgetImageRequest>
{
  public Request<GetMetricWidgetImageRequest> marshall(GetMetricWidgetImageRequest getMetricWidgetImageRequest)
  {
    if (getMetricWidgetImageRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetMetricWidgetImageRequest> request = new DefaultRequest(getMetricWidgetImageRequest, "AmazonCloudWatch");
    request.addParameter("Action", "GetMetricWidgetImage");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (getMetricWidgetImageRequest.getMetricWidget() != null) {
      request.addParameter("MetricWidget", StringUtils.fromString(getMetricWidgetImageRequest.getMetricWidget()));
    }
    if (getMetricWidgetImageRequest.getOutputFormat() != null) {
      request.addParameter("OutputFormat", StringUtils.fromString(getMetricWidgetImageRequest.getOutputFormat()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricWidgetImageRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */