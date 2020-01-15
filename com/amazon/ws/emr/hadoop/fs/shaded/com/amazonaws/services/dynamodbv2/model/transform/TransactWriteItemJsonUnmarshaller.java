package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TransactWriteItem;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TransactWriteItemJsonUnmarshaller
  implements Unmarshaller<TransactWriteItem, JsonUnmarshallerContext>
{
  private static TransactWriteItemJsonUnmarshaller instance;
  
  public TransactWriteItem unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TransactWriteItem transactWriteItem = new TransactWriteItem();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ConditionCheck", targetDepth))
        {
          context.nextToken();
          transactWriteItem.setConditionCheck(ConditionCheckJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Put", targetDepth))
        {
          context.nextToken();
          transactWriteItem.setPut(PutJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Delete", targetDepth))
        {
          context.nextToken();
          transactWriteItem.setDelete(DeleteJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Update", targetDepth))
        {
          context.nextToken();
          transactWriteItem.setUpdate(UpdateJsonUnmarshaller.getInstance().unmarshall(context));
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
    return transactWriteItem;
  }
  
  public static TransactWriteItemJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TransactWriteItemJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TransactWriteItemJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */