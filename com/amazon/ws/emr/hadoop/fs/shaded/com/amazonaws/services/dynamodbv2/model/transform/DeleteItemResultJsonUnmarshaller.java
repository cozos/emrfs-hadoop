package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DeleteItemResultJsonUnmarshaller
  implements Unmarshaller<DeleteItemResult, JsonUnmarshallerContext>
{
  private static DeleteItemResultJsonUnmarshaller instance;
  
  public DeleteItemResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DeleteItemResult deleteItemResult = new DeleteItemResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return deleteItemResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Attributes", targetDepth))
        {
          context.nextToken();
          deleteItemResult.setAttributes(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          deleteItemResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ItemCollectionMetrics", targetDepth))
        {
          context.nextToken();
          deleteItemResult.setItemCollectionMetrics(ItemCollectionMetricsJsonUnmarshaller.getInstance().unmarshall(context));
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
    return deleteItemResult;
  }
  
  public static DeleteItemResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteItemResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DeleteItemResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */