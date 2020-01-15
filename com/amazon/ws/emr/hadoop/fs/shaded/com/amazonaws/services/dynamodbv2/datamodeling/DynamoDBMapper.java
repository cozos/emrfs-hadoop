package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionCheck;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionalOperator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Delete;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Get;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ItemResponse;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Put;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValuesOnConditionCheckFailure;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Select;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItem;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItem;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Update;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.VersionInfoUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DynamoDBMapper
  extends AbstractDynamoDBMapper
{
  private final AmazonDynamoDB db;
  private final DynamoDBMapperModelFactory models;
  private final S3Link.Factory s3Links;
  private final AttributeTransformer transformer;
  static final long MAX_BACKOFF_IN_MILLISECONDS = 3000L;
  static final int MAX_ITEMS_PER_BATCH = 25;
  static final int BATCH_GET_MAX_RETRY_COUNT_ALL_KEYS = 5;
  private static final String USER_AGENT = DynamoDBMapper.class
    .getName() + "/" + VersionInfoUtils.getVersion();
  private static final String USER_AGENT_BATCH_OPERATION = DynamoDBMapper.class
    .getName() + "_batch_operation/" + VersionInfoUtils.getVersion();
  private static final String USER_AGENT_TRANSACTION_OPERATION = DynamoDBMapper.class
    .getName() + "_transaction_operation/" + VersionInfoUtils.getVersion();
  private static final Log log = LogFactory.getLog(DynamoDBMapper.class);
  
  private static void failFastOnIncompatibleSubclass(Class<?> clazz)
  {
    while (clazz != DynamoDBMapper.class)
    {
      Class<?>[] classOverride = { Class.class, Map.class };
      
      Class<?>[] nameOverride = { String.class, String.class, Map.class };
      for (Method method : clazz.getDeclaredMethods()) {
        if (method.getName().equals("transformAttributes"))
        {
          Class<?>[] params = method.getParameterTypes();
          if ((Arrays.equals(params, classOverride)) || 
            (Arrays.equals(params, nameOverride))) {
            throw new IllegalStateException("The deprecated transformAttributes method is no longer supported as of 1.9.0. Use an AttributeTransformer to inject custom attribute transformation logic.");
          }
        }
      }
      clazz = clazz.getSuperclass();
    }
  }
  
  public DynamoDBMapper(AmazonDynamoDB dynamoDB)
  {
    this(dynamoDB, DynamoDBMapperConfig.DEFAULT, null, null);
  }
  
  public DynamoDBMapper(AmazonDynamoDB dynamoDB, DynamoDBMapperConfig config)
  {
    this(dynamoDB, config, null, null);
  }
  
  public DynamoDBMapper(AmazonDynamoDB ddb, AWSCredentialsProvider s3CredentialProvider)
  {
    this(ddb, DynamoDBMapperConfig.DEFAULT, s3CredentialProvider);
  }
  
  public DynamoDBMapper(AmazonDynamoDB dynamoDB, DynamoDBMapperConfig config, AttributeTransformer transformer)
  {
    this(dynamoDB, config, transformer, null);
  }
  
  public DynamoDBMapper(AmazonDynamoDB dynamoDB, DynamoDBMapperConfig config, AWSCredentialsProvider s3CredentialProvider)
  {
    this(dynamoDB, config, null, validate(s3CredentialProvider));
  }
  
  private static AWSCredentialsProvider validate(AWSCredentialsProvider provider)
  {
    if (provider == null) {
      throw new IllegalArgumentException("s3 credentials provider must not be null");
    }
    return provider;
  }
  
  public DynamoDBMapper(AmazonDynamoDB dynamoDB, DynamoDBMapperConfig config, AttributeTransformer transformer, AWSCredentialsProvider s3CredentialsProvider)
  {
    super(config);
    
    failFastOnIncompatibleSubclass(getClass());
    
    db = dynamoDB;
    this.transformer = transformer;
    
    s3Links = S3Link.Factory.of(s3CredentialsProvider);
    
    models = StandardModelFactories.of(s3Links);
  }
  
  public <T> DynamoDBMapperTableModel<T> getTableModel(Class<T> clazz, DynamoDBMapperConfig config)
  {
    return models.getTableFactory(config).getTable(clazz);
  }
  
  public <T> T load(T keyObject, DynamoDBMapperConfig config)
  {
    Class<T> clazz = keyObject.getClass();
    
    config = mergeConfig(config);
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, config);
    
    String tableName = getTableName(clazz, keyObject, config);
    
    GetItemRequest rq = (GetItemRequest)new GetItemRequest().withRequestMetricCollector(config.getRequestMetricCollector());
    
    Map<String, AttributeValue> key = model.convertKey(keyObject);
    
    rq.setKey(key);
    rq.setTableName(tableName);
    rq.setConsistentRead(Boolean.valueOf(config.getConsistentReads() == DynamoDBMapperConfig.ConsistentReads.CONSISTENT));
    
    GetItemResult item = db.getItem((GetItemRequest)applyUserAgent(rq));
    Map<String, AttributeValue> itemAttributes = item.getItem();
    if (itemAttributes == null) {
      return null;
    }
    T object = privateMarshallIntoObject(
      toParameters(itemAttributes, clazz, tableName, config));
    
    return object;
  }
  
  public <T> T load(Class<T> clazz, Object hashKey, Object rangeKey, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, config);
    T keyObject = model.createKey(hashKey, rangeKey);
    return (T)load(keyObject, config);
  }
  
  public <T> T marshallIntoObject(Class<T> clazz, Map<String, AttributeValue> itemAttributes, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    String tableName = getTableName(clazz, config);
    
    return (T)privateMarshallIntoObject(
      toParameters(itemAttributes, clazz, tableName, config));
  }
  
  private <T> T privateMarshallIntoObject(AttributeTransformer.Parameters<T> parameters)
  {
    Class<T> clazz = parameters.getModelClass();
    Map<String, AttributeValue> values = untransformAttributes(parameters);
    
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, parameters.getMapperConfig());
    return (T)model.unconvert(values);
  }
  
  public <T> List<T> marshallIntoObjects(Class<T> clazz, List<Map<String, AttributeValue>> itemAttributes, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    List<T> result = new ArrayList(itemAttributes.size());
    for (Map<String, AttributeValue> item : itemAttributes) {
      result.add(marshallIntoObject(clazz, item));
    }
    return result;
  }
  
  final <T> List<T> marshallIntoObjects(List<AttributeTransformer.Parameters<T>> parameters)
  {
    List<T> result = new ArrayList(parameters.size());
    for (AttributeTransformer.Parameters<T> entry : parameters) {
      result.add(privateMarshallIntoObject(entry));
    }
    return result;
  }
  
  public <T> void save(T object, DynamoDBSaveExpression saveExpression, DynamoDBMapperConfig config)
  {
    DynamoDBMapperConfig finalConfig = mergeConfig(config);
    
    Class<T> clazz = object.getClass();
    String tableName = getTableName(clazz, object, finalConfig);
    
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, finalConfig);
    
    boolean usePut = (finalConfig.getSaveBehavior() == DynamoDBMapperConfig.SaveBehavior.CLOBBER) || (finalConfig.getSaveBehavior() == DynamoDBMapperConfig.SaveBehavior.PUT) || (anyKeyGeneratable(model, object, finalConfig.getSaveBehavior()));
    SaveObjectHandler saveObjectHandler;
    SaveObjectHandler saveObjectHandler;
    if (usePut) {
      saveObjectHandler = new SaveObjectHandler(this, clazz, object, tableName, finalConfig, saveExpression)
      {
        protected void onPrimaryKeyAttributeValue(String attributeName, AttributeValue keyAttributeValue)
        {
          getAttributeValueUpdates().put(attributeName, new AttributeValueUpdate()
            .withValue(keyAttributeValue)
            .withAction("PUT"));
        }
        
        protected void onNullNonKeyAttribute(String attributeName) {}
        
        protected void executeLowLevelRequest()
        {
          doPutItem();
        }
      };
    } else {
      saveObjectHandler = new SaveObjectHandler(this, clazz, object, tableName, finalConfig, saveExpression)
      {
        protected void onPrimaryKeyAttributeValue(String attributeName, AttributeValue keyAttributeValue)
        {
          getPrimaryKeyAttributeValues().put(attributeName, keyAttributeValue);
        }
        
        protected void onNonKeyAttribute(String attributeName, AttributeValue currentValue)
        {
          if ((getLocalSaveBehavior() == DynamoDBMapperConfig.SaveBehavior.APPEND_SET) && (
            (currentValue.getBS() != null) || 
            (currentValue.getNS() != null) || 
            (currentValue.getSS() != null)))
          {
            getAttributeValueUpdates().put(attributeName, new AttributeValueUpdate()
            
              .withValue(currentValue)
              .withAction("ADD"));
            return;
          }
          super.onNonKeyAttribute(attributeName, currentValue);
        }
        
        protected void onNullNonKeyAttribute(String attributeName)
        {
          if ((getLocalSaveBehavior() == DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES) || 
            (getLocalSaveBehavior() == DynamoDBMapperConfig.SaveBehavior.APPEND_SET)) {
            return;
          }
          getAttributeValueUpdates().put(attributeName, new AttributeValueUpdate()
          
            .withAction("DELETE"));
        }
        
        protected void executeLowLevelRequest()
        {
          UpdateItemResult updateItemResult = doUpdateItem();
          if ((updateItemResult.getAttributes() == null) || 
            (updateItemResult.getAttributes().isEmpty()))
          {
            for (String keyAttributeName : getPrimaryKeyAttributeValues().keySet()) {
              getAttributeValueUpdates().put(keyAttributeName, new AttributeValueUpdate()
              
                .withValue((AttributeValue)getPrimaryKeyAttributeValues().get(keyAttributeName))
                .withAction("PUT"));
            }
            doPutItem();
          }
        }
      };
    }
    saveObjectHandler.execute();
  }
  
  protected abstract class SaveObjectHandler
  {
    protected final Object object;
    protected final Class<?> clazz;
    private final String tableName;
    private final DynamoDBMapperConfig saveConfig;
    private final Map<String, AttributeValue> primaryKeys;
    private final Map<String, AttributeValueUpdate> updateValues;
    private final Map<String, ExpectedAttributeValue> internalExpectedValueAssertions;
    protected final Map<String, ExpectedAttributeValue> userProvidedExpectedValueConditions;
    protected final String userProvidedConditionOperator;
    private final List<DynamoDBMapper.ValueUpdate> inMemoryUpdates;
    
    public SaveObjectHandler(Object clazz, String object, DynamoDBMapperConfig tableName, DynamoDBSaveExpression saveConfig)
    {
      this.clazz = clazz;
      this.object = object;
      this.tableName = tableName;
      this.saveConfig = saveConfig;
      if (saveExpression != null)
      {
        userProvidedExpectedValueConditions = saveExpression.getExpected();
        
        userProvidedConditionOperator = saveExpression.getConditionalOperator();
      }
      else
      {
        userProvidedExpectedValueConditions = null;
        userProvidedConditionOperator = null;
      }
      updateValues = new HashMap();
      internalExpectedValueAssertions = new HashMap();
      inMemoryUpdates = new LinkedList();
      primaryKeys = new HashMap();
    }
    
    public void execute()
    {
      DynamoDBMapperTableModel<Object> model = getTableModel(clazz, saveConfig);
      for (DynamoDBMapperFieldModel<Object, Object> field : model.fields()) {
        if (DynamoDBMapper.canGenerate(model, object, getLocalSaveBehavior(), field))
        {
          if ((field.keyType() != null) || (field.indexed())) {
            onAutoGenerateAssignableKey(field);
          } else if (field.versioned()) {
            onVersionAttribute(field);
          } else {
            onAutoGenerate(field);
          }
        }
        else if (field.keyType() != null)
        {
          AttributeValue newAttributeValue = field.convert(field.get(object));
          if (newAttributeValue == null) {
            throw new DynamoDBMappingException(clazz.getSimpleName() + "[" + field.name() + "]; null or empty value for primary key");
          }
          onPrimaryKeyAttributeValue(field.name(), newAttributeValue);
        }
        else
        {
          AttributeValue currentValue = field.convert(field.get(object));
          if (currentValue != null) {
            onNonKeyAttribute(field.name(), currentValue);
          } else {
            onNullNonKeyAttribute(field.name());
          }
        }
      }
      executeLowLevelRequest();
      for (DynamoDBMapper.ValueUpdate update : inMemoryUpdates) {
        update.apply();
      }
    }
    
    protected abstract void onPrimaryKeyAttributeValue(String paramString, AttributeValue paramAttributeValue);
    
    protected void onNonKeyAttribute(String attributeName, AttributeValue currentValue)
    {
      updateValues.put(attributeName, new AttributeValueUpdate()
        .withValue(currentValue).withAction("PUT"));
    }
    
    protected abstract void onNullNonKeyAttribute(String paramString);
    
    protected abstract void executeLowLevelRequest();
    
    protected DynamoDBMapperConfig.SaveBehavior getLocalSaveBehavior()
    {
      return saveConfig.getSaveBehavior();
    }
    
    protected String getTableName()
    {
      return tableName;
    }
    
    protected Map<String, AttributeValue> getPrimaryKeyAttributeValues()
    {
      return primaryKeys;
    }
    
    protected Map<String, AttributeValueUpdate> getAttributeValueUpdates()
    {
      return updateValues;
    }
    
    protected Map<String, ExpectedAttributeValue> mergeExpectedAttributeValueConditions()
    {
      return DynamoDBMapper.mergeExpectedAttributeValueConditions(internalExpectedValueAssertions, userProvidedExpectedValueConditions, userProvidedConditionOperator);
    }
    
    protected List<DynamoDBMapper.ValueUpdate> getInMemoryUpdates()
    {
      return inMemoryUpdates;
    }
    
    protected UpdateItemResult doUpdateItem()
    {
      UpdateItemRequest req = (UpdateItemRequest)new UpdateItemRequest().withTableName(getTableName()).withKey(getPrimaryKeyAttributeValues()).withAttributeUpdates(transformAttributeUpdates(clazz, getTableName(), getPrimaryKeyAttributeValues(), getAttributeValueUpdates(), saveConfig)).withExpected(mergeExpectedAttributeValueConditions()).withConditionalOperator(userProvidedConditionOperator).withReturnValues(ReturnValue.ALL_NEW).withRequestMetricCollector(saveConfig.getRequestMetricCollector());
      
      return db.updateItem((UpdateItemRequest)DynamoDBMapper.applyUserAgent(req));
    }
    
    protected PutItemResult doPutItem()
    {
      Map<String, AttributeValue> attributeValues = convertToItem(getAttributeValueUpdates());
      
      attributeValues = DynamoDBMapper.this.transformAttributes(
        DynamoDBMapper.access$300(DynamoDBMapper.this, attributeValues, clazz, 
        
        getTableName(), saveConfig));
      
      PutItemRequest req = (PutItemRequest)new PutItemRequest().withTableName(getTableName()).withItem(attributeValues).withExpected(mergeExpectedAttributeValueConditions()).withConditionalOperator(userProvidedConditionOperator).withRequestMetricCollector(saveConfig.getRequestMetricCollector());
      
      return db.putItem((PutItemRequest)DynamoDBMapper.applyUserAgent(req));
    }
    
    private void onAutoGenerate(DynamoDBMapperFieldModel<Object, Object> field)
    {
      AttributeValue value = field.convert(field.generate(field.get(object)));
      updateValues.put(field.name(), new AttributeValueUpdate().withAction("PUT").withValue(value));
      inMemoryUpdates.add(new DynamoDBMapper.ValueUpdate(DynamoDBMapper.this, field, value, object));
    }
    
    private void onAutoGenerateAssignableKey(DynamoDBMapperFieldModel<Object, Object> field)
    {
      onAutoGenerate(field);
      if ((getLocalSaveBehavior() != DynamoDBMapperConfig.SaveBehavior.CLOBBER) && 
        (!internalExpectedValueAssertions.containsKey(field.name())) && 
        (field.getGenerateStrategy() != DynamoDBAutoGenerateStrategy.ALWAYS)) {
        internalExpectedValueAssertions.put(field.name(), new ExpectedAttributeValue()
          .withExists(Boolean.valueOf(false)));
      }
    }
    
    private void onVersionAttribute(DynamoDBMapperFieldModel<Object, Object> field)
    {
      if ((getLocalSaveBehavior() != DynamoDBMapperConfig.SaveBehavior.CLOBBER) && 
        (!internalExpectedValueAssertions.containsKey(field.name())))
      {
        Object current = field.get(object);
        if (current == null) {
          internalExpectedValueAssertions.put(field.name(), new ExpectedAttributeValue()
            .withExists(Boolean.valueOf(false)));
        } else {
          internalExpectedValueAssertions.put(field.name(), new ExpectedAttributeValue()
            .withExists(Boolean.valueOf(true)).withValue(field.convert(current)));
        }
      }
      onAutoGenerate(field);
    }
    
    private Map<String, AttributeValue> convertToItem(Map<String, AttributeValueUpdate> putValues)
    {
      Map<String, AttributeValue> map = new HashMap();
      for (Map.Entry<String, AttributeValueUpdate> entry : putValues.entrySet())
      {
        String attributeName = (String)entry.getKey();
        AttributeValue attributeValue = ((AttributeValueUpdate)entry.getValue()).getValue();
        String attributeAction = ((AttributeValueUpdate)entry.getValue()).getAction();
        if ((attributeValue != null) && 
          (!AttributeAction.DELETE.toString().equals(attributeAction))) {
          map.put(attributeName, attributeValue);
        }
      }
      return map;
    }
    
    private Map<String, AttributeValueUpdate> transformAttributeUpdates(Class<?> clazz, String tableName, Map<String, AttributeValue> keys, Map<String, AttributeValueUpdate> updateValues, DynamoDBMapperConfig config)
    {
      Map<String, AttributeValue> item = convertToItem(updateValues);
      
      HashSet<String> keysAdded = new HashSet();
      for (Map.Entry<String, AttributeValue> e : keys.entrySet()) {
        if (!item.containsKey(e.getKey()))
        {
          keysAdded.add(e.getKey());
          item.put(e.getKey(), e.getValue());
        }
      }
      Object parameters = DynamoDBMapper.this.toParameters(item, true, clazz, tableName, config);
      
      String hashKey = ((AttributeTransformer.Parameters)parameters).getHashKeyName();
      if (!item.containsKey(hashKey)) {
        item.put(hashKey, keys.get(hashKey));
      }
      item = DynamoDBMapper.this.transformAttributes((AttributeTransformer.Parameters)parameters);
      for (Map.Entry<String, AttributeValue> entry : item.entrySet()) {
        if (!keysAdded.contains(entry.getKey()))
        {
          AttributeValueUpdate update = (AttributeValueUpdate)updateValues.get(entry.getKey());
          if (update != null) {
            update.getValue().withB(((AttributeValue)entry.getValue()).getB()).withBS(((AttributeValue)entry.getValue()).getBS()).withN(((AttributeValue)entry.getValue()).getN()).withNS(((AttributeValue)entry.getValue()).getNS()).withS(((AttributeValue)entry.getValue()).getS()).withSS(((AttributeValue)entry.getValue()).getSS()).withM(((AttributeValue)entry.getValue()).getM()).withL(((AttributeValue)entry.getValue()).getL()).withNULL(((AttributeValue)entry.getValue()).getNULL()).withBOOL(((AttributeValue)entry.getValue()).getBOOL());
          } else {
            updateValues.put(entry.getKey(), new AttributeValueUpdate(
              (AttributeValue)entry.getValue(), "PUT"));
          }
        }
      }
      return updateValues;
    }
  }
  
  public <T> void delete(T object, DynamoDBDeleteExpression deleteExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    Class<T> clazz = object.getClass();
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, config);
    
    String tableName = getTableName(clazz, object, config);
    
    Map<String, AttributeValue> key = model.convertKey(object);
    
    Map<String, ExpectedAttributeValue> internalAssertions = new HashMap();
    if ((config.getSaveBehavior() != DynamoDBMapperConfig.SaveBehavior.CLOBBER) && (model.versioned()))
    {
      Iterator localIterator = model.versions().iterator();
      if (localIterator.hasNext())
      {
        DynamoDBMapperFieldModel<T, Object> field = (DynamoDBMapperFieldModel)localIterator.next();
        AttributeValue current = field.getAndConvert(object);
        if (current == null) {
          internalAssertions.put(field.name(), new ExpectedAttributeValue(Boolean.valueOf(false)));
        } else {
          internalAssertions.put(field.name(), new ExpectedAttributeValue(Boolean.valueOf(true)).withValue(current));
        }
      }
    }
    DeleteItemRequest req = (DeleteItemRequest)new DeleteItemRequest().withKey(key).withTableName(tableName).withExpected(internalAssertions).withRequestMetricCollector(config.getRequestMetricCollector());
    if (deleteExpression != null)
    {
      String conditionalExpression = deleteExpression.getConditionExpression();
      if (conditionalExpression != null)
      {
        if ((internalAssertions != null) && (!internalAssertions.isEmpty())) {
          throw new SdkClientException("Condition Expressions cannot be used if a versioned attribute is present");
        }
        req = req.withConditionExpression(conditionalExpression).withExpressionAttributeNames(deleteExpression.getExpressionAttributeNames()).withExpressionAttributeValues(deleteExpression
          .getExpressionAttributeValues());
      }
      req = req.withExpected(mergeExpectedAttributeValueConditions(internalAssertions, deleteExpression.getExpected(), deleteExpression.getConditionalOperator())).withConditionalOperator(deleteExpression
        .getConditionalOperator());
    }
    db.deleteItem((DeleteItemRequest)applyUserAgent(req));
  }
  
  public void transactionWrite(TransactionWriteRequest transactionWriteRequest, DynamoDBMapperConfig config)
  {
    if ((transactionWriteRequest == null) || (isNullOrEmpty(transactionWriteRequest.getTransactionWriteOperations()))) {
      throw new SdkClientException("Input request is null or empty");
    }
    DynamoDBMapperConfig finalConfig = mergeConfig(config);
    
    List<TransactionWriteRequest.TransactionWriteOperation> writeOperations = transactionWriteRequest.getTransactionWriteOperations();
    List<ValueUpdate> inMemoryUpdates = new LinkedList();
    TransactWriteItemsRequest transactWriteItemsRequest = new TransactWriteItemsRequest();
    List<TransactWriteItem> transactWriteItems = new ArrayList();
    
    transactWriteItemsRequest.setClientRequestToken(transactionWriteRequest.getIdempotencyToken());
    for (TransactionWriteRequest.TransactionWriteOperation writeOperation : writeOperations) {
      transactWriteItems.add(generateTransactWriteItem(writeOperation, inMemoryUpdates, finalConfig));
    }
    transactWriteItemsRequest.setTransactItems(transactWriteItems);
    
    db.transactWriteItems((TransactWriteItemsRequest)applyTransactionOperationUserAgent(transactWriteItemsRequest));
    for (ValueUpdate update : inMemoryUpdates) {
      update.apply();
    }
  }
  
  public List<Object> transactionLoad(TransactionLoadRequest transactionLoadRequest, DynamoDBMapperConfig config)
  {
    if ((transactionLoadRequest == null) || (isNullOrEmpty(transactionLoadRequest.getObjectsToLoad()))) {
      return new ArrayList();
    }
    DynamoDBMapperConfig finalConfig = mergeConfig(config);
    
    List<Object> objectsToLoad = transactionLoadRequest.getObjectsToLoad();
    List<DynamoDBTransactionLoadExpression> transactionLoadExpressions = transactionLoadRequest.getObjectLoadExpressions();
    List<TransactGetItem> transactGetItems = new ArrayList();
    List<Class<?>> classList = new ArrayList();
    List<String> tableNameList = new ArrayList();
    for (int i = 0; i < objectsToLoad.size(); i++)
    {
      Object objectToLoad = objectsToLoad.get(i);
      DynamoDBTransactionLoadExpression expressionForLoad = (DynamoDBTransactionLoadExpression)transactionLoadExpressions.get(i);
      Class<Object> clazz = objectToLoad.getClass();
      
      String tableName = getTableName(clazz, objectToLoad, finalConfig);
      tableNameList.add(tableName);
      classList.add(clazz);
      DynamoDBMapperTableModel<Object> model = getTableModel(clazz, finalConfig);
      
      Map<String, AttributeValue> key = model.convertKey(objectToLoad);
      TransactGetItem transactGetItem = new TransactGetItem();
      Get getItem = new Get();
      getItem.setTableName(tableName);
      getItem.setKey(key);
      if (expressionForLoad != null)
      {
        getItem.setExpressionAttributeNames(expressionForLoad.getExpressionAttributeNames());
        getItem.setProjectionExpression(expressionForLoad.getProjectionExpression());
      }
      transactGetItem.setGet(getItem);
      transactGetItems.add(transactGetItem);
    }
    TransactGetItemsRequest transactGetItemsRequest = new TransactGetItemsRequest();
    transactGetItemsRequest.withTransactItems(transactGetItems);
    TransactGetItemsResult transactGetItemsResult = db.transactGetItems((TransactGetItemsRequest)applyTransactionOperationUserAgent(transactGetItemsRequest));
    List<ItemResponse> responseItems = transactGetItemsResult.getResponses();
    
    List<Object> resultObjects = new ArrayList();
    for (int i = 0; i < responseItems.size(); i++) {
      if (((ItemResponse)responseItems.get(i)).getItem() == null) {
        resultObjects.add(null);
      } else {
        resultObjects.add(
          privateMarshallIntoObject(
          toParameters(((ItemResponse)responseItems.get(i)).getItem(), 
          (Class)classList.get(i), 
          (String)tableNameList.get(i), finalConfig)));
      }
    }
    return resultObjects;
  }
  
  public List<FailedBatch> batchWrite(Iterable<? extends Object> objectsToWrite, Iterable<? extends Object> objectsToDelete, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    List<FailedBatch> totalFailedBatches = new LinkedList();
    
    StringListMap<WriteRequest> requestItems = new StringListMap();
    
    List<ValueUpdate> inMemoryUpdates = new LinkedList();
    for (Object toWrite : objectsToWrite)
    {
      Class<Object> clazz = toWrite.getClass();
      String tableName = getTableName(clazz, toWrite, config);
      
      Map<String, AttributeValue> attributeValues = new HashMap();
      
      DynamoDBMapperTableModel<Object> model = getTableModel(clazz, config);
      for (DynamoDBMapperFieldModel<Object, Object> field : model.fields())
      {
        AttributeValue currentValue = null;
        if ((canGenerate(model, toWrite, config.getSaveBehavior(), field)) && (!field.versioned()))
        {
          currentValue = field.convert(field.generate(field.get(toWrite)));
          inMemoryUpdates.add(new ValueUpdate(field, currentValue, toWrite));
        }
        else
        {
          currentValue = field.convert(field.get(toWrite));
        }
        if (currentValue != null) {
          attributeValues.put(field.name(), currentValue);
        }
      }
      if (!requestItems.containsKey(tableName)) {
        requestItems.put(tableName, new LinkedList());
      }
      Object parameters = toParameters(attributeValues, clazz, tableName, config);
      
      requestItems.add(tableName, new WriteRequest(new PutRequest(transformAttributes((AttributeTransformer.Parameters)parameters))));
    }
    for (Object toDelete : objectsToDelete)
    {
      Class<Object> clazz = toDelete.getClass();
      
      String tableName = getTableName(clazz, toDelete, config);
      DynamoDBMapperTableModel<Object> model = getTableModel(clazz, config);
      
      Map<String, AttributeValue> key = model.convertKey(toDelete);
      
      requestItems.add(tableName, new WriteRequest(new DeleteRequest(key)));
    }
    for (StringListMap<WriteRequest> batch : requestItems.subMaps(25, true))
    {
      List<FailedBatch> failedBatches = writeOneBatch(batch, config.getBatchWriteRetryStrategy());
      if (failedBatches != null)
      {
        totalFailedBatches.addAll(failedBatches);
        if (containsThrottlingException(failedBatches)) {
          pause(config.getBatchWriteRetryStrategy().getDelayBeforeRetryUnprocessedItems(
            Collections.unmodifiableMap(batch), 0));
        }
      }
    }
    for (ValueUpdate update : inMemoryUpdates) {
      update.apply();
    }
    return totalFailedBatches;
  }
  
  private List<FailedBatch> writeOneBatch(StringListMap<WriteRequest> batch, DynamoDBMapperConfig.BatchWriteRetryStrategy batchWriteRetryStrategy)
  {
    List<FailedBatch> failedBatches = new LinkedList();
    FailedBatch failedBatch = doBatchWriteItemWithRetry(batch, batchWriteRetryStrategy);
    if (failedBatch != null) {
      if (failedBatch.isRequestEntityTooLarge())
      {
        if (failedBatch.size() == 1) {
          failedBatches.add(failedBatch);
        } else {
          for (StringListMap<WriteRequest> subBatch : batch.subMaps(2, false)) {
            failedBatches.addAll(writeOneBatch(subBatch, batchWriteRetryStrategy));
          }
        }
      }
      else {
        failedBatches.add(failedBatch);
      }
    }
    return failedBatches;
  }
  
  private boolean containsThrottlingException(List<FailedBatch> failedBatches)
  {
    for (FailedBatch failedBatch : failedBatches) {
      if (failedBatch.isThrottling()) {
        return true;
      }
    }
    return false;
  }
  
  private FailedBatch doBatchWriteItemWithRetry(Map<String, List<WriteRequest>> batch, DynamoDBMapperConfig.BatchWriteRetryStrategy batchWriteRetryStrategy)
  {
    BatchWriteItemResult result = null;
    int retries = 0;
    
    int maxRetries = batchWriteRetryStrategy.getMaxRetryOnUnprocessedItems(
      Collections.unmodifiableMap(batch));
    
    FailedBatch failedBatch = null;
    Map<String, List<WriteRequest>> pendingItems = batch;
    for (;;)
    {
      try
      {
        result = db.batchWriteItem((BatchWriteItemRequest)applyBatchOperationUserAgent(new BatchWriteItemRequest()
          .withRequestItems(pendingItems)));
      }
      catch (Exception e)
      {
        failedBatch = new FailedBatch();
        failedBatch.setUnprocessedItems(pendingItems);
        failedBatch.setException(e);
        return failedBatch;
      }
      pendingItems = result.getUnprocessedItems();
      if (pendingItems.size() <= 0) {
        break;
      }
      if ((maxRetries >= 0) && (retries >= maxRetries))
      {
        failedBatch = new FailedBatch();
        failedBatch.setUnprocessedItems(pendingItems);
        failedBatch.setException(null);
        return failedBatch;
      }
      pause(batchWriteRetryStrategy.getDelayBeforeRetryUnprocessedItems(
        Collections.unmodifiableMap(pendingItems), retries));
      retries++;
    }
    return failedBatch;
  }
  
  public Map<String, List<Object>> batchLoad(Iterable<? extends Object> itemsToGet, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    boolean consistentReads = config.getConsistentReads() == DynamoDBMapperConfig.ConsistentReads.CONSISTENT;
    if (itemsToGet == null) {
      return new HashMap();
    }
    Map<String, KeysAndAttributes> requestItems = new HashMap();
    Map<String, Class<?>> classesByTableName = new HashMap();
    Map<String, List<Object>> resultSet = new HashMap();
    int count = 0;
    for (Object keyObject : itemsToGet)
    {
      Class<Object> clazz = keyObject.getClass();
      DynamoDBMapperTableModel model = getTableModel(clazz, config);
      
      String tableName = getTableName(clazz, keyObject, config);
      classesByTableName.put(tableName, clazz);
      if (!requestItems.containsKey(tableName)) {
        requestItems.put(tableName, new KeysAndAttributes()
        
          .withConsistentRead(Boolean.valueOf(consistentReads)).withKeys(new LinkedList()));
      }
      ((KeysAndAttributes)requestItems.get(tableName)).getKeys().add(model.convertKey(keyObject));
      
      count++;
      if (count == 100)
      {
        processBatchGetRequest(classesByTableName, requestItems, resultSet, config);
        requestItems.clear();
        count = 0;
      }
    }
    if (count > 0) {
      processBatchGetRequest(classesByTableName, requestItems, resultSet, config);
    }
    return resultSet;
  }
  
  public Map<String, List<Object>> batchLoad(Map<Class<?>, List<KeyPair>> itemsToGet, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    List<Object> keys = new ArrayList();
    if (itemsToGet != null) {
      for (Class<?> clazz : itemsToGet.keySet()) {
        if (itemsToGet.get(clazz) != null)
        {
          model = getTableModel(clazz, config);
          for (KeyPair keyPair : (List)itemsToGet.get(clazz)) {
            keys.add(model.createKey(keyPair.getHashKey(), keyPair.getRangeKey()));
          }
        }
      }
    }
    DynamoDBMapperTableModel model;
    return batchLoad(keys, config);
  }
  
  private void processBatchGetRequest(Map<String, Class<?>> classesByTableName, Map<String, KeysAndAttributes> requestItems, Map<String, List<Object>> resultSet, DynamoDBMapperConfig config)
  {
    BatchGetItemResult batchGetItemResult = null;
    
    BatchGetItemRequest batchGetItemRequest = (BatchGetItemRequest)new BatchGetItemRequest().withRequestMetricCollector(config.getRequestMetricCollector());
    batchGetItemRequest.setRequestItems(requestItems);
    
    DynamoDBMapperConfig.BatchLoadRetryStrategy batchLoadStrategy = config.getBatchLoadRetryStrategy();
    
    BatchLoadContext batchLoadContext = new BatchLoadContext(batchGetItemRequest);
    
    int retries = 0;
    do
    {
      if (batchGetItemResult != null)
      {
        retries++;
        batchLoadContext.setRetriesAttempted(retries);
        if (!isNullOrEmpty(batchGetItemResult.getUnprocessedKeys()))
        {
          pause(batchLoadStrategy.getDelayBeforeNextRetry(batchLoadContext));
          batchGetItemRequest.setRequestItems(batchGetItemResult
            .getUnprocessedKeys());
        }
      }
      batchGetItemResult = db.batchGetItem(
        (BatchGetItemRequest)applyBatchOperationUserAgent(batchGetItemRequest));
      
      Map<String, List<Map<String, AttributeValue>>> responses = batchGetItemResult.getResponses();
      for (String tableName : responses.keySet())
      {
        List<Object> objects = null;
        if (resultSet.get(tableName) != null) {
          objects = (List)resultSet.get(tableName);
        } else {
          objects = new LinkedList();
        }
        Class<?> clazz = (Class)classesByTableName.get(tableName);
        for (Map<String, AttributeValue> item : (List)responses.get(tableName))
        {
          AttributeTransformer.Parameters<?> parameters = toParameters(item, clazz, tableName, config);
          objects.add(privateMarshallIntoObject(parameters));
        }
        resultSet.put(tableName, objects);
      }
      batchLoadContext.setBatchGetItemResult(batchGetItemResult);
    } while (batchLoadStrategy.shouldRetry(batchLoadContext));
    if (!isNullOrEmpty(batchGetItemResult.getUnprocessedKeys())) {
      throw new BatchGetItemException("The BatchGetItemResult has unprocessed keys after max retry attempts. Catch the BatchGetItemException to get the list of unprocessed keys.", batchGetItemResult.getUnprocessedKeys(), resultSet);
    }
  }
  
  private static <K, V> boolean isNullOrEmpty(Map<K, V> map)
  {
    return (map == null) || (map.isEmpty());
  }
  
  private static <T> boolean isNullOrEmpty(List<T> list)
  {
    return (list == null) || (list.isEmpty());
  }
  
  private static <T> boolean anyKeyGeneratable(DynamoDBMapperTableModel<T> model, T object, DynamoDBMapperConfig.SaveBehavior saveBehavior)
  {
    for (DynamoDBMapperFieldModel<T, Object> field : model.keys()) {
      if (canGenerate(model, object, saveBehavior, field)) {
        return true;
      }
    }
    return false;
  }
  
  private static <T> boolean canGenerate(DynamoDBMapperTableModel<T> model, T object, DynamoDBMapperConfig.SaveBehavior saveBehavior, DynamoDBMapperFieldModel<T, Object> field)
  {
    if (field.getGenerateStrategy() == null) {
      return false;
    }
    if (field.getGenerateStrategy() == DynamoDBAutoGenerateStrategy.ALWAYS) {
      return true;
    }
    if (field.get(object) != null) {
      return false;
    }
    if ((field.keyType() != null) || (field.indexed())) {
      return true;
    }
    if ((saveBehavior == DynamoDBMapperConfig.SaveBehavior.CLOBBER) || (saveBehavior == DynamoDBMapperConfig.SaveBehavior.UPDATE) || (saveBehavior == DynamoDBMapperConfig.SaveBehavior.PUT)) {
      return true;
    }
    if (anyKeyGeneratable(model, object, saveBehavior)) {
      return true;
    }
    return false;
  }
  
  private final class ValueUpdate
  {
    private final DynamoDBMapperFieldModel<Object, Object> field;
    private final AttributeValue newValue;
    private final Object target;
    
    public ValueUpdate(AttributeValue field, Object newValue)
    {
      this.field = field;
      this.newValue = newValue;
      this.target = target;
    }
    
    public void apply()
    {
      field.set(target, field.unconvert(newValue));
    }
  }
  
  public <T> PaginatedScanList<T> scan(Class<T> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    ScanRequest scanRequest = createScanRequestFromExpression(clazz, scanExpression, config);
    
    ScanResult scanResult = db.scan((ScanRequest)applyUserAgent(scanRequest));
    return new PaginatedScanList(this, clazz, db, scanRequest, scanResult, config.getPaginationLoadingStrategy(), config);
  }
  
  public <T> PaginatedParallelScanList<T> parallelScan(Class<T> clazz, DynamoDBScanExpression scanExpression, int totalSegments, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    List<ScanRequest> parallelScanRequests = createParallelScanRequestsFromExpression(clazz, scanExpression, totalSegments, config);
    ParallelScanTask parallelScanTask = new ParallelScanTask(db, parallelScanRequests);
    
    return new PaginatedParallelScanList(this, clazz, db, parallelScanTask, config.getPaginationLoadingStrategy(), config);
  }
  
  public <T> ScanResultPage<T> scanPage(Class<T> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    ScanRequest scanRequest = createScanRequestFromExpression(clazz, scanExpression, config);
    
    ScanResult scanResult = db.scan((ScanRequest)applyUserAgent(scanRequest));
    ScanResultPage<T> result = new ScanResultPage();
    
    List<AttributeTransformer.Parameters<T>> parameters = toParameters(scanResult.getItems(), clazz, scanRequest.getTableName(), config);
    
    result.setResults(marshallIntoObjects(parameters));
    result.setLastEvaluatedKey(scanResult.getLastEvaluatedKey());
    result.setCount(scanResult.getCount());
    result.setScannedCount(scanResult.getScannedCount());
    result.setConsumedCapacity(scanResult.getConsumedCapacity());
    
    return result;
  }
  
  public <T> PaginatedQueryList<T> query(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    QueryRequest queryRequest = createQueryRequestFromExpression(clazz, queryExpression, config);
    
    QueryResult queryResult = db.query((QueryRequest)applyUserAgent(queryRequest));
    return new PaginatedQueryList(this, clazz, db, queryRequest, queryResult, config.getPaginationLoadingStrategy(), config);
  }
  
  public <T> QueryResultPage<T> queryPage(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    QueryRequest queryRequest = createQueryRequestFromExpression(clazz, queryExpression, config);
    
    QueryResult queryResult = db.query((QueryRequest)applyUserAgent(queryRequest));
    QueryResultPage<T> result = new QueryResultPage();
    
    List<AttributeTransformer.Parameters<T>> parameters = toParameters(queryResult.getItems(), clazz, queryRequest.getTableName(), config);
    
    result.setResults(marshallIntoObjects(parameters));
    result.setLastEvaluatedKey(queryResult.getLastEvaluatedKey());
    result.setCount(queryResult.getCount());
    result.setScannedCount(queryResult.getScannedCount());
    result.setConsumedCapacity(queryResult.getConsumedCapacity());
    
    return result;
  }
  
  public int count(Class<?> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    ScanRequest scanRequest = createScanRequestFromExpression(clazz, scanExpression, config);
    scanRequest.setSelect(Select.COUNT);
    
    int count = 0;
    ScanResult scanResult = null;
    do
    {
      scanResult = db.scan((ScanRequest)applyUserAgent(scanRequest));
      count += scanResult.getCount().intValue();
      scanRequest.setExclusiveStartKey(scanResult.getLastEvaluatedKey());
    } while (scanResult.getLastEvaluatedKey() != null);
    return count;
  }
  
  public <T> int count(Class<T> clazz, DynamoDBQueryExpression<T> queryExpression, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    
    QueryRequest queryRequest = createQueryRequestFromExpression(clazz, queryExpression, config);
    queryRequest.setSelect(Select.COUNT);
    
    int count = 0;
    QueryResult queryResult = null;
    do
    {
      queryResult = db.query((QueryRequest)applyUserAgent(queryRequest));
      count += queryResult.getCount().intValue();
      queryRequest.setExclusiveStartKey(queryResult.getLastEvaluatedKey());
    } while (queryResult.getLastEvaluatedKey() != null);
    return count;
  }
  
  private ScanRequest createScanRequestFromExpression(Class<?> clazz, DynamoDBScanExpression scanExpression, DynamoDBMapperConfig config)
  {
    ScanRequest scanRequest = new ScanRequest();
    
    scanRequest.setTableName(getTableName(clazz, config));
    scanRequest.setIndexName(scanExpression.getIndexName());
    scanRequest.setScanFilter(scanExpression.getScanFilter());
    scanRequest.setLimit(scanExpression.getLimit());
    scanRequest.setExclusiveStartKey(scanExpression.getExclusiveStartKey());
    scanRequest.setTotalSegments(scanExpression.getTotalSegments());
    scanRequest.setSegment(scanExpression.getSegment());
    scanRequest.setConditionalOperator(scanExpression.getConditionalOperator());
    scanRequest.setFilterExpression(scanExpression.getFilterExpression());
    scanRequest.setExpressionAttributeNames(scanExpression
      .getExpressionAttributeNames());
    scanRequest.setExpressionAttributeValues(scanExpression
      .getExpressionAttributeValues());
    scanRequest.setRequestMetricCollector(config.getRequestMetricCollector());
    scanRequest.setSelect(scanExpression.getSelect());
    scanRequest.setProjectionExpression(scanExpression.getProjectionExpression());
    scanRequest.setReturnConsumedCapacity(scanExpression.getReturnConsumedCapacity());
    scanRequest.setConsistentRead(scanExpression.isConsistentRead());
    
    return (ScanRequest)applyUserAgent(scanRequest);
  }
  
  private List<ScanRequest> createParallelScanRequestsFromExpression(Class<?> clazz, DynamoDBScanExpression scanExpression, int totalSegments, DynamoDBMapperConfig config)
  {
    if (totalSegments < 1) {
      throw new IllegalArgumentException("Parallel scan should have at least one scan segment.");
    }
    if (scanExpression.getExclusiveStartKey() != null) {
      log.info("The ExclusiveStartKey parameter specified in the DynamoDBScanExpression is ignored, since the individual parallel scan request on each segment is applied on a separate key scope.");
    }
    if ((scanExpression.getSegment() != null) || (scanExpression.getTotalSegments() != null)) {
      log.info("The Segment and TotalSegments parameters specified in the DynamoDBScanExpression are ignored.");
    }
    List<ScanRequest> parallelScanRequests = new LinkedList();
    for (int segment = 0; segment < totalSegments; segment++)
    {
      ScanRequest scanRequest = createScanRequestFromExpression(clazz, scanExpression, config);
      parallelScanRequests.add(scanRequest
        .withSegment(Integer.valueOf(segment)).withTotalSegments(Integer.valueOf(totalSegments))
        .withExclusiveStartKey(null));
    }
    return parallelScanRequests;
  }
  
  protected <T> QueryRequest createQueryRequestFromExpression(Class<T> clazz, DynamoDBQueryExpression<T> xpress, DynamoDBMapperConfig config)
  {
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, config);
    
    QueryRequest req = new QueryRequest();
    req.setConsistentRead(Boolean.valueOf(xpress.isConsistentRead()));
    req.setTableName(getTableName(clazz, xpress.getHashKeyValues(), config));
    req.setIndexName(xpress.getIndexName());
    
    req.setKeyConditionExpression(xpress.getKeyConditionExpression());
    processKeyConditions(req, xpress, model);
    
    req.withScanIndexForward(Boolean.valueOf(xpress.isScanIndexForward()))
      .withLimit(xpress.getLimit())
      .withExclusiveStartKey(xpress.getExclusiveStartKey())
      .withQueryFilter(xpress.getQueryFilter())
      .withConditionalOperator(xpress.getConditionalOperator())
      .withSelect(xpress.getSelect())
      .withProjectionExpression(xpress.getProjectionExpression())
      .withFilterExpression(xpress.getFilterExpression())
      .withExpressionAttributeNames(xpress.getExpressionAttributeNames())
      .withExpressionAttributeValues(xpress.getExpressionAttributeValues())
      .withReturnConsumedCapacity(xpress.getReturnConsumedCapacity())
      .withRequestMetricCollector(config.getRequestMetricCollector());
    
    return (QueryRequest)applyUserAgent(req);
  }
  
  private static <T> void processKeyConditions(QueryRequest queryRequest, DynamoDBQueryExpression<T> expression, DynamoDBMapperTableModel<T> model)
  {
    Map<String, Condition> hashKeyConditions = new LinkedHashMap();
    if (expression.getHashKeyValues() != null) {
      for (DynamoDBMapperFieldModel<T, Object> field : model.fields()) {
        if ((field.keyType() == KeyType.HASH) || (!field.globalSecondaryIndexNames(KeyType.HASH).isEmpty()))
        {
          Object value = field.get(expression.getHashKeyValues());
          if (value != null) {
            hashKeyConditions.put(field.name(), field.eq(value));
          }
        }
      }
    }
    Object rangeKeyConditions = expression.getRangeKeyConditions();
    
    String keyCondExpression = queryRequest.getKeyConditionExpression();
    if (keyCondExpression == null)
    {
      if (isNullOrEmpty(hashKeyConditions)) {
        throw new IllegalArgumentException("Illegal query expression: No hash key condition is found in the query");
      }
    }
    else
    {
      if (!isNullOrEmpty(hashKeyConditions)) {
        throw new IllegalArgumentException("Illegal query expression: Either the hash key conditions or the key condition expression must be specified but not both.");
      }
      if (!isNullOrEmpty((Map)rangeKeyConditions)) {
        throw new IllegalArgumentException("Illegal query expression: The range key conditions can only be specified when the key condition expression is not specified.");
      }
      return;
    }
    if ((rangeKeyConditions != null) && (((Map)rangeKeyConditions).size() > 1)) {
      throw new IllegalArgumentException("Illegal query expression: Conditions on multiple range keys (" + ((Map)rangeKeyConditions).keySet().toString() + ") are found in the query. DynamoDB service only accepts up to ONE range key condition.");
    }
    boolean hasRangeKeyCondition = (rangeKeyConditions != null) && (!((Map)rangeKeyConditions).isEmpty());
    String userProvidedIndexName = queryRequest.getIndexName();
    String primaryHashKeyName = model.hashKey().name();
    
    boolean hasPrimaryHashKeyCondition = false;
    Map<String, Set<String>> annotatedGSIsOnHashKeys = new HashMap();
    String hashKeyNameForThisQuery = null;
    
    boolean hasPrimaryRangeKeyCondition = false;
    Set<String> annotatedLSIsOnRangeKey = new HashSet();
    Set<String> annotatedGSIsOnRangeKey = new HashSet();
    
    String rangeKeyNameForThisQuery = null;
    if (hasRangeKeyCondition)
    {
      for (String rangeKeyName : ((Map)rangeKeyConditions).keySet())
      {
        rangeKeyNameForThisQuery = rangeKeyName;
        
        DynamoDBMapperFieldModel<T, Object> rk = model.field(rangeKeyName);
        if (rk.keyType() == KeyType.RANGE) {
          hasPrimaryRangeKeyCondition = true;
        }
        annotatedLSIsOnRangeKey.addAll(rk.localSecondaryIndexNames());
        annotatedGSIsOnRangeKey.addAll(rk.globalSecondaryIndexNames(KeyType.RANGE));
      }
      if ((!hasPrimaryRangeKeyCondition) && 
        (annotatedLSIsOnRangeKey.isEmpty()) && 
        (annotatedGSIsOnRangeKey.isEmpty())) {
        throw new DynamoDBMappingException("The query contains a condition on a range key (" + rangeKeyNameForThisQuery + ") that is not annotated with either @DynamoDBRangeKey or @DynamoDBIndexRangeKey.");
      }
    }
    boolean userProvidedLSIWithRangeKeyCondition = (userProvidedIndexName != null) && (annotatedLSIsOnRangeKey.contains(userProvidedIndexName));
    if ((userProvidedIndexName != null) && (!hasRangeKeyCondition)) {}
    boolean hashOnlyLSIQuery = model.localSecondaryIndex(userProvidedIndexName) != null;
    boolean userProvidedLSI = (userProvidedLSIWithRangeKeyCondition) || (hashOnlyLSIQuery);
    
    boolean userProvidedGSIWithRangeKeyCondition = (userProvidedIndexName != null) && (annotatedGSIsOnRangeKey.contains(userProvidedIndexName));
    if ((userProvidedIndexName != null) && (!hasRangeKeyCondition)) {}
    boolean hashOnlyGSIQuery = model.globalSecondaryIndex(userProvidedIndexName) != null;
    boolean userProvidedGSI = (userProvidedGSIWithRangeKeyCondition) || (hashOnlyGSIQuery);
    if ((userProvidedLSI) && (userProvidedGSI)) {
      throw new DynamoDBMappingException("Invalid query: Index \"" + userProvidedIndexName + "\" is annotateded as both a LSI and a GSI for attribute.");
    }
    for (String hashKeyName : hashKeyConditions.keySet())
    {
      if (hashKeyName.equals(primaryHashKeyName)) {
        hasPrimaryHashKeyCondition = true;
      }
      hk = model.field(hashKeyName);
      
      Collection<String> annotatedGSINames = hk.globalSecondaryIndexNames(KeyType.HASH);
      annotatedGSIsOnHashKeys.put(hashKeyName, annotatedGSINames == null ? new HashSet() : new HashSet(annotatedGSINames));
      if (userProvidedIndexName != null)
      {
        boolean foundHashKeyConditionValidWithUserProvidedIndex = false;
        if ((userProvidedLSI) && (hashKeyName.equals(primaryHashKeyName))) {
          foundHashKeyConditionValidWithUserProvidedIndex = true;
        } else if ((userProvidedGSI) && (annotatedGSINames != null) && 
          (annotatedGSINames.contains(userProvidedIndexName))) {
          foundHashKeyConditionValidWithUserProvidedIndex = true;
        }
        if (foundHashKeyConditionValidWithUserProvidedIndex)
        {
          if (hashKeyNameForThisQuery != null) {
            throw new IllegalArgumentException("Ambiguous query expression: More than one hash key EQ conditions (" + hashKeyNameForThisQuery + ", " + hashKeyName + ") are applicable to the specified index (" + userProvidedIndexName + "). Please provide only one of them in the query expression.");
          }
          hashKeyNameForThisQuery = hashKeyName;
        }
      }
    }
    DynamoDBMapperFieldModel<T, Object> hk;
    Object keyConditions = new HashMap();
    if (userProvidedIndexName != null)
    {
      if ((hasRangeKeyCondition) && (!userProvidedLSI) && (!userProvidedGSI)) {
        throw new IllegalArgumentException("Illegal query expression: No range key condition is applicable to the specified index (" + userProvidedIndexName + "). ");
      }
      if (hashKeyNameForThisQuery == null) {
        throw new IllegalArgumentException("Illegal query expression: No hash key condition is applicable to the specified index (" + userProvidedIndexName + "). ");
      }
      ((Map)keyConditions).put(hashKeyNameForThisQuery, hashKeyConditions.get(hashKeyNameForThisQuery));
      if (hasRangeKeyCondition) {
        ((Map)keyConditions).putAll((Map)rangeKeyConditions);
      }
    }
    else if (hasRangeKeyCondition)
    {
      String inferredIndexName = null;
      hashKeyNameForThisQuery = null;
      if ((hasPrimaryHashKeyCondition) && (hasPrimaryRangeKeyCondition)) {
        hashKeyNameForThisQuery = primaryHashKeyName;
      } else {
        for (String hashKeyName : annotatedGSIsOnHashKeys.keySet())
        {
          boolean foundValidQueryExpressionWithInferredIndex = false;
          String indexNameInferredByThisHashKey = null;
          if ((hashKeyName.equals(primaryHashKeyName)) && 
            (annotatedLSIsOnRangeKey.size() == 1))
          {
            foundValidQueryExpressionWithInferredIndex = true;
            indexNameInferredByThisHashKey = (String)annotatedLSIsOnRangeKey.iterator().next();
          }
          Set<String> annotatedGSIsOnHashKey = (Set)annotatedGSIsOnHashKeys.get(hashKeyName);
          
          annotatedGSIsOnHashKey.retainAll(annotatedGSIsOnRangeKey);
          if (annotatedGSIsOnHashKey.size() == 1)
          {
            if (foundValidQueryExpressionWithInferredIndex)
            {
              hashKeyNameForThisQuery = hashKeyName;
              inferredIndexName = indexNameInferredByThisHashKey;
            }
            foundValidQueryExpressionWithInferredIndex = true;
            indexNameInferredByThisHashKey = (String)annotatedGSIsOnHashKey.iterator().next();
          }
          if (foundValidQueryExpressionWithInferredIndex)
          {
            if (hashKeyNameForThisQuery != null) {
              throw new IllegalArgumentException("Ambiguous query expression: Found multiple valid queries: (Hash: \"" + hashKeyNameForThisQuery + "\", Range: \"" + rangeKeyNameForThisQuery + "\", Index: \"" + inferredIndexName + "\") and (Hash: \"" + hashKeyName + "\", Range: \"" + rangeKeyNameForThisQuery + "\", Index: \"" + indexNameInferredByThisHashKey + "\").");
            }
            hashKeyNameForThisQuery = hashKeyName;
            inferredIndexName = indexNameInferredByThisHashKey;
          }
        }
      }
      if (hashKeyNameForThisQuery != null)
      {
        ((Map)keyConditions).put(hashKeyNameForThisQuery, hashKeyConditions.get(hashKeyNameForThisQuery));
        ((Map)keyConditions).putAll((Map)rangeKeyConditions);
        queryRequest.setIndexName(inferredIndexName);
      }
      else
      {
        throw new IllegalArgumentException("Illegal query expression: Cannot infer the index name from the query expression.");
      }
    }
    else if (hashKeyConditions.size() > 1)
    {
      if (hasPrimaryHashKeyCondition) {
        ((Map)keyConditions).put(primaryHashKeyName, hashKeyConditions.get(primaryHashKeyName));
      } else {
        throw new IllegalArgumentException("Ambiguous query expression: More than one index hash key EQ conditions (" + hashKeyConditions.keySet() + ") are applicable to the query. Please provide only one of them in the query expression, or specify the appropriate index name.");
      }
    }
    else
    {
      String hashKeyName = (String)annotatedGSIsOnHashKeys.keySet().iterator().next();
      if (!hasPrimaryHashKeyCondition) {
        if (((Set)annotatedGSIsOnHashKeys.get(hashKeyName)).size() == 1)
        {
          queryRequest.setIndexName((String)((Set)annotatedGSIsOnHashKeys.get(hashKeyName)).iterator().next());
        }
        else
        {
          if (((Set)annotatedGSIsOnHashKeys.get(hashKeyName)).size() > 1) {
            throw new IllegalArgumentException("Ambiguous query expression: More than one GSIs (" + annotatedGSIsOnHashKeys.get(hashKeyName) + ") are applicable to the query. Please specify one of them in your query expression.");
          }
          throw new IllegalArgumentException("Illegal query expression: No GSI is found in the @DynamoDBIndexHashKey annotation for attribute \"" + hashKeyName + "\".");
        }
      }
      ((Map)keyConditions).putAll(hashKeyConditions);
    }
    queryRequest.setKeyConditions((Map)keyConditions);
  }
  
  private <T> AttributeTransformer.Parameters<T> toParameters(Map<String, AttributeValue> attributeValues, Class<T> modelClass, String tableName, DynamoDBMapperConfig mapperConfig)
  {
    return toParameters(attributeValues, false, modelClass, tableName, mapperConfig);
  }
  
  private <T> AttributeTransformer.Parameters<T> toParameters(Map<String, AttributeValue> attributeValues, boolean partialUpdate, Class<T> modelClass, String tableName, DynamoDBMapperConfig mapperConfig)
  {
    return new TransformerParameters(
      getTableModel(modelClass, mapperConfig), attributeValues, partialUpdate, modelClass, mapperConfig, tableName);
  }
  
  final <T> List<AttributeTransformer.Parameters<T>> toParameters(List<Map<String, AttributeValue>> attributeValues, Class<T> modelClass, String tableName, DynamoDBMapperConfig mapperConfig)
  {
    if (attributeValues == null) {
      return Collections.emptyList();
    }
    List<AttributeTransformer.Parameters<T>> rval = new ArrayList(attributeValues.size());
    for (Map<String, AttributeValue> item : attributeValues) {
      rval.add(toParameters(item, modelClass, tableName, mapperConfig));
    }
    return rval;
  }
  
  private static class TransformerParameters<T>
    implements AttributeTransformer.Parameters<T>
  {
    private final DynamoDBMapperTableModel<T> model;
    private final Map<String, AttributeValue> attributeValues;
    private final boolean partialUpdate;
    private final Class<T> modelClass;
    private final DynamoDBMapperConfig mapperConfig;
    private final String tableName;
    
    public TransformerParameters(DynamoDBMapperTableModel<T> model, Map<String, AttributeValue> attributeValues, boolean partialUpdate, Class<T> modelClass, DynamoDBMapperConfig mapperConfig, String tableName)
    {
      this.model = model;
      this.attributeValues = 
        Collections.unmodifiableMap(attributeValues);
      this.partialUpdate = partialUpdate;
      this.modelClass = modelClass;
      this.mapperConfig = mapperConfig;
      this.tableName = tableName;
    }
    
    public Map<String, AttributeValue> getAttributeValues()
    {
      return attributeValues;
    }
    
    public boolean isPartialUpdate()
    {
      return partialUpdate;
    }
    
    public Class<T> getModelClass()
    {
      return modelClass;
    }
    
    public DynamoDBMapperConfig getMapperConfig()
    {
      return mapperConfig;
    }
    
    public String getTableName()
    {
      return tableName;
    }
    
    public String getHashKeyName()
    {
      return model.hashKey().name();
    }
    
    public String getRangeKeyName()
    {
      return model.rangeKeyIfExists() == null ? null : model.rangeKey().name();
    }
  }
  
  private Map<String, AttributeValue> untransformAttributes(AttributeTransformer.Parameters<?> parameters)
  {
    if (transformer != null) {
      return transformer.untransform(parameters);
    }
    return parameters.getAttributeValues();
  }
  
  private Map<String, AttributeValue> transformAttributes(AttributeTransformer.Parameters<?> parameters)
  {
    if (transformer != null) {
      return transformer.transform(parameters);
    }
    return parameters.getAttributeValues();
  }
  
  private static Map<String, ExpectedAttributeValue> mergeExpectedAttributeValueConditions(Map<String, ExpectedAttributeValue> internalAssertions, Map<String, ExpectedAttributeValue> userProvidedConditions, String userProvidedConditionOperator)
  {
    if (((internalAssertions == null) || (internalAssertions.isEmpty())) && ((userProvidedConditions == null) || 
      (userProvidedConditions.isEmpty()))) {
      return null;
    }
    if (internalAssertions == null) {
      return new HashMap(userProvidedConditions);
    }
    if (userProvidedConditions == null) {
      return new HashMap(internalAssertions);
    }
    Map<String, ExpectedAttributeValue> mergedExpectedValues = new HashMap(internalAssertions);
    for (String attrName : userProvidedConditions.keySet()) {
      mergedExpectedValues.remove(attrName);
    }
    if ((ConditionalOperator.OR.toString().equals(userProvidedConditionOperator)) && 
      (!mergedExpectedValues.isEmpty())) {
      throw new IllegalArgumentException("Unable to assert the value of the fields " + mergedExpectedValues.keySet() + ", since the expected value conditions cannot be combined with user-specified conditions joined by \"OR\". You can use SaveBehavior.CLOBBER to skip the assertion on these fields.");
    }
    mergedExpectedValues.putAll(userProvidedConditions);
    
    return mergedExpectedValues;
  }
  
  static <X extends AmazonWebServiceRequest> X applyUserAgent(X request)
  {
    request.getRequestClientOptions().appendUserAgent(USER_AGENT);
    return request;
  }
  
  static <X extends AmazonWebServiceRequest> X applyBatchOperationUserAgent(X request)
  {
    request.getRequestClientOptions().appendUserAgent(USER_AGENT_BATCH_OPERATION);
    return request;
  }
  
  static <X extends AmazonWebServiceRequest> X applyTransactionOperationUserAgent(X request)
  {
    request.getRequestClientOptions().appendUserAgent(USER_AGENT_TRANSACTION_OPERATION);
    return request;
  }
  
  public S3ClientCache getS3ClientCache()
  {
    return s3Links.getS3ClientCache();
  }
  
  public S3Link createS3Link(Region s3region, String bucketName, String key)
  {
    return s3Links.createS3Link(s3region, bucketName, key);
  }
  
  public S3Link createS3Link(String s3region, String bucketName, String key)
  {
    return s3Links.createS3Link(s3region, bucketName, key);
  }
  
  public <T> CreateTableRequest generateCreateTableRequest(Class<T> clazz, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    DynamoDBMapperTableModel<T> model = getTableModel(clazz, config);
    
    CreateTableRequest request = new CreateTableRequest();
    request.setTableName(getTableName(clazz, config));
    request.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(model.hashKey().name(), KeyType.HASH) });
    if (model.rangeKeyIfExists() != null) {
      request.withKeySchema(new KeySchemaElement[] { new KeySchemaElement(model.rangeKey().name(), KeyType.RANGE) });
    }
    request.setGlobalSecondaryIndexes(model.globalSecondaryIndexes());
    request.setLocalSecondaryIndexes(model.localSecondaryIndexes());
    for (DynamoDBMapperFieldModel<T, Object> field : model.fields()) {
      if ((field.keyType() != null) || (field.indexed())) {
        request.withAttributeDefinitions(new AttributeDefinition[] {new AttributeDefinition()
          .withAttributeType(ScalarAttributeType.valueOf(field.attributeType().name()))
          .withAttributeName(field.name()) });
      }
    }
    return request;
  }
  
  public <T> DeleteTableRequest generateDeleteTableRequest(Class<T> clazz, DynamoDBMapperConfig config)
  {
    config = mergeConfig(config);
    DeleteTableRequest deleteTableRequest = new DeleteTableRequest();
    deleteTableRequest.setTableName(getTableName(clazz, config));
    return deleteTableRequest;
  }
  
  public <T, H, R> DynamoDBTableMapper<T, H, R> newTableMapper(Class<T> clazz)
  {
    DynamoDBMapperConfig config = mergeConfig(null);
    return new DynamoDBTableMapper(db, this, config, getTableModel(clazz, config));
  }
  
  public static class FailedBatch
  {
    private Map<String, List<WriteRequest>> unprocessedItems;
    private Exception exception;
    
    public void setUnprocessedItems(Map<String, List<WriteRequest>> unprocessedItems)
    {
      this.unprocessedItems = unprocessedItems;
    }
    
    public Map<String, List<WriteRequest>> getUnprocessedItems()
    {
      return unprocessedItems;
    }
    
    public void setException(Exception exception)
    {
      this.exception = exception;
    }
    
    public Exception getException()
    {
      return exception;
    }
    
    private final boolean isRequestEntityTooLarge()
    {
      return ((exception instanceof AmazonServiceException)) && 
        (RetryUtils.isRequestEntityTooLargeException((AmazonServiceException)exception));
    }
    
    private final boolean isThrottling()
    {
      return ((exception instanceof AmazonServiceException)) && 
        (RetryUtils.isThrottlingException((AmazonServiceException)exception));
    }
    
    private final int size()
    {
      int size = 0;
      for (List<WriteRequest> values : unprocessedItems.values()) {
        size += values.size();
      }
      return size;
    }
  }
  
  static final class StringListMap<T>
    extends LinkedHashMap<String, List<T>>
  {
    private static final long serialVersionUID = -1L;
    
    public List<T> getPutIfNotExists(String key)
    {
      List<T> list = (List)get(key);
      if (list == null) {
        put(key, list = new LinkedList());
      }
      return list;
    }
    
    public boolean add(String key, T value)
    {
      return getPutIfNotExists(key).add(value);
    }
    
    public List<StringListMap<T>> subMaps(int size, boolean perMap)
    {
      LinkedList<StringListMap<T>> maps = new LinkedList();
      int index = 0;int count = 0;
      for (Map.Entry<String, List<T>> entry : entrySet()) {
        for (Iterator localIterator2 = ((List)entry.getValue()).iterator(); localIterator2.hasNext(); index = perMap ? count / size : index % size)
        {
          T value = localIterator2.next();
          if (index == maps.size()) {
            maps.add(new StringListMap());
          }
          ((StringListMap)maps.get(index)).add((String)entry.getKey(), value);
          count++;index++;
        }
      }
      return maps;
    }
  }
  
  private static void pause(long delay)
  {
    if (delay <= 0L) {
      return;
    }
    try
    {
      Thread.sleep(delay);
    }
    catch (InterruptedException e)
    {
      Thread.currentThread().interrupt();
      throw new SdkClientException(e.getMessage(), e);
    }
  }
  
  public static final class BatchGetItemException
    extends SdkClientException
  {
    private final Map<String, KeysAndAttributes> unprocessedKeys;
    private final Map<String, List<Object>> responses;
    
    public BatchGetItemException(String message, Map<String, KeysAndAttributes> unprocessedKeys, Map<String, List<Object>> responses)
    {
      super();
      this.unprocessedKeys = unprocessedKeys;
      this.responses = responses;
    }
    
    public Map<String, KeysAndAttributes> getUnprocessedKeys()
    {
      return unprocessedKeys;
    }
    
    public Map<String, List<Object>> getResponses()
    {
      return responses;
    }
  }
  
  private TransactWriteItem generateTransactWriteItem(TransactionWriteRequest.TransactionWriteOperation transactionWriteOperation, List<ValueUpdate> inMemoryUpdates, DynamoDBMapperConfig config)
  {
    Object objectToWrite = transactionWriteOperation.getObject();
    DynamoDBTransactionWriteExpression writeExpression = transactionWriteOperation.getDynamoDBTransactionWriteExpression();
    ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure = transactionWriteOperation.getReturnValuesOnConditionCheckFailure();
    TransactionWriteRequest.TransactionWriteOperationType operationType = transactionWriteOperation.getTransactionWriteOperationType();
    Class<Object> clazz = objectToWrite.getClass();
    String tableName = getTableName(clazz, objectToWrite, config);
    Map<String, AttributeValue> attributeValues = new HashMap();
    DynamoDBMapperTableModel<Object> model = getTableModel(clazz, config);
    VersionAttributeConditionExpressionGenerator versionAttributeConditionExpressionGenerator = new VersionAttributeConditionExpressionGenerator();
    for (DynamoDBMapperFieldModel<Object, Object> field : model.fields())
    {
      AttributeValue currentValue = null;
      if (field.versioned())
      {
        if (writeExpression != null) {
          throw new SdkClientException("A transactional write operation may not also specify a condition expression if a versioned attribute is present on the model of the item.");
        }
        Object fieldValue = field.get(objectToWrite);
        versionAttributeConditionExpressionGenerator
          .appendVersionAttributeToConditionExpression(field, fieldValue);
        
        currentValue = field.convert(field.generate(field.get(objectToWrite)));
        inMemoryUpdates.add(new ValueUpdate(field, currentValue, objectToWrite));
      }
      else if (canGenerate(model, objectToWrite, DynamoDBMapperConfig.SaveBehavior.CLOBBER, field))
      {
        currentValue = field.convert(field.generate(field.get(objectToWrite)));
        inMemoryUpdates.add(new ValueUpdate(field, currentValue, objectToWrite));
      }
      else
      {
        currentValue = field.convert(field.get(objectToWrite));
      }
      if ((currentValue == null) && (field.keyType() != null)) {
        throw new DynamoDBMappingException(clazz.getSimpleName() + "[" + field.name() + "]; null or empty value for primary key");
      }
      if (currentValue != null) {
        attributeValues.put(field.name(), currentValue);
      }
    }
    DynamoDBTransactionWriteExpression versionAttributeConditionExpression = versionAttributeConditionExpressionGenerator.getVersionAttributeConditionExpression();
    if (versionAttributeConditionExpression.getConditionExpression() != null) {
      writeExpression = versionAttributeConditionExpression;
    }
    AttributeTransformer.Parameters<?> parameters = toParameters(attributeValues, clazz, tableName, config);
    Map<String, AttributeValue> attributeValueMap = transformAttributes(parameters);
    
    TransactWriteItem transactWriteItem = new TransactWriteItem();
    switch (operationType)
    {
    case Put: 
      transactWriteItem.setPut(generatePut(tableName, attributeValueMap, returnValuesOnConditionCheckFailure, writeExpression));
      break;
    case Update: 
      transactWriteItem.setUpdate(
        generateUpdate(model, tableName, attributeValueMap, returnValuesOnConditionCheckFailure, writeExpression));
      break;
    case ConditionCheck: 
      transactWriteItem.setConditionCheck(
        generateConditionCheck(model, tableName, objectToWrite, returnValuesOnConditionCheckFailure, writeExpression));
      break;
    case Delete: 
      transactWriteItem.setDelete(
        generateDelete(model, tableName, objectToWrite, returnValuesOnConditionCheckFailure, writeExpression));
      break;
    default: 
      throw new UnsupportedOperationException("Unsupported operationType: " + operationType + " for object: " + model.convertKey(objectToWrite) + " of type: " + clazz);
    }
    return transactWriteItem;
  }
  
  private Put generatePut(String tableName, Map<String, AttributeValue> attributeValueMap, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure, DynamoDBTransactionWriteExpression writeExpression)
  {
    Put put = new Put();
    put.setItem(attributeValueMap);
    put.setTableName(tableName);
    if (returnValuesOnConditionCheckFailure != null) {
      put.setReturnValuesOnConditionCheckFailure(returnValuesOnConditionCheckFailure
        .toString());
    }
    if (writeExpression != null)
    {
      if (writeExpression.getConditionExpression() != null) {
        put.setConditionExpression(writeExpression.getConditionExpression());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeNames())) {
        put.setExpressionAttributeNames(writeExpression.getExpressionAttributeNames());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeValues())) {
        put.setExpressionAttributeValues(writeExpression.getExpressionAttributeValues());
      }
    }
    return put;
  }
  
  private Update generateUpdate(DynamoDBMapperTableModel<Object> model, String tableName, Map<String, AttributeValue> attributeValueMap, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure, DynamoDBTransactionWriteExpression writeExpression)
  {
    Update update = new Update();
    Map<String, String> expressionAttributeNamesMap = new HashMap();
    Map<String, AttributeValue> expressionsAttributeValuesMap = new HashMap();
    if (returnValuesOnConditionCheckFailure != null) {
      update.setReturnValuesOnConditionCheckFailure(returnValuesOnConditionCheckFailure
        .toString());
    }
    if (writeExpression != null)
    {
      if (writeExpression.getConditionExpression() != null) {
        update.setConditionExpression(writeExpression.getConditionExpression());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeNames())) {
        expressionAttributeNamesMap.putAll(writeExpression.getExpressionAttributeNames());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeValues())) {
        expressionsAttributeValuesMap.putAll(writeExpression.getExpressionAttributeValues());
      }
    }
    Map<String, AttributeValue> keyAttributeValueMap = new HashMap();
    Map<String, AttributeValue> nonKeyNonNullAttributeValueMap = new HashMap();
    
    List<String> nullValuedNonKeyAttributeNames = new ArrayList();
    for (DynamoDBMapperFieldModel<Object, Object> field : model.fields()) {
      if (field.keyType() != null) {
        keyAttributeValueMap.put(field.name(), attributeValueMap.get(field.name()));
      } else if (attributeValueMap.get(field.name()) != null) {
        nonKeyNonNullAttributeValueMap.put(field.name(), attributeValueMap.get(field.name()));
      } else {
        nullValuedNonKeyAttributeNames.add(field.name());
      }
    }
    update.setTableName(tableName);
    update.setUpdateExpression(new UpdateExpressionGenerator()
      .generateUpdateExpressionAndUpdateAttributeMaps(expressionAttributeNamesMap, expressionsAttributeValuesMap, nonKeyNonNullAttributeValueMap, nullValuedNonKeyAttributeNames));
    
    update.setKey(keyAttributeValueMap);
    if (expressionAttributeNamesMap.size() > 0) {
      update.setExpressionAttributeNames(expressionAttributeNamesMap);
    }
    if (expressionsAttributeValuesMap.size() > 0) {
      update.setExpressionAttributeValues(expressionsAttributeValuesMap);
    }
    return update;
  }
  
  private ConditionCheck generateConditionCheck(DynamoDBMapperTableModel<Object> model, String tableName, Object objectToConditionCheck, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure, DynamoDBTransactionWriteExpression writeExpression)
  {
    ConditionCheck conditionCheck = new ConditionCheck();
    conditionCheck.setKey(model.convertKey(objectToConditionCheck));
    conditionCheck.setTableName(tableName);
    if (returnValuesOnConditionCheckFailure != null) {
      conditionCheck.setReturnValuesOnConditionCheckFailure(returnValuesOnConditionCheckFailure
        .toString());
    }
    if (writeExpression != null)
    {
      conditionCheck.setConditionExpression(writeExpression.getConditionExpression());
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeNames())) {
        conditionCheck.setExpressionAttributeNames(writeExpression.getExpressionAttributeNames());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeValues())) {
        conditionCheck.setExpressionAttributeValues(writeExpression.getExpressionAttributeValues());
      }
    }
    return conditionCheck;
  }
  
  private Delete generateDelete(DynamoDBMapperTableModel<Object> model, String tableName, Object objectToDelete, ReturnValuesOnConditionCheckFailure returnValuesOnConditionCheckFailure, DynamoDBTransactionWriteExpression writeExpression)
  {
    Delete delete = new Delete();
    delete.setKey(model.convertKey(objectToDelete));
    delete.setTableName(tableName);
    if (returnValuesOnConditionCheckFailure != null) {
      delete.setReturnValuesOnConditionCheckFailure(returnValuesOnConditionCheckFailure
        .toString());
    }
    if (writeExpression != null)
    {
      if (writeExpression.getConditionExpression() != null) {
        delete.setConditionExpression(writeExpression.getConditionExpression());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeNames())) {
        delete.setExpressionAttributeNames(writeExpression.getExpressionAttributeNames());
      }
      if (!isNullOrEmpty(writeExpression.getExpressionAttributeValues())) {
        delete.setExpressionAttributeValues(writeExpression.getExpressionAttributeValues());
      }
    }
    return delete;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */