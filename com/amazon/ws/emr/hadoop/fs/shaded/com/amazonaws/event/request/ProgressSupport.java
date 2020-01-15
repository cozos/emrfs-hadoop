package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
public class ProgressSupport
  extends Progress
{
  private volatile long requestContentLength = -1L;
  private volatile long requestBytesTransferred;
  private volatile long responseContentLength = -1L;
  private volatile long responseBytesTransferred;
  private static final Object lock = new Object();
  
  public long getRequestContentLength()
  {
    return requestContentLength;
  }
  
  public void addRequestContentLength(long contentLength)
  {
    if (contentLength < 0L) {
      throw new IllegalArgumentException();
    }
    synchronized (lock)
    {
      if (requestContentLength == -1L) {
        requestContentLength = contentLength;
      } else {
        requestContentLength += contentLength;
      }
    }
  }
  
  public long getRequestBytesTransferred()
  {
    return requestBytesTransferred;
  }
  
  public long getResponseContentLength()
  {
    return responseContentLength;
  }
  
  public void addResponseContentLength(long contentLength)
  {
    if (contentLength < 0L) {
      throw new IllegalArgumentException();
    }
    synchronized (lock)
    {
      if (responseContentLength == -1L) {
        responseContentLength = contentLength;
      } else {
        responseContentLength += contentLength;
      }
    }
  }
  
  public long getResponseBytesTransferred()
  {
    return responseBytesTransferred;
  }
  
  public void addRequestBytesTransferred(long bytes)
  {
    synchronized (lock)
    {
      requestBytesTransferred += bytes;
    }
  }
  
  public void addResponseBytesTransferred(long bytes)
  {
    synchronized (lock)
    {
      responseBytesTransferred += bytes;
    }
  }
  
  public String toString()
  {
    return String.format("Request: %d/%d, Response: %d/%d", new Object[] {
      Long.valueOf(requestBytesTransferred), Long.valueOf(requestContentLength), 
      Long.valueOf(responseBytesTransferred), Long.valueOf(responseContentLength) });
  }
  
  public final boolean isEnabled()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.request.ProgressSupport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */