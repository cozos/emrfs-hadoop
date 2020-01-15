package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.LocalSecondaryIndexInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class LocalSecondaryIndexInfoJsonUnmarshaller
  implements Unmarshaller<LocalSecondaryIndexInfo, JsonUnmarshallerContext>
{
  private static LocalSecondaryIndexInfoJsonUnmarshaller instance;
  
  public LocalSecondaryIndexInfo unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    LocalSecondaryIndexInfo localSecondaryIndexInfo = new LocalSecondaryIndexInfo();
    
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
        if (context.testExpression("IndexName", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexInfo.setIndexName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeySchema", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexInfo.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("Projection", targetDepth))
        {
          context.nextToken();
          localSecondaryIndexInfo.setProjection(ProjectionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return localSecondaryIndexInfo;
  }
  
  public static LocalSecondaryIndexInfoJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new LocalSecondaryIndexInfoJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.LocalSecondaryIndexInfoJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */