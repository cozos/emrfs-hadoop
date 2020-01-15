package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalSecondaryIndexUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GlobalSecondaryIndexUpdateJsonUnmarshaller
  implements Unmarshaller<GlobalSecondaryIndexUpdate, JsonUnmarshallerContext>
{
  private static GlobalSecondaryIndexUpdateJsonUnmarshaller instance;
  
  public GlobalSecondaryIndexUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GlobalSecondaryIndexUpdate globalSecondaryIndexUpdate = new GlobalSecondaryIndexUpdate();
    
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
        if (context.testExpression("Update", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexUpdate.setUpdate(UpdateGlobalSecondaryIndexActionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Create", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexUpdate.setCreate(CreateGlobalSecondaryIndexActionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Delete", targetDepth))
        {
          context.nextToken();
          globalSecondaryIndexUpdate.setDelete(DeleteGlobalSecondaryIndexActionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return globalSecondaryIndexUpdate;
  }
  
  public static GlobalSecondaryIndexUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GlobalSecondaryIndexUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalSecondaryIndexUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */