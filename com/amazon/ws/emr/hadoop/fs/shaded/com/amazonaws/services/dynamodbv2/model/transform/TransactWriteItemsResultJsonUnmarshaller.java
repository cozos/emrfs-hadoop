package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TransactWriteItemsResultJsonUnmarshaller
  implements Unmarshaller<TransactWriteItemsResult, JsonUnmarshallerContext>
{
  private static TransactWriteItemsResultJsonUnmarshaller instance;
  
  public TransactWriteItemsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TransactWriteItemsResult transactWriteItemsResult = new TransactWriteItemsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return transactWriteItemsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          transactWriteItemsResult.setConsumedCapacity(new ListUnmarshaller(ConsumedCapacityJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("ItemCollectionMetrics", targetDepth))
        {
          context.nextToken();
          transactWriteItemsResult.setItemCollectionMetrics(new MapUnmarshaller(context
            .getUnmarshaller(String.class), new ListUnmarshaller(ItemCollectionMetricsJsonUnmarshaller.getInstance()))
            .unmarshall(context));
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
    return transactWriteItemsResult;
  }
  
  public static TransactWriteItemsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TransactWriteItemsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactWriteItemsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */