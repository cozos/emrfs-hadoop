package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Expected;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.PutItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PutItemResult;
import java.util.Map;

public class PutItemImpl
  extends AbstractImpl
  implements PutItemApi
{
  public PutItemImpl(AmazonDynamoDB client, Table table)
  {
    super(client, table);
  }
  
  public PutItemOutcome putItem(Item item)
  {
    return doPutItem(new PutItemSpec().withItem(item));
  }
  
  public PutItemOutcome putItem(Item item, Expected... expected)
  {
    return doPutItem(new PutItemSpec()
      .withItem(item)
      .withExpected(expected));
  }
  
  public PutItemOutcome putItem(Item item, String conditionExpression, Map<String, String> nameMap, Map<String, Object> valueMap)
  {
    return doPutItem(new PutItemSpec()
      .withItem(item)
      .withConditionExpression(conditionExpression)
      .withNameMap(nameMap)
      .withValueMap(valueMap));
  }
  
  public PutItemOutcome putItem(PutItemSpec spec)
  {
    return doPutItem(spec);
  }
  
  private PutItemOutcome doPutItem(PutItemSpec spec)
  {
    String tableName = getTable().getTableName();
    PutItemRequest req = ((PutItemRequest)spec.getRequest()).withTableName(tableName);
    
    Item item = spec.getItem();
    Map<String, AttributeValue> attributes = InternalUtils.toAttributeValues(item);
    
    Map<String, ExpectedAttributeValue> expectedMap = InternalUtils.toExpectedAttributeValueMap(spec.getExpected());
    
    Map<String, AttributeValue> attrValMap = InternalUtils.fromSimpleMap(spec.getValueMap());
    
    req.withItem(attributes)
      .withExpected(expectedMap)
      .withExpressionAttributeNames(spec.getNameMap())
      .withExpressionAttributeValues(attrValMap);
    
    PutItemResult result = getClient().putItem(req);
    return new PutItemOutcome(result);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.PutItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */