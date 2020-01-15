package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaSettingsDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ReplicaSettingsDescriptionJsonUnmarshaller
  implements Unmarshaller<ReplicaSettingsDescription, JsonUnmarshallerContext>
{
  private static ReplicaSettingsDescriptionJsonUnmarshaller instance;
  
  public ReplicaSettingsDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ReplicaSettingsDescription replicaSettingsDescription = new ReplicaSettingsDescription();
    
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
          replicaSettingsDescription.setRegionName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaStatus", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaBillingModeSummary", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaBillingModeSummary(BillingModeSummaryJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ReplicaProvisionedReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaProvisionedReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaProvisionedReadCapacityAutoScalingSettings", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaProvisionedReadCapacityAutoScalingSettings(
            AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ReplicaProvisionedWriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaProvisionedWriteCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaProvisionedWriteCapacityAutoScalingSettings", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaProvisionedWriteCapacityAutoScalingSettings(
            AutoScalingSettingsDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ReplicaGlobalSecondaryIndexSettings", targetDepth))
        {
          context.nextToken();
          replicaSettingsDescription.setReplicaGlobalSecondaryIndexSettings(new ListUnmarshaller(
            ReplicaGlobalSecondaryIndexSettingsDescriptionJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return replicaSettingsDescription;
  }
  
  public static ReplicaSettingsDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReplicaSettingsDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaSettingsDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */