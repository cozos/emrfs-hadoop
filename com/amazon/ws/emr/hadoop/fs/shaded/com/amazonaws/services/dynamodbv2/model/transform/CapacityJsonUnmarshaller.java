package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Capacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CapacityJsonUnmarshaller
  implements Unmarshaller<Capacity, JsonUnmarshallerContext>
{
  private static CapacityJsonUnmarshaller instance;
  
  public Capacity unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Capacity capacity = new Capacity();
    
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
        if (context.testExpression("ReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          capacity.setReadCapacityUnits((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("WriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          capacity.setWriteCapacityUnits((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("CapacityUnits", targetDepth))
        {
          context.nextToken();
          capacity.setCapacityUnits((Double)context.getUnmarshaller(Double.class).unmarshall(context));
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
    return capacity;
  }
  
  public static CapacityJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CapacityJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.CapacityJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */