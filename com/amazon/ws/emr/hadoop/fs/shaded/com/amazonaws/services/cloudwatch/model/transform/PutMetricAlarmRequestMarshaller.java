package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.DefaultRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.HttpMethodName;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Metric;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataQuery;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricStat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Marshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.util.List;

public class PutMetricAlarmRequestMarshaller
  implements Marshaller<Request<PutMetricAlarmRequest>, PutMetricAlarmRequest>
{
  public Request<PutMetricAlarmRequest> marshall(PutMetricAlarmRequest putMetricAlarmRequest)
  {
    if (putMetricAlarmRequest == null) {
      throw new SdkClientException("Invalid argument passed to marshall(...)");
    }
    Request<PutMetricAlarmRequest> request = new DefaultRequest(putMetricAlarmRequest, "AmazonCloudWatch");
    request.addParameter("Action", "PutMetricAlarm");
    request.addParameter("Version", "2010-08-01");
    request.setHttpMethod(HttpMethodName.POST);
    if (putMetricAlarmRequest.getAlarmName() != null) {
      request.addParameter("AlarmName", StringUtils.fromString(putMetricAlarmRequest.getAlarmName()));
    }
    if (putMetricAlarmRequest.getAlarmDescription() != null) {
      request.addParameter("AlarmDescription", StringUtils.fromString(putMetricAlarmRequest.getAlarmDescription()));
    }
    if (putMetricAlarmRequest.getActionsEnabled() != null) {
      request.addParameter("ActionsEnabled", StringUtils.fromBoolean(putMetricAlarmRequest.getActionsEnabled()));
    }
    int oKActionsListIndex;
    if ((!putMetricAlarmRequest.getOKActions().isEmpty()) || 
      (!((SdkInternalList)putMetricAlarmRequest.getOKActions()).isAutoConstruct()))
    {
      SdkInternalList<String> oKActionsList = (SdkInternalList)putMetricAlarmRequest.getOKActions();
      oKActionsListIndex = 1;
      for (String oKActionsListValue : oKActionsList)
      {
        if (oKActionsListValue != null) {
          request.addParameter("OKActions.member." + oKActionsListIndex, StringUtils.fromString(oKActionsListValue));
        }
        oKActionsListIndex++;
      }
    }
    int alarmActionsListIndex;
    if ((!putMetricAlarmRequest.getAlarmActions().isEmpty()) || 
      (!((SdkInternalList)putMetricAlarmRequest.getAlarmActions()).isAutoConstruct()))
    {
      SdkInternalList<String> alarmActionsList = (SdkInternalList)putMetricAlarmRequest.getAlarmActions();
      alarmActionsListIndex = 1;
      for (String alarmActionsListValue : alarmActionsList)
      {
        if (alarmActionsListValue != null) {
          request.addParameter("AlarmActions.member." + alarmActionsListIndex, StringUtils.fromString(alarmActionsListValue));
        }
        alarmActionsListIndex++;
      }
    }
    int insufficientDataActionsListIndex;
    if ((!putMetricAlarmRequest.getInsufficientDataActions().isEmpty()) || 
      (!((SdkInternalList)putMetricAlarmRequest.getInsufficientDataActions()).isAutoConstruct()))
    {
      SdkInternalList<String> insufficientDataActionsList = (SdkInternalList)putMetricAlarmRequest.getInsufficientDataActions();
      insufficientDataActionsListIndex = 1;
      for (String insufficientDataActionsListValue : insufficientDataActionsList)
      {
        if (insufficientDataActionsListValue != null) {
          request.addParameter("InsufficientDataActions.member." + insufficientDataActionsListIndex, 
            StringUtils.fromString(insufficientDataActionsListValue));
        }
        insufficientDataActionsListIndex++;
      }
    }
    if (putMetricAlarmRequest.getMetricName() != null) {
      request.addParameter("MetricName", StringUtils.fromString(putMetricAlarmRequest.getMetricName()));
    }
    if (putMetricAlarmRequest.getNamespace() != null) {
      request.addParameter("Namespace", StringUtils.fromString(putMetricAlarmRequest.getNamespace()));
    }
    if (putMetricAlarmRequest.getStatistic() != null) {
      request.addParameter("Statistic", StringUtils.fromString(putMetricAlarmRequest.getStatistic()));
    }
    if (putMetricAlarmRequest.getExtendedStatistic() != null) {
      request.addParameter("ExtendedStatistic", StringUtils.fromString(putMetricAlarmRequest.getExtendedStatistic()));
    }
    int dimensionsListIndex;
    if ((!putMetricAlarmRequest.getDimensions().isEmpty()) || 
      (!((SdkInternalList)putMetricAlarmRequest.getDimensions()).isAutoConstruct()))
    {
      SdkInternalList<Dimension> dimensionsList = (SdkInternalList)putMetricAlarmRequest.getDimensions();
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
    if (putMetricAlarmRequest.getPeriod() != null) {
      request.addParameter("Period", StringUtils.fromInteger(putMetricAlarmRequest.getPeriod()));
    }
    if (putMetricAlarmRequest.getUnit() != null) {
      request.addParameter("Unit", StringUtils.fromString(putMetricAlarmRequest.getUnit()));
    }
    if (putMetricAlarmRequest.getEvaluationPeriods() != null) {
      request.addParameter("EvaluationPeriods", StringUtils.fromInteger(putMetricAlarmRequest.getEvaluationPeriods()));
    }
    if (putMetricAlarmRequest.getDatapointsToAlarm() != null) {
      request.addParameter("DatapointsToAlarm", StringUtils.fromInteger(putMetricAlarmRequest.getDatapointsToAlarm()));
    }
    if (putMetricAlarmRequest.getThreshold() != null) {
      request.addParameter("Threshold", StringUtils.fromDouble(putMetricAlarmRequest.getThreshold()));
    }
    if (putMetricAlarmRequest.getComparisonOperator() != null) {
      request.addParameter("ComparisonOperator", StringUtils.fromString(putMetricAlarmRequest.getComparisonOperator()));
    }
    if (putMetricAlarmRequest.getTreatMissingData() != null) {
      request.addParameter("TreatMissingData", StringUtils.fromString(putMetricAlarmRequest.getTreatMissingData()));
    }
    if (putMetricAlarmRequest.getEvaluateLowSampleCountPercentile() != null) {
      request.addParameter("EvaluateLowSampleCountPercentile", StringUtils.fromString(putMetricAlarmRequest.getEvaluateLowSampleCountPercentile()));
    }
    int metricsListIndex;
    if ((!putMetricAlarmRequest.getMetrics().isEmpty()) || 
      (!((SdkInternalList)putMetricAlarmRequest.getMetrics()).isAutoConstruct()))
    {
      SdkInternalList<MetricDataQuery> metricsList = (SdkInternalList)putMetricAlarmRequest.getMetrics();
      metricsListIndex = 1;
      for (MetricDataQuery metricsListValue : metricsList)
      {
        if (metricsListValue.getId() != null) {
          request.addParameter("Metrics.member." + metricsListIndex + ".Id", StringUtils.fromString(metricsListValue.getId()));
        }
        MetricStat metricStat = metricsListValue.getMetricStat();
        if (metricStat != null)
        {
          Metric metric = metricStat.getMetric();
          int dimensionsListIndex;
          if (metric != null)
          {
            if (metric.getNamespace() != null) {
              request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Metric.Namespace", 
                StringUtils.fromString(metric.getNamespace()));
            }
            if (metric.getMetricName() != null) {
              request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Metric.MetricName", 
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
                  request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Metric.Dimensions.member." + dimensionsListIndex + ".Name", 
                    StringUtils.fromString(dimensionsListValue.getName()));
                }
                if (dimensionsListValue.getValue() != null) {
                  request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Metric.Dimensions.member." + dimensionsListIndex + ".Value", 
                    StringUtils.fromString(dimensionsListValue.getValue()));
                }
                dimensionsListIndex++;
              }
            }
          }
          if (metricStat.getPeriod() != null) {
            request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Period", StringUtils.fromInteger(metricStat.getPeriod()));
          }
          if (metricStat.getStat() != null) {
            request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Stat", StringUtils.fromString(metricStat.getStat()));
          }
          if (metricStat.getUnit() != null) {
            request.addParameter("Metrics.member." + metricsListIndex + ".MetricStat.Unit", StringUtils.fromString(metricStat.getUnit()));
          }
        }
        if (metricsListValue.getExpression() != null) {
          request.addParameter("Metrics.member." + metricsListIndex + ".Expression", StringUtils.fromString(metricsListValue.getExpression()));
        }
        if (metricsListValue.getLabel() != null) {
          request.addParameter("Metrics.member." + metricsListIndex + ".Label", StringUtils.fromString(metricsListValue.getLabel()));
        }
        if (metricsListValue.getReturnData() != null) {
          request.addParameter("Metrics.member." + metricsListIndex + ".ReturnData", StringUtils.fromBoolean(metricsListValue.getReturnData()));
        }
        if (metricsListValue.getPeriod() != null) {
          request.addParameter("Metrics.member." + metricsListIndex + ".Period", StringUtils.fromInteger(metricsListValue.getPeriod()));
        }
        metricsListIndex++;
      }
    }
    int tagsListIndex;
    if ((!putMetricAlarmRequest.getTags().isEmpty()) || (!((SdkInternalList)putMetricAlarmRequest.getTags()).isAutoConstruct()))
    {
      SdkInternalList<Tag> tagsList = (SdkInternalList)putMetricAlarmRequest.getTags();
      tagsListIndex = 1;
      for (Tag tagsListValue : tagsList)
      {
        if (tagsListValue.getKey() != null) {
          request.addParameter("Tags.member." + tagsListIndex + ".Key", StringUtils.fromString(tagsListValue.getKey()));
        }
        if (tagsListValue.getValue() != null) {
          request.addParameter("Tags.member." + tagsListIndex + ".Value", StringUtils.fromString(tagsListValue.getValue()));
        }
        tagsListIndex++;
      }
    }
    if (putMetricAlarmRequest.getThresholdMetricId() != null) {
      request.addParameter("ThresholdMetricId", StringUtils.fromString(putMetricAlarmRequest.getThresholdMetricId()));
    }
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricAlarmRequestMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */