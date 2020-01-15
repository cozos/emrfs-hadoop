package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.BatchGetItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchGetItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import java.util.Map;

@ThreadSafe
public abstract interface BatchGetItemApi
{
  public abstract BatchGetItemOutcome batchGetItem(ReturnConsumedCapacity paramReturnConsumedCapacity, TableKeysAndAttributes... paramVarArgs);
  
  public abstract BatchGetItemOutcome batchGetItem(TableKeysAndAttributes... paramVarArgs);
  
  public abstract BatchGetItemOutcome batchGetItem(BatchGetItemSpec paramBatchGetItemSpec);
  
  public abstract BatchGetItemOutcome batchGetItemUnprocessed(ReturnConsumedCapacity paramReturnConsumedCapacity, Map<String, KeysAndAttributes> paramMap);
  
  public abstract BatchGetItemOutcome batchGetItemUnprocessed(Map<String, KeysAndAttributes> paramMap);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.BatchGetItemApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */