package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.InternalUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.List;

public class QueryOutcome
{
  private final QueryResult result;
  
  public QueryOutcome(QueryResult result)
  {
    if (result == null) {
      throw new IllegalArgumentException();
    }
    this.result = result;
  }
  
  public List<Item> getItems()
  {
    return InternalUtils.toItemList(result.getItems());
  }
  
  public QueryResult getQueryResult()
  {
    return result;
  }
  
  public String toString()
  {
    return String.valueOf(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryOutcome
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */