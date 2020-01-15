package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class DescribeAlarmsForMetricRequestMarshaller
  implements Marshaller<Request<DescribeAlarmsForMetricRequest>, DescribeAlarmsForMetricRequest>
{
  public Request<DescribeAlarmsForMetricRequest> marshall(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest)
  {
    if (describeAlarmsForMetricRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DescribeAlarmsForMetricRequest> request = new DefaultRequest(describeAlarmsForMetricRequest, "AmazonCloudWatch");
    request.addParameter("Action", "DescribeAlarmsForMetric");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (describeAlarmsForMetricRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(describeAlarmsForMetricRequest.getMetricName()));
    }
    if (describeAlarmsForMetricRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(describeAlarmsForMetricRequest.getNamespace()));
    }
    if (describeAlarmsForMetricRequest.getStatistic() != null) {
      request.addParameter("Statistic", StringUtils.fromString(describeAlarmsForMetricRequest.getStatistic()));
    }
    if (describeAlarmsForMetricRequest.getExtendedStatistic() != null) {
      request.addParameter("ExtendedStatistic", StringUtils.fromString(describeAlarmsForMetricRequest.getExtendedStatistic()));
    }
    int dimensionsListIndex;
    if ((!describeAlarmsForMetricRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)describeAlarmsForMetricRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<Dimension> dimensionsList = (SdkInternalList)describeAlarmsForMetricRequest.getDimensions();
      dimensionsListIndex = 1;
      for (Dimension dimensionsListValue : dimensionsList)
      {
        if (dimensionsListValue.getName() != null) {
          request.addParameter("Dimensions.member." + dimensionsListIndex + ".Name", StringUtils.fromString(dimensionsListValue.getName()));
        }
        if (dimensionsListValue.getValue() != null) {
          request.addParameter("Dimensions.member." + dimensionsListIndex + ".Value", StringUtils.fromString(dimensionsListValue.getValue()));
        }
        dimensionsListIndex++;
      }
    }
    if (describeAlarmsForMetricRequest.getPeriod() != null) {
      request.addParameter("Period", StringUtils.fromInteger(describeAlarmsForMetricRequest.getPeriod()));
    }
    if (describeAlarmsForMetricRequest.getUnit() != null) {
      request.addParameter("Unit", StringUtils.fromString(describeAlarmsForMetricRequest.getUnit()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsForMetricRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */