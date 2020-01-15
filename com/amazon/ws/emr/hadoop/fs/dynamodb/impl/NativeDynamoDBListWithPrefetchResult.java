package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NativeDynamoDBListWithPrefetchResult
  implements Iterable<Entity>
{
  private static final Logger LOG = LoggerFactory.getLogger(NativeDynamoDBListWithPrefetchResult.class);
  private Thread forwardPrefetcher;
  private BlockingDeque<QueryResult> forwardQueryResults;
  private final StringBuilder lastSeenForwardRangeKey;
  private AtomicBoolean forwardPrefetcherStopped;
  private final String FORWARD_PREFETCHER_NAME = "Forward Prefetcher";
  private Thread backwardPrefetcher;
  private BlockingDeque<QueryResult> backwardQueryResults;
  private final StringBuilder lastSeenBackwardRangeKey;
  private AtomicBoolean backwardPrefetcherStopped;
  private final String BACKWARD_PREFETCHER_NAME = "Backward Prefetcher";
  private String lastReturnedRangeKey = null;
  private Exception prefetcherException;
  private String lastRangeKey = null;
  
  class Prefetcher
    implements Runnable
  {
    private AmazonDynamoDB amazonDynamoDB;
    private QueryRequest queryRequest;
    private Map<String, AttributeValue> exclusiveStartKey = null;
    private NativeDynamoDBRateLimiter rateLimiter;
    private BlockingDeque<QueryResult> queryResults;
    private StringBuilder lastSeenRangeKey;
    private AtomicBoolean stopped;
    private String prefetcherName;
    
    Prefetcher(QueryRequest amazonDynamoDB, NativeDynamoDBRateLimiter queryRequest, BlockingDeque<QueryResult> rateLimiter, StringBuilder queryResults, AtomicBoolean lastSeenRangeKey, String stopped)
    {
      this.prefetcherName = prefetcherName;
      this.amazonDynamoDB = amazonDynamoDB;
      this.queryRequest = new QueryRequest()
        .withTableName(queryRequest.getTableName())
        .withConsistentRead(queryRequest.getConsistentRead())
        .withKeyConditions(queryRequest.getKeyConditions())
        .withLimit(queryRequest.getLimit())
        .withScanIndexForward(queryRequest.getScanIndexForward())
        .withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
      this.rateLimiter = rateLimiter;
      this.queryResults = queryResults;
      this.lastSeenRangeKey = lastSeenRangeKey;
      this.stopped = stopped;
    }
    
    public void run()
    {
      for (;;)
      {
        queryRequest.setExclusiveStartKey(exclusiveStartKey);
        try
        {
          rateLimiter.beforeRead();
          QueryResult queryResult = amazonDynamoDB.query(queryRequest);
          rateLimiter.afterRead(queryResult.getConsumedCapacity());
        }
        catch (AmazonClientException e)
        {
          String errorMessage = String.format("Query operation failed: '%s'", new Object[] { queryRequest });
          NativeDynamoDBListWithPrefetchResult.this.setPrefetcherException(new RetriableEntityStoreException(errorMessage, e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION));
          stopped.set(true);
          break;
        }
        QueryResult queryResult;
        if ((queryResult == null) || (queryResult.getItems() == null) || (queryResult.getItems().size() == 0))
        {
          stopped.set(true);
          break;
        }
        try
        {
          if (prefetcherName.equals("Forward Prefetcher")) {
            NativeDynamoDBListWithPrefetchResult.LOG.debug("{} fetched range keys {} - {}", new Object[] { prefetcherName, NativeDynamoDBListWithPrefetchResult.this
            
              .getRangeKey((Map)queryResult.getItems().get(0)), NativeDynamoDBListWithPrefetchResult.this
              .getRangeKey((Map)queryResult.getItems().get(queryResult.getItems().size() - 1)) });
          } else {
            NativeDynamoDBListWithPrefetchResult.LOG.debug("{} fetched range keys {} - {}", new Object[] { prefetcherName, NativeDynamoDBListWithPrefetchResult.this
            
              .getRangeKey((Map)queryResult.getItems().get(queryResult.getItems().size() - 1)), NativeDynamoDBListWithPrefetchResult.this
              .getRangeKey((Map)queryResult.getItems().get(0)) });
          }
          Map<String, AttributeValue> item = (Map)queryResult.getItems().get(queryResult.getItems().size() - 1);
          if ((queryRequest.getScanIndexForward().booleanValue()) && (queryResult.getLastEvaluatedKey() == null)) {
            lastRangeKey = NativeDynamoDBListWithPrefetchResult.this.getRangeKey(item);
          }
          queryResults.putLast(queryResult);
          lastSeenRangeKey.setLength(0);
          lastSeenRangeKey.append(NativeDynamoDBListWithPrefetchResult.this.getRangeKey(item));
          if (NativeDynamoDBListWithPrefetchResult.this.isOverlapping())
          {
            stopped.set(true);
            break;
          }
        }
        catch (InterruptedException e)
        {
          NativeDynamoDBListWithPrefetchResult.this.setPrefetcherException(e);
          stopped.set(true);
          break;
        }
        exclusiveStartKey = queryResult.getLastEvaluatedKey();
        if (exclusiveStartKey == null)
        {
          stopped.set(true);
          break;
        }
      }
    }
  }
  
  private String getRangeKey(Map<String, AttributeValue> item)
  {
    return ((AttributeValue)item.get("rangeKey")).getS();
  }
  
  private synchronized boolean isOverlapping()
  {
    LOG.debug("Last evaluated forward range key: {}", lastSeenForwardRangeKey.toString());
    LOG.debug("Last evaluated backward range key: {}", lastSeenBackwardRangeKey.toString());
    LOG.debug("Number of forward query results: {}", Integer.valueOf(forwardQueryResults.size()));
    LOG.debug("Number of backward query results: {}", Integer.valueOf(backwardQueryResults.size()));
    return (!lastSeenForwardRangeKey.toString().isEmpty()) && 
      (!lastSeenBackwardRangeKey.toString().isEmpty()) && 
      (lastSeenForwardRangeKey.toString().compareTo(lastSeenBackwardRangeKey.toString()) >= 0);
  }
  
  private synchronized void setPrefetcherException(Exception exception)
  {
    prefetcherException = exception;
  }
  
  private synchronized void checkPrefetcherException()
    throws RuntimeException
  {
    if (prefetcherException != null) {
      throw new RuntimeException(prefetcherException);
    }
  }
  
  public NativeDynamoDBListWithPrefetchResult(AmazonDynamoDB amazonDynamoDB, QueryRequest queryRequest, NativeDynamoDBRateLimiter rateLimiter)
  {
    forwardQueryResults = new LinkedBlockingDeque();
    lastSeenForwardRangeKey = new StringBuilder("");
    forwardPrefetcherStopped = new AtomicBoolean(false);
    
    forwardPrefetcher = new Thread(new Prefetcher(amazonDynamoDB, queryRequest.withScanIndexForward(Boolean.valueOf(true)), rateLimiter, forwardQueryResults, lastSeenForwardRangeKey, forwardPrefetcherStopped, "Forward Prefetcher"));
    
    forwardPrefetcher.setDaemon(true);
    forwardPrefetcher.setName("Forward Prefetcher");
    
    backwardQueryResults = new LinkedBlockingDeque();
    lastSeenBackwardRangeKey = new StringBuilder("");
    backwardPrefetcherStopped = new AtomicBoolean(false);
    
    backwardPrefetcher = new Thread(new Prefetcher(amazonDynamoDB, queryRequest.withScanIndexForward(Boolean.valueOf(false)), rateLimiter, backwardQueryResults, lastSeenBackwardRangeKey, backwardPrefetcherStopped, "Backward Prefetcher"));
    
    backwardPrefetcher.setDaemon(true);
    backwardPrefetcher.setName("Backward Prefetcher");
    
    prefetcherException = null;
    
    forwardPrefetcher.start();
    backwardPrefetcher.start();
  }
  
  public Iterator<Entity> iterator()
  {
    new AbstractIterator()
    {
      QueryResult queryResult = null;
      Iterator<Map<String, AttributeValue>> iterator = null;
      boolean usingBackwardResults = false;
      
      protected Entity computeNext()
      {
        if ((lastReturnedRangeKey != null) && (lastReturnedRangeKey.equals(lastRangeKey))) {
          return (Entity)endOfData();
        }
        for (;;)
        {
          NativeDynamoDBListWithPrefetchResult.this.checkPrefetcherException();
          if ((iterator != null) && (iterator.hasNext())) {
            break;
          }
          if ((forwardQueryResults.isEmpty()) && (backwardQueryResults.isEmpty()))
          {
            if ((forwardPrefetcherStopped.get()) && (backwardPrefetcherStopped.get())) {
              return (Entity)endOfData();
            }
          }
          else if (!forwardQueryResults.isEmpty())
          {
            try
            {
              queryResult = ((QueryResult)forwardQueryResults.take());
              List<Map<String, AttributeValue>> items = queryResult.getItems();
              NativeDynamoDBListWithPrefetchResult.LOG.debug("Getting items from forwardQueryResults: {} - {}", NativeDynamoDBListWithPrefetchResult.this
                .getRangeKey((Map)items.get(0)), NativeDynamoDBListWithPrefetchResult.this
                .getRangeKey((Map)items.get(items.size() - 1)));
              iterator = queryResult.getItems().iterator();
            }
            catch (InterruptedException e)
            {
              throw new RuntimeException(e);
            }
          }
          else if ((forwardQueryResults.isEmpty()) && (!backwardQueryResults.isEmpty()) && 
            (forwardPrefetcherStopped.get()) && (forwardQueryResults.isEmpty()) && 
            
            (backwardPrefetcherStopped.get()))
          {
            if (lastReturnedRangeKey == null)
            {
              lastReturnedRangeKey = "";
              usingBackwardResults = true;
            }
            QueryResult result = null;
            if (!usingBackwardResults)
            {
              String lowerRangeKey = "";
              String upperRangeKey = "";
              while (!backwardQueryResults.isEmpty())
              {
                try
                {
                  result = (QueryResult)backwardQueryResults.takeLast();
                }
                catch (InterruptedException e)
                {
                  throw new RuntimeException(e);
                }
                lowerRangeKey = NativeDynamoDBListWithPrefetchResult.this.getRangeKey((Map)result.getItems().get(result.getItems().size() - 1));
                upperRangeKey = NativeDynamoDBListWithPrefetchResult.this.getRangeKey((Map)result.getItems().get(0));
                if ((lastReturnedRangeKey.compareTo(lowerRangeKey) >= 0) && (lastReturnedRangeKey.compareTo(upperRangeKey) < 0)) {
                  break;
                }
                result = null;
              }
              if (result == null)
              {
                NativeDynamoDBListWithPrefetchResult.LOG.info("Cannot find the next item {} in backwardQueryResults", lastReturnedRangeKey);
                return (Entity)endOfData();
              }
              iterator = Lists.reverse(result.getItems()).iterator();
              while (iterator.hasNext()) {
                if (NativeDynamoDBListWithPrefetchResult.this.getRangeKey((Map)iterator.next()).equals(lastReturnedRangeKey))
                {
                  NativeDynamoDBListWithPrefetchResult.LOG.debug("Last range key from forwardQueryResults: {}", lastReturnedRangeKey);
                  NativeDynamoDBListWithPrefetchResult.LOG.debug("Start getting items from backwardQueryResults: {} - {}", lowerRangeKey, upperRangeKey);
                  usingBackwardResults = true;
                }
              }
            }
            else
            {
              while (!backwardQueryResults.isEmpty())
              {
                try
                {
                  result = (QueryResult)backwardQueryResults.takeLast();
                }
                catch (InterruptedException e)
                {
                  throw new RuntimeException(e);
                }
                String lowerRangeKey = NativeDynamoDBListWithPrefetchResult.this.getRangeKey((Map)result.getItems().get(result.getItems().size() - 1));
                if (lowerRangeKey.compareTo(lastReturnedRangeKey) >= 0) {
                  break;
                }
                result = null;
              }
              if (result == null) {
                return (Entity)endOfData();
              }
              NativeDynamoDBListWithPrefetchResult.LOG.debug("Getting items from backwardQueryResults: {} - {}", NativeDynamoDBListWithPrefetchResult.this
                .getRangeKey((Map)result.getItems().get(result.getItems().size() - 1)), NativeDynamoDBListWithPrefetchResult.this
                .getRangeKey((Map)result.getItems().get(0)));
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
        lastReturnedRangeKey = rangeKey;
        return entity;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBListWithPrefetchResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */