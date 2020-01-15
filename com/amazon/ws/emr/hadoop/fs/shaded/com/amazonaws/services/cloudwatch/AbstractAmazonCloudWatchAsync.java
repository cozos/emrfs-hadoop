package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
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
import java.util.concurrent.Future;

public class AbstractAmazonCloudWatchAsync
  extends AbstractAmazonCloudWatch
  implements AmazonCloudWatchAsync
{
  public Future<DeleteAlarmsResult> deleteAlarmsAsync(DeleteAlarmsRequest request)
  {
    return deleteAlarmsAsync(request, null);
  }
  
  public Future<DeleteAlarmsResult> deleteAlarmsAsync(DeleteAlarmsRequest request, AsyncHandler<DeleteAlarmsRequest, DeleteAlarmsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteAnomalyDetectorResult> deleteAnomalyDetectorAsync(DeleteAnomalyDetectorRequest request)
  {
    return deleteAnomalyDetectorAsync(request, null);
  }
  
  public Future<DeleteAnomalyDetectorResult> deleteAnomalyDetectorAsync(DeleteAnomalyDetectorRequest request, AsyncHandler<DeleteAnomalyDetectorRequest, DeleteAnomalyDetectorResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DeleteDashboardsResult> deleteDashboardsAsync(DeleteDashboardsRequest request)
  {
    return deleteDashboardsAsync(request, null);
  }
  
  public Future<DeleteDashboardsResult> deleteDashboardsAsync(DeleteDashboardsRequest request, AsyncHandler<DeleteDashboardsRequest, DeleteDashboardsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest request)
  {
    return describeAlarmHistoryAsync(request, null);
  }
  
  public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest request, AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync()
  {
    return describeAlarmHistoryAsync(new DescribeAlarmHistoryRequest());
  }
  
  public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> asyncHandler)
  {
    return describeAlarmHistoryAsync(new DescribeAlarmHistoryRequest(), asyncHandler);
  }
  
  public Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest request)
  {
    return describeAlarmsAsync(request, null);
  }
  
  public Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest request, AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeAlarmsResult> describeAlarmsAsync()
  {
    return describeAlarmsAsync(new DescribeAlarmsRequest());
  }
  
  public Future<DescribeAlarmsResult> describeAlarmsAsync(AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> asyncHandler)
  {
    return describeAlarmsAsync(new DescribeAlarmsRequest(), asyncHandler);
  }
  
  public Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest request)
  {
    return describeAlarmsForMetricAsync(request, null);
  }
  
  public Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest request, AsyncHandler<DescribeAlarmsForMetricRequest, DescribeAlarmsForMetricResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DescribeAnomalyDetectorsResult> describeAnomalyDetectorsAsync(DescribeAnomalyDetectorsRequest request)
  {
    return describeAnomalyDetectorsAsync(request, null);
  }
  
  public Future<DescribeAnomalyDetectorsResult> describeAnomalyDetectorsAsync(DescribeAnomalyDetectorsRequest request, AsyncHandler<DescribeAnomalyDetectorsRequest, DescribeAnomalyDetectorsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<DisableAlarmActionsResult> disableAlarmActionsAsync(DisableAlarmActionsRequest request)
  {
    return disableAlarmActionsAsync(request, null);
  }
  
  public Future<DisableAlarmActionsResult> disableAlarmActionsAsync(DisableAlarmActionsRequest request, AsyncHandler<DisableAlarmActionsRequest, DisableAlarmActionsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<EnableAlarmActionsResult> enableAlarmActionsAsync(EnableAlarmActionsRequest request)
  {
    return enableAlarmActionsAsync(request, null);
  }
  
  public Future<EnableAlarmActionsResult> enableAlarmActionsAsync(EnableAlarmActionsRequest request, AsyncHandler<EnableAlarmActionsRequest, EnableAlarmActionsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetDashboardResult> getDashboardAsync(GetDashboardRequest request)
  {
    return getDashboardAsync(request, null);
  }
  
  public Future<GetDashboardResult> getDashboardAsync(GetDashboardRequest request, AsyncHandler<GetDashboardRequest, GetDashboardResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetMetricDataResult> getMetricDataAsync(GetMetricDataRequest request)
  {
    return getMetricDataAsync(request, null);
  }
  
  public Future<GetMetricDataResult> getMetricDataAsync(GetMetricDataRequest request, AsyncHandler<GetMetricDataRequest, GetMetricDataResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest request)
  {
    return getMetricStatisticsAsync(request, null);
  }
  
  public Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest request, AsyncHandler<GetMetricStatisticsRequest, GetMetricStatisticsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetMetricWidgetImageResult> getMetricWidgetImageAsync(GetMetricWidgetImageRequest request)
  {
    return getMetricWidgetImageAsync(request, null);
  }
  
  public Future<GetMetricWidgetImageResult> getMetricWidgetImageAsync(GetMetricWidgetImageRequest request, AsyncHandler<GetMetricWidgetImageRequest, GetMetricWidgetImageResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListDashboardsResult> listDashboardsAsync(ListDashboardsRequest request)
  {
    return listDashboardsAsync(request, null);
  }
  
  public Future<ListDashboardsResult> listDashboardsAsync(ListDashboardsRequest request, AsyncHandler<ListDashboardsRequest, ListDashboardsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest request)
  {
    return listMetricsAsync(request, null);
  }
  
  public Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest request, AsyncHandler<ListMetricsRequest, ListMetricsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListMetricsResult> listMetricsAsync()
  {
    return listMetricsAsync(new ListMetricsRequest());
  }
  
  public Future<ListMetricsResult> listMetricsAsync(AsyncHandler<ListMetricsRequest, ListMetricsResult> asyncHandler)
  {
    return listMetricsAsync(new ListMetricsRequest(), asyncHandler);
  }
  
  public Future<ListTagsForResourceResult> listTagsForResourceAsync(ListTagsForResourceRequest request)
  {
    return listTagsForResourceAsync(request, null);
  }
  
  public Future<ListTagsForResourceResult> listTagsForResourceAsync(ListTagsForResourceRequest request, AsyncHandler<ListTagsForResourceRequest, ListTagsForResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutAnomalyDetectorResult> putAnomalyDetectorAsync(PutAnomalyDetectorRequest request)
  {
    return putAnomalyDetectorAsync(request, null);
  }
  
  public Future<PutAnomalyDetectorResult> putAnomalyDetectorAsync(PutAnomalyDetectorRequest request, AsyncHandler<PutAnomalyDetectorRequest, PutAnomalyDetectorResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutDashboardResult> putDashboardAsync(PutDashboardRequest request)
  {
    return putDashboardAsync(request, null);
  }
  
  public Future<PutDashboardResult> putDashboardAsync(PutDashboardRequest request, AsyncHandler<PutDashboardRequest, PutDashboardResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutMetricAlarmResult> putMetricAlarmAsync(PutMetricAlarmRequest request)
  {
    return putMetricAlarmAsync(request, null);
  }
  
  public Future<PutMetricAlarmResult> putMetricAlarmAsync(PutMetricAlarmRequest request, AsyncHandler<PutMetricAlarmRequest, PutMetricAlarmResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<PutMetricDataResult> putMetricDataAsync(PutMetricDataRequest request)
  {
    return putMetricDataAsync(request, null);
  }
  
  public Future<PutMetricDataResult> putMetricDataAsync(PutMetricDataRequest request, AsyncHandler<PutMetricDataRequest, PutMetricDataResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<SetAlarmStateResult> setAlarmStateAsync(SetAlarmStateRequest request)
  {
    return setAlarmStateAsync(request, null);
  }
  
  public Future<SetAlarmStateResult> setAlarmStateAsync(SetAlarmStateRequest request, AsyncHandler<SetAlarmStateRequest, SetAlarmStateResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request)
  {
    return tagResourceAsync(request, null);
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request, AsyncHandler<TagResourceRequest, TagResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request)
  {
    return untagResourceAsync(request, null);
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request, AsyncHandler<UntagResourceRequest, UntagResourceResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AbstractAmazonCloudWatchAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */