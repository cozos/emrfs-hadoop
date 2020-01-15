package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import java.util.Map;

class DynamoDBMapper$1
  extends DynamoDBMapper.SaveObjectHandler
{
  DynamoDBMapper$1(DynamoDBMapper this$0, DynamoDBMapper x0, Class clazz, Object object, String tableName, DynamoDBMapperConfig saveConfig, DynamoDBSaveExpression saveExpression)
  {
    super(tmp7_6, clazz, object, tableName, saveConfig, saveExpression);
  }
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */