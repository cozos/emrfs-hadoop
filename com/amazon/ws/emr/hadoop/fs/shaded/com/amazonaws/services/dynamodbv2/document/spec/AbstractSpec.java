package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;

class AbstractSpec<T extends AmazonWebServiceRequest>
{
  private final T req;
  
  AbstractSpec(T req)
  {
    InternalUtils.applyUserAgent(req);
    this.req = req;
  }
  
  public T getRequest()
  {
    return req;
  }
  
  public ProgressListener getProgressListener()
  {
    return getRequest().getGeneralProgressListener();
  }
  
  public void setProgressListener(ProgressListener progressListener)
  {
    getRequest().setGeneralProgressListener(progressListener);
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return getRequest().getRequestMetricCollector();
  }
  
  public void setRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    getRequest().setRequestMetricCollector(requestMetricCollector);
  }
  
  public AbstractSpec<T> withProgressListener(ProgressListener progressListener)
  {
    getRequest().setGeneralProgressListener(progressListener);
    return this;
  }
  
  public AbstractSpec<T> withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    getRequest().setRequestMetricCollector(requestMetricCollector);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.AbstractSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */