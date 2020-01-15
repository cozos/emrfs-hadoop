package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AttributeDefinitionJsonUnmarshaller
  implements Unmarshaller<AttributeDefinition, JsonUnmarshallerContext>
{
  private static AttributeDefinitionJsonUnmarshaller instance;
  
  public AttributeDefinition unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AttributeDefinition attributeDefinition = new AttributeDefinition();
    
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
          attributeDefinition.setAttributeName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AttributeType", targetDepth))
        {
          context.nextToken();
          attributeDefinition.setAttributeType((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return attributeDefinition;
  }
  
  public static AttributeDefinitionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttributeDefinitionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AttributeDefinitionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */