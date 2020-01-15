package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.concurrent.Consumer;
import com.amazon.ws.emr.hadoop.fs.concurrent.Producer;
import com.amazon.ws.emr.hadoop.fs.concurrent.ProducerConsumerExecutor;
import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class NativeDynamoDBDumpResult
  implements Iterable<Entity>
{
  private static final int PRODUCER_COUNT = 5;
  private final ScanRequest originalScanRequest;
  private final NativeDynamoDBRateLimiter rateLimiter;
  private final AmazonDynamoDB dynamoDB;
  
  public NativeDynamoDBDumpResult(AmazonDynamoDB dynamoDB, NativeDynamoDBRateLimiter rateLimiter, ScanRequest scanRequest)
  {
    originalScanRequest = scanRequest;
    this.rateLimiter = rateLimiter;
    this.dynamoDB = dynamoDB;
  }
  
  public Iterator<Entity> iterator()
  {
    final BlockingQueue<Optional<Entity>> queue = new ArrayBlockingQueue(1000);
    Iterator<Entity> iterator = new AbstractIterator()
    {
      protected Entity computeNext()
      {
        try
        {
          entity = (Entity)((Optional)queue.take()).orNull();
        }
        catch (InterruptedException e)
        {
          Entity entity;
          throw new RuntimeException(e);
        }
        Entity entity;
        if (entity == null) {
          return (Entity)endOfData();
        }
        return entity;
      }
    };
    final ProducerConsumerExecutor executor = new ProducerConsumerExecutor();
    final Consumer<Entity> consumer = new EntityConsumer(queue);
    final List<Producer<Entity>> producers = new ArrayList();
    for (int i = 0; i < 5; i++)
    {
      ScanRequest scanRequest = new ScanRequest().withTableName(originalScanRequest.getTableName()).withLimit(originalScanRequest.getLimit()).withExclusiveStartKey(originalScanRequest.getExclusiveStartKey()).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL).withScanFilter(originalScanRequest.getScanFilter()).withSegment(Integer.valueOf(i)).withTotalSegments(Integer.valueOf(5));
      producers.add(new EntityProducer(dynamoDB, scanRequest));
    }
    Thread executionThread = new Thread(new Runnable()
    {
      public void run()
      {
        executor.execute(producers, Lists.newArrayList(new Consumer[] { consumer }));
      }
    });
    executionThread.setDaemon(true);
    executionThread.setName("NativeDynamoDBDumpResult|" + Integer.toString(System.identityHashCode(iterator)));
    executionThread.start();
    return iterator;
  }
  
  public class EntityProducer
    extends Producer<Entity>
  {
    private ScanRequest scanRequest;
    private AmazonDynamoDB dynamoDB;
    private boolean moreToScan = true;
    private Iterator<Entity> iterator;
    
    public EntityProducer(AmazonDynamoDB dynamoDB, ScanRequest scanRequest)
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
        rateLimiter.beforeRead();
        ScanResult scanResult = dynamoDB.scan(scanRequest);
        rateLimiter.afterRead(scanResult.getConsumedCapacity());
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
  
  private class EntityConsumer
    extends Consumer<Entity>
  {
    private BlockingQueue<Optional<Entity>> queue;
    
    public EntityConsumer()
    {
      this.queue = queue;
    }
    
    public void beforeConsumption() {}
    
    public void consume(Entity value)
    {
      try
      {
        queue.put(Optional.of(value));
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    
    public void afterConsumption()
    {
      try
      {
        Optional<Entity> absent = Optional.absent();
        queue.put(absent);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBDumpResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */