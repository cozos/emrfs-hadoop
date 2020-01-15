package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractIterator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NativeDynamoDBListResult
  implements Iterable<Entity>
{
  private static final Logger LOG = LoggerFactory.getLogger(NativeDynamoDBListResult.class);
  private final QueryRequest queryRequest;
  private final AmazonDynamoDB amazonDynamoDB;
  private Map<String, AttributeValue> exclusiveStartKey = null;
  private boolean endOfData = false;
  private NativeDynamoDBRateLimiter rateLimiter;
  
  public NativeDynamoDBListResult(AmazonDynamoDB amazonDynamoDB, QueryRequest queryRequest, NativeDynamoDBRateLimiter rateLimiter)
  {
    this.amazonDynamoDB = amazonDynamoDB;
    this.queryRequest = queryRequest;
    this.rateLimiter = rateLimiter;
  }
  
  public Iterator<Entity> iterator()
  {
    new AbstractIterator()
    {
      List<Entity> batchResult = null;
      Iterator<Entity> iterator = null;
      
      protected Entity computeNext()
      {
        for (;;)
        {
          if ((iterator != null) && (iterator.hasNext())) {
            return (Entity)iterator.next();
          }
          batchResult = NativeDynamoDBListResult.this.getNextBatch();
          if ((batchResult == null) || (batchResult.size() == 0)) {
            return (Entity)endOfData();
          }
          iterator = batchResult.iterator();
        }
      }
    };
  }
  
  private List<Entity> getNextBatch()
  {
    if (endOfData) {
      return null;
    }
    queryRequest.setExclusiveStartKey(exclusiveStartKey);
    QueryResult queryResult = null;
    try
    {
      rateLimiter.beforeRead();
      queryResult = amazonDynamoDB.query(queryRequest);
      rateLimiter.afterRead(queryResult.getConsumedCapacity());
    }
    catch (AmazonClientException e)
    {
      LOG.error(String.format("Query operation failed: '%s'", new Object[] { queryRequest }), e);
      throw new RetriableEntityStoreException(e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION);
    }
    if ((queryResult == null) || (queryResult.getItems() == null) || (queryResult.getItems().size() == 0))
    {
      endOfData = true;
      return null;
    }
    exclusiveStartKey = queryResult.getLastEvaluatedKey();
    if (exclusiveStartKey == null) {
      endOfData = true;
    }
    List<Entity> entities = Lists.newArrayList();
    for (Map<String, AttributeValue> item : queryResult.getItems()) {
      entities.add(NativeDynamoDBEntityStore.itemToEntity(item));
    }
    return entities;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBListResult
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */