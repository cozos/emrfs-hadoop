package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region;
import java.util.List;
import java.util.Map;

public abstract interface IDynamoDBMapper
{
  public abstract <T> DynamoDBMapperTableModel<T> getTableModel(Class<T> paramClass);
  
  public abstract <T> DynamoDBMapperTableModel<T> getTableModel(Class<T> paramClass, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> T load(Class<T> paramClass, Object paramObject, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> T load(Class<T> paramClass, Object paramObject);
  
  public abstract <T> T load(Class<T> paramClass, Object paramObject1, Object paramObject2);
  
  public abstract <T> T load(T paramT);
  
  public abstract <T> T load(T paramT, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> T load(Class<T> paramClass, Object paramObject1, Object paramObject2, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> T marshallIntoObject(Class<T> paramClass, Map<String, AttributeValue> paramMap);
  
  public abstract <T> List<T> marshallIntoObjects(Class<T> paramClass, List<Map<String, AttributeValue>> paramList);
  
  public abstract <T> void save(T paramT);
  
  public abstract <T> void save(T paramT, DynamoDBSaveExpression paramDynamoDBSaveExpression);
  
  public abstract <T> void save(T paramT, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> void save(T paramT, DynamoDBSaveExpression paramDynamoDBSaveExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract void delete(Object paramObject);
  
  public abstract void delete(Object paramObject, DynamoDBDeleteExpression paramDynamoDBDeleteExpression);
  
  public abstract void delete(Object paramObject, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> void delete(T paramT, DynamoDBDeleteExpression paramDynamoDBDeleteExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract void transactionWrite(TransactionWriteRequest paramTransactionWriteRequest);
  
  public abstract void transactionWrite(TransactionWriteRequest paramTransactionWriteRequest, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract List<Object> transactionLoad(TransactionLoadRequest paramTransactionLoadRequest);
  
  public abstract List<Object> transactionLoad(TransactionLoadRequest paramTransactionLoadRequest, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract List<DynamoDBMapper.FailedBatch> batchDelete(Iterable<? extends Object> paramIterable);
  
  public abstract List<DynamoDBMapper.FailedBatch> batchDelete(Object... paramVarArgs);
  
  public abstract List<DynamoDBMapper.FailedBatch> batchSave(Iterable<? extends Object> paramIterable);
  
  public abstract List<DynamoDBMapper.FailedBatch> batchSave(Object... paramVarArgs);
  
  public abstract List<DynamoDBMapper.FailedBatch> batchWrite(Iterable<? extends Object> paramIterable1, Iterable<? extends Object> paramIterable2);
  
  public abstract List<DynamoDBMapper.FailedBatch> batchWrite(Iterable<? extends Object> paramIterable1, Iterable<? extends Object> paramIterable2, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract Map<String, List<Object>> batchLoad(Iterable<? extends Object> paramIterable);
  
  public abstract Map<String, List<Object>> batchLoad(Iterable<? extends Object> paramIterable, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> paramMap);
  
  public abstract Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> paramMap, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> PaginatedScanList<T> scan(Class<T> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression);
  
  public abstract <T> PaginatedScanList<T> scan(Class<T> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> PaginatedParallelScanList<T> parallelScan(Class<T> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression, int paramInt);
  
  public abstract <T> PaginatedParallelScanList<T> parallelScan(Class<T> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression, int paramInt, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> ScanResultPage<T> scanPage(Class<T> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> ScanResultPage<T> scanPage(Class<T> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression);
  
  public abstract <T> PaginatedQueryList<T> query(Class<T> paramClass, DynamoDBQueryExpression<T> paramDynamoDBQueryExpression);
  
  public abstract <T> PaginatedQueryList<T> query(Class<T> paramClass, DynamoDBQueryExpression<T> paramDynamoDBQueryExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> QueryResultPage<T> queryPage(Class<T> paramClass, DynamoDBQueryExpression<T> paramDynamoDBQueryExpression);
  
  public abstract <T> QueryResultPage<T> queryPage(Class<T> paramClass, DynamoDBQueryExpression<T> paramDynamoDBQueryExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract int count(Class<?> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression);
  
  public abstract int count(Class<?> paramClass, DynamoDBScanExpression paramDynamoDBScanExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract <T> int count(Class<T> paramClass, DynamoDBQueryExpression<T> paramDynamoDBQueryExpression);
  
  public abstract <T> int count(Class<T> paramClass, DynamoDBQueryExpression<T> paramDynamoDBQueryExpression, DynamoDBMapperConfig paramDynamoDBMapperConfig);
  
  public abstract S3ClientCache getS3ClientCache();
  
  public abstract S3Link createS3Link(String paramString1, String paramString2);
  
  public abstract S3Link createS3Link(Region paramRegion, String paramString1, String paramString2);
  
  public abstract S3Link createS3Link(String paramString1, String paramString2, String paramString3);
  
  public abstract CreateTableRequest generateCreateTableRequest(Class<?> paramClass);
  
  public abstract DeleteTableRequest generateDeleteTableRequest(Class<?> paramClass);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */