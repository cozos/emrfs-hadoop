package com.amazon.ws.emr.hadoop.fs.guice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BlockFastProducerPolicy
  implements RejectedExecutionHandler
{
  private static final Logger logger = LoggerFactory.getLogger(BlockFastProducerPolicy.class);
  private transient long rejectedTaskIdx = 0L;
  private static final int FREQUECNY_OF_LOG = 100;
  
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor)
  {
    if (executor.isShutdown()) {
      throw new RejectedExecutionException("ThreadPoolExecutor already shutdown");
    }
    rejectedTaskIdx += 1L;
    if (rejectedTaskIdx % 100L == 1L) {
      logger.info("Waiting on the blocking worker queue");
    }
    try
    {
      executor.getQueue().put(r);
    }
    catch (InterruptedException e)
    {
      throw new RejectedExecutionException("Thread was interrupted while waiting for space to be available in the threadpool for task rtask-" + rejectedTaskIdx, e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.BlockFastProducerPolicy
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */