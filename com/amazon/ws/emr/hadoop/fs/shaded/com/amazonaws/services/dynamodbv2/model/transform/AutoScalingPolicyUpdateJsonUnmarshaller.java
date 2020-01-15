package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingPolicyUpdateJsonUnmarshaller
  implements Unmarshaller<AutoScalingPolicyUpdate, JsonUnmarshallerContext>
{
  private static AutoScalingPolicyUpdateJsonUnmarshaller instance;
  
  public AutoScalingPolicyUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingPolicyUpdate autoScalingPolicyUpdate = new AutoScalingPolicyUpdate();
    
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
        if (context.testExpression("PolicyName", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyUpdate.setPolicyName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TargetTrackingScalingPolicyConfiguration", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyUpdate
            .setTargetTrackingScalingPolicyConfiguration(
            AutoScalingTargetTrackingScalingPolicyConfigurationUpdateJsonUnmarshaller.getInstance().unmarshall(context));
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
    return autoScalingPolicyUpdate;
  }
  
  public static AutoScalingPolicyUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingPolicyUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingPolicyUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */