package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.GetItemOutcome;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Item;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.Table;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.api.GetItemApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetItemResult;
import java.util.Map;

public class GetItemImpl
  extends AbstractImpl
  implements GetItemApi
{
  public GetItemImpl(AmazonDynamoDB client, Table table)
  {
    super(client, table);
  }
  
  public GetItemOutcome getItemOutcome(KeyAttribute... primaryKeyComponents)
  {
    return doLoadItem(new GetItemSpec()
      .withPrimaryKey(primaryKeyComponents));
  }
  
  public GetItemOutcome getItemOutcome(PrimaryKey primaryKey)
  {
    return doLoadItem(new GetItemSpec()
      .withPrimaryKey(primaryKey));
  }
  
  public GetItemOutcome getItemOutcome(PrimaryKey primaryKey, String projectionExpression, Map<String, String> nameMap)
  {
    return doLoadItem(new GetItemSpec()
      .withPrimaryKey(primaryKey)
      .withProjectionExpression(projectionExpression)
      .withNameMap(nameMap));
  }
  
  public GetItemOutcome getItemOutcome(GetItemSpec spec)
  {
    return doLoadItem(spec);
  }
  
  public Item getItem(GetItemSpec spec)
  {
    return doLoadItem(spec).getItem();
  }
  
  private GetItemOutcome doLoadItem(GetItemSpec spec)
  {
    String tableName = getTable().getTableName();
    
    GetItemRequest req = ((GetItemRequest)spec.getRequest()).withTableName(tableName).withKey(InternalUtils.toAttributeValueMap(spec.getKeyComponents())).withExpressionAttributeNames(spec.getNameMap());
    
    GetItemResult result = getClient().getItem(req);
    return new GetItemOutcome(result);
  }
  
  public Item getItem(KeyAttribute... primaryKey)
  {
    return getItemOutcome(primaryKey).getItem();
  }
  
  public Item getItem(PrimaryKey primaryKey)
  {
    return getItemOutcome(primaryKey).getItem();
  }
  
  public Item getItem(PrimaryKey primaryKey, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemOutcome(primaryKey, projectionExpression, nameMap).getItem();
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue)
  {
    return getItemOutcome(new KeyAttribute[] { new KeyAttribute(hashKeyName, hashKeyValue) });
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return getItemOutcome(new KeyAttribute[] { new KeyAttribute(hashKeyName, hashKeyValue), new KeyAttribute(rangeKeyName, rangeKeyValue) });
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue)
  {
    return getItemOutcome(hashKeyName, hashKeyValue).getItem();
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue)
  {
    return getItemOutcome(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue).getItem();
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemOutcome(new PrimaryKey(hashKeyName, hashKeyValue), projectionExpression, nameMap);
  }
  
  public GetItemOutcome getItemOutcome(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return getItemOutcome(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), projectionExpression, nameMap);
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return 
      getItemOutcome(new PrimaryKey(hashKeyName, hashKeyValue), projectionExpression, nameMap).getItem();
  }
  
  public Item getItem(String hashKeyName, Object hashKeyValue, String rangeKeyName, Object rangeKeyValue, String projectionExpression, Map<String, String> nameMap)
  {
    return 
    
      getItemOutcome(new PrimaryKey(hashKeyName, hashKeyValue, rangeKeyName, rangeKeyValue), projectionExpression, nameMap).getItem();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.internal.GetItemImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */