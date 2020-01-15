package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import java.util.Map;

class DynamoDBMapper$2
  extends DynamoDBMapper.SaveObjectHandler
{
  DynamoDBMapper$2(DynamoDBMapper this$0, DynamoDBMapper x0, Class clazz, Object object, String tableName, DynamoDBMapperConfig saveConfig, DynamoDBSaveExpression saveExpression)
  {
    super(tmp7_6, clazz, object, tableName, saveConfig, saveExpression);
  }
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */