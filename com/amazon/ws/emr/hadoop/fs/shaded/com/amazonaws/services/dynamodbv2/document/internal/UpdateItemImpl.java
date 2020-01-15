package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.AttributeUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.UpdateItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemRequest;
import java.util.Collection;
import java.util.Map;

public class UpdateItemImpl
  implements UpdateItemApi
{
  private final Table table;
  private final AmazonDynamoDB client;
  
  public UpdateItemImpl(AmazonDynamoDB client, Table table)
  {
    this.client = client;
    this.table = table;
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, AttributeUpdate... attributeUpdates)
  {
    return updateItem(new UpdateItemSpec()
      .withPrimaryKey(primaryKey)
      .withAttributeUpdate(attributeUpdates));
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, Collection<Expected> expected, AttributeUpdate... attributeUpdates)
  {
    return updateItem(new UpdateItemSpec()
      .withPrimaryKey(primaryKey)
      .withExpected(expected)
      .withAttributeUpdate(attributeUpdates));
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, String updateExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItem(new UpdateItemSpec()
      .withPrimaryKey(primaryKey)
      .withUpdateExpression(updateExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public UpdateItemOutcome updateItem(PrimaryKey primaryKey, String updateExpression, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItem(new UpdateItemSpec().withPrimaryKey(primaryKey)
      .withUpdateExpression(updateExpression)
      .withConditionExpression(conditionExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public UpdateItemOutcome updateItem(UpdateItemSpec spec)
  {
    return doUpdateItem(spec);
  }
  
  private UpdateItemOutcome doUpdateItem(UpdateItemSpec spec)
  {
    UpdateItemRequest request = (UpdateItemRequest)spec.getRequest();
    request.setKey(InternalUtils.toAttributeValueMap(spec.getKeyComponents()));
    request.setTableName(table.getTableName());
    Collection<Expected> expected = spec.getExpected();
    
    Map<String, ExpectedAttributeValue> expectedMap = InternalUtils.toExpectedAttributeValueMap(expected);
    request.setExpected(expectedMap);
    request.setAttributeUpdates(
      InternalUtils.toAttributeValueUpdate(spec.getAttributeUpdate()));
    request.setExpressionAttributeNames(spec.getNameMap());
    request.setExpressionAttributeValues(
      InternalUtils.fromSimpleMap(spec.getValueMap()));
    return new UpdateItemOutcome(client.updateItem(request));
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, AttributeUpdate... attributeUpdates)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue), attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, AttributeUpdate... attributeUpdates)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, Collection<Expected> expected, AttributeUpdate... attributeUpdates)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue), expected, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, Collection<Expected> expected, AttributeUpdate... attributeUpdates)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), expected, attributeUpdates);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String updateExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue), updateExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String updateExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), updateExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String updateExpression, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue), updateExpression, conditionExpression, nameMap, valueMap);
  }
  
  public UpdateItemOutcome updateItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String updateExpression, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return updateItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), updateExpression, conditionExpression, nameMap, valueMap);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.UpdateItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */