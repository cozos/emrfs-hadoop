package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
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
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AmazonCloudWatchAsyncClient
  extends AmazonCloudWatchClient
  implements AmazonCloudWatchAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AmazonCloudWatchAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AmazonCloudWatchAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AmazonCloudWatchAsyncClientBuilder asyncBuilder()
  {
    return AmazonCloudWatchAsyncClientBuilder.standard();
  }
  
  AmazonCloudWatchAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<DeleteAlarmsResult> deleteAlarmsAsync(DeleteAlarmsRequest request)
  {
    return deleteAlarmsAsync(request, null);
  }
  
  public Future<DeleteAlarmsResult> deleteAlarmsAsync(DeleteAlarmsRequest request, final AsyncHandler<DeleteAlarmsRequest, DeleteAlarmsResult> asyncHandler)
  {
    final DeleteAlarmsRequest finalRequest = (DeleteAlarmsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteAlarmsResult call()
        throws Exception
      {
        DeleteAlarmsResult result = null;
        try
        {
          result = executeDeleteAlarms(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DeleteAnomalyDetectorResult> deleteAnomalyDetectorAsync(DeleteAnomalyDetectorRequest request)
  {
    return deleteAnomalyDetectorAsync(request, null);
  }
  
  public Future<DeleteAnomalyDetectorResult> deleteAnomalyDetectorAsync(DeleteAnomalyDetectorRequest request, final AsyncHandler<DeleteAnomalyDetectorRequest, DeleteAnomalyDetectorResult> asyncHandler)
  {
    final DeleteAnomalyDetectorRequest finalRequest = (DeleteAnomalyDetectorRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteAnomalyDetectorResult call()
        throws Exception
      {
        DeleteAnomalyDetectorResult result = null;
        try
        {
          result = executeDeleteAnomalyDetector(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DeleteDashboardsResult> deleteDashboardsAsync(DeleteDashboardsRequest request)
  {
    return deleteDashboardsAsync(request, null);
  }
  
  public Future<DeleteDashboardsResult> deleteDashboardsAsync(DeleteDashboardsRequest request, final AsyncHandler<DeleteDashboardsRequest, DeleteDashboardsResult> asyncHandler)
  {
    final DeleteDashboardsRequest finalRequest = (DeleteDashboardsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DeleteDashboardsResult call()
        throws Exception
      {
        DeleteDashboardsResult result = null;
        try
        {
          result = executeDeleteDashboards(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest request)
  {
    return describeAlarmHistoryAsync(request, null);
  }
  
  public Future<DescribeAlarmHistoryResult> describeAlarmHistoryAsync(DescribeAlarmHistoryRequest request, final AsyncHandler<DescribeAlarmHistoryRequest, DescribeAlarmHistoryResult> asyncHandler)
  {
    final DescribeAlarmHistoryRequest finalRequest = (DescribeAlarmHistoryRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeAlarmHistoryResult call()
        throws Exception
      {
        DescribeAlarmHistoryResult result = null;
        try
        {
          result = executeDescribeAlarmHistory(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<DescribeAlarmsResult> describeAlarmsAsync(DescribeAlarmsRequest request, final AsyncHandler<DescribeAlarmsRequest, DescribeAlarmsResult> asyncHandler)
  {
    final DescribeAlarmsRequest finalRequest = (DescribeAlarmsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeAlarmsResult call()
        throws Exception
      {
        DescribeAlarmsResult result = null;
        try
        {
          result = executeDescribeAlarms(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<DescribeAlarmsForMetricResult> describeAlarmsForMetricAsync(DescribeAlarmsForMetricRequest request, final AsyncHandler<DescribeAlarmsForMetricRequest, DescribeAlarmsForMetricResult> asyncHandler)
  {
    final DescribeAlarmsForMetricRequest finalRequest = (DescribeAlarmsForMetricRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeAlarmsForMetricResult call()
        throws Exception
      {
        DescribeAlarmsForMetricResult result = null;
        try
        {
          result = executeDescribeAlarmsForMetric(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DescribeAnomalyDetectorsResult> describeAnomalyDetectorsAsync(DescribeAnomalyDetectorsRequest request)
  {
    return describeAnomalyDetectorsAsync(request, null);
  }
  
  public Future<DescribeAnomalyDetectorsResult> describeAnomalyDetectorsAsync(DescribeAnomalyDetectorsRequest request, final AsyncHandler<DescribeAnomalyDetectorsRequest, DescribeAnomalyDetectorsResult> asyncHandler)
  {
    final DescribeAnomalyDetectorsRequest finalRequest = (DescribeAnomalyDetectorsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DescribeAnomalyDetectorsResult call()
        throws Exception
      {
        DescribeAnomalyDetectorsResult result = null;
        try
        {
          result = executeDescribeAnomalyDetectors(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DisableAlarmActionsResult> disableAlarmActionsAsync(DisableAlarmActionsRequest request)
  {
    return disableAlarmActionsAsync(request, null);
  }
  
  public Future<DisableAlarmActionsResult> disableAlarmActionsAsync(DisableAlarmActionsRequest request, final AsyncHandler<DisableAlarmActionsRequest, DisableAlarmActionsResult> asyncHandler)
  {
    final DisableAlarmActionsRequest finalRequest = (DisableAlarmActionsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DisableAlarmActionsResult call()
        throws Exception
      {
        DisableAlarmActionsResult result = null;
        try
        {
          result = executeDisableAlarmActions(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<EnableAlarmActionsResult> enableAlarmActionsAsync(EnableAlarmActionsRequest request)
  {
    return enableAlarmActionsAsync(request, null);
  }
  
  public Future<EnableAlarmActionsResult> enableAlarmActionsAsync(EnableAlarmActionsRequest request, final AsyncHandler<EnableAlarmActionsRequest, EnableAlarmActionsResult> asyncHandler)
  {
    final EnableAlarmActionsRequest finalRequest = (EnableAlarmActionsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public EnableAlarmActionsResult call()
        throws Exception
      {
        EnableAlarmActionsResult result = null;
        try
        {
          result = executeEnableAlarmActions(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetDashboardResult> getDashboardAsync(GetDashboardRequest request)
  {
    return getDashboardAsync(request, null);
  }
  
  public Future<GetDashboardResult> getDashboardAsync(GetDashboardRequest request, final AsyncHandler<GetDashboardRequest, GetDashboardResult> asyncHandler)
  {
    final GetDashboardRequest finalRequest = (GetDashboardRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetDashboardResult call()
        throws Exception
      {
        GetDashboardResult result = null;
        try
        {
          result = executeGetDashboard(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetMetricDataResult> getMetricDataAsync(GetMetricDataRequest request)
  {
    return getMetricDataAsync(request, null);
  }
  
  public Future<GetMetricDataResult> getMetricDataAsync(GetMetricDataRequest request, final AsyncHandler<GetMetricDataRequest, GetMetricDataResult> asyncHandler)
  {
    final GetMetricDataRequest finalRequest = (GetMetricDataRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetMetricDataResult call()
        throws Exception
      {
        GetMetricDataResult result = null;
        try
        {
          result = executeGetMetricData(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest request)
  {
    return getMetricStatisticsAsync(request, null);
  }
  
  public Future<GetMetricStatisticsResult> getMetricStatisticsAsync(GetMetricStatisticsRequest request, final AsyncHandler<GetMetricStatisticsRequest, GetMetricStatisticsResult> asyncHandler)
  {
    final GetMetricStatisticsRequest finalRequest = (GetMetricStatisticsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetMetricStatisticsResult call()
        throws Exception
      {
        GetMetricStatisticsResult result = null;
        try
        {
          result = executeGetMetricStatistics(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetMetricWidgetImageResult> getMetricWidgetImageAsync(GetMetricWidgetImageRequest request)
  {
    return getMetricWidgetImageAsync(request, null);
  }
  
  public Future<GetMetricWidgetImageResult> getMetricWidgetImageAsync(GetMetricWidgetImageRequest request, final AsyncHandler<GetMetricWidgetImageRequest, GetMetricWidgetImageResult> asyncHandler)
  {
    final GetMetricWidgetImageRequest finalRequest = (GetMetricWidgetImageRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetMetricWidgetImageResult call()
        throws Exception
      {
        GetMetricWidgetImageResult result = null;
        try
        {
          result = executeGetMetricWidgetImage(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListDashboardsResult> listDashboardsAsync(ListDashboardsRequest request)
  {
    return listDashboardsAsync(request, null);
  }
  
  public Future<ListDashboardsResult> listDashboardsAsync(ListDashboardsRequest request, final AsyncHandler<ListDashboardsRequest, ListDashboardsResult> asyncHandler)
  {
    final ListDashboardsRequest finalRequest = (ListDashboardsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListDashboardsResult call()
        throws Exception
      {
        ListDashboardsResult result = null;
        try
        {
          result = executeListDashboards(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest request)
  {
    return listMetricsAsync(request, null);
  }
  
  public Future<ListMetricsResult> listMetricsAsync(ListMetricsRequest request, final AsyncHandler<ListMetricsRequest, ListMetricsResult> asyncHandler)
  {
    final ListMetricsRequest finalRequest = (ListMetricsRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListMetricsResult call()
        throws Exception
      {
        ListMetricsResult result = null;
        try
        {
          result = executeListMetrics(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
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
  
  public Future<ListTagsForResourceResult> listTagsForResourceAsync(ListTagsForResourceRequest request, final AsyncHandler<ListTagsForResourceRequest, ListTagsForResourceResult> asyncHandler)
  {
    final ListTagsForResourceRequest finalRequest = (ListTagsForResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public ListTagsForResourceResult call()
        throws Exception
      {
        ListTagsForResourceResult result = null;
        try
        {
          result = executeListTagsForResource(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<PutAnomalyDetectorResult> putAnomalyDetectorAsync(PutAnomalyDetectorRequest request)
  {
    return putAnomalyDetectorAsync(request, null);
  }
  
  public Future<PutAnomalyDetectorResult> putAnomalyDetectorAsync(PutAnomalyDetectorRequest request, final AsyncHandler<PutAnomalyDetectorRequest, PutAnomalyDetectorResult> asyncHandler)
  {
    final PutAnomalyDetectorRequest finalRequest = (PutAnomalyDetectorRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutAnomalyDetectorResult call()
        throws Exception
      {
        PutAnomalyDetectorResult result = null;
        try
        {
          result = executePutAnomalyDetector(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<PutDashboardResult> putDashboardAsync(PutDashboardRequest request)
  {
    return putDashboardAsync(request, null);
  }
  
  public Future<PutDashboardResult> putDashboardAsync(PutDashboardRequest request, final AsyncHandler<PutDashboardRequest, PutDashboardResult> asyncHandler)
  {
    final PutDashboardRequest finalRequest = (PutDashboardRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutDashboardResult call()
        throws Exception
      {
        PutDashboardResult result = null;
        try
        {
          result = executePutDashboard(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<PutMetricAlarmResult> putMetricAlarmAsync(PutMetricAlarmRequest request)
  {
    return putMetricAlarmAsync(request, null);
  }
  
  public Future<PutMetricAlarmResult> putMetricAlarmAsync(PutMetricAlarmRequest request, final AsyncHandler<PutMetricAlarmRequest, PutMetricAlarmResult> asyncHandler)
  {
    final PutMetricAlarmRequest finalRequest = (PutMetricAlarmRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutMetricAlarmResult call()
        throws Exception
      {
        PutMetricAlarmResult result = null;
        try
        {
          result = executePutMetricAlarm(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<PutMetricDataResult> putMetricDataAsync(PutMetricDataRequest request)
  {
    return putMetricDataAsync(request, null);
  }
  
  public Future<PutMetricDataResult> putMetricDataAsync(PutMetricDataRequest request, final AsyncHandler<PutMetricDataRequest, PutMetricDataResult> asyncHandler)
  {
    final PutMetricDataRequest finalRequest = (PutMetricDataRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public PutMetricDataResult call()
        throws Exception
      {
        PutMetricDataResult result = null;
        try
        {
          result = executePutMetricData(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<SetAlarmStateResult> setAlarmStateAsync(SetAlarmStateRequest request)
  {
    return setAlarmStateAsync(request, null);
  }
  
  public Future<SetAlarmStateResult> setAlarmStateAsync(SetAlarmStateRequest request, final AsyncHandler<SetAlarmStateRequest, SetAlarmStateResult> asyncHandler)
  {
    final SetAlarmStateRequest finalRequest = (SetAlarmStateRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public SetAlarmStateResult call()
        throws Exception
      {
        SetAlarmStateResult result = null;
        try
        {
          result = executeSetAlarmState(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request)
  {
    return tagResourceAsync(request, null);
  }
  
  public Future<TagResourceResult> tagResourceAsync(TagResourceRequest request, final AsyncHandler<TagResourceRequest, TagResourceResult> asyncHandler)
  {
    final TagResourceRequest finalRequest = (TagResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public TagResourceResult call()
        throws Exception
      {
        TagResourceResult result = null;
        try
        {
          result = executeTagResource(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request)
  {
    return untagResourceAsync(request, null);
  }
  
  public Future<UntagResourceResult> untagResourceAsync(UntagResourceRequest request, final AsyncHandler<UntagResourceRequest, UntagResourceResult> asyncHandler)
  {
    final UntagResourceRequest finalRequest = (UntagResourceRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public UntagResourceResult call()
        throws Exception
      {
        UntagResourceResult result = null;
        try
        {
          result = executeUntagResource(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public void shutdown()
  {
    super.shutdown();
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatchAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */