package com.amazon.ws.emr.hadoop.fs.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class ProducerConsumerExecutor
{
  public synchronized <T> void execute(Collection<Producer<T>> producers, Collection<Consumer<T>> consumers)
  {
    doExecute(producers, consumers);
  }
  
  private <T> void doExecute(Collection<Producer<T>> producers, Collection<Consumer<T>> consumers)
  {
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat(String.format("Executor:%d:thread:%%d", new Object[] { Integer.valueOf(System.identityHashCode(this)) })).build();
    ExecutorService pool = Executors.newFixedThreadPool(producers.size() + consumers.size(), threadFactory);
    try
    {
      BlockingQueue<T> queue = new ArrayBlockingQueue(1000);
      List<Future> producerFutures = new ArrayList();
      for (Iterator localIterator = producers.iterator(); localIterator.hasNext();)
      {
        p = (Producer)localIterator.next();
        BlockingQueueProducer<T> blockingQueueProducer = new BlockingQueueProducer(queue, p);
        producerFutures.add(pool.submit(blockingQueueProducer));
      }
      Producer<T> p;
      Object consumerFutures = new ArrayList();
      for (Consumer<T> c : consumers)
      {
        BlockingQueueConsumer<T> blockingQueueConsumer = new BlockingQueueConsumer(queue, c);
        ((List)consumerFutures).add(pool.submit(blockingQueueConsumer));
      }
      waitForExecutionToFinish(queue, producerFutures, (List)consumerFutures);
    }
    finally
    {
      pool.shutdownNow();
    }
  }
  
  private void waitForExecutionToFinish(BlockingQueue queue, List<Future> producerFutures, List<Future> consumerFutures)
  {
    try
    {
      for (Future f : producerFutures) {
        f.get();
      }
      for (Future f : consumerFutures) {
        queue.put(Optional.absent());
      }
      for (Future f : consumerFutures) {
        f.get();
      }
    }
    catch (InterruptedException|ExecutionException e)
    {
      cancelAll(producerFutures);
      cancelAll(consumerFutures);
      throw new RuntimeException(e);
    }
  }
  
  private void cancelAll(Collection<Future> futures)
  {
    for (Future f : futures) {
      f.cancel(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.concurrent.ProducerConsumerExecutor
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */