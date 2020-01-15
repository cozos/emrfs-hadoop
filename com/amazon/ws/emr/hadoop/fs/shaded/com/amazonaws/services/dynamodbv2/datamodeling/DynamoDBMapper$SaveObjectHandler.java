package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class DynamoDBMapper$SaveObjectHandler
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
  
  public DynamoDBMapper$SaveObjectHandler(Class<?> this$0, Object clazz, String object, DynamoDBMapperConfig tableName, DynamoDBSaveExpression saveConfig)
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
    DynamoDBMapperTableModel<Object> model = this$0.getTableModel(clazz, saveConfig);
    for (DynamoDBMapperFieldModel<Object, Object> field : model.fields()) {
      if (DynamoDBMapper.access$000(model, object, getLocalSaveBehavior(), field))
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
    return DynamoDBMapper.access$100(internalExpectedValueAssertions, userProvidedExpectedValueConditions, userProvidedConditionOperator);
  }
  
  protected List<DynamoDBMapper.ValueUpdate> getInMemoryUpdates()
  {
    return inMemoryUpdates;
  }
  
  protected UpdateItemResult doUpdateItem()
  {
    UpdateItemRequest req = (UpdateItemRequest)new UpdateItemRequest().withTableName(getTableName()).withKey(getPrimaryKeyAttributeValues()).withAttributeUpdates(transformAttributeUpdates(clazz, getTableName(), getPrimaryKeyAttributeValues(), getAttributeValueUpdates(), saveConfig)).withExpected(mergeExpectedAttributeValueConditions()).withConditionalOperator(userProvidedConditionOperator).withReturnValues(ReturnValue.ALL_NEW).withRequestMetricCollector(saveConfig.getRequestMetricCollector());
    
    return DynamoDBMapper.access$200(this$0).updateItem((UpdateItemRequest)DynamoDBMapper.applyUserAgent(req));
  }
  
  protected PutItemResult doPutItem()
  {
    Map<String, AttributeValue> attributeValues = convertToItem(getAttributeValueUpdates());
    
    attributeValues = DynamoDBMapper.access$400(this$0, 
      DynamoDBMapper.access$300(this$0, attributeValues, clazz, 
      
      getTableName(), saveConfig));
    
    PutItemRequest req = (PutItemRequest)new PutItemRequest().withTableName(getTableName()).withItem(attributeValues).withExpected(mergeExpectedAttributeValueConditions()).withConditionalOperator(userProvidedConditionOperator).withRequestMetricCollector(saveConfig.getRequestMetricCollector());
    
    return DynamoDBMapper.access$200(this$0).putItem((PutItemRequest)DynamoDBMapper.applyUserAgent(req));
  }
  
  private void onAutoGenerate(DynamoDBMapperFieldModel<Object, Object> field)
  {
    AttributeValue value = field.convert(field.generate(field.get(object)));
    updateValues.put(field.name(), new AttributeValueUpdate().withAction("PUT").withValue(value));
    inMemoryUpdates.add(new DynamoDBMapper.ValueUpdate(this$0, field, value, object));
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
    Object parameters = DynamoDBMapper.access$500(this$0, item, true, clazz, tableName, config);
    
    String hashKey = ((AttributeTransformer.Parameters)parameters).getHashKeyName();
    if (!item.containsKey(hashKey)) {
      item.put(hashKey, keys.get(hashKey));
    }
    item = DynamoDBMapper.access$400(this$0, (AttributeTransformer.Parameters)parameters);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.SaveObjectHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */