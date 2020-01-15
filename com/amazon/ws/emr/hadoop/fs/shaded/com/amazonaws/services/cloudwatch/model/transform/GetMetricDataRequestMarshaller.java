package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Metric;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataQuery;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricStat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class GetMetricDataRequestMarshaller
  implements Marshaller<Request<GetMetricDataRequest>, GetMetricDataRequest>
{
  public Request<GetMetricDataRequest> marshall(GetMetricDataRequest getMetricDataRequest)
  {
    if (getMetricDataRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<GetMetricDataRequest> request = new DefaultRequest(getMetricDataRequest, "AmazonCloudWatch");
    request.addParameter("Action", "GetMetricData");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    int metricDataQueriesListIndex;
    if ((!getMetricDataRequest.getMetricDataQueries().isEmpty()) || 
      (!((SdkInternalList)getMetricDataRequest.getMetricDataQueries()).isAutoConstruct()))
    {
      SdkInternalList<MetricDataQuery> metricDataQueriesList = (SdkInternalList)getMetricDataRequest.getMetricDataQueries();
      metricDataQueriesListIndex = 1;
      for (MetricDataQuery metricDataQueriesListValue : metricDataQueriesList)
      {
        if (metricDataQueriesListValue.getId() != null) {
          request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".Id", 
            StringUtils.fromString(metricDataQueriesListValue.getId()));
        }
        MetricStat metricStat = metricDataQueriesListValue.getMetricStat();
        if (metricStat != null)
        {
          Metric metric = metricStat.getMetric();
          int dimensionsListIndex;
          if (metric != null)
          {
            if (metric.getNamespace() != null) {
              request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Metric.Namespace", 
                StringUtils.fromString(metric.getNamespace()));
            }
            if (metric.getMetricName() != null) {
              request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Metric.MetricName", 
                StringUtils.fromString(metric.getMetricName()));
            }
            if ((!metric.getDimensions().isEmpty()) || 
              (!((SdkInternalList)metric.getDimensions()).isAutoConstruct()))
            {
              SdkInternalList<Dimension> dimensionsList = (SdkInternalList)metric.getDimensions();
              dimensionsListIndex = 1;
              for (Dimension dimensionsListValue : dimensionsList)
              {
                if (dimensionsListValue.getName() != null) {
                  request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Metric.Dimensions.member." + dimensionsListIndex + ".Name", 
                  
                    StringUtils.fromString(dimensionsListValue.getName()));
                }
                if (dimensionsListValue.getValue() != null) {
                  request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Metric.Dimensions.member." + dimensionsListIndex + ".Value", 
                  
                    StringUtils.fromString(dimensionsListValue.getValue()));
                }
                dimensionsListIndex++;
              }
            }
          }
          if (metricStat.getPeriod() != null) {
            request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Period", 
              StringUtils.fromInteger(metricStat.getPeriod()));
          }
          if (metricStat.getStat() != null) {
            request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Stat", 
              StringUtils.fromString(metricStat.getStat()));
          }
          if (metricStat.getUnit() != null) {
            request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".MetricStat.Unit", 
              StringUtils.fromString(metricStat.getUnit()));
          }
        }
        if (metricDataQueriesListValue.getExpression() != null) {
          request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".Expression", 
            StringUtils.fromString(metricDataQueriesListValue.getExpression()));
        }
        if (metricDataQueriesListValue.getLabel() != null) {
          request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".Label", 
            StringUtils.fromString(metricDataQueriesListValue.getLabel()));
        }
        if (metricDataQueriesListValue.getReturnData() != null) {
          request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".ReturnData", 
            StringUtils.fromBoolean(metricDataQueriesListValue.getReturnData()));
        }
        if (metricDataQueriesListValue.getPeriod() != null) {
          request.addParameter("MetricDataQueries.member." + metricDataQueriesListIndex + ".Period", 
            StringUtils.fromInteger(metricDataQueriesListValue.getPeriod()));
        }
        metricDataQueriesListIndex++;
      }
    }
    if (getMetricDataRequest.getStartTime() != null) {
      request.addParameter("StartTime", StringUtils.fromDate(getMetricDataRequest.getStartTime()));
    }
    if (getMetricDataRequest.getEndTime() != null) {
      request.addParameter("EndTime", StringUtils.fromDate(getMetricDataRequest.getEndTime()));
    }
    if (getMetricDataRequest.getNextToken() != null) {
      request.addParameter("NextToken", StringUtils.fromString(getMetricDataRequest.getNextToken()));
    }
    if (getMetricDataRequest.getScanBy() != null) {
      request.addParameter("ScanBy", StringUtils.fromString(getMetricDataRequest.getScanBy()));
    }
    if (getMetricDataRequest.getMaxDatapoints() != null) {
      request.addParameter("MaxDatapoints", StringUtils.fromInteger(getMetricDataRequest.getMaxDatapoints()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricDataRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */