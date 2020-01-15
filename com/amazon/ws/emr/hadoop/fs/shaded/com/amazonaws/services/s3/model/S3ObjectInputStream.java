package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.MetricAware;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.AwsSdkMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.MetricFilterInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.metrics.S3ServiceMetric;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.methods.HttpRequestBase;
import java.io.IOException;
import java.io.InputStream;

public class S3ObjectInputStream
  extends SdkFilterInputStream
{
  private final HttpRequestBase httpRequest;
  
  public S3ObjectInputStream(InputStream in, HttpRequestBase httpRequest)
  {
    this(in, httpRequest, wrapWithByteCounting(in));
  }
  
  public S3ObjectInputStream(InputStream in, HttpRequestBase httpRequest, boolean collectMetrics)
  {
    super(collectMetrics ? new MetricFilterInputStream(S3ServiceMetric.S3DownloadThroughput, in) : in);
    
    this.httpRequest = httpRequest;
  }
  
  private static boolean wrapWithByteCounting(InputStream in)
  {
    if (!AwsSdkMetrics.isMetricsEnabled()) {
      return false;
    }
    if ((in instanceof MetricAware))
    {
      MetricAware aware = (MetricAware)in;
      
      return !aware.isMetricActivated();
    }
    return true;
  }
  
  public void abort()
  {
    super.abort();
    if (httpRequest != null) {
      httpRequest.abort();
    }
    if (!(in instanceof SdkFilterInputStream)) {
      IOUtils.closeQuietly(in, null);
    }
  }
  
  public HttpRequestBase getHttpRequest()
  {
    return httpRequest;
  }
  
  public int available()
    throws IOException
  {
    int estimate = super.available();
    return estimate == 0 ? 1 : estimate;
  }
  
  public void close()
    throws IOException
  {
    super.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */