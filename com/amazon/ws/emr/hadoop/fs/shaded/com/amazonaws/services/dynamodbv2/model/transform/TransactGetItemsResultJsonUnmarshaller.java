package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactGetItemsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TransactGetItemsResultJsonUnmarshaller
  implements Unmarshaller<TransactGetItemsResult, JsonUnmarshallerContext>
{
  private static TransactGetItemsResultJsonUnmarshaller instance;
  
  public TransactGetItemsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TransactGetItemsResult transactGetItemsResult = new TransactGetItemsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return transactGetItemsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          transactGetItemsResult.setConsumedCapacity(new ListUnmarshaller(ConsumedCapacityJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("Responses", targetDepth))
        {
          context.nextToken();
          transactGetItemsResult.setResponses(new ListUnmarshaller(ItemResponseJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return transactGetItemsResult;
  }
  
  public static TransactGetItemsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TransactGetItemsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactGetItemsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */