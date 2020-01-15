package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.request;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
public class Progress
{
  public static final Progress NOOP = new Progress();
  private static final String MSG = "No progress tracking configured";
  
  public boolean isEnabled()
  {
    return false;
  }
  
  public void addRequestBytesTransferred(long bytes) {}
  
  public void addResponseBytesTransferred(long bytes) {}
  
  public long getRequestContentLength()
  {
    throw new UnsupportedOperationException("No progress tracking configured");
  }
  
  public void addRequestContentLength(long contentLength) {}
  
  public long getRequestBytesTransferred()
  {
    throw new UnsupportedOperationException("No progress tracking configured");
  }
  
  public long getResponseContentLength()
  {
    throw new UnsupportedOperationException("No progress tracking configured");
  }
  
  public void addResponseContentLength(long contentLength) {}
  
  public long getResponseBytesTransferred()
  {
    throw new UnsupportedOperationException("No progress tracking configured");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.request.Progress
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */