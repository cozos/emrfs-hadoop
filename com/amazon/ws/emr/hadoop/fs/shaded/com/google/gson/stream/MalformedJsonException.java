package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream;

import java.io.IOException;

public final class MalformedJsonException
  extends IOException
{
  private static final long serialVersionUID = 1L;
  
  public MalformedJsonException(String msg)
  {
    super(msg);
  }
  
  public MalformedJsonException(String msg, Throwable throwable)
  {
    super(msg);
    
    initCause(throwable);
  }
  
  public MalformedJsonException(Throwable throwable)
  {
    initCause(throwable);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.stream.MalformedJsonException
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */