package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;

public class ListTablesSpec
  extends AbstractCollectionSpec<ListTablesRequest>
{
  public ListTablesSpec()
  {
    super(new ListTablesRequest());
  }
  
  public String getExclusiveStartTableName()
  {
    return ((ListTablesRequest)getRequest()).getExclusiveStartTableName();
  }
  
  public ListTablesSpec withExclusiveStartTableName(String exclusiveStartTableName)
  {
    ((ListTablesRequest)getRequest()).setExclusiveStartTableName(exclusiveStartTableName);
    return this;
  }
  
  public ListTablesSpec withMaxResultSize(Integer maxResultSize)
  {
    setMaxResultSize(maxResultSize);
    return this;
  }
  
  public ListTablesSpec withMaxResultSize(int maxResultSize)
  {
    setMaxResultSize(maxResultSize);
    return this;
  }
  
  public ListTablesSpec withMaxPageSize(Integer maxPageSize)
  {
    setMaxPageSize(maxPageSize);
    return this;
  }
  
  public ListTablesSpec withMaxPageSize(int maxPageSize)
  {
    setMaxPageSize(Integer.valueOf(maxPageSize));
    return this;
  }
  
  public ListTablesSpec withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    return this;
  }
  
  public ListTablesSpec withRequestMetricCollector(RequestMetricCollector requestMetricCollector)
  {
    setRequestMetricCollector(requestMetricCollector);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ListTablesSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */