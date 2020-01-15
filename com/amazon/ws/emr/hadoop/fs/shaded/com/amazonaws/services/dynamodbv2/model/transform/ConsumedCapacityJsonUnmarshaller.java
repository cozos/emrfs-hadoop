package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConsumedCapacity;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ConsumedCapacityJsonUnmarshaller
  implements Unmarshaller<ConsumedCapacity, JsonUnmarshallerContext>
{
  private static ConsumedCapacityJsonUnmarshaller instance;
  
  public ConsumedCapacity unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ConsumedCapacity consumedCapacity = new ConsumedCapacity();
    
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
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CapacityUnits", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setCapacityUnits((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("ReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setReadCapacityUnits((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("WriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setWriteCapacityUnits((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("Table", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setTable(CapacityJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("LocalSecondaryIndexes", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setLocalSecondaryIndexes(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            CapacityJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("GlobalSecondaryIndexes", targetDepth))
        {
          context.nextToken();
          consumedCapacity.setGlobalSecondaryIndexes(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            CapacityJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return consumedCapacity;
  }
  
  public static ConsumedCapacityJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ConsumedCapacityJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ConsumedCapacityJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */