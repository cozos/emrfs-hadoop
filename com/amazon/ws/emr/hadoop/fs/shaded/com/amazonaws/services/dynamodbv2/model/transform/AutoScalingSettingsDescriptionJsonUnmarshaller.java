package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingSettingsDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingSettingsDescriptionJsonUnmarshaller
  implements Unmarshaller<AutoScalingSettingsDescription, JsonUnmarshallerContext>
{
  private static AutoScalingSettingsDescriptionJsonUnmarshaller instance;
  
  public AutoScalingSettingsDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingSettingsDescription autoScalingSettingsDescription = new AutoScalingSettingsDescription();
    
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
          autoScalingSettingsDescription.setMinimumUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("MaximumUnits", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsDescription.setMaximumUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingDisabled", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsDescription.setAutoScalingDisabled((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingRoleArn", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsDescription.setAutoScalingRoleArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ScalingPolicies", targetDepth))
        {
          context.nextToken();
          autoScalingSettingsDescription.setScalingPolicies(new ListUnmarshaller(
            AutoScalingPolicyDescriptionJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return autoScalingSettingsDescription;
  }
  
  public static AutoScalingSettingsDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingSettingsDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingSettingsDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */