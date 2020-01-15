package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchWriteItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BatchWriteItemResultJsonUnmarshaller
  implements Unmarshaller<BatchWriteItemResult, JsonUnmarshallerContext>
{
  private static BatchWriteItemResultJsonUnmarshaller instance;
  
  public BatchWriteItemResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BatchWriteItemResult batchWriteItemResult = new BatchWriteItemResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return batchWriteItemResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("UnprocessedItems", targetDepth))
        {
          context.nextToken();
          batchWriteItemResult.setUnprocessedItems(new MapUnmarshaller(context.getUnmarshaller(String.class), new ListUnmarshaller(
            WriteRequestJsonUnmarshaller.getInstance())).unmarshall(context));
        }
        if (context.testExpression("ItemCollectionMetrics", targetDepth))
        {
          context.nextToken();
          batchWriteItemResult.setItemCollectionMetrics(new MapUnmarshaller(context
            .getUnmarshaller(String.class), new ListUnmarshaller(ItemCollectionMetricsJsonUnmarshaller.getInstance()))
            .unmarshall(context));
        }
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          batchWriteItemResult.setConsumedCapacity(new ListUnmarshaller(ConsumedCapacityJsonUnmarshaller.getInstance())
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
    return batchWriteItemResult;
  }
  
  public static BatchWriteItemResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BatchWriteItemResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchWriteItemResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */