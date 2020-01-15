package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller
  implements Unmarshaller<ReplicaGlobalSecondaryIndexSettingsUpdate, JsonUnmarshallerContext>
{
  private static ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller instance;
  
  public ReplicaGlobalSecondaryIndexSettingsUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ReplicaGlobalSecondaryIndexSettingsUpdate replicaGlobalSecondaryIndexSettingsUpdate = new ReplicaGlobalSecondaryIndexSettingsUpdate();
    
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
          replicaGlobalSecondaryIndexSettingsUpdate.setIndexName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsUpdate.setProvisionedReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedReadCapacityAutoScalingSettingsUpdate", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsUpdate.setProvisionedReadCapacityAutoScalingSettingsUpdate(
            AutoScalingSettingsUpdateJsonUnmarshaller.getInstance().unmarshall(context));
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
    return replicaGlobalSecondaryIndexSettingsUpdate;
  }
  
  public static ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */