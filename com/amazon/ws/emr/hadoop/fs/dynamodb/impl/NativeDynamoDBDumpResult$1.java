package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import java.util.concurrent.BlockingQueue;

class NativeDynamoDBDumpResult$1
  extends AbstractIterator<Entity>
{
  NativeDynamoDBDumpResult$1(NativeDynamoDBDumpResult this$0, BlockingQueue paramBlockingQueue) {}
  
  protected Entity computeNext()
  {
    try
    {
      entity = (Entity)((Optional)val$queue.take()).orNull();
    }
    catch (InterruptedException e)
    {
      Entity entity;
      throw new RuntimeException(e);
    }
    Entity entity;
    if (entity == null) {
      return (Entity)endOfData();
    }
    return entity;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBDumpResult.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */