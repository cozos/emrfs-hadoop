package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.AbortableTransfer;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

@SdkInternalApi
final class AbstractDownloadCallableConfig
{
  private ExecutorService executor;
  private File destFile;
  private CountDownLatch latch;
  private AbortableTransfer abortableDownload;
  private boolean isDownloadParallel;
  private ScheduledExecutorService timedExecutor;
  private long timeout;
  
  public ExecutorService getExecutor()
  {
    return executor;
  }
  
  public void setExecutor(ExecutorService executor)
  {
    this.executor = executor;
  }
  
  public AbstractDownloadCallableConfig withExecutor(ExecutorService executor)
  {
    setExecutor(executor);
    return this;
  }
  
  public File getDestFile()
  {
    return destFile;
  }
  
  public void setDestFile(File destFile)
  {
    this.destFile = destFile;
  }
  
  public AbstractDownloadCallableConfig withDestFile(File destFile)
  {
    setDestFile(destFile);
    return this;
  }
  
  public CountDownLatch getLatch()
  {
    return latch;
  }
  
  public void setLatch(CountDownLatch latch)
  {
    this.latch = latch;
  }
  
  public AbstractDownloadCallableConfig withLatch(CountDownLatch latch)
  {
    setLatch(latch);
    return this;
  }
  
  public AbortableTransfer getAbortableDownload()
  {
    return abortableDownload;
  }
  
  public void setAbortableDownload(AbortableTransfer abortableDownload)
  {
    this.abortableDownload = abortableDownload;
  }
  
  public AbstractDownloadCallableConfig withAbortableDownload(AbortableTransfer abortableDownload)
  {
    setAbortableDownload(abortableDownload);
    return this;
  }
  
  public boolean isDownloadParallel()
  {
    return isDownloadParallel;
  }
  
  public void setDownloadParallel(boolean downloadParallel)
  {
    isDownloadParallel = downloadParallel;
  }
  
  public AbstractDownloadCallableConfig withDownloadParallel(boolean downloadParallel)
  {
    setDownloadParallel(downloadParallel);
    return this;
  }
  
  public ScheduledExecutorService getTimedExecutor()
  {
    return timedExecutor;
  }
  
  public void setTimedExecutor(ScheduledExecutorService timedExecutor)
  {
    this.timedExecutor = timedExecutor;
  }
  
  public AbstractDownloadCallableConfig withTimedExecutor(ScheduledExecutorService timedExecutor)
  {
    setTimedExecutor(timedExecutor);
    return this;
  }
  
  public long getTimeout()
  {
    return timeout;
  }
  
  public void setTimeout(long timeout)
  {
    this.timeout = timeout;
  }
  
  public AbstractDownloadCallableConfig withTimeout(long timeout)
  {
    setTimeout(timeout);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.AbstractDownloadCallableConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */