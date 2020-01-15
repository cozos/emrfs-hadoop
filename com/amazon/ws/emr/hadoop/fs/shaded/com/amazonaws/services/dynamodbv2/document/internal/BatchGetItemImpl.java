package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.BatchGetItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableKeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.BatchGetItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchGetItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BatchGetItemImpl
  implements BatchGetItemApi
{
  private final AmazonDynamoDB client;
  
  public BatchGetItemImpl(AmazonDynamoDB client)
  {
    this.client = client;
  }
  
  public BatchGetItemOutcome batchGetItem(ReturnConsumedCapacity returnConsumedCapacity, TableKeysAndAttributes... tableKeysAndAttributes)
  {
    return doBatchGetItem(new BatchGetItemSpec()
      .withReturnConsumedCapacity(returnConsumedCapacity)
      .withTableKeyAndAttributes(tableKeysAndAttributes));
  }
  
  public BatchGetItemOutcome batchGetItem(TableKeysAndAttributes... tableKeysAndAttributes)
  {
    return doBatchGetItem(new BatchGetItemSpec()
      .withTableKeyAndAttributes(tableKeysAndAttributes));
  }
  
  public BatchGetItemOutcome batchGetItem(BatchGetItemSpec spec)
  {
    return doBatchGetItem(spec);
  }
  
  private BatchGetItemOutcome doBatchGetItem(BatchGetItemSpec spec)
  {
    Collection<TableKeysAndAttributes> tableKeysAndAttributesCol = spec.getTableKeysAndAttributes();
    
    Map<String, KeysAndAttributes> requestItems = spec.getUnprocessedKeys();
    if ((requestItems == null) || (requestItems.size() == 0)) {
      requestItems = new LinkedHashMap();
    } else {
      requestItems = new LinkedHashMap(requestItems);
    }
    if (tableKeysAndAttributesCol != null) {
      for (TableKeysAndAttributes tableKeysAndAttributes : tableKeysAndAttributesCol)
      {
        Set<String> attrNames = tableKeysAndAttributes.getAttributeNames();
        
        List<PrimaryKey> pks = tableKeysAndAttributes.getPrimaryKeys();
        List<Map<String, AttributeValue>> keys = new ArrayList(pks.size());
        for (PrimaryKey pk : pks) {
          keys.add(InternalUtils.toAttributeValueMap(pk));
        }
        KeysAndAttributes keysAndAttrs = new KeysAndAttributes().withAttributesToGet(attrNames).withConsistentRead(Boolean.valueOf(tableKeysAndAttributes.isConsistentRead())).withKeys(keys).withProjectionExpression(tableKeysAndAttributes.getProjectionExpression()).withExpressionAttributeNames(tableKeysAndAttributes.getNameMap());
        
        requestItems.put(tableKeysAndAttributes.getTableName(), keysAndAttrs);
      }
    }
    BatchGetItemRequest req = ((BatchGetItemRequest)spec.getRequest()).withRequestItems(requestItems);
    BatchGetItemResult result = client.batchGetItem(req);
    return new BatchGetItemOutcome(result);
  }
  
  public BatchGetItemOutcome batchGetItemUnprocessed(ReturnConsumedCapacity returnConsumedCapacity, Map<String, KeysAndAttributes> unprocessedKeys)
  {
    return doBatchGetItem(new BatchGetItemSpec()
      .withReturnConsumedCapacity(returnConsumedCapacity)
      .withUnprocessedKeys(unprocessedKeys));
  }
  
  public BatchGetItemOutcome batchGetItemUnprocessed(Map<String, KeysAndAttributes> unprocessedKeys)
  {
    return doBatchGetItem(new BatchGetItemSpec()
      .withUnprocessedKeys(unprocessedKeys));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.BatchGetItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */