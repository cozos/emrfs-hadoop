package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class QueryPage
  extends Page<Item, QueryOutcome>
{
  private final AmazonDynamoDB client;
  private final QuerySpec spec;
  private final QueryRequest request;
  private final int index;
  private final Map<String, AttributeValue> lastEvaluatedKey;
  
  public QueryPage(AmazonDynamoDB client, QuerySpec spec, QueryRequest request, int index, QueryOutcome outcome)
  {
    super(Collections.unmodifiableList(
      InternalUtils.toItemList(outcome.getQueryResult().getItems())), outcome);
    
    this.client = client;
    this.spec = spec;
    this.request = request;
    this.index = index;
    
    Integer max = spec.getMaxResultSize();
    QueryResult result = outcome.getQueryResult();
    List<?> ilist = result.getItems();
    int size = ilist == null ? 0 : ilist.size();
    if ((max != null) && (index + size > max.intValue())) {
      lastEvaluatedKey = null;
    } else {
      lastEvaluatedKey = result.getLastEvaluatedKey();
    }
  }
  
  public boolean hasNextPage()
  {
    if (lastEvaluatedKey == null) {
      return false;
    }
    Integer max = spec.getMaxResultSize();
    if (max == null) {
      return true;
    }
    return nextRequestLimit(max.intValue()) > 0;
  }
  
  private int nextRequestLimit(int max)
  {
    int nextIndex = index + size();
    return InternalUtils.minimum(
      Integer.valueOf(max - nextIndex), spec
      .getMaxPageSize()).intValue();
  }
  
  public Page<Item, QueryOutcome> nextPage()
  {
    if (lastEvaluatedKey == null) {
      throw new NoSuchElementException("No more pages");
    }
    Integer max = spec.getMaxResultSize();
    if (max != null)
    {
      int nextLimit = nextRequestLimit(max.intValue());
      if (nextLimit == 0) {
        throw new NoSuchElementException("No more pages");
      }
      request.setLimit(Integer.valueOf(nextLimit));
    }
    request.setExclusiveStartKey(lastEvaluatedKey);
    QueryResult result = client.query(request);
    int nextIndex = index + size();
    return new QueryPage(client, spec, request, nextIndex, new QueryOutcome(result));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.QueryPage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */