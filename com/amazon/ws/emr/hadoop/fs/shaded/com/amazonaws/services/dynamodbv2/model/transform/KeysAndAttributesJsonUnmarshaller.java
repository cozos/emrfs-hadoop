package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeysAndAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class KeysAndAttributesJsonUnmarshaller
  implements Unmarshaller<KeysAndAttributes, JsonUnmarshallerContext>
{
  private static KeysAndAttributesJsonUnmarshaller instance;
  
  public KeysAndAttributes unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    KeysAndAttributes keysAndAttributes = new KeysAndAttributes();
    
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
        if (context.testExpression("Keys", targetDepth))
        {
          context.nextToken();
          keysAndAttributes.setKeys(new ListUnmarshaller(new MapUnmarshaller(context
            .getUnmarshaller(String.class), AttributeValueJsonUnmarshaller.getInstance())).unmarshall(context));
        }
        if (context.testExpression("AttributesToGet", targetDepth))
        {
          context.nextToken();
          keysAndAttributes.setAttributesToGet(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("ConsistentRead", targetDepth))
        {
          context.nextToken();
          keysAndAttributes.setConsistentRead((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("ProjectionExpression", targetDepth))
        {
          context.nextToken();
          keysAndAttributes.setProjectionExpression((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeNames", targetDepth))
        {
          context.nextToken();
          keysAndAttributes.setExpressionAttributeNames(new MapUnmarshaller(context.getUnmarshaller(String.class), context
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
    return keysAndAttributes;
  }
  
  public static KeysAndAttributesJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new KeysAndAttributesJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.KeysAndAttributesJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */