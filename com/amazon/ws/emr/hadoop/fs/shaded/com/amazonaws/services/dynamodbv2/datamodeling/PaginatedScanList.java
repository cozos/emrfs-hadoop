package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.List;

public class PaginatedScanList<T>
  extends PaginatedList<T>
{
  private final ScanRequest scanRequest;
  private final DynamoDBMapperConfig config;
  private ScanResult scanResult;
  
  public PaginatedScanList(DynamoDBMapper mapper, Class<T> clazz, AmazonDynamoDB dynamo, ScanRequest scanRequest, ScanResult scanResult, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy, DynamoDBMapperConfig config)
  {
    super(mapper, clazz, dynamo, paginationLoadingStrategy);
    
    this.scanRequest = scanRequest;
    this.scanResult = scanResult;
    this.config = config;
    
    allResults.addAll(mapper.marshallIntoObjects(mapper
      .toParameters(scanResult
      .getItems(), clazz, scanRequest
      
      .getTableName(), config)));
    if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING) {
      loadAllResults();
    }
  }
  
  protected boolean atEndOfResults()
  {
    return scanResult.getLastEvaluatedKey() == null;
  }
  
  protected synchronized List<T> fetchNextPage()
  {
    scanRequest.setExclusiveStartKey(scanResult.getLastEvaluatedKey());
    scanResult = dynamo.scan((ScanRequest)DynamoDBMapper.applyUserAgent(scanRequest));
    return mapper.marshallIntoObjects(mapper.toParameters(scanResult
      .getItems(), clazz, scanRequest
      
      .getTableName(), config));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */