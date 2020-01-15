package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingTargetTrackingScalingPolicyConfigurationUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller
  implements Unmarshaller<AutoScalingTargetTrackingScalingPolicyConfigurationUpdate, JsonUnmarshallerContext>
{
  private static AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller instance;
  
  public AutoScalingTargetTrackingScalingPolicyConfigurationUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingTargetTrackingScalingPolicyConfigurationUpdate autoScalingTargetTrackingScalingPolicyConfigurationUpdate = new AutoScalingTargetTrackingScalingPolicyConfigurationUpdate();
    
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
        if (context.testExpression("DisableScaleIn", targetDepth))
        {
          context.nextToken();
          autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setDisableScaleIn((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("ScaleInCooldown", targetDepth))
        {
          context.nextToken();
          autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setScaleInCooldown((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("ScaleOutCooldown", targetDepth))
        {
          context.nextToken();
          autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setScaleOutCooldown((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("TargetValue", targetDepth))
        {
          context.nextToken();
          autoScalingTargetTrackingScalingPolicyConfigurationUpdate.setTargetValue((Double)context.getUnmarshaller(Double.class).unmarshall(context));
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
    return autoScalingTargetTrackingScalingPolicyConfigurationUpdate;
  }
  
  public static AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */