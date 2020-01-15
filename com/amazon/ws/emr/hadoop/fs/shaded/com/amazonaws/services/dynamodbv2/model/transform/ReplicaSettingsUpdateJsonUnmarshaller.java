package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaSettingsUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ReplicaSettingsUpdateJsonUnmarshaller
  implements Unmarshaller<ReplicaSettingsUpdate, JsonUnmarshallerContext>
{
  private static ReplicaSettingsUpdateJsonUnmarshaller instance;
  
  public ReplicaSettingsUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ReplicaSettingsUpdate replicaSettingsUpdate = new ReplicaSettingsUpdate();
    
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
        if (context.testExpression("RegionName", targetDepth))
        {
          context.nextToken();
          replicaSettingsUpdate.setRegionName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaProvisionedReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          replicaSettingsUpdate.setReplicaProvisionedReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaProvisionedReadCapacityAutoScalingSettingsUpdate", targetDepth))
        {
          context.nextToken();
          replicaSettingsUpdate.setReplicaProvisionedReadCapacityAutoScalingSettingsUpdate(AutoScalingSettingsUpdateJsonUnmarshaller.getInstance()
            .unmarshall(context));
        }
        if (context.testExpression("ReplicaGlobalSecondaryIndexSettingsUpdate", targetDepth))
        {
          context.nextToken();
          replicaSettingsUpdate.setReplicaGlobalSecondaryIndexSettingsUpdate(new ListUnmarshaller(
            ReplicaGlobalSecondaryIndexSettingsUpdateJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return replicaSettingsUpdate;
  }
  
  public static ReplicaSettingsUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReplicaSettingsUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaSettingsUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */