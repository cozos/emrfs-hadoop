package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndex;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DynamoDBTableMapper<T, H, R>
{
  private static final Log LOG = LogFactory.getLog(DynamoDBTableMapper.class);
  private final DynamoDBMapperTableModel<T> model;
  private final DynamoDBMapperFieldModel<T, H> hk;
  private final DynamoDBMapperFieldModel<T, R> rk;
  private final DynamoDBMapperConfig config;
  private final DynamoDBMapper mapper;
  private final AmazonDynamoDB db;
  
  protected DynamoDBTableMapper(AmazonDynamoDB db, DynamoDBMapper mapper, DynamoDBMapperConfig config, DynamoDBMapperTableModel<T> model)
  {
    rk = model.rangeKeyIfExists();
    hk = model.hashKey();
    this.model = model;
    this.config = config;
    this.mapper = mapper;
    this.db = db;
  }
  
  public <V> DynamoDBMapperFieldModel<T, V> field(String attributeName)
  {
    return model.field(attributeName);
  }
  
  public DynamoDBMapperFieldModel<T, H> hashKey()
  {
    return model.hashKey();
  }
  
  public DynamoDBMapperFieldModel<T, R> rangeKey()
  {
    return model.rangeKey();
  }
  
  public List<T> batchLoad(Iterable<T> itemsToGet)
  {
    Map<String, List<Object>> results = mapper.batchLoad(itemsToGet);
    if (results.isEmpty()) {
      return Collections.emptyList();
    }
    return (List)results.get(mapper.getTableName(model.targetType(), config));
  }
  
  public List<DynamoDBMapper.FailedBatch> batchSave(Iterable<T> objectsToSave)
  {
    return mapper.batchWrite(objectsToSave, Collections.emptyList());
  }
  
  public List<DynamoDBMapper.FailedBatch> batchDelete(Iterable<T> objectsToDelete)
  {
    return mapper.batchWrite(Collections.emptyList(), objectsToDelete);
  }
  
  public List<DynamoDBMapper.FailedBatch> batchWrite(Iterable<T> objectsToWrite, Iterable<T> objectsToDelete)
  {
    return mapper.batchWrite(objectsToWrite, objectsToDelete);
  }
  
  public void transactionWrite(TransactionWriteRequest transactionWriteRequest)
  {
    for (TransactionWriteRequest.TransactionWriteOperation transactionWriteOperation : transactionWriteRequest.getTransactionWriteOperations()) {
      if (!model.targetType().equals(transactionWriteOperation.getObject().getClass())) {
        throw new DynamoDBMappingException("Input object is of the classType: " + transactionWriteOperation.getObject().getClass() + " but tableMapper is declared with classType: " + model.targetType());
      }
    }
    mapper.transactionWrite(transactionWriteRequest);
  }
  
  public List<Object> transactionLoad(TransactionLoadRequest transactionLoadRequest)
  {
    for (Object object : transactionLoadRequest.getObjectsToLoad()) {
      if (!model.targetType().equals(object.getClass())) {
        throw new DynamoDBMappingException("Input object is of the classType: " + object.getClass() + " but tableMapper is declared with classType: " + model.targetType());
      }
    }
    return mapper.transactionLoad(transactionLoadRequest);
  }
  
  public T load(H hashKey)
  {
    return (T)mapper.load(model.targetType(), hashKey);
  }
  
  public T load(H hashKey, R rangeKey)
  {
    return (T)mapper.load(model.targetType(), hashKey, rangeKey);
  }
  
  public void save(T object)
  {
    mapper.save(object);
  }
  
  public void save(T object, DynamoDBSaveExpression saveExpression)
  {
    mapper.save(object, saveExpression);
  }
  
  public void saveIfNotExists(T object)
    throws ConditionalCheckFailedException
  {
    DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
    for (DynamoDBMapperFieldModel<T, Object> key : model.keys()) {
      saveExpression.withExpectedEntry(key.name(), new ExpectedAttributeValue()
        .withExists(Boolean.valueOf(false)));
    }
    mapper.save(object, saveExpression);
  }
  
  public void saveIfExists(T object)
    throws ConditionalCheckFailedException
  {
    DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression();
    for (DynamoDBMapperFieldModel<T, Object> key : model.keys()) {
      saveExpression.withExpectedEntry(key.name(), new ExpectedAttributeValue()
        .withExists(Boolean.valueOf(true)).withValue(key.convert(key.get(object))));
    }
    mapper.save(object, saveExpression);
  }
  
  public final void delete(T object)
  {
    mapper.delete(object);
  }
  
  public final void delete(T object, DynamoDBDeleteExpression deleteExpression)
  {
    mapper.delete(object, deleteExpression);
  }
  
  public void deleteIfExists(T object)
    throws ConditionalCheckFailedException
  {
    DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression();
    for (DynamoDBMapperFieldModel<T, Object> key : model.keys()) {
      deleteExpression.withExpectedEntry(key.name(), new ExpectedAttributeValue()
        .withExists(Boolean.valueOf(true)).withValue(key.convert(key.get(object))));
    }
    mapper.delete(object, deleteExpression);
  }
  
  public int count(DynamoDBQueryExpression<T> queryExpression)
  {
    return mapper.count(model.targetType(), queryExpression);
  }
  
  public PaginatedQueryList<T> query(DynamoDBQueryExpression<T> queryExpression)
  {
    return mapper.query(model.targetType(), queryExpression);
  }
  
  public QueryResultPage<T> queryPage(DynamoDBQueryExpression<T> queryExpression)
  {
    return mapper.queryPage(model.targetType(), queryExpression);
  }
  
  public int count(DynamoDBScanExpression scanExpression)
  {
    return mapper.count(model.targetType(), scanExpression);
  }
  
  public PaginatedScanList<T> scan(DynamoDBScanExpression scanExpression)
  {
    return mapper.scan(model.targetType(), scanExpression);
  }
  
  public ScanResultPage<T> scanPage(DynamoDBScanExpression scanExpression)
  {
    return mapper.scanPage(model.targetType(), scanExpression);
  }
  
  public PaginatedParallelScanList<T> parallelScan(DynamoDBScanExpression scanExpression, int totalSegments)
  {
    return mapper.parallelScan(model.targetType(), scanExpression, totalSegments);
  }
  
  public TableDescription describeTable()
  {
    return 
    
      db.describeTable(mapper.getTableName(model.targetType(), config)).getTable();
  }
  
  public TableDescription createTable(ProvisionedThroughput throughput)
  {
    CreateTableRequest request = mapper.generateCreateTableRequest(model.targetType());
    request.setProvisionedThroughput(throughput);
    if (request.getGlobalSecondaryIndexes() != null) {
      for (GlobalSecondaryIndex gsi : request.getGlobalSecondaryIndexes()) {
        gsi.setProvisionedThroughput(throughput);
      }
    }
    return db.createTable(request).getTableDescription();
  }
  
  public boolean createTableIfNotExists(ProvisionedThroughput throughput)
  {
    try
    {
      createTable(throughput);
    }
    catch (ResourceInUseException e)
    {
      if (LOG.isTraceEnabled()) {
        LOG.trace("Table already exists, no need to create", e);
      }
      return false;
    }
    return true;
  }
  
  public TableDescription deleteTable()
  {
    return 
    
      db.deleteTable(mapper.generateDeleteTableRequest(model.targetType())).getTableDescription();
  }
  
  public boolean deleteTableIfExists()
  {
    try
    {
      deleteTable();
    }
    catch (ResourceNotFoundException e)
    {
      if (LOG.isTraceEnabled()) {
        LOG.trace("Table does not exist, no need to delete", e);
      }
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTableMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */