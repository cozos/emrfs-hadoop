package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.DeleteItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.DeleteItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import java.util.Collection;
import java.util.Map;

public class DeleteItemImpl
  extends AbstractImpl
  implements DeleteItemApi
{
  public DeleteItemImpl(AmazonDynamoDB client, Table table)
  {
    super(client, table);
  }
  
  public DeleteItemOutcome deleteItem(KeyAttribute... primaryKeyComponents)
  {
    return doDeleteItem(new DeleteItemSpec()
      .withPrimaryKey(primaryKeyComponents));
  }
  
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKey)
  {
    return doDeleteItem(new DeleteItemSpec()
      .withPrimaryKey(primaryKey));
  }
  
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKeys, Expected... expected)
  {
    return doDeleteItem(new DeleteItemSpec()
      .withPrimaryKey(primaryKeys)
      .withExpected(expected));
  }
  
  public DeleteItemOutcome deleteItem(PrimaryKey primaryKeys, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return doDeleteItem(new DeleteItemSpec()
      .withPrimaryKey(primaryKeys)
      .withConditionExpression(conditionExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public DeleteItemOutcome deleteItem(DeleteItemSpec spec)
  {
    return doDeleteItem(spec);
  }
  
  private DeleteItemOutcome doDeleteItem(DeleteItemSpec spec)
  {
    String tableName = getTable().getTableName();
    
    DeleteItemRequest req = ((DeleteItemRequest)spec.getRequest()).withTableName(tableName).withKey(InternalUtils.toAttributeValueMap(spec.getKeyComponents()));
    
    Collection<Expected> expected = spec.getExpected();
    
    Map<String, ExpectedAttributeValue> expectedMap = InternalUtils.toExpectedAttributeValueMap(expected);
    
    Map<String, AttributeValue> attrValMap = InternalUtils.fromSimpleMap(spec.getValueMap());
    
    req.withExpected(expectedMap)
      .withExpressionAttributeNames(spec.getNameMap())
      .withExpressionAttributeValues(attrValMap);
    
    DeleteItemResult result = getClient().deleteItem(req);
    return new DeleteItemOutcome(result);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue)
  {
    return deleteItem(new PrimaryKey(hashKeyName, hashKeyValue));
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return deleteItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue));
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, Expected... expected)
  {
    return deleteItem(new PrimaryKey(hashKeyName, hashKeyValue), expected);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, Expected... expected)
  {
    return deleteItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), expected);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return deleteItem(new PrimaryKey(hashKeyName, hashKeyValue), conditionExpression, nameMap, valueMap);
  }
  
  public DeleteItemOutcome deleteItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return deleteItem(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), conditionExpression, nameMap, valueMap);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.DeleteItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */