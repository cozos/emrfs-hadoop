package com.amazon.ws.emr.hadoop.fs.dynamodb.impl;

import com.amazon.ws.emr.hadoop.fs.dynamodb.Entity;
import com.amazon.ws.emr.hadoop.fs.dynamodb.EntityStore;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKey;
import com.amazon.ws.emr.hadoop.fs.dynamodb.ItemKeyCondition;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreException;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.EntityStoreExceptionCode;
import com.amazon.ws.emr.hadoop.fs.dynamodb.impl.exception.RetriableEntityStoreException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TableStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.EntryTransformer;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.tuple.Pair;
import com.amazon.ws.emr.hadoop.fs.shaded.org.joda.time.DateTime;
import com.amazon.ws.emr.hadoop.fs.util.EmrFsUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NativeDynamoDBEntityStore
  implements EntityStore<Entity>
{
  private final AmazonDynamoDB amazonDynamoDB;
  private static final Logger LOG = LoggerFactory.getLogger(NativeDynamoDBEntityStore.class);
  private static final long DEFAULT_READ_CAPACITY = 400L;
  private static final long DEFAULT_WRITE_CAPACITY = 100L;
  private String tableName;
  private boolean autoCreateTable;
  private Long readCapacityUnits = new Long(400L);
  private Long writeCapacityUnits = new Long(100L);
  private boolean conditionalUpdate;
  private boolean logVerbose = false;
  private boolean autoAdjustRateLimiter = true;
  private int limit = Integer.MAX_VALUE;
  private final boolean scanForward = true;
  private final boolean consistentRead = true;
  private boolean prefetching = false;
  private boolean initialized = false;
  private boolean etagVerification = true;
  private NativeDynamoDBRateLimiter rateLimiter;
  
  public NativeDynamoDBEntityStore(AmazonDynamoDB amazonDynamoDB)
  {
    this(amazonDynamoDB, -1L, -1L);
  }
  
  public NativeDynamoDBEntityStore(AmazonDynamoDB amazonDynamoDB, long readCapacityLimit, long writeCapacityLimit)
  {
    this.amazonDynamoDB = amazonDynamoDB;
    rateLimiter = new NativeDynamoDBRateLimiter(readCapacityLimit, writeCapacityLimit);
  }
  
  public String getTableName()
  {
    return tableName;
  }
  
  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  
  public NativeDynamoDBEntityStore withTableName(String tableName)
  {
    setTableName(tableName);
    return this;
  }
  
  public boolean isLogVerbose()
  {
    return logVerbose;
  }
  
  public void setLogVerbose(boolean logVerbose)
  {
    this.logVerbose = logVerbose;
  }
  
  public NativeDynamoDBEntityStore withLogVerbose(boolean logVerbose)
  {
    setLogVerbose(logVerbose);
    return this;
  }
  
  public boolean isAutoCreateTable()
  {
    return autoCreateTable;
  }
  
  public void setAutoCreateTable(boolean autoCreateTable)
  {
    this.autoCreateTable = autoCreateTable;
  }
  
  public NativeDynamoDBEntityStore withAutoCreateTable(boolean autoCreateTable)
  {
    setAutoCreateTable(autoCreateTable);
    return this;
  }
  
  public boolean isAutoAdjustRateLimiter()
  {
    return autoAdjustRateLimiter;
  }
  
  public void setAutoAdjustRateLimiter(boolean autoAdjustRateLimiter)
  {
    this.autoAdjustRateLimiter = autoAdjustRateLimiter;
  }
  
  public NativeDynamoDBEntityStore withAutoAdjustRateLimiter(boolean autoAdjustRateLimiter)
  {
    setAutoAdjustRateLimiter(autoAdjustRateLimiter);
    return this;
  }
  
  public Long getReadCapacityUnits()
  {
    return readCapacityUnits;
  }
  
  public long getReadCapacityLimit()
  {
    return Double.valueOf(rateLimiter.getReadPermitsPerSecond()).longValue();
  }
  
  public TableDescription getTableDescription()
  {
    DescribeTableResult describeTableResult = amazonDynamoDB.describeTable(tableName);
    return describeTableResult.getTable();
  }
  
  public void setReadCapacityUnits(Long readCapacityUnits)
  {
    this.readCapacityUnits = readCapacityUnits;
  }
  
  public NativeDynamoDBEntityStore withReadCapacityUnits(Long readCapacityUnits)
  {
    setReadCapacityUnits(readCapacityUnits);
    return this;
  }
  
  public boolean etagVerificationEnabled()
  {
    return etagVerification;
  }
  
  public void setEtagVerification(boolean etagVerification)
  {
    this.etagVerification = etagVerification;
  }
  
  public NativeDynamoDBEntityStore withEtagVerification(boolean etagVerification)
  {
    setEtagVerification(etagVerification);
    return this;
  }
  
  public boolean isPrefetching()
  {
    return prefetching;
  }
  
  public void setPrefetching(boolean prefetching)
  {
    this.prefetching = prefetching;
  }
  
  public NativeDynamoDBEntityStore withPrefetching(boolean prefetching)
  {
    setPrefetching(prefetching);
    return this;
  }
  
  public Long getWriteCapacityUnits()
  {
    return writeCapacityUnits;
  }
  
  public long getWriteCapacityLimit()
  {
    return Double.valueOf(rateLimiter.getWritePermitsPerSecond()).longValue();
  }
  
  public void setWriteCapacityUnits(Long writeCapacityUnits)
  {
    this.writeCapacityUnits = writeCapacityUnits;
  }
  
  public NativeDynamoDBEntityStore withWriteCapacityUnits(Long writeCapacityUnits)
  {
    setWriteCapacityUnits(writeCapacityUnits);
    return this;
  }
  
  public boolean isConditionalUpdate()
  {
    return conditionalUpdate;
  }
  
  public void setConditionalUpdate(boolean conditionalUpdate)
  {
    this.conditionalUpdate = conditionalUpdate;
  }
  
  public NativeDynamoDBEntityStore withConditionalUpdate(boolean conditionalUpdate)
  {
    setConditionalUpdate(conditionalUpdate);
    return this;
  }
  
  public int getLimit()
  {
    return limit;
  }
  
  public void setLimit(int limit)
  {
    this.limit = limit;
  }
  
  public NativeDynamoDBEntityStore withLimit(int limit)
  {
    setLimit(limit);
    return this;
  }
  
  public void initialize()
  {
    Preconditions.checkArgument(!Strings.isNullOrEmpty(tableName), "Table name cannot be empty");
    Preconditions.checkArgument(!initialized, "Cannot initialize more than once");
    if (tableExists())
    {
      getProvisionedThroughput();
      Entity entity = retrieve(getEntityStoreTagItemKey());
      if (entity == null) {
        throw new EntityStoreException("Table '" + tableName + "' already exists but does not contain required tag entries", EntityStoreExceptionCode.INVALID_TABLE_ROLE);
      }
    }
    else if (autoCreateTable)
    {
      createTable();
    }
    else
    {
      throw new ResourceNotFoundException(String.format("Could not find DynamoDB table '%s'", new Object[] { tableName }));
    }
    if (autoAdjustRateLimiter) {
      if (rateLimiter == null)
      {
        rateLimiter = new NativeDynamoDBRateLimiter(getReadCapacityUnits().longValue(), getWriteCapacityUnits().longValue());
      }
      else
      {
        double readLimit;
        double readLimit;
        if (rateLimiter.getReadPermitsPerSecond() == -1.0D) {
          readLimit = getReadCapacityUnits().longValue();
        } else {
          readLimit = rateLimiter.getReadPermitsPerSecond();
        }
        double writeLimit;
        double writeLimit;
        if (rateLimiter.getWritePermitsPerSecond() == -1.0D) {
          writeLimit = getWriteCapacityUnits().longValue();
        } else {
          writeLimit = rateLimiter.getWritePermitsPerSecond();
        }
        rateLimiter = new NativeDynamoDBRateLimiter(readLimit, writeLimit);
      }
    }
    initialized = true;
  }
  
  public Pair<Long, Long> getProvisionedThroughput()
  {
    DescribeTableResult describeTableResult = describeTable();
    if (describeTableResult != null)
    {
      readCapacityUnits = describeTableResult.getTable().getProvisionedThroughput().getReadCapacityUnits();
      writeCapacityUnits = describeTableResult.getTable().getProvisionedThroughput().getWriteCapacityUnits();
      return Pair.of(readCapacityUnits, writeCapacityUnits);
    }
    return null;
  }
  
  private boolean tableExists()
  {
    return describeTable() != null;
  }
  
  private DescribeTableResult describeTable()
  {
    try
    {
      return amazonDynamoDB.describeTable(tableName);
    }
    catch (ResourceNotFoundException e) {}
    return null;
  }
  
  public void updateProvisionedThroughput()
  {
    ProvisionedThroughputDescription provisionedThroughputDescription = amazonDynamoDB.describeTable(tableName).getTable().getProvisionedThroughput();
    long currentRead = provisionedThroughputDescription.getReadCapacityUnits().longValue();
    long currentWrite = provisionedThroughputDescription.getWriteCapacityUnits().longValue();
    long targetRead = readCapacityUnits.longValue() <= 0L ? currentRead : readCapacityUnits.longValue();
    long targetWrite = writeCapacityUnits.longValue() <= 0L ? currentWrite : writeCapacityUnits.longValue();
    int operationTimeoutSeconds = 300;
    while ((currentRead != targetRead) || (currentWrite != targetWrite))
    {
      long updatedRead = currentRead * 2L < targetRead ? currentRead * 2L : targetRead;
      long updatedWrite = currentWrite * 2L < targetWrite ? currentWrite * 2L : targetWrite;
      ProvisionedThroughput provisionedThroughput = new ProvisionedThroughput(Long.valueOf(updatedRead), Long.valueOf(updatedWrite));
      try
      {
        amazonDynamoDB.updateTable(tableName, provisionedThroughput);
        currentRead = updatedRead;
        currentWrite = updatedWrite;
        waitForTableState(TableStatus.ACTIVE, 300);
        if ((currentRead == targetRead) && (currentWrite == targetWrite)) {
          return;
        }
      }
      catch (ResourceInUseException e)
      {
        waitForTableState(TableStatus.ACTIVE, 300);
      }
    }
  }
  
  private void createTable()
  {
    KeySchemaElement hashKeyElement = new KeySchemaElement();
    hashKeyElement.setAttributeName("hashKey");
    hashKeyElement.setKeyType(KeyType.HASH);
    
    KeySchemaElement rangeKeyElement = new KeySchemaElement();
    rangeKeyElement.setAttributeName("rangeKey");
    rangeKeyElement.setKeyType(KeyType.RANGE);
    
    List<KeySchemaElement> keySchema = Lists.newArrayList();
    keySchema.add(hashKeyElement);
    keySchema.add(rangeKeyElement);
    
    Collection<AttributeDefinition> attributeDefinitions = Lists.newArrayList();
    attributeDefinitions.add(new AttributeDefinition().withAttributeName("hashKey").withAttributeType(ScalarAttributeType.S));
    attributeDefinitions.add(new AttributeDefinition().withAttributeName("rangeKey").withAttributeType(ScalarAttributeType.S));
    
    CreateTableRequest createTableRequest = new CreateTableRequest(tableName, keySchema);
    createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(getReadCapacityUnits(), getWriteCapacityUnits()));
    createTableRequest.setAttributeDefinitions(attributeDefinitions);
    amazonDynamoDB.createTable(createTableRequest);
    
    int timeoutSeconds = 300;
    waitForTableState(TableStatus.ACTIVE, 300);
    ItemKey entityStoreTagItemKey = getEntityStoreTagItemKey();
    create(new Entity(entityStoreTagItemKey, new byte[1]));
  }
  
  private void waitForTableState(TableStatus tableStatus, int timeoutSeconds)
  {
    DateTime timeout = new DateTime().plusSeconds(timeoutSeconds);
    while (DateTime.now().isBefore(timeout))
    {
      DescribeTableResult result = null;
      try
      {
        result = amazonDynamoDB.describeTable(tableName);
        if (tableStatus.toString().equals(result.getTable().getTableStatus())) {
          return;
        }
      }
      catch (ResourceNotFoundException localResourceNotFoundException) {}
      if (result == null) {
        LOG.info("Waiting for DynamoDB table '{}' to be created...");
      } else {
        LOG.info("Waiting for DynamoDB table '{}' to transition from {} to {}...", new Object[] { tableName, result.getTable().getTableStatus(), tableStatus });
      }
      try
      {
        TimeUnit.SECONDS.sleep(5L);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
    throw new RuntimeException(String.format("Timeout waiting for table '%s' to transition to status '%s'", new Object[] { tableName, tableStatus }));
  }
  
  public void create(Entity entity)
  {
    Preconditions.checkNotNull(entity, "Entity cannot be null");
    Preconditions.checkNotNull(entity.getPayload(), "must supply a payload");
    Preconditions.checkArgument(entity.getPayload().length > 0, "payload must have positive size");
    Map<String, AttributeValue> item = getCreateItem(entity, false);
    
    Map<String, ExpectedAttributeValue> expected = Maps.newHashMap();
    expected.put("hashKey", new ExpectedAttributeValue(Boolean.valueOf(false)));
    expected.put("rangeKey", new ExpectedAttributeValue(Boolean.valueOf(false)));
    
    PutItemRequest putItemRequest = new PutItemRequest().withTableName(tableName).withItem(item).withExpected(expected).withConditionalOperator(ConditionalOperator.OR).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
    try
    {
      rateLimiter.beforeWrite(putItemRequest.getItem());
      PutItemResult result = amazonDynamoDB.putItem(putItemRequest);
      rateLimiter.afterWrite(result.getConsumedCapacity());
    }
    catch (ConditionalCheckFailedException e)
    {
      if (logVerbose) {
        LOG.debug("Item already exists, itemKey='{}'", entity.getItemKey(), e);
      }
      throw new EntityStoreException(String.format("Item '%s' already exists", new Object[] { entity.getItemKey() }), e, EntityStoreExceptionCode.ALREADY_EXISTS);
    }
    catch (AmazonClientException e)
    {
      if (logVerbose) {
        LOG.error("Unable to create item, itemKey='{}'", entity.getItemKey(), e);
      }
      throw new RetriableEntityStoreException(String.format("Unable to create '%s'", new Object[] { entity.getItemKey() }), e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION);
    }
  }
  
  private Map<String, AttributeValue> getCreateItem(Entity entity, boolean batchRequest)
  {
    String hashKey = entity.getItemKey().getHashKey();
    String rangeKey = entity.getItemKey().getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Create: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Create: range key cannot be empty");
    Map<String, AttributeValue> item = Maps.newHashMap();
    item.put("hashKey", new AttributeValue().withS(hashKey));
    item.put("rangeKey", new AttributeValue().withS(rangeKey));
    item.put("lastModified", new AttributeValue().withN(Long.toString(DateTime.now().getMillis())));
    item.put("payload", new AttributeValue().withB(EmrFsUtils.safeCreateByteBuffer(entity.getPayload())));
    if ((entity.getEtag() != null) && (etagVerificationEnabled())) {
      item.put("eTag", new AttributeValue().withS(entity.getEtag()));
    }
    if (entity.getDeletionTTL() != null) {
      item.put("deletionTTL", new AttributeValue()
        .withN(Long.toString(entity.getDeletionTTL().longValue())));
    }
    if ((conditionalUpdate) && (!batchRequest)) {
      item.put("counter", new AttributeValue().withN(Long.toString(1L)));
    }
    return item;
  }
  
  public void update(Entity entity)
  {
    Preconditions.checkNotNull(entity, "Entity cannot be null");
    
    String hashKey = entity.getItemKey().getHashKey();
    String rangeKey = entity.getItemKey().getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Update: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Update: range key cannot be empty");
    
    Map<String, AttributeValue> updateItemKey = Maps.newHashMap();
    updateItemKey.put("hashKey", new AttributeValue().withS(hashKey));
    updateItemKey.put("rangeKey", new AttributeValue().withS(rangeKey));
    
    Map<String, ExpectedAttributeValue> expected = Maps.newHashMap();
    expected.put("hashKey", new ExpectedAttributeValue().withExists(Boolean.valueOf(true)).withValue(new AttributeValue().withS(hashKey)));
    expected.put("rangeKey", new ExpectedAttributeValue().withExists(Boolean.valueOf(true)).withValue(new AttributeValue().withS(rangeKey)));
    
    Map<String, AttributeValueUpdate> updates = Maps.newHashMap();
    updates.put("lastModified", new AttributeValueUpdate()
    
      .withAction(AttributeAction.PUT)
      .withValue(new AttributeValue().withN(Long.toString(DateTime.now().getMillis()))));
    updates.put("payload", new AttributeValueUpdate()
    
      .withAction(AttributeAction.PUT)
      .withValue(new AttributeValue().withB(EmrFsUtils.safeCreateByteBuffer(entity.getPayload()))));
    updates.put("deletionTTL", new AttributeValueUpdate()
    
      .withAction(AttributeAction.PUT)
      .withValue(new AttributeValue().withN(Long.toString(entity.getDeletionTTL().longValue()))));
    if ((entity.getEtag() != null) && (etagVerificationEnabled())) {
      updates.put("eTag", new AttributeValueUpdate()
      
        .withAction(AttributeAction.PUT)
        .withValue(new AttributeValue().withS(entity.getEtag())));
    }
    if (conditionalUpdate)
    {
      updates.put("counter", new AttributeValueUpdate()
      
        .withAction(AttributeAction.ADD)
        .withValue(new AttributeValue().withN(Long.toString(1L))));
      if (entity.getCounter() != null) {
        expected.put("counter", new ExpectedAttributeValue()
        
          .withValue(new AttributeValue().withN(Long.toString(entity.getCounter().longValue()))));
      } else {
        expected.put("counter", new ExpectedAttributeValue()
          .withExists(Boolean.valueOf(false)));
      }
    }
    UpdateItemRequest updateItemRequest = new UpdateItemRequest().withTableName(tableName).withKey(updateItemKey).withAttributeUpdates(updates).withExpected(expected).withConditionalOperator(ConditionalOperator.AND).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
    try
    {
      rateLimiter.beforeWrite(
        Maps.transformEntries(updateItemRequest.getAttributeUpdates(), new Maps.EntryTransformer()
        {
          public AttributeValue transformEntry(@Nullable String key, @Nullable AttributeValueUpdate value)
          {
            return value.getValue();
          }
        }));
      UpdateItemResult result = amazonDynamoDB.updateItem(updateItemRequest);
      rateLimiter.afterWrite(result.getConsumedCapacity());
    }
    catch (ConditionalCheckFailedException e)
    {
      if (logVerbose) {
        LOG.debug(String.format("Stale entity, hashKey='%s', rangeKey='%s', counter='%s'", new Object[] { hashKey, rangeKey, entity.getCounter() }), e);
      }
      throw new EntityStoreException(e, EntityStoreExceptionCode.STALE_ENTITY);
    }
    catch (AmazonClientException e)
    {
      LOG.error(String.format("Unable to update item, hashKey='%s', rangeKey='%s'", new Object[] { hashKey, rangeKey }), e);
      throw new RetriableEntityStoreException(e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION);
    }
  }
  
  public Entity retrieve(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Item key cannot be null");
    
    String hashKey = itemKey.getHashKey();
    String rangeKey = itemKey.getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Retrieve: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Retrieve: range key cannot be empty");
    
    Map<String, AttributeValue> getItemKey = Maps.newHashMap();
    getItemKey.put("hashKey", new AttributeValue().withS(hashKey));
    getItemKey.put("rangeKey", new AttributeValue().withS(rangeKey));
    
    GetItemRequest getItemRequest = new GetItemRequest().withTableName(tableName).withConsistentRead(Boolean.valueOf(true)).withKey(getItemKey).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
    
    GetItemResult getItemResult = null;
    try
    {
      rateLimiter.beforeRead();
      getItemResult = amazonDynamoDB.getItem(getItemRequest);
      rateLimiter.afterRead(getItemResult.getConsumedCapacity());
    }
    catch (AmazonClientException e)
    {
      if (logVerbose) {
        LOG.error(String.format("Unable to retrieve item, hashKey='%s', rangeKey='%s'", new Object[] { hashKey, rangeKey }), e);
      }
      throw new RetriableEntityStoreException(e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION);
    }
    if ((getItemResult == null) || (getItemResult.getItem() == null) || (getItemResult.getItem().size() == 0)) {
      return null;
    }
    Entity entity = new Entity(itemKey).withPayload(((AttributeValue)getItemResult.getItem().get("payload")).getB().array()).withLastModified(Long.valueOf(Long.parseLong(((AttributeValue)getItemResult.getItem().get("lastModified")).getN()))).withDeletionTTL(DynamoDBUtils.getLongFromItemIfExists(
      (AttributeValue)getItemResult.getItem().get("deletionTTL")).longValue());
    if (getItemResult.getItem().containsKey("eTag")) {
      entity = entity.withEtag(((AttributeValue)getItemResult.getItem().get("eTag")).getS());
    }
    if ((conditionalUpdate) && (getItemResult.getItem().containsKey("counter"))) {
      entity = entity.withCounter(Long.valueOf(Long.parseLong(((AttributeValue)getItemResult.getItem().get("counter")).getN())));
    }
    return entity;
  }
  
  private Map<String, AttributeValue> getDeleteItemKey(ItemKey itemKey)
  {
    String hashKey = itemKey.getHashKey();
    String rangeKey = itemKey.getRangeKey();
    Preconditions.checkArgument(!Strings.isNullOrEmpty(hashKey), "Delete: hash key cannot be empty");
    Preconditions.checkArgument(!Strings.isNullOrEmpty(rangeKey), "Delete: range key cannot be empty");
    Map<String, AttributeValue> deleteItemKey = Maps.newHashMap();
    deleteItemKey.put("hashKey", new AttributeValue().withS(hashKey));
    deleteItemKey.put("rangeKey", new AttributeValue().withS(rangeKey));
    return deleteItemKey;
  }
  
  public void delete(Entity entity)
  {
    Preconditions.checkNotNull(entity, "Entity cannot be null");
    Map<String, AttributeValue> deleteItemKey = getDeleteItemKey(entity.getItemKey());
    
    DeleteItemRequest deleteItemRequest = new DeleteItemRequest().withTableName(tableName).withKey(deleteItemKey).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
    if (conditionalUpdate)
    {
      Map<String, ExpectedAttributeValue> expected = Maps.newHashMap();
      if (entity.getCounter() != null) {
        expected.put("counter", new ExpectedAttributeValue()
        
          .withValue(new AttributeValue().withN(Long.toString(entity.getCounter().longValue()))));
      } else {
        expected.put("counter", new ExpectedAttributeValue()
          .withExists(Boolean.valueOf(false)));
      }
      deleteItemRequest.setExpected(expected);
    }
    try
    {
      rateLimiter.beforeWrite(null);
      DeleteItemResult result = amazonDynamoDB.deleteItem(deleteItemRequest);
      rateLimiter.afterWrite(result.getConsumedCapacity());
    }
    catch (ConditionalCheckFailedException e)
    {
      if (logVerbose) {
        LOG.debug(String.format("Stale entity, '%s', counter='%s'", new Object[] { entity.getItemKey(), entity.getCounter() }), e);
      }
      throw new EntityStoreException(e, EntityStoreExceptionCode.STALE_ENTITY);
    }
    catch (AmazonClientException e)
    {
      if (logVerbose) {
        LOG.error(String.format("Unable to delete item, '%s'", new Object[] { entity.getItemKey() }), e);
      }
      throw new RetriableEntityStoreException(e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION);
    }
  }
  
  public void delete(ItemKey itemKey)
  {
    delete(new Entity(itemKey).withCounter(null));
  }
  
  public void delete(Collection<ItemKey> itemKeys)
    throws EntityStoreException
  {
    Preconditions.checkNotNull(itemKeys, "itemKeys must have a valid value");
    for (ItemKey itemKey : itemKeys) {
      Preconditions.checkNotNull(itemKey, "ItemKey must have a valid value");
    }
    if (itemKeys.isEmpty()) {
      return;
    }
    int maxKeys = 25;
    if (itemKeys.size() <= 25)
    {
      batchDelete(itemKeys);
    }
    else
    {
      List<ItemKey> keysList = new ArrayList(25);
      for (ItemKey itemKey : itemKeys)
      {
        keysList.add(itemKey);
        if (keysList.size() == 25)
        {
          batchDelete(keysList);
          keysList = new ArrayList(25);
        }
      }
      if (!keysList.isEmpty()) {
        batchDelete(keysList);
      }
    }
  }
  
  public void create(Collection<Entity> entities)
  {
    Preconditions.checkNotNull(entities, "entities must have a valid value");
    for (Entity e : entities) {
      Preconditions.checkNotNull(e, "entity must have a valid value");
    }
    if (entities.isEmpty()) {
      return;
    }
    int maxKeys = 25;
    if (entities.size() <= 25)
    {
      batchCreate(entities);
    }
    else
    {
      List<Entity> entitiesList = new ArrayList(25);
      for (Entity e : entities)
      {
        entitiesList.add(e);
        if (entitiesList.size() == 25)
        {
          batchCreate(entitiesList);
          entitiesList = new ArrayList(25);
        }
      }
      if (!entitiesList.isEmpty()) {
        batchCreate(entitiesList);
      }
    }
  }
  
  private void batchCreate(Collection<Entity> entities)
    throws EntityStoreException
  {
    List<WriteRequest> writeRequests = new ArrayList();
    for (Entity e : entities)
    {
      Map<String, AttributeValue> createItem = getCreateItem(e, true);
      
      PutRequest putRequest = new PutRequest().withItem(createItem);
      
      WriteRequest writeRequest = new WriteRequest().withPutRequest(putRequest);
      writeRequests.add(writeRequest);
    }
    doBatchWrite(writeRequests);
  }
  
  private void batchDelete(Collection<ItemKey> itemKeys)
    throws EntityStoreException
  {
    List<WriteRequest> writeRequests = new ArrayList();
    for (ItemKey itemKey : itemKeys)
    {
      Map<String, AttributeValue> deleteItemKey = getDeleteItemKey(itemKey);
      
      DeleteRequest deleteRequest = new DeleteRequest().withKey(deleteItemKey);
      
      WriteRequest writeRequest = new WriteRequest().withDeleteRequest(deleteRequest);
      writeRequests.add(writeRequest);
    }
    doBatchWrite(writeRequests);
  }
  
  private void doBatchWrite(List<WriteRequest> writeRequests)
  {
    Map<String, List<WriteRequest>> writeRequestsMap = new HashMap();
    writeRequestsMap.put(tableName, writeRequests);
    
    BatchWriteItemRequest batchWriteItemRequest = new BatchWriteItemRequest().withRequestItems(writeRequestsMap).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
    do
    {
      try
      {
        rateLimiter.beforeWrite(null);
        BatchWriteItemResult result = amazonDynamoDB.batchWriteItem(batchWriteItemRequest);
        rateLimiter.afterWrite(result.getConsumedCapacity());
        writeRequestsMap = result.getUnprocessedItems();
      }
      catch (AmazonClientException e)
      {
        if (logVerbose)
        {
          String itemsString = Joiner.on(", ").join((Iterable)writeRequestsMap.get(tableName));
          LOG.error("Unable to batch write item(s): {}", itemsString, e);
        }
        throw new RetriableEntityStoreException(e, EntityStoreExceptionCode.AMAZON_CLIENT_EXCEPTION);
      }
    } while (!writeRequestsMap.isEmpty());
  }
  
  public Iterable<Entity> list(ItemKey itemKey)
  {
    Preconditions.checkNotNull(itemKey, "Key cannot be null");
    return listInternal(itemKey, true, null, false);
  }
  
  public Iterable<Entity> dump()
  {
    Map<String, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition> scanFilter = new HashMap();
    return dumpInternal(scanFilter);
  }
  
  public Iterable<Entity> dump(ItemKeyCondition condition)
  {
    Preconditions.checkNotNull(condition);
    Map<String, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition> scanFilter = new HashMap();
    ComparisonOperator operator = entityStoreConditionToDynamoComparisonOperator(condition.getCondition());
    
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition hashKeyCondition = new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition().withAttributeValueList(new AttributeValue[] {new AttributeValue().withS(condition.getItemKey().getHashKey()) }).withComparisonOperator(operator);
    
    scanFilter.put("hashKey", hashKeyCondition);
    if (!Strings.isNullOrEmpty(condition.getItemKey().getRangeKey()))
    {
      com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition rangeKeyCondition = new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition().withAttributeValueList(new AttributeValue[] { new AttributeValue().withS(condition.getItemKey().getRangeKey()) }).withComparisonOperator(operator);
      scanFilter.put("rangeKey", rangeKeyCondition);
    }
    return dumpInternal(scanFilter);
  }
  
  private ComparisonOperator entityStoreConditionToDynamoComparisonOperator(com.amazon.ws.emr.hadoop.fs.dynamodb.Condition condition)
  {
    switch (condition)
    {
    case BEGINS_WITH: 
      return ComparisonOperator.BEGINS_WITH;
    case EQUALS: 
      return ComparisonOperator.EQ;
    }
    throw new UnsupportedOperationException();
  }
  
  private Iterable<Entity> dumpInternal(Map<String, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition> scanFilter)
  {
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition payloadCondition = new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition().withComparisonOperator(ComparisonOperator.NOT_NULL);
    scanFilter.put("payload", payloadCondition);
    
    ScanRequest scanRequest = new ScanRequest().withScanFilter(scanFilter).withTableName(tableName);
    return new NativeDynamoDBDumpResult(amazonDynamoDB, rateLimiter, scanRequest);
  }
  
  public Iterable<Entity> list(ItemKey startKey, boolean startKeyInclusive, ItemKey endKey, boolean endKeyInclusive)
  {
    Preconditions.checkArgument((startKey != null) && (endKey != null), "Invalid range");
    return listInternal(startKey, startKeyInclusive, endKey, endKeyInclusive);
  }
  
  private Iterable<Entity> listInternal(ItemKey startKey, boolean startKeyInclusive, ItemKey endKey, boolean endKeyInclusive)
  {
    QueryRequest queryRequest = getQueryRequest(startKey, startKeyInclusive, endKey, endKeyInclusive);
    if (!prefetching) {
      return new NativeDynamoDBListResult(amazonDynamoDB, queryRequest, rateLimiter);
    }
    return new NativeDynamoDBListWithPrefetchResult(amazonDynamoDB, queryRequest, rateLimiter);
  }
  
  private QueryRequest getQueryRequest(ItemKey startKey, boolean startKeyInclusive, ItemKey endKey, boolean endKeyInclusive)
  {
    Map<String, com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition> keyConditions = Maps.newHashMap();
    
    keyConditions.put("hashKey", new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition()
    
      .withComparisonOperator(ComparisonOperator.EQ)
      .withAttributeValueList(new AttributeValue[] {new AttributeValue().withS(startKey.getHashKey()) }));
    if (endKey != null)
    {
      if (!startKey.getHashKey().equals(endKey.getHashKey())) {
        throw new RuntimeException(String.format("Invalid range: {'%s', '%s'}", new Object[] { startKey, endKey }));
      }
      String lowerRangeKey = startKey.getRangeKey();
      String upperRangeKey = endKey.getRangeKey();
      if ((!Strings.isNullOrEmpty(lowerRangeKey)) && (!Strings.isNullOrEmpty(upperRangeKey))) {
        keyConditions.put("rangeKey", new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition()
        
          .withComparisonOperator(ComparisonOperator.BETWEEN)
          .withAttributeValueList(new AttributeValue[] {new AttributeValue()
          .withS(lowerRangeKey), new AttributeValue()
          .withS(upperRangeKey) }));
      } else if (!Strings.isNullOrEmpty(lowerRangeKey)) {
        keyConditions.put("rangeKey", new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition()
        
          .withComparisonOperator(startKeyInclusive ? ComparisonOperator.GE : ComparisonOperator.GT)
          .withAttributeValueList(new AttributeValue[] {new AttributeValue()
          .withS(lowerRangeKey) }));
      } else if (!Strings.isNullOrEmpty(upperRangeKey)) {
        keyConditions.put("rangeKey", new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition()
        
          .withComparisonOperator(endKeyInclusive ? ComparisonOperator.LE : ComparisonOperator.LT)
          .withAttributeValueList(new AttributeValue[] {new AttributeValue()
          .withS(upperRangeKey) }));
      }
    }
    else if (!Strings.isNullOrEmpty(startKey.getRangeKey()))
    {
      keyConditions.put("rangeKey", new com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition()
        .withComparisonOperator(ComparisonOperator.BEGINS_WITH)
        .withAttributeValueList(new AttributeValue[] {new AttributeValue().withS(startKey.getRangeKey()) }));
    }
    QueryRequest queryRequest = new QueryRequest().withTableName(tableName).withConsistentRead(Boolean.valueOf(true)).withKeyConditions(keyConditions).withLimit(Integer.valueOf(limit)).withScanIndexForward(Boolean.valueOf(true)).withReturnConsumedCapacity(ReturnConsumedCapacity.TOTAL);
    return queryRequest;
  }
  
  public void close() {}
  
  protected static ItemKey getEntityStoreTagItemKey()
  {
    return new ItemKey("MultiKeyStoreTag", "TableRole");
  }
  
  protected static Entity itemToEntity(Map<String, AttributeValue> item)
  {
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
    return entity;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.dynamodb.impl.NativeDynamoDBEntityStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */