package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableGlobalSecondaryIndexSettingsUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller
  implements Unmarshaller<GlobalTableGlobalSecondaryIndexSettingsUpdate, JsonUnmarshallerContext>
{
  private static GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller instance;
  
  public GlobalTableGlobalSecondaryIndexSettingsUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GlobalTableGlobalSecondaryIndexSettingsUpdate globalTableGlobalSecondaryIndexSettingsUpdate = new GlobalTableGlobalSecondaryIndexSettingsUpdate();
    
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
          globalTableGlobalSecondaryIndexSettingsUpdate.setIndexName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedWriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          globalTableGlobalSecondaryIndexSettingsUpdate.setProvisionedWriteCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedWriteCapacityAutoScalingSettingsUpdate", targetDepth))
        {
          context.nextToken();
          globalTableGlobalSecondaryIndexSettingsUpdate
            .setProvisionedWriteCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdateJsonUnmarshaller.getInstance().unmarshall(context));
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
    return globalTableGlobalSecondaryIndexSettingsUpdate;
  }
  
  public static GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */