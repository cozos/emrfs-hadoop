package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.LinkedHashMap;
import java.util.Map;

class QueryCollection
  extends ItemCollection<QueryOutcome>
{
  private final AmazonDynamoDB client;
  private final QuerySpec spec;
  private final Map<String, AttributeValue> startKey;
  
  public QueryCollection(AmazonDynamoDB client, QuerySpec spec)
  {
    this.client = client;
    this.spec = spec;
    
    Map<String, AttributeValue> startKey = ((QueryRequest)spec.getRequest()).getExclusiveStartKey();
    this.startKey = (startKey == null ? null : new LinkedHashMap(startKey));
  }
  
  public Page<Item, QueryOutcome> firstPage()
  {
    QueryRequest request = (QueryRequest)spec.getRequest();
    request.setExclusiveStartKey(startKey);
    request.setLimit(InternalUtils.minimum(spec
      .getMaxResultSize(), spec
      .getMaxPageSize()));
    QueryResult result = client.query(request);
    QueryOutcome outcome = new QueryOutcome(result);
    setLastLowLevelResult(outcome);
    return new QueryPage(client, spec, request, 0, outcome);
  }
  
  public Integer getMaxResultSize()
  {
    return spec.getMaxResultSize();
  }
  
  protected void setLastLowLevelResult(QueryOutcome lowLevelResult)
  {
    super.setLastLowLevelResult(lowLevelResult);
    QueryResult result = lowLevelResult.getQueryResult();
    accumulateStats(result.getConsumedCapacity(), result.getCount(), result
      .getScannedCount());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.QueryCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */