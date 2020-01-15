package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Page;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.LinkedHashMap;
import java.util.Map;

class ScanCollection
  extends ItemCollection<ScanOutcome>
{
  private final AmazonDynamoDB client;
  private final ScanSpec spec;
  private final Map<String, AttributeValue> startKey;
  
  public ScanCollection(AmazonDynamoDB client, ScanSpec spec)
  {
    this.client = client;
    this.spec = spec;
    
    Map<String, AttributeValue> startKey = ((ScanRequest)spec.getRequest()).getExclusiveStartKey();
    this.startKey = (startKey == null ? null : new LinkedHashMap(startKey));
  }
  
  public Page<Item, ScanOutcome> firstPage()
  {
    ScanRequest request = (ScanRequest)spec.getRequest();
    request.setExclusiveStartKey(startKey);
    
    request.setLimit(InternalUtils.minimum(spec
      .getMaxResultSize(), spec
      .getMaxPageSize()));
    
    ScanResult result = client.scan(request);
    ScanOutcome outcome = new ScanOutcome(result);
    setLastLowLevelResult(outcome);
    return new ScanPage(client, spec, request, 0, outcome);
  }
  
  public Integer getMaxResultSize()
  {
    return spec.getMaxResultSize();
  }
  
  protected void setLastLowLevelResult(ScanOutcome lowLevelResult)
  {
    super.setLastLowLevelResult(lowLevelResult);
    ScanResult result = lowLevelResult.getScanResult();
    accumulateStats(result.getConsumedCapacity(), result.getCount(), result
      .getScannedCount());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ScanCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */