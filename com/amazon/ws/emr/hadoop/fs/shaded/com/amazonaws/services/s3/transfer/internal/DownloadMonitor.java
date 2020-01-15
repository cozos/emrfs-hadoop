package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import java.util.concurrent.Future;

public class DownloadMonitor
  implements TransferMonitor
{
  private Future<?> future;
  private final AbstractTransfer download;
  
  public DownloadMonitor(DownloadImpl download, Future<?> future)
  {
    this(download, future);
  }
  
  public DownloadMonitor(AbstractTransfer download, Future<?> future)
  {
    this.download = download;
    this.future = future;
  }
  
  public synchronized Future<?> getFuture()
  {
    return future;
  }
  
  public synchronized void setFuture(Future<?> future)
  {
    this.future = future;
  }
  
  public boolean isDone()
  {
    return download.isDone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */