package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

@SdkInternalApi
public final class PreparedDownloadContext
{
  private final DownloadImpl transfer;
  private final Callable<?> callable;
  private final CountDownLatch latch;
  
  public PreparedDownloadContext(DownloadImpl transfer, Callable<?> callable, CountDownLatch latch)
  {
    this.transfer = transfer;
    this.callable = callable;
    this.latch = latch;
  }
  
  public DownloadImpl getTransfer()
  {
    return transfer;
  }
  
  public Callable<?> getCallable()
  {
    return callable;
  }
  
  public CountDownLatch getLatch()
  {
    return latch;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PreparedDownloadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */