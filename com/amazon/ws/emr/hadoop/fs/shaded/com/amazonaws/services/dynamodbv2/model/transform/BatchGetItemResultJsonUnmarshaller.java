package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BatchGetItemResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BatchGetItemResultJsonUnmarshaller
  implements Unmarshaller<BatchGetItemResult, JsonUnmarshallerContext>
{
  private static BatchGetItemResultJsonUnmarshaller instance;
  
  public BatchGetItemResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BatchGetItemResult batchGetItemResult = new BatchGetItemResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return batchGetItemResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Responses", targetDepth))
        {
          context.nextToken();
          batchGetItemResult.setResponses(new MapUnmarshaller(context
            .getUnmarshaller(String.class), new ListUnmarshaller(new MapUnmarshaller(context
            .getUnmarshaller(String.class), AttributeValueJsonUnmarshaller.getInstance())))
            .unmarshall(context));
        }
        if (context.testExpression("UnprocessedKeys", targetDepth))
        {
          context.nextToken();
          batchGetItemResult.setUnprocessedKeys(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            KeysAndAttributesJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          batchGetItemResult.setConsumedCapacity(new ListUnmarshaller(ConsumedCapacityJsonUnmarshaller.getInstance())
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
    return batchGetItemResult;
  }
  
  public static BatchGetItemResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BatchGetItemResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BatchGetItemResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */