package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Response;

public final class HandlerAfterAttemptContext
{
  private final Request<?> request;
  private final Response<?> response;
  private final Exception exception;
  
  private HandlerAfterAttemptContext(Request<?> request, Response<?> response, Exception exception)
  {
    this.request = request;
    this.response = response;
    this.exception = exception;
  }
  
  public Request<?> getRequest()
  {
    return request;
  }
  
  public Response<?> getResponse()
  {
    return response;
  }
  
  public Exception getException()
  {
    return exception;
  }
  
  public static HandlerAfterAttemptContextBuilder builder()
  {
    return new HandlerAfterAttemptContextBuilder(null);
  }
  
  public static class HandlerAfterAttemptContextBuilder
  {
    private Request<?> request;
    private Response<?> response;
    private Exception exception;
    
    public HandlerAfterAttemptContextBuilder withRequest(Request<?> request)
    {
      this.request = request;
      
      return this;
    }
    
    public HandlerAfterAttemptContextBuilder withResponse(Response<?> response)
    {
      this.response = response;
      
      return this;
    }
    
    public HandlerAfterAttemptContextBuilder withException(Exception exception)
    {
      this.exception = exception;
      
      return this;
    }
    
    public HandlerAfterAttemptContext build()
    {
      return new HandlerAfterAttemptContext(request, response, exception, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.HandlerAfterAttemptContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */