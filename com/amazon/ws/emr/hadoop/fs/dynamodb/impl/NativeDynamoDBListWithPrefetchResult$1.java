package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;

class NativeDynamoDBListWithPrefetchResult$1
  extends AbstractIterator<Entity>
{
  QueryResult queryResult = null;
  Iterator<Map<String, AttributeValue>> iterator = null;
  boolean usingBackwardResults = false;
  
  NativeDynamoDBListWithPrefetchResult$1(NativeDynamoDBListWithPrefetchResult this$0) {}
  
  protected Entity computeNext()
  {
    if ((NativeDynamoDBListWithPrefetchResult.access$500(this$0) != null) && (NativeDynamoDBListWithPrefetchResult.access$500(this$0).equals(NativeDynamoDBListWithPrefetchResult.access$300(this$0)))) {
      return (Entity)endOfData();
    }
    for (;;)
    {
      NativeDynamoDBListWithPrefetchResult.access$600(this$0);
      if ((iterator != null) && (iterator.hasNext())) {
        break;
      }
      if ((NativeDynamoDBListWithPrefetchResult.access$700(this$0).isEmpty()) && (NativeDynamoDBListWithPrefetchResult.access$800(this$0).isEmpty()))
      {
        if ((NativeDynamoDBListWithPrefetchResult.access$900(this$0).get()) && (NativeDynamoDBListWithPrefetchResult.access$1000(this$0).get())) {
          return (Entity)endOfData();
        }
      }
      else if (!NativeDynamoDBListWithPrefetchResult.access$700(this$0).isEmpty())
      {
        try
        {
          queryResult = ((QueryResult)NativeDynamoDBListWithPrefetchResult.access$700(this$0).take());
          List<Map<String, AttributeValue>> items = queryResult.getItems();
          NativeDynamoDBListWithPrefetchResult.access$200().debug("Getting items from forwardQueryResults: {} - {}", 
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)items.get(0)), 
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)items.get(items.size() - 1)));
          iterator = queryResult.getItems().iterator();
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
      }
      else if ((NativeDynamoDBListWithPrefetchResult.access$700(this$0).isEmpty()) && (!NativeDynamoDBListWithPrefetchResult.access$800(this$0).isEmpty()) && 
        (NativeDynamoDBListWithPrefetchResult.access$900(this$0).get()) && (NativeDynamoDBListWithPrefetchResult.access$700(this$0).isEmpty()) && 
        
        (NativeDynamoDBListWithPrefetchResult.access$1000(this$0).get()))
      {
        if (NativeDynamoDBListWithPrefetchResult.access$500(this$0) == null)
        {
          NativeDynamoDBListWithPrefetchResult.access$502(this$0, "");
          usingBackwardResults = true;
        }
        QueryResult result = null;
        if (!usingBackwardResults)
        {
          String lowerRangeKey = "";
          String upperRangeKey = "";
          while (!NativeDynamoDBListWithPrefetchResult.access$800(this$0).isEmpty())
          {
            try
            {
              result = (QueryResult)NativeDynamoDBListWithPrefetchResult.access$800(this$0).takeLast();
            }
            catch (InterruptedException e)
            {
              throw new RuntimeException(e);
            }
            lowerRangeKey = NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)result.getItems().get(result.getItems().size() - 1));
            upperRangeKey = NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)result.getItems().get(0));
            if ((NativeDynamoDBListWithPrefetchResult.access$500(this$0).compareTo(lowerRangeKey) >= 0) && (NativeDynamoDBListWithPrefetchResult.access$500(this$0).compareTo(upperRangeKey) < 0)) {
              break;
            }
            result = null;
          }
          if (result == null)
          {
            NativeDynamoDBListWithPrefetchResult.access$200().info("Cannot find the next item {} in backwardQueryResults", NativeDynamoDBListWithPrefetchResult.access$500(this$0));
            return (Entity)endOfData();
          }
          iterator = Lists.reverse(result.getItems()).iterator();
          while (iterator.hasNext()) {
            if (NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)iterator.next()).equals(NativeDynamoDBListWithPrefetchResult.access$500(this$0)))
            {
              NativeDynamoDBListWithPrefetchResult.access$200().debug("Last range key from forwardQueryResults: {}", NativeDynamoDBListWithPrefetchResult.access$500(this$0));
              NativeDynamoDBListWithPrefetchResult.access$200().debug("Start getting items from backwardQueryResults: {} - {}", lowerRangeKey, upperRangeKey);
              usingBackwardResults = true;
            }
          }
        }
        else
        {
          while (!NativeDynamoDBListWithPrefetchResult.access$800(this$0).isEmpty())
          {
            try
            {
              result = (QueryResult)NativeDynamoDBListWithPrefetchResult.access$800(this$0).takeLast();
            }
            catch (InterruptedException e)
            {
              throw new RuntimeException(e);
            }
            String lowerRangeKey = NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)result.getItems().get(result.getItems().size() - 1));
            if (lowerRangeKey.compareTo(NativeDynamoDBListWithPrefetchResult.access$500(this$0)) >= 0) {
              break;
            }
            result = null;
          }
          if (result == null) {
            return (Entity)endOfData();
          }
          NativeDynamoDBListWithPrefetchResult.access$200().debug("Getting items from backwardQueryResults: {} - {}", 
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)result.getItems().get(result.getItems().size() - 1)), 
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)result.getItems().get(0)));
          iterator = Lists.reverse(result.getItems()).iterator();
        }
      }
    }
    Map<String, AttributeValue> item = (Map)iterator.next();
    String hashKey = ((AttributeValue)item.get("hashKey")).getS();
    String rangeKey = ((AttributeValue)item.get("rangeKey")).getS();
    Long lastModified = Long.valueOf(Long.parseLong(((AttributeValue)item.get("lastModified")).getN()));
    byte[] payload = ((AttributeValue)item.get("payload")).getB().array();
    Long deletionTTL = DynamoDBUtils.getLongFromItemIfExists((AttributeValue)item.get("deletionTTL"));
    
    Entity entity = new Entity(new ItemKey(hashKey, rangeKey)).withLastModified(lastModified).withPayload(payload).withDeletionTTL(deletionTTL.longValue());
    if (item.containsKey("counter"))
    {
      Long counter = Long.valueOf(Long.parseLong(((AttributeValue)item.get("counter")).getN()));
      entity = entity.withCounter(counter);
    }
    if (item.containsKey("eTag")) {
      entity = entity.withEtag(((AttributeValue)item.get("eTag")).getS());
    }
    NativeDynamoDBListWithPrefetchResult.access$502(this$0, rangeKey);
    return entity;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBListWithPrefetchResult.1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */