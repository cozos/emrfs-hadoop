package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.concurrent.Consumer;
import com.amazon.ws.emr.hadoop.fs.concurrent.ProducerConsumerExecutor;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.List;

class NativeDynamoDBDumpResult$2
  implements Runnable
{
  NativeDynamoDBDumpResult$2(NativeDynamoDBDumpResult this$0, ProducerConsumerExecutor paramProducerConsumerExecutor, List paramList, Consumer paramConsumer) {}
  
  public void run()
  {
    val$executor.execute(val$producers, Lists.newArrayList(new Consumer[] { val$consumer }));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBDumpResult.2
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */