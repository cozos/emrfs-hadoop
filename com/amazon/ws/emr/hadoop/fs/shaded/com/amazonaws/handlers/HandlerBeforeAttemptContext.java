package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;

public final class HandlerBeforeAttemptContext
{
  private final Request<?> request;
  
  private HandlerBeforeAttemptContext(Request<?> request)
  {
    this.request = request;
  }
  
  public Request<?> getRequest()
  {
    return request;
  }
  
  public static HandlerBeforeAttemptContextBuilder builder()
  {
    return new HandlerBeforeAttemptContextBuilder(null);
  }
  
  public static class HandlerBeforeAttemptContextBuilder
  {
    private Request<?> request;
    
    public HandlerBeforeAttemptContextBuilder withRequest(Request<?> request)
    {
      this.request = request;
      
      return this;
    }
    
    public HandlerBeforeAttemptContext build()
    {
      return new HandlerBeforeAttemptContext(request, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerBeforeAttemptContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */