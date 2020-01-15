package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import java.util.Iterator;
import java.util.List;

class NativeDynamoDBListResult$1
  extends AbstractIterator<Entity>
{
  List<Entity> batchResult = null;
  Iterator<Entity> iterator = null;
  
  NativeDynamoDBListResult$1(NativeDynamoDBListResult this$0) {}
  
  protected Entity computeNext()
  {
    for (;;)
    {
      if ((iterator != null) && (iterator.hasNext())) {
        return (Entity)iterator.next();
      }
      batchResult = NativeDynamoDBListResult.access$000(this$0);
      if ((batchResult == null) || (batchResult.size() == 0)) {
        return (Entity)endOfData();
      }
      iterator = batchResult.iterator();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBListResult.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */