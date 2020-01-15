package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableWriteItems;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BatchWriteItemSpec
  extends AbstractSpec<BatchWriteItemRequest>
{
  private Collection<TableWriteItems> tableWriteItems;
  private Map<String, List<WriteRequest>> unprocessedItems;
  
  public BatchWriteItemSpec()
  {
    super(new BatchWriteItemRequest());
  }
  
  public Collection<TableWriteItems> getTableWriteItems()
  {
    return tableWriteItems;
  }
  
  public BatchWriteItemSpec withTableWriteItems(TableWriteItems... tableWriteItems)
  {
    if (tableWriteItems == null)
    {
      this.tableWriteItems = null;
    }
    else
    {
      Set<String> names = new LinkedHashSet();
      for (TableWriteItems e : tableWriteItems) {
        names.add(e.getTableName());
      }
      if (names.size() != tableWriteItems.length) {
        throw new IllegalArgumentException("table names must not duplicate in the list of TableWriteItems");
      }
      this.tableWriteItems = Arrays.asList(tableWriteItems);
    }
    return this;
  }
  
  public String getReturnConsumedCapacity()
  {
    return ((BatchWriteItemRequest)getRequest()).getReturnConsumedCapacity();
  }
  
  public BatchWriteItemSpec withReturnConsumedCapacity(ReturnConsumedCapacity capacity)
  {
    ((BatchWriteItemRequest)getRequest()).withReturnConsumedCapacity(capacity);
    return this;
  }
  
  public BatchWriteItemSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public BatchWriteItemSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
  
  public Map<String, List<WriteRequest>> getUnprocessedItems()
  {
    return unprocessedItems;
  }
  
  public BatchWriteItemSpec withUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems)
  {
    this.unprocessedItems = Collections.unmodifiableMap(new LinkedHashMap(unprocessedItems));
    
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchWriteItemSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */