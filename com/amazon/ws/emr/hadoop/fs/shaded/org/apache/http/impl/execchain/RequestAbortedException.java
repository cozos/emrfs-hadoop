package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain;

import java.io.InterruptedIOException;

public class RequestAbortedException
  extends InterruptedIOException
{
  private static final long serialVersionUID = 4973849966012490112L;
  
  public RequestAbortedException(String message)
  {
    super(message);
  }
  
  public RequestAbortedException(String message, Throwable cause)
  {
    super(message);
    if (cause != null) {
      initCause(cause);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.impl.execchain.RequestAbortedException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */