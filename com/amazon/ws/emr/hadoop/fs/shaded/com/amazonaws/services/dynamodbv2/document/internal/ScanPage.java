package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class ScanPage
  extends Page<Item, ScanOutcome>
{
  private final AmazonDynamoDB client;
  private final ScanSpec spec;
  private final ScanRequest request;
  private final int index;
  private final Map<String, AttributeValue> lastEvaluatedKey;
  
  public ScanPage(AmazonDynamoDB client, ScanSpec spec, ScanRequest request, int index, ScanOutcome outcome)
  {
    super(Collections.unmodifiableList(
      InternalUtils.toItemList(outcome.getScanResult().getItems())), outcome);
    
    this.client = client;
    this.spec = spec;
    this.request = request;
    this.index = index;
    
    Integer max = spec.getMaxResultSize();
    ScanResult result = outcome.getScanResult();
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
  
  public Page<Item, ScanOutcome> nextPage()
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
    
    ScanResult result = client.scan(request);
    int nextIndex = index + size();
    return new ScanPage(client, spec, request, nextIndex, new ScanOutcome(result));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ScanPage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */