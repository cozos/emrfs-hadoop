package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaGlobalSecondaryIndexSettingsDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller
  implements Unmarshaller<ReplicaGlobalSecondaryIndexSettingsDescription, JsonUnmarshallerContext>
{
  private static ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller instance;
  
  public ReplicaGlobalSecondaryIndexSettingsDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ReplicaGlobalSecondaryIndexSettingsDescription replicaGlobalSecondaryIndexSettingsDescription = new ReplicaGlobalSecondaryIndexSettingsDescription();
    
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
          replicaGlobalSecondaryIndexSettingsDescription.setIndexName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("IndexStatus", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsDescription.setIndexStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsDescription.setProvisionedReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedReadCapacityAutoScalingSettings", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsDescription.setProvisionedReadCapacityAutoScalingSettings(
            AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ProvisionedWriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsDescription.setProvisionedWriteCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedWriteCapacityAutoScalingSettings", targetDepth))
        {
          context.nextToken();
          replicaGlobalSecondaryIndexSettingsDescription
            .setProvisionedWriteCapacityAutoScalingSettings(AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return replicaGlobalSecondaryIndexSettingsDescription;
  }
  
  public static ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */