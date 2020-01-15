package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.AbortableTransfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SdkInternalApi
public abstract class AbstractDownloadCallable
  implements Callable<File>
{
  protected final ExecutorService executor;
  protected final List<Future<Long>> futures;
  protected final File dstfile;
  private final CountDownLatch latch;
  private final AbortableTransfer abortableDownload;
  private final boolean isDownloadParallel;
  private final ScheduledExecutorService timedExecutor;
  private final long timeout;
  
  protected AbstractDownloadCallable(AbstractDownloadCallableConfig options)
  {
    if ((options.getLatch() == null) || (options.getDestFile() == null) || (options.getAbortableDownload() == null)) {
      throw new IllegalArgumentException();
    }
    executor = options.getExecutor();
    timedExecutor = options.getTimedExecutor();
    futures = new ArrayList();
    dstfile = options.getDestFile();
    latch = options.getLatch();
    abortableDownload = options.getAbortableDownload();
    isDownloadParallel = options.isDownloadParallel();
    timeout = options.getTimeout();
  }
  
  public File call()
    throws Exception
  {
    try
    {
      latch.await();
      if (isTimeoutEnabled()) {
        timedExecutor.schedule(new Runnable()
        {
          public void run()
          {
            try
            {
              if (abortableDownload.getState() != Transfer.TransferState.Completed) {
                abortableDownload.abort();
              }
            }
            catch (Exception e)
            {
              throw new SdkClientException("Unable to abort download after timeout", e);
            }
          }
        }, timeout, TimeUnit.MILLISECONDS);
      }
      setState(Transfer.TransferState.InProgress);
      ServiceUtils.createParentDirectoryIfNecessary(dstfile);
      if (isDownloadParallel) {
        downloadInParallel();
      } else {
        downloadAsSingleObject();
      }
      return dstfile;
    }
    catch (Throwable t)
    {
      cleanupAfterException();
      if ((t instanceof Exception)) {
        throw ((Exception)t);
      }
      throw ((Error)t);
    }
  }
  
  protected abstract void setState(Transfer.TransferState paramTransferState);
  
  protected abstract void downloadAsSingleObject();
  
  protected abstract void downloadInParallel()
    throws Exception;
  
  protected static AbstractDownloadCallableConfig constructCallableConfig(ExecutorService executor, File dstfile, CountDownLatch latch, AbortableTransfer download, boolean isDownloadParallel, ScheduledExecutorService timedExecutor, long timeout)
  {
    return 
    
      new AbstractDownloadCallableConfig().withExecutor(executor).withDestFile(dstfile).withLatch(latch).withAbortableDownload(download).withDownloadParallel(isDownloadParallel).withTimedExecutor(timedExecutor).withTimeout(timeout);
  }
  
  private boolean isTimeoutEnabled()
  {
    return timeout > 0L;
  }
  
  private void cleanupAfterException()
  {
    for (Future<Long> f : futures) {
      f.cancel(true);
    }
    if (abortableDownload.getState() != Transfer.TransferState.Canceled) {
      setState(Transfer.TransferState.Failed);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.AbstractDownloadCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */