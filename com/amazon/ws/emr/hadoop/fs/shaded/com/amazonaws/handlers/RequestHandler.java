package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;

@Deprecated
public abstract interface RequestHandler
{
  public abstract void beforeRequest(Request<?> paramRequest);
  
  public abstract void afterResponse(Request<?> paramRequest, Object paramObject, TimingInfo paramTimingInfo);
  
  public abstract void afterError(Request<?> paramRequest, Exception paramException);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */