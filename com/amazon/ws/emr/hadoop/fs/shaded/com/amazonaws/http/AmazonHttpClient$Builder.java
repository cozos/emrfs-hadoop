package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.v2.RetryPolicy;

public class AmazonHttpClient$Builder
{
  private ClientConfiguration clientConfig;
  private RetryPolicy retryPolicy;
  private RequestMetricCollector requestMetricCollector;
  private boolean useBrowserCompatibleHostNameVerifier;
  private boolean calculateCRC32FromCompressedData;
  
  public Builder clientConfiguration(ClientConfiguration clientConfig)
  {
    this.clientConfig = clientConfig;
    return this;
  }
  
  public Builder retryPolicy(RetryPolicy retryPolicy)
  {
    this.retryPolicy = retryPolicy;
    return this;
  }
  
  public Builder requestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    this.requestMetricCollector = requestMetricCollector;
    return this;
  }
  
  public Builder useBrowserCompatibleHostNameVerifier(boolean useBrowserCompatibleHostNameVerifier)
  {
    this.useBrowserCompatibleHostNameVerifier = useBrowserCompatibleHostNameVerifier;
    return this;
  }
  
  public Builder calculateCRC32FromCompressedData(boolean calculateCRC32FromCompressedData)
  {
    this.calculateCRC32FromCompressedData = calculateCRC32FromCompressedData;
    return this;
  }
  
  public AmazonHttpClient build()
  {
    return new AmazonHttpClient(clientConfig, retryPolicy, requestMetricCollector, useBrowserCompatibleHostNameVerifier, calculateCRC32FromCompressedData, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.AmazonHttpClient.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */