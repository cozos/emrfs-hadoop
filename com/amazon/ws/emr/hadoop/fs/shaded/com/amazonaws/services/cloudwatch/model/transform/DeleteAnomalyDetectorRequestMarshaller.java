package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class DeleteAnomalyDetectorRequestMarshaller
  implements Marshaller<Request<DeleteAnomalyDetectorRequest>, DeleteAnomalyDetectorRequest>
{
  public Request<DeleteAnomalyDetectorRequest> marshall(DeleteAnomalyDetectorRequest deleteAnomalyDetectorRequest)
  {
    if (deleteAnomalyDetectorRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<DeleteAnomalyDetectorRequest> request = new DefaultRequest(deleteAnomalyDetectorRequest, "AmazonCloudWatch");
    request.addParameter("Action", "DeleteAnomalyDetector");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (deleteAnomalyDetectorRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(deleteAnomalyDetectorRequest.getNamespace()));
    }
    if (deleteAnomalyDetectorRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(deleteAnomalyDetectorRequest.getMetricName()));
    }
    int dimensionsListIndex;
    if ((!deleteAnomalyDetectorRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)deleteAnomalyDetectorRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<Dimension> dimensionsList = (SdkInternalList)deleteAnomalyDetectorRequest.getDimensions();
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
    if (deleteAnomalyDetectorRequest.getStat() != null) {
      request.addParameter("Stat", StringUtils.fromString(deleteAnomalyDetectorRequest.getStat()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DeleteAnomalyDetectorRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */