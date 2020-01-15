package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class AwsClientBuilder$SyncBuilderParams
  extends AwsAsyncClientParams
{
  private final ClientConfiguration _clientConfig;
  private final AWSCredentialsProvider _credentials;
  private final RequestMetricCollector _metricsCollector;
  private final List<RequestHandler2> _requestHandlers;
  private final CsmConfigurationProvider _csmConfig;
  private final MonitoringListener _monitoringListener;
  private final AdvancedConfig _advancedConfig;
  
  protected AwsClientBuilder$SyncBuilderParams(AwsClientBuilder this$0)
  {
    _clientConfig = AwsClientBuilder.access$000(this$0);
    _credentials = AwsClientBuilder.access$100(this$0);
    _metricsCollector = AwsClientBuilder.access$200(this$0);
    _requestHandlers = AwsClientBuilder.access$300(this$0);
    _csmConfig = AwsClientBuilder.access$400(this$0);
    _monitoringListener = AwsClientBuilder.access$500(this$0);
    _advancedConfig = AwsClientBuilder.access$600(this$0).build();
  }
  
  public AWSCredentialsProvider getCredentialsProvider()
  {
    return _credentials;
  }
  
  public ClientConfiguration getClientConfiguration()
  {
    return _clientConfig;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return _metricsCollector;
  }
  
  public List<RequestHandler2> getRequestHandlers()
  {
    return _requestHandlers;
  }
  
  public CsmConfigurationProvider getClientSideMonitoringConfigurationProvider()
  {
    return _csmConfig;
  }
  
  public MonitoringListener getMonitoringListener()
  {
    return _monitoringListener;
  }
  
  public AdvancedConfig getAdvancedConfig()
  {
    return _advancedConfig;
  }
  
  public ExecutorService getExecutor()
  {
    throw new UnsupportedOperationException("ExecutorService is not used for sync client.");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AwsClientBuilder.SyncBuilderParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */