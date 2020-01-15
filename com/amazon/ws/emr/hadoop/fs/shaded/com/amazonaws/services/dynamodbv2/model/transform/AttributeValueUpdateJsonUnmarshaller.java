package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AttributeValueUpdateJsonUnmarshaller
  implements Unmarshaller<AttributeValueUpdate, JsonUnmarshallerContext>
{
  private static AttributeValueUpdateJsonUnmarshaller instance;
  
  public AttributeValueUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AttributeValueUpdate attributeValueUpdate = new AttributeValueUpdate();
    
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
        if (context.testExpression("Value", targetDepth))
        {
          context.nextToken();
          attributeValueUpdate.setValue(AttributeValueJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Action", targetDepth))
        {
          context.nextToken();
          attributeValueUpdate.setAction((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return attributeValueUpdate;
  }
  
  public static AttributeValueUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttributeValueUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AttributeValueUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */