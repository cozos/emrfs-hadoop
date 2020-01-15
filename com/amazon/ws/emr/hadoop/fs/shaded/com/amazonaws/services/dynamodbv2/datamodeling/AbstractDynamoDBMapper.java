package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AbstractDynamoDBMapper
  implements IDynamoDBMapper
{
  private final DynamoDBMapperConfig config;
  
  protected AbstractDynamoDBMapper(DynamoDBMapperConfig defaults)
  {
    config = DynamoDBMapperConfig.DEFAULT.merge(defaults);
  }
  
  protected AbstractDynamoDBMapper()
  {
    this(DynamoDBMapperConfig.DEFAULT);
  }
  
  protected final String getTableName(Class<?> clazz, Object object, DynamoDBMapperConfig config)
  {
    if ((config.getObjectTableNameResolver() != null) && (object != null)) {
      return config.getObjectTableNameResolver().getTableName(object, config);
    }
    return getTableName(clazz, config);
  }
  
  protected final String getTableName(Class<?> clazz, DynamoDBMapperConfig config)
  {
    if (config.getTableNameResolver() == null) {
      return DynamoDBMapperConfig.DefaultTableNameResolver.INSTANCE.getTableName(clazz, config);
    }
    return config.getTableNameResolver().getTableName(clazz, config);
  }
  
  protected final DynamoDBMapperConfig mergeConfig(DynamoDBMapperConfig overrides)
  {
    return config.merge(overrides);
  }
  
  public <T> DynamoDBMapperTableModel<T> getTableModel(Class<T> clazz)
  {
    return getTableModel(clazz, config);
  }
  
  public <T> DynamoDBMapperTableModel<T> getTableModel(Class<T> clazz, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> T load(Class<T> clazz, Object hashKey, DynamoDBMapperConfig config)
  {
    return (T)load(clazz, hashKey, null, config);
  }
  
  public <T> T load(Class<T> clazz, Object hashKey)
  {
    return (T)load(clazz, hashKey, null, config);
  }
  
  public <T> T load(Class<T> clazz, Object hashKey, Object rangeKey)
  {
    return (T)load(clazz, hashKey, rangeKey, config);
  }
  
  public <T> T load(Class<T> clazz, Object hashKey, Object rangeKey, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> T load(T keyObject)
  {
    return (T)load(keyObject, config);
  }
  
  public <T> T load(T keyObject, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> T marshallIntoObject(Class<T> clazz, Map<String, AttributeValue> itemAttributes)
  {
    return (T)marshallIntoObject(clazz, itemAttributes, config);
  }
  
  public <T> T marshallIntoObject(Class<T> clazz, Map<String, AttributeValue> itemAttributes, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> List<T> marshallIntoObjects(Class<T> clazz, List<Map<String, AttributeValue>> itemAttributes)
  {
    return marshallIntoObjects(clazz, itemAttributes, config);
  }
  
  public <T> List<T> marshallIntoObjects(Class<T> clazz, List<Map<String, AttributeValue>> itemAttributes, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> void save(T object)
  {
    save(object, (DynamoDBSaveExpression)null, config);
  }
  
  public <T> void save(T object, DynamoDBSaveExpression saveExpression)
  {
    save(object, saveExpression, config);
  }
  
  public <T> void save(T object, DynamoDBMapperConfig config)
  {
    save(object, (DynamoDBSaveExpression)null, config);
  }
  
  public <T> void save(T object, DynamoDBSaveExpression saveExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public void delete(Object object)
  {
    delete(object, (DynamoDBDeleteExpression)null, config);
  }
  
  public void delete(Object object, DynamoDBDeleteExpression deleteExpression)
  {
    delete(object, deleteExpression, config);
  }
  
  public void delete(Object object, DynamoDBMapperConfig config)
  {
    delete(object, (DynamoDBDeleteExpression)null, config);
  }
  
  public <T> void delete(T object, DynamoDBDeleteExpression deleteExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public void transactionWrite(TransactionWriteRequest transactionWriteRequest)
  {
    transactionWrite(transactionWriteRequest, (DynamoDBMapperConfig)null);
  }
  
  public void transactionWrite(TransactionWriteRequest transactionWriteRequest, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public List<Object> transactionLoad(TransactionLoadRequest transactionLoadRequest)
  {
    return transactionLoad(transactionLoadRequest, (DynamoDBMapperConfig)null);
  }
  
  public List<Object> transactionLoad(TransactionLoadRequest transactionLoadRequest, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public List<DynamoDBMapper.FailedBatch> batchDelete(Iterable<? extends Object> objectsToDelete)
  {
    return batchWrite(Collections.emptyList(), objectsToDelete, config);
  }
  
  public List<DynamoDBMapper.FailedBatch> batchDelete(Object... objectsToDelete)
  {
    return batchWrite(Collections.emptyList(), Arrays.asList(objectsToDelete), config);
  }
  
  public List<DynamoDBMapper.FailedBatch> batchSave(Iterable<? extends Object> objectsToSave)
  {
    return batchWrite(objectsToSave, Collections.emptyList(), config);
  }
  
  public List<DynamoDBMapper.FailedBatch> batchSave(Object... objectsToSave)
  {
    return batchWrite(Arrays.asList(objectsToSave), Collections.emptyList(), config);
  }
  
  public List<DynamoDBMapper.FailedBatch> batchWrite(Iterable<? extends Object> objectsToWrite, Iterable<? extends Object> objectsToDelete)
  {
    return batchWrite(objectsToWrite, objectsToDelete, config);
  }
  
  public List<DynamoDBMapper.FailedBatch> batchWrite(Iterable<? extends Object> objectsToWrite, Iterable<? extends Object> objectsToDelete, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public Map<String, List<Object>> batchLoad(Iterable<? extends Object> itemsToGet)
  {
    return batchLoad(itemsToGet, config);
  }
  
  public Map<String, List<Object>> batchLoad(Iterable<? extends Object> itemsToGet, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> itemsToGet)
  {
    return batchLoad(itemsToGet, config);
  }
  
  public Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> itemsToGet, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> PaginatedScanList<T> scan(Class<T> clazz, DynamoDBScanExpression scanExpression)
  {
    return scan(clazz, scanExpression, config);
  }
  
  public <T> PaginatedScanList<T> scan(Class<T> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> PaginatedParallelScanList<T> parallelScan(Class<T> clazz, DynamoDBScanExpression scanExpression, int totalSegments)
  {
    return parallelScan(clazz, scanExpression, totalSegments, config);
  }
  
  public <T> PaginatedParallelScanList<T> parallelScan(Class<T> clazz, DynamoDBScanExpression scanExpression, int totalSegments, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> ScanResultPage<T> scanPage(Class<T> clazz, DynamoDBScanExpression scanExpression)
  {
    return scanPage(clazz, scanExpression, config);
  }
  
  public <T> ScanResultPage<T> scanPage(Class<T> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public int count(Class<?> clazz, DynamoDBScanExpression scanExpression)
  {
    return count(clazz, scanExpression, config);
  }
  
  public int count(Class<?> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> PaginatedQueryList<T> query(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression)
  {
    return query(clazz, queryExpression, config);
  }
  
  public <T> PaginatedQueryList<T> query(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> QueryResultPage<T> queryPage(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression)
  {
    return queryPage(clazz, queryExpression, config);
  }
  
  public <T> QueryResultPage<T> queryPage(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public <T> int count(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression)
  {
    return count(clazz, queryExpression, config);
  }
  
  public <T> int count(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public S3ClientCache getS3ClientCache()
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public S3Link createS3Link(String bucketName, String key)
  {
    return createS3Link((Region)null, bucketName, key);
  }
  
  public S3Link createS3Link(Region s3region, String bucketName, String key)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public S3Link createS3Link(String s3region, String bucketName, String key)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public CreateTableRequest generateCreateTableRequest(Class<?> clazz)
  {
    return generateCreateTableRequest(clazz, config);
  }
  
  public <T> CreateTableRequest generateCreateTableRequest(Class<T> clazz, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
  
  public DeleteTableRequest generateDeleteTableRequest(Class<?> clazz)
  {
    return generateDeleteTableRequest(clazz, config);
  }
  
  public <T> DeleteTableRequest generateDeleteTableRequest(Class<T> clazz, DynamoDBMapperConfig config)
  {
    throw new UnsupportedOperationException("operation not supported in " + getClass());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.AbstractDynamoDBMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */