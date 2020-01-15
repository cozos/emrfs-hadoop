package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.builder.AdvancedConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicyAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicy;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.List;

@SdkProtectedApi
public abstract class AwsSyncClientParams
{
  public abstract AWSCredentialsProvider getCredentialsProvider();
  
  public abstract ClientConfiguration getClientConfiguration();
  
  public abstract RequestMetricCollector getRequestMetricCollector();
  
  public abstract List<RequestHandler2> getRequestHandlers();
  
  public abstract CsmConfigurationProvider getClientSideMonitoringConfigurationProvider();
  
  public abstract MonitoringListener getMonitoringListener();
  
  public AdvancedConfig getAdvancedConfig()
  {
    return AdvancedConfig.EMPTY;
  }
  
  public SignerProvider getSignerProvider()
  {
    return null;
  }
  
  public URI getEndpoint()
  {
    return null;
  }
  
  public RetryPolicy getRetryPolicy()
  {
    ClientConfiguration config = getClientConfiguration();
    return new RetryPolicyAdapter(config.getRetryPolicy(), config);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */