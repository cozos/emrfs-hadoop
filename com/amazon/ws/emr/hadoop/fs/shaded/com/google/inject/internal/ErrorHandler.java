package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.Message;

abstract interface ErrorHandler
{
  public abstract void handle(Object paramObject, Errors paramErrors);
  
  public abstract void handle(Message paramMessage);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ErrorHandler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */