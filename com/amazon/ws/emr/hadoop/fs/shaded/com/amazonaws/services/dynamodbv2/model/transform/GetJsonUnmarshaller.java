package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Get;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GetJsonUnmarshaller
  implements Unmarshaller<Get, JsonUnmarshallerContext>
{
  private static GetJsonUnmarshaller instance;
  
  public Get unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Get get = new Get();
    
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
        if (context.testExpression("Key", targetDepth))
        {
          context.nextToken();
          get.setKey(new MapUnmarshaller(context.getUnmarshaller(String.class), AttributeValueJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          get.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ProjectionExpression", targetDepth))
        {
          context.nextToken();
          get.setProjectionExpression((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeNames", targetDepth))
        {
          context.nextToken();
          get.setExpressionAttributeNames(new MapUnmarshaller(context.getUnmarshaller(String.class), context
            .getUnmarshaller(String.class)).unmarshall(context));
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
    return get;
  }
  
  public static GetJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GetJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */