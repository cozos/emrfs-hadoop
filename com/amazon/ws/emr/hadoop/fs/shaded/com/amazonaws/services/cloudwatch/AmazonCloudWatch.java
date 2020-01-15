package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteAnomalyDetectorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DeleteDashboardsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmHistoryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAnomalyDetectorsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetDashboardResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricWidgetImageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutAnomalyDetectorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.TagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.UntagResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters.AmazonCloudWatchWaiters;

public abstract interface AmazonCloudWatch
{
  public static final String ENDPOINT_PREFIX = "monitoring";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract DeleteAlarmsResult deleteAlarms(DeleteAlarmsRequest paramDeleteAlarmsRequest);
  
  public abstract DeleteAnomalyDetectorResult deleteAnomalyDetector(DeleteAnomalyDetectorRequest paramDeleteAnomalyDetectorRequest);
  
  public abstract DeleteDashboardsResult deleteDashboards(DeleteDashboardsRequest paramDeleteDashboardsRequest);
  
  public abstract DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest paramDescribeAlarmHistoryRequest);
  
  public abstract DescribeAlarmHistoryResult describeAlarmHistory();
  
  public abstract DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest paramDescribeAlarmsRequest);
  
  public abstract DescribeAlarmsResult describeAlarms();
  
  public abstract DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest paramDescribeAlarmsForMetricRequest);
  
  public abstract DescribeAnomalyDetectorsResult describeAnomalyDetectors(DescribeAnomalyDetectorsRequest paramDescribeAnomalyDetectorsRequest);
  
  public abstract DisableAlarmActionsResult disableAlarmActions(DisableAlarmActionsRequest paramDisableAlarmActionsRequest);
  
  public abstract EnableAlarmActionsResult enableAlarmActions(EnableAlarmActionsRequest paramEnableAlarmActionsRequest);
  
  public abstract GetDashboardResult getDashboard(GetDashboardRequest paramGetDashboardRequest);
  
  public abstract GetMetricDataResult getMetricData(GetMetricDataRequest paramGetMetricDataRequest);
  
  public abstract GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest paramGetMetricStatisticsRequest);
  
  public abstract GetMetricWidgetImageResult getMetricWidgetImage(GetMetricWidgetImageRequest paramGetMetricWidgetImageRequest);
  
  public abstract ListDashboardsResult listDashboards(ListDashboardsRequest paramListDashboardsRequest);
  
  public abstract ListMetricsResult listMetrics(ListMetricsRequest paramListMetricsRequest);
  
  public abstract ListMetricsResult listMetrics();
  
  public abstract ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest paramListTagsForResourceRequest);
  
  public abstract PutAnomalyDetectorResult putAnomalyDetector(PutAnomalyDetectorRequest paramPutAnomalyDetectorRequest);
  
  public abstract PutDashboardResult putDashboard(PutDashboardRequest paramPutDashboardRequest);
  
  public abstract PutMetricAlarmResult putMetricAlarm(PutMetricAlarmRequest paramPutMetricAlarmRequest);
  
  public abstract PutMetricDataResult putMetricData(PutMetricDataRequest paramPutMetricDataRequest);
  
  public abstract SetAlarmStateResult setAlarmState(SetAlarmStateRequest paramSetAlarmStateRequest);
  
  public abstract TagResourceResult tagResource(TagResourceRequest paramTagResourceRequest);
  
  public abstract UntagResourceResult untagResource(UntagResourceRequest paramUntagResourceRequest);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
  
  public abstract AmazonCloudWatchWaiters waiters();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */