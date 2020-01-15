package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableWriteItems;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchWriteItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.List;
import java.util.Map;

@ThreadSafe
public abstract interface BatchWriteItemApi
{
  public abstract BatchWriteItemOutcome batchWriteItem(TableWriteItems... paramVarArgs);
  
  public abstract BatchWriteItemOutcome batchWriteItem(BatchWriteItemSpec paramBatchWriteItemSpec);
  
  public abstract BatchWriteItemOutcome batchWriteItemUnprocessed(Map<String, List<WriteRequest>> paramMap);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.BatchWriteItemApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */