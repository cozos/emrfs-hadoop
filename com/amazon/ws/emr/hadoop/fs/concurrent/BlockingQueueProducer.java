package com.amazon.ws.emr.hadoop.fs.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer<T>
  implements Runnable
{
  private BlockingQueue<Optional<T>> queue;
  private Producer<T> producer;
  
  public BlockingQueueProducer(BlockingQueue<Optional<T>> queue, Producer<T> producer)
  {
    this.queue = queue;
    this.producer = producer;
  }
  
  public void run()
  {
    while (producer.canProduce())
    {
      T value = producer.produce();
      try
      {
        queue.put(Optional.of(value));
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.BlockingQueueProducer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */