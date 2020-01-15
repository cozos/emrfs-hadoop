package com.amazon.ws.emr.hadoop.fs.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer<T>
  implements Runnable
{
  private BlockingQueue<Optional<T>> queue;
  private Consumer<T> consumer;
  private volatile boolean keepRunning = true;
  
  public BlockingQueueConsumer(BlockingQueue<Optional<T>> queue, Consumer<T> consumer)
  {
    this.queue = queue;
    this.consumer = consumer;
  }
  
  public void run()
  {
    consumer.beforeConsumption();
    while (keepRunning)
    {
      try
      {
        value = (Optional)queue.take();
      }
      catch (InterruptedException e)
      {
        Optional<T> value;
        throw new RuntimeException(e);
      }
      Optional<T> value;
      if (value.isPresent()) {
        consumer.consume(value.get());
      } else {
        keepRunning = false;
      }
    }
    consumer.afterConsumption();
  }
  
  public void stop()
  {
    keepRunning = false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.BlockingQueueConsumer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */