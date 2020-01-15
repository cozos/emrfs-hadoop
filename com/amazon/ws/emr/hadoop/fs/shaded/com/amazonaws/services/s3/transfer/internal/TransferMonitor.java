package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import java.util.concurrent.Future;

public abstract interface TransferMonitor
{
  public abstract Future<?> getFuture();
  
  public abstract boolean isDone();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */