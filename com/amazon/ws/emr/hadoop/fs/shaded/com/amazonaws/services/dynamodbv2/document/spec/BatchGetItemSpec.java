package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BatchGetItemSpec
  extends AbstractSpec<BatchGetItemRequest>
{
  private Collection<TableKeysAndAttributes> tableKeyAndAttributes;
  private Map<String, KeysAndAttributes> unprocessedKeys;
  
  public BatchGetItemSpec()
  {
    super(new BatchGetItemRequest());
  }
  
  public Collection<TableKeysAndAttributes> getTableKeysAndAttributes()
  {
    return tableKeyAndAttributes;
  }
  
  public BatchGetItemSpec withTableKeyAndAttributes(TableKeysAndAttributes... tableKeyAndAttributes)
  {
    if (tableKeyAndAttributes == null)
    {
      this.tableKeyAndAttributes = null;
    }
    else
    {
      Set<String> names = new LinkedHashSet();
      for (TableKeysAndAttributes e : tableKeyAndAttributes) {
        names.add(e.getTableName());
      }
      if (names.size() != tableKeyAndAttributes.length) {
        throw new IllegalArgumentException("table names must not duplicate in the list of TableKeysAndAttributes");
      }
      this.tableKeyAndAttributes = Arrays.asList(tableKeyAndAttributes);
    }
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((BatchGetItemRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public BatchGetItemSpec withReturnConsumedCapacity(ReturnConsumedCapacity capacity)
  {
    ((BatchGetItemRequest)getRequest()).withReturnConsumedCapacity(capacity);
    return this;
  }
  
  public BatchGetItemSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public BatchGetItemSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  public Map<String, KeysAndAttributes> getUnprocessedKeys()
  {
    return unprocessedKeys;
  }
  
  public BatchGetItemSpec withUnprocessedKeys(Map<String, KeysAndAttributes> unprocessedKeys)
  {
    this.unprocessedKeys = Collections.unmodifiableMap(new LinkedHashMap(unprocessedKeys));
    
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchGetItemSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */