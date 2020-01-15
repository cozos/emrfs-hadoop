package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.ScanApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import java.util.Collection;
import java.util.Map;

public class ScanImpl
  extends AbstractImpl
  implements ScanApi
{
  public ScanImpl(AmazonDynamoDB client, Table table)
  {
    super(client, table);
  }
  
  public ItemCollection<ScanOutcome> scan(ScanFilter... scanFilters)
  {
    return doScan(new ScanSpec()
      .withScanFilters(scanFilters));
  }
  
  public ItemCollection<ScanOutcome> scan(String filterExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return doScan(new ScanSpec()
      .withFilterExpression(filterExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public ItemCollection<ScanOutcome> scan(String filterExpression, String projectionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return doScan(new ScanSpec()
      .withFilterExpression(filterExpression)
      .withProjectionExpression(projectionExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public ItemCollection<ScanOutcome> scan(ScanSpec spec)
  {
    return doScan(spec);
  }
  
  protected ItemCollection<ScanOutcome> doScan(ScanSpec spec)
  {
    String tableName = getTable().getTableName();
    ScanRequest req = ((ScanRequest)spec.getRequest()).withTableName(tableName);
    
    Collection<KeyAttribute> startKey = spec.getExclusiveStartKey();
    if (startKey != null) {
      req.setExclusiveStartKey(InternalUtils.toAttributeValueMap(startKey));
    }
    Collection<ScanFilter> filters = spec.getScanFilters();
    if (filters != null) {
      req.setScanFilter(InternalUtils.toAttributeConditionMap(filters));
    }
    Map<String, AttributeValue> attrValMap = InternalUtils.fromSimpleMap(spec.getValueMap());
    
    req.withExpressionAttributeNames(spec.getNameMap())
      .withExpressionAttributeValues(attrValMap);
    
    return new ScanCollection(getClient(), spec);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.ScanImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */