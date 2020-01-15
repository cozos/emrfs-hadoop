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

public class AbstractAmazonCloudWatch
  implements AmazonCloudWatch
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAlarmsResult deleteAlarms(DeleteAlarmsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteAnomalyDetectorResult deleteAnomalyDetector(DeleteAnomalyDetectorRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DeleteDashboardsResult deleteDashboards(DeleteDashboardsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeAlarmHistoryResult describeAlarmHistory()
  {
    return describeAlarmHistory(new DescribeAlarmHistoryRequest());
  }
  
  public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeAlarmsResult describeAlarms()
  {
    return describeAlarms(new DescribeAlarmsRequest());
  }
  
  public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeAnomalyDetectorsResult describeAnomalyDetectors(DescribeAnomalyDetectorsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public DisableAlarmActionsResult disableAlarmActions(DisableAlarmActionsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public EnableAlarmActionsResult enableAlarmActions(EnableAlarmActionsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetDashboardResult getDashboard(GetDashboardRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetMetricDataResult getMetricData(GetMetricDataRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetMetricWidgetImageResult getMetricWidgetImage(GetMetricWidgetImageRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListDashboardsResult listDashboards(ListDashboardsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListMetricsResult listMetrics(ListMetricsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListMetricsResult listMetrics()
  {
    return listMetrics(new ListMetricsRequest());
  }
  
  public ListTagsForResourceResult listTagsForResource(ListTagsForResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutAnomalyDetectorResult putAnomalyDetector(PutAnomalyDetectorRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutDashboardResult putDashboard(PutDashboardRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutMetricAlarmResult putMetricAlarm(PutMetricAlarmRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public PutMetricDataResult putMetricData(PutMetricDataRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public SetAlarmStateResult setAlarmState(SetAlarmStateRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public TagResourceResult tagResource(TagResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public UntagResourceResult untagResource(UntagResourceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public AmazonCloudWatchWaiters waiters()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AbstractAmazonCloudWatch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */