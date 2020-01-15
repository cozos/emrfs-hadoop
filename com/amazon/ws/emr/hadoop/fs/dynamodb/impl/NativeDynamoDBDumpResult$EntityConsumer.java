package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.concurrent.Consumer;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import java.util.concurrent.BlockingQueue;

class NativeDynamoDBDumpResult$EntityConsumer
  extends Consumer<Entity>
{
  private BlockingQueue<Optional<Entity>> queue;
  
  public NativeDynamoDBDumpResult$EntityConsumer(BlockingQueue<Optional<Entity>> arg1)
  {
    this.queue = queue;
  }
  
  public void beforeConsumption() {}
  
  public void consume(Entity value)
  {
    try
    {
      queue.put(Optional.of(value));
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public void afterConsumption()
  {
    try
    {
      Optional<Entity> absent = Optional.absent();
      queue.put(absent);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBDumpResult.EntityConsumer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */