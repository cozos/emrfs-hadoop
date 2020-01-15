package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.concurrent.Producer;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NativeDynamoDBDumpResult$EntityProducer
  extends Producer<Entity>
{
  private ScanRequest scanRequest;
  private AmazonDynamoDB dynamoDB;
  private boolean moreToScan = true;
  private Iterator<Entity> iterator;
  
  public NativeDynamoDBDumpResult$EntityProducer(NativeDynamoDBDumpResult this$0, AmazonDynamoDB dynamoDB, ScanRequest scanRequest)
  {
    this.dynamoDB = dynamoDB;
    this.scanRequest = scanRequest;
  }
  
  protected boolean canProduce()
  {
    if ((iterator == null) || (!iterator.hasNext()))
    {
      List<Entity> batch = getNextBatch();
      if ((batch == null) || (batch.isEmpty())) {
        return false;
      }
      iterator = batch.iterator();
    }
    return true;
  }
  
  protected Entity produce()
  {
    return (Entity)iterator.next();
  }
  
  private List<Entity> getNextBatch()
  {
    if (!moreToScan) {
      return null;
    }
    List<Entity> entities;
    do
    {
      NativeDynamoDBDumpResult.access$000(this$0).beforeRead();
      ScanResult scanResult = dynamoDB.scan(scanRequest);
      NativeDynamoDBDumpResult.access$000(this$0).afterRead(scanResult.getConsumedCapacity());
      if (scanResult.getLastEvaluatedKey() == null) {
        moreToScan = false;
      } else {
        scanRequest.setExclusiveStartKey(scanResult.getLastEvaluatedKey());
      }
      entities = new ArrayList(scanResult.getItems().size());
      for (Map<String, AttributeValue> item : scanResult.getItems()) {
        if ((!((AttributeValue)item.get("hashKey")).getS().equals("MultiKeyStoreTag")) || 
          (!((AttributeValue)item.get("rangeKey")).getS().equals("TableRole"))) {
          entities.add(NativeDynamoDBEntityStore.itemToEntity(item));
        }
      }
    } while ((moreToScan) && (entities.isEmpty()));
    return entities;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBDumpResult.EntityProducer
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */