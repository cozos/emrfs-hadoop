package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.AmazonWebServiceRequestAdapter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.List;
import java.util.Map;

@SdkProtectedApi
public abstract class RequestConfig
{
  public static final RequestConfig NO_OP = new AmazonWebServiceRequestAdapter(AmazonWebServiceRequest.NOOP);
  
  public abstract ProgressListener getProgressListener();
  
  public abstract RequestMetricCollector getRequestMetricsCollector();
  
  public abstract AWSCredentialsProvider getCredentialsProvider();
  
  public abstract Map<String, String> getCustomRequestHeaders();
  
  public abstract Map<String, List<String>> getCustomQueryParameters();
  
  public abstract Integer getRequestTimeout();
  
  public abstract Integer getClientExecutionTimeout();
  
  public abstract RequestClientOptions getRequestClientOptions();
  
  public abstract String getRequestType();
  
  public abstract Object getOriginalRequest();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */