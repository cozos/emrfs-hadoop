package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AnomalyDetectorConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Range;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.Iterator;
import java.util.List;

public class PutAnomalyDetectorRequestMarshaller
  implements Marshaller<Request<PutAnomalyDetectorRequest>, PutAnomalyDetectorRequest>
{
  public Request<PutAnomalyDetectorRequest> marshall(PutAnomalyDetectorRequest putAnomalyDetectorRequest)
  {
    if (putAnomalyDetectorRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutAnomalyDetectorRequest> request = new DefaultRequest(putAnomalyDetectorRequest, "AmazonCloudWatch");
    request.addParameter("Action", "PutAnomalyDetector");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (putAnomalyDetectorRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(putAnomalyDetectorRequest.getNamespace()));
    }
    if (putAnomalyDetectorRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(putAnomalyDetectorRequest.getMetricName()));
    }
    int dimensionsListIndex;
    Iterator localIterator;
    if ((!putAnomalyDetectorRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)putAnomalyDetectorRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<Dimension> dimensionsList = (SdkInternalList)putAnomalyDetectorRequest.getDimensions();
      dimensionsListIndex = 1;
      for (localIterator = dimensionsList.iterator(); localIterator.hasNext();)
      {
        dimensionsListValue = (Dimension)localIterator.next();
        if (dimensionsListValue.getName() != null) {
          request.addParameter("Dimensions.member." + dimensionsListIndex + ".Name", StringUtils.fromString(dimensionsListValue.getName()));
        }
        if (dimensionsListValue.getValue() != null) {
          request.addParameter("Dimensions.member." + dimensionsListIndex + ".Value", StringUtils.fromString(dimensionsListValue.getValue()));
        }
        dimensionsListIndex++;
      }
    }
    Dimension dimensionsListValue;
    if (putAnomalyDetectorRequest.getStat() != null) {
      request.addParameter("Stat", StringUtils.fromString(putAnomalyDetectorRequest.getStat()));
    }
    AnomalyDetectorConfiguration configuration = putAnomalyDetectorRequest.getConfiguration();
    if (configuration != null)
    {
      int excludedTimeRangesListIndex;
      if ((!configuration.getExcludedTimeRanges().isEmpty()) || 
        (!((SdkInternalList)configuration.getExcludedTimeRanges()).isAutoConstruct()))
      {
        SdkInternalList<Range> excludedTimeRangesList = (SdkInternalList)configuration.getExcludedTimeRanges();
        excludedTimeRangesListIndex = 1;
        for (Range excludedTimeRangesListValue : excludedTimeRangesList)
        {
          if (excludedTimeRangesListValue.getStartTime() != null) {
            request.addParameter("Configuration.ExcludedTimeRanges.member." + excludedTimeRangesListIndex + ".StartTime", 
              StringUtils.fromDate(excludedTimeRangesListValue.getStartTime()));
          }
          if (excludedTimeRangesListValue.getEndTime() != null) {
            request.addParameter("Configuration.ExcludedTimeRanges.member." + excludedTimeRangesListIndex + ".EndTime", 
              StringUtils.fromDate(excludedTimeRangesListValue.getEndTime()));
          }
          excludedTimeRangesListIndex++;
        }
      }
      if (configuration.getMetricTimezone() != null) {
        request.addParameter("Configuration.MetricTimezone", StringUtils.fromString(configuration.getMetricTimezone()));
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutAnomalyDetectorRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */