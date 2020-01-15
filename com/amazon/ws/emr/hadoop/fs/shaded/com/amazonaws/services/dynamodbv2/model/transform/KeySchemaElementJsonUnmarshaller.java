package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class KeySchemaElementJsonUnmarshaller
  implements Unmarshaller<KeySchemaElement, JsonUnmarshallerContext>
{
  private static KeySchemaElementJsonUnmarshaller instance;
  
  public KeySchemaElement unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    KeySchemaElement keySchemaElement = new KeySchemaElement();
    
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
        if (context.testExpression("AttributeName", targetDepth))
        {
          context.nextToken();
          keySchemaElement.setAttributeName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeyType", targetDepth))
        {
          context.nextToken();
          keySchemaElement.setKeyType((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return keySchemaElement;
  }
  
  public static KeySchemaElementJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new KeySchemaElementJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.KeySchemaElementJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */