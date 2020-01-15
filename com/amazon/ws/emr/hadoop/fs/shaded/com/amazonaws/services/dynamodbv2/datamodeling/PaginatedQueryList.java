package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.List;

public class PaginatedQueryList<T>
  extends PaginatedList<T>
{
  private final QueryRequest queryRequest;
  private final DynamoDBMapperConfig config;
  private QueryResult queryResult;
  
  public PaginatedQueryList(DynamoDBMapper mapper, Class<T> clazz, AmazonDynamoDB dynamo, QueryRequest queryRequest, QueryResult queryResult, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy, DynamoDBMapperConfig config)
  {
    super(mapper, clazz, dynamo, paginationLoadingStrategy);
    
    this.queryRequest = queryRequest;
    this.queryResult = queryResult;
    this.config = config;
    
    allResults.addAll(mapper.marshallIntoObjects(mapper
      .toParameters(queryResult
      .getItems(), clazz, queryRequest
      
      .getTableName(), config)));
    if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING) {
      loadAllResults();
    }
  }
  
  protected boolean atEndOfResults()
  {
    return queryResult.getLastEvaluatedKey() == null;
  }
  
  protected synchronized List<T> fetchNextPage()
  {
    queryRequest.setExclusiveStartKey(queryResult.getLastEvaluatedKey());
    queryResult = dynamo.query((QueryRequest)DynamoDBMapper.applyUserAgent(queryRequest));
    return mapper.marshallIntoObjects(mapper.toParameters(queryResult
      .getItems(), clazz, queryRequest
      
      .getTableName(), config));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */