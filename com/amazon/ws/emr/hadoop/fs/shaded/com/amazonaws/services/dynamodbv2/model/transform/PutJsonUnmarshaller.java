package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Put;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class PutJsonUnmarshaller
  implements Unmarshaller<Put, JsonUnmarshallerContext>
{
  private static PutJsonUnmarshaller instance;
  
  public Put unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Put put = new Put();
    
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
        if (context.testExpression("Item", targetDepth))
        {
          context.nextToken();
          put.setItem(new MapUnmarshaller(context.getUnmarshaller(String.class), AttributeValueJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          put.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ConditionExpression", targetDepth))
        {
          context.nextToken();
          put.setConditionExpression((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeNames", targetDepth))
        {
          context.nextToken();
          put.setExpressionAttributeNames(new MapUnmarshaller(context.getUnmarshaller(String.class), context
            .getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeValues", targetDepth))
        {
          context.nextToken();
          put.setExpressionAttributeValues(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ReturnValuesOnConditionCheckFailure", targetDepth))
        {
          context.nextToken();
          put.setReturnValuesOnConditionCheckFailure((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return put;
  }
  
  public static PutJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PutJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */