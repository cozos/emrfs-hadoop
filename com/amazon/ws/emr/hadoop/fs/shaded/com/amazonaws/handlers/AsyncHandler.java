package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;

public abstract interface AsyncHandler<REQUEST extends AmazonWebServiceRequest, RESULT>
{
  public abstract void onError(Exception paramException);
  
  public abstract void onSuccess(REQUEST paramREQUEST, RESULT paramRESULT);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */