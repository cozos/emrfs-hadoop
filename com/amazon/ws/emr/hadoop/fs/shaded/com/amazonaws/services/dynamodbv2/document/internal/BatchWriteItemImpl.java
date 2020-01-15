package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.BatchWriteItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.TableWriteItems;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.BatchWriteItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.BatchWriteItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BatchWriteItemImpl
  implements BatchWriteItemApi
{
  private final AmazonDynamoDB client;
  
  public BatchWriteItemImpl(AmazonDynamoDB client)
  {
    this.client = client;
  }
  
  public BatchWriteItemOutcome batchWriteItem(TableWriteItems... tableWriteItems)
  {
    return doBatchWriteItem(new BatchWriteItemSpec()
      .withTableWriteItems(tableWriteItems));
  }
  
  public BatchWriteItemOutcome batchWriteItem(BatchWriteItemSpec spec)
  {
    return doBatchWriteItem(spec);
  }
  
  public BatchWriteItemOutcome batchWriteItemUnprocessed(Map<String, List<WriteRequest>> unprocessedItems)
  {
    return doBatchWriteItem(new BatchWriteItemSpec()
      .withUnprocessedItems(unprocessedItems));
  }
  
  private BatchWriteItemOutcome doBatchWriteItem(BatchWriteItemSpec spec)
  {
    Collection<TableWriteItems> tableWriteItemsCol = spec.getTableWriteItems();
    
    Map<String, List<WriteRequest>> requestItems = spec.getUnprocessedItems();
    if ((requestItems == null) || (requestItems.size() == 0)) {
      requestItems = new LinkedHashMap();
    } else {
      requestItems = new LinkedHashMap(requestItems);
    }
    if (tableWriteItemsCol != null) {
      for (TableWriteItems tableWriteItems : tableWriteItemsCol)
      {
        Collection<Item> itemsToPut = tableWriteItems.getItemsToPut();
        
        List<PrimaryKey> pksToDelete = tableWriteItems.getPrimaryKeysToDelete();
        
        int numPut = itemsToPut == null ? 0 : itemsToPut.size();
        int numDel = pksToDelete == null ? 0 : pksToDelete.size();
        List<WriteRequest> writeRequests = new ArrayList(numPut + numDel);
        if (itemsToPut != null) {
          for (Item item : itemsToPut) {
            writeRequests.add(new WriteRequest()
              .withPutRequest(new PutRequest()
              .withItem(InternalUtils.toAttributeValues(item))));
          }
        }
        if (pksToDelete != null) {
          for (PrimaryKey pkToDelete : pksToDelete) {
            writeRequests.add(new WriteRequest()
              .withDeleteRequest(new DeleteRequest()
              .withKey(InternalUtils.toAttributeValueMap(pkToDelete))));
          }
        }
        requestItems.put(tableWriteItems.getTableName(), writeRequests);
      }
    }
    BatchWriteItemRequest req = ((BatchWriteItemRequest)spec.getRequest()).withRequestItems(requestItems);
    BatchWriteItemResult result = client.batchWriteItem(req);
    return new BatchWriteItemOutcome(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.BatchWriteItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */