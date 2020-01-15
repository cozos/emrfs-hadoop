package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

public class AttributeValueJsonUnmarshaller
  implements Unmarshaller<AttributeValue, JsonUnmarshallerContext>
{
  private static AttributeValueJsonUnmarshaller instance;
  
  public AttributeValue unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AttributeValue attributeValue = new AttributeValue();
    
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
        if (context.testExpression("S", targetDepth))
        {
          context.nextToken();
          attributeValue.setS((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("N", targetDepth))
        {
          context.nextToken();
          attributeValue.setN((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("B", targetDepth))
        {
          context.nextToken();
          attributeValue.setB((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("SS", targetDepth))
        {
          context.nextToken();
          attributeValue.setSS(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("NS", targetDepth))
        {
          context.nextToken();
          attributeValue.setNS(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("BS", targetDepth))
        {
          context.nextToken();
          attributeValue.setBS(new ListUnmarshaller(context.getUnmarshaller(ByteBuffer.class)).unmarshall(context));
        }
        if (context.testExpression("M", targetDepth))
        {
          context.nextToken();
          attributeValue.setM(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            getInstance()).unmarshall(context));
        }
        if (context.testExpression("L", targetDepth))
        {
          context.nextToken();
          attributeValue.setL(new ListUnmarshaller(getInstance()).unmarshall(context));
        }
        if (context.testExpression("NULL", targetDepth))
        {
          context.nextToken();
          attributeValue.setNULL((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("BOOL", targetDepth))
        {
          context.nextToken();
          attributeValue.setBOOL((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return attributeValue;
  }
  
  public static AttributeValueJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttributeValueJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AttributeValueJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */