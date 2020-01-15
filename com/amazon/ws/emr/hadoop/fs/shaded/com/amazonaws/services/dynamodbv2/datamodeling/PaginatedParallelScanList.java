package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.LinkedList;
import java.util.List;

public class PaginatedParallelScanList<T>
  extends PaginatedList<T>
{
  private final ParallelScanTask parallelScanTask;
  private final DynamoDBMapperConfig config;
  
  public PaginatedParallelScanList(DynamoDBMapper mapper, Class<T> clazz, AmazonDynamoDB dynamo, ParallelScanTask parallelScanTask, DynamoDBMapperConfig.PaginationLoadingStrategy paginationLoadingStrategy, DynamoDBMapperConfig config)
  {
    super(mapper, clazz, dynamo, paginationLoadingStrategy);
    
    this.parallelScanTask = parallelScanTask;
    this.config = config;
    
    allResults.addAll(marshalParallelScanResultsIntoObjects(parallelScanTask.getNextBatchOfScanResults()));
    if (paginationLoadingStrategy == DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING) {
      loadAllResults();
    }
  }
  
  protected boolean atEndOfResults()
  {
    return parallelScanTask.isAllSegmentScanFinished();
  }
  
  protected List<T> fetchNextPage()
  {
    return marshalParallelScanResultsIntoObjects(parallelScanTask.getNextBatchOfScanResults());
  }
  
  private List<T> marshalParallelScanResultsIntoObjects(List<ScanResult> scanResults)
  {
    List<T> allItems = new LinkedList();
    for (ScanResult scanResult : scanResults) {
      if (null != scanResult) {
        allItems.addAll(mapper.marshallIntoObjects(mapper
          .toParameters(scanResult
          .getItems(), clazz, parallelScanTask
          
          .getTableName(), config)));
      }
    }
    return allItems;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.PaginatedParallelScanList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */