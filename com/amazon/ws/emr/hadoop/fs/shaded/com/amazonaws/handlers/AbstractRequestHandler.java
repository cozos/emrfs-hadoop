package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.TimingInfo;

@Deprecated
public abstract class AbstractRequestHandler
  implements RequestHandler
{
  public void beforeRequest(Request<?> request) {}
  
  public void afterResponse(Request<?> request, Object response, TimingInfo timingInfo) {}
  
  public void afterError(Request<?> request, Exception e) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AbstractRequestHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */