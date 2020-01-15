package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.slf4j.Logger;

class NativeDynamoDBListWithPrefetchResult$Prefetcher
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
  
  NativeDynamoDBListWithPrefetchResult$Prefetcher(AmazonDynamoDB this$0, QueryRequest amazonDynamoDB, NativeDynamoDBRateLimiter queryRequest, BlockingDeque<QueryResult> rateLimiter, StringBuilder queryResults, AtomicBoolean lastSeenRangeKey, String stopped)
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
        NativeDynamoDBListWithPrefetchResult.access$000(this$0, new RetriableEntityStoreException(errorMessage, e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION));
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
          NativeDynamoDBListWithPrefetchResult.access$200().debug("{} fetched range keys {} - {}", new Object[] { prefetcherName, 
          
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)queryResult.getItems().get(0)), 
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)queryResult.getItems().get(queryResult.getItems().size() - 1)) });
        } else {
          NativeDynamoDBListWithPrefetchResult.access$200().debug("{} fetched range keys {} - {}", new Object[] { prefetcherName, 
          
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)queryResult.getItems().get(queryResult.getItems().size() - 1)), 
            NativeDynamoDBListWithPrefetchResult.access$100(this$0, (Map)queryResult.getItems().get(0)) });
        }
        Map<String, AttributeValue> item = (Map)queryResult.getItems().get(queryResult.getItems().size() - 1);
        if ((queryRequest.getScanIndexForward().booleanValue()) && (queryResult.getLastEvaluatedKey() == null)) {
          NativeDynamoDBListWithPrefetchResult.access$302(this$0, NativeDynamoDBListWithPrefetchResult.access$100(this$0, item));
        }
        queryResults.putLast(queryResult);
        lastSeenRangeKey.setLength(0);
        lastSeenRangeKey.append(NativeDynamoDBListWithPrefetchResult.access$100(this$0, item));
        if (NativeDynamoDBListWithPrefetchResult.access$400(this$0))
        {
          stopped.set(true);
          break;
        }
      }
      catch (InterruptedException e)
      {
        NativeDynamoDBListWithPrefetchResult.access$000(this$0, e);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBListWithPrefetchResult.Prefetcher
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */