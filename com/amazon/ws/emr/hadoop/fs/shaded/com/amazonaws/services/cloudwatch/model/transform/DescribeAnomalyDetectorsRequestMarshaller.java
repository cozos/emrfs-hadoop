package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class DescribeAnomalyDetectorsRequestMarshaller
  implements Marshaller<Request<DescribeAnomalyDetectorsRequest>, DescribeAnomalyDetectorsRequest>
{
  public Request<DescribeAnomalyDetectorsRequest> marshall(DescribeAnomalyDetectorsRequest describeAnomalyDetectorsRequest)
  {
    if (describeAnomalyDetectorsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DescribeAnomalyDetectorsRequest> request = new DefaultRequest(describeAnomalyDetectorsRequest, "AmazonCloudWatch");
    
    request.addParameter("Action", "DescribeAnomalyDetectors");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (describeAnomalyDetectorsRequest.getNextToken() != null) {
      request.addParameter("NextToken", StringUtils.fromString(describeAnomalyDetectorsRequest.getNextToken()));
    }
    if (describeAnomalyDetectorsRequest.getMaxResults() != null) {
      request.addParameter("MaxResults", StringUtils.fromInteger(describeAnomalyDetectorsRequest.getMaxResults()));
    }
    if (describeAnomalyDetectorsRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(describeAnomalyDetectorsRequest.getNamespace()));
    }
    if (describeAnomalyDetectorsRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(describeAnomalyDetectorsRequest.getMetricName()));
    }
    int dimensionsListIndex;
    if ((!describeAnomalyDetectorsRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)describeAnomalyDetectorsRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<Dimension> dimensionsList = (SdkInternalList)describeAnomalyDetectorsRequest.getDimensions();
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
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAnomalyDetectorsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */