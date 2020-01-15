package com.amazonaws.services.sqs.buffered;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class QueueBuffer$DaemonThreadFactory
  implements ThreadFactory
{
  static AtomicInteger threadCount = new AtomicInteger(0);
  
  public Thread newThread(Runnable r)
  {
    int threadNumber = threadCount.addAndGet(1);
    Thread thread = new Thread(r);
    thread.setDaemon(true);
    thread.setName("SQSQueueBufferWorkerThread-" + threadNumber);
    return thread;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.buffered.QueueBuffer.DaemonThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */