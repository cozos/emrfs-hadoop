package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.StatisticSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class PutMetricDataRequestMarshaller
  implements Marshaller<Request<PutMetricDataRequest>, PutMetricDataRequest>
{
  public Request<PutMetricDataRequest> marshall(PutMetricDataRequest putMetricDataRequest)
  {
    if (putMetricDataRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutMetricDataRequest> request = new DefaultRequest(putMetricDataRequest, "AmazonCloudWatch");
    request.addParameter("Action", "PutMetricData");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (putMetricDataRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(putMetricDataRequest.getNamespace()));
    }
    int metricDataListIndex;
    if ((!putMetricDataRequest.getMetricData().isEmpty()) || 
      (!((SdkInternalList)putMetricDataRequest.getMetricData()).isAutoConstruct()))
    {
      SdkInternalList<MetricDatum> metricDataList = (SdkInternalList)putMetricDataRequest.getMetricData();
      metricDataListIndex = 1;
      for (MetricDatum metricDataListValue : metricDataList)
      {
        if (metricDataListValue.getMetricName() != null) {
          request.addParameter("MetricData.member." + metricDataListIndex + ".MetricName", 
            StringUtils.fromString(metricDataListValue.getMetricName()));
        }
        int dimensionsListIndex;
        if ((!metricDataListValue.getDimensions().isEmpty()) || 
          (!((SdkInternalList)metricDataListValue.getDimensions()).isAutoConstruct()))
        {
          SdkInternalList<Dimension> dimensionsList = (SdkInternalList)metricDataListValue.getDimensions();
          dimensionsListIndex = 1;
          for (Dimension dimensionsListValue : dimensionsList)
          {
            if (dimensionsListValue.getName() != null) {
              request.addParameter("MetricData.member." + metricDataListIndex + ".Dimensions.member." + dimensionsListIndex + ".Name", 
                StringUtils.fromString(dimensionsListValue.getName()));
            }
            if (dimensionsListValue.getValue() != null) {
              request.addParameter("MetricData.member." + metricDataListIndex + ".Dimensions.member." + dimensionsListIndex + ".Value", 
                StringUtils.fromString(dimensionsListValue.getValue()));
            }
            dimensionsListIndex++;
          }
        }
        if (metricDataListValue.getTimestamp() != null) {
          request.addParameter("MetricData.member." + metricDataListIndex + ".Timestamp", StringUtils.fromDate(metricDataListValue.getTimestamp()));
        }
        if (metricDataListValue.getValue() != null) {
          request.addParameter("MetricData.member." + metricDataListIndex + ".Value", StringUtils.fromDouble(metricDataListValue.getValue()));
        }
        StatisticSet statisticValues = metricDataListValue.getStatisticValues();
        if (statisticValues != null)
        {
          if (statisticValues.getSampleCount() != null) {
            request.addParameter("MetricData.member." + metricDataListIndex + ".StatisticValues.SampleCount", 
              StringUtils.fromDouble(statisticValues.getSampleCount()));
          }
          if (statisticValues.getSum() != null) {
            request.addParameter("MetricData.member." + metricDataListIndex + ".StatisticValues.Sum", 
              StringUtils.fromDouble(statisticValues.getSum()));
          }
          if (statisticValues.getMinimum() != null) {
            request.addParameter("MetricData.member." + metricDataListIndex + ".StatisticValues.Minimum", 
              StringUtils.fromDouble(statisticValues.getMinimum()));
          }
          if (statisticValues.getMaximum() != null) {
            request.addParameter("MetricData.member." + metricDataListIndex + ".StatisticValues.Maximum", 
              StringUtils.fromDouble(statisticValues.getMaximum()));
          }
        }
        int valuesListIndex;
        if ((!metricDataListValue.getValues().isEmpty()) || 
          (!((SdkInternalList)metricDataListValue.getValues()).isAutoConstruct()))
        {
          SdkInternalList<Double> valuesList = (SdkInternalList)metricDataListValue.getValues();
          valuesListIndex = 1;
          for (Double valuesListValue : valuesList)
          {
            if (valuesListValue != null) {
              request.addParameter("MetricData.member." + metricDataListIndex + ".Values.member." + valuesListIndex, 
                StringUtils.fromDouble(valuesListValue));
            }
            valuesListIndex++;
          }
        }
        int countsListIndex;
        if ((!metricDataListValue.getCounts().isEmpty()) || 
          (!((SdkInternalList)metricDataListValue.getCounts()).isAutoConstruct()))
        {
          SdkInternalList<Double> countsList = (SdkInternalList)metricDataListValue.getCounts();
          countsListIndex = 1;
          for (Double countsListValue : countsList)
          {
            if (countsListValue != null) {
              request.addParameter("MetricData.member." + metricDataListIndex + ".Counts.member." + countsListIndex, 
                StringUtils.fromDouble(countsListValue));
            }
            countsListIndex++;
          }
        }
        if (metricDataListValue.getUnit() != null) {
          request.addParameter("MetricData.member." + metricDataListIndex + ".Unit", StringUtils.fromString(metricDataListValue.getUnit()));
        }
        if (metricDataListValue.getStorageResolution() != null) {
          request.addParameter("MetricData.member." + metricDataListIndex + ".StorageResolution", 
            StringUtils.fromInteger(metricDataListValue.getStorageResolution()));
        }
        metricDataListIndex++;
      }
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricDataRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */