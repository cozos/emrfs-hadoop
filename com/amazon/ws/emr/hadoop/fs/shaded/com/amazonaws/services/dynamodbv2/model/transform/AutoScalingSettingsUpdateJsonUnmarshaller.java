package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingSettingsUpdateJsonUnmarshaller
  implements Unmarshaller<AutoScalingSettingsUpdate, JsonUnmarshallerContext>
{
  private static AutoScalingSettingsUpdateJsonUnmarshaller instance;
  
  public AutoScalingSettingsUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingSettingsUpdate autoScalingSettingsUpdate = new AutoScalingSettingsUpdate();
    
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
        if (context.testExpression("MinimumUnits", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsUpdate.setMinimumUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("MaximumUnits", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsUpdate.setMaximumUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingDisabled", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsUpdate.setAutoScalingDisabled((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingRoleArn", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsUpdate.setAutoScalingRoleArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ScalingPolicyUpdate", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsUpdate.setScalingPolicyUpdate(AutoScalingPolicyUpdateJsonUnmarshaller.getInstance().unmarshall(context));
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
    return autoScalingSettingsUpdate;
  }
  
  public static AutoScalingSettingsUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingSettingsUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingSettingsUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */