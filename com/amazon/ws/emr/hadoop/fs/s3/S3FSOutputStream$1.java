package com.amazon.ws.emr.hadoop.fs.s3;

import java.util.concurrent.ThreadFactory;

class S3FSOutputStream$1
  implements ThreadFactory
{
  private int threadCount = 1;
  
  S3FSOutputStream$1(S3FSOutputStream this$0) {}
  
  public Thread newThread(Runnable r)
  {
    Thread thread = new Thread(r);
    thread.setName("progress-reporter" + threadCount++);
    thread.setDaemon(true);
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.S3FSOutputStream.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */