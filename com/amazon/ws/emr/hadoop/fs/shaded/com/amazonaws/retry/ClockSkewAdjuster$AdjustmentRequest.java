package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkBaseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.HttpResponse;

@NotThreadSafe
public final class ClockSkewAdjuster$AdjustmentRequest
{
  private Request<?> clientRequest;
  private HttpResponse serviceResponse;
  private SdkBaseException exception;
  private long currentTime = System.currentTimeMillis();
  
  public AdjustmentRequest clientRequest(Request<?> clientRequest)
  {
    this.clientRequest = clientRequest;
    return this;
  }
  
  public AdjustmentRequest serviceResponse(HttpResponse serviceResponse)
  {
    this.serviceResponse = serviceResponse;
    return this;
  }
  
  public AdjustmentRequest exception(SdkBaseException exception)
  {
    this.exception = exception;
    return this;
  }
  
  @SdkTestInternalApi
  public AdjustmentRequest currentTime(long currentTime)
  {
    this.currentTime = currentTime;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.ClockSkewAdjuster.AdjustmentRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */