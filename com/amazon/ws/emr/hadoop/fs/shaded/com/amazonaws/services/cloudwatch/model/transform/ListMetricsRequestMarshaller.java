package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DimensionFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class ListMetricsRequestMarshaller
  implements Marshaller<Request<ListMetricsRequest>, ListMetricsRequest>
{
  public Request<ListMetricsRequest> marshall(ListMetricsRequest listMetricsRequest)
  {
    if (listMetricsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<ListMetricsRequest> request = new DefaultRequest(listMetricsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "ListMetrics");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (listMetricsRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(listMetricsRequest.getNamespace()));
    }
    if (listMetricsRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(listMetricsRequest.getMetricName()));
    }
    int dimensionsListIndex;
    if ((!listMetricsRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)listMetricsRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<DimensionFilter> dimensionsList = (SdkInternalList)listMetricsRequest.getDimensions();
      dimensionsListIndex = 1;
      for (DimensionFilter dimensionsListValue : dimensionsList)
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
    if (listMetricsRequest.getNextToken() != null) {
      request.addParameter("NextToken", StringUtils.fromString(listMetricsRequest.getNextToken()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListMetricsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */