package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class TransferManager$1
  implements ThreadFactory
{
  final AtomicInteger threadCount = new AtomicInteger(0);
  
  public Thread newThread(Runnable r)
  {
    int threadNumber = threadCount.incrementAndGet();
    Thread thread = new Thread(r);
    thread.setDaemon(true);
    thread.setName("S3TransferManagerTimedThread-" + threadNumber);
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */