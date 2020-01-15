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

public abstract interface AmazonCloudWatchAsync
  extends AmazonCloudWatch
{
  public abstract Future<DeleteAlarmsResult> deleteAlarmsAsync(DeleteAlarmsRequest paramDeleteAlarmsRequest);
  
  public abstract Future<DeleteAlarmsResult> deleteAlarmsAsync(DeleteAlarmsRequest paramDeleteAlarmsRequest, AsyncHandler<DeleteAlarmsRequest, DeleteAlarmsResult> paramAsyncHandler);
  
  public abstract Future<DeleteAnomalyDetectorResult> deleteAnomalyDetectorAsync(DeleteAnomalyDetectorRequest paramDeleteAnomalyDetectorRequest);
  
  public abstract Future<DeleteAnomalyDetectorResult> deleteAnomalyDetectorAsync(DeleteAnomalyDetectorRequest paramDeleteAnomalyDetectorRequest, AsyncHandler<DeleteAnomalyDetectorRequest, DeleteAnomalyDetectorResult> paramAsyncHandler);
  
  public abstract Future<DeleteDashboardsResult> deleteDashboardsAsync(DeleteDashboardsRequest paramDeleteDashboardsRequest);
  
  public abstract Future<DeleteDashboardsResult> deleteDashboardsAsync(DeleteDashboardsRequest paramDeleteDashboardsRequest, AsyncHandler<DeleteDashboardsRequest, DeleteDashboardsResult> paramAsyncHandler);
  
  public abstract Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest paramDescribeAlarmHistoryRequest);
  
  public abstract Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest paramDescribeAlarmHistoryRequest, AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> paramAsyncHandler);
  
  public abstract Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync();
  
  public abstract Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> paramAsyncHandler);
  
  public abstract Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest paramDescribeAlarmsRequest);
  
  public abstract Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest paramDescribeAlarmsRequest, AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> paramAsyncHandler);
  
  public abstract Future<DescribeAlarmsResult> describeAlarmsAsync();
  
  public abstract Future<DescribeAlarmsResult> describeAlarmsAsync(AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> paramAsyncHandler);
  
  public abstract Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest paramDescribeAlarmsForMetricRequest);
  
  public abstract Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest paramDescribeAlarmsForMetricRequest, AsyncHandler<DescribeAlarmsForMetricRequest, DescribeAlarmsForMetricResult> paramAsyncHandler);
  
  public abstract Future<DescribeAnomalyDetectorsResult> describeAnomalyDetectorsAsync(DescribeAnomalyDetectorsRequest paramDescribeAnomalyDetectorsRequest);
  
  public abstract Future<DescribeAnomalyDetectorsResult> describeAnomalyDetectorsAsync(DescribeAnomalyDetectorsRequest paramDescribeAnomalyDetectorsRequest, AsyncHandler<DescribeAnomalyDetectorsRequest, DescribeAnomalyDetectorsResult> paramAsyncHandler);
  
  public abstract Future<DisableAlarmActionsResult> disableAlarmActionsAsync(DisableAlarmActionsRequest paramDisableAlarmActionsRequest);
  
  public abstract Future<DisableAlarmActionsResult> disableAlarmActionsAsync(DisableAlarmActionsRequest paramDisableAlarmActionsRequest, AsyncHandler<DisableAlarmActionsRequest, DisableAlarmActionsResult> paramAsyncHandler);
  
  public abstract Future<EnableAlarmActionsResult> enableAlarmActionsAsync(EnableAlarmActionsRequest paramEnableAlarmActionsRequest);
  
  public abstract Future<EnableAlarmActionsResult> enableAlarmActionsAsync(EnableAlarmActionsRequest paramEnableAlarmActionsRequest, AsyncHandler<EnableAlarmActionsRequest, EnableAlarmActionsResult> paramAsyncHandler);
  
  public abstract Future<GetDashboardResult> getDashboardAsync(GetDashboardRequest paramGetDashboardRequest);
  
  public abstract Future<GetDashboardResult> getDashboardAsync(GetDashboardRequest paramGetDashboardRequest, AsyncHandler<GetDashboardRequest, GetDashboardResult> paramAsyncHandler);
  
  public abstract Future<GetMetricDataResult> getMetricDataAsync(GetMetricDataRequest paramGetMetricDataRequest);
  
  public abstract Future<GetMetricDataResult> getMetricDataAsync(GetMetricDataRequest paramGetMetricDataRequest, AsyncHandler<GetMetricDataRequest, GetMetricDataResult> paramAsyncHandler);
  
  public abstract Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest paramGetMetricStatisticsRequest);
  
  public abstract Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest paramGetMetricStatisticsRequest, AsyncHandler<GetMetricStatisticsRequest, GetMetricStatisticsResult> paramAsyncHandler);
  
  public abstract Future<GetMetricWidgetImageResult> getMetricWidgetImageAsync(GetMetricWidgetImageRequest paramGetMetricWidgetImageRequest);
  
  public abstract Future<GetMetricWidgetImageResult> getMetricWidgetImageAsync(GetMetricWidgetImageRequest paramGetMetricWidgetImageRequest, AsyncHandler<GetMetricWidgetImageRequest, GetMetricWidgetImageResult> paramAsyncHandler);
  
  public abstract Future<ListDashboardsResult> listDashboardsAsync(ListDashboardsRequest paramListDashboardsRequest);
  
  public abstract Future<ListDashboardsResult> listDashboardsAsync(ListDashboardsRequest paramListDashboardsRequest, AsyncHandler<ListDashboardsRequest, ListDashboardsResult> paramAsyncHandler);
  
  public abstract Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest paramListMetricsRequest);
  
  public abstract Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest paramListMetricsRequest, AsyncHandler<ListMetricsRequest, ListMetricsResult> paramAsyncHandler);
  
  public abstract Future<ListMetricsResult> listMetricsAsync();
  
  public abstract Future<ListMetricsResult> listMetricsAsync(AsyncHandler<ListMetricsRequest, ListMetricsResult> paramAsyncHandler);
  
  public abstract Future<ListTagsForResourceResult> listTagsForResourceAsync(ListTagsForResourceRequest paramListTagsForResourceRequest);
  
  public abstract Future<ListTagsForResourceResult> listTagsForResourceAsync(ListTagsForResourceRequest paramListTagsForResourceRequest, AsyncHandler<ListTagsForResourceRequest, ListTagsForResourceResult> paramAsyncHandler);
  
  public abstract Future<PutAnomalyDetectorResult> putAnomalyDetectorAsync(PutAnomalyDetectorRequest paramPutAnomalyDetectorRequest);
  
  public abstract Future<PutAnomalyDetectorResult> putAnomalyDetectorAsync(PutAnomalyDetectorRequest paramPutAnomalyDetectorRequest, AsyncHandler<PutAnomalyDetectorRequest, PutAnomalyDetectorResult> paramAsyncHandler);
  
  public abstract Future<PutDashboardResult> putDashboardAsync(PutDashboardRequest paramPutDashboardRequest);
  
  public abstract Future<PutDashboardResult> putDashboardAsync(PutDashboardRequest paramPutDashboardRequest, AsyncHandler<PutDashboardRequest, PutDashboardResult> paramAsyncHandler);
  
  public abstract Future<PutMetricAlarmResult> putMetricAlarmAsync(PutMetricAlarmRequest paramPutMetricAlarmRequest);
  
  public abstract Future<PutMetricAlarmResult> putMetricAlarmAsync(PutMetricAlarmRequest paramPutMetricAlarmRequest, AsyncHandler<PutMetricAlarmRequest, PutMetricAlarmResult> paramAsyncHandler);
  
  public abstract Future<PutMetricDataResult> putMetricDataAsync(PutMetricDataRequest paramPutMetricDataRequest);
  
  public abstract Future<PutMetricDataResult> putMetricDataAsync(PutMetricDataRequest paramPutMetricDataRequest, AsyncHandler<PutMetricDataRequest, PutMetricDataResult> paramAsyncHandler);
  
  public abstract Future<SetAlarmStateResult> setAlarmStateAsync(SetAlarmStateRequest paramSetAlarmStateRequest);
  
  public abstract Future<SetAlarmStateResult> setAlarmStateAsync(SetAlarmStateRequest paramSetAlarmStateRequest, AsyncHandler<SetAlarmStateRequest, SetAlarmStateResult> paramAsyncHandler);
  
  public abstract Future<TagResourceResult> tagResourceAsync(TagResourceRequest paramTagResourceRequest);
  
  public abstract Future<TagResourceResult> tagResourceAsync(TagResourceRequest paramTagResourceRequest, AsyncHandler<TagResourceRequest, TagResourceResult> paramAsyncHandler);
  
  public abstract Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest paramUntagResourceRequest);
  
  public abstract Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest paramUntagResourceRequest, AsyncHandler<UntagResourceRequest, UntagResourceResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */