package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import java.util.concurrent.ThreadFactory;

final class TransferManagerUtils$1
  implements ThreadFactory
{
  private int threadCount = 1;
  
  public Thread newThread(Runnable r)
  {
    Thread thread = new Thread(r);
    thread.setName("s3-transfer-manager-worker-" + threadCount++);
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferManagerUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */