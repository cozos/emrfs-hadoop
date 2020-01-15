package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsSyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.DefaultCsmConfigurationProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.MonitoringListener;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class AmazonWebServiceClient$1
  extends AwsSyncClientParams
{
  AmazonWebServiceClient$1(ClientConfiguration paramClientConfiguration, RequestMetricCollector paramRequestMetricCollector) {}
  
  public AWSCredentialsProvider getCredentialsProvider()
  {
    return null;
  }
  
  public ClientConfiguration getClientConfiguration()
  {
    return val$clientConfiguration;
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return val$requestMetricCollector;
  }
  
  public List<RequestHandler2> getRequestHandlers()
  {
    return new CopyOnWriteArrayList();
  }
  
  public CsmConfigurationProvider getClientSideMonitoringConfigurationProvider()
  {
    return DefaultCsmConfigurationProviderChain.getInstance();
  }
  
  public MonitoringListener getMonitoringListener()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */