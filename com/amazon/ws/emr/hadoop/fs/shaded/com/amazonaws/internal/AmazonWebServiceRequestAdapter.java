package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SdkInternalApi
public final class AmazonWebServiceRequestAdapter
  extends RequestConfig
{
  private final AmazonWebServiceRequest request;
  
  public AmazonWebServiceRequestAdapter(AmazonWebServiceRequest request)
  {
    this.request = request;
  }
  
  public ProgressListener getProgressListener()
  {
    return request.getGeneralProgressListener();
  }
  
  public RequestMetricCollector getRequestMetricsCollector()
  {
    return request.getRequestMetricCollector();
  }
  
  public AWSCredentialsProvider getCredentialsProvider()
  {
    return request.getRequestCredentialsProvider();
  }
  
  public Map<String, String> getCustomRequestHeaders()
  {
    return request.getCustomRequestHeaders() == null ? Collections.emptyMap() : request
      .getCustomRequestHeaders();
  }
  
  public Map<String, List<String>> getCustomQueryParameters()
  {
    return request.getCustomQueryParameters() == null ? Collections.emptyMap() : request
      .getCustomQueryParameters();
  }
  
  public Integer getRequestTimeout()
  {
    return request.getSdkRequestTimeout();
  }
  
  public Integer getClientExecutionTimeout()
  {
    return request.getSdkClientExecutionTimeout();
  }
  
  public RequestClientOptions getRequestClientOptions()
  {
    return request.getRequestClientOptions();
  }
  
  public String getRequestType()
  {
    return request.getClass().getSimpleName();
  }
  
  public Object getOriginalRequest()
  {
    return request;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.AmazonWebServiceRequestAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */