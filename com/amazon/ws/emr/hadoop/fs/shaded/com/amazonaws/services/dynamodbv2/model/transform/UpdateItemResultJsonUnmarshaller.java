package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class UpdateItemResultJsonUnmarshaller
  implements Unmarshaller<UpdateItemResult, JsonUnmarshallerContext>
{
  private static UpdateItemResultJsonUnmarshaller instance;
  
  public UpdateItemResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateItemResult updateItemResult = new UpdateItemResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return updateItemResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Attributes", targetDepth))
        {
          context.nextToken();
          updateItemResult.setAttributes(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          updateItemResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ItemCollectionMetrics", targetDepth))
        {
          context.nextToken();
          updateItemResult.setItemCollectionMetrics(ItemCollectionMetricsJsonUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else
      {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return updateItemResult;
  }
  
  public static UpdateItemResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateItemResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateItemResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */