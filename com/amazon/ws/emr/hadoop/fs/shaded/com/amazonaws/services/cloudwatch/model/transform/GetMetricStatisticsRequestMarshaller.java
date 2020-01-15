package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class GetMetricStatisticsRequestMarshaller
  implements Marshaller<Request<GetMetricStatisticsRequest>, GetMetricStatisticsRequest>
{
  public Request<GetMetricStatisticsRequest> marshall(GetMetricStatisticsRequest getMetricStatisticsRequest)
  {
    if (getMetricStatisticsRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetMetricStatisticsRequest> request = new DefaultRequest(getMetricStatisticsRequest, "AmazonCloudWatch");
    request.addParameter("Action", "GetMetricStatistics");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (getMetricStatisticsRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(getMetricStatisticsRequest.getNamespace()));
    }
    if (getMetricStatisticsRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(getMetricStatisticsRequest.getMetricName()));
    }
    int dimensionsListIndex;
    if ((!getMetricStatisticsRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)getMetricStatisticsRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<Dimension> dimensionsList = (SdkInternalList)getMetricStatisticsRequest.getDimensions();
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
    if (getMetricStatisticsRequest.getStartTime() != null) {
      request.addParameter("StartTime", StringUtils.fromDate(getMetricStatisticsRequest.getStartTime()));
    }
    if (getMetricStatisticsRequest.getEndTime() != null) {
      request.addParameter("EndTime", StringUtils.fromDate(getMetricStatisticsRequest.getEndTime()));
    }
    if (getMetricStatisticsRequest.getPeriod() != null) {
      request.addParameter("Period", StringUtils.fromInteger(getMetricStatisticsRequest.getPeriod()));
    }
    int statisticsListIndex;
    if ((!getMetricStatisticsRequest.getStatistics().isEmpty()) || 
      (!((SdkInternalList)getMetricStatisticsRequest.getStatistics()).isAutoConstruct()))
    {
      SdkInternalList<String> statisticsList = (SdkInternalList)getMetricStatisticsRequest.getStatistics();
      statisticsListIndex = 1;
      for (String statisticsListValue : statisticsList)
      {
        if (statisticsListValue != null) {
          request.addParameter("Statistics.member." + statisticsListIndex, StringUtils.fromString(statisticsListValue));
        }
        statisticsListIndex++;
      }
    }
    int extendedStatisticsListIndex;
    if ((!getMetricStatisticsRequest.getExtendedStatistics().isEmpty()) || 
      (!((SdkInternalList)getMetricStatisticsRequest.getExtendedStatistics()).isAutoConstruct()))
    {
      SdkInternalList<String> extendedStatisticsList = (SdkInternalList)getMetricStatisticsRequest.getExtendedStatistics();
      extendedStatisticsListIndex = 1;
      for (String extendedStatisticsListValue : extendedStatisticsList)
      {
        if (extendedStatisticsListValue != null) {
          request.addParameter("ExtendedStatistics.member." + extendedStatisticsListIndex, StringUtils.fromString(extendedStatisticsListValue));
        }
        extendedStatisticsListIndex++;
      }
    }
    if (getMetricStatisticsRequest.getUnit() != null) {
      request.addParameter("Unit", StringUtils.fromString(getMetricStatisticsRequest.getUnit()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricStatisticsRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */